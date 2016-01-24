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
public class Map {

    private Field[][] fields;
    private int size;

    Map(int size) {
        this.size = size;
        fields = new Field[size][size];

    }
    public void init(){
        for(int i= 0 ;i<size;i++){
            for(int j = 0;j<size;j++){
                fields[i][j] = new Field();
            }
        }
    }
    public void setValue(int i, int j, int value) {
        fields[i][j] = new Field(i, j, value);
    }
    public void changeHole(int x,int y){
        fields[x][y].changeHoleState();
    }
    public boolean getStatAgent(int x ,int y){
           
            return (fields[x][y].isAgent()==true)? true : false;
    }
    public boolean getStatHole(int x ,int y){
           
            return (fields[x][y].isHole()==true)? true : false;
    }
    public boolean getStatSmok(int x ,int y){
           
            return (fields[x][y].isSmok()==true)? true : false;
    }
    public boolean getStatSmell(int x ,int y){
           
            return (fields[x][y].isSmell()==true)? true : false;
    }
     public boolean getStatWind(int x ,int y){
           
            return (fields[x][y].isWind()==true)? true : false;
    }
     public boolean getStatGold(int x ,int y){
           
            return (fields[x][y].isGold()==true)? true : false;
    }
     
    public void show() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("Smok " +fields[i][j].isSmok() + "  dziura " +fields[i][j].isHole() + "  agent "+ fields[i][j].isAgent()   );
                System.out.println("  wiatr " +fields[i][j].isWind() + "  zapach " +fields[i][j].isSmell() + "  zloto "+ fields[i][j].isGold()   );
            
            }
            System.out.println("\n");

        }
    }

    public void setNeigh() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 && j == 0) {
                    if (fields[i + 1][j].isHole() == true || fields[i][j + 1].isHole() == true) {
                        fields[i][j].setWind();
                    }
                    if (fields[i + 1][j].isSmok() == true || fields[i][j + 1].isSmok() == true) {
                        fields[i][j].setSmell();
                    }

                }
                if (i == size - 1 && j == size - 1) {
                    if (fields[i - 1][j].isHole() == true || fields[i][j - 1].isHole() == true) {
                        fields[i][j].setWind();
                    }

                    if (fields[i - 1][j].isSmok() == true || fields[i][j - 1].isSmok() == true) {
                        fields[i][j].setSmell();
                    }

                }
                if (i == size - 1 && j == 0) {
                    if (fields[i - 1][j].isHole() == true || fields[i][j + 1].isHole() == true) {
                        fields[i][j].setWind();
                    }
                    if (fields[i - 1][j].isSmok() == true || fields[i][j + 1].isSmok() == true) {
                        fields[i][j].setSmell();
                    }

                }
                if (i == 0 && j == size - 1) {
                    if (fields[i + 1][j].isHole() == true || fields[i][j - 1].isHole() == true) {
                        fields[i][j].setWind();
                    }
                    if (fields[i + 1][j].isSmok() == true || fields[i][j - 1].isSmok() == true) {
                        fields[i][j].setSmell();

                    }

                }
                if (i == 0 && j > 0 && j < size - 1) {
                    if (fields[i + 1][j].isHole() == true || fields[i][j - 1].isHole() == true || fields[i][j + 1].isHole() == true) {
                        fields[i][j].setWind();
                    }
                    if (fields[i + 1][j].isSmok() == true || fields[i][j - 1].isSmok() == true || fields[i][j + 1].isSmok() == true) {
                        fields[i][j].setSmell();
                    }

                }
                if (i == size - 1 && j > 0 && j < size - 1) {
                    if (fields[i - 1][j].isHole() == true || fields[i][j - 1].isHole() == true || fields[i][j + 1].isHole() == true) {
                        fields[i][j].setWind();
                    }
                    if (fields[i - 1][j].isSmok() == true || fields[i][j - 1].isSmok() == true || fields[i][j + 1].isSmok() == true) {
                        fields[i][j].setSmell();

                    }
                }
                if (i > 0 && i < size - 1 && j == 0) {
                    if (fields[i + 1][j].isHole() == true || fields[i - 1][j].isHole() == true || fields[i][j + 1].isHole() == true) {
                        fields[i][j].setWind();
                    }
                    if (fields[i + 1][j].isSmok() == true || fields[i - 1][j].isSmok() == true || fields[i][j + 1].isSmok() == true) {
                        fields[i][j].setSmell();
                    }

                }
                if (i > 0 && i < size - 1 && j == size - 1) {
                    if (fields[i + 1][j].isHole() == true || fields[i - 1][j].isHole() == true || fields[i][j - 1].isHole() == true) {
                        fields[i][j].setWind();
                    }
                    if (fields[i + 1][j].isSmok() == true || fields[i - 1][j].isSmok() == true || fields[i][j - 1].isSmok() == true) {
                        fields[i][j].setSmell();
                    }

                }
                if (i > 0 && j > 0 && i < size - 1 && j < size - 1) {
                    if (fields[i + 1][j].isHole() == true || fields[i - 1][j].isHole() == true || fields[i][j - 1].isHole() == true || fields[i][j + 1].isHole() == true) {
                        fields[i][j].setWind();
                    }
                    if (fields[i + 1][j].isSmok() == true || fields[i - 1][j].isSmok() == true || fields[i][j - 1].isSmok() == true || fields[i][j + 1].isSmok() == true) {
                        fields[i][j].setSmell();

                    }

                }
            }

        }
    }

}
