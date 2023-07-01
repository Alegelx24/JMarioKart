/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author alessandrogelsi
 */

public interface IModel {

     public String getNameOfSelectedKart();
     
     public void setSelectedKart(int kartIndex);
          
     public String getSelectedKartName();
     
     public int getSelectedKart();

     public int getTime();
     
     public void setTime(int actualTime);
     
     public void saveTime(int actualTime);
     
     public int[] getBestTimes();
      
     public void setPlayerName(String newPlayerName);
     
     public String getPlayerName();
     
     public int getXIndex();
     
     public int getYIndex();
     
     public void setXIndex(int x);

     public void setYIndex(int y);  
     
     public boolean isRunnableArea( int x, int y);
  
     public int initXIndex();
     
     public int initYIndex(); 
     
     public void initGame();
     
     public void resetAll();  
    
}
