package com.develogical;

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
        }
        return "";
    }
}
