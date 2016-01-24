/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smok;

import java.util.Random;

/**
 *
 * @author lukasz
 */
public class MapGenerator {

    private static int size;
    private Random generator = new Random();
    private Map mapa;

    MapGenerator(int size) {
        this.size = size;
        genMap();

    }

    private void genMap() {

        mapa = new Map(size);
        mapa.init();
        mapa.setValue(0, 0, 1);
        int x, y;
        
        boolean setGold = false;
        while (setGold == false) {
            x = genCordX();
            y = genCordY();
            if (x == 0 && y == 0) {
                x = genCordX();
                y = genCordY();
                //  mapa.setValue(x, y, 2);
            } else {
                mapa.setValue(x, y, 2);
                System.out.println(x + "  " +y);
                setGold=true;
            }
        }
        //mapa.show();
        int i = generator.nextInt(size) + 1;  //generuj randomowa ilosc dziur
        int j = 0;
        while(j<i) {
            int x1, y1;
            x1 = genCordX();
            y1 = genCordY();
            if ((x1 == 0 && x1 == 0) || mapa.getStatGold(x1, y1)==true) {
                x1 = genCordX();
                y1 = genCordY();
            } else {
                mapa.setValue(x1, y1, 3);
                j++;
            }

        }
        int x1, y1;
        x1 = genCordX();
        y1 = genCordY();

        if (mapa.getStatAgent(x1, y1) == true || mapa.getStatHole(x1, y1) == true || mapa.getStatGold(x1, y1)) {
            x1 = genCordX();
            y1 = genCordY();
            mapa.setValue(x1, y1, 4);

        } else {
            mapa.setValue(x1, y1, 4);
        }

        if ((mapa.getStatHole(1, 0) == true || mapa.getStatSmok(1, 0) == true) && (mapa.getStatHole(0, 1) == true || mapa.getStatSmok(0, 1) == true)) {
            if (mapa.getStatHole(1, 0) == true) {
                mapa.changeHole(1, 0);
            } else {
                mapa.changeHole(0, 1);
            }
        }
        mapa.setNeigh();

    }

    public Map returnMap() {
        return mapa;
    }

    private int genCordX() {
        return generator.nextInt(size);

    }

    private int genCordY() {
        return generator.nextInt(size);

    }

}
