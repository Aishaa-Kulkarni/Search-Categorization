package searchPack;

import DataPack.Clusters;
import DataPack.SingleCluster;
import DataPack.SinglePoint;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import net.n3.nanoxml.*;
import textMining.IR_Cosine;
import textMining.MyToken;
import textMining.Stemmer;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Administrator
 */
public class Demo extends javax.swing.JFrame {

    Vector<SingleEntry> vec;
    ArrayList<SingleProcessedEntry> allProcessedEntry;
    Clusters clusterDB;
    long start_time, stop_time;

    public Demo() {
        initComponents();

        Dimension sd = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(sd.width / 2 - this.getWidth() / 2, sd.height / 2 - this.getHeight() / 2);

    }

    class MyDownloadTask extends TimerTask {

        @Override
        public void run() {
            jProgressBar1.setIndeterminate(true);
            vec = new Vector<SingleEntry>();
            int index_count = 1;
            for (int i = 1; i <=5; i++) {
                Vector<SingleEntry> current_vect = fetchResults(jTextSearch.getText(), jTextKey.getText(), index_count);
                index_count += 10;
                for (int j = 0; j < current_vect.size(); j++) {
                    vec.addElement(current_vect.elementAt(j));
                }
            }
            String result = "";
            if (vec.size() == 0) {
                result = "ERROR FETCHING RESULTS";
            } else {
                result = "TOATL RESULTS FETCHED: " + vec.size() + "\n";
                for (SingleEntry se : vec) {
                    result += "ID : " + se.id + "\n";
                    result += "TITLE : " + se.title + "\n";
                    result += "SUMMARY : " + se.summary + "\n";
                    result += "LINK : " + se.link + "\n";
                    result += "\n\n";
                }
            }
            jTextArea1.setText(result);
            jProgressBar1.setIndeterminate(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextKey = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextSearch = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextLowRange = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        new JavaLib.LoadForm();
        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        new JavaLib.LoadForm();
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 51, 0));
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 102, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GOOGLE CUSTOM SEARCH INTERFACE");
        jLabel1.setOpaque(true);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("KEY");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextKey.setForeground(new java.awt.Color(0, 153, 0));
        jTextKey.setText("AIzaSyCCdJ86nxc_gLLMfxePv4lp65n9mU4eoj0");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SEARCH TEXT");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        new JavaLib.LoadForm();
        jTextSearch.setText("apple");

        jButton2.setForeground(new java.awt.Color(204, 51, 0));
        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextLowRange.setText("1");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 51, 0));
        jButton3.setText("APPLY CLUSTERING");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextKey))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextLowRange, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextLowRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jTextKey, jTextLowRange, jTextSearch});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void purgeDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                purgeDirectory(file);
            }
            file.delete();
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        MyDownloadTask myDownloadTask = new MyDownloadTask();
        Timer t = new Timer();
        t.schedule(myDownloadTask, 100);
