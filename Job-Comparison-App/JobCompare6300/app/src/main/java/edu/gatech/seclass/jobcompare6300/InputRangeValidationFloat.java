package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Toast;

public class InputRangeValidationFloat implements InputFilter {
    private float min;
    private float max;
    private Context context;

    public InputRangeValidationFloat(float min, float max, Context context) {
        this.min = min;
        this.max = max;
        this.context = context;
    }

    @Override
    public CharSequence filter(CharSequence charSequence, int front, int back, Spanned spanned, int sFront, int sBack) {
        try {
            float num = Float.parseFloat(spanned.subSequence(0, sFront).toString() + charSequence + spanned.subSequence(sBack, spanned.length()));
            if (max > min ? num >= min && num <= max : num >= max && num <= min) {
                return null;
            }
        } catch (NumberFormatException e) {
        }
        Toast.makeText(context, "Number must be between " + min + " and " + max + ".", Toast.LENGTH_SHORT).show();
        return "";
    }

}
