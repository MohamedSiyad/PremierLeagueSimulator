/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1758050_footballmanager;

import java.util.Collections;

/**
 *
 * @author msiyad
 */
public class GUI extends javax.swing.JFrame   {
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    };

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LeagueTableOrderButton = new javax.swing.JButton();
        SortByWinsButton = new javax.swing.JButton();
        GoalsScoredSortButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        LeagueTableDisplay = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LeagueTableOrderButton.setText("League Table");
        LeagueTableOrderButton.setActionCommand("DescendingOrder");
        LeagueTableOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeagueTableOrderButtonActionPerformed(evt);
            }
        });

        SortByWinsButton.setText("Sort by Wins");
        SortByWinsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortByWinsButtonActionPerformed(evt);
            }
        });

        GoalsScoredSortButton.setText("Sort by Goals Scored");
        GoalsScoredSortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoalsScoredSortButtonActionPerformed(evt);
            }
        });

        LeagueTableDisplay.setEditable(false);
        LeagueTableDisplay.setColumns(20);
        LeagueTableDisplay.setRows(5);
        jScrollPane1.setViewportView(LeagueTableDisplay);
        // automatically wrap lines
        LeagueTableDisplay.setLineWrap( true );
        // break lines on word, rather than character boundaries.
        LeagueTableDisplay.setWrapStyleWord( true );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LeagueTableOrderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(GoalsScoredSortButton)
                        .addGap(54, 54, 54)
                        .addComponent(SortByWinsButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LeagueTableOrderButton)
                    .addComponent(GoalsScoredSortButton)
                    .addComponent(SortByWinsButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SortByWinsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortByWinsButtonActionPerformed
        LeagueTableDisplay.setText("");       
        Collections.sort(PremierLeagueManager.league, new MostWinsComparator());
        for (FootballClub club : PremierLeagueManager.league) {
            LeagueTableDisplay.append('\n' + "Club: " + club.getName() + " Points: " + club.getNumberOfPoints() + " Goals Scored :" + club.getGoalsScored() + " GD: " + (club.getGoalsScored() - club.getGoalsConceded()) + " Wins: " + (club.getWinsAmount()));
        }
    }//GEN-LAST:event_SortByWinsButtonActionPerformed

    private void LeagueTableOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeagueTableOrderButtonActionPerformed
        LeagueTableDisplay.setText("");
        Collections.sort(PremierLeagueManager.league, new TableComparator());
        for (FootballClub club : PremierLeagueManager.league) {
            LeagueTableDisplay.append('\n' + "Club: " + club.getName() + " Points: " + club.getNumberOfPoints() + " Goals Scored :" + club.getGoalsScored() + " GD: " + (club.getGoalsScored() - club.getGoalsConceded()) + " Wins: " + (club.getWinsAmount()));
        }
    }//GEN-LAST:event_LeagueTableOrderButtonActionPerformed

    private void GoalsScoredSortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoalsScoredSortButtonActionPerformed
        LeagueTableDisplay.setText("");
        Collections.sort(PremierLeagueManager.league, new GoalsScoredComparator());
        for (FootballClub club : PremierLeagueManager.league) {
            LeagueTableDisplay.append('\n' + "Club: " + club.getName() + " Points: " + club.getNumberOfPoints() + " Goals Scored :" + club.getGoalsScored() + " GD: " + (club.getGoalsScored() - club.getGoalsConceded()) + " Wins: " + (club.getWinsAmount()));
        }
    }//GEN-LAST:event_GoalsScoredSortButtonActionPerformed

    /**
     * 
     * @param args the command line arguments
     */
    public void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoalsScoredSortButton;
    public javax.swing.JTextArea LeagueTableDisplay;
    private javax.swing.JButton LeagueTableOrderButton;
    private javax.swing.JButton SortByWinsButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    }

