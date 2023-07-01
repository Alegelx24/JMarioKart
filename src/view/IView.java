/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author alessandrogelsi
 */

public interface IView {
    
    public void openMainGUI();
    
    public void startStopWelcomeMusic(boolean condition);
    
    public void startStopRaceMusic(String trackTitle, boolean condition);
    
    public void startStopVictoryMusic(String trackTitle, boolean condition);
    
    public void loadTeamGraphics(String kartSprite, String raceBackground);
    
    public void quitRace();
    
    public void restartNewGame();
    
    public void loadPlayerName(String playerName);
    
    public void setActualTime();
    
    public void setBestTime();

    public void right();
    
    public void left();
    
    public void up();

    public void down();

    public void startStopTimer(boolean condition);
}
