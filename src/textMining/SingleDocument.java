/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package textMining;

import java.io.Serializable;
import java.util.StringTokenizer;
import java.util.Vector;


public class SingleDocument implements Serializable {

   public String docContent, docContentStem;
   public int wordCount;
   
   public Vector <MyToken> processedTokens;
   String delim = "\t\n\r\f .,;'()[]{}\"";
   
   public int ontologyIndex;
    public double coeff_Cosine;
     public double score;

    public SingleDocument(String docContent, int ontologyIndex) {
        this.docContent = docContent;
        this.docContentStem = docContent;
        processedTokens = new Vector<MyToken>();
        processedTokens = new Vector<MyToken>();        
        wordCount = 0;
        this.ontologyIndex = ontologyIndex;
        
    }
    
    public String getShortData(int maxLength) {
        if(docContent.length() > maxLength) {
            return docContent.substring(0, maxLength-1).trim();
        }
        return docContent.trim();
    }
    
    public void sortTokens() {
        for(int i=0;i<processedTokens.size()-1;i++) {
            for(int j=i+1;j<processedTokens.size();j++) {
                MyToken mt1 = processedTokens.get(i);
                MyToken mt2 = processedTokens.get(j);
                
                if(mt2.tf_idf > mt1.tf_idf) {
                    processedTokens.remove(j);
                    processedTokens.remove(i);
                    processedTokens.add(i,mt2);
                    processedTokens.add(j,mt1);
                }
            }
        }
    }
    
    public double getMaxTF() {
        double maxTF = 0;
        for(MyToken mt: processedTokens) {
            if(mt.tf > maxTF) {
                maxTF = mt.tf;
            }
        }
        return maxTF;
    }
    
    public void processDocument(Vector <String> filters) {
        processedTokens.clear();
        StringTokenizer st = new StringTokenizer(docContentStem.toLowerCase(), delim);
        wordCount = 0;
        
        while(st.hasMoreTokens()) {
            String token = st.nextToken().trim().toLowerCase();
            
            // maintain total word count
            if(!token.equals("")) {
                wordCount++;
            }
            
            boolean toFilter = false;
            for(String filter: filters) {
                if(filter.equalsIgnoreCase(token)) {
                    toFilter = true;
                    break;
                }
            }
            if(toFilter) {
                continue;
            }
            
            boolean found = false;
            for(MyToken mt: processedTokens) {
                if(mt.compareAndAdd(token)) {
                    found = true;
                    break;
                }
            }
            
            if(!found) {
                MyToken mt = new MyToken(token);
                processedTokens.add(mt);
            }
        }
    }
    
    public boolean containsToken(String data) {
        for(MyToken token: processedTokens) {
            if(token.data.equalsIgnoreCase(data)) {
                return true;
            }
        }
        return false;
    }
}
