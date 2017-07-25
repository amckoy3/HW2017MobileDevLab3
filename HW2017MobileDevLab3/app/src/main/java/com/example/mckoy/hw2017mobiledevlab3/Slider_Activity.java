package com.example.mckoy.hw2017mobiledevlab3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.content.Intent;

public class Slider_Activity extends AppCompatActivity {

    private static final String SLIDER_VALUE_KEY = "slider_value_key";

    private SeekBar mSeekBar;

    public static Intent newIntent(Context context, int initialValue) {
        Intent i = new Intent(context, Slider_Activity.class);
        i.putExtra(SLIDER_VALUE_KEY, initialValue);
        return i;
    }

    public static int getSliderValueFromReturnIntent(Intent i) {
        return i.getIntExtra(Slider_Activity.SLIDER_VALUE_KEY, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        int initialValue = getIntent().getIntExtra(SLIDER_VALUE_KEY, 0);

        mSeekBar = (SeekBar) findViewById(R.id.seek_bar);
        mSeekBar.setProgress(initialValue);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(SLIDER_VALUE_KEY, seekBar.getProgress());
                setResult(RESULT_OK, returnIntent);
            }
        });
    }
}
