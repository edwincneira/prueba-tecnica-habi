package com.demoqa.utils;

import java.util.GregorianCalendar;
import static com.demoqa.utils.VariablesGlobals.day;
import static com.demoqa.utils.VariablesGlobals.year;
import static com.demoqa.utils.VariablesGlobals.month;
import static com.demoqa.utils.VariablesGlobals.numberDay;
import static com.demoqa.utils.VariablesGlobals.numberWeek;

public class DayOfMonth {

    //Clase para identificar desde que xpath de la semana inciar dependiendo de la fecha ingresada en la historia de usuario
    // xpath = //div[@class='react-datepicker__month']//child::div[ITEM_TO_CHANGE]
    public static int getDayItem() {
        String dateName = new GregorianCalendar(year, month - 1, 1).getTime().toString().substring(0, 3);
        switch (dateName) {
            case "Sun":
                return 1;
            case "Mon":
                return 2;
            case "Tue":
                return 3;
            case "Wed":
                return 4;
            case "Thu":
                return 5;
            case "Fri":
                return 6;
            case "Sat":
                return 7;
            default: return 0;
        }
    }

    /*
    * Programa basico para identificar que numero de semana y numero de día dependiendo desde el numero de dia que incia el mes
    * //div[@class='react-datepicker__month']//child::div[NUMERODESEMANA]//child::div[NUMERODEDIA_1_7]
    * */

    public static void calculateWeekAndDay(int numberInitDay) {
        int dayNumber = 0;
        int weekNumber = 1;
        int count = 0;
        for (int i=numberInitDay - 1; i<=7; i++) {
            count++;
            if(i==7) {
                weekNumber++;
                i=0;
            }
            if(count == day) {
                dayNumber = i + 1;
                break;
            }
        }
        numberDay = dayNumber;
        numberWeek = weekNumber;
    }
}
