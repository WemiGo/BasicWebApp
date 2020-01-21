package com.develogical;

import java.util.Arrays;
import java.util.List;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().isEmpty()) {
            return "Woah there! Looks like you've submitted an empty string... That's not great! " +
                    "You should really get that looked at";
        } else if (query.toLowerCase().contains("remi")) {
            return "Heeyy you guessed who I was... That's great for you, not for me!";
        } else if (query.toLowerCase().contains("team name")) {
            return "Entity";
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
            return String.valueOf(Integer.parseInt(numbers.get(0).replaceAll("\\s+", "")) + Integer.parseInt(numbers.get(1).replaceAll("\\s+", "")));
        } else if (query.toLowerCase().contains("multiplied")) {
            String issplit = Arrays.asList(query.split("is")).get(1);
            List<String> numbers  = Arrays.asList(issplit.split("multiplied by"));
            return String.valueOf(Integer.parseInt(numbers.get(0).replaceAll("\\s+", "")) * Integer.parseInt(numbers.get(1).replaceAll("\\s+", "")));
        }
        return "";
    }
}
