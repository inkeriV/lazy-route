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
        Node[][] vl = new Node[nodes.length][];
        for (int i=0; i<nodes.length; i++) {
            vl[i]=new Node[4];
        }
        //adjacency list for A*
        if (alg=="a" || alg=="A") {
            AdjacencyLforA(nodes, vl, m,n, list);
        }
        //adjacency list for Dijkstra
        if (alg == "d" || alg == "D") {
            AdjacencyLforD(nodes, vl, m,n, list);
        }
        path=Path.shortestPath(list, vl, a, l, alg, nodes);
        
    }
    
    //heuristic function
    public int h( int ai, int aj, int bi, int bj) { 
        int lop = Math.abs(ai-bi)+Math.abs(aj-bj);
        return lop;
    }

    public Node[][] AdjacencyLforD(int[] nodes, Node[][] vl, int m, int n, Node[] list) {
        
        int x = 0;
            list[1]=new Node(1,nodes[1],INFINITE_VALUE);
            for (int j=0; j<n; j++) {
                for (int i=0; i<m; i++) {

                if (list[x]==null) { list[x]= new Node(x, nodes[x],INFINITE_VALUE); }
                
                //---------Corner-nodes---------
                //left upper corner
                if (i==0 && j==0) {
                    vl[0][0]=new Node(1,nodes[1],INFINITE_VALUE); //next node
                    vl[0][1]=new Node(m,nodes[m],INFINITE_VALUE); //node below
                    x++;
                }
                //right upper corner
                if (i==m-1 && j==0) {
                    vl[i][0]=new Node(m-2,nodes[m-2],INFINITE_VALUE); //previous node
                    vl[i][1]=new Node((m*2)-1,nodes[m*2-1], INFINITE_VALUE); //node below
                    x++;
                }
                //left bottom corner
                if (x==m*(n-1) && j==n-1) {
                    vl[x][0]=new Node(m*(n-2),nodes[m*(n-2)], INFINITE_VALUE); //upper node
                    vl[x][1]=new Node(m*(n-1)+1,nodes[x+1], INFINITE_VALUE); //next node
                    x++;
                }
                //right bottom corner    
                if (i==m-1 && j==m-1) {
                    vl[m*m-1][0]=new Node(m*(n-1)-1,nodes[m*(n-1)], INFINITE_VALUE); //upper node
                    vl[m*m-1][1]=new Node(m*n-2,nodes[m*n-2], INFINITE_VALUE); //previous node
                    x++;
                }

                //---------Other-border-nodes---------
                //upper edge
                if (j==0 && i!=m-1 && i!=0 ) {
                    vl[x][0]=new Node(x-1,nodes[x-1], INFINITE_VALUE); //previous node 
                    vl[x][1]=new Node(i+m, nodes[i+m], INFINITE_VALUE); //node below
                    vl[x][2]=new Node(x+1,nodes[x+1], INFINITE_VALUE); //next node
                    x++;  
                }
                //left border
                if (i==0 && j!=0 && j!=m-1) {
                    vl[x][0]=new Node(x-m,nodes[x-m], INFINITE_VALUE); //upper
                    vl[x][1]=new Node(x+1,nodes[x+1], INFINITE_VALUE); //next
                    vl[x][2]=new Node(x+m,nodes[x+m], INFINITE_VALUE); //bottom
                    x++;
                }
                //right border
                if (i==m-1 && j!=0 && j!=n-1) {
                    vl[x][0]=new Node(x-m,nodes[x-m], INFINITE_VALUE); //upper
                    vl[x][1]=new Node(x-1,nodes[x-1], INFINITE_VALUE); //previous
                    vl[x][2]=new Node(x+m,nodes[x+m], INFINITE_VALUE); //below
                    x++;
                }
                //foot
                if (j==n-1 && i!=0 && i!=m-1) { 
                    vl[x][0]=new Node(x-1,nodes[x-1], INFINITE_VALUE); //previous
                    vl[x][1]=new Node(x-m,nodes[x-m], INFINITE_VALUE); //upper
                    vl[x][2]=new Node(x+1,nodes[x+1], INFINITE_VALUE);//next
                    x++;

                //---------Middle-nodes---------
                } else if (j!=0 && j!=n-1 && i!=0 && i!=m-1) {
                    vl[x][0]=new Node(x-m,nodes[x-m], INFINITE_VALUE); //upper 
                    vl[x][1]=new Node(x+m,nodes[x+m], INFINITE_VALUE); //bottom
                    vl[x][2]=new Node(x-1,nodes[x-1], INFINITE_VALUE); //previous
                    vl[x][3]=new Node(x+1,nodes[x+1], INFINITE_VALUE); //next
                    x++;
                }
            }    
        }
        return vl;
    }
    
    public Node[][] AdjacencyLforA(int[] nodes, Node[][] vl, int m, int n,  Node[] list) {
        
        int x = 0;
            list[1]=new Node(1,nodes[1],INFINITE_VALUE);
            for (int j=0; j<n; j++) {
                for (int i=0; i<m; i++) {

                if (list[x]==null) { list[x]= new Node(x,INFINITE_VALUE,h(i,j,li,lj)); }

                //left upper corner
                if (i==0 && j==0) {
                    vl[0][0]=new Node(1,INFINITE_VALUE,h(1,0,li,lj)); //next node
                    vl[0][1]=new Node(m,INFINITE_VALUE,h(0,1,li,lj)); //node below
                    x++;
                }
                //right upper corner
                if (i==m-1 && j==0) {
                    vl[i][0]=new Node(m-2,INFINITE_VALUE,h(m-2,0,li,lj)); //previous node
                    vl[i][1]=new Node(i+m,INFINITE_VALUE,h(m-1, 1,li,lj)); //node below
                    x++;
                }
                //left bottom corner
                if (x==m*(n-1) && j==n-1) {
                    vl[x][0]=new Node(m*(n-2),INFINITE_VALUE,h(0, n-1, li, lj)); //upper node
                    vl[x][1]=new Node(m*(n-1)+1,INFINITE_VALUE,h(1,j,li,lj)); //next node
                    x++;
                }
                //right bottom corner    
                if (i==m-1 && j==m-1) {
                    vl[x][0]=new Node(x-m,INFINITE_VALUE,h(0,n-2,li,lj)); //upper node
                    vl[x][1]=new Node(x-1,INFINITE_VALUE,h(m-2, n-1, li, lj)); //previous node
                    x++;
                }

                //---------Other-border-nodes---------
                //upper edge
                if (j==0 && i!=m-1 && i!=0 ) {
                    vl[x][0]=new Node(x-1,INFINITE_VALUE,h(i-1,j,li,lj)); //previous node 
                    vl[x][1]=new Node(i+m, INFINITE_VALUE,h(i,j+1,li,lj)); //node below
                    vl[x][2]=new Node(x+1,INFINITE_VALUE,h(x,j,li,lj)); //next node
                    x++;  
                }
                //left border
                if (i==0 && j!=0 && j!=m-1) {
                    vl[x][0]=new Node(x-m,INFINITE_VALUE,h(i,j-1,li,lj)); //upper
                    vl[x][1]=new Node(x+1,INFINITE_VALUE,h(i+1,j,li,lj)); //next
                    vl[x][2]=new Node(x+m,INFINITE_VALUE,h(i,j+1,li,lj)); //bottom
                    x++;
                }
                //right border
                if (i==m-1 && j!=0 && j!=n-1) {
                    vl[x][0]=new Node(x-m,INFINITE_VALUE,h(i,j-1,li,lj)); //upper
                    vl[x][1]=new Node(x-1,INFINITE_VALUE,h(i-1,j,li,lj)); //previous
                    vl[x][2]=new Node(x+m-1,INFINITE_VALUE,h(i,j+1,li,lj)); //below
                    x++;
                }
                //foot
                if (j==n-1 && i!=0 && i!=m-1) { 
                    vl[x][0]=new Node(x-1,INFINITE_VALUE,h(i-1,j,li,lj)); //previous
                    vl[x][1]=new Node(x-m,INFINITE_VALUE,h(i,j-1,li,lj)); //upper
                    vl[x][2]=new Node(x+1,INFINITE_VALUE,h(i+1,j,li,lj));//next
                    x++;

                //---------Middle-nodes---------
                } else if (j!=0 && j!=n-1 && i!=0 && i!=m-1) {
                    vl[x][0]=new Node(x-m,INFINITE_VALUE,h(i,j-1,li,lj)); //upper 
                    vl[x][1]=new Node(x+m,INFINITE_VALUE,h(i,j+1,li,lj)); //bottom
                    vl[x][2]=new Node(x-1,INFINITE_VALUE,h(i-1,j,li,lj)); //previous
                    vl[x][3]=new Node(x+1,INFINITE_VALUE,h(i+1,j,li,lj)); //next
                    x++;
                }
            }    
        }
        return vl;
    }
    
    public int getStartNodeCoordinateI() { return ai; }
    public int getStartNodeCoordinateJ() { return aj; }
    public int getEndNodeCoordinateI() { return li; }
    public int getEndNodeCoordinateJ() { return lj; }
    
    
    
    public static void testPerformance(int n) { 
        for (int i=1; i<=n; i++) {
            int[] graph = createRandomGraph();
            
            Graph a = new Graph(graph, 1, 10000, 100, 100, "a");
            Graph d = new Graph(graph, 1, 10000, 100, 100, "d");

            long beginningTimeAStar = System.currentTimeMillis();

            a.init();

            long endingTimeAStar = System.currentTimeMillis();
            System.out.println("Laskenta A* kesti "+ (endingTimeAStar - beginningTimeAStar) + " ms.");
            //System.out.println(path.ToString(path));

            long beginningTimeDijkstra = System.currentTimeMillis();

            d.init();

            long endingTimeDijkstra = System.currentTimeMillis();
            System.out.println("Laskenta Dijkstralla kesti " + (endingTimeDijkstra - beginningTimeDijkstra) + " ms.");
            //System.out.println(path.ToString(path));
        }
    }
    
    public static int[] createRandomGraph() {
        
        int[] graph = new int[10000];
        
        for (int i=0; i<10000; i++) {
            graph[i]=(int)Math.floor(Math.random()*100);
        }
        
        return graph;
    }
}
