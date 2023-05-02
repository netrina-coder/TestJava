package org.example;

public class Main {
    public static void main(String[] args) {new Main().run();}

    public void run() {
        Tabulate tab=new Tabulate();
        int step = tab.calculateStepCount(0.1, 1, 0.001);
        double[] xArray = tab.createXArray(0.1, 1, 0.001);
        double[] yArray = tab.createYArray(1.5,xArray);
        double sum = tab.calculateSum(yArray);
        System.out.println(sum);
        tab.printMaxElement(xArray,yArray);
        tab.printMinElement(xArray,yArray);
    }
}