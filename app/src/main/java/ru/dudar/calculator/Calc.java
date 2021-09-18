package ru.dudar.calculator;

public class Calc {
    private float decimal1; // первое число
    private float decimal2; // второе число
    private float result; // результат
    private String action; // операция
    private int indexAction; // индекс знака операции в calculat
    private String calculat; // строка калькулятора для вывода на экран
    private int countPoint; // количество точек в числе

    public Calc() {
        this.decimal1 = 0.0f;
        this.decimal2 = 0.0f;
        this.result = 0.0f;
        this.action = "";
        this.indexAction = 0;
        this.calculat = "";
        this.countPoint = 0;
    }

    public void setCountPoint(int countPoint) {
        this.countPoint = countPoint;
    }

    public void setDecimal1(float decimal1) {
        this.decimal1 = decimal1;
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

    public float runResult() {
        decimal1 = Float.parseFloat(calculat.substring(0, indexAction));
        decimal2 = Float.parseFloat(calculat.substring(indexAction + 1));
        switch (action) {
            case "+": {
                result = decimal1 + decimal2;
                break;
            }
            case "-": {
                result = decimal1 - decimal2;
                break;
            }
            case "*": {
                result = decimal1 * decimal2;
                break;
            }
            case "/": {
                result = decimal1 / decimal2;
                break;
            }
            default:
                break;

        }
        return result;
    }

}
