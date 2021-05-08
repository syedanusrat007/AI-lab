/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pancake;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Tonni
 */
public class Pancake {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
      
        Scanner scan = new Scanner(new File("in.txt")); 
        int counter =0; 
        while(scan.hasNextInt()) 
        {
            counter++;
            scan.nextInt();
        }
        Scanner scan2 = new Scanner(new File("in.txt")); 
        int a[] = new int[counter];
        for(int i=0;i<counter;i++)
        {
            a[i]=scan2.nextInt(); 
        }
          
           
           
            State s = new State(a,counter);
           
          
           System.out.println("Sorted Array: ");
           s.generateNextState(a);
           s.printStack(a);
          
    }
}
