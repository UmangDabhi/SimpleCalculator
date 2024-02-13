package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleCalculator extends AppCompatActivity implements View.OnClickListener{

    Button buttonAdd, buttonMin, buttonMul, buttonDiv;
    EditText editText1, editText2;
    TextView textView;
    int num1, num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.btnAdd);
        buttonMin = findViewById(R.id.btnMin);
        buttonMul = findViewById(R.id.btnMul);
        buttonDiv = findViewById(R.id.btnDiv);
        editText1 = findViewById(R.id.number1);
        editText2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(this);
        buttonMin.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
    }
    public int getIntFromEditText(EditText editText){
        if(editText.getText().toString().equals("")){
            Toast.makeText(this, "Enter Number",Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Integer.parseInt(editText.getText().toString());
    }

    @Override
    public void onClick(View v) {
        num1 = getIntFromEditText(editText1);
        num2 = getIntFromEditText(editText2);
        int id = v.getId();
        if (id == R.id.btnAdd) {
            textView.setText("Answer: "+(num1 + num2));
        } else if (id == R.id.btnMin) {
            textView.setText("Answer: "+(num1 - num2));
        } else if (id == R.id.btnMul) {
            textView.setText("Answer: "+(num1 * num2));
        }else if(id == R.id.btnDiv){
            textView.setText("Answer: "+((float)num1 / (float)num2));
        }
    }
}