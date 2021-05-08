
public class State {
	public int[] obj;
	
	public State()
	{
		obj = new int[4];
		obj[0] = obj[1] = obj[2] = obj[3] = 0;
	}
	public State(int wolf, int cabbage, int farmer, int goat) {
		obj = new int[4];
		obj[0] = wolf;
		obj[1] = cabbage;
		obj[2] = farmer;
		obj[3] = goat;
	}
	
	public State[] generateNextState()
	{
		State ret[] = new State[4];
		
		//generate all possible next state given present state
		//	in each next state, farmer must cross the river
		//		he can either choose to cross alone,
		//			or take any of the objects with him, given that the object is on the same side
		
		return ret;
	}
	
	public boolean isIllegalState()
	{
		// A state is illegal if
		//		wolf-goat on same side, farmer on the other side
		//		or, goat-cabbage on same side, farmer on the other side
		
		return false;
	}
	
	@Override
	public String toString() {
		return "" + obj[0] + obj[1] + obj[2] + obj[3];
	}
	
}
