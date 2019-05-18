package com.thejavacademy.companie.calculator;

public enum CalculatorTaxe implements ICalculatorTaxe {

    CALCULATOR_GENERAL(0.16),
    CALCULATOR_IT(0.10),
    CALCULATOR_CONSTRUCTII(0.5);

    double procentTaxa;

    CalculatorTaxe(double procentTaxa) {
        this.procentTaxa = procentTaxa;
    }

    public static CalculatorTaxe getCalculator(Departament departament) {
        switch (departament) {
            case IT:
                return CALCULATOR_IT;
            case CONSTRUCTII:
                return CALCULATOR_CONSTRUCTII;
            default:
                return CALCULATOR_GENERAL;
        }
    }

    public double calculeazaTaxa(double suma) {
        return suma * procentTaxa;
    }

    public enum Departament {
        GENERAL, IT, CONSTRUCTII,
    }

}
