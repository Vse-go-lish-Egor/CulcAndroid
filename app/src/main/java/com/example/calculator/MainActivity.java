package com.example.calculator;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TextView editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        System.out.println("Create");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key", editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editText.setText(savedInstanceState.getString("key"));
    }
    public void onClickNum(View view){
        String text = editText.getText().toString();
        Button pressedButton = (Button)view;
        if(pressedButton.getText().toString().equals(".")) if (text.contains(".")) {
            text = text.replace(".", "");
        }
        String resultText = text+pressedButton.getText().toString();
        editText.setText(resultText);
    }
    public void  onClickOperation(View view){
        String text = editText.getText().toString();
        Operations operations = new Operations();
        editText.setText(operations.addMathOperation(view, text));
    }
    public void onClickEquals(View view){
        Calculation calc = new Calculation();
        editText.setText(calc.calculateOperation(editText.getText().toString()));
    }
    public void onClickShowAll(View view){
        Button button = (Button) view;
        LinearLayout operation =findViewById(R.id.allOperation);
        if(button.getText().toString().equals(">")){
            operation.setVisibility(View.VISIBLE);
            button.setText("<");
        }else{
            operation.setVisibility(View.GONE);
            button.setText(">");
        }
    }
    public void showExtend(View view){
        String text = editText.getText().toString();
        Operations operations = new Operations();
        editText.setText(operations.addExtendOperation(view, text));
    }
}