/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegovikingos;

/**
 *
 * @author edujg
 */
public class Blank extends Pieza{

    @Override
    public boolean movimiento(Pieza[][] tablero, int x, int y, int xo, int yo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pieza[][] comer(Pieza[][] tablero, int x, int y, int xo, int yo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "| |";
    }
    
}
