/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute;

/**
 *
 * @author inkeriv
 */

/* 

Stack implemented as int array and int size. Elements (graph's nodes' id-numbers) are kept in the array and size
tells the index of the next empty entry.

This stack is used for returning the shortest path in the right order. 

*/
public class Stack {
    
    public int[] stack ;
    public int size; 
    
    private static final int INITIAL_SIZE=1000;
    
    
    public Stack() {
        
        stack=new int[INITIAL_SIZE];
        size=0;
    }
    

    public static Stack createStack() {
        
        Stack pino = new Stack();
        return pino;
    }
    
    
    public void addToStack(int value) { 
        
        if (size == stack.length) {
            increaseStackSize();
        }
        stack[size]=value;
        size++;
    }
    
    
    public int popStack() {
        
        size--;
        return stack[size];
    }
        
    
    //doubles the size of the stack array
    public void increaseStackSize() { 
        
        int l = stack.length;
        int[] newStack = new int[l*2];

        for (int i=0; i<l; i++) { 
            newStack[i]=stack[i];
        }
        stack = newStack;
    }
    
    
    public boolean isEmpty() {
        
        return (size <= 0);
    } 
}
