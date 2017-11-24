package com.example.demo.impl;

import com.example.demo.Calculator;
import com.example.demo.InvalidOperation;
import com.example.demo.Work;

public class CalculatorImpl implements Calculator.Iface {
    @Override
    public int calculate(Work work) throws InvalidOperation {
        int result = 0;
        switch (work.op) {
            case ADD:
                result = work.num1 + work.num2;
                break;
            case SUBTRACT:
                result = work.num1 - work.num2;
                break;
            case MULTIPLY:
                result = work.num1 * work.num2;
                break;
            case DIVIDE:
                if (work.num2 == 0) {
                    InvalidOperation invalidOperation = new InvalidOperation();
                    invalidOperation.whatOp = work.op.getValue();
                    invalidOperation.why = "Cannot divide by 0";
                    throw invalidOperation;
                }
                result = work.num1 / work.num2;
                break;
            default:
                InvalidOperation invalidOperation = new InvalidOperation();
                invalidOperation.whatOp = work.op.getValue();
                invalidOperation.why = "Unknown operation";
                throw invalidOperation;
        }

        return result;
    }
}
