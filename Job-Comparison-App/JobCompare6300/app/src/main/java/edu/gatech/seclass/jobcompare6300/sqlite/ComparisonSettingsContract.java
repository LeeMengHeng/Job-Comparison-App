package edu.gatech.seclass.jobcompare6300.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class ComparisonSettingsContract {
    private ComparisonSettingsContract() {}

    public static class ComparisonSettingsEntry implements BaseColumns {
        public static final String TABLE_NAME = "comparisonsettings";
        public static final String COLUMN_NAME_YEARLY_SALARY_WEIGHT = "yearly_salary_weight";
        public static final String COLUMN_NAME_YEARLY_BONUS_WEIGHT = "yearly_bonus_weight";
        public static final String COLUMN_NAME_GYM_MEMBERSHIP_WEIGHT = "gym_membership_weight";
        public static final String COLUMN_NAME_LEAVE_TIME_WEIGHT = "leave_time_weight";
        public static final String COLUMN_NAME_RETIREMENT_MATCH_WEIGHT = "retirement_match_weight";
        public static final String COLUMN_NAME_PET_INSURANCE_WEIGHT = "pet_insurance_weight";
    }

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ComparisonSettingsEntry.TABLE_NAME;

    public static class ComparisonSettingsDbHelper extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Application.db";

        public ComparisonSettingsDbHelper(Context context) {
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
