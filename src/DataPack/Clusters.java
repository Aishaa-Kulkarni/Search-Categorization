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
public class Clusters {
    
    public  Vector<SingleCluster> clusterList;
    public  SingleCluster outliers;
    public  SingleCluster originalPoints;
    public double d;

    public Clusters() {
        clusterList = new Vector<SingleCluster>();
        outliers = new SingleCluster();
        originalPoints = new SingleCluster();
        d = 0;
    }
    
    public int getLength() {
        return originalPoints.points.size();
    }
}
