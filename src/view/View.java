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
public class View implements IView  {
    
//---------------------------------------------------------------
// STATIC FIELDS
//---------------------------------------------------------------
   
    private static View instance = null;
    
//---------------------------------------------------------------
// INSTANCE ATTRIBUTES
//---------------------------------------------------------------
    
   protected MainGUI mainGUI = null;
   
   private View(){
   
   };     
   
//---------------------------------------------------------------
// INSTANCE METHODS
//---------------------------------------------------------------
    
    @Override
    public void openMainGUI() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (mainGUI == null)
                    mainGUI = new MainGUI();
                mainGUI.setVisible(true);
            }
        });
    };
      
    @Override
    public void startStopWelcomeMusic(boolean condition) {
        this.mainGUI.startStopWelcomeMusic(condition);
    };
    
    @Override
    public void startStopRaceMusic(String trackTitle, boolean condition) {
        this.mainGUI.startStopRaceMusic(trackTitle, condition);
    };
    
    @Override
    public void startStopVictoryMusic(String trackTitle, boolean condition) {
        this.mainGUI.startStopVictoryMusic(trackTitle, condition);
    };
    
    @Override
    public void loadTeamGraphics(String kartSprite, String raceBackground) {
        this.mainGUI.loadTeamGraphics(kartSprite, raceBackground);
    };
    
    @Override
    public void quitRace(){
        this.mainGUI.quitRace();
    };
    
    @Override
    public void restartNewGame(){
        this.mainGUI.restartNewGame();
        this.mainGUI.resetAll();
    };
      
    @Override
    public void loadPlayerName(String playerName){
        this.mainGUI.loadPlayerName(playerName);
    };
    
    @Override
    public void setActualTime(){
        this.mainGUI.setActualTime();
    };
    
    @Override
    public void setBestTime(){
        this.mainGUI.setBestTime();
    };

    @Override
    public void right(){
        this.mainGUI.right();
    };

    @Override
    public void left(){
        this.mainGUI.left();
    };

    @Override
    public void up(){
        this.mainGUI.up();
    };

    @Override
    public void down(){
        this.mainGUI.down();
    };
    
    @Override
    public void startStopTimer(boolean condition){
        this.mainGUI.startStopTimer(condition);
    };
    
//---------------------------------------------------------------
// STATIC METHODS
//---------------------------------------------------------------

   public static IView getInstance() {
       if (instance == null)
		instance = new View();
       return instance;
    } 
}//end class


