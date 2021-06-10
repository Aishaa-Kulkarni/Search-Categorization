/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package textMining;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class MyToken implements Serializable {

    public String data;
    public int occurance;
    public double tf;
    public double idf;
    public double tf_idf;

    public MyToken(String data) {
        this.data = data.trim();
        occurance = 1;
        tf = 0;
        idf = 0;
        tf_idf = 0;
    }

    public boolean compareAndAdd(String newData) {
        if (data.compareToIgnoreCase(newData.trim()) == 0) {
            occurance++;
            return true;
        }
        return false;
    }
}
