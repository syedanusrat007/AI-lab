/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task0;

/**
 *
 * @author Tonni
 */
public class TASK0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        BFS bfs = new BFS();
	bfs.start(new State());
        System.out.println("tower|order");
	bfs.printPath();
       
	System.out.println("Done!");
        AnimatedHanoi.Animate();
    }
}
