package com.gmail.mytipcalculator.bmichaelh13;

import androidx.appcompat.app.AppCompatActivity;


import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResultTextView;
    private TextView textViewSeekBar;
    private int seekBarPercentage;
    private float enteredBillFloat;

    public static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount = (EditText) findViewById(R.id.billAmountId);
        seekBar = (SeekBar) findViewById(R.id.seekBarId);
        calculateButton = (Button) findViewById(R.id.calculateButtonId);
        totalResultTextView = (TextView) findViewById(R.id.resultId);
        textViewSeekBar = (TextView) findViewById(R.id.textViewSeekBarId);

        Toast.makeText(getApplicationContext(), "Hello Big Spender", Toast.LENGTH_LONG).show();



        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textViewSeekBar.setText(String.valueOf(seekBar.getProgress()) + "%");


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                seekBarPercentage = seekBar.getProgress();

            }
        });


    }


    @Override
    public void onClick(View v) {
        calculate();
    }

    //TODO build out this app to include more stuff...

    public void calculate() {

        float result = 0.0f;

        if (!enteredAmount.getText().toString().equals("")) {

            enteredBillFloat = Float.parseFloat(enteredAmount.getText().toString());
            result = enteredBillFloat * seekBarPercentage / 100;
            totalResultTextView.setText("$" + String.valueOf(result) + "  Gratuity");

            Log.v(TAG, String.valueOf(result));

        } else {
            Toast.makeText(MainActivity.this, "Please enter the bill amount.", Toast.LENGTH_LONG).show();
        }
    }

}
