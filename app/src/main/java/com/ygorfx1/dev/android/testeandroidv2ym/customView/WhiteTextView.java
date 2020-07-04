package com.ygorfx1.dev.android.testeandroidv2ym.customView;

import android.content.Context;
import android.util.AttributeSet;

import com.ygorfx1.dev.android.testeandroidv2ym.R;

import androidx.appcompat.widget.AppCompatTextView;

public class WhiteTextView extends AppCompatTextView {
    public WhiteTextView(Context context) {
        super(context);
        setInit();
    }

    public WhiteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setInit();
    }

    private void setInit() {
        this.setTextColor(getResources().getColor(R.color.white));
    }


}
