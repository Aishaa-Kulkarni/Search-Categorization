/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchPack;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import textMining.MyToken;

public class ClusterView extends javax.swing.JFrame implements MouseListener {

    Demo parent;
    ArrayList<int[]> all_normalize_cluster;

    public ClusterView(Demo parent, ArrayList<int[]> all_normalize_cluster) {
        initComponents();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.parent = parent;
        this.all_normalize_cluster = all_normalize_cluster;
        fill_clusters();
    }

    void fill_clusters() {
        jScrollPane1.getViewport().removeAll();
        jPanel2.removeAll();
        GridLayout gl = new GridLayout(4, 1);
        jPanel2.setLayout(gl);
        for (int i = 0; i < all_normalize_cluster.size(); i++) {
            String result = "";
            System.out.println("cluster name for C" + (i + 1));
            Vector<String> linksInCluster = new Vector<String>();
            Object[][] wordsInCluster = new Object[all_normalize_cluster.get(i).length][2];
            for (int j = 0; j < all_normalize_cluster.get(i).length; j++) {
                result += "ID : " + parent.vec.elementAt(all_normalize_cluster.get(i)[j]).id + "\n";
                result += "TITLE : " + parent.vec.elementAt(all_normalize_cluster.get(i)[j]).title + "\n";
                result += "SUMMARY : " + parent.vec.elementAt(all_normalize_cluster.get(i)[j]).summary + "\n";
                result += "LINK : " + parent.vec.elementAt(all_normalize_cluster.get(i)[j]).link + "\n";
                result += "\n\n";
                linksInCluster.addElement(parent.vec.elementAt(all_normalize_cluster.get(i)[j]).link);
//                System.out.println("word : " + parent.allProcessedEntry.get(all_normalize_cluster.get(i)[j]).all_tokens.get(0).data + " occurance: " + parent.allProcessedEntry.get(all_normalize_cluster.get(i)[j]).all_tokens.get(0).occurance);
                wordsInCluster[j][0] = parent.allProcessedEntry.get(all_normalize_cluster.get(i)[j]).all_tokens.get(0).data;
                wordsInCluster[j][1] = parent.allProcessedEntry.get(all_normalize_cluster.get(i)[j]).all_tokens.get(0).occurance;
            }
            String[] tags = filterWords(wordsInCluster);
            Box1 box = new Box1(result, linksInCluster, tags);
            box.addMouseListener(this);
            jPanel2.add(box);
            jScrollPane1.getViewport().add(jPanel2);
        }
    }

    String[] filterWords(Object[][] wordsInCluster) {

        for (int i = 0; i < wordsInCluster.length - 1; i++) {
            for (int j = 1; j < wordsInCluster.length; j++) {
                if ((Integer) wordsInCluster[j][1] > (Integer) wordsInCluster[i][1]) {
                    Object word = wordsInCluster[i][0];
                    Object occerence = wordsInCluster[i][1];
                    wordsInCluster[i][0] = wordsInCluster[j][0];
                    wordsInCluster[i][1] = wordsInCluster[j][1];
                    wordsInCluster[j][0] = word;
                    wordsInCluster[j][1] = occerence;
                }
            }
        }
        String[] tag = null;
        if (wordsInCluster.length > 3) {
            tag = new String[3];
            tag[0] = (String) wordsInCluster[0][0];
            tag[1] = (String) wordsInCluster[1][0];
            tag[2] = (String) wordsInCluster[2][0];
        } else if (wordsInCluster.length > 2) {
            tag = new String[2];
            tag[0] = (String) wordsInCluster[0][0];
            tag[1] = (String) wordsInCluster[1][0];
        } else if (wordsInCluster.length > 0) {
            tag = new String[1];
            tag[0] = (String) wordsInCluster[0][0];
        }
        for (int i = 0; i < tag.length; i++) {
            System.out.println("word : " + tag[i]);
        }
        return tag;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jButton1.setForeground(new java.awt.Color(204, 51, 0));
        jButton1.setText("B A C K");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
}
