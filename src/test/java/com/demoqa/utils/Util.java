package com.demoqa.utils;

public class Util {

    public static boolean whatDoAcceptOrCancel(String message) { return (message.contains("aceptar")) ? true : (message.contains("cancelar") ? false : false);}

}
