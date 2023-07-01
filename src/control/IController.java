/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author alessandrogelsi
 */

public interface IController {
    
        public void openMainGUI();

        public void startStopTimer(boolean condition);
        
        public void startStopWelcomeMusic(boolean condition);
    
        public void startStopRaceMusic(String trackTitle, boolean condition);
              
        public void startStopVictoryMusic(String trackTitle, boolean condition);

        public void loadTeamGraphics(String kartSprite, String raceBackground );
        
        public void setActualTime();
        
        public void loadBestTime();
        
        public void quitRace();
        
        public void restartNewGame();
        
        public String getPlayerName();
        
        public String getSelectedKartName();
        
        public void loadPlayerName(String playerName);

        public int getXIndex();

	public int getYIndex();
        
	public void initGame();

        public void up();
        
	public void down();
	
	public void left();
	
	public void right();
        
        public void setSelectedKart(int kartIndex);
        
        public void setTime(int actualTime);

        public void saveTime(int actualTime);

        public int[] getBestTimes();

        public void setPlayerName(String newPlayerName);

        public int getRecord();

        public void setXYIndex(int x, int y);

        public boolean isRunnable(int x, int y);

        public void resetAll();

}
