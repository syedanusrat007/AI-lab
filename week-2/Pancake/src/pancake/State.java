/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pancake;

/**
 *
 * @author Tonni
 */
public class State {

   
    
    public int[] stack;
    public int c;

   

    public State(int[] stack,int c) {
        int a = c;
        System.out.println("Unsorted Array: ");
        for(int i=0;i<c;i++)
            System.out.println(stack[i]);
    }
    
    public State[] generateNextState(int a[]){
         int n = a.length;
           
           for (int unsortASize=n; unsortASize>1;--unsortASize) {
               
                int idxMax = findMax(a,unsortASize);
               
               
                if (idxMax != unsortASize-1) {
                    
                     
                    prefix_rev(a, idxMax);

                   
                     prefix_rev(a, unsortASize-1);
                }
           }
        return null;
        
    }
    
    static int findMax(int array[], int n) {
           int idxMax = 0;
           for (int i = 0; i < n; ++i) {
                if (array[i] > array[idxMax]) {
                     idxMax = i;
                }
           }
           return idxMax;
     }
    
    static void prefix_rev(int array[], int idx) {
           int temp, start = 0;
           while (start < idx) {
                temp = array[start];
                array[start] = array[idx];
                array[idx] = temp;
                start++;
                idx--;
           }
     }
    
    static void printStack(int arr[]) {
          
         for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
     }

    
   
    
}
