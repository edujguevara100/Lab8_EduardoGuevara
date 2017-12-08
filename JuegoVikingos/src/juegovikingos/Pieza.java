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
public abstract class Pieza {
    public abstract boolean movimiento(Pieza[][] tablero, int x, int y, int xo, int yo);
    public abstract Pieza[][] comer(Pieza[][] tablero, int x, int y, int xo, int yo);
    
}
