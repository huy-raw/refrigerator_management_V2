/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se150324_lab1.utils;

/**
 *
 * @author HuyRaw
 */
public class Message {

    public static final String MSG_MUST_GREATER_THAN_ZERO = "Error: the number you entered must be greater than 0!";
    public static final String MSG_INPUT_ID = "Enter dish ID (eg A200, N199):";
    public static final String MSG_INPUT_NAME = "Enter the name of the dish (eg: BanhMi, Xuc xich,...):";
    public static final String MSG_INPUT_WEIGHT = "Enter weight (eg: 1, 1.5...): ";
    public static final String MSG_INPUT_TYPE = "Enter the type of food (eg: fresh vegetable, cake,...):";
    public static final String MSG_INPUT_PLACE = "Please choose the place to store food : ";
    public static final String MSG_INPUT_EXPIRED_DATE = "Enter the expiration date of the food (eg 23/10/2020): ";

    public static final String ERROR_DUPLICATE_ID = "The ID you just entered already exists. Please re-enter it!";
    public static final String ERROR_WRONG_INPUT_ID = "Enter data format (eg A200, N199)!";
    public static final String ERROR_WRONG_INPUT_NAME = "Food  name can not null!";
    public static final String ERROR_WRONG_INPUT_DOUBLE = "Invalid data type (Weight needs to be greater than 0 )!";
    public static final String ERROR_WRONG_INPUT_DATE = "Please input date have format is dd/mm/YYYY";
    public static final String ERROR_WRONG_INPUT_TYPE = "Type food can not null!";
    public static final String ERROR_WRONG_INPUT_PLACE = "Type food can not null!";
    public static final String ERROR_WRONG_INPUT_NAME_TO_FIND = "Pls, enter food name you entered to find data!";

    public static final String MSG_ADD_SUCCESSFULLY = "Add data successfully!";
    public static final String MSG_ADD_SUCCESSFULLY_INFO = "The data you just entered is:";

    public static final String MSG_INPUT_FOOD_ID_TO_DELETE = "Enter food ID to delete: ";
    public static final String ERROR_FOOD_NOT_FOUND = "No food found, check the ID you just entered!";
    public static final String MSG_DELETE_FOOD_SUCCESSFULLY = "Food deleted successfully!";

    public static final String MSG_UPDATE_FOOD_SUCCESSFULLY = "Food updated successfully!";
    public static final String MSG_UPDATE_FOOD_FAILED = "Can't update food!";
    public static final String MSG_INFO_BEFORE_UPDATE = "The feed to be updated has been found, you can update the fields or press Enter to skip updating any fields!";
    public static final String MSG_INPUT_FOOD_ID_TO_UPDATE = "Enter the ID to update (eg A200, N999): ";

    public static final String MSG_DATA_AFTER_SORT = "Food list after sorting";

    public static final String MSG_INPU_FOOD_NAME_TO_FIND = "Enter the name of the food you are looking for:";
    public static final String ERROR_WRONG_INPUT_INT = "The number entered is not valid. Please enter an INTEGER ";

    public static final String REGEX_DOC_ID = "^[a-zA-Z]{1}\\d{3}$";
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String UI_DIV = "------------------------------------";
}
