

/**
 * Example class extending Game class
 
 *
 */
public class TickTackToe extends Game
{

	/**
	 * The actual game board
	 * -1 empty, 0 -> O, 1 -> X
	 */
	public int[][] board;
	
	/**
	 * First agent starts with O
	 * @param a
	 * @param b
	 */
	public TickTackToe(Agent a, Agent b) {
		super(a, b);
		// TODO Auto-generated constructor stub
		
		a.setRole(0); // The first argument/agent is always assigned O (0)
		b.setRole(1); // The second argument/agent is always assigned X (1)
					  // NOtice that, here first dows not mean that afent a will make the first move of the game.
					  // Here, first means the first argument of the constructor
					  // Which of a and b will actually give the first move is chosen randomly. See Game class
		
		name = "Tick Tack Toe";
		
		board = new int[3][3];
		
	}

	/**
	 * Called by the play method of Game class. It must update the winner variable. 
	 * In this implementation, it is done inside checkForWin() function.
	 */
	@Override
	boolean isFinished() {
		// TODO Auto-generated method stub
		if(checkForWin() != -1)
			return true;
		else if(isBoardFull())
			return true;
		else return false;
	}

	@Override
	void initialize(boolean fromFile) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = -1;
			}
		}
	}

	/**
	 * Prints the current board (may be replaced/appended with by GUI)
	 */
	@Override
	void showGameState() {
		// TODO Auto-generated method stub
	
        System.out.println("-------------");
		
        for (int i = 0; i < 3; i++) 
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) 
            {
            	if(board[i][j]==-1)
            		System.out.print(" " + " | ");
            	else if	(board[i][j]==0)
            		System.out.print( "O | ");
            	else
            		System.out.print( "X | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
	
    /** Loop through all cells of the board and if one is found to be empty (contains -1) then return false.
    	Otherwise the board is full.
    */
    public boolean isBoardFull() {

	//if the board is full return true else return false	
    for (int i = 0; i < 3; i++) 
        {
           
            for (int j = 0; j < 3; j++) 
            {
            	if(board[i][j]==-1)
            		return false;
           
            }
           
        }
    return true;
       
    }
	
	
    /** Returns role of the winner, if no winner/ still game is going on -1.
     * @return role of the winner, if no winner/ still game is going on -1.
     */
    public int checkForWin() 
    {
         winner = null;
    	int winRole=-1;
    	/*
        update the winner and returns role of the winner, if no winner/ still game is going on -1.
        */
        if( board[0][0]==1&&board[0][0]==board[1][1] && board[0][0]==board[2][2]){
            winner=agent[1];
            return winRole=1;
        }
         if( board[0][2]==1&&board[0][2]==board[1][1] && board[0][2]==board[2][0]){
            winner=agent[1];
            return winRole=1;
        }
        for (int i = 0; i < 3; i++) {
            if( (board[i][0]==board[i][1] && board[i][0]==board[i][2] && board[i][0]==1)||( board[0][i]==board[1][i] && board[0][i]==board[2][i] & board[0][i]==1)){
                 winner=agent[1];
                 return winRole=1;
            }
           
        }
        if(  board[0][2]==0 &&board[0][2]==board[1][1] && board[0][2]==board[2][0]){
             winner=agent[0];
            return winRole=0;
        }
         if(  board[0][0]==0&&board[0][0]==board[1][1] && board[0][0]==board[2][2]){
             winner=agent[0];
            return winRole=0;
        }
        for (int i = 0; i < 3; i++) {
            if( (board[i][0]==board[i][1] && board[i][0]==board[i][2] && board[i][0]==0)||( board[0][i]==board[1][i] && board[0][i]==board[2][i] & board[0][i]==0)){
                  winner=agent[0];
                  return winRole=0;
            }
            
        }
        return winRole;
    }
	
    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(int c1, int c2, int c3) 
    {
        return ((c1 != -1) && (c1 == c2) && (c2 == c3));
    }
	
	public boolean isValidCell(int row, int col)
	{
            //if the cell is valid return true else return false
            
            if( row>=0 && row <3){
                if(col>=0 && col <3){
                if(board[row][col]==-1)
                    return true;
            }
            }
             return false;
	}

	@Override
	void updateMessage(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}
	
}
