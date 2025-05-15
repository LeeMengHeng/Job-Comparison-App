package edu.gatech.seclass.jobcompare6300.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class ApplicationContract {
    private ApplicationContract() {
    }

    public static class ApplicationEntry implements BaseColumns {
        public static final String TABLE_NAME = "application";
        public static final String COLUMN_NAME_CURRENT_JOB = "current_job";
        public static final String COLUMN_NAME_JOB_OFFERS = "job_offers";
    }

    private static final String APPLICATION_SQL_CREATE_ENTRIES =
            "CREATE TABLE " +
                ApplicationEntry.TABLE_NAME + " (" +
                ApplicationEntry._ID + " INTEGER PRIMARY KEY," +
                ApplicationEntry.COLUMN_NAME_CURRENT_JOB + " INTEGER," +
                ApplicationEntry.COLUMN_NAME_JOB_OFFERS + " INTEGER)";

    private static final String JOBS_SQL_CREATE_ENTRIES =
            "CREATE TABLE " + JobContract.JobEntry.TABLE_NAME + " (" +
                    JobContract.JobEntry._ID + " INTEGER PRIMARY KEY," +
                    JobContract.JobEntry.COLUMN_NAME_TITLE + " TEXT," +
                    JobContract.JobEntry.COLUMN_NAME_COMPANY + " TEXT," +
                    JobContract.JobEntry.COLUMN_NAME_LOCATION + " TEXT," +
                    JobContract.JobEntry.COLUMN_NAME_COST_OF_LIVING + " INTEGER," +
                    JobContract.JobEntry.COLUMN_NAME_YEARLY_SALARY + " REAL," +
                    JobContract.JobEntry.COLUMN_NAME_YEARLY_BONUS + " REAL," +
                    JobContract.JobEntry.COLUMN_NAME_GYM_MEMBERSHIP + " REAL," +
                    JobContract.JobEntry.COLUMN_NAME_LEAVE_TIME + " INTEGER," +
                    JobContract.JobEntry.COLUMN_NAME_RETIREMENT_MATCH + " INTEGER," +
                    JobContract.JobEntry.COLUMN_NAME_PET_INSURANCE + " REAL," +
                    JobContract.JobEntry.COLUMN_NAME_JOB_SCORE + " REAL)";

    private static final String COMPARISON_SETTINGS_SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ComparisonSettingsContract.ComparisonSettingsEntry.TABLE_NAME + " (" +
                    ComparisonSettingsContract.ComparisonSettingsEntry._ID + " INTEGER PRIMARY KEY," +
                    ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_YEARLY_SALARY_WEIGHT + " INTEGER," +
                    ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_YEARLY_BONUS_WEIGHT + " INTEGER," +
                    ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_GYM_MEMBERSHIP_WEIGHT + " INTEGER," +
                    ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_LEAVE_TIME_WEIGHT + " INTEGER," +
                    ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_RETIREMENT_MATCH_WEIGHT + " INTEGER," +
                    ComparisonSettingsContract.ComparisonSettingsEntry.COLUMN_NAME_PET_INSURANCE_WEIGHT + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ApplicationEntry.TABLE_NAME;

    public static class ApplicationDbHelper extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Application.db";

        public ApplicationDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(APPLICATION_SQL_CREATE_ENTRIES);
            db.execSQL(JOBS_SQL_CREATE_ENTRIES);
            db.execSQL(COMPARISON_SETTINGS_SQL_CREATE_ENTRIES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_ENTRIES);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }
}
