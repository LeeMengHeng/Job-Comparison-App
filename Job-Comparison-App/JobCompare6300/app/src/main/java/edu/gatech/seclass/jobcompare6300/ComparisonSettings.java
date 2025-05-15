package edu.gatech.seclass.jobcompare6300;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;

import edu.gatech.seclass.jobcompare6300.sqlite.ComparisonSettingsContract;

public class ComparisonSettings {

    //Declare attributes:
    private int yearlySalaryWeight;
    private int yearlyBonusWeight;
    private int gymMembershipWeight;
    private int retirementMatchWeight;
    private int leaveTimeWeight;
    private int petInsuranceWeight;
    private ComparisonSettingsContract.ComparisonSettingsDbHelper csDbHelper;

    public ComparisonSettings(int yearlySalaryWeight, int yearlyBonusWeight, int gymMembershipWeight, int retirementMatchWeight, int leaveTimeWeight, int petInsuranceWeight) {
        this.setYearlySalaryWeight(yearlySalaryWeight);
        this.setYearlyBonusWeight(yearlyBonusWeight);
        this.setGymMembershipWeight(gymMembershipWeight);
        this.setRetirementMatchWeight(retirementMatchWeight);
        this.setLeaveTimeWeight(leaveTimeWeight);
        this.setPetInsuranceWeight(petInsuranceWeight);
    }

    //Constructor which initializes its fields using a Cursor object from the database.
    public ComparisonSettings(int yearlySalaryWeight, int yearlyBonusWeight, int gymMembershipWeight, int retirementMatchWeight, int leaveTimeWeight, int petInsuranceWeight, Context context) {
        this.setYearlySalaryWeight(yearlySalaryWeight);
        this.setYearlyBonusWeight(yearlyBonusWeight);
        this.setGymMembershipWeight(gymMembershipWeight);
        this.setRetirementMatchWeight(retirementMatchWeight);
        this.setLeaveTimeWeight(leaveTimeWeight);
        this.setPetInsuranceWeight(petInsuranceWeight);
        this.csDbHelper = new ComparisonSettingsContract.ComparisonSettingsDbHelper(context);
    }

