package edu.gatech.seclass.jobcompare6300;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;

import edu.gatech.seclass.jobcompare6300.sqlite.JobContract;

public class Job {

    //Declare attributes:
    private String title;
    private String company;
    private String location;
    private int costOfLiving;
    private float yearlySalary;
    private float yearlyBonus;
    private float gymMembership;
    private int leaveTime;
    private int f01kMatch;
    private float petInsurance;

    private JobContract.JobDbHelper jobDbHelper;

    public Job(String title, String company, String location, int costOfLiving, float yearlySalary, float yearlyBonus, float gymMembership, int leaveTime, int f01kMatch, float petInsurance) {

        this.setTitle(title);
        this.setCompany(company);
        this.setLocation(location);
        this.setCostOfLiving(costOfLiving);
        this.setYearlySalary(yearlySalary);
        this.setYearlyBonus(yearlyBonus);
        this.setGymMembership(gymMembership);
        this.setLeaveTime(leaveTime);
        this.setF01kMatch(f01kMatch);
        this.setPetInsurance(petInsurance);
    }

    public Job(String title, String company, String location, int costOfLiving, float yearlySalary, float yearlyBonus, float gymMembership, int leaveTime, int f01kMatch, float petInsurance, Context context) {
        this.jobDbHelper = new JobContract.JobDbHelper(context);
        try {
            //set up the database connection and initialize the value for Job Table:
            SQLiteDatabase jobDb = jobDbHelper.getWritableDatabase();

            ContentValues jobValues = new ContentValues();

            jobValues.put(JobContract.JobEntry._ID, 1);

            jobDb.insert(JobContract.JobEntry.TABLE_NAME, null, jobValues);
        } catch (SQLiteConstraintException e) {
            System.out.println("Entry already exists, skipping...");
        }

        this.setTitle(title);
        this.setCompany(company);
        this.setLocation(location);
        this.setCostOfLiving(costOfLiving);
        this.setYearlySalary(yearlySalary);
        this.setYearlyBonus(yearlyBonus);
        this.setGymMembership(gymMembership);
        this.setLeaveTime(leaveTime);
        this.setF01kMatch(f01kMatch);
        this.setPetInsurance(petInsurance);
    }

