package com.example.demo.server;

import com.example.demo.Calculator;
import com.example.demo.impl.CalculatorImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class CalculatorServer {

    public static CalculatorImpl calculatorImnpl;
    public static Calculator.Processor processor;

    public static void main(String[] args) {
        try {
            calculatorImnpl = new CalculatorImpl();
            processor = new Calculator.Processor(calculatorImnpl);

            final Runnable simple = new Runnable() {
                @Override
                public void run() {
                    simple(processor);
                }
            };

            new Thread(simple).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void simple(Calculator.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9000);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            System.out.println("Starting the server....");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}