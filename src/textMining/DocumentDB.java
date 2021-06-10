/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package textMining;

import java.io.Serializable;
import java.util.Vector;


public class DocumentDB implements Serializable {

    public Vector<SingleDocument> list;
    public Vector<String> filters;
    public DocumentDB() {
        list = new Vector<SingleDocument>();
        filters = new Vector<String>();
        loadForm();
    }

    private void loadForm() {
        ;
    }

    public int noOfDocumentsContaining(String token) {
        int count = 0;
        for (SingleDocument sd : list) {
            if (sd.containsToken(token)) {
                count++;
            }
        }
        return count;
    }

    public void addFilter(String keyword) {
        keyword = keyword.trim().toLowerCase();
        for (String existingKeyword : filters) {
            if (existingKeyword.equals(keyword)) {
                return;
            }
        }
        filters.add(keyword);
    }
}