    @SuppressLint("Range")
    public Job(long id, Context context) {
        this.jobDbHelper = new JobContract.JobDbHelper(context);
        try {
            //set up the database connection and initialize the value for Job Table:
            SQLiteDatabase jobDb = jobDbHelper.getWritableDatabase();

            ContentValues jobValues = new ContentValues();

            jobValues.put(JobContract.JobEntry._ID, 1);

            jobDb.insert(JobContract.JobEntry.TABLE_NAME, null, jobValues);
        } catch (SQLiteConstraintException e) {
            System.out.println("Entry already exists, skipping...");
        }

        //connection:
        SQLiteDatabase jobDB = jobDbHelper.getReadableDatabase();

        //preparation:
        String[] projection = {
                JobContract.JobEntry.COLUMN_NAME_TITLE,
                JobContract.JobEntry.COLUMN_NAME_COMPANY,
                JobContract.JobEntry.COLUMN_NAME_LOCATION,
                JobContract.JobEntry.COLUMN_NAME_COST_OF_LIVING,
                JobContract.JobEntry.COLUMN_NAME_YEARLY_SALARY,
                JobContract.JobEntry.COLUMN_NAME_YEARLY_BONUS,
                JobContract.JobEntry.COLUMN_NAME_GYM_MEMBERSHIP,
                JobContract.JobEntry.COLUMN_NAME_LEAVE_TIME,
                JobContract.JobEntry.COLUMN_NAME_RETIREMENT_MATCH,
                JobContract.JobEntry.COLUMN_NAME_PET_INSURANCE,
                JobContract.JobEntry.COLUMN_NAME_JOB_SCORE
        };

        String selection = JobContract.JobEntry._ID + " = ?";

        String[] selectionArgs = {"" + id};

        // query:
        Cursor jobCursor = jobDB.query(
                JobContract.JobEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        jobCursor.moveToFirst();

        // result:
        String title = jobCursor.getString(jobCursor.getColumnIndex(JobContract.JobEntry.COLUMN_NAME_TITLE));
        String company = jobCursor.getString(jobCursor.getColumnIndex(JobContract.JobEntry.COLUMN_NAME_COMPANY));
        String location = jobCursor.getString(jobCursor.getColumnIndex(JobContract.JobEntry.COLUMN_NAME_LOCATION));
        int costOfLiving = jobCursor.getInt(jobCursor.getColumnIndex(JobContract.JobEntry.COLUMN_NAME_COST_OF_LIVING));
        float yearlySalary = jobCursor.getFloat(jobCursor.getColumnIndex(JobContract.JobEntry.COLUMN_NAME_YEARLY_SALARY));
        float yearlyBonus = jobCursor.getFloat(jobCursor.getColumnIndex(JobContract.JobEntry.COLUMN_NAME_YEARLY_BONUS));
        float gymMembership = jobCursor.getFloat(jobCursor.getColumnIndex(JobContract.JobEntry.COLUMN_NAME_GYM_MEMBERSHIP));
        int leaveTime = jobCursor.getInt(jobCursor.getColumnIndex(JobContract.JobEntry.COLUMN_NAME_LEAVE_TIME));
        int f01kMatch = jobCursor.getInt(jobCursor.getColumnIndex(JobContract.JobEntry.COLUMN_NAME_RETIREMENT_MATCH));
        float petInsurance = jobCursor.getFloat(jobCursor.getColumnIndex(JobContract.JobEntry.COLUMN_NAME_PET_INSURANCE));

        this.title = title;
        this.company = company;
        this.location = location;
        this.costOfLiving = costOfLiving;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.gymMembership = gymMembership;
        this.leaveTime = leaveTime;
        this.f01kMatch = f01kMatch;
        this.petInsurance = petInsurance;
    }

    //Getter method for Job Class
    public String getTitle() { return title; }
    public String getCompany() { return company; }
    public String getLocation() { return location; }
    public int getCostOfLiving() { return costOfLiving; }
    public float getYearlySalary() { return yearlySalary; }
    public float getYearlyBonus() { return yearlyBonus; }
    public float getGymMembership() { return gymMembership; }
    public int getLeaveTime() { return leaveTime; }
    public int getF01kMatch() { return f01kMatch; }
    public float getPetInsurance() { return petInsurance; }

    // Setter methods for the `Job` class:
    public void setTitle(String title) {
        if ( title.isEmpty() ){ throw new RuntimeException("Empty String"); }
        this.title = title;
    }

    public void setCompany(String company) {
        if ( company.isEmpty() ){ throw new RuntimeException("Empty String"); }
        this.company = company;
    }

    public void setLocation(String location) {
        if ( location.isEmpty() ){ throw new RuntimeException("Empty String"); }
        this.location = location;
    }
    public void setCostOfLiving(int costOfLiving) {
        if ( costOfLiving < 0 ) { throw new RuntimeException("Range Error"); }

        this.costOfLiving = costOfLiving;
    }
    public void setYearlySalary(float yearlySalary) {
        if ( yearlySalary < 0.0 ) { throw new RuntimeException("Range Error"); }

        this.yearlySalary = yearlySalary;
    }

    public void setYearlyBonus(float yearlyBonus) {
        if ( yearlyBonus < 0.0 ) { throw new RuntimeException("Range Error"); }

        this.yearlyBonus = yearlyBonus;
    }

    public void setGymMembership(float gymMembership) {
        if ( gymMembership < 0.0 ) { throw new RuntimeException("Range Error"); }

        this.gymMembership = gymMembership;
    }

    public void setLeaveTime(int leaveTime) {
        if ( leaveTime < 0 ) { throw new RuntimeException("Range Error"); }

        this.leaveTime = leaveTime;
    }

    public void setF01kMatch(int f01kMatch) {
        if ( f01kMatch < 0 || f01kMatch > 20) { throw new RuntimeException("Range Error"); }

        this.f01kMatch = f01kMatch;
    }

    public void setPetInsurance(float petInsurance) {
        if ( petInsurance < 0.0 || petInsurance > 5000.0) { throw new RuntimeException("Range Error"); }

        this.petInsurance = petInsurance;
    }

    public long insertJob() {
        // storing job information to JOB database
        SQLiteDatabase jobDb = jobDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(JobContract.JobEntry.COLUMN_NAME_TITLE, title);
        values.put(JobContract.JobEntry.COLUMN_NAME_COMPANY, company);
        values.put(JobContract.JobEntry.COLUMN_NAME_LOCATION, location);
        values.put(JobContract.JobEntry.COLUMN_NAME_COST_OF_LIVING, costOfLiving);
        values.put(JobContract.JobEntry.COLUMN_NAME_YEARLY_SALARY, yearlySalary);
        values.put(JobContract.JobEntry.COLUMN_NAME_YEARLY_BONUS, yearlyBonus);
        values.put(JobContract.JobEntry.COLUMN_NAME_GYM_MEMBERSHIP, gymMembership);
        values.put(JobContract.JobEntry.COLUMN_NAME_LEAVE_TIME, leaveTime);
        values.put(JobContract.JobEntry.COLUMN_NAME_RETIREMENT_MATCH, f01kMatch);
        values.put(JobContract.JobEntry.COLUMN_NAME_PET_INSURANCE, petInsurance);

        // Not only save the info, it also returns the rowID of new row in JOB database:
        return jobDb.insert(JobContract.JobEntry.TABLE_NAME, null, values);
    }

    public long updateJob(long jobId) {
        SQLiteDatabase jobDb = jobDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(JobContract.JobEntry.COLUMN_NAME_TITLE, title);
        values.put(JobContract.JobEntry.COLUMN_NAME_COMPANY, company);
        values.put(JobContract.JobEntry.COLUMN_NAME_LOCATION, location);
        values.put(JobContract.JobEntry.COLUMN_NAME_COST_OF_LIVING, costOfLiving);
        values.put(JobContract.JobEntry.COLUMN_NAME_YEARLY_SALARY, yearlySalary);
        values.put(JobContract.JobEntry.COLUMN_NAME_YEARLY_BONUS, yearlyBonus);
        values.put(JobContract.JobEntry.COLUMN_NAME_GYM_MEMBERSHIP, gymMembership);
        values.put(JobContract.JobEntry.COLUMN_NAME_LEAVE_TIME, leaveTime);
        values.put(JobContract.JobEntry.COLUMN_NAME_RETIREMENT_MATCH, f01kMatch);
        values.put(JobContract.JobEntry.COLUMN_NAME_PET_INSURANCE, petInsurance);

        String selection = JobContract.JobEntry._ID + " LIKE ?";
        String[] selectionArgs = { "" + jobId };

        //update the result and return the update rowID.
        return jobDb.update(JobContract.JobEntry.TABLE_NAME, values, selection, selectionArgs);
    }

    public static JobCursorAdapter getJobList(Context context) {
        JobContract.JobDbHelper jobDbHelper = new JobContract.JobDbHelper(context);
        SQLiteDatabase jobDb = jobDbHelper.getReadableDatabase();

        String[] projection = {
                JobContract.JobEntry._ID,
                JobContract.JobEntry.COLUMN_NAME_TITLE,
                JobContract.JobEntry.COLUMN_NAME_COMPANY
        };
        Cursor cursor = jobDb.query(JobContract.JobEntry.TABLE_NAME, projection, null, null, null, null, null, null);

        JobCursorAdapter jobCursorAdapter = new JobCursorAdapter(context, cursor);
        return jobCursorAdapter;
    }
}
