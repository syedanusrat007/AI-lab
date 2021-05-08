import java.util.Scanner;

/**
 * An example class implementing Agent class for human players. 
 * The implementation is coupled with the actual game (here, TickTackToe) the agent is playing.
 * 
 *
 */
public class HumanTTTAgent extends Agent
{

	static Scanner in = new Scanner(System.in);
	public HumanTTTAgent(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove(Game game) {
            
		TickTackToe tttGame = (TickTackToe) game;
                
		/*Human Agent will give his move;
                 if the move is not is a valid position (use the isValidCell(row, col) function of TickTackToe object) 
                            it will again ask for move otherwise play will be contunied*/
                System.out.println("Enter value of row and coloum\n");
          
                
                 int x = in.nextInt();
                 int y = in.nextInt();
                if(tttGame.isValidCell(x,y)==false){
                   System.out.println("Invalid position! enter value of row and coloum within 0 to 2\n"); 
                     x = in.nextInt();
                  y = in.nextInt();
                }
              tttGame.board[x][y]=0;
                 
                
                
	
	}


	

}
