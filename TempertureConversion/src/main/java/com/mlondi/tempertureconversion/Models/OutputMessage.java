package com.mlondi.tempertureconversion.Models;

public class OutputMessage {

    public static String getKelvin(Double input){
        return input+" Kelvin = "+(Math.round((input - 273.15)*100.0)/100.0)+" Celsius";
    }

    public static String getCelsius(Double input){
        return input+" Celsius = "+(Math.round((input + 273.15)*100.0)/100.0)+" Kelvin";
    }

    public static String getKilometers(Double input){
        return input+" Mile(s) = "+(Math.round((input * 1.609)*100.0)/100.0)+" Kilometer(s)";
    }

    public static String getMiles(Double input){
        return input+" Kilometer(s) = "+(Math.round((input / 1.609)*100.0)/100.0)+" Mile(s)";
    }

}
