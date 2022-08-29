package com.demoqa.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.demoqa.utils.Contain.getElementText;
import static com.demoqa.utils.VariablesGlobals.rowItemIsPerson;
import static com.demoqa.utils.VariablesConst.NUMBER_OF_COLUMNS_WEB_TABLES;

// Clase para determinar si los datos de las personas que se ingresaron estan en la tabla y así poder eliminar a esa persona en la seccion web tables
public class IsPerson {

    private static List<String> list_data_persons_registers = new ArrayList<>();
    private static String _value = "";
    private static String xpath = "//div[@class='rt-tbody']//child::div[%s]//div//child::*[%s]";

    public static boolean here(Actor actor, String name, String lastName, String email) {
        list_data_persons_registers.add("1");
        for (int i=1; i<20; i++) {
            for (int j=1; j<NUMBER_OF_COLUMNS_WEB_TABLES; j++) {
                Target target = Target.the("names identifier").located(By.xpath(String.format(xpath, String.valueOf(i), String.valueOf(j))));
                _value = getElementText(target, actor);
                if(_value.equals(" ")) break;
                list_data_persons_registers.add(_value);
            }
            if(_value.equals(" ")) break;
            list_data_persons_registers.add(String.valueOf(i + 1));
        }
        if(list_data_persons_registers.contains(name) && list_data_persons_registers.contains(lastName) && list_data_persons_registers.contains(email)) {
            rowItemIsPerson = Integer.parseInt(list_data_persons_registers.get(list_data_persons_registers.lastIndexOf(name) - 1));
            return true;
        } else{
            return false;
        }
    }

}
