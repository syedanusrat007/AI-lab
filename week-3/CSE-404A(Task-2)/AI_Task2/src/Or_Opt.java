/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Or_Opt {
    
    /**
	 * improves the route by repeatedly applying the first better Or-opt move
	 * @param individual
	 * @param period
	 * @param vehicle
	 * @return false if cost is not decreased
 	 */
	public static Route apply(Route rt)
	{
            Route route = new Route (rt);
            
           Route chain =new Route (rt);
          
             
             
             
                
           
            System.out.println("Or_opt");
            
               int n = route.route.size();
              
               for ( int chain_size = 3; chain_size>=1; chain_size--) {
                  
 
                   for (int i = 0; i+chain_size-1 <n; i++) {
                    Route tmp_route =new Route (rt);
                    System.out.println("Route: "+route.route);
                    chain.route.clear();
                      
                        for (int j = i; j <=(i+chain_size-1); j++) {
                            System.out.println("chain j:"+j);
                          chain.route.add(route.route.get(j));
                          
                       
                   }
                         System.out.println("chain: "+chain.route);
                        
                    
                        
                         for (int j = i; j <(i+chain_size); j++) {
                               
                               System.out.println("rmv i:"+i);
                               tmp_route.route.remove(i);

                             
                         
                           
                       
                   }
                    System.out.println("tmp: "+tmp_route.route); 
                 
                     int nn = tmp_route.route.size();
                  
                
               
                   for (int j = 1; j <=nn; j++) {
                        Route tmp_route1 =new Route (tmp_route);
                      System.out.println("tmp1 j:"+j);

                       tmp_route1.route.addAll(j, chain.route);
                     
                       
                        if(tmp_route1.updateCost()<route.updateCost()){
                      return tmp_route1;
                  }
                     System.out.println("tmp1: "+tmp_route1.route);    
                   }
                   
                 
                   
               }
                
            }
		return route;
	}
	
    
}
