/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegovikingos;

import java.util.Scanner;

/**
 *
 * @author edujg
 */
public class JuegoVikingos {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static boolean gane = false, hayrey = true;

    public static void main(String[] args) {
        char resp = 's';
        gane = false;
        hayrey = true;
        int filas = 0, columnas = 0, turnos = 2;
        Pieza[][] tablero = matriz();
        Imprimir(tablero, filas, columnas);
        System.out.println("");
        while ((gane == false && hayrey == true) && resp == 's') {
            filas = 0;
            columnas = 0;
            hayrey = false;
            boolean validamov = false;
            boolean exception = false;
            while (!validamov) {
                int piezaselectx = -1;
                int piezaselecty = -1;
                int movimientox = -1;
                int movimientoy = -1;
                int ocupadocont = 0;
                while (piezaselecty < 0 || piezaselecty > 10) {
                    System.out.println("Ingrese la fila(0-10) en la que se encuentra su pieza: ");
                    try {
                        piezaselecty = sc.nextInt();
                    } catch (Exception e) {
                        //System.out.println("Formato invalido");
                        sc.nextLine();
                        piezaselecty = -1;
                    }
                    if (piezaselecty < 0 || piezaselecty > 10) {
                        System.out.println("Pieza no existe");
                    }
                }
                while (piezaselectx < 0 || piezaselectx > 10) {
                    System.out.println("Ingrese la columna(0-10) en la que se encuentra su pieza: ");
                    try {
                        piezaselectx = sc.nextInt();
                    } catch (Exception e) {
                        sc.nextLine();
                        piezaselectx = -1;
                    }
                    if (piezaselectx < 0 || piezaselectx > 10) {
                        System.out.println("Pieza no existe");
                    }
                }
                while (movimientoy < 0 || movimientoy > 10) {
                    System.out.println("Ingrese la fila(0-10) a la que quiera mover su pieza: ");
                    try {
                        movimientoy = sc.nextInt();
                    } catch (Exception e) {
                        sc.nextLine();
                        movimientoy = -1;
                    }
                    if (movimientoy < 0 || movimientoy > 10) {
                        System.out.println("Movimiento invalido");
                    }
                }
                while (movimientox < 0 || movimientox > 10) {
                    System.out.println("Ingrese la columna(0-10) a la que quiere mover su pieza: ");
                    try {
                        movimientox = sc.nextInt();
                    } catch (Exception e) {
                        sc.nextLine();
                        movimientox = -1;
                    }
                    if (movimientox < 0 || movimientox > 10) {
                        System.out.println("Movimiento invalido");
                    }
                }
                boolean selected = false;
                if (turnos % 2 == 0) {
                    if (tablero[piezaselecty][piezaselectx] instanceof Atacante) {
                        selected = true;
                    } else {
                        System.out.println("Pieza seleccionada no es suya");
                        selected = false;
                        continue;
                    }
                } else {
                    if (tablero[piezaselecty][piezaselectx] instanceof Defensor || tablero[piezaselecty][piezaselectx] instanceof Rey) {
                        selected = true;
                    } else {
                        System.out.println("Pieza seleccionada no es suya");
                        selected = false;
                        continue;
                    }
                }
                boolean mov = tablero[piezaselecty][piezaselectx].movimiento(tablero, piezaselectx, piezaselecty, movimientox, movimientoy);
                if (mov == true) {
                    tablero = tablero[piezaselecty][piezaselectx].comer(tablero, piezaselectx, piezaselecty, movimientox, movimientoy);
                    validamov = true;
                    turnos++;
                } else {
                    System.out.println("Movimiento Invalido");
                }
            }
            tablero = act(tablero);
            tablero = act2(tablero);
            tablero = act3(tablero);
            Imprimir(tablero, 0, 0);
            System.out.println("");
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    if (tablero[i][j] instanceof Rey) {
                        hayrey = true;
                    }
                }
            }
            if (hayrey == false) {
                System.out.println("Victoria de los atacantes");
            }
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    if (tablero[i][j] instanceof Rey) {
                        if (i == 0 || i == 10) {
                            gane = true;
                        } else if (j == 0 || j == 10) {
                            gane = true;
                        }
                    }
                }
            }
            if (gane == true) {
                System.out.println("Victoria de los Defensores");
            }
            System.out.println("");
            System.out.println("");

        }
    }

    public static Pieza[][] matriz() {
        Pieza[][] tablero = {{new Blank(), new Blank(), new Blank(), new Atacante(), new Atacante(), new Atacante(), new Atacante(), new Atacante(), new Blank(), new Blank(), new Blank()},
        {new Blank(), new Blank(), new Blank(), new Blank(), new Blank(), new Atacante(), new Blank(), new Blank(), new Blank(), new Blank(), new Blank()},
        {new Blank(), new Blank(), new Blank(), new Blank(), new Blank(), new Defensor(), new Blank(), new Blank(), new Blank(), new Blank(), new Blank()},
        {new Atacante(), new Blank(), new Blank(), new Blank(), new Blank(), new Defensor(), new Blank(), new Blank(), new Blank(), new Blank(), new Atacante()},
        {new Atacante(), new Blank(), new Blank(), new Blank(), new Blank(), new Defensor(), new Blank(), new Blank(), new Blank(), new Blank(), new Atacante()},
        {new Atacante(), new Atacante(), new Defensor(), new Defensor(), new Defensor(), new Rey(), new Defensor(), new Defensor(), new Defensor(), new Atacante(), new Atacante()},
        {new Atacante(), new Blank(), new Blank(), new Blank(), new Blank(), new Defensor(), new Blank(), new Blank(), new Blank(), new Blank(), new Atacante()},
        {new Atacante(), new Blank(), new Blank(), new Blank(), new Blank(), new Defensor(), new Blank(), new Blank(), new Blank(), new Blank(), new Atacante()},
        {new Blank(), new Blank(), new Blank(), new Blank(), new Blank(), new Defensor(), new Blank(), new Blank(), new Blank(), new Blank(), new Blank()},
        {new Blank(), new Blank(), new Blank(), new Blank(), new Blank(), new Atacante(), new Blank(), new Blank(), new Blank(), new Blank(), new Blank()},
        {new Blank(), new Blank(), new Blank(), new Atacante(), new Atacante(), new Atacante(), new Atacante(), new Atacante(), new Blank(), new Blank(), new Blank()}};
        return tablero;
    }

    public static void Imprimir(Pieza[][] tablero, int filas, int columnas) {
        if (filas == tablero.length - 1 && columnas == tablero.length - 1) {
            System.out.print(tablero[filas][columnas] + "\t");
        } else {
            if (columnas == tablero.length - 1) {
                System.out.println(tablero[filas][columnas]);
                Imprimir(tablero, filas + 1, 0);
            } else {
                System.out.print(tablero[filas][columnas] + "\t");
                Imprimir(tablero, filas, columnas + 1);
            }
        }
    }

    public static Pieza[][] act(Pieza[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] instanceof Defensor) {
                    if (i != 0 && i != tablero.length - 1) {
                        if (tablero[i + 1][j] instanceof Atacante && tablero[i - 1][j] instanceof Atacante) {
                            tablero[i][j] = new Blank();
                        }
                        if (j != 0 && j != tablero.length - 1) {
                            if (tablero[i][j + 1] instanceof Atacante && tablero[i][j - 1] instanceof Atacante) {
                                tablero[i][j] = new Blank();
                            }
                        }
                    } else if (j != 0 && j != tablero.length - 1) {
                        if (tablero[i][j + 1] instanceof Atacante && tablero[i][j - 1] instanceof Atacante) {
                            tablero[i][j] = new Blank();
                        }
                        if (i != 0 && i != tablero.length - 1) {
                            if (tablero[i + 1][j] instanceof Atacante && tablero[i - 1][j] instanceof Atacante) {
                                tablero[i][j] = new Blank();
                            }
                        }
                    }
                } else if (tablero[i][j] instanceof Atacante) {
                    if (i != 0 && i != tablero.length - 1) {
                        if ((tablero[i + 1][j] instanceof Defensor || tablero[i + 1][j] instanceof Rey) && (tablero[i - 1][j] instanceof Defensor || tablero[i - 1][j] instanceof Rey)) {
                            tablero[i][j] = new Blank();
                        }
                        if (j != 0 && j != tablero.length - 1) {
                            if ((tablero[i][j + 1] instanceof Defensor || tablero[i][j + 1] instanceof Rey) && (tablero[i][j - 1] instanceof Defensor || tablero[i][j - 1] instanceof Rey)) {
                                tablero[i][j] = new Blank();
                            }
                        }
                    } else if (j != 0 && j != tablero.length - 1) {
                        if ((tablero[i][j + 1] instanceof Defensor || tablero[i][j + 1] instanceof Rey) && (tablero[i][j - 1] instanceof Defensor || tablero[i][j - 1] instanceof Rey)) {
                            tablero[i][j] = new Blank();
                        }
                        if (i != 0 && i != tablero.length - 1) {
                            if ((tablero[i + 1][j] instanceof Defensor || tablero[i + 1][j] instanceof Rey) && (tablero[i - 1][j] instanceof Defensor || tablero[i - 1][j] instanceof Rey)) {
                                tablero[i][j] = new Blank();
                            }
                        }
                    }
                }
            }

        }
        return tablero;
    }

    public static Pieza[][] act2(Pieza[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] instanceof Defensor || tablero[i][j] instanceof Rey) {
                    if (i + 3 > tablero.length - 1) {
                        //abajo
                    } else {
                        if (tablero[i + 3][j] instanceof Defensor || tablero[i + 3][j] instanceof Rey) {
                            if (tablero[i + 1][j] instanceof Atacante && tablero[i + 2][j] instanceof Atacante) {
                                tablero[i + 1][j] = new Blank();
                                tablero[i + 2][j] = new Blank();
                            }
                        }
                    }
                    if (i - 3 < 0) {
                        //arriba
                    } else {
                        if (tablero[i - 3][j] instanceof Defensor || tablero[i - 3][j] instanceof Rey) {
                            if (tablero[i - 1][j] instanceof Atacante && tablero[i - 2][j] instanceof Atacante) {
                                tablero[i - 1][j] = new Blank();
                                tablero[i - 2][j] = new Blank();
                            }
                        }
                    }
                    if (j + 3 > tablero.length - 1) {
                    } else {
                        //derecha
                        if (tablero[i][j + 3] instanceof Defensor || tablero[i][j + 3] instanceof Rey) {
                            if (tablero[i][j + 1] instanceof Atacante && tablero[i][j + 2] instanceof Atacante) {
                                tablero[i][j + 1] = new Blank();
                                tablero[i][j + 2] = new Blank();
                            }
                        }
                    }
                    if (j - 3 < 0) {
                    } else {
                        //izquierda
                        if (tablero[i][j - 3] instanceof Defensor || tablero[i][j - 3] instanceof Rey) {
                            if (tablero[i][j - 1] instanceof Atacante && tablero[i][j - 2] instanceof Atacante) {
                                tablero[i][j - 1] = new Blank();
                                tablero[i][j - 2] = new Blank();
                            }
                        }
                    }
                } else if (tablero[i][j] instanceof Atacante) {
                    if (i + 3 > tablero.length - 1) {
                        //abajo
                    } else {
                        if (tablero[i + 3][j] instanceof Atacante) {
                            if ((tablero[i + 1][j] instanceof Defensor || tablero[i + 1][j] instanceof Rey) && (tablero[i + 2][j] instanceof Defensor || tablero[i + 2][j] instanceof Rey)) {
                                tablero[i + 1][j] = new Blank();
                                tablero[i + 2][j] = new Blank();
                            }
                        }
                    }
                    if (i - 3 < 0) {
                        //arriba
                    } else {
                        if (tablero[i - 3][j] instanceof Atacante) {
                            if ((tablero[i - 1][j] instanceof Defensor || tablero[i - 1][j] instanceof Rey) && (tablero[i - 2][j] instanceof Defensor || tablero[i - 2][j] instanceof Rey)) {
                                tablero[i - 1][j] = new Blank();
                                tablero[i - 2][j] = new Blank();
                            }
                        }
                    }
                    if (j + 3 > tablero.length - 1) {
                        //derecha
                    } else {
                        if (tablero[i][j + 3] instanceof Atacante) {
                            if ((tablero[i][j + 1] instanceof Defensor || tablero[i][j + 1] instanceof Rey) && (tablero[i][j + 2] instanceof Defensor || tablero[i][j + 2] instanceof Rey)) {
                                tablero[i][j + 1] = new Blank();
                                tablero[i][j + 2] = new Blank();
                            }
                        }
                    }
                    if (j - 3 < 0) {
                    } else {
                        //izquierda
                        if (tablero[i][j - 3] instanceof Atacante) {
                            if ((tablero[i][j - 1] instanceof Defensor || tablero[i][j - 1] instanceof Rey) && (tablero[i][j - 2] instanceof Defensor || tablero[i][j - 2] instanceof Rey)) {
                                tablero[i][j - 1] = new Blank();
                                tablero[i][j - 2] = new Blank();
                            }
                        }
                    }
                }
            }
        }
        return tablero;
    }

    public static Pieza[][] act3(Pieza[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] instanceof Defensor || tablero[i][j] instanceof Rey) {
                    if (i + 4 > tablero.length - 1) {
                        //abajo
                    } else {
                        if (tablero[i + 4][j] instanceof Defensor || tablero[i + 4][j] instanceof Rey) {
                            if (tablero[i + 1][j] instanceof Atacante && tablero[i + 2][j] instanceof Atacante && tablero[i + 3][j] instanceof Atacante) {
                                tablero[i + 1][j] = new Blank();
                                tablero[i + 2][j] = new Blank();
                                tablero[i + 3][j] = new Blank();
                            }
                        }
                    }
                    if (i - 4 < 0) {
                        //arriba
                    } else {
                        if (tablero[i - 4][j] instanceof Defensor || tablero[i - 4][j] instanceof Rey) {
                            if (tablero[i - 1][j] instanceof Atacante && tablero[i - 2][j] instanceof Atacante && tablero[i - 3][j] instanceof Atacante) {
                                tablero[i - 1][j] = new Blank();
                                tablero[i - 2][j] = new Blank();
                                tablero[i - 3][j] = new Blank();
                            }
                        }
                    }
                    if (j + 4 > tablero.length - 1) {
                    } else {
                        //derecha
                        if (tablero[i][j + 4] instanceof Defensor || tablero[i][j + 4] instanceof Rey) {
                            if (tablero[i][j + 1] instanceof Atacante && tablero[i][j + 2] instanceof Atacante && tablero[i][j + 3] instanceof Atacante) {
                                tablero[i][j + 1] = new Blank();
                                tablero[i][j + 2] = new Blank();
                                tablero[i][j + 3] = new Blank();
                            }
                        }
                    }
                    if (j - 4 < 0) {
                    } else {
                        //izquierda
                        if (tablero[i][j - 4] instanceof Defensor || tablero[i][j - 4] instanceof Rey) {
                            if (tablero[i][j - 1] instanceof Atacante && tablero[i][j - 2] instanceof Atacante && tablero[i][j - 3] instanceof Atacante) {
                                tablero[i][j - 1] = new Blank();
                                tablero[i][j - 2] = new Blank();
                                tablero[i][j - 3] = new Blank();
                            }
                        }
                    }
                } else if (tablero[i][j] instanceof Atacante) {
                    if (i + 4 > tablero.length - 1) {
                        //abajo
                    } else {
                        if (tablero[i + 4][j] instanceof Atacante) {
                            if ((tablero[i + 1][j] instanceof Defensor || tablero[i + 1][j] instanceof Rey) && (tablero[i + 2][j] instanceof Defensor || tablero[i + 2][j] instanceof Rey) && (tablero[i + 3][j] instanceof Defensor || tablero[i + 3][j] instanceof Rey)) {
                                tablero[i + 1][j] = new Blank();
                                tablero[i + 2][j] = new Blank();
                                tablero[i + 3][j] = new Blank();
                            }
                        }
                    }
                    if (i - 4 < 0) {
                        //arriba
                    } else {
                        if (tablero[i - 4][j] instanceof Atacante) {
                            if ((tablero[i - 1][j] instanceof Defensor || tablero[i - 1][j] instanceof Rey) && (tablero[i - 2][j] instanceof Defensor || tablero[i - 2][j] instanceof Rey) && (tablero[i - 3][j] instanceof Defensor || tablero[i - 3][j] instanceof Rey)) {
                                tablero[i - 1][j] = new Blank();
                                tablero[i - 2][j] = new Blank();
                                tablero[i - 3][j] = new Blank();
                            }
                        }
                    }
                    if (j + 4 > tablero.length - 1) {
                        //derecha
                    } else {
                        if (tablero[i][j + 4] instanceof Atacante) {
                            if ((tablero[i][j + 1] instanceof Defensor || tablero[i][j + 1] instanceof Rey) && (tablero[i][j + 2] instanceof Defensor || tablero[i][j + 2] instanceof Rey) && (tablero[i][j + 3] instanceof Defensor || tablero[i][j + 3] instanceof Rey)) {
                                tablero[i][j + 1] = new Blank();
                                tablero[i][j + 2] = new Blank();
                                tablero[i][j + 3] = new Blank();
                            }
                        }
                    }
                    if (j - 4 < 0) {
                    } else {
                        //izquierda
                        if (tablero[i][j - 4] instanceof Atacante) {
                            if ((tablero[i][j - 1] instanceof Defensor || tablero[i][j - 1] instanceof Rey) && (tablero[i][j - 2] instanceof Defensor || tablero[i][j - 2] instanceof Rey) && (tablero[i][j - 3] instanceof Defensor || tablero[i][j - 3] instanceof Rey)) {
                                tablero[i][j - 1] = new Blank();
                                tablero[i][j - 2] = new Blank();
                                tablero[i][j - 3] = new Blank();
                            }
                        }
                    }
                }
            }
        }
        return tablero;
    }

}
