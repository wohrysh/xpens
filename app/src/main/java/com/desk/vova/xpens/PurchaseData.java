package com.desk.vova.xpens;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.desk.vova.xpens.PurchaseType.ENTERTAINMENT;
import static com.desk.vova.xpens.PurchaseType.FOOD;
import static com.desk.vova.xpens.PurchaseType.GIFTS;
import static com.desk.vova.xpens.PurchaseType.HOUSE;
import static com.desk.vova.xpens.PurchaseType.KIDS;
import static com.desk.vova.xpens.PurchaseType.OTHER;
import static com.desk.vova.xpens.PurchaseType.STUDY;

/**
 * Created by vova on 04/11/2016.
 */
enum PurchaseType {FOOD, ENTERTAINMENT, KIDS, HOUSE, STUDY, GIFTS, OTHER};

public class PurchaseData {

    private final long id;
    private Date date;
    private PurchaseType type;
    private String description;
    private int price;

    PurchaseData(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PurchaseType getType() {
        return type;
    }

    public void setType(PurchaseType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String getTypeString() {
        switch (this.type) {
            case FOOD:
                return "Food";
            case ENTERTAINMENT:
                return "Entertainment";
            case KIDS:
                return "Kids";
            case HOUSE:
                return "House";
            case STUDY:
                return "Study";

            case GIFTS:
                return "Gifts";
            default:
                return "Other";
        }
    }
    public String getDateString(Context context) {
        String              date_format_string  = context.getString(R.string.PURCHASE_DATE_FORMAT) ;
        SimpleDateFormat    date_format         = new SimpleDateFormat(date_format_string)              ;
        return date_format.format(this.getDate());
    }

    //parses the date entry from string. Throws exception if the given string is not of proper format
    public void setDateFromStr(Context context, String dateStr) throws ParseException {
        String              date_format_string  = context.getString(R.string.PURCHASE_DATE_FORMAT)      ;
        SimpleDateFormat    date_format         = new SimpleDateFormat(date_format_string)                              ;
        this.date = date_format.parse(dateStr);
    }

    //parses the purchase type from string. Returns false if the given string is not of proper format
    public Boolean setTypeFromStr(String purchase_type_string) {
        if(purchase_type_string.equals("Food")) {
            type = FOOD;
        }
        else if(purchase_type_string.equals("Entertainment")) {
            type = ENTERTAINMENT;
        }
        else if(purchase_type_string.equals("Kids")) {
            type = KIDS;
        }
        else if(purchase_type_string.equals("House")) {
            type = HOUSE;
        }

        else if(purchase_type_string.equals("Study")) {
            type = STUDY;
        }
        else if(purchase_type_string.equals("Gifts")) {
            type = GIFTS;
        }
        else if(purchase_type_string.equals("Other")) {
            type = OTHER;
        } else {
            return false;
        }
        return true;
    }
}
