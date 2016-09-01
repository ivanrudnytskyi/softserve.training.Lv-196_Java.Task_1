package com.softserve.edu.lv196.java.task_1;

import java.util.stream.LongStream;

/**
 * @author Ivan Rudnytskyi
 * date 2016/08/31 (yyyy/mm/dd)
 *
 * The task (#330):
 *
 * A natural number is perfect, if it equals to sum of its divisors, except itself.
 * Number 6 is perfect, because 6 = 1 + 2 + 3. Number 8 is not perfect, since 8 != 1 + 2 + 4.
 * A natural number n is given. Find all the perfect numbers under the number n.

 *
 **/


public class Task330 {

    public static void main(String[] args) {

        //the limit for perfect numbers search
        long number = 10_000;

        // the method, which searches for perfect numbers
        perfectNumbers(number);

    }
    /**
     * in the method perfect number are searched for. If a perfect number is found
     *  - it is printed. Otherwise, the message is printed - no perfect numbers found.
     * @param number - long, high limit of the search for perfect numbers
     * @throws IllegalArgumentException - the number must be greater than 1
     */
    public static void perfectNumbers (long number){

        if (number < 1)
            throw new IllegalArgumentException("The number must be greater than 1");

        //prints and count perfect numbers
        long count = LongStream.rangeClosed(1, number)
                .filter(n -> n == LongStream.rangeClosed(1, n / 2)
                        .filter(i -> n % i == 0)
                        .sum())
                .peek(i -> System.out.println("Perfect number under " + number + ": " + i))
                .count();

        //otherwise - if no perfect number is found, print the message
        if (count == 0)
            System.out.println("There are no perfect numbers under " + number);

        System.out.println("Calculation finished");
    }

}
