package com.thejavacademy.companie.calculator;

public enum CalculatorTaxeEnum implements ICalculatorTaxe {

    CALCULATOR_GENERAL(0.16),
    CALCULATOR_IT(0.10),
    CALCULATOR_CONSTRUCTII(0.5);

    double procentTaxa;

    CalculatorTaxeEnum(double procentTaxa) {
        this.procentTaxa = procentTaxa;
    }

    public double calculeazaTaxa(double suma) {
        return suma * procentTaxa;
    }

}
