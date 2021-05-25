package de.intergrata.firstspring;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
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
    	
    	
    	System.out.println("-----------------");
		
		Demo demo = (Demo) context.getBean("demo");
		
		demo.print();
		
		Demo demo2 = (Demo) context.getBean("demo");
		
		System.out.println(demo == demo2);
		
		
		
		LOGGER.info("Finished");
    }
}
