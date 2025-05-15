package edu.gatech.seclass.jobcompare6300.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class JobContract {
    private JobContract() {}

    public static class JobEntry implements BaseColumns {
        public static final String TABLE_NAME = "jobs";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_COMPANY = "company";
        public static final String COLUMN_NAME_LOCATION = "location";
        public static final String COLUMN_NAME_COST_OF_LIVING = "cost_of_living";
        public static final String COLUMN_NAME_YEARLY_SALARY = "yearly_salary";
        public static final String COLUMN_NAME_YEARLY_BONUS = "yearly_bonus";
        public static final String COLUMN_NAME_GYM_MEMBERSHIP = "gym_membership";
        public static final String COLUMN_NAME_LEAVE_TIME = "leave_time";
        public static final String COLUMN_NAME_RETIREMENT_MATCH = "retirement_match";
        public static final String COLUMN_NAME_PET_INSURANCE = "pet_insurance";
        public static final String COLUMN_NAME_JOB_SCORE = "job_score";
    }

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + JobEntry.TABLE_NAME;

    public static class JobDbHelper extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Application.db";

        public JobDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_ENTRIES);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }
}
