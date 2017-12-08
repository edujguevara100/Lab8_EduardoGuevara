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
public class Atacante extends Pieza {

    @Override
    public boolean movimiento(Pieza[][] tablero, int x, int y, int xo, int yo) {
        if (xo - x == 0 && yo - y != 0) {
            if (yo - y < 0) {
                for (int i = y; i > yo; i--) {
                    if (i != yo + 1) {
                        if (tablero[i - 1][x] instanceof Blank) {
                        } else {
                            return false;
                        }
                    } else {
                        if (tablero[i - 1][x] instanceof Blank) {
                        } else {
                            return false;
                        }
                    }
                }
                return true;
            } else {
                for (int i = y; i < yo; i++) {
                    if (i != yo - 1) {
                        if (tablero[i + 1][x] instanceof Blank) {
                        } else {
                            return false;
                        }
                    } else {
                        if (tablero[i + 1][x] instanceof Blank) {
                        } else {
                            return false;
                        }
                    }
                }
                return true;
            }
        } else if (yo - y == 0 && xo - x != 0) {
            if (xo - x < 0) {
                for (int i = x; i > xo; i--) {
                    if (i != xo + 1) {
                        if (tablero[y][i - 1] instanceof Blank) {
                        } else {
                            return false;
                        }
                    } else {
                        if (tablero[y][i - 1] instanceof Blank) {
                        } else {
                            return false;
                        }
                    }
                }
                return true;
            } else {
                for (int i = x; i < xo; i++) {
                    if (i != xo - 1) {
                        if (tablero[y][i + 1] instanceof Blank) {
                        } else {
                            return false;
                        }
                    } else {
                        if (tablero[y][i + 1] instanceof Blank) {
                        } else {
                            return false;
                        }
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public Pieza[][] comer(Pieza[][] tablero, int x, int y, int xo, int yo) {
        Pieza temp = tablero[y][x];
        tablero[y][x] = new Blank();
        tablero[yo][xo] = temp;
        return tablero;
    }

    @Override
    public String toString() {
        return " X";
    }

}
