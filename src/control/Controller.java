/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Model;
import view.View;

/**
 *
 * @author alessandrogelsi
 */

public class Controller implements IController {
    
//---------------------------------------------------------------
// STATIC FIELDS
//---------------------------------------------------------------
    
    private static Controller instance = null;
    
    private Controller() {
        //to-do
           }
    

//---------------------------------------------------------------
// PUBLIC INSTANCE METHODS
//---------------------------------------------------------------
  
    @Override
    public void openMainGUI(){
            View.getInstance().openMainGUI();
    }
 
    @Override
    public void startStopTimer(boolean condition){
           View.getInstance().startStopTimer(condition);
       };

    @Override
    public void startStopWelcomeMusic(boolean condition) {
        View.getInstance().startStopWelcomeMusic(condition);
        View.getInstance().startStopVictoryMusic( "congratulations", !condition);
    }
    
    @Override
    public void startStopRaceMusic(String trackTitle, boolean condition) {
        View.getInstance().startStopWelcomeMusic(!condition);
        View.getInstance().startStopRaceMusic(trackTitle, condition);
    }
    
        @Override
    public void startStopVictoryMusic(String trackTitle, boolean condition) {
        View.getInstance().startStopRaceMusic(trackTitle,!condition);
        View.getInstance().startStopVictoryMusic(trackTitle, condition);
    }

    @Override
    public void loadTeamGraphics(String kartSprite, String raceBackground) {
        View.getInstance().loadTeamGraphics(Model.getInstance().getNameOfSelectedKart(), 
                                            raceBackground 
                                            );
    }
    
    @Override
    public void setActualTime(){
        View.getInstance().setActualTime();
    };

    @Override
    public void loadBestTime() {
        View.getInstance().setBestTime();
    };

    @Override
    public void quitRace(){
        View.getInstance().quitRace();
    };
    
    @Override
    public void restartNewGame(){
        View.getInstance().restartNewGame();
        View.getInstance().startStopVictoryMusic("congratulations", false);
    };
    
    @Override
    public String getPlayerName(){
        return Model.getInstance().getPlayerName();
    };
    
   @Override       
    public void loadPlayerName(String playerName){
        View.getInstance().loadPlayerName(Model.getInstance().getPlayerName());
    };  

    @Override
    public String getSelectedKartName(){
        return Model.getInstance().getNameOfSelectedKart();
    };
   
    @Override
    public void initGame(){
        Model.getInstance().initGame();
    };  

    @Override
    public int getXIndex(){
        return Model.getInstance().getXIndex();
    };

    @Override
    public int getYIndex(){
        return Model.getInstance().getYIndex();
    };
	
    @Override
    public void up(){
        View.getInstance().up();
    };
        
    @Override
    public void down(){
        View.getInstance().down();
    };
	
    @Override
    public void left(){
        View.getInstance().left();
    };
	
    @Override
    public void right(){
        View.getInstance().right();
    };   

     @Override
    public void setPlayerName(String newPlayerName){
        Model.getInstance().setPlayerName(newPlayerName); 
    };

    @Override
    public void setTime(int actualTime){
        Model.getInstance().setTime(actualTime);
    };
    
    @Override
    public int getRecord() {
       return Model.getInstance().getTime();
    };

    @Override
    public void saveTime(int actualTime){
        Model.getInstance().saveTime(actualTime);
    };
    
    @Override
    public int[] getBestTimes(){
        return Model.getInstance().getBestTimes();
    };
    
    @Override
    public void setSelectedKart(int kartIndex) {
        Model.getInstance().setSelectedKart(kartIndex); 
    };

    @Override
    public void resetAll() {
        Model.getInstance().resetAll();
    };

    @Override  
    public void setXYIndex(int x, int y){
        Model.getInstance().setXIndex(x);
        Model.getInstance().setYIndex(y);
    };

    @Override
    public boolean isRunnable(int x, int y) {
        boolean isRunnable;
        isRunnable= Model.getInstance().isRunnableArea(x, y);
        return isRunnable;
    }
         
//---------------------------------------------------------------
// STATIC METHODS
//---------------------------------------------------------------
    
public static IController getInstance() {
		if (instance == null)
			instance = new Controller();
		return instance;
	}
    
}
