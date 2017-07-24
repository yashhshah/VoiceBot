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
    
    public static void main(String args[]) throws IOException{
        
        Configuration c = new Configuration(); 
        
        //set language, acoustics etc. 
        // Set path to acoustic model.
    c.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
    // Set path to dictionary.
    c.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
    // Set language model.
    c.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
    
    
    
    //create the live speech recognizer
    LiveSpeechRecognizer r = new LiveSpeechRecognizer(c); 
    
    r.startRecognition(true);
    SpeechResult result = r.getResult();
    while ((result = r.getResult()) != null) {
    System.out.println(result.getHypothesis());
}
    
    }
    
    
}
