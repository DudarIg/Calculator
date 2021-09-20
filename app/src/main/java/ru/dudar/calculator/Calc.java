package ru.dudar.calculator;

import java.io.Serializable;

public class Calc implements Serializable {
    private String action; // операция
    private int indexAction; // индекс знака операции в calculat
    private String calculat; // строка калькулятора для вывода на экран
    private int countPoint; // количество точек в числе

    public Calc() {
        this.action = "";
        this.indexAction = 0;
        this.calculat = "";
        this.countPoint = 0;
    }

    public void setCountPoint(int countPoint) {
        this.countPoint = countPoint;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setIndexAction(int indexAction) {
        this.indexAction = indexAction;
    }

    public void setCalculat(String calculat) {
        this.calculat = calculat;
    }

    public void addSign(String sign) {
        calculat += sign;
    }

    public int getCountPoint() {
        return countPoint;
    }

    public String getCalculat() {
        return calculat;
    }

    public int getIndexAction() {
        return indexAction;
    }

    public String runResult() {

        if (indexAction == 0) {
            return "";
        }
        String val1 = calculat.substring(0, indexAction);
        String val2 = calculat.substring(indexAction + 1);

        if (val2.length() == 0 ) {
            return "Операция невозможна";
        }

        float decimal1 = Float.parseFloat(val1);
        float decimal2 = Float.parseFloat(val2);
        float resultFloat = 0.0F;

        switch (action) {
            case "+": {
                resultFloat = decimal1 + decimal2;
                break;
            }
            case "-": {
                resultFloat = decimal1 - decimal2;
                break;
            }
            case "*": {
                resultFloat = decimal1 * decimal2;
                break;
            }
            case "÷": {
                if (decimal2 != 0.0f) {
                    resultFloat = decimal1 / decimal2;
                }

                break;
            }
            default:
                break;

        }

        if (decimal2 != 0.0f) {
            return String.valueOf(resultFloat);
        } else {
            return "Деление на 0!!!";
        }

    }

}
