package ru.sinergy.androidpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    private static final String  LogCat = "CALCULATOR_ACTIVITY";
    private static final String LifeCycleTag = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifeCycleTag, "I'm on created");
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LogCat, "Button have been pushed");

            calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiple = (RadioButton) findViewById(R.id.multiple);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        TextView answer = (TextView) findViewById(R.id.result);

        Log.d(LogCat, "All views have been founded");

        String num1 = numOne.getText().toString();
        String num2 = numTwo.getText().toString();

        float numone = Integer.parseInt(numOne.getText().toString());
        float numtwo = Integer.parseInt(numTwo.getText().toString());

        Log.d(LogCat, "Successfully grubbed data from input fields");
        Log.d(LogCat, "numone is " + numone + " ; " + "numtwo is " + numtwo);

        float solution = 0;

        if(add.isChecked()) {
            Log.d(LogCat, "Operation is add");
            solution = numone + numtwo;
        }

        if(sub.isChecked()) {
            Log.d(LogCat, "Operation is subtract");
            solution = numone - numtwo;
        }

        if(multiple.isChecked()) {
            Log.d(LogCat, "Operation is multiple");
            solution = numone * numtwo;
        }

        if(divide.isChecked()) {
            Log.d(LogCat, "Operation is divide");
            if(numtwo == 0) {
                Toast.makeText(this, "Number two cannot be zero", Toast.LENGTH_SHORT).show();
                return;
            }

            Log.d(LogCat, "The result of operation is " + solution);
            solution = numone / numtwo;
        }

        answer.setText("Answer is " + solution);
    }
}