/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Controller;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.sound.midi.Sequencer;
import utils.Config;

/**
 *
 * @author alessandrogelsi
 */

public class VictoryPanel extends javax.swing.JPanel {

    private MainGUI mainGUI= null;
    private Image victoryBackground = null ;
    private Sequencer sequencer;
    private int actualTime;
    private Image kartGif;

    
    /**
     * Creates new form VictoryPanel
     */
    public VictoryPanel() {
        setMusicSequencer();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RestartButton = new javax.swing.JButton();
        VictoryBackground = new javax.swing.JLabel();
        PlayerNameLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        MarioKartExpertLabel = new javax.swing.JLabel();
        BestTimesLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1100, 720));
        setPreferredSize(new java.awt.Dimension(1100, 720));

        RestartButton.setBackground(new java.awt.Color(153, 153, 153));
        RestartButton.setFont(new java.awt.Font("Gill Sans Nova Ultra Bold", 1, 18)); // NOI18N
        RestartButton.setForeground(new java.awt.Color(255, 255, 255));
        RestartButton.setText("Restart a new game");
        RestartButton.setAutoscrolls(true);
        RestartButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        RestartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartButtonActionPerformed(evt);
            }
        });

        PlayerNameLabel.setFont(Config.getInstance().getFont(Font.BOLD, 35));
        PlayerNameLabel.setForeground(new java.awt.Color(0, 51, 153));
        PlayerNameLabel.setText(Controller.getInstance().getPlayerName());

        TimeLabel.setFont(new java.awt.Font("Gill Sans Nova Ultra Bold", 1, 40)); // NOI18N
        TimeLabel.setForeground(new java.awt.Color(0, 51, 153));

        MarioKartExpertLabel.setFont(Config.getInstance().getFont(Font.BOLD, 32));
        MarioKartExpertLabel.setForeground(new java.awt.Color(0, 51, 153));
        MarioKartExpertLabel.setText("You are now a JMarioKart expert!");

        BestTimesLabel.setFont(Config.getInstance().getFont(Font.BOLD, 16));
        BestTimesLabel.setForeground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RestartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VictoryBackground)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(PlayerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(MarioKartExpertLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(BestTimesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(VictoryBackground)
                .addGap(190, 190, 190)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlayerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MarioKartExpertLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BestTimesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134)
                .addComponent(RestartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RestartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartButtonActionPerformed
        Controller.getInstance().startStopWelcomeMusic(true);
        Controller.getInstance().restartNewGame();
    }//GEN-LAST:event_RestartButtonActionPerformed
 
    private void setMusicSequencer () {
       this.sequencer = Config.getInstance().getMusic("Music", "congratulations");   
    }
    
    protected void startStopMusic( boolean condition) {
        if (condition) {        //condition == true means music has to start
            this.sequencer = Config.getInstance().getMusic("Music", "congratulations");
            if (this.sequencer != null)
                this.sequencer.start();
        }
        else {
            this.sequencer.stop();
        }
    }
        
    protected void setBackground() {
        this.victoryBackground = Config.getInstance().getSelectedImage("VictoryBackground", "Congratulations", ".png");
    }
     
    protected void setPlayerName(String playerName){
         this.PlayerNameLabel.setText(playerName + "!");
     };
     
    protected void setTimeLabel(){
        this.actualTime = Controller.getInstance().getRecord();
        this.TimeLabel.setText("Your actual time is" + "  " + String.valueOf(actualTime) +"s !");
     };
     
    protected void setKartGif(){
         this.kartGif = Config.getInstance().getKartGif("KartGif", Controller.getInstance().getSelectedKartName());
     };
    
    protected void setBestTimes(){
       this.BestTimesLabel.setText("Best Times:  "+ "1)" + "  " + String.valueOf(Controller.getInstance().getBestTimes()[0]) + " s;   " + 
                                       "2)" + "  " + String.valueOf(Controller.getInstance().getBestTimes()[1]) + " s;   " +
                                       "3)" + "  " + String.valueOf(Controller.getInstance().getBestTimes()[2]) + " s;   " );        
    };
      
    protected void setMainGUI(MainGUI mainGUI) {
       this.mainGUI = mainGUI;
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g); 
      Graphics2D g2d = (Graphics2D)g;
        if (this.victoryBackground != null && this.mainGUI != null )    
            g.drawImage(this.victoryBackground, 0, 0, this.mainGUI.getWidth()-15,this.mainGUI.getHeight()-35, this);
        if(this.kartGif != null)
            g.drawImage(kartGif, 450,490, this);
    };
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BestTimesLabel;
    private javax.swing.JLabel MarioKartExpertLabel;
    private javax.swing.JLabel PlayerNameLabel;
    private javax.swing.JButton RestartButton;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel VictoryBackground;
    // End of variables declaration//GEN-END:variables
}
