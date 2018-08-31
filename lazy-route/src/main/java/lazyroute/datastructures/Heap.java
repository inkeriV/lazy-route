/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute.datastructures;

import lazyroute.graph.Node;


/**
 *
 * @author inkeriv
 */

/*  Minheap for arranging nodes according to their dist+weigth. 
    Heap has a Node array and integer values for the length of the array and the number of nodes in the array. */

public class Heap { 

    
    public Node[] harray;
    public int length ;//length of the array
    public int size; //number of nodes in the array
    
    private static final int START_SIZE=1000; 
    
    public Heap() {
        
        this.harray=new Node[START_SIZE];
        this.length=1000;
        this.size=-1;
    }
      
    
    public void createHeap(Node[] lista)  {
        
        for(int i=0; i<lista.length; i++) {
            add(lista[i]);
        }
    }
    
    
    public void add(Node node) {

        if (size == harray.length-1) {
            doubleSize();
        }
        size++;
        harray[size]=node;
        bubbleUp();
    }
        
    
    public Node popMin() {
        
        //switching the last node of the array in the root & heapifying
        Node palauta= harray[0];
        harray[0] = harray[size];
        harray[size] = null;

        bubbleDown();
        size--;
        
        return palauta;
    }

    
    public void bubbleUp() { //called when a node is added
        
        int index = size;
        
        //while node has parent && lower node < its parent node
        while (harray[(index-1)/2]!=null && harray[index].compareTo(harray[(index-1)/2])==-1) { 
            
            //switch their places
            Node help = harray[(index-1)/2];
            harray[(index-1)/2] = harray[index];
            harray[index]=help;
            
            //index is now parent node's index
            index=(index-1)/2;
        }    
    }
    
    public void bubbleDown() { //called when root node is popped & last node is moved to the root
        
        int smallerNodeIndex;
        int index = 0;
        
        //while left child exists
        while (2*index+1 < size) {
            
            smallerNodeIndex = 2*index+1; 
            
            //if right child exists AND right child weight+dist < left child weight+dist (maybe a separate method would make this prettier..)
            if (2*index+2 < size && harray[2*index+2].weight + harray[2*index+2].dist < harray[2*index+1].weight + harray[2*index+1].dist) {
                
                smallerNodeIndex = 2*index+2;
            }
            
            //if parent w+d is smaller than smaller child's w+d, let's not do anything
            if (harray[index].compareTo(harray[smallerNodeIndex])==-1) {
                break;
                
            //else let's switch their places    
            } else {
                
                Node help=harray[index];
                harray[index]=harray[smallerNodeIndex];
                harray[smallerNodeIndex] = help;
            }
            
            index = smallerNodeIndex;
        }
    }

        
    public void doubleSize() {
        
        Node[] newHeap = new Node[harray.length*2]; //New array double its last size
        int newLenght=length*2;
        
        for (int i=0; i<harray.length; i++) {
            newHeap[i]=harray[i];
        }
        
        length = newLenght;
        harray = newHeap;
    }
    
    
    //Both peek-methods made for testing
    public Node peekMinNode() {
        Node peekNode = harray[0];
        return peekNode;
    }
    public int peekMinValue() {
        if (harray[0]!=null) {
            int peekValue = harray[0].dist + harray[0].weight;    
            return peekValue;
        }
        return -1;
    }
}
