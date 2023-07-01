/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import utils.Config;

/**
 *
 * @author alessandrogelsi
 */

public class Main {
    
    	public static void main(String[] args) {
		Config.getInstance(); 
		Controller.getInstance().openMainGUI();
	}
    
}
