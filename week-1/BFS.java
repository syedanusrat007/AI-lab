import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	Queue<State> Q;
	HashSet<String> visited;
	
	LinkedList<ArrayList<String>> paths;
	ArrayList<String> shortest_path;
	
	public BFS()
	{
		Q = new LinkedList<>();
		visited = new HashSet<>();
		paths = new LinkedList<>();
	}
	
	public void printPath()
	{
		//print the shortest_path
		for (String s : shortest_path)
		{
			System.out.println(s);
		}
	}
	
	public void start(State start)
	{
		Q.add(start);
		
		//for shortest_path
		ArrayList<String> r = new ArrayList<>();
		r.add(start.toString());
		paths.add(r);
		//-----------------
		
		//start state is visited
		while (Q.size() != 0)
		{
			State u = Q.poll();				// for edge (u,v), get u
			shortest_path = paths.poll();	//get equivalent shortest_path
			
			//if u is the end state, return
			
			State v_list[] = u.generateNextState();
			
			for (State v : v_list)
			{
				//if v is visited, continue
				//if v is illegal state, continue
				
				//otherwise, 	add v to visited
				//				push v to Q (add() method)
				
				//for shortest_path
				ArrayList<String> r1 = new ArrayList<>(shortest_path);
				r1.add(v.toString());
				paths.add(r1);
			}
		}
	}
}
