//package org.miage;
//
//import java.text.ParseException;
//import java.util.Scanner;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        InterfaceRPNParser parser = new RPNParser();
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("RPN Calc");
//        System.out.println("Type '.exit' at any time to quit");
//
//        while (true) {
//            System.out.println("Input a RPN expression");
//            System.out.print("-> ");
//
//            String input = scanner.nextLine().trim();
//
//            if (input.equals(".exit")) {
//                break;
//            }
//
//            try {
//                double result = parser.parseAndDisplayResult(input);
//                System.out.println(result);
//            } catch (NotEnoughOperandsOnStackException e) {
//                System.out.println("Not enough operands, Try again or type '.exit' to quit");
//            } catch (DivideByZeroException e) {
//                System.out.println("Divide by zero, Try again or type '.exit' to quit");
//            } catch (ParseException e) {
//                System.out.println("Invalid Expression, Try again or type '.exit' to quit");
//            }
//        }
//
//        scanner.close();
//    }
//}