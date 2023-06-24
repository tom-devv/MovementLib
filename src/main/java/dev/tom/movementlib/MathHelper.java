package dev.tom.movementlib;

public class MathHelper {

    public static void QuadraticEquationSolver(double x1, double y1, double x2, double y2){
        double x1Squared = x1 * x1;
        double x2Squared = x2 * x2;

        // Calculate the coefficients of the quadratic equation
        double a = (y2 - y1) / ((x2 - x1) * (x2 - x1));
        double b = -2 * a * x1;
        double c = y1 - (a * x1 * x1) - (b * x1);

        System.out.println("The quadratic equation is: y = " + a + "x^2 + " + b + "x + " + c);


    }

}
