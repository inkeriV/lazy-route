/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyroute;

import lazyroute.Node;

/**
 *
 * @author inkeriv
 */


public class Verkko {
    
    //start node coordinates in graph
    private int ai;
    private int aj;

    //end node coordinates in graph
    private int li;
    private int lj;
    
    //infinite value
    private static final int INFINITE_VALUE=1000000000;//Integer.MAX_VALUE;
    
    public int[] nodes;
    public int a;
    public int l;
    public int m;
    public int n;
    public String alg;
    
    public Verkko (int[] s, int alku, int loppu, int lev, int pit, String al) {
        nodes = s;
        a = alku;
        l = loppu;
        m = lev;
        n = pit;
        alg = al;
    }
     
  
    //creating graph presentations
    //private Node[] list;
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
            initializeAAdjList(nodes, vl, m,n, list);
        }
        //adjacency list for Dijkstra
        if (alg == "d" || alg == "D") {
            initializeDAdjList(nodes, vl, m,n, list);
        }
        FindPath.shortestPath(list, vl, a, l, alg, nodes);
        /*for (int i=0; i<vl.length; i++) {
            System.out.println(i+ " => ");
            for (Node solmu: vl[i]) {
                System.out.println(solmu);
            }
        }*/
    }
    
    //heuristic function
    public int h( int ai, int aj, int bi, int bj) { 
        int lop = Math.abs(ai-bi)+Math.abs(aj-bj);
        return lop;
    }

    public void initializeDAdjList(int[] nodes, Node[][] vl, int m, int n, Node[] list) {
        
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
                    System.out.println(x); 
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
    }
    
    public void initializeAAdjList(int[] nodes, Node[][] vl, int m, int n,  Node[] list) {
        
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
    }


    public static void main(String[] args) {
        
        //running in NetBeans

        Verkko test = new Verkko(new int[]{1,3,3,4,4,4,5,5,5,2,2,1,4,2,5,3}, 1, 12, 4, 4, "a");
        test.init();
        
        //Graph koe=new Graph(new int[]{1,1,1,1,2,3,2,1,2,3,1,2,3,4,2,4,1,1,1,1,1,2,1,2,1,4,2,4,2,4,2,1,2,2,1,1},1,35,6,6,"a");
        //koe.init();
        
         /*
        Graph koe=new Graph(new int[]{1,2,2,2,2,2,9,9,9,7,
                                        3,3,3,4,3,4,3,2,1,2,
                                        5,5,5,5,6,6,6,7,3,1,
                                        3,4,4,4,4,4,2,2,1,1,
                                        7,7,7,7,3,3,2,1,5,3,
                                        1,2,2,2,2,2,9,9,9,7,
                                        3,3,3,4,3,4,3,2,1,2,
                                        5,5,5,5,6,6,6,7,3,1,
                                        3,4,4,4,4,4,4,4,4,2,
                                        2,1,1,7,7,7,7,3,3,2 }, 1, 99, 10,10,"a");
        koe.init();
        */
        
        //running in terminal
        
        
        //command: 
        //mvn compile exec:java -Dexec.mainClass=lazyroute.Verkko 
        //                -Dexec.args="1,1,1,1,2,3,2,1,2,3,1,2,3,4,2,4,1,1,1,1,1,2,1,2,1,4,2,4,2,4,2,1,2,2,1,1, 1 35 6 6 d"
        
        /*
        String patki = args[0];
        int[] lista = new int[(int)Math.floor(patki.length()/2)];
        int apu=0;
        
        try {
            for (String k: patki.split(",")) {
                lista[apu]=Integer.parseInt(k);
            }
        } catch (NumberFormatException e) {
            System.err.println("Argument" + args[0] + " must be a list of integers.");
        }
        

        int alkusolmu = Integer.parseInt(args[1]);
        int loppusolmu = Integer.parseInt(args[2]);
        int m = Integer.parseInt(args[3]);
        int n = Integer.parseInt(args[4]);
        String algoritmi = args[5];

        Verkko koe=new Verkko(lista, alkusolmu, loppusolmu, m, n, algoritmi);
        koe.alustus();
        */
        
    }  
}
