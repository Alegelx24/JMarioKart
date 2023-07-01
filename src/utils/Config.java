/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence; 
import javax.sound.midi.Sequencer;

/**
 *
 * @author alessandrogelsi
 */


public class Config {
    
    //---------------------------------------------------------------
    // STATIC CONSTANTS
    //---------------------------------------------------------------
    private final static boolean IS_DIST_VERSION = true;
    
    //---------------------------------------------------------------
    // STATIC ATTRIBUTE
    //---------------------------------------------------------------
    private static Config instance = null;

    //---------------------------------------------------------------
    // INSTANCE ATTRIBUTE
    //---------------------------------------------------------------
    private String path;
    private Font font = null;
    
    
    private Config() {
     if (IS_DIST_VERSION)
            setPathDistVersion();
      else
            setPathDevVersion();   
    }
    
    //PATH WITHOUT JAR (DEV VERSION)    //ONLY ON WINDOWS
    private void setPathDevVersion() {
        try {
            URL classURL = Config.class.getResource("Config.class");           
            URI classURI = classURL.toURI(); 
            this.path = new java.io.File(classURI).getParentFile().getParentFile().getParentFile().getParentFile().getAbsolutePath()
                        + "\\src\\resources";
        } catch (URISyntaxException ex) {
            System.out.println("URIException durante il caricamento del welcomeBackground");
            this.path = null;
        }        
    }
    
    //PATH WITH JAR (DIST VERSION)     //ONLY ON WINDOWS
    private void setPathDistVersion() {
        try {
            URL classURL = Config.class.getResource("Config.class");           
            URI classURI = classURL.toURI(); 
            String jarPath = classURI.toString();
            int indexOfExclamationMark = jarPath.indexOf("!");
            String prefix = "jar:file:/"; //prefix for Windows OS platform		
            String homeDir = jarPath.substring(prefix.length(), indexOfExclamationMark);           
            int lastIndexOfSlash = homeDir.lastIndexOf("/");
            this.path = homeDir.substring(0, lastIndexOfSlash);      
            this.path = this.path + "\\resources";
        } catch (URISyntaxException ex) {
            System.out.println("URIException durante il caricamento del welcomeBackground");
            this.path = null;
        }        
    }
   
    
    public String getPath() {
        return this.path;
    }
    
    //TESTATO FUNZIONANTE (OTTENGO LA LISTA DI TUTTI I FILE NELLA CARTELLA "directory" CON L'ESTENSIONE
    private String[] getFileList (String directory, String fileType) {       //used to get a String[] containing all the files of given type
        File dir = new File(directory);
        String[] files = dir.list(new FilenameFilter() {
                @Override
                public boolean accept(File file, String name) {
                    return name.endsWith(fileType);
            }
        }); 
        return files;
    }
    
    //TESTATO FUNZIONANTE (OTTENGO LA LISTA DI TUTTI I FILE NELLA CARTELLA "directory" TAGLIANDO L'ESTENSIONE
    private String[] getFileListWithoutExtension (String directory, String fileType) {       //used to get a String[] containing all the files(ONLY THE NAME) of given type
        String[] files = getFileList(directory, fileType); 
        for (int i = 0; i< files.length; i++)
            files[i] = files[i].substring(0, files[i].length() - fileType.length());
        return files;
    }
    
    public String[] getAvailable (String directory, String fileType) {
        return getFileListWithoutExtension(this.path + "\\" + directory, fileType);
    }

    public Image getSelectedImage (String directory, String filename, String fileType) {
        try {
            return ImageIO.read(new File(this.path + "\\" + directory + "\\" + filename + fileType));
        } catch (IOException ex) {
            return null;
        }
    }
    
    public BufferedImage getBufferedImage (String directory, String filename, String fileType) {
        try {
            return ImageIO.read(new File(this.path + "\\" + directory + "\\" + filename + fileType));
        } catch (IOException ex) {
            return null;
        }
    }
    
    public Image getKartGif (String directory, String filename) {
        return Toolkit.getDefaultToolkit().createImage(this.path + "\\" + directory + "\\" + filename + ".gif");
    }
    public Sequencer getMusic (String directory, String trackTitle) {
        Sequencer sequencer = null;
        try {
                sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
                if (sequencer==null) {
                    System.out.println("Sequencer device not supported");
                    return sequencer;
                } 
                sequencer.open(); // Open device
                // Creates sequence, the File must contain MIDI file data.
                Sequence sequence = MidiSystem.getSequence(new File(this.path + "\\" + directory + "\\" + trackTitle + ".mid"));
                sequencer.setSequence(sequence); // load it into sequencer
                sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
                
            } catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
                ex.printStackTrace();
            }
        return sequencer;
    }
      
    public Font getBaseFont() {
        if (font == null)
            try {
                font = Font.createFont(Font.TRUETYPE_FONT, new File(this.path + "\\Fonts\\Gill.ttf"));//CAMBIA   
            } catch (FontFormatException ex) {
                System.out.println("Errore nel caricamento del font");
            } catch (IOException ex) {
                System.out.println("Errore nel caricamento del font");
            }
        return font;
    }
    
    public Font getFont (int style, float size) {
        getBaseFont();
        Font newFont;
        if (font != null)
            newFont = font.deriveFont(style, size);
        else
            newFont = Font.getFont(Font.DIALOG);
        return newFont;
    }
    
    //---------------------------------------------------------------
    // STATIC METHODS
    //---------------------------------------------------------------
    
    public static Config getInstance() {
        if (instance == null)
                instance = new Config();
        return instance;
    }
}