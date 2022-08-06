package com.ironhack.bootcamp.exercises.s2;

public class StringChallenge {

    /**
     * executor
     * @param n is not use in this case.
     */
    public void execute(int n) {
        if (productFormatter("   My awesome product   ", "17-05-2003").length() > 10) {
            System.out.println("Cadena demasiado larga");
        }
    }

    /**
     * receives a String name productName and a String date as parameters. This method should return the productName
     * trimmed, change spaces by _, append the date at the end of the string and return the formatted product all
     * uppercase.
     * @param productName Name of your product
     * @param date the Date suffix
     * @return String with the desired product formatted.
     */
    private static String productFormatter(String productName, String date) {
        // Implement this method
        /*String productAndDate = productName.concat(date);
        String productTrimmed = productAndDate.trim();
        String productReplaced = productTrimmed.replace(" ", "_");
        String productUpper = productReplaced.toUpperCase();
        return productUpper; */

        String result = productName.trim().concat(" ").concat(date).replace(" ", "_").toUpperCase();
        return result;

    }
}

