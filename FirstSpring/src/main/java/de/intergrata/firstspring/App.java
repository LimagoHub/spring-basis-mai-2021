package de.intergrata.firstspring;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final Logger LOGGER = LogManager.getLogger("App");
	
    public static void main( String[] args )
    {
    	
    	
    	
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		context.registerShutdownHook();
		
		LOGGER.info("Finished");
    }
}
