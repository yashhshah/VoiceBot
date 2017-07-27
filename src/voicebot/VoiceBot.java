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
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VoiceBot { 
    
   
    public static void main(String args[]) throws IOException, AWTException, InterruptedException{
        
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
    ArrayList<String> tabs = new ArrayList<String>();
    ArrayList<String> windows = new ArrayList<String>();
    ArrayList<Integer> windowNum = new ArrayList<Integer>();
   
    
    
   //for selenium scripting, create the chrome driver and set property since selenium only supports firefox
   WebDriver driver = null;
     
     
     
     //arrays for windoe handles and window numbers
     
     int windowNumber = -1;
     int tabNumber = windowNumber;
     String currentHandle = null;
     
    
    
    //keeps recognizing speech until i say shutdown
   while ((result = r.getResult()) != null) {
        String whatCommand = result.getHypothesis();
        System.out.println(whatCommand);
        
        
        //COMMANDS START
        
        
        /*
        ------------------------------------------------------------------------
        -----------------------------------------------------------------------
        ------------------------------------------------------------------------
        ------------------------------------------------------------------------
        ------------------------------------------------------------------------
        */
        //GOOGLE FUNCTIONS  
        if(whatCommand.equals("zero open google") ){
            if(whatCommand.equals("zero open google")){
                try{
                 driver.get("https://www.google.ca/");
                }
                catch(Exception e){
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yash Shah\\Documents\\NetBeansProjects\\VoiceBotApp\\chromedriver.exe");
                    driver = new ChromeDriver();    
                    driver.get("https://www.google.ca/");
                    
                    
                }}
        }
        
        
                
        /*
        ------------------------------------------------------------------------
        -----------------------------------------------------------------------
        ------------------------------------------------------------------------
        ------------------------------------------------------------------------
        ------------------------------------------------------------------------
        */              
                
         //YOUTUBE COMMANDS       
                
            else if(whatCommand.equals("zero open youtube") || whatCommand.equals("zero change to youtube")){   
                try{
                 driver.get("https://www.youtube.com/");    
                }
                catch(Exception e){
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yash Shah\\Documents\\NetBeansProjects\\VoiceBotApp\\chromedriver.exe");
                    driver = new ChromeDriver();    
                    driver.get("https://www.youtube.com/");    
                    
                    
                }
            }
                    
            
//        
//      
//        /*
//        ------------------------------------------------------------------------
//        -----------------------------------------------------------------------
//        ------------------------------------------------------------------------
//        ------------------------------------------------------------------------
//        ------------------------------------------------------------------------
//        */    
//            
//        //GENERIC COMMANDS
//        
        else if(whatCommand.equals("zero close tab")){
            
          windows = new ArrayList<String>(driver.getWindowHandles()); 
          windowNumber--;
          try{
          driver.switchTo().window(windows.get(windowNumber)).close();
          } 
          catch(Exception e){
               driver.quit();
          
          }
    
    
    }
            
            
            
            
            
        
        
//        
        else if(whatCommand.equals("zero new tab")){
            try{
                ((JavascriptExecutor)driver).executeScript("window.open()");
                windowNumber++;  
                tabNumber = windowNumber;
                tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(windowNumber));
            } 
            catch(Exception e){
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yash Shah\\Documents\\NetBeansProjects\\VoiceBotApp\\chromedriver.exe");
                driver = new ChromeDriver();    
                driver.get("https://www.google.ca/");
            
            
            }
           
            
        
        }
        
        else if(whatCommand.equals("zero last tab")){
            try{
            if(windowNumber-1>=0){
                tabNumber--; 
                tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(tabNumber));
            }
            }
            catch(Exception e){
            
            }
            
        
        }
        
        else if(whatCommand.equals("zero next tab")){
            try{
            tabNumber++; 
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabNumber));
            
            } 
            catch(Exception e){
            }
            
        
        }
