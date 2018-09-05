/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute.graph;

import lazyroute.graph.Node;
import lazyroute.pathing.Path;

/**
 *
 * @author inkeriv
 */


public class Graph {
    
    //start node coordinates in graph
    private int ai;
    private int aj;

    //end node coordinates in graph
    private int li;
    private int lj;
    
    //infinite value
    private static final int INFINITE_VALUE=1000000000;//Integer.MAX_VALUE;
    
    private int[] nodes;
    private int a;
    private int l;
    private int m;
    private int n;
    private String alg;
    
    private static Path path;

    
    public Graph (int[] s, int alku, int loppu, int lev, int pit, String al) {
        nodes = s;
        a = alku;
        l = loppu;
        m = lev;
        n = pit;
        alg = al;
    }
     
  
    //creating graph presentations
    public void init() {
        Node[] list = new Node[nodes.length] ;
        //list = new Node[nodes.length];
        int[][] graph = new int[m][n];
        
        
        //Node-type list of nodes
        int value=0;
        for (int j=0; j<m; j++) {
            for (int i=0; i<n; i++) {
                
                //start node coordinates
                if (value==a-1) {
                    ai=i;
                    aj=j;
                }
                
                //end node coordinates
                if (value==l-1) {
                    li=i;
                    lj=j;
                }
                
                graph[i][j] = nodes[value];
                value++;
            }
        }
        
        //Adjacency list
        int[][] vl = new int[nodes.length][];
        for (int i=0; i<nodes.length; i++) {
            vl[i]=new int[4];
        }
        
        int[] dists = new int[nodes.length];
        int[] weights = new int[nodes.length];
        
        if (alg=="a" || alg=="A") {
            for (int i=0; i<nodes.length; i++) {
                weights[i]=INFINITE_VALUE;
            }
            AdjacencyListAStar(nodes, vl, m, n, list, weights, dists);
        }

        if (alg == "d" || alg == "D") {
            for (int i=0; i<nodes.length; i++) {
                dists[i] = INFINITE_VALUE;
            }
            
            AdjacencyListDijkstra(nodes, vl, m, n, list, dists);
        }
        
        path=Path.shortestPath(list, vl, a, l, alg, nodes, weights, dists);
        System.out.println(path.ToString(path)); //KORJAA TÄMÄ
        
    }
    public static Path getPath(Graph graph) {
        graph.init();
        return path;
    }
    
    //heuristic function
    public int h( int ai, int aj, int bi, int bj) { 
        int lop = Math.abs(ai-bi)+Math.abs(aj-bj);
        return lop;
    }
    public int[][] AdjacencyListAStar(int[] nodes, int[][] vl, int m, int n, Node[] list, int[] weights, int[] dists) {
        int x = 0;
        
        list[1]=new Node(1, INFINITE_VALUE, h(1,0,li,lj));
        weights[1]=INFINITE_VALUE;
        dists[1]=list[1].dist;
        
        for (int j=0; j<n; j++) {
            for (int i=0; i<m; i++) {
                if (list[x]==null) { 
                
                    list[x]=new Node(x, INFINITE_VALUE, h(i,j,li,lj));
                    weights[x]=INFINITE_VALUE;
                    dists[x]=list[x].dist;
                    
                }
                //upper node
                if (isWithinBounds(i,j-1,m,n)) {
                    vl[x][0]=x-m;
                    
                } else { vl[x][0]=-1; }
                
                //previous node
                if (isWithinBounds(i-1,j,m,n)) {
                    vl[x][1]=x-1;
                    
                } else { vl[x][1]=-1; }
                
                //next node
                if (isWithinBounds(i+1,j,m,n)) {
                    vl[x][2]=x+1;
                    
                } else { vl[x][2]=-1; }
                
                //bottom node
                if (isWithinBounds(i,j+1,m,n)) {
                    vl[x][3]=x+m;
                    
                } else { vl[x][3]=-1; }
                
                x++;
            }    
        }
        return vl;
    }
    public int[][] AdjacencyListDijkstra(int[] nodes, int[][] vl, int m, int n, Node[] list, int[] dists) {
        int x = 0;
        int c = 0;
        
        list[1]=new Node(1, nodes[1], INFINITE_VALUE);
        dists[1]=INFINITE_VALUE;
        
        for (int j=0; j<n; j++) {
            for (int i=0; i<m; i++) {
                if (list[x]==null) { 
                
                    list[x]=new Node(x, nodes[x], INFINITE_VALUE);
                    dists[x]=INFINITE_VALUE;
                    
                }
                //upper node
                if (isWithinBounds(i,j-1,m,n)) {
                    vl[x][0]=x-m;
                    
                } else { vl[x][0]=-1; }
                
                //previous node
                if (isWithinBounds(i-1,j,m,n)) {
                    vl[x][1]=x-1;
                    
                } else { vl[x][1]=-1; }
                
                //next node
                if (isWithinBounds(i+1,j,m,n)) {
                    vl[x][2]=x+1;
                    
                } else { vl[x][2]=-1; }
                
                //bottom node
                if (isWithinBounds(i,j+1,m,n)) {
                    vl[x][3]=x+m;
                    
                } else { vl[x][3]=-1; }
                
                x++;
                c++;
            }    
        }
        return vl;
    }
    
    
    //return true if node-coordinates are within the graph
    //used for checking what neighbour nodes a node has (previous,next,upper,bottom)
    //(big thanks to my code reviewer)
    private boolean isWithinBounds(int i, int j, int m, int n) {
        if (i>=0 && i<m && j>=0 && j<n) {
            return true;
        }
        return false;
    }
    
    public int getStartNodeCoordinateI() { return ai; }
    public int getStartNodeCoordinateJ() { return aj; }
    public int getEndNodeCoordinateI() { return li; }
    public int getEndNodeCoordinateJ() { return lj; }
    
    
    
    public static void testPerformance(int n) { 
        
    }
    

}
