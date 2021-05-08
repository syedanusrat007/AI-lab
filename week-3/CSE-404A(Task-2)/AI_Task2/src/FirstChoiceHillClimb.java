import java.util.Random;


public class FirstChoiceHillClimb 
{
	TSP tsp;
	int sigma;
    
	
	public FirstChoiceHillClimb(TSP tsp, int sigma) 
	{
		// TODO Auto-generated constructor stub
		this.tsp = tsp;
		this.sigma = sigma;
	}
	
	/**
	 * Main loop of your local search algorithm. 
	 * After the search is complete, create a SolutionInfo Object 
	 * with related information and return to the caller to generate aggregated results
	 * @return
	 */
        private static Random random = new Random(System.currentTimeMillis());
        
      
	public SolutionInfo run() 
	{
		//Main loop of your local search algorithm. 
		
                 Route current  = new Route (tsp);
                   
                 int count =0;
                  Route neighbor  = new Route (tsp);
                  neighbor.route.clear();
                  int i;
               
                 while(true){
                     for ( i = 0; i <sigma; i++) {
                         int max=1;
                         int min =0;
                   
                         
                         double ran = (double) (Math.random() * (max - min)) + min;
                         
                        
                         
                     if(ran<.5){
                        neighbor=OneOneExchange.apply(current);
                         System.out.println("Neighbor: "+neighbor.route);
                     }
                     
                     
                     else{
                        neighbor=Or_Opt.apply(current);
                     }
                     
                     if(neighbor.updateCost()<current.updateCost())
                        
                         break;
                 }
                     if(i==sigma)
                     {
                    SolutionInfo si = new SolutionInfo(current,count);	
		return si; 
                     }
               
                  current=neighbor;
                count++;
                           
	 
		
	}
	
	
	
	
	
}
}