//        
        else if(whatCommand.equalsIgnoreCase("zero new window")){
            if(windowNumber==-1){
               System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yash Shah\\Documents\\NetBeansProjects\\VoiceBotApp\\chromedriver.exe");
                driver = new ChromeDriver();    
                driver.get("https://www.google.ca/");
                driver.getWindowHandles();
                
            }
            
            else{
                Robot ra = new Robot();
                ra.keyPress(KeyEvent.VK_CONTROL);
                ra.keyPress(KeyEvent.VK_N);
                ra.keyRelease(KeyEvent.VK_CONTROL);
                ra.keyRelease(KeyEvent.VK_N); 
                driver.getWindowHandles();
            }
            windowNumber++;
            tabNumber = windowNumber;
            
             windows = new ArrayList<String>(driver.getWindowHandles());
             if(windowNumber>0){
                 driver.switchTo().window(windows.get(windows.size()-1));
             }
            windowNum.add(windowNumber);
                              
             
        
        }
//      
        else if(whatCommand.equals("zero close window")){
            
            
            
            windows = new ArrayList<String>(driver.getWindowHandles()); 
            if(windows.size()>1){
             int counter = windows.size()-1;
            
                boolean end = false; 
            
                while(!end){
               
                    if(counter!=windowNum.get(windowNum.size()-1)){
                    
                    
                        driver.switchTo().window(windows.get(counter-1)).close();
                        counter--; 
                    
                    
                       
                    }       
                    
                    
                            
                
                
                
                    else{
                    
                        windowNum.remove(windowNum.size()-1); 
                        end = true;
                    
                    
                        }
                
                
                
                
                
                }
               
            
            }
            else{
                driver.quit();
                windowNumber=-1;
                
            
            }
            
        }
        
        else if(whatCommand.equals("zero maximize")){
            driver.manage().window().maximize();
        }
        
        else if(whatCommand.equals("zero sign me in")){
            if(driver.getCurrentUrl().equals("https://www.google.com/gmail/about/#") ||driver.getTitle().equals("Gmail") ){
                
                if(driver.getCurrentUrl().equals("https://www.google.com/gmail/about/#")){
                    driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
                    Thread.sleep(1000);
                    
                }
                
            
            }
            
                driver.findElement(By.id("identifierId")).sendKeys("yashhshah1999@gmail.com");
                driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
                
                
                    
                
            }
        
        
        else if(whatCommand.equals("zero next")){
            driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content")).click();
        
        
        }
        
        
        else if(whatCommand.equals("zero sign me out")){
                 //if(driver.getCurrentUrl().equals("https://mail.google.com/mail/u/0/#inbox")){
                   
                    try{
                    driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
                    } 
                    catch(Exception e){
                    driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[4]/div[1]/a")).click();
                    }
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();
                 
                 
                 
                 
             
            
        
        
        }
                
        
        
          
        
        
//
////        }
//        
//        /*
//        ------------------------------------------------------------------------
//        -----------------------------------------------------------------------
//        ------------------------------------------------------------------------
//        ------------------------------------------------------------------------
//        ------------------------------------------------------------------------
//        */
//        
//        //GMAIL COMMANDS
//        
//        
        else if(whatCommand.equals("zero open my mail") || whatCommand.equals("zero change to my mail")){
           
                try{
                     driver.get("https://www.gmail.com");
                     
                } 
                catch(Exception e){
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yash Shah\\Documents\\NetBeansProjects\\VoiceBotApp\\chromedriver.exe");
                    driver = new ChromeDriver();    
                    driver.get("https://www.gmail.com");
                
                
                }
                    
        
        
            }
            
      
        
        
        else if(whatCommand.equals("zero open facebook")){
           driver.get("https://www.facebook.com/");            
            
        
        }
        
        
//        else if(whatCommand.equals("zero close google") || whatCommand.equals("zero close youtube") || whatCommand.equals("zero close john's channel") || whatCommand.equals("zero close felix's channel")
//                || whatCommand.equals("zero close my mail")){
//            
//            Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
//        
//        }
        else if(whatCommand.equals("zero shutdown")){
            r.stopRecognition();
            Runtime.getRuntime().halt(0);
            System.exit(0);
 }
//        
     
    }
   
   }
}

    


    
    
 
	
    
    

