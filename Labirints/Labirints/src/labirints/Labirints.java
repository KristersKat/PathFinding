package labirints;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Labirints extends javax.swing.JFrame {

    int m, n, rin, kol;
    int rutina, blakus;//labirinta rindu un kolonnu skaits

    public Labirints() {
        initComponents();
    }

    public void BFS(int v, int galap) {
        v--;
        galap--;
        Queue<Integer> rinda = new LinkedList();
        rinda.clear();
        rinda.add(v);
        boolean[] apmeklets = new boolean[n * m];
        apmeklets[v] = true;
        System.out.println(v + 1);
        int[] no = new int[n * m];
        no[v] = -1;
        int p, u = -1;
        while (!rinda.isEmpty()) {
            p = rinda.remove();
            for (int j = 0; j < labirints[p].size() && u != galap; j++) {
                u = labirints[p].get(j);
                if (!apmeklets[u]) {
                    no[u] = p;
                    rinda.add(u);
                    apmeklets[u] = true;
                    System.out.println(u + 1);
                }
            }
        }
        System.out.println("-------------");
        while(no[u]!=-1){
            System.out.println(u+1);
            zimetCelu(u, no[u]);
            u=no[u];
        }
    }
    
    public void zimetCelu(int no, int uz) {
        rin = (no) / n;
        kol = (no) % n;
        int rin1 = (uz) / n;
        int kol1 = (uz) % n;
        Graphics2D g = (Graphics2D) panelis.getGraphics();
        g.setColor(Color.red);
        g.drawLine(40 * (kol) + 20, 40 * rin + 20, 40 * (kol1) + 20, 40 * (rin1) + 20);
        g.setStroke(new BasicStroke(3));
    }

    ArrayList<Integer>[] labirints;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lasa = new javax.swing.JButton();
        zime = new javax.swing.JButton();
        panelis = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lasa.setText("Uzzīmēt labirintu");
        lasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lasaActionPerformed(evt);
            }
        });

        zime.setText("Uzzīmēt ceļu");
        zime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelisLayout = new javax.swing.GroupLayout(panelis);
        panelis.setLayout(panelisLayout);
        panelisLayout.setHorizontalGroup(
            panelisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        panelisLayout.setVerticalGroup(
            panelisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));

        jLabel1.setText("No");

        jLabel2.setText("Uz");

        jButton1.setText("RESET");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(panelis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lasa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(zime)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)
                        .addComponent(jButton1)
                        .addGap(182, 182, 182))
                    .addComponent(panelis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lasaActionPerformed
        try {
            BufferedReader bufRdr = new BufferedReader(new FileReader("labirints.txt"));
            String failaRinda = bufRdr.readLine(); //nolasa no faila vienu teksta rindu
            String[] tmp = failaRinda.split(" ");    //sadala to atsevišķos gabaliņos, kurus saliek masīvā tmp
            m = Integer.parseInt(tmp[0]);            //iegūst rindu skaitu
            n = Integer.parseInt(tmp[1]);          //iegūst kolonnu skaitu
            System.out.println(m + " " + n);           //izvada rindu un kolonnu skaitu testa nolūkiem
            Graphics2D g = (Graphics2D) panelis.getGraphics();
            g.setStroke(new BasicStroke(5));
            for (int i = 0; i < n + 1; i++) {
                g.drawLine(40 * i, 0, i * 40, 40 * m);
                g.setColor(java.awt.Color.black);
                g.setStroke(new BasicStroke(3));
            }
            for (int i = 0; i < m + 1; i++) {
                g.drawLine(0, 40 * i, 40 * n, 40 * i);
                g.setColor(java.awt.Color.black);
                g.setStroke(new BasicStroke(3));
            }

            labirints = new ArrayList[m * n];

            for (int i = 0; i < n * m; i++) {
                failaRinda = bufRdr.readLine();
                tmp = failaRinda.split(" ");
                labirints[i] = new ArrayList<Integer>();
                rutina = Integer.parseInt(tmp[0]);
                rin = (rutina - 1) / n;
                kol = (rutina - 1) % n;
                for (int j = 1; j < tmp.length; j++) {
                    labirints[i].add(Integer.parseInt(tmp[j]) - 1);
                    blakus = Integer.parseInt(tmp[j]);
                    if (rutina + 1 == blakus) {
                        g.setColor(panelis.getBackground());
                        g.drawLine(40 * (kol + 1), 40 * rin, 40 * (kol + 1), 40 * (rin + 1));
                        g.setStroke(new BasicStroke(3));
                    } else if (rutina - 1 == blakus) {
                        g.setColor(panelis.getBackground());
                        g.drawLine(40 * kol, 40 * rin, 40 * kol, 40 * (rin + 1));
                        g.setStroke(new BasicStroke(3));
                    } else if (rutina + n == blakus) {
                        g.setColor(panelis.getBackground());
                        g.drawLine(40 * kol, 40 * (rin + 1), 40 * (kol + 1), 40 * (rin + 1));
                        g.setStroke(new BasicStroke(3));
                    } else if (rutina - n == blakus) {
                        g.setColor(panelis.getBackground());
                        g.drawLine(40 * kol, 40 * rin, 40 * (kol + 1), 40 * rin);
                        g.setStroke(new BasicStroke(3));
                    }
                }
            }
        } 
        catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
        for (int i = 0; i < labirints.length; i++) {
            System.out.print((i + 1) + " kaimiņi: ");
            Iterator it = labirints[i].iterator();
            while (it.hasNext()) {
                int j = (Integer) it.next();
                System.out.print(j + 1 + " ");
            }
            System.out.println();
        }


    }//GEN-LAST:event_lasaActionPerformed

    private void zimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zimeActionPerformed
        // te jānolasa lietotāja vēlmes no kuras uz kuru rūtiņu jāmeklē ceļš
        int no = (int) jSpinner1.getValue();
        int uz = (int) jSpinner2.getValue();
        BFS(no, uz);
    }//GEN-LAST:event_zimeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        repaint();
    }//GEN-LAST:event_jButton1ActionPerformed


    public Stack<Integer> mekletCelu(int no, int uz) {
        Stack<Integer> cels = new Stack();
        // te jāraksta ceļa meklēšnas algoritms
        return cels;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Labirints().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JButton lasa;
    private javax.swing.JPanel panelis;
    private javax.swing.JButton zime;
    // End of variables declaration//GEN-END:variables
}
