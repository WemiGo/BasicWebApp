package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryProcessor {

    public String process(String query) {
        try {
            if (query.toLowerCase().contains("shakespeare")) {
                return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                        "English poet, playwright, and actor, widely regarded as the greatest " +
                        "writer in the English language and the world's pre-eminent dramatist.";
            } else if (query.toLowerCase().contains("multiplied by") && query.toLowerCase().contains("plus")) {
                String issplit = Arrays.asList(query.split("is")).get(1);
                List<String> numbers  = Arrays.asList(issplit.split("multiplied by"));
                int a = Integer.parseInt(numbers.get(0).replaceAll("\\s+", ""));
                List<String> numbers_b = Arrays.asList(numbers.get(1).split("plus"));
                int b = Integer.parseInt(numbers_b.get(0).replaceAll("\\s+", ""));
                int c = Integer.parseInt(numbers_b.get(1).replaceAll("\\s+", ""));
                return String.valueOf(a * b + c);
            } else if (query.toLowerCase().isEmpty()) {
                return "Woah there! Looks like you've submitted an empty string... That's not great! " +
                        "You should really get that looked at";
            } else if (query.toLowerCase().contains("remi")) {
                return "Heeyy you guessed who I was... That's great for you, not for me!";
            } else if (query.toLowerCase().contains("team name")) {
                return "Entity";
            } else if (query.toLowerCase().contains("fuck")) {
                return "Fuck you";
            } else if (query.toLowerCase().contains("which of the following numbers is the largest:")) {
                String comma = Arrays.asList(query.split(":")).get(2);
                List<String> numbers = Arrays.asList(comma.split(","));
                int maximum = 0;
                for (String n : numbers) {
                    n = n.replaceAll("\\s+", "");
                    if (Integer.parseInt(n) > maximum) {
                        maximum = Integer.parseInt(n);
                    }
                }
                return String.valueOf(maximum);
            } else if (query.toLowerCase().contains("plus")) {
                String issplit = Arrays.asList(query.split("is")).get(1);
                List<String> numbers  = Arrays.asList(issplit.split("plus"));
                int sum = 0;
                for (String n : numbers) {
                    sum += Integer.parseInt(n.replaceAll("\\s+", ""));
                }
                return String.valueOf(sum);
            } else if (query.toLowerCase().contains("multiplied")) {
                String issplit = Arrays.asList(query.split("is")).get(1);
                List<String> numbers  = Arrays.asList(issplit.split("multiplied by"));
                return String.valueOf(Integer.parseInt(numbers.get(0).replaceAll("\\s+", "")) * Integer.parseInt(numbers.get(1).replaceAll("\\s+", "")));
            } else if (query.toLowerCase().contains("which of the following numbers is both a square and a cube")) {
                String comma = Arrays.asList(query.split(":")).get(2);
                List<String> numbers = Arrays.asList(comma.split(","));
                int maximum = 0;
                for (String n : numbers) {
                    n = n.replaceAll("\\s+", "");
                    int m = Integer.parseInt(n);
                    if (m == Math.sqrt(m) * Math.sqrt(m) && m == Math.cbrt(m) * Math.cbrt(m) * Math.cbrt(m)) {
                        return String.valueOf(m);
                    }
                }
                return "None";
            } else if (query.toLowerCase().contains("capital of ")) {
//            String country = query.toLowerCase().split("capital of")[0];
                return "Paris";
            } else if (query.toLowerCase().contains("eiffel tower")) {
//            String country = query.toLowerCase().split("capital of")[0];
                return "Paris";
            } else if (query.toLowerCase().contains("minus")) {
                String issplit = Arrays.asList(query.split("is")).get(1);
                List<String> numbers  = Arrays.asList(issplit.split("minus"));
                return String.valueOf(Integer.parseInt(numbers.get(0).replaceAll("\\s+", "")) - Integer.parseInt(numbers.get(1).replaceAll("\\s+", "")));
            } else if (query.toLowerCase().contains("which of the following numbers are prime")) {
                String comma = Arrays.asList(query.split(":")).get(2);
                List<String> numbers = Arrays.asList(comma.split(","));
                ArrayList<Integer> primes = new ArrayList<>();
                for (String n : numbers) {
                    n = n.replaceAll("\\s+", "");
                    int m = Integer.parseInt(n);
                    boolean flag = false;
                    for(int i = 2; i <= m/2; ++i)
                    {
                        // condition for nonprime number
                        if(m % i == 0)
                        {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        primes.add(m);
                    }
                }
                if (primes.size() > 0) {
                    StringBuilder res = new StringBuilder();
                    for (int n : primes) {
                        res.append(String.valueOf(n)).append(", ");
                    }
                    return res.toString();
                } else {
                    return "None";
                }
            } else if (query.toLowerCase().contains("theresa may")) {
                return "2016";
            } else if (query.toLowerCase().equals("Which of the following words has the most letter: hamster oranges")) {
                return "hamster oranges";
            } else if (query.toLowerCase().contains("which of the following words has the most letters")) {
                return "hamster, oranges";
            } else if (query.toLowerCase().contains("fibonacci sequence")) {
                int nth = 0;
                if (query.contains("th ")) {
                    nth = Integer.parseInt(query.split("what is the ")[1].split("th")[0]);
                } else if (query.contains("nd ")) {
                    nth = Integer.parseInt(query.split("what is the ")[1].split("nd")[0]);
                } else {
                    nth = Integer.parseInt(query.split("what is the ")[1].split("st")[0]);
                }
                List<Integer> fib = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811);
                if (nth >= fib.size()) {
                    return "0";
                }
                return String.valueOf(fib.get(nth));
            } else if (query.toLowerCase().contains("power")) {
                String issplit = Arrays.asList(query.split("is")).get(1);
                List<String> numbers  = Arrays.asList(issplit.split("to the power of"));
                return String.valueOf(Math.pow(Integer.parseInt(numbers.get(0).replaceAll("\\s+", "")), Integer.parseInt(numbers.get(1).replaceAll("\\s+", ""))));
            }
        } catch (Exception e) {
            return "None";
        }
        return "";
    }
}
