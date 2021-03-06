package exceptions.polinom;

import java.util.Scanner;

public class Polynomial {

    private double[] coefficients;


    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficientStrs) {
        if (coefficientStrs == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        double[] coefficient = new double[coefficientStrs.length];
        try {
            for (int i = 0; i < coefficientStrs.length; i++) {
                coefficient[i] = Double.parseDouble(coefficientStrs[i]);
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
        }
        this.coefficients = coefficient;
    }

    public double evaluate(double x) {
        int n = coefficients.length - 1;
        double result = 0;
        for (int i = n; i >= 0; i--) {
            result += coefficients[i] * Math.pow(x, (double)n-i);
        }
        return result;
    }

    public double[] getCoefficients() {
        return coefficients;
    }
}
