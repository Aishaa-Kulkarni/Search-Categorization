/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package textMining;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

public class IR_Cosine implements Serializable {

    SingleDocument pi;
    Stemmer ss;
    Vector<SingleDocument> vecSearchedDocuments;
    DocumentDB db;

    public IR_Cosine() {
        ss = new Stemmer();
        vecSearchedDocuments = new Vector<SingleDocument>();
        db = new DocumentDB();
        db.addFilter("is");
        db.addFilter("a");
        db.addFilter("at");
        db.addFilter("or");
        db.addFilter("not");
        db.addFilter("with");
        db.addFilter("it");
        db.addFilter("are");
        db.addFilter("get");
        db.addFilter("set");
        db.addFilter("an");
        db.addFilter("and");
        db.addFilter("does");
        db.addFilter("any");
        db.addFilter("too");
        db.addFilter("of");
        db.addFilter("has");
        db.addFilter("have");
        db.addFilter("as");
        db.addFilter("been");
        db.addFilter("the");
        db.addFilter("had");
        db.addFilter("for");
        db.addFilter("to");
        db.addFilter("on");
        db.addFilter("1");
        db.addFilter("2");
        db.addFilter("3");
        db.addFilter("4");
        db.addFilter("5");
        db.addFilter("6");
        db.addFilter("7");
        db.addFilter("8");
        db.addFilter("9");
        db.addFilter("0");

//        readFromDB();
        // process all documents on start up...    
    }

    double logBase2(double data) {
        return (Math.log10(data) / Math.log10(2));
    }

    public ArrayList<MyToken> ApplyTf(String stemWords) {
        ArrayList<MyToken> allTokens = new ArrayList<MyToken>();
        SingleDocument sdQuery = new SingleDocument("", 0);

        sdQuery.docContentStem = (stemWords).trim();
        //sdQuery.docContent = jTextQuery.getText();
        sdQuery.processDocument(db.filters);
        // tf only
        for (MyToken mt : sdQuery.processedTokens) {
            // calculate TF
            mt.tf = mt.occurance * 1. / sdQuery.wordCount;
//            System.out.println("word : "+mt.data+" TF : "+mt.tf);
            allTokens.add(mt);
//             System.out.println(mt.data+"  "+mt.occurance);
        }
        return allTokens;

    }

    public Vector<MyToken> ApplyCosine(String stemwords) {
        try {
            System.out.println("Inside Ir Cosine ...");
            // process query
            SingleDocument sdQuery = new SingleDocument("", 0);

            sdQuery.docContentStem = (stemwords).trim();
            //sdQuery.docContent = jTextQuery.getText();
            sdQuery.processDocument(db.filters);
            // tf only
            for (MyToken mt : sdQuery.processedTokens) {
                // calculate TF
                mt.tf = mt.occurance * 1. / sdQuery.wordCount;

            }
            double maxTF = sdQuery.getMaxTF();
            // calculate tf idf for query
            for (MyToken mt : sdQuery.processedTokens) {
                // normalize to values between 0 and 1 (for uneven sized documents)
                mt.tf = mt.tf / maxTF;

                // idf
                // add one for query document
                int totalDocuments = db.list.size() + 1;
                // 1 is added since the input query itself (which is to be considered as a document) contains the term at least once.
                int totalDocumentsContainingTerm = db.noOfDocumentsContaining(mt.data) + 1;
                System.out.println("word found in : "+totalDocumentsContainingTerm);
                mt.idf = logBase2(totalDocuments * 1. / totalDocumentsContainingTerm);

                // calculate TF-IDF
                mt.tf_idf = mt.tf * mt.idf;
            }
            sdQuery.sortTokens();
            //for printing....
            for (int i = 0; i < sdQuery.processedTokens.size(); i++) {
                System.out.println("word : " + sdQuery.processedTokens.elementAt(i).data + " TF : " + sdQuery.processedTokens.elementAt(i).tf+" IDF : "+sdQuery.processedTokens.elementAt(i).idf);
            }
            return sdQuery.processedTokens;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
