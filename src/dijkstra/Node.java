/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.ArrayList;

/**
 *
 * @author Suli
 */
public class Node {
    
    int dist = 999999999;
    public String value;
    Node prev = null;
    public ArrayList<NeighbourNode> neighbours = new ArrayList<NeighbourNode>();
    
    public static class NeighbourNode{
     public int cost;
     public Node node;
     public NeighbourNode(Node node,int cost)
     {
         this.node=node;
         this.cost=cost;
     }
    }
    
    public Node(String value)
    {
        this.value=value;
    }
    
    public void SetDistance(int dist){
        this.dist=dist;
    }
    
    public void SetPrevious(Node prev){
        this.prev=prev;
    }
    
    public int GetDistance(){
        return dist;
    }
    
    public Node GetPrevious(){
        return prev;
    }
}
