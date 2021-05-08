
import java.util.Random;
import java.io.*;
import java.util.Collections;



public class OneOneExchange {
    
    private static Random random = new Random(System.currentTimeMillis());
	public static Route apply(Route rt) 
	{
	        System.out.println("OneOne");
		Route route = new Route (rt);
               int n = route.route.size();
               int  ran2 ,max=n,min=0;
              
                int ran = (int) (Math.random() * (max - min)) + min;
              
         do {
        
              ran2 = (int) (Math.random() * (max - min)) + min;
             
    } while (ran != ran2);
  
              Collections.swap(route.route, ran, ran2);
		route.updateCost();
		return route;
	}
    
}
