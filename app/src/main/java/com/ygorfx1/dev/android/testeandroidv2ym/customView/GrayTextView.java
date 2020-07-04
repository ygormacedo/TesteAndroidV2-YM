package com.ygorfx1.dev.android.testeandroidv2ym.customView;

import android.content.Context;
import android.util.AttributeSet;

import com.ygorfx1.dev.android.testeandroidv2ym.R;

import androidx.appcompat.widget.AppCompatTextView;

public class GrayTextView extends AppCompatTextView {
    public GrayTextView(Context context) {
        super(context);
        setInit();
    }

    public GrayTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setInit();
    }

    private void setInit() {
        this.setTextColor(getResources().getColor(R.color.gray));
    }
}
