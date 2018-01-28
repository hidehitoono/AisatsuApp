package jp.techacademy.hidehito.ono.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.TimePickerDialog;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button) {
                    showTimePickerDialog();
                }

            }

            private void showTimePickerDialog() {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                if (hourOfDay >= 2 && hourOfDay < 10) {
                                    textView.setText("おはよう");
                                } else if (hourOfDay >= 10 && hourOfDay <18) {
                                    textView.setText("こんにちは");
                                } else if (hourOfDay >= 18 || hourOfDay <2) {
                                    textView.setText("こんばんは");
                                }

                            }

                        },
                        13,
                        0,
                        true);
                timePickerDialog.show();
            }
        });

    }
}