//        vec = new Vector<SingleEntry>();
//        int index_count = 1;
//        for (int i = 1; i <= 5; i++) {
//            Vector<SingleEntry> current_vect = fetchResults(jTextSearch.getText(), jTextKey.getText(), index_count);
//            index_count += 10;
//            for (int j = 0; j < current_vect.size(); j++) {
//                vec.addElement(current_vect.elementAt(j));
//            }
//        }
//        String result = "";
//        if (vec.size() == 0) {
//            result = "ERROR FETCHING RESULTS";
//        } else {
//            result = "TOATL RESULTS FETCHED: " + vec.size() + "\n";
//            for (SingleEntry se : vec) {
//                result += "ID : " + se.id + "\n";
//                result += "TITLE : " + se.title + "\n";
//                result += "SUMMARY : " + se.summary + "\n";
//                result += "LINK : " + se.link + "\n";
//                result += "\n\n";
//            }
//        }
//        jTextArea1.setText(result);
//        jEditorPane1.setText(result);
//        jEditorPane1.setSelectionStart(0);
//        jEditorPane1.setSelectionEnd(jEditorPane1.getText().length());
//        jTextArea1.setText(jEditorPane1.getSelectedText());


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        System.exit(0);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            //writing files...
            purgeDirectory(new File("D:\\ProjectData\\12968DB\\"));
            BufferedWriter br;
            for (int i = 0; i < vec.size(); i++) {
                br = new BufferedWriter(new FileWriter(new File("D:\\ProjectData\\12968DB\\" + i + ".txt")));
                br.write(vec.elementAt(i).title + "\n");
                br.write(vec.elementAt(i).summary);
                br.close();
            }
            //prepare for processing...
            start_time = System.currentTimeMillis();
            allProcessedEntry = new ArrayList<SingleProcessedEntry>();
            SingleProcessedEntry spe;
            for (int i = 0; i < vec.size(); i++) {
                String path = "D:\\ProjectData\\12968DB\\" + i + ".txt";
                spe = new SingleProcessedEntry();
                spe.all_tokens = processdata(path);
                allProcessedEntry.add(spe);
            }
            //  calculate idf..
            int total_documents = allProcessedEntry.size();
            for (int i = 0; i < allProcessedEntry.size(); i++) {
                for (int j = 0; j < allProcessedEntry.get(i).all_tokens.size(); j++) {
                    int totalDocumentsContainingTerm = getContainsCount(allProcessedEntry.get(i).all_tokens.get(j).data);
                    allProcessedEntry.get(i).all_tokens.get(j).idf = logBase2(total_documents * 1. / totalDocumentsContainingTerm);
                    allProcessedEntry.get(i).all_tokens.get(j).tf_idf = (allProcessedEntry.get(i).all_tokens.get(j).tf * allProcessedEntry.get(i).all_tokens.get(j).idf);
//                    System.out.println(allProcessedEntry.get(i).all_tokens.get(j).data + "       "+ totalDocumentsContainingTerm+"        "+ allProcessedEntry.get(i).all_tokens.get(j).idf + "           " + allProcessedEntry.get(i).all_tokens.get(j).tf_idf);
                }
            }
            // apply sorting on tf_idf values.... 
            sort_all_tf_idf();
            //prepare data for Improved k-means...
            ArrayList<double[]> allSortedArrays = new ArrayList<double[]>();
            double tfIdfArray[];
            for (int i = 0; i < allProcessedEntry.size(); i++) {
                tfIdfArray = new double[5];
                for (int j = 0; j < 5; j++) {
                    tfIdfArray[j] = allProcessedEntry.get(i).all_tokens.get(j).tf_idf;
                }
                allSortedArrays.add(tfIdfArray);
            }
            //apply cosine similarity...
            ArrayList<double[]> allCosineRelations = new ArrayList<double[]>();
            double singleCosineRelation[];
            int count;
            for (int i = 0; i < allSortedArrays.size(); i++) {
                double array1[] = allSortedArrays.get(i);
                singleCosineRelation = new double[allSortedArrays.size() - 1]; //size -1 because it compare individual with all others..
                count = 0;
                for (int j = 0; j < allSortedArrays.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    double array2[] = allSortedArrays.get(j);
                    singleCosineRelation[count] = apply_cosine(array1, array2);
                    count++;
                }
                allCosineRelations.add(singleCosineRelation);
            }
            for (int i = 0; i < allCosineRelations.get(0).length; i++) {
                System.out.println("cosine[" + (i + 1) + "] : " + allCosineRelations.get(0)[i]);
            }
            // apply improved k-means....
            apply_improved_kmeans(allCosineRelations.get(0));  // 0 because first to all cosine relation..
        } catch (IOException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    ArrayList<MyToken> processdata(String docPath) {
        ArrayList<MyToken> allTokens = new ArrayList<MyToken>();
        Stemmer stemmer = new Stemmer();
        String stemResult = stemmer.displayResultFromFile(docPath);
//        System.out.println("Result= " + stemResult);
        IR_Cosine tf = new IR_Cosine();
        allTokens = tf.ApplyTf(stemResult);
        return allTokens;
    }

    int getContainsCount(String word) {
        int count = 0;
        for (SingleProcessedEntry spe : allProcessedEntry) {
            for (MyToken mt : spe.all_tokens) {
                if (word.equalsIgnoreCase(mt.data)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    double apply_cosine(double array1[], double array2[]) {
        double sum_xy, sum_x2, sum_y2;
        sum_x2 = sum_xy = sum_y2 = 0.0;
        for (int i = 0; i < array1.length; i++) {
            sum_xy += (array1[i] * array2[i] * 1.);
            sum_x2 += Math.pow(array1[i], 2);
            sum_y2 += Math.pow(array2[i], 2);
        }
        return (sum_xy / Math.sqrt(sum_x2 * sum_y2));
    }

    public void sort_all_tf_idf() {
        for (int index = 0; index < allProcessedEntry.size(); index++) {
            for (int i = 0; i < allProcessedEntry.get(index).all_tokens.size() - 1; i++) {
                for (int j = i + 1; j < allProcessedEntry.get(index).all_tokens.size(); j++) {
                    MyToken mt1 = allProcessedEntry.get(index).all_tokens.get(i);
                    MyToken mt2 = allProcessedEntry.get(index).all_tokens.get(j);
                    if (mt2.tf_idf > mt1.tf_idf) {
                        allProcessedEntry.get(index).all_tokens.remove(j);
                        allProcessedEntry.get(index).all_tokens.remove(i);
                        allProcessedEntry.get(index).all_tokens.add(i, mt2);
                        allProcessedEntry.get(index).all_tokens.add(j, mt1);
                    }
                }
            }
        }

    }

    double logBase2(double data) {
        return (Math.log10(data) / Math.log10(2));
    }

    void apply_improved_kmeans(double data_points[]) {
        clusterDB = new Clusters();
        // fill data items..
        for (int i = 0; i < data_points.length; i++) {
            SinglePoint sp = new SinglePoint(1);
            sp.data[0] = Math.abs(data_points[i]);
            clusterDB.originalPoints.points.add(sp);
        }
        // calculate centroids...
        setInitialCluster();
        System.out.println("Cluster 1 : " + clusterDB.clusterList.get(0).toString());
        System.out.println("Cluster 2 : " + clusterDB.clusterList.get(1).toString());

        double minDistForCluster1 = clusterDB.clusterList.get(0).getMinDistanceBetweenAnyTwoPoints();
        double minDistForCluster2 = clusterDB.clusterList.get(1).getMinDistanceBetweenAnyTwoPoints();
//        clusterDB.d = Math.min(minDistForCluster1, minDistForCluster2);
//        this is for less than 10 results..
//        clusterDB.d = 0.02;
//        this is for 1-50 results...
        clusterDB.d = 0.03;
        System.out.println("D: " + clusterDB.d);

        for (int j = clusterDB.clusterList.size() - 1; j >= 0; j--) {
            SingleCluster sc = clusterDB.clusterList.get(j);
            double minValue = sc.getMeanCentroid();
            for (int i = sc.points.size() - 1; i >= 0; i--) {
                if (sc.points.get(i).getDiff(minValue) > clusterDB.d) {
                    clusterDB.outliers.points.add(sc.points.get(i));
                    sc.points.remove(i);
                }
            }
            if (sc.points.size() == 0) {
                clusterDB.clusterList.remove(j);
            }
        }

        System.out.println("Again Printing");

        for (SingleCluster sc : clusterDB.clusterList) {
            System.out.print("Cluster: " + sc.toString());
        }
        System.out.println("Outliers:  " + clusterDB.outliers.toString());

        calculateClusters();
        // this code is added for taking final values(optional)..
        ArrayList<double[]> all_cluster = new ArrayList<double[]>();
        double array_of_points[];
        for (SingleCluster sc : clusterDB.clusterList) {
            array_of_points = new double[sc.points.size()];
            for (int i = 0; i < sc.points.size(); i++) {
                array_of_points[i] = sc.points.elementAt(i).data[0];
            }
            all_cluster.add(array_of_points);
        }
        ArrayList<int[]> all_normalize_cluster = new ArrayList<int[]>();
        int[] array;
        for (int i = 0; i < all_cluster.size(); i++) {
            array = new int[all_cluster.get(i).length];
            for (int j = 0; j < data_points.length; j++) {
                for (int k = 0; k < all_cluster.get(i).length; k++) {
                    if (all_cluster.get(i)[k] == data_points[j]) {
                        array[k] = (j + 1);
                    }
                }
            }
            all_normalize_cluster.add(array);
        }
        stop_time = System.currentTimeMillis();
        System.out.println("TIME REQUIRED TO PERFORM CLUSTERING IN (MILISECONDS) : " + (stop_time - start_time));
        //now call CLusterView form..
        new ClusterView(this, all_normalize_cluster).setVisible(true);

    }

    void setInitialCluster() {

        double minOfAll = clusterDB.originalPoints.getMin();
        double maxOfAll = clusterDB.originalPoints.getMax();
        System.out.println("Min:  " + minOfAll + " , " + maxOfAll);

        SingleCluster scMin = new SingleCluster();
        SingleCluster scMax = new SingleCluster();
        int minIndex = clusterDB.originalPoints.getMinPointIndex();
        int maxIndex = clusterDB.originalPoints.getMaxPointIndex();
        SinglePoint spMin = clusterDB.originalPoints.points.get(minIndex);
        SinglePoint spMax = clusterDB.originalPoints.points.get(maxIndex);
        System.out.println("Min Point: " + spMin);
        System.out.println("Max Point: " + spMax);

        // update data points clustering...
        for (int i = 0; i < clusterDB.getLength(); i++) { // data points

            SinglePoint sp = clusterDB.originalPoints.points.get(i);

            double dist1 = sp.getDistFrom(spMin);
            double dist2 = sp.getDistFrom(spMax);
            if (dist1 < dist2) {
                scMin.points.add(sp);
            } else {
                scMax.points.add(sp);
            }
        }
        clusterDB.clusterList.add(scMin);
        clusterDB.clusterList.add(scMax);
    }

    void calculateClusters() {
        try {
            SingleCluster outliertemp = new SingleCluster();
            SingleCluster newCluster = new SingleCluster();

            while (clusterDB.outliers.points.size() != 0) {
                System.out.println("Outlier:  " + clusterDB.outliers.toString());
                double meanCentroid = clusterDB.outliers.getMeanCentroid();
                outliertemp = new SingleCluster();
                newCluster = new SingleCluster();
                for (SinglePoint sp : clusterDB.outliers.points) {
                    if (sp.getDiff(meanCentroid) > clusterDB.d) {
                        outliertemp.points.add(sp);
                    } else {
                        newCluster.points.add(sp);
                    }
                }

                if (newCluster.points.size() == 0) { //Special Condition
                    //  System.out.println("Special Condition!!");
                    int index = -1;
                    double meanTemp = outliertemp.getMeanCentroid();

                    double minDiff = getMinValue(outliertemp);
                    for (int i = 0; i < outliertemp.points.size(); i++) {
                        if (minDiff == (Math.abs(meanTemp - outliertemp.points.get(i).data[0]))) {
                            index = i;
                            break;
                        }
                    }
                    if (index != -1) {
                        newCluster.points.add(outliertemp.points.get(index));
                        outliertemp.points.remove(index);

                    }
                }
                if (newCluster.points.size() != 0) {
                    clusterDB.clusterList.add(newCluster);
                }
                System.out.print("New Cluster:  " + newCluster.toString());
//                /System.out.println("OutLier :  " + outliertemp.toString());

                System.out.println("Before Cluster OUTPUT::");
                for (SingleCluster sc : clusterDB.clusterList) {
                    System.out.print("*" + sc.toString());
                }

                boolean canAdd = false;
                double distanceValue = 0.0;
                clusterDB.outliers.points.clear();
                for (int j = outliertemp.points.size() - 1; j >= 0; j--) {
                    canAdd = false;
                    for (int i = clusterDB.clusterList.size() - 1; i >= 0; i--) {
                        double meanTemp = clusterDB.clusterList.get(i).getMeanCentroid();
                        //SingleCluster sp=outliertemp.clusterList.get(i);
                        distanceValue = outliertemp.points.get(j).getDiff(meanTemp);//data[0];
                        if (distanceValue <= clusterDB.d) {
                            canAdd = true;
                            clusterDB.clusterList.get(i).points.add(outliertemp.points.remove(j));
                            break;
                        }
                    }

                    if (!canAdd) {
                        clusterDB.outliers.points.add(outliertemp.points.remove(j));
                    }
                }
                //clusterDB.outliers = remainingOutliers;//.add(outliertemp.points.get(j));

                System.out.println("Cluster OUTPUT::");
                for (SingleCluster sc : clusterDB.clusterList) {
                    System.out.print("*" + sc.toString());
                }

            }

            System.out.println("Finally OUTPUT");
            for (SingleCluster sc : clusterDB.clusterList) {
                System.out.print("*" + sc.toString());
            }

        } catch (Exception e) {
            System.out.println("Error is found: " + e);
            e.printStackTrace();
        }
    }

    double getMinValue(SingleCluster outliertemp) {
        double meanTemp = outliertemp.getMeanCentroid();
        double minDiff = 999999999;
        for (SinglePoint sp : outliertemp.points) {

            double currDiff = Math.abs(meanTemp - sp.data[0]);
            if (currDiff < minDiff) {
                minDiff = currDiff;

            }
        }

        return minDiff;
    }

    public Vector<SingleEntry> fetchResults(String searchString, String key, int LowRange) {

        Vector<SingleEntry> vec = new Vector<SingleEntry>();
        int c;
        URL theURL;
        URLConnection con;
        String data = "";

        String formattedSearchString = "";
        String tempS;
        for (int i = 0; i < searchString.length(); i++) {
            tempS = Integer.toHexString((int) searchString.charAt(i)).toUpperCase();
            if (tempS.length() == 1) {
                tempS = "0" + tempS;
            }
            tempS = "%" + tempS;
            formattedSearchString += tempS;
        }
//        System.out.println("FORMATTED: " + formattedSearchString);

        try {
            //theURL = new File(System.getProperty("user.dir") + "\\result.txt").toURL(); // "https://www.googleapis.com/customsearch/v1?key=AIzaSyDH-rrC5iXsE1DnlrObB0K1Za_4s8vM0hE&cx=013036536707430787589:_pqjad5hr1a&q=flowers&alt=atom");
            theURL = new URL("https://www.googleapis.com/customsearch/v1?key=" + key + "&cx=013036536707430787589:_pqjad5hr1a&q=" + formattedSearchString + "&alt=atom&start=" + LowRange + "&num=10");
            con = theURL.openConnection();
            InputStream input = con.getInputStream();
            c = input.read();
            while (c != -1) {
                data += (char) c;
                c = input.read();
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return vec;
        }

//        System.out.println("DATA: " + data);

        // data collected start parsing...
        IXMLParser xmlParser;
        IXMLReader xmlReader;

        JEditorPane jEditorPaneFormatter = new JEditorPane();
        jEditorPaneFormatter.setContentType("text/html");

        try {
            // Create the XML parser
            xmlParser = XMLParserFactory.createDefaultXMLParser();
            xmlReader = StdXMLReader.stringReader(data);
            xmlParser.setReader(xmlReader);

            // Read stream and parse it!
            IXMLElement xmlDoc = (IXMLElement) xmlParser.parse();

//            System.out.println("Name: " + xmlDoc.getName());

            Enumeration e1 = xmlDoc.enumerateChildren();
            while (e1.hasMoreElements()) {
                IXMLElement node = (IXMLElement) e1.nextElement();

                if (node.getName().equals("entry")) {
                    SingleEntry se = new SingleEntry();
                    se.id = node.getFirstChildNamed("id").getContent();
                    se.title = node.getFirstChildNamed("title").getContent();
                    se.link = node.getFirstChildNamed("link").getAttribute("href", "href");
                    se.summary = node.getFirstChildNamed("summary").getContent();

                    jEditorPaneFormatter.setText(se.id);
                    jEditorPaneFormatter.setSelectionStart(0);
                    jEditorPaneFormatter.setSelectionEnd(jEditorPaneFormatter.getText().length());
                    se.id = jEditorPaneFormatter.getSelectedText();

                    jEditorPaneFormatter.setText(se.title);
                    jEditorPaneFormatter.setSelectionStart(0);
                    jEditorPaneFormatter.setSelectionEnd(jEditorPaneFormatter.getText().length());
                    se.title = jEditorPaneFormatter.getSelectedText();

                    jEditorPaneFormatter.setText(se.link);
                    jEditorPaneFormatter.setSelectionStart(0);
                    jEditorPaneFormatter.setSelectionEnd(jEditorPaneFormatter.getText().length());
                    se.link = jEditorPaneFormatter.getSelectedText();

                    jEditorPaneFormatter.setText(se.summary);
                    jEditorPaneFormatter.setSelectionStart(0);
                    jEditorPaneFormatter.setSelectionEnd(jEditorPaneFormatter.getText().length());
                    se.summary = jEditorPaneFormatter.getSelectedText();

                    vec.add(se);
//                    System.out.println("ID: " + se.id);
//                    System.out.println("TI: " + se.title);
//                    System.out.println("LI: " + se.link);
//                    System.out.println("SU: " + se.summary);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            vec.clear();
            return vec;
        }
        return vec;
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /*
//         * Set the Nimbus look and feel
//         */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /*
//         * If Nimbus (introduced in Java SE 6) is not available, stay with the
//         * default look and feel. For details see
//         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /*
//         * Create and display the form
//         */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            
//            public void run() {
//                new Demo().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextKey;
    private javax.swing.JTextField jTextLowRange;
    private javax.swing.JTextField jTextSearch;
    // End of variables declaration//GEN-END:variables
}