    @SuppressLint("Range")
    public ComparisonSettings(Context context) {
        this.csDbHelper = new ComparisonSettingsContract.ComparisonSettingsDbHelper(context);
        try {
            // Set up the connection and initialize the data value for comparison setting table:
            SQLiteDatabase csDb = csDbHelper.getWritableDatabase();

            ContentValues csValues = new ContentValues();

            csValues.put(ComparisonSettingsContract.ComparisonSettingsEntry._ID, 1);
            csValues.put(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_YEARLY_SALARY_WEIGHT, 1);
            csValues.put(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_YEARLY_BONUS_WEIGHT, 1);
            csValues.put(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_GYM_MEMBERSHIP_WEIGHT, 1);
            csValues.put(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_RETIREMENT_MATCH_WEIGHT, 1);
            csValues.put(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_LEAVE_TIME_WEIGHT, 1);
            csValues.put(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_PET_INSURANCE_WEIGHT, 1);

            csDb.insert(ComparisonSettingsContract.ComparisonSettingsEntry.TABLE_NAME, null, csValues);
        } catch (SQLiteConstraintException e) {
            System.out.println("Entry already exists, skipping...");
        }

        SQLiteDatabase csDB = csDbHelper.getReadableDatabase();

        String[] projection = {
                ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_YEARLY_SALARY_WEIGHT,
                ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_YEARLY_BONUS_WEIGHT,
                ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_GYM_MEMBERSHIP_WEIGHT,
                ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_RETIREMENT_MATCH_WEIGHT,
                ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_LEAVE_TIME_WEIGHT,
                ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_PET_INSURANCE_WEIGHT
        };

        String selection = ComparisonSettingsContract.ComparisonSettingsEntry._ID + " = ?";

        String[] selectionArgs = {"" + 1};


        Cursor csCursor = csDB.query(
                ComparisonSettingsContract.ComparisonSettingsEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (csCursor != null && csCursor.moveToFirst()) {
            csCursor.moveToFirst();
            this.yearlySalaryWeight = csCursor.getInt(csCursor.getColumnIndex(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_YEARLY_SALARY_WEIGHT));
            this.yearlyBonusWeight = csCursor.getInt(csCursor.getColumnIndex(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_YEARLY_BONUS_WEIGHT));
            this.gymMembershipWeight = csCursor.getInt(csCursor.getColumnIndex(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_GYM_MEMBERSHIP_WEIGHT));
            this.retirementMatchWeight = csCursor.getInt(csCursor.getColumnIndex(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_RETIREMENT_MATCH_WEIGHT));
            this.leaveTimeWeight = csCursor.getInt(csCursor.getColumnIndex(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_LEAVE_TIME_WEIGHT));
            this.petInsuranceWeight = csCursor.getInt(csCursor.getColumnIndex(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_PET_INSURANCE_WEIGHT));
            csCursor.close();
        }
    }

    // Getter methods
    public int getYearlySalaryWeight() { return yearlySalaryWeight; }
    public int getYearlyBonusWeight() { return yearlyBonusWeight; }
    public int getGymMembershipWeight() { return gymMembershipWeight; }
    public int getRetirementMatchWeight() { return retirementMatchWeight; }
    public int getLeaveTimeWeight() { return leaveTimeWeight; }
    public int getPetInsuranceWeight() { return petInsuranceWeight; }

    // Setter methods
    public void setYearlySalaryWeight(int yearlySalaryWeight) {
        if ( yearlySalaryWeight < 0 ) { throw new RuntimeException("Range Error"); }

        this.yearlySalaryWeight = yearlySalaryWeight;
    }
    public void setYearlyBonusWeight(int yearlyBonusWeight) {
        if ( yearlyBonusWeight < 0 ) { throw new RuntimeException("Range Error"); }

        this.yearlyBonusWeight = yearlyBonusWeight;
    }
    public void setGymMembershipWeight(int gymMembershipWeight) {
        if ( gymMembershipWeight < 0 ) { throw new RuntimeException("Range Error"); }

        this.gymMembershipWeight = gymMembershipWeight;
    }
    public void setRetirementMatchWeight(int retirementMatchWeight) {
        if ( retirementMatchWeight < 0 ) { throw new RuntimeException("Range Error"); }

        this.retirementMatchWeight = retirementMatchWeight;
    }
    public void setLeaveTimeWeight(int leaveTimeWeight) {
        if ( leaveTimeWeight < 0 ) { throw new RuntimeException("Range Error"); }

        this.leaveTimeWeight = leaveTimeWeight;
    }
    public void setPetInsuranceWeight(int petInsuranceWeight) {
        if ( petInsuranceWeight < 0 ) { throw new RuntimeException("Range Error"); }

        this.petInsuranceWeight = petInsuranceWeight;
    }

    public long updateComparisonSettings() {
        SQLiteDatabase csDb = csDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_YEARLY_SALARY_WEIGHT, yearlySalaryWeight);
        values.put(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_YEARLY_BONUS_WEIGHT, yearlyBonusWeight);
        values.put(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_GYM_MEMBERSHIP_WEIGHT, gymMembershipWeight);
        values.put(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_RETIREMENT_MATCH_WEIGHT, retirementMatchWeight);
        values.put(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_LEAVE_TIME_WEIGHT, leaveTimeWeight);
        values.put(ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_PET_INSURANCE_WEIGHT, petInsuranceWeight);

        String selection = ComparisonSettingsContract.ComparisonSettingsEntry._ID + " LIKE ?";
        String[] selectionArgs = { "1" };

        return csDb.update(ComparisonSettingsContract.ComparisonSettingsEntry.TABLE_NAME, values, selection, selectionArgs);
    }
}
