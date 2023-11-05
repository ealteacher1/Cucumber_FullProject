package Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends baseClass {
	
	 @Before(value = "@search",order=1)
	 public void before_a() {   
			log.info("**************************  LoginFeatureFile is starting ************************");
			
		   }
	 
	 
	
	
	 @Before (order=2)
	   public void before_b() { 
		 
//		 log.info("**************************  Configuring extent Report ************************"); 
//		 configureReport();
		
	   }
	 
	 @After
	 public void after_a() {
//		 log.info("**************************  Preparing Report ************************"); 
//		 reports.flush();
		 log.info("**************************  Closing Browser ************************");  
		 tearDown();
	 }

	
	

}
