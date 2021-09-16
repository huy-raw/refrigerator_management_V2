/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se150324_lab1.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author HuyRaw
 */
public class Utils {

    private static Scanner sc;

    //get ID with form 
    public static String getID(String inputMsg, String errorMsg, String format) {
        sc = new Scanner(System.in);
        String id;

        boolean match;
        while (true) {
            System.out.print(inputMsg);

            id = sc.nextLine().trim().toLowerCase();

            match = id.matches(format);
            if (match == false) {
                System.out.println(errorMsg);
            } else {
                return id.toUpperCase();
            }
        }
    }

    //get double
    public static double getADouble(String inputMsg, String errorMsg) {
        sc = new Scanner(System.in);
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < 0) {
                    System.out.println(Message.MSG_MUST_GREATER_THAN_ZERO);
                } else {
                    return n;
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getOption(String inputMsg, String errorMsg) {
        sc = new Scanner(System.in);
        int choose;
        System.out.println("Choose the place to store th food!!");
        System.out.println("1 -> Freezer compartment");
        System.out.println("2 -> Cooler compartment 1");
        System.out.println("3 -> Cooler compartment 2");
        while (true) {
            try {
                System.out.print(inputMsg);
                choose = Integer.parseInt(sc.nextLine());
                if (choose <= 0 || choose > 3) {
                    System.out.println(Message.MSG_MUST_GREATER_THAN_ZERO);
                } else {
                    return choose;
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }

        }
    }

    //get string
    public static String getString(String inputMsg, String errorMsg) {
        sc = new Scanner(System.in);
        String string;
        while (true) {
            System.out.print(inputMsg);
            string = sc.nextLine();
            if (string.length() == 0) {
                System.out.println(errorMsg);
            } else {
                
                return string;
            }
        }
       
    }

    //get date
    public static Date getDate(String inputMsg, String errorMsg) {
        Date date;
        Date currentDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat(Message.DATE_FORMAT);
        format.setLenient(false); // auto plus date
        sc = new Scanner(System.in);
        do {
            System.out.println(inputMsg);
            String sDate = sc.nextLine();
            try {
                date = format.parse(sDate);
                if (date.compareTo(currentDate) > 0) {
                    return date;
                } else {
                    System.out.println("Expired date must be greater than current date");
                }

            } catch (ParseException e) {
                System.out.println(errorMsg);
            }
        } while (true);

    }

    //yes/no option
    public static boolean chooseOption(String inputMsg) {
        String s;
        sc = new Scanner(System.in);

        do {
            System.out.println(inputMsg);
            System.out.println("Y/y = YES || N/n = NO");
            s = sc.nextLine();
            if (s.equalsIgnoreCase("y") == true) {
                return true;
            } else if (s.equalsIgnoreCase("n") == true) {
                return false;
            } else {
                System.out.println("Please input Y/y or N/n to choose");
            }
        } while (true);
    }

    //Menu
    public static void printManageMenu() {
        System.out.println(Message.UI_DIV);
        System.out.println("--Welcome to the Refrigerator Management System--");
        System.out.println(Message.UI_DIV);
        System.out.println("1 - Add a new food");
        System.out.println("2 - Search a food by name");
        System.out.println("3 - Remove the food by ID");
        System.out.println("4 - Print the food list in the descending order of expired date");
        System.out.println("5 - Save to file");
        System.out.println("6 - Exit");

    }

    public static void main(String[] args) {
        Date date = new Date();
        Date  test = getDate("Nhap ngay", "Loi");
        

    }

}
