package com.finbyte.payment;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class PaymentApplication {

    public static void main(String[] args) throws Exception {
        //SpringApplication.run(PaymentApplication.class, args);


        final List<Payment> payments = new ArrayList<>();
        payments.add(new Payment(1.0, "cash"));
        payments.add(new Payment(2.0, "credit"));
        payments.add(new Payment(3.0, "cash"));
        payments.add(new Payment(4.0, "credit"));

        payments.forEach(payment -> System.out.println("Date:"+ LocalDateTime.now() + payment.amount + ", " + payment.type));

        var sum = sum(payments);
        System.out.println(sum);

        var pymMap = count(payments);
        // todo print count with payment types

        var paymentsWithTax = addTax(payments, 0.1, "cash");
        // todo print payments with tax


        concurrentAddPayment(payments);

    }

    public static double sum(List<Payment> payments) {
        // todo calculate sum
        double sum = 0;
        //
        return sum;
    }

    public static Map<String, Long> count(List<Payment> payments) {
        int count = 0;
        // todo return the count of each payment type
       return Collections.emptyMap();
    }

    public static List<Payment> addTax(List<Payment> payments, double tax, String type) {
        // todo  add tax payment for giving types with add "_tax" postfix to tax
        return Collections.emptyList();
    }

    public static void concurrentAddPayment(List<Payment> payments) throws Exception{
        // todo add payment in a thread safe way and print all payments with insertion order

        Thread t1 = new Thread(() -> addPayment(new Payment(5.0, "cash"), payments));
        Thread t2 = new Thread(() -> addPayment(new Payment(6.0, "credit"), payments));


        t1.start();
        t2.start();



    }

    public static void addPayment(Payment payment, List<Payment> payments) {


        try {
            System.out.println("Date:"+ LocalDateTime.now() +" Adding payment: " + payment.amount + ", " + payment.type);
            Thread.sleep(new Random().nextLong(3000, 6000));
            payments.add(payment);
            System.out.println("Date:"+ LocalDateTime.now() +" Added payment: " + payment.amount + ", " + payment.type);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static final class Payment {

        public double amount;

        public String type;

        public Payment(double amount, String type) {
            this.amount = amount;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Payment{" +
                    "amount=" + amount +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

}
