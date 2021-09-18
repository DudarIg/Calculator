package ru.dudar.calculator;

public class Calc {
    private float decimal1; // первое число
    private float decimal2; // второе число
    private float result; // результат
    private String action; // операция
    private int indexAction; // индекс знака операции в calculat
    private String calculat; // строка калькулятора для вывода на экран

    public Calc() {
        this.decimal1 = 0.0f;
        this.decimal2 = 0.0f;
        this.result = 0.0f;
        this.action = "";
        this.indexAction = 0;
        this.calculat = "";
    }

    public void setAction() {
        this.action = "";
    }

    public void setIndexAction() {
        this.indexAction = 0;
    }

    public void setCalculat() {
        this.calculat = "";
    }

    public void addSign(String sign) {
        calculat += sign;

    }

    public String getCalculat() {
        return calculat;
    }
}
