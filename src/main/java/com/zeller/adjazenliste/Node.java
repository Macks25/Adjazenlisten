/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeller.adjazenliste;

import java.util.ArrayList;

/**
 *
 * @author zelle
 */
public class Node {
    
    String name;
    int id;
    ArrayList<Node> Verbindungen = new ArrayList<Node>();
    ArrayList<ArrayList<String>> ergebnisse = new ArrayList<ArrayList<String>>();

    public ArrayList<Node> getVerbindungen() {
        return Verbindungen;
    }
    
    public void addVerbinung(Node node){
        Verbindungen.add(node);
        node.Verbindungen.add(this);
    }
    public void removeVerbinung(Node node){
        Verbindungen.remove(node);
        node.Verbindungen.remove(this);
    }
    
    
    public void setVerbindungen(ArrayList<Node> Verbindungen) {
        this.Verbindungen = Verbindungen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int countVerbindungen(){
        return this.Verbindungen.size();
    }
   
    public Node(String name){
        this.name = name;
    }
    
    
    
    public void suche(Node gesucht, ArrayList<Node> ndlist){
        ArrayList<Node> newnd = new ArrayList<>();
        for(Node n : ndlist){
        newnd.add(n);
        }
        newnd.add(this);
        
        if(this == gesucht){
            
        ArrayList<String> namen = new ArrayList<>();
        
            for(Node nds: newnd){
                namen.add(nds.getName());
 
            }
         this.ergebnisse.add(namen);
        }
        
        

        for(Node nd: this.getVerbindungen()){
            
            if(!newnd.contains(nd)){
               // System.out.println(this.getName() +  " -> " + nd.getName());
                nd.suche(gesucht, newnd);
            }
        }
        
        
        
    }
    public ArrayList<ArrayList<String>> such(Node gesucht, ArrayList<Node> ndlist){
        this.suche(gesucht, ndlist);
        return gesucht.ergebnisse;
    }
    
     
}
