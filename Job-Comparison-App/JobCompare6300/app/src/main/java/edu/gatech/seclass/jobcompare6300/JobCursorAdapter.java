package edu.gatech.seclass.jobcompare6300;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import edu.gatech.seclass.jobcompare6300.sqlite.JobContract;

public class JobCursorAdapter extends CursorAdapter {

    public JobCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.checkbox_row_layout, viewGroup, false);
    }

    @SuppressLint("Range")
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView rowTextView = (TextView) view.findViewById(R.id.rowTextView);

        int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(JobContract.JobEntry._ID)));
        String title = cursor.getString(cursor.getColumnIndex(JobContract.JobEntry.COLUMN_NAME_TITLE));
        String company = cursor.getString(cursor.getColumnIndex(JobContract.JobEntry.COLUMN_NAME_COMPANY));

        String text = "";
        if (id == 1) {
            text = "CURRENT JOB" + "\n" + "Title: " + title + "\n" + "Company: " + company;
        } else {
            text = "Title: " + title + "\n" + "Company: " + company;
        }
        rowTextView.setText(text);
    }
}
