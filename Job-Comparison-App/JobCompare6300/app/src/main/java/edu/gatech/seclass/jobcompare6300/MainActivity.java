package edu.gatech.seclass.jobcompare6300;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

import edu.gatech.seclass.jobcompare6300.sqlite.ApplicationContract;

public class MainActivity extends AppCompatActivity {

    // database creation, connection, and version management for the application
    ApplicationContract.ApplicationDbHelper appDbHelper = new ApplicationContract.ApplicationDbHelper(MainActivity.this);
    ArrayList<Long> jobList;

    //Initialize the activity and sets its content view to activity_main:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // When on main activity page
        try {
            // set up the connection to the database for application table:
            SQLiteDatabase appDb = appDbHelper.getWritableDatabase();

            ContentValues appValues = new ContentValues();

            // Set up the initial data for application table:
            appValues.put(ApplicationContract.ApplicationEntry._ID, 1);
            appValues.put(ApplicationContract.ApplicationEntry.COLUMN_NAME_CURRENT_JOB, 1);
            appValues.put(ApplicationContract.ApplicationEntry.COLUMN_NAME_JOB_OFFERS, 1);

            appDb.insert(ApplicationContract.ApplicationEntry.TABLE_NAME, null, appValues);
        } catch (SQLiteConstraintException e) {
            System.out.println("Entry already exists, skipping...");
        }
    }

    // Helper function to retrieve the current job ID:
    @SuppressLint("Range")
    private int getCurrentJobId() {

        //set up the connection and obtain the readable database:
        SQLiteDatabase appDb = appDbHelper.getReadableDatabase();

        //retrieve current job ID from application table:
        String[] appProjection = {
                ApplicationContract.ApplicationEntry.COLUMN_NAME_CURRENT_JOB
        };

        //a query to retrieve the info for the current job row:
        String appSelection = ApplicationContract.ApplicationEntry._ID + " = ?";

        String[] appSelectionArgs = { "1" };

        Cursor appCursor = appDb.query(
                ApplicationContract.ApplicationEntry.TABLE_NAME,
                appProjection,
                appSelection,
                appSelectionArgs,
                null,
                null,
                null
        );
        // point to the first row of the result set:
        appCursor.moveToFirst();
        int currentJobId = appCursor.getInt(appCursor.getColumnIndex(ApplicationContract.ApplicationEntry.COLUMN_NAME_CURRENT_JOB));

        return currentJobId;
    }

    // Retrieve the current job info from database and display in 'EditText' fields!
    @SuppressLint("Range")
    private void setCurrentJobFields(long currentJobId) {

        //Retrieve current job info based on ID
        Job job = new Job(1, this);

        //Display the retrieved info in 'EditText' fields!
        EditText titleEditText = (EditText)findViewById(R.id.titleEditText);
        titleEditText.setText(job.getTitle());

        EditText companyEditText = (EditText)findViewById(R.id.companyEditText);
        companyEditText.setText(job.getCompany());

        EditText locationEditText = (EditText)findViewById(R.id.cityEditText);
        locationEditText.setText(job.getLocation());

        EditText costOfLivingEditText = (EditText)findViewById(R.id.colEditText);
        costOfLivingEditText.setText("" + job.getCostOfLiving());

        EditText yearlySalaryEditText = (EditText)findViewById(R.id.salaryEditText);
        yearlySalaryEditText.setText("" + job.getYearlySalary());

        EditText yearlyBonusEditText = (EditText)findViewById(R.id.yearlyBonusEditText);
        yearlyBonusEditText.setText("" + job.getYearlyBonus());

        EditText gymMembershipEditText = (EditText)findViewById(R.id.gymMembershipEditText);
        gymMembershipEditText.setText("" + job.getGymMembership());

        EditText leaveTimeEditText = (EditText)findViewById(R.id.leaveTimeEditText);
        leaveTimeEditText.setText("" + job.getLeaveTime());

        EditText retirementMatchEditText = (EditText)findViewById(R.id.benefitsEditText);
        retirementMatchEditText.setText("" + job.getF01kMatch());

        EditText petInsuranceEditText = (EditText)findViewById(R.id.petInsuranceEditText);
        petInsuranceEditText.setText(String.valueOf(job.getPetInsurance()));
    }

    public static double scoreJob(Job job, ComparisonSettings cmpSet) {
        double totalWeight = cmpSet.getYearlySalaryWeight() + cmpSet.getYearlyBonusWeight() +
                cmpSet.getGymMembershipWeight() + cmpSet.getRetirementMatchWeight() + cmpSet.getLeaveTimeWeight() +
                cmpSet.getPetInsuranceWeight();
        double jobScore = (cmpSet.getYearlySalaryWeight() / totalWeight) * job.getYearlySalary() +
                (cmpSet.getYearlyBonusWeight() / totalWeight) * job.getYearlyBonus() +
                (cmpSet.getGymMembershipWeight() / totalWeight) * job.getGymMembership() +
                (cmpSet.getLeaveTimeWeight() / totalWeight) * ((double) job.getLeaveTime() * (job.getYearlySalary() / 260)) +
                (cmpSet.getRetirementMatchWeight() / totalWeight) * (job.getYearlySalary() * (job.getF01kMatch() / 100)) +
                (cmpSet.getPetInsuranceWeight() / totalWeight) * job.getPetInsurance();

        return jobScore;
    }

    // collecting information from the user interface, calculating a job score based on certain weightings,
    // and then storing all of this information in a database.
    @SuppressLint("Range")
    private long saveJob() {

        // Retrieve the user input:
        EditText titleEditText = (EditText)findViewById(R.id.titleEditText);
        String title = titleEditText.getText().toString();

        EditText companyEditText = (EditText)findViewById(R.id.companyEditText);
        String company = companyEditText.getText().toString();

        EditText locationEditText = (EditText)findViewById(R.id.cityEditText);
        String location = locationEditText.getText().toString();

        EditText costOfLivingEditText = (EditText)findViewById(R.id.colEditText);
        int costOfLiving = Integer.parseInt(costOfLivingEditText.getText().toString());

        EditText yearlySalaryEditText = (EditText)findViewById(R.id.salaryEditText);
        float yearlySalary = Float.parseFloat(yearlySalaryEditText.getText().toString());

        EditText yearlyBonusEditText = (EditText)findViewById(R.id.yearlyBonusEditText);
        float yearlyBonus = Float.parseFloat(yearlyBonusEditText.getText().toString());

        EditText gymMembershipEditText = (EditText)findViewById(R.id.gymMembershipEditText);
        float gymMembership = Float.parseFloat(gymMembershipEditText.getText().toString());

        EditText leaveTimeEditText = (EditText)findViewById(R.id.leaveTimeEditText);
        int leaveTime = Integer.parseInt(leaveTimeEditText.getText().toString());

        EditText retirementMatchEditText = (EditText)findViewById(R.id.benefitsEditText);
        int retirementMatch = Integer.parseInt(retirementMatchEditText.getText().toString());

        EditText petInsuranceEditText = (EditText)findViewById(R.id.petInsuranceEditText);
        float petInsurance = Float.parseFloat(petInsuranceEditText.getText().toString());

        Job job = new Job(title, company, location, costOfLiving, yearlySalary, yearlyBonus, gymMembership, leaveTime, retirementMatch, petInsurance,this);
        return job.insertJob();
    }

    //  update an existing job entry in the database based on the user inputs from the UI.
    @SuppressLint("Range")
    private long updateJob(long jobId) {

        //Retrieve the user input:
        EditText titleEditText = (EditText)findViewById(R.id.titleEditText);
        String title = titleEditText.getText().toString();

        EditText companyEditText = (EditText)findViewById(R.id.companyEditText);
        String company = companyEditText.getText().toString();

        EditText locationEditText = (EditText)findViewById(R.id.cityEditText);
        String location = locationEditText.getText().toString();

        EditText costOfLivingEditText = (EditText)findViewById(R.id.colEditText);
        int costOfLiving = Integer.parseInt(costOfLivingEditText.getText().toString());

        EditText yearlySalaryEditText = (EditText)findViewById(R.id.salaryEditText);
        float yearlySalary = Float.parseFloat(yearlySalaryEditText.getText().toString());

        EditText yearlyBonusEditText = (EditText)findViewById(R.id.yearlyBonusEditText);
        float yearlyBonus = Float.parseFloat(yearlyBonusEditText.getText().toString());

        EditText gymMembershipEditText = (EditText)findViewById(R.id.gymMembershipEditText);
        float gymMembership = Float.parseFloat(gymMembershipEditText.getText().toString());

        EditText leaveTimeEditText = (EditText)findViewById(R.id.leaveTimeEditText);
        int leaveTime = Integer.parseInt(leaveTimeEditText.getText().toString());

        EditText retirementMatchEditText = (EditText)findViewById(R.id.benefitsEditText);
        int retirementMatch = Integer.parseInt(retirementMatchEditText.getText().toString());

        EditText petInsuranceEditText = (EditText)findViewById(R.id.petInsuranceEditText);
        float petInsurance = Float.parseFloat(petInsuranceEditText.getText().toString());

        //overwrite the job entry based on jobID:
        Job job = new Job(title, company, location, costOfLiving, yearlySalary, yearlyBonus, gymMembership, leaveTime, retirementMatch, petInsurance, this);
        return job.updateJob(jobId);
    }

    // retrieving information about two jobs from the database,
    // formatting the information, and displaying it in a ListView for comparison
    @SuppressLint("Range")
    private void compareJobs(long jobOneId, long jobTwoId) {

        //Initialize listview object:
        ListView jobListView = (ListView) findViewById(R.id.compareTwoJobsListview);

        Job jobOne = new Job(jobOneId, this);
        Job jobTwo = new Job(jobTwoId, this);
        ComparisonSettings cs = new ComparisonSettings(this);

        String jobOneTitle = jobOne.getTitle();
        String jobOneCompany = jobOne.getCompany();
        String jobOneLocation = jobOne.getLocation();
        String jobOneCostOfLiving = String.valueOf(jobOne.getCostOfLiving());
        String jobOneYearlySalary = String.valueOf(jobOne.getYearlySalary());
        String jobOneYearlyBonus = String.valueOf(jobOne.getYearlyBonus());
        String jobOneGymMembership = String.valueOf(jobOne.getGymMembership());
        String jobOneLeaveTime = String.valueOf(jobOne.getLeaveTime());
        String jobOneRetirementMatch = String.valueOf(jobOne.getF01kMatch());
        String jobOnePetInsurance = String.valueOf(jobOne.getPetInsurance());
        String jobOneJobScore = String.valueOf(scoreJob(jobOne, cs));

        String jobTwoTitle = jobTwo.getTitle();
        String jobTwoCompany = jobTwo.getCompany();
        String jobTwoLocation = jobTwo.getLocation();
        String jobTwoCostOfLiving = String.valueOf(jobTwo.getCostOfLiving());
        String jobTwoYearlySalary = String.valueOf(jobTwo.getYearlySalary());
        String jobTwoYearlyBonus = String.valueOf(jobTwo.getYearlyBonus());
        String jobTwoGymMembership = String.valueOf(jobTwo.getGymMembership());
        String jobTwoLeaveTime = String.valueOf(jobTwo.getLeaveTime());
        String jobTwoRetirementMatch = String.valueOf(jobTwo.getF01kMatch());
        String jobTwoPetInsurance = String.valueOf(jobTwo.getPetInsurance());
        String jobTwoJobScore = String.valueOf(scoreJob(jobTwo, cs));

        // prepare display strings:
        String[] jobArray = new String[]{
                "Title: " + jobOneTitle + "\n"
                        + "Company: " + jobOneCompany + "\n"
                        + "Location: " + jobOneLocation + "\n"
                        + "Cost of living: " + jobOneCostOfLiving + "\n"
                        + "Yearly salary: " + jobOneYearlySalary + "\n"
                        + "Yearly bonus: " + jobOneYearlyBonus + "\n"
                        + "Gym membership: " + jobOneGymMembership + "\n"
                        + "Leave time: " + jobOneLeaveTime + "\n"
                        + "401k match: " + jobOneRetirementMatch + "\n"
                        + "Pet insurance: " + jobOnePetInsurance + "\n"
                        + "Job score: " + jobOneJobScore,
                "Title: " + jobTwoTitle + "\n"
                        + "Company: " + jobTwoCompany + "\n"
                        + "Location: " + jobTwoLocation + "\n"
                        + "Cost of living: " + jobTwoCostOfLiving + "\n"
                        + "Yearly salary: " + jobTwoYearlySalary + "\n"
                        + "Yearly bonus: " + jobTwoYearlyBonus + "\n"
                        + "Gym membership: " + jobTwoGymMembership + "\n"
                        + "Leave time: " + jobTwoLeaveTime + "\n"
                        + "401k match: " + jobTwoRetirementMatch + "\n"
                        + "Pet insurance: " + jobTwoPetInsurance + "\n"
                        + "Job score: " + jobTwoJobScore
        };

        ArrayList<String> jobList = new ArrayList<String>();
        jobList.addAll(Arrays.asList(jobArray));

        // Listview adapter setup
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, R.layout.row_layout, jobList);

        // The listAdapter is set as the adapter for the jobListView,
        // which will now display the job comparison data to the user.
        jobListView.setAdapter(listAdapter);
    }


    // For comparison settings, populate the UI fields with data retrieved from the database
    @SuppressLint("Range")
    private void setComparisonSettingsFields() {
        ComparisonSettings cs = new ComparisonSettings(this);

        EditText yearlySalaryEditText = (EditText)findViewById(R.id.salaryCompareEditText);
        yearlySalaryEditText.setText(String.valueOf(cs.getYearlySalaryWeight()));

        EditText yearlyBonusEditText = (EditText)findViewById(R.id.yearlyBonusCompareEditText);
        yearlyBonusEditText.setText(String.valueOf(cs.getYearlyBonusWeight()));

        EditText gymMembershipEditText = (EditText)findViewById(R.id.GymMembershipEditText);
        gymMembershipEditText.setText(String.valueOf(cs.getGymMembershipWeight()));

        EditText retirementMatchEditText = (EditText)findViewById(R.id.benefitCompareEditText);
        retirementMatchEditText.setText(String.valueOf(cs.getRetirementMatchWeight()));

        EditText leaveTimeEditText = (EditText)findViewById(R.id.leaveTimeCompareEditText);
        leaveTimeEditText.setText(String.valueOf(cs.getLeaveTimeWeight()));

        EditText petInsuranceEditText = (EditText)findViewById(R.id.petInsuranceEditText);
        petInsuranceEditText.setText(String.valueOf(cs.getPetInsuranceWeight()));
    }

    // Update the comparison settings in the database with the values provided by UI
    private void saveComparisonSettings() {
        EditText yearlySalaryEditText = (EditText)findViewById(R.id.salaryCompareEditText);
        int yearlySalaryWeight = Integer.parseInt(yearlySalaryEditText.getText().toString());

        EditText yearlyBonusEditText = (EditText)findViewById(R.id.yearlyBonusCompareEditText);
        int yearlyBonusWeight = Integer.parseInt(yearlyBonusEditText.getText().toString());

        EditText gymMembershipEditText = (EditText)findViewById(R.id.GymMembershipEditText);
        int gymMembershipWeight = Integer.parseInt(gymMembershipEditText.getText().toString());

        EditText retirementMatchEditText = (EditText)findViewById(R.id.benefitCompareEditText);
        int retirementMatchWeight = Integer.parseInt(retirementMatchEditText.getText().toString());

        EditText leaveTimeEditText = (EditText)findViewById(R.id.leaveTimeCompareEditText);
        int leaveTimeWeight = Integer.parseInt(leaveTimeEditText.getText().toString());

        EditText petInsuranceEditText = (EditText)findViewById(R.id.petInsuranceEditText);
        int petInsuranceWeight = Integer.parseInt(petInsuranceEditText.getText().toString());

        ComparisonSettings cs = new ComparisonSettings(yearlySalaryWeight, yearlyBonusWeight, gymMembershipWeight, retirementMatchWeight, leaveTimeWeight, petInsuranceWeight, this);
        cs.updateComparisonSettings();
    }

    // set input range validation for 401k match (0-20) and pet insurance (0-5000)
    private void setInputRangeValidation() {
        EditText retirementMatchEditText = (EditText)findViewById(R.id.benefitsEditText);
        retirementMatchEditText.setFilters(new InputFilter[]{new InputRangeValidation(0, 20, this)});
        EditText petInsuranceEditText = (EditText)findViewById(R.id.petInsuranceEditText);
        petInsuranceEditText.setFilters((new InputFilter[]{new InputRangeValidationFloat(0, 5000, this)}));
    }

    // click event on current job button on main menu page:
    public void onCurrentJobClick(View view) {
        setContentView(R.layout.activity_current_job);

        setInputRangeValidation();

        int currentJobId = getCurrentJobId();
        // set up current job fields if we have anything:
        setCurrentJobFields(currentJobId);
    }

    //  click event on add job offer button on main menu page:
    public void onJobOfferClick(View view) {
        setContentView(R.layout.activity_job_offer);

        setInputRangeValidation();
    }

    // handle a user's click event to initiate a job comparison(current job and job offer)
    public void onCompareCurrentJobClick(View view) {
        long jobOneId = saveJob();
        long jobTwoId = 1;

        setContentView(R.layout.activity_compare_currentjob_joboffer);

        compareJobs(jobOneId, jobTwoId);
    }

    // ??
    public void onJobComparisonClick(View view) {
        setContentView(R.layout.activity_job_comparison_settings);

        setComparisonSettingsFields();
    }

    // click event to save comparison settings:
    public void onSaveComparisonSettings(View view) {
        saveComparisonSettings();

        setContentView(R.layout.activity_main);
    }

    // A click event where users can select and compare different job offers.
    @SuppressLint("Range")
    public void onJobComparerClick(View view) {
        setContentView(R.layout.activity_job_comparer);
        Button compareOffersButton = (Button) findViewById(R.id.compareTwoJobButton);
        compareOffersButton.setEnabled(false);
        ListView jobsListView = (ListView) findViewById(R.id.jobCompareListView);
        jobsListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        JobCursorAdapter jobCursorAdapter = Job.getJobList(this);

        jobsListView.setAdapter(jobCursorAdapter);

        ArrayList<CheckBox> checkedBoxes = new ArrayList<>();
        jobList = new ArrayList<>();

        jobsListView.setOnItemClickListener((adapterView, view1, i, l) -> {
            CheckBox checkbox = (CheckBox) view1.findViewById(R.id.CheckBox);
            if (checkbox.isChecked()) {
                checkbox.setChecked(false);
                checkedBoxes.remove(checkbox);
                jobList.remove(l);
            } else {
                checkbox.setChecked(true);
                checkedBoxes.add(checkbox);
                jobList.add(l);
            }
            if (checkedBoxes.size() < 2 || checkedBoxes.size() > 2) {
                compareOffersButton.setEnabled(false);
            } else {
                compareOffersButton.setEnabled(true);
            }
        });
    }

    // Back to main menu when triggering back button.
    public void onBackClick(View view) {
        setContentView(R.layout.activity_main);
    }

    // Save job offer info and back to main menu:
    public void onSaveJobOfferClick(View view) {
        saveJob();

        setContentView(R.layout.activity_main);
    }

    // Update current job:
    public void onSaveCurrentJobClick(View view) {
        //jobID is always 1: update database for current job !
        updateJob(1);

        // for the step below? Why do we still need to
        // update current job row in ApplicationEntry?
        SQLiteDatabase appDb = appDbHelper.getWritableDatabase();

        ContentValues appValues = new ContentValues();

        appValues.put(ApplicationContract.ApplicationEntry.COLUMN_NAME_CURRENT_JOB, 1);

        String selection = ApplicationContract.ApplicationEntry._ID + " LIKE ?";
        String[] selectionArgs = { "1" };

        appDb.update(ApplicationContract.ApplicationEntry.TABLE_NAME, appValues, selection, selectionArgs);

        setContentView(R.layout.activity_main);
    }

    // Compare two job offers:
    public void onClickCompareOffers(View view) {
        setContentView(R.layout.activity_compare_two_jobs);

        compareJobs(jobList.get(0), jobList.get(1));
    }

    // Back to main menu:
    public void onReturnToMainClick(View view) {
        setContentView(R.layout.activity_main);
    }
}