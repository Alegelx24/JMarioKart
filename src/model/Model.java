/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.awt.image.BufferedImage;
import utils.Config;

/**
 *
 * @author alessandrogelsi
 */

public class Model implements IModel {
    
//---------------------------------------------------------------
// STATIC CONSTANTS
//---------------------------------------------------------------
    
    private final static int DEFAULT_TRACK_HEIGHT  = 1100;
    
    private final static int DEFAULT_TRACK_WIDTH  = 720;
        
    private final static int X_INDEX_INIT = 640;
    
    private final static int Y_INDEX_INIT = 20;  
     
//---------------------------------------------------------------
// STATIC FIELDS
//---------------------------------------------------------------
     
    private static Model instance = null;
    
//---------------------------------------------------------------
// INSTANCE ATTRIBUTES
//---------------------------------------------------------------
    
    public String playerName;
    
    private int recordTime;
    
    private int firstTime;
    
    private int secondTime;
    
    private int thirdTime;
   
    private Kart previewKart;
    
    private int kartIndex=0;
    
    private Kart selectedKart;
    
    private int XIndex;
    
    private int YIndex;
    
    private Kart[] selectedKartArray = new Kart[7];
        
    private BufferedImage trackScheme;
    
    private Model() {
        this.trackScheme = Config.getInstance().getBufferedImage("TrackScheme", "RainbowScheme", ".png");
        initGame();
    }
    
//---------------------------------------------------------------
// PRIVATE INSTANCE METHODS
//---------------------------------------------------------------

    private Kart getKartWithIntegerEncoding(int i) {
		Kart kart = null;
		if (i == 0)
			kart = Kart.getSelectedKartByName("Mario");
		else if (i == 1)
			kart = Kart.getSelectedKartByName("Luigi");
		else if (i == 2)
			kart = Kart.getSelectedKartByName("Peach");
		else if (i == 3)
			kart = Kart.getSelectedKartByName("Bowser");
		else if (i == 4)
			kart = Kart.getSelectedKartByName("Koopa");
		else if (i == 5)
			kart = Kart.getSelectedKartByName("Yoshi");
		else if (i == 6)
			kart = Kart.getSelectedKartByName("Donkey");
		return kart;
    };    
    
//---------------------------------------------------------------
// PUBLIC INSTANCE METHODS
//---------------------------------------------------------------

    @Override
    public String getNameOfSelectedKart(){
         return this.selectedKart.getKartName();
     };
     
    @Override
    public int getTime(){      
         return this.recordTime;
     };
     
    @Override
    public void setTime(int actualTime){         
          this.recordTime = actualTime;
    };
     
    @Override
    public void saveTime(int actualTime){
         if (this.firstTime== 0 || this.firstTime>actualTime){
             this.thirdTime=this.secondTime;
             this.secondTime=this.firstTime;
             this.firstTime=actualTime;    
         }
         else if(this.secondTime==0 || this.secondTime>actualTime){
                 this.thirdTime=this.secondTime;
                 this.secondTime=actualTime;
         }        
         else if(this.thirdTime==0 || this.thirdTime>actualTime)
               this.thirdTime=actualTime;
    };
     
    @Override
    public int[] getBestTimes(){
        int[] bestTimes = new int[3];
               bestTimes[0]=this.firstTime;
               bestTimes[1]=this.secondTime;
               bestTimes[2]=this.thirdTime;
         return bestTimes;   
    };
     
     
    @Override
    public void setPlayerName(String newPlayerName){         
         this.playerName = newPlayerName;
         if(newPlayerName==null)
             this.playerName="Guest";
    };
     
    @Override
    public String getPlayerName(){     
        if (this.playerName==null)
                   this.playerName="Guest";
        return this.playerName;
    };
         
    @Override
    public int getXIndex(){        
        return this.XIndex;
    };
     
    @Override
    public int getYIndex(){
        return this.YIndex;
    };
     
    @Override
    public void setXIndex(int x){
     	if ((0 <= x) && (x < DEFAULT_TRACK_HEIGHT))
            this.XIndex = x;
     };

    @Override
    public void setYIndex(int y){
     	if ((0 <= y) && (y < DEFAULT_TRACK_WIDTH))
            this.YIndex = y;
     };      
     
    @Override
    public boolean isRunnableArea(int x, int y){           
          boolean isRunnable=false;
          int RGB = this.trackScheme.getRGB(x , y);
          int red = (RGB >> 16) & 255;
          int green = (RGB >> 8) & 255;
          int blue = RGB & 255;
          if(red==0 && green==0 && blue==0 && 0<= x && x < DEFAULT_TRACK_HEIGHT-10 && 0<= y && y < DEFAULT_TRACK_WIDTH-10)
                return isRunnable=true;
          else 
             return isRunnable=false;
    };
     
    @Override
    public int initXIndex(){
         this.XIndex=X_INDEX_INIT;
         return X_INDEX_INIT;
    };
     
    @Override
    public int initYIndex(){
         this.YIndex=Y_INDEX_INIT;
         return Y_INDEX_INIT;
    }; 
     
    @Override
    public void initGame(){
	this.XIndex = X_INDEX_INIT;
	this.YIndex = Y_INDEX_INIT;
    };     

    @Override
    public void setSelectedKart(int newKartIndex){    
        this.kartIndex = newKartIndex;
        this.selectedKart = getKartWithIntegerEncoding(kartIndex);
    };
    
    @Override
    public String getSelectedKartName() {
        String selectedKart;
        selectedKart = this.selectedKartArray[kartIndex].getKartName();
        return selectedKart;
    }
    
    @Override
    public int getSelectedKart() {
        return kartIndex;
    };

    @Override
    public void resetAll() {    
        this.kartIndex=-1;
        this.selectedKart=null;
    };

//---------------------------------------------------------------
// STATIC METHODS
//---------------------------------------------------------------
    
    public static IModel getInstance() {
	if (instance == null)
		instance = new Model();
        return instance;
    };
}



