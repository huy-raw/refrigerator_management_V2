/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se150324_lab1.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import java.util.Scanner;
import se150324_lab1.utils.Message;
import se150324_lab1.utils.Utils;

/**
 *
 * @author HuyRaw
 */
public class FoodManagement {

    private Scanner sc;
    private ArrayList<Food> foodList = new ArrayList();

    public FoodManagement() {
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    public void createFood() {

        String _name, _id, _type, _place;
        double _weight;
        Date _expiredDate;
        int _getOptionPlace, pos; // position in array 

        do {
            _id = Utils.getID(Message.MSG_INPUT_ID, Message.ERROR_WRONG_INPUT_ID, Message.REGEX_DOC_ID);
            pos = checkIDAvailable(_id);
            if (pos > 0) {
                System.out.println(Message.ERROR_DUPLICATE_ID);
            }
        } while (pos != -1);

        _name = Utils.getString(Message.MSG_INPUT_NAME, Message.ERROR_WRONG_INPUT_NAME);
        _weight = Utils.getADouble(Message.MSG_INPUT_WEIGHT, Message.ERROR_WRONG_INPUT_DOUBLE);
        _type = Utils.getString(Message.MSG_INPUT_TYPE, Message.ERROR_WRONG_INPUT_TYPE);
        _getOptionPlace = Utils.getOption(Message.MSG_INPUT_PLACE, Message.ERROR_WRONG_INPUT_PLACE);
        switch (_getOptionPlace) {
            case 1 ->
                _place = "Freezer compartment";
            case 2 ->
                _place = "Cooler compartment 1";
            case 3 ->
                _place = "Cooler compartment 2";

            default -> {
                System.out.println("Your option unvalid!!");
                _place = "Unknown";
            }
        }
        _expiredDate = Utils.getDate(Message.MSG_INPUT_EXPIRED_DATE, Message.ERROR_WRONG_INPUT_DATE);

        Food food = new Food(_id, _name, _weight, _type, _place, _expiredDate);
        foodList.add(food);
        System.out.println(Message.MSG_ADD_SUCCESSFULLY);
        if (Utils.chooseOption("Do you wanna input another food?")) {

            this.createFood();
        }

    }

    public void deleteFood() {
        String ID;

        ID = Utils.getID(Message.MSG_INPUT_FOOD_ID_TO_DELETE, Message.ERROR_WRONG_INPUT_ID, Message.REGEX_DOC_ID);
        System.out.println(Message.UI_DIV);
        for (Food food : foodList) {
            if (food.getID().equalsIgnoreCase(ID)) {
                if (Utils.chooseOption("Food to be deleted has been found. Do you really want to delete it??")) {
                    System.out.println("The food have ID:" + ID);
                    if (delete(ID)) {
                        System.out.println(Message.MSG_DELETE_FOOD_SUCCESSFULLY);
                    } else {
                        System.out.println(Message.ERROR_FOOD_NOT_FOUND);
                    }
                    break;
                } 
            }
        }

    }

    private boolean delete(String id) {
        return foodList.removeIf(food -> {
            boolean isMatch = food.getID().equalsIgnoreCase(id);
            return isMatch;
        });

    }

    //check ID exist
    private int checkIDAvailable(String ID) {
        if (foodList == null) {
            return -1;
        } else {
            for (Food food : foodList) {
                if (food.getID().equalsIgnoreCase(ID)) {
                    return 1;
                }
            }
        }
        return -1;
    }

    //search food by name
    public void listFoodByname() {
        sc = new Scanner(System.in);
        ArrayList<Food> tempFoodList = new ArrayList();

        String strName = Utils.getString(Message.MSG_INPU_FOOD_NAME_TO_FIND, Message.ERROR_WRONG_INPUT_NAME_TO_FIND);
        foodList.forEach(food -> {
            if (food.getName().contains(strName)) {
                tempFoodList.add(food);
            }
        });

        if (!tempFoodList.isEmpty()) {
            for (Food food : tempFoodList) {
                System.out.println(food.toString());
            }
        } else {
            System.out.println("No data match");
        }

        if (Utils.chooseOption("Do you wana find another food ?")) {
            this.listFoodByname();
        }
    }

    //comparison
    public void Comparison() {
        Collections.sort(foodList);
        System.out.println(Message.MSG_DATA_AFTER_SORT);
        display();

    }

    public void display() {
        System.out.println(String.format("|%10s|%20s|%11s|%20s|%25s|%20s|", "ID", "NAME", "WEIGHT(kg)",
                "TYPE", "PLACE", "EXPRIDED DATE"));
        foodList.forEach(food -> {
            System.out.println(food.toString());
        });
    }

    //save to File
    public void saveToFile(String fName) {
        try {
            File f = new File(fName);
            if (!f.exists()) {
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Food food : foodList) {
                    bw.newLine();
                    fw.write(food.toString());
                }
                System.out.println("Added succesfully!!");
                bw.close();
                fw.close();
            }
        } catch (IOException e) {
            System.out.println("Error!!");
        }

    }

}
