package com.example.calculator;
import org.mariuszgromada.math.mxparser.*;

public class Calculation {
    public String calculateOperation(String mathFunction){
        Expression expression = new Expression(mathFunction);
        String result = String.valueOf(expression.calculate());
        return (result.equals("NaN")) ?  "Неверное выражение": result;
    }
}
