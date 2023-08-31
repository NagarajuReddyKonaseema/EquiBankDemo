package com.ibm.gbs.javaprep;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimeNumberDemo {

// This method find all prime numbers less than input number
    //If the input is 5, the output will be 2,3
    //If the input is 5.1,the output will be 2,3,5
        public List<Integer> getPrimeNumbers(double inputNumber)
        {
            // Declaring the variables
            int i, j;
            boolean isNotPrimeNumber=false;
            List<Integer> primeNumberList=new ArrayList<>();

            // Using for loop
            // the numbers from 2 to inputNumber
            // 1 is NOT prime NOT Composite number. So starting the loop from the number 2
            for (i = 2; i < inputNumber; i++)
            {

                //Reset the prime number flag for each loop iteration
                isNotPrimeNumber=false;

                //inner for loop to find each number is prime or not
                for (j = 2; j <= i / 2; ++j)
                {
                    if (i % j == 0) {
                        isNotPrimeNumber = true;
                        break;
                    }
                }
                //if it is prime number(flag should be false at this point), Add to the Arraylist
                if (!isNotPrimeNumber)
                    primeNumberList.add(i);
            }
            return primeNumberList;

        }

        //Using Streams
    public static List<Integer> findPrimeNumberUsingStream(double inputNumber)
    {
        int number=Double.valueOf(Math.ceil(inputNumber)).intValue();

        return IntStream.rangeClosed(2,number-1).
                filter(PrimeNumberDemo::isPrime)
                .boxed()
                .collect(Collectors.toList());


    }

    private static boolean isPrime(int inputNumber)
    {
       return IntStream.range(2,inputNumber).noneMatch(i -> inputNumber % i ==0);
    }


        // Main method
        public static void main(String[] args)
        {
            PrimeNumberDemo primeNumberDemo=new PrimeNumberDemo();

            System.out.println(" ****** Using for loop ******");

            double inputNumber1 = 5.0;
            List<Integer> response=primeNumberDemo.getPrimeNumbers(inputNumber1);
            System.out.print("Prime number less than "+inputNumber1+ " are : ");
            response.forEach(System.out::println);

            System.out.println();
            double inputNumber2 = 6.5;
            List<Integer> response2=primeNumberDemo.getPrimeNumbers(inputNumber2);
            System.out.print("Prime number less than "+inputNumber2+ " are : ");
            response2.forEach(i -> {System.out.print(i+" ");});

            System.out.println();
            System.out.println(" ****** Using streams ******");

            //Using Streams
            double inputNumber3 = 5;
            List<Integer> response3=findPrimeNumberUsingStream(inputNumber3);
            System.out.print("Prime number less than "+inputNumber3+ " are : ");
            response3.forEach(i -> {System.out.print(i+" ");});

            System.out.println();

            //Using Streams
            double inputNumber4 = 6.5;
            List<Integer> response4=findPrimeNumberUsingStream(inputNumber4);
            System.out.print("Prime number less than "+inputNumber4+ " are : ");
            response4.forEach(i -> {System.out.print(i+" ");});

        }
    }
