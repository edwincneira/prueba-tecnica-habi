package com.demoqa.utils;

import static com.demoqa.utils.VariablesGlobals.*;

public class ClearDate {

    private static String date;

    public ClearDate(String date) {
        this.date = date;
    }

    public static int getDay() { return Integer.parseInt(date.substring(3, 5)); }
    public static int getMonth() { return Integer.parseInt(date.substring(0, 2)); }
    public static int getYear() { return Integer.parseInt(date.substring(6, 10)); }
    public static String getHour() { return (date.length() > 10) ? date.substring(12, 16) : ""; }

    public static void setDate() {
        day = getDay();
        month = getMonth();
        year = getYear();
        hour = getHour();
    }
}
