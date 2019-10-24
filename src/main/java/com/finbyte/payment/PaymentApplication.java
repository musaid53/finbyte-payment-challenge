package com.finbyte.payment;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PaymentApplication {

    public static void main(String[] args) {
        //SpringApplication.run(PaymentApplication.class, args);


        List<Payment> payments = new ArrayList<Payment>();
        payments.add(new Payment(1.0));
        payments.add(new Payment(2.0));
        payments.add(new Payment(3.0));

        double sum = sum(payments);
        System.out.println(sum);
    }

    public static double sum(List<Payment> payments) {
        double sum = 0;
        //
        return sum;
    }

    public static final class Payment {

        public double amount;

        public Payment(double amount) {
            this.amount = amount;
        }
    }

}
