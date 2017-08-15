# VoiceBot

Having a bluetooth keyboard, my goal was to replace my mouse by just my voice so that I could work on my computer without having to just sit on my chair all day. Zero is a desktop voice bot that allows repetitive browser tasks to be done by just your voice. It was coded using the sphinx4 library in java and uses selenium webdriver and javascript for window and browser manipulation. 



List of commands(taken from the grammar file I made, hence in that format)


public <OpenCloseCommands> = (zero open | zero close) (google|youtube|my mail|facebook|twitter);

public <exitbot> = (zero shutdown);

public <changeWindow> = (zero change to) (google|youtube|my mail);

public<newWindow> = (zero new window);

public <lastWindow> = (zero last window);

public<closeWindow> = (zero close) (window|tab);


public<tabs> = (zero new tab);

public<lastTab> = (zero last tab);

public<nextTab> = (zero next tab);


public<maximize> = (zero maximize); 

public<signIn> = (zero sign me) (in|out);

