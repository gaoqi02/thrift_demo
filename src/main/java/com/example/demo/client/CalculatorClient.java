package com.example.demo.client;

import com.example.demo.Calculator;
import com.example.demo.InvalidOperation;
import com.example.demo.Operation;
import com.example.demo.Work;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            TTransport transport = new TSocket("localhost", 9000);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            Calculator.Client client = new Calculator.Client(protocol);
            perform(client);
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void perform(Calculator.Client client) {
        Work work = new Work();
        work.op = Operation.ADD;
        work.num1 = 9;
        work.num2 = 9;
        try {
            int result = client.calculate(work);
            System.out.println("resu;t=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        work.op = Operation.SUBTRACT;
        work.num1 = 9;
        work.num2 = 9;
        try {
            int result = client.calculate(work);
            System.out.println("result=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        work.op = Operation.MULTIPLY;
        work.num1 = 9;
        work.num2 = 9;
        try {
            int result = client.calculate(work);
            System.out.println("result=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        work.op = Operation.DIVIDE;
        work.num1 = 9;
        work.num2 = 9;
        try {
            int result = client.calculate(work);
            System.out.println("result=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        work.op = Operation.DIVIDE;
        work.num1 = 9;
        work.num2 = 0;
        try {
            int result = client.calculate(work);
            System.out.println("resu;t=" + result);
        } catch (InvalidOperation invalidOperation) {
            System.out.println("error:" + invalidOperation.why);
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}