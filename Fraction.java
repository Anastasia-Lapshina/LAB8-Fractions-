package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fraction {

    public int numerator;
    public int denominator;


    public Fraction(int num, int denomin) { //creating a fraction
        this.numerator = num;
        this.denominator = denomin;
        FractionReduction();
    }

    public Fraction(String Fraction) {
        int numerator;
        int denominator;
        String slash = "/";

        int indexOfDash = Fraction.indexOf(slash);  //finding the index of the dash in the Fraction
        String numeratorString = Fraction.substring(0, indexOfDash);
        String denominatorString = Fraction.substring(indexOfDash + 1);
        numerator = Integer.parseInt(numeratorString);
        denominator = Integer.parseInt(denominatorString);

        this.numerator = numerator;
        this.denominator = denominator;
        FractionReduction();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }


    public int GreatestCommonDivisor(int numerator, int denominator) {
        if (numerator % denominator == 0) { //if numerator is divisible by the given denominator, return denominator
            return denominator;
        }
        if (denominator % numerator == 0) { //else return numerator
            return numerator;
        }
        return GreatestCommonDivisor(denominator, numerator % denominator); //or call the function again (recursion)
    }


    void FractionReduction() { //this method reduces the given fraction to its lowest form possible
        int greatestCommonDivisor = GreatestCommonDivisor(numerator, denominator);
        numerator /= greatestCommonDivisor;
        denominator /= greatestCommonDivisor;
    }


    public Fraction Addition(Fraction SecondFraction) { //method for adding two fractions
        int newNumerator = (numerator * SecondFraction.getDenominator()) +
                (SecondFraction.getNumerator() * denominator);
        int newDenominator = denominator * SecondFraction.getDenominator();

        return new Fraction(newNumerator, newDenominator); //using the method for building a fraction
    }


    public Fraction Subtraction(Fraction SecondFraction) {
        int newNumerator = (numerator * SecondFraction.denominator) -
                (SecondFraction.numerator * denominator);
        int newDenominator = denominator * SecondFraction.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction Multiplication(Fraction SecondFraction) {
        int newNumerator = numerator * SecondFraction.numerator;
        int newDenominator = denominator * SecondFraction.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction Division(Fraction SecondFraction) {
        int newNumerator = numerator * SecondFraction.getDenominator();
        int newDenominator = denominator * SecondFraction.numerator;

        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction Addition(Fraction FirstFraction, Fraction SecondFraction) {
        int newNumerator = FirstFraction.getNumerator() * SecondFraction.getDenominator() + SecondFraction.getNumerator() * FirstFraction.getDenominator();
        int newDenominator = FirstFraction.getDenominator() * SecondFraction.getDenominator();

        return new Fraction(newNumerator, newDenominator);

    }

    public static Fraction Subtraction(Fraction FirstFraction, Fraction SecondFraction) {
        int numerator = FirstFraction.getNumerator() * SecondFraction.getDenominator() - SecondFraction.getNumerator() * FirstFraction.getDenominator();
        int denominator = FirstFraction.getDenominator() * SecondFraction.getDenominator();

        return new Fraction(numerator, denominator);
    }

    public static Fraction Multiplication(Fraction FirstFraction, Fraction SecondFraction) {
        int numerator = FirstFraction.getNumerator() * SecondFraction.getNumerator();
        int denominator = FirstFraction.getDenominator() * SecondFraction.getDenominator();

        return new Fraction(numerator, denominator);
    }

    public static Fraction Division(Fraction FirstFraction, Fraction SecondFraction) {
        int numerator = FirstFraction.getNumerator() * SecondFraction.getDenominator();
        int denominator = FirstFraction.getDenominator() * SecondFraction.getNumerator();

        return new Fraction(numerator, denominator);
    }

    public static Fraction SimplestFraction() {
        int numerator = 1;
        int denominator = 1;

        return new Fraction(numerator, denominator);
    }

    public static String ConvertingToString(Fraction OurFraction) { //method for converting Fractions into String
        int numerator = OurFraction.getNumerator();
        int denominator = OurFraction.getDenominator();

        String result;
        result = numerator + "/" + denominator;
        return result;
    }

    public static boolean ExpressionCheck(String expression) {
        return expression.matches("^\\d+/\\d+[-+:*]\\d+/\\d+|^-\\d+/\\d+[-+:*]\\d+/\\d+");
    }

    public static String ExtractingTheSymbol(String expression) throws Exception {
        String Symbol;
        Pattern pattern = Pattern.compile("\\d+[-+:*]\\d+");
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

        Pattern pattern = Pattern.compile("\\d+[-+:*]\\d+");
        Matcher matcher = pattern.matcher(expression);

        if (matcher.find()) {  //necessary for the piece of code to perform correctly
            Symbol = matcher.group().substring(1, 2);
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