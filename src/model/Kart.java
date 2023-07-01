/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alessandrogelsi
 */
public class Kart{
    
    protected String kartName;
    
    protected Kart() {
    //do nothing
    };
    
    protected static Kart[] SELECTED_KART_ARRAY = new Kart[7];
    
    protected static HashMap<String, Kart> mapStringNameToKartObj= new HashMap<String, Kart>();
        static {
        try {
            SELECTED_KART_ARRAY[0] = new Mario();
            SELECTED_KART_ARRAY[1] = new Luigi();
            SELECTED_KART_ARRAY[2] = new Peach();
            SELECTED_KART_ARRAY[3] = new Bowser();
            SELECTED_KART_ARRAY[4] = new Koopa();
            SELECTED_KART_ARRAY[5] = new Yoshi();
            SELECTED_KART_ARRAY[6] = new Donkey();
            
            for (int i = 0; i < SELECTED_KART_ARRAY.length; i++)
                mapStringNameToKartObj.put((SELECTED_KART_ARRAY[i]).getKartName(), SELECTED_KART_ARRAY[i]);
            } catch (IOException ex) {
                Logger.getLogger(Kart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
//---------------------------------------------------------------
// METHODS
//---------------------------------------------------------------
    
    protected String getKartName() {
	return this.kartName;
    };
 
    protected static  Kart getSelectedKartByName(String kartName) {
	return mapStringNameToKartObj.get(kartName);
    };      
}

