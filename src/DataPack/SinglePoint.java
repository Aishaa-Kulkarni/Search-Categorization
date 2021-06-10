/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPack;

/**
 *
 * @author PC 1
 */
public class SinglePoint {

    // public int dimenstion;
    public double data[];

    public SinglePoint(int totalDimensions) {
        data = new double[totalDimensions];
    }

    public double getDistFromOrigin() {
        double dist = 0;
        SinglePoint sp = new SinglePoint(1);
        sp.data[0] = 0;

        for (int i = 0; i < 1; i++) {
            dist += Math.pow((data[i] - sp.data[i]), 2);
        }
        return Math.sqrt(dist);
    }

    public double getDistFrom(SinglePoint sp) {
        double dist = 0;
        for (int i = 0; i < 1; i++) {
            dist += Math.pow((data[i] - sp.data[i]), 2);
        }
        return Math.sqrt(dist);
    }

    public double getDiff(double mean) {
        double dist = 0;
        dist = Math.pow((data[0] - mean), 2);
        return Math.sqrt(dist);
    }

    public String toString() {
        String str = "Point Data: (" + data[0] + ") ";
        return str;
    }
}
