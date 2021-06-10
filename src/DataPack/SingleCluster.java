/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPack;

import java.util.Vector;

/**
 *
 * @author PC 1
 */
public class SingleCluster {

    public Vector<SinglePoint> points;

    public SingleCluster() {
        points = new Vector<SinglePoint>();
    }
    
    public String toString() {
        String str = "";
        str = "CLUSTER DETAILS: ";
        for(SinglePoint sp: points) {
            str += "" + sp.data[0] + " ";
        }
        str += "\n";
        return str;
    }

    public double getMin() {
        double min = points.get(0).data[0];
        for (SinglePoint sp : points) {
            if (min > sp.data[0]) {
                min = sp.data[0];
            }
        }
        return min;
    }
    
    public int getMinPointIndex() {
        int minIndex = -1;
        double minDist = 0;
        
        for (int i=0;i<points.size();i++) {
            SinglePoint sp = points.get(i);
            double dist = sp.getDistFromOrigin();
            if(minIndex == -1) {
                minIndex = 0;
                minDist = dist;
            }else {
                if(minDist > dist) {
                    minDist = dist;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
    
    public int getMaxPointIndex() {
        int maxIndex = -1;
        double maxDist = 0;
        
        for (int i=0;i<points.size();i++) {
            SinglePoint sp = points.get(i);
            double dist = sp.getDistFromOrigin();
            if(maxIndex == -1) {
                maxIndex = 0;
                maxDist = dist;
            }else {
                if(maxDist < dist) {
                    maxDist = dist;
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }    
    
    public double getMinDistanceBetweenAnyTwoPoints() {
        double minDist = -1;
        for (int i=0;i<points.size()-1;i++) {
            SinglePoint sp1 = points.get(i);
            for (int j=i+1;j<points.size();j++) {
                SinglePoint sp2 = points.get(j);
                double dist = sp1.getDistFrom(sp2);
                if(minDist==-1 && dist!=0) {
                    minDist = dist;
                }else {
                    if(minDist > dist && dist!=0) {
                        minDist = dist;
                    }
                }
            }
        }
        return minDist;
    }     
    

    public double getMax() {
        double max = points.get(0).data[0];
        for (SinglePoint sp : points) {
            if (max < sp.data[0]) {
                max = sp.data[0];
            }
        }
        return max;
    }

    public double getMeanCentroid() {

        double sum = 0;
        //System.out.println("All Points Size:  "+points.size());
        for (SinglePoint sp : points) {
            sum += sp.data[0];
        }
        return (sum / points.size());
    }
}
