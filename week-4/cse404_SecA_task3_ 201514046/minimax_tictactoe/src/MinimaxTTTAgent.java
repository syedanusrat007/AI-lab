
/**
 * Example MiniMax agent extending Agent class.
 * Here, for simplicity of understanding min and max functions are written separately. One single function can do the task. 
 * 
 *
 */
public class MinimaxTTTAgent extends Agent
{   public int c=0;
  
	
	public MinimaxTTTAgent(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove(Game game) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}TickTackToe tttGame = (TickTackToe) game;


 
             //  CellValueTuple best = max(tttGame);
             CellValueTuple best =alphabetamax(tttGame,-100,100);
             
             
      
   
		
		if( best.col!=-1)
		{
			tttGame.board[ best.row][ best.col] = role;
		}
                
              
		
	}
	
	private CellValueTuple max(TickTackToe game)
	{	
		CellValueTuple maxCVT = new CellValueTuple();
                CellValueTuple val = new CellValueTuple();
		maxCVT.utility = -100;
	      //  maxCVT.col=-1;
              // maxCVT.row=-1;
		int winner = game.checkForWin();
               
                //Check if the terminating condition is fullfilled and return the object of CellValueTuple
		//implement max function of minimax/alpha-beta pruning algorithm
                        //traverse the whole board
                                //temporarily machine agent occupy the empty cell
                                //call for min function of human agent
                                //update maxcvt
                                //go to previous state
                if(winner == 0)
                {
                    maxCVT.utility=-1;
                        return maxCVT;
                }
                if(winner==1){
                     maxCVT.utility=1;
                        return maxCVT;
                }
                
                if(game.isBoardFull()){
                     maxCVT.utility=0;
                    return maxCVT;
                }
                
                
       
                

       for (int i = 0; i<3; i++)
        {
            for (int j = 0; j<3; j++)
            {
              
                if (game.board[i][j]==-1)
                {
                    
                    game.board[i][j] = 1;
 
                     val=min(game);
 
                  
                    game.board[i][j] = -1;
                    
                           
                    if (val.utility > maxCVT.utility)
                {
                    maxCVT.row = i;
                    maxCVT.col = j;
                    maxCVT.utility = val.utility;
                }
                }
            }
        } 
       
             
                      
		return maxCVT;
			
	}
	
	private CellValueTuple min(TickTackToe game)
	{	
		CellValueTuple minCVT = new CellValueTuple();
                CellValueTuple val = new CellValueTuple();
		minCVT.utility = 100;
                 // minCVT.col=-1;
              // minCVT.row=-1;
	
		
		int winner = game.checkForWin();
             //   System.out.println("winner min " + winner);
		
		//Check if the terminating condition is fullfilled and return the object of CellValueTuple
         
		
		//implement min function of minimax/alpha-beta pruning algorithm 
              if(winner == 0)
                {
                    minCVT.utility=-1;
                        return minCVT;
                }
                if(winner==1){
                     minCVT.utility=1;
                        return minCVT;
                }
                
                if(game.isBoardFull()){
                     minCVT.utility=0;
                    return minCVT;
                }
                  
 
                  
 for (int i = 0; i<3; i++)
        {
            for (int j = 0; j<3; j++)
            {
                
                if (game.board[i][j]==-1)
                {
                 
                    game.board[i][j] = 0;
 
                  
                    val=max(game);
 
                
                    game.board[i][j] = -1;
                    
                    if (val.utility < minCVT.utility)
                {
                    minCVT.row = i;
                    minCVT.col = j;
                    minCVT.utility = val.utility;
                }
                }
            }
        }
      
    
                return minCVT;		
	}
        
      private CellValueTuple alphabetamax(TickTackToe game,int a,int b)
	{	
		CellValueTuple maxCVT = new CellValueTuple();
                CellValueTuple minCVT = new CellValueTuple();
                CellValueTuple val = new CellValueTuple();
		maxCVT.utility = a;
               // minCVT.utility = b;
	     //  maxCVT.col=-1;
              // maxCVT.row=-1;
		int winner = game.checkForWin();
               
                //Check if the terminating condition is fullfilled and return the object of CellValueTuple
		//implement max function of minimax/alpha-beta pruning algorithm
                        //traverse the whole board
                                //temporarily machine agent occupy the empty cell
                                //call for min function of human agent
                                //update maxcvt
                                //go to previous state
                if(winner == 0)
                {
                    maxCVT.utility=-1;
                        return maxCVT;
                }
                if(winner==1){
                     maxCVT.utility=1;
                        return maxCVT;
                }
                
                if(game.isBoardFull()){
                     maxCVT.utility=0;
                    return maxCVT;
                }
                
                 if(game.isFinished()){
                     maxCVT.utility=0;
                    return maxCVT;
                }
                
                
             
                

       for (int i = 0; i<3; i++)
        {
            for (int j = 0; j<3; j++)
            {
              
                if (game.board[i][j]==-1)
                {
                    
                    game.board[i][j] = 1;
 
                     val=alphabetamin(game,a,b);
 
                  
                    game.board[i][j] = -1;
                    
                           
                    if (val.utility > maxCVT.utility)
                {
                    maxCVT.row = i;
                    maxCVT.col = j;
                    maxCVT.utility = val.utility;
                    a=maxCVT.utility;
                   // b=minCVT.utility;
                }
               if (a >= b)
                {
                  // maxCVT.cnt=maxCVT.cnt+1;
                    c+=1;
                   System.out.println("Count " +c); 
            
                 break;
                }
                
                }
            }
        } 
       
           
        return maxCVT;
			
	}
      	
	private CellValueTuple alphabetamin(TickTackToe game,int a,int b)
	{	
		
                CellValueTuple maxCVT = new CellValueTuple();
                CellValueTuple minCVT = new CellValueTuple();
                CellValueTuple val = new CellValueTuple();
		//maxCVT.utility = a;
                minCVT.utility = b;
                 // minCVT.col=-1;
              // minCVT.row=-1;
	
		
		int winner = game.checkForWin();
             //   System.out.println("winner min " + winner);
		
		//Check if the terminating condition is fullfilled and return the object of CellValueTuple
         
		
		//implement min function of minimax/alpha-beta pruning algorithm 
              if(winner == 0)
                {
                    minCVT.utility=-1;
                        return minCVT;
                }
                if(winner==1){
                     minCVT.utility=1;
                        return minCVT;
                }
                
                if(game.isBoardFull()){
                     minCVT.utility=0;
                    return minCVT;
                }
                if(game.isFinished())
                {
                     minCVT.utility=0;
                    return minCVT;
                }
                  
 
                  
 for (int i = 0; i<3; i++)
        {
            for (int j = 0; j<3; j++)
            {
                
                if (game.board[i][j]==-1)
                {
                 
                    game.board[i][j] = 0;
 
                  
                    val=alphabetamax(game,a,b);
 
                
                    game.board[i][j] = -1;
                    
                    if (val.utility < minCVT.utility)
                {
                    minCVT.row = i;
                    minCVT.col = j;
                    minCVT.utility = val.utility;
                    //a=maxCVT.utility;
                    b=minCVT.utility;
                }
                    
                     if (a >= b)
                {
                    // minCVT.cnt=minCVT.cnt+1;
                    c+=1;
                     System.out.println("Count ="+ c); 
                   
                 break;
                }
                }
            }
        }
            
    
                return minCVT;		
	}
        
 
	
	private int minRole()
	{
		if(role==0)return 1;
		else return 0;
	}

	class CellValueTuple
	{
		int row,col, utility,cnt;
		public CellValueTuple() {
			// TODO Auto-generated constructor stub
			row =-1;
			col =-1;
                        cnt=0;
		}
	}

}
