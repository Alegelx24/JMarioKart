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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.Config;
import javax.sound.midi.Sequencer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author alessandrogelsi
 */

public class RacePanel extends JPanel {

    private final static int SPRITE_X_GAP = 30;
    private final static int SPRITE_Y_GAP = 30;

    private int kartXPosition = 600;
    private int kartYPosition = 20;
    private int spriteXPixel = 60;
    private int spriteYPixel = 0;
    private boolean isMovingRight = false;
    private boolean isMovingLeft = false;
    private boolean isMovingDown = false;
    private boolean isMovingUp = false;
    private Image raceBackground = null;
    private MainGUI mainGUI = null;
    private Sequencer sequencer;
    private Sequencer soundEffectsSequencer;
    private boolean isStarted = false;
    private Image kartSprite = null;
    private Timer timer = null;
    private Timer refreshTimer = null;
    private String playerName;
    private int numLaps;
    private int second = 0;
    private int finishLineGap=1;
    private int refreshRate = 15;
    private int pixelIncrease = 2;

    /**
     * Creates new form RacePanel
     */
    public RacePanel() {
        initComponents();
        this.NumLapsLabel.setText(String.valueOf(numLaps) + " " + "/3  laps");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QuitButton = new javax.swing.JButton();
        RightButton = new javax.swing.JButton();
        UpButton = new javax.swing.JButton();
        DownButton = new javax.swing.JButton();
        LeftButton = new javax.swing.JButton();
        TimerLabel = new javax.swing.JLabel();
        NumLapsLabel = new javax.swing.JLabel();
        YourTimeLabel = new javax.swing.JLabel();
        PlayerNameLabel = new javax.swing.JLabel();
        GoodGameLabel = new javax.swing.JLabel();
        LakituLabel = new javax.swing.JLabel();
        BoostToggleButton = new javax.swing.JToggleButton();
        BrakeToggleButton1 = new javax.swing.JToggleButton();
        PressKeyToStartLabel = new javax.swing.JLabel();
        CommandLabel = new javax.swing.JLabel();
        ArrowLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1100, 720));
        setPreferredSize(new java.awt.Dimension(1100, 720));

        QuitButton.setBackground(new java.awt.Color(153, 153, 153));
        QuitButton.setFont(Config.getInstance().getFont(Font.BOLD, 18));
        QuitButton.setForeground(new java.awt.Color(255, 255, 255));
        QuitButton.setText("Quit!");
        QuitButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        QuitButton.setDoubleBuffered(true);
        QuitButton.setMinimumSize(new java.awt.Dimension(80, 30));
        QuitButton.setPreferredSize(new java.awt.Dimension(80, 30));
        QuitButton.setRolloverEnabled(true);
        QuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitButtonActionPerformed(evt);
            }
        });

        RightButton.setBackground(new java.awt.Color(153, 153, 153));
        RightButton.setFont(Config.getInstance().getFont(Font.BOLD, 14));
        RightButton.setForeground(new java.awt.Color(255, 255, 255));
        RightButton.setText(">");
        RightButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        RightButton.setDoubleBuffered(true);
        RightButton.setMinimumSize(new java.awt.Dimension(50, 50));
        RightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightButtonActionPerformed(evt);
            }
        });

        UpButton.setBackground(new java.awt.Color(153, 153, 153));
        UpButton.setFont(Config.getInstance().getFont(Font.BOLD, 14));
        UpButton.setForeground(new java.awt.Color(255, 255, 255));
        UpButton.setText("^");
        UpButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        UpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpButtonActionPerformed(evt);
            }
        });

        DownButton.setBackground(new java.awt.Color(153, 153, 153));
        DownButton.setFont(Config.getInstance().getFont(Font.BOLD, 14));
        DownButton.setForeground(new java.awt.Color(255, 255, 255));
        DownButton.setText("v");
        DownButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        DownButton.setDoubleBuffered(true);
        DownButton.setMaximumSize(new java.awt.Dimension(60, 60));
        DownButton.setMinimumSize(new java.awt.Dimension(50, 50));
        DownButton.setPreferredSize(new java.awt.Dimension(50, 50));
        DownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownButtonActionPerformed(evt);
            }
        });

        LeftButton.setBackground(new java.awt.Color(153, 153, 153));
        LeftButton.setFont(Config.getInstance().getFont(Font.BOLD, 14));
        LeftButton.setForeground(new java.awt.Color(255, 255, 255));
        LeftButton.setText("<");
        LeftButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        LeftButton.setPreferredSize(new java.awt.Dimension(50, 50));
        LeftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftButtonActionPerformed(evt);
            }
        });

        TimerLabel.setFont(Config.getInstance().getFont(Font.BOLD, 18));
        TimerLabel.setForeground(new java.awt.Color(255, 255, 255));

        NumLapsLabel.setFont(Config.getInstance().getFont(Font.BOLD, 18));
        NumLapsLabel.setForeground(new java.awt.Color(255, 255, 255));
        NumLapsLabel.setToolTipText("");

        YourTimeLabel.setFont(Config.getInstance().getFont(Font.BOLD, 16));
        YourTimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        YourTimeLabel.setText("Your time:");

        PlayerNameLabel.setFont(Config.getInstance().getFont(Font.BOLD, 16));
        PlayerNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        PlayerNameLabel.setText(Controller.getInstance().getPlayerName());

        GoodGameLabel.setFont(Config.getInstance().getFont(Font.BOLD, 30));
        GoodGameLabel.setForeground(new java.awt.Color(255, 255, 255));

        LakituLabel.setDoubleBuffered(true);
        LakituLabel.setMaximumSize(new java.awt.Dimension(300, 300));

        BoostToggleButton.setBackground(new java.awt.Color(153, 153, 153));
        BoostToggleButton.setFont(Config.getInstance().getFont(Font.BOLD, 18));
        BoostToggleButton.setForeground(new java.awt.Color(255, 255, 255));
        BoostToggleButton.setText("Boost!");
        BoostToggleButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        BoostToggleButton.setDoubleBuffered(true);
        BoostToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoostToggleButtonActionPerformed(evt);
            }
        });

        BrakeToggleButton1.setBackground(new java.awt.Color(153, 153, 153));
        BrakeToggleButton1.setFont(Config.getInstance().getFont(Font.BOLD, 18));
        BrakeToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        BrakeToggleButton1.setText("Brake!");
        BrakeToggleButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        BrakeToggleButton1.setDoubleBuffered(true);
        BrakeToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrakeToggleButton1ActionPerformed(evt);
            }
        });

        PressKeyToStartLabel.setFont(Config.getInstance().getFont(Font.BOLD, 16));
        PressKeyToStartLabel.setForeground(new java.awt.Color(255, 255, 255));
        PressKeyToStartLabel.setText("Press right arrow button to start!");

        CommandLabel.setFont(Config.getInstance().getFont(Font.BOLD, 15));
        CommandLabel.setForeground(new java.awt.Color(255, 255, 255));
        CommandLabel.setText("Use boost button to accelerate!\n Use Brake button to slow down!");

        ArrowLabel.setFont(Config.getInstance().getFont(Font.BOLD, 20));
        ArrowLabel.setForeground(new java.awt.Color(255, 255, 255));
        ArrowLabel.setText("--->");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TimerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NumLapsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BoostToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(LeftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(4, 4, 4)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(DownButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(RightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(UpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(BrakeToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(YourTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PressKeyToStartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(GoodGameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                            .addComponent(PlayerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LakituLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ArrowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(482, 482, 482))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CommandLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(ArrowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YourTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PressKeyToStartLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TimerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlayerNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(GoodGameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LakituLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(NumLapsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LeftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DownButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(UpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addComponent(BoostToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BrakeToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(CommandLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        QuitButton.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void QuitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitButtonActionPerformed
        if (this.numLaps == 3) {
            Controller.getInstance().quitRace();
            Controller.getInstance().startStopVictoryMusic("congratulations", true);
            Controller.getInstance().loadPlayerName(Controller.getInstance().getPlayerName());
            timer.stop();
            Controller.getInstance().setTime(second);
            Controller.getInstance().saveTime(second);
            Controller.getInstance().setActualTime();
            Controller.getInstance().loadBestTime();

        }
    }//GEN-LAST:event_QuitButtonActionPerformed

    protected Timer startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                TimerLabel.setText(String.valueOf(second) + " " + "s");

                if (numLaps == 3) {
                    timer.stop();
                } else {
                    second++;
                }
            }
        });
        return timer;
    };
  
    protected void startRefreshTimer() {
        refreshTimer = new Timer(refreshRate, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                if (numLaps == 3) {
                    refreshTimer.stop();
                } else {
                    next();
                }
            }
        });
        refreshTimer.start();
    };
    
    private void RightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightButtonActionPerformed
        this.isStarted = true;
        this.isMovingRight = true;
        this.isMovingDown = false;
        this.isMovingUp = false;
        this.isMovingLeft = false;
        this.repaint();
        this.timer.start();
        this.refreshTimer.start();
    }//GEN-LAST:event_RightButtonActionPerformed

    private void LeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftButtonActionPerformed
        if (this.isStarted) {
            this.isMovingRight = false;
            this.isMovingDown = false;
            this.isMovingUp = false;
            this.isMovingLeft = true;
           this.repaint();    }//GEN-LAST:event_LeftButtonActionPerformed
    }
    private void UpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpButtonActionPerformed
        if (this.isStarted) {
            this.isMovingRight = false;
            this.isMovingDown = false;
            this.isMovingUp = true;
            this.isMovingLeft = false;
           this.repaint();    }//GEN-LAST:event_UpButtonActionPerformed
    }
    private void DownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownButtonActionPerformed
        if (this.isStarted) {
            this.isMovingRight = false;
            this.isMovingDown = true;
            this.isMovingUp = false;
            this.isMovingLeft = false;
           this.repaint();      }//GEN-LAST:event_DownButtonActionPerformed
    }
    private void BoostToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoostToggleButtonActionPerformed
        if (this.BoostToggleButton.isSelected()) {
            this.pixelIncrease=5;
            this.finishLineGap=4;
            this.BrakeToggleButton1.setSelected(false);
        }
         if (!this.BoostToggleButton.isSelected())
             this.pixelIncrease=2;
        }
    
    
    private void BrakeToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrakeToggleButton1ActionPerformed
        if (this.BrakeToggleButton1.isSelected()) {
            this.pixelIncrease = 1;
            this.finishLineGap=0;
            this.BoostToggleButton.setSelected(false);
        }
        if (!this.BrakeToggleButton1.isSelected())
            this.pixelIncrease=2;
        }

    protected void startStopMusic(String trackTitle, boolean condition) {
        if (condition) {        //condition == true means music has to start
            this.sequencer = Config.getInstance().getMusic("Music", trackTitle);
            if (this.sequencer != null) {
                this.sequencer.start();
            }
        } else {
            this.sequencer.stop();
            this.sequencer = null;
        }
    };

    protected void setSprite(String kartSprite) {
        this.kartSprite = Config.getInstance().getSelectedImage("KartSprites", kartSprite, ".png");
    };
   
    protected void setBackground() {
        this.raceBackground = Config.getInstance().getSelectedImage("Tracks", "Rainbow", ".png");
    };

    protected void setPlayerName(String playerName) {
        this.PlayerNameLabel.setText("Let's go " + " " + playerName + " !");
    };
  
    protected void increaseNumLaps() {
        if(!this.BoostToggleButton.isSelected() && !this.BrakeToggleButton1.isSelected())
            this.finishLineGap=1;
        if (this.kartXPosition>=(600-finishLineGap) && this.kartXPosition <=600 && this.kartYPosition < 60) {
            this.numLaps++;
        }
        this.NumLapsLabel.setText(String.valueOf(numLaps) + " " + " /3  laps");
        if (numLaps == 3) {
            this.LakituLabel.setIcon(new ImageIcon(Config.getInstance().getKartGif("KartGIF", "Lakitu")));
            this.GoodGameLabel.setText("Good game!");
        }
    };
     
    protected void drawSelectedKartSprite(Graphics g) {
        g.drawImage(kartSprite,
                kartXPosition,
                kartYPosition,
                kartXPosition + SPRITE_X_GAP,
                kartYPosition + SPRITE_Y_GAP,
                spriteXPixel, spriteYPixel, spriteXPixel + SPRITE_X_GAP, spriteYPixel + SPRITE_Y_GAP,
                this);
    };

    protected void setMainGUI(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    };

    protected void right() {
        if (Controller.getInstance().isRunnable(kartXPosition + this.pixelIncrease + 15, kartYPosition + 5)) {
            this.spriteXPixel = 60;
            this.kartXPosition = kartXPosition + this.pixelIncrease;
            increaseNumLaps();
            Controller.getInstance().setXYIndex(kartXPosition, kartYPosition);
        }
    };
      
    protected void left() {
        if (Controller.getInstance().isRunnable(kartXPosition - this.pixelIncrease + 15, kartYPosition + 5)) {
            this.spriteXPixel = 90;
            this.kartXPosition = kartXPosition - this.pixelIncrease;
            increaseNumLaps();
            Controller.getInstance().setXYIndex(kartXPosition, kartYPosition);
        }
    };

    protected void up() {
        if (Controller.getInstance().isRunnable(kartXPosition + 10, kartYPosition - this.pixelIncrease + 15)) {
            this.kartYPosition = kartYPosition - this.pixelIncrease;
            this.spriteXPixel = 0;
            increaseNumLaps();
            Controller.getInstance().setXYIndex(kartXPosition, kartYPosition);
        }
    };
    
    protected void down() {
        if (Controller.getInstance().isRunnable(kartXPosition + 10, kartYPosition + this.pixelIncrease + 15)) {
            this.spriteXPixel = 30;
            this.kartYPosition = kartYPosition + this.pixelIncrease;
            increaseNumLaps();
            Controller.getInstance().setXYIndex(kartXPosition, kartYPosition);
        }
    };     
      
    protected void next() {
        if (isMovingRight) {
            this.right();
            this.repaint();
        } else if (isMovingLeft) {
            this.left();
            this.repaint();
        } else if (isMovingUp) {
            this.up();
            this.repaint();
        } else if (isMovingDown) {
            this.down();
            this.repaint();
        }
    };
   
    protected void resetTimer() {
        if (timer.isRunning() || refreshTimer.isRunning()) {
            timer.stop();
            refreshTimer.stop();
        }
        this.TimerLabel.setText(String.valueOf(second) + " s");
    }

    protected void resetAll() {
        this.kartXPosition = 600;
        this.kartYPosition = 20;
        this.spriteXPixel = 60;
        this.spriteYPixel = 0;
        this.numLaps = 0;
        this.second = 0;
        this.resetTimer();
        this.isStarted = false;
        this.isMovingDown = false;
        this.isMovingLeft = false;
        this.isMovingRight = false;
        this.isMovingUp = false;
        this.LakituLabel.setIcon(null);
        this.GoodGameLabel.setText("");
    };
              
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (this.raceBackground != null && this.mainGUI != null) {
            g.drawImage(this.raceBackground,
                    0,
                    0,
                    1100,
                    720,
                    0, 0, 1100, 720,
                    this);
        }
        if (this.kartSprite != null) {
            drawSelectedKartSprite(g);
        }
    };
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ArrowLabel;
    private javax.swing.JToggleButton BoostToggleButton;
    private javax.swing.JToggleButton BrakeToggleButton1;
    private javax.swing.JLabel CommandLabel;
    private javax.swing.JButton DownButton;
    private javax.swing.JLabel GoodGameLabel;
    private javax.swing.JLabel LakituLabel;
    private javax.swing.JButton LeftButton;
    private javax.swing.JLabel NumLapsLabel;
    private javax.swing.JLabel PlayerNameLabel;
    private javax.swing.JLabel PressKeyToStartLabel;
    private javax.swing.JButton QuitButton;
    private javax.swing.JButton RightButton;
    private javax.swing.JLabel TimerLabel;
    private javax.swing.JButton UpButton;
    private javax.swing.JLabel YourTimeLabel;
    // End of variables declaration//GEN-END:variables

}