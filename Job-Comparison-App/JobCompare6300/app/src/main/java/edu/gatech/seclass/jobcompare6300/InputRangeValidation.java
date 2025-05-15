package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Toast;

public class InputRangeValidation implements InputFilter {
    private int min;
    private int max;
    private Context context;

    public InputRangeValidation(int min, int max, Context context) {
        this.min = min;
        this.max = max;
        this.context = context;
    }

    @Override
    public CharSequence filter(CharSequence charSequence, int front, int back, Spanned spanned, int sFront, int sBack) {
        try {
            int num = Integer.parseInt(spanned.subSequence(0, sFront).toString() + charSequence + spanned.subSequence(sBack, spanned.length()));
            if (max > min ? num >= min && num <= max : num >= max && num <= min) {
                return null;
            }
        } catch (NumberFormatException e) {
        }
        Toast.makeText(context, "Number must be between " + min + " and " + max + ".", Toast.LENGTH_SHORT).show();
        return "";
    }

}
