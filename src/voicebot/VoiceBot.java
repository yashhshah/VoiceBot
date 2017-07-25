/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voicebot;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import java.io.IOException;

public class VoiceBot { 
    
    @SuppressWarnings("empty-statement")
    public static void main(String args[]) throws IOException{
        
        Configuration c = new Configuration(); 
        
        
        //set language, acoustics etc. 
        // Set path to acoustic model.
    c.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
    // Set path to dictionary.
    c.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
    // Set language model.
        
    c.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
    c.setGrammarPath("/Users/Yash%20Shah/Documents/NetBeansProjects/VoiceBotApp");
    c.setGrammarName("gr");
    c.setUseGrammar(true);
    
    //create the live speech recognizer
    
    LiveSpeechRecognizer r = new LiveSpeechRecognizer(c); 
    
    r.startRecognition(true);
    SpeechResult result = r.getResult();
    int systemShutdown = 0;
    
   
   while ((result = r.getResult()) != null) {
        String whatCommand = result.getHypothesis();
        System.out.println(whatCommand);
        if(whatCommand.equals("zero open google")){
             Runtime.getRuntime().exec("\"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe\""); 
        
    
        }
        else if(whatCommand.equals("zero open youtube")){
            String[] a = {"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe", "https://www.youtube.com/"};
            Runtime.getRuntime().exec(a);
        
        }
        else if(whatCommand.equals("zero open john's channel") || whatCommand.equals("zero open felix's channel")){
            
            if(whatCommand.equals("zero open john's channel")){
                String[] a = {"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe", "https://www.youtube.com/user/MrFish235"};
                Runtime.getRuntime().exec(a);
            }
           
            else{
                String[] a = {"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe", "https://www.youtube.com/channel/UC-lHJZR3Gqxm24_Vd_AJ5Yw"};
                Runtime.getRuntime().exec(a); 
                
            }
            
            
        
        }
        
        else if(whatCommand.equals("zero open my mail")){
            String[] a = {"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe", "https://mail.google.com/mail/u/0/#inbox"};
            Runtime.getRuntime().exec(a);
        
        
        }
        
        else if(whatCommand.equals("zero open facebook")){
            String[] a = {"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe", "https://www.facebook.com/"};
            Runtime.getRuntime().exec(a);
            
        
        }
        else if(whatCommand.equals("zero close google") || whatCommand.equals("zero close youtube") || whatCommand.equals("zero close john's channel") || whatCommand.equals("zero close felix's channel")
                || whatCommand.equals("zero close my mail")){
            
            Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
        
        }
        else if(whatCommand.equals("zero shutdown")){
            r.stopRecognition();
            Runtime.getRuntime().halt(0);
            System.exit(0);
            
        
        }
        
        
    }
   r.stopRecognition();
}
    
    }
    
    
 
	
    
    

