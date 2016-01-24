/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smok;

/**
 *
 * @author lukasz
 */
public class Field {
    private boolean gold = false;
    private boolean agent = false;
    private boolean smell = false;
    private boolean hole = false;
    private boolean wind = false;
     private boolean smok =false;
    private int x;
    private int y;
    private int value;
    public Field(){
        
    }
    public Field(int i,int j,int value){
        x =i;
        y=j;
        this.value = value;
        setStatues();
        
    }
    public boolean isGold(){
        return gold;
    }
    public boolean isAgent(){
        return agent;
    }
    public boolean isSmok(){
        return smok;
    }
    public boolean isWind(){
        return wind;
    }
    public boolean isSmell(){
        return smell;
    }
    public boolean isHole(){
        return hole;
    }
    public void setWind(){
        wind = true;
    }
    public void setSmell(){
        smell =true;
    }
    public void changeHoleState(){
        hole = false;
    }
    private void setStatues(){
        if(value == 2) {
            gold =true;
          //  System.out.println("Gold" + gold);
        }
        else if(value ==3){
            hole = true;
         //   System.out.println("hole" + hole);
        }
        else if(value ==4){
            smok =true;
            System.out.println("smok" + smok);
        }
        else if(value ==1){
            agent =true;
          //  System.out.println("agent" + agent);
        }
        
    }
    
}
