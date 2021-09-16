/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se150324_lab1.data;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import se150324_lab1.utils.Message;

/**
 *
 * @author HuyRaw
 */
public class Food implements Comparable<Food>{
    private String ID;
    private String name;
    private double weight;
    private String type;
    private String place;
    private Date expiredDate;
    

    public Food() {
    }

    public Food(String ID, String name, double weight, String type, String place, Date expiredDate) {
        this.ID = ID;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public int compareTo(Food o) {
       return this.getExpiredDate().compareTo(o.getExpiredDate());
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat(Message.DATE_FORMAT);
        return String.format("|%10s|%20s|%11.1f|%20s|%25s|%20s|", ID, name, weight,
                type, place, dateFormat.format(expiredDate));
    }
    
    
    

    
    
    

    
}
