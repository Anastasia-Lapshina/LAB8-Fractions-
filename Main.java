package com.company;

import java.util.Scanner;

import static com.company.Fraction.*;

public class Main {

    public static Fraction FirstFraction;
    public static Fraction SecondFraction;


    public static void main(String[] args) throws Exception {
        String Expression;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a mathematical expression with two fractions: ");
        Expression = scanner.next();

        if(ExpressionCheck(Expression)){
            FirstFraction = new Fraction(Expression.substring(0,IndexOfTheSymbol(Expression)));
            SecondFraction = new Fraction(Expression.substring(IndexOfTheSymbol(Expression)+1));

            switch (ExtractingTheSymbol(Expression)){
                case "+":
                    System.out.println("The result of addition is: "+ConvertingToString(FirstFraction.Addition(SecondFraction)));
                    break;

                case "-":
                    System.out.println("The result of subtraction is: "+ConvertingToString(FirstFraction.Subtraction(SecondFraction)));
                    break;

                case "*":
                    System.out.println("The result of multiplication is: "+ConvertingToString(Multiplication(FirstFraction, SecondFraction)));
                    break;

                case ":":
                    System.out.println("The result of division is: "+ConvertingToString(Division(FirstFraction, SecondFraction)));
                    break;

                default:
                    System.out.println("Invalid data. Try and enter the proper expression again.");
                    break;
            }
        }

        else {
            System.out.println("Invalid data. Please, try and enter an expression again.");
            throw new Exception();
        }

    }
}