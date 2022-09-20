package com.example.calculator;

import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operations {
    private final String defaultOperations = "+*-/";
    private final List<String> extendedOperations = new ArrayList<String>(Arrays.asList("sin(", "cos(", "tan(", "^", "!", "ln(", "(", ")", "pi", "%", "√"));
    public String addMathOperation(View view, String text) {
        if(text == null || text.length() == 0) return "";
        switch (view.getId()) {
            case R.id.btnClear:
                return "";
            case R.id.btnBack:
                return (text.substring(0, text.length() - 1));
        }
        if(!this.defaultOperations.contains(text.substring(text.length() - 1))){
            switch (view.getId()) {
                case R.id.btnAdd:
                    return text + "+";
                case R.id.btnDivide:
                    return  text + "/";
                case R.id.btnSubtract:
                    return  text + "-";
                case R.id.btnMultiply:
                    return text + "*";
            }

        }
        return text;
    }
    public String addExtendOperation(View view, String text){
        switch (view.getId()) {
            case R.id.btnSin:
                return text + this.extendedOperations.get(0);
            case R.id.btnCos:
                return  text + this.extendedOperations.get(1);
            case R.id.btnTan:
                return  text + this.extendedOperations.get(2);
            case R.id.btnPow:
                return text + this.extendedOperations.get(3);
            case  R.id.btnFact:
                return text + this.extendedOperations.get(4);
            case  R.id.btnLn:
                return text + this.extendedOperations.get(5);
            case  R.id.btnBracketOpen:
                return text + this.extendedOperations.get(6);
            case  R.id.btnBracketClose:
                return text + this.extendedOperations.get(7);
            case  R.id.btnPi:
                return text + this.extendedOperations.get(8);
            case  R.id.btnPercentages:
                return text + this.extendedOperations.get(9);

            case  R.id.btnSquareRoot:
                return text + this.extendedOperations.get(10);
        }


        return text;
    }
}