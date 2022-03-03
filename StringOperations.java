package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperations {

    public static boolean ExpressionCheck(String expression) {
        return expression.matches("^-*\\d+\\/\\d+[-+:*]-*\\d+\\/\\d+");
    }

    public static String ExtractingTheSymbol(String expression) throws Exception {
        String Symbol;
        Pattern pattern = Pattern.compile("([0-9][-+:*]\\d)|([0-9][-+:*]-\\d)");
        Matcher matcher = pattern.matcher(expression);

        if (matcher.find()) {  //necessary for the piece of code to perform
            Symbol = matcher.group().substring(1, 2);
            return Symbol;
        }
        else {
            System.out.println("Invalid data. Please, try and enter an expression again.");
            throw new Exception();
        }
    }

    public static int IndexOfTheSymbol(String expression) throws Exception {
        String Symbol;
        int indexOfSymbol;
        int count = 0;

        if(expression.charAt(0) == '-'){  //if the first fraction starts with "-", remove the first "minus" symbol
            expression = expression.substring(1);
            count += 1;
        }

        Pattern pattern = Pattern.compile("([0-9][-+:*]\\d)|([0-9][-+:*]-\\d)");
        Matcher matcher = pattern.matcher(expression);


        if (matcher.find()) {  //necessary for the piece of code to perform correctly
            Symbol = matcher.group(0).substring(1, 2);
            indexOfSymbol = expression.indexOf(Symbol);
            if (count == 1) {
                return indexOfSymbol + 1;
            }
            else {
                return indexOfSymbol;
            }
        }

        else {
            System.out.println("Invalid data. Please, enter your expression again.");
            throw new Exception();
        }
    }
}
