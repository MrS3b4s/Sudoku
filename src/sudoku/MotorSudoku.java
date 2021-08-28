/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author matoc
 */
public class MotorSudoku {

    private String[][] tablero = new String[9][9];
    private int casillasLlenas = 0;

    public int getCasillasLlenas() {
        return casillasLlenas;
    }

    public void setCasillasLlenas(int casillasLlenas) {
        this.casillasLlenas = casillasLlenas;
    }

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public MotorSudoku() {
        this.llenarTablero();
        System.out.println("Casillas llenas: " + this.getCasillasLlenas());
    }

    public void mostrarTablero() {
        for (int f = 0; f < 9; f++) {
            for (int c = 0; c < 9; c++) {
                System.out.print("[" + tablero[f][c] + "]");
            }
            System.out.println();
        }
    }

    //Llena la matriz con 42 numeros aleatorios, siempre en posiciones vacias.
    private void llenarTablero() {
        int num;
        int facil = 42;
        /*
        for (int i = 0; i < 42; i++) {
            num = (int) (Math.floor(Math.random() * 9 + 1));
            int[] posicion = this.generarPosicion();
            System.out.println(num + "[" + posicion[0] + "][" + posicion[1] + "]");

           if(!this.isNumInRow(String.valueOf(num), posicion[0]) &&
              !this.isNumInCol(String.valueOf(num), posicion[1]) &&
              !this.identificarCuadrante(String.valueOf(num), posicion[0], posicion[1])){
               this.getTablero()[posicion[0]][posicion[1]] = String.valueOf(num);
               this.setCasillasLlenas(this.getCasillasLlenas() + 1);
           }
        }
        */
        
        while (this.getCasillasLlenas()<42){
            num = (int) (Math.floor(Math.random() * 9 + 1));
            int[] posicion = this.generarPosicion();
            System.out.println(num + "[" + posicion[0] + "][" + posicion[1] + "]");

            if(!this.isNumInRow(String.valueOf(num), posicion[0]) &&
               !this.isNumInCol(String.valueOf(num), posicion[1]) &&
               !this.identificarCuadrante(String.valueOf(num), posicion[0], posicion[1])){
                
                this.getTablero()[posicion[0]][posicion[1]] = String.valueOf(num);
                this.setCasillasLlenas(this.getCasillasLlenas() + 1);
            }
        }
       
    }
    
    /*
    
    private void llenarTablero() {
        int num;
        int facil = 42;

        for (int i = 0; i < 42; i++) {
            num = (int) (Math.floor(Math.random() * 9 + 1));
            int[] posicion = this.generarPosicion();
            System.out.println(num + "[" + posicion[0] + "][" + posicion[1] + "]");

           if(!this.isNumInRow(String.valueOf(num), posicion[0]) &&
              !this.isNumInCol(String.valueOf(num), posicion[1]) &&
              !this.identificarCuadrante(String.valueOf(num), posicion[0], posicion[1])){
               this.getTablero()[posicion[0]][posicion[1]] = String.valueOf(num);
               this.setCasillasLlenas(this.getCasillasLlenas() + 1);
           }
        }

    }
    */

    private void llenarTableroCeros() {

        for (int f = 0; f < 9; f++) {
            for (int c = 0; c < 9; c++) {
                this.getTablero()[f][c] = "0";
            }

        }

    }

    private boolean isNumInRow(String num, int f) {
        String[][] t = this.getTablero();

        for (int x = 0; x < 9; x++) {
            if (t[f][x] == null ? (num) == null : t[f][x].equals(num)) {
                return true;
            }
        }

        return false;
    }

    private boolean isNumInCol(String num, int c) {
        String[][] t = this.getTablero();

        for (int x = 0; x < 9; x++) {
            if (t[x][c] == null ? (num) == null : t[x][c].equals(num)) {
                return true;
            }
        }

        return false;
    }

    private boolean identificarCuadrante(String num, int f, int c) {
        if ((f >= 0 && f <= 2) && (c >= 0 && c <= 2)) {
            System.out.println("Cuadrante 1 ["+f+"]["+c+"]:" + num);
            return this.isNumInCuadrante(num, 0, 0);
        } else if ((f >= 0 && f <= 2) && (c >= 3 && c <= 5)) {
            System.out.println("Cuadrante 2 ["+f+"]["+c+"]:" + num);
            return this.isNumInCuadrante(num, 0, 3);
        } else if ((f >= 0 && f <= 2) && (c >= 6 && c <= 8)) {
            System.out.println("Cuadrante 3 ["+f+"]["+c+"]:" + num);
            return this.isNumInCuadrante(num, 0, 6);
        } else if ((f >= 3 && f <= 5) && (c >= 0 && c <= 2)) {
            System.out.println("Cuadrante 4 ["+f+"]["+c+"]:" + num);
            return this.isNumInCuadrante(num, 3, 0);
        } else if ((f >= 3 && f <= 5) && (c >= 3 && c <= 5)) {
            System.out.println("Cuadrante 5 ["+f+"]["+c+"]:" + num);
            return this.isNumInCuadrante(num, 3, 3);
        } else if ((f >= 3 && f <= 5) && (c >= 6 && c <= 8)) {
            System.out.println("Cuadrante 6 ["+f+"]["+c+"]:" + num);
            return this.isNumInCuadrante(num, 3, 6);
        } else if ((f >= 6 && f <= 8) && (c >= 0 && c <= 2)) {
            System.out.println("Cuadrante 7 ["+f+"]["+c+"]:" + num);
            return this.isNumInCuadrante(num, 6, 0);
        } else if ((f >= 6 && f <= 8) && (c >= 3 && c <= 5)) {
            System.out.println("Cuadrante 8 ["+f+"]["+c+"]:" + num);
            return this.isNumInCuadrante(num, 6, 3);
        } else if ((f >= 6 && f <= 8) && (c >= 6 && c <= 8)) {
            System.out.println("Cuadrante 9 ["+f+"]["+c+"]:" + num);
            return this.isNumInCuadrante(num, 6, 6);
        }

        return false;
    }
    
    private boolean isNumInCuadrante(String num,int f, int c){
        String[][] t = this.getTablero();
        int i = f;
        int j = c;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print("["+String.valueOf(i)+String.valueOf(j)+"]");
                if(t[i][j] == null ? (num) == null : t[i][j].equals(num)){
                    return true;
                }
                j++;
            }
            System.out.println();
            j = c;
            i++;
        }
        return false;
    }
    
    private boolean mostrarCuadrante(String num,int f, int c){
        String[][] t = this.getTablero();
        int i = f;
        int j = c;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print("["+String.valueOf(i)+String.valueOf(j)+"]");
                j++;
            }
            System.out.println();
            j = c;
            i++;
        }
           
            
        return false;
    }
    

    //Busca una posición vacía(null) en la matriz y retorna la fila y columna en un arreglo de 2 enteros.
    private int[] generarPosicion() {
        int[] posicion = new int[2];

        int f;
        int c;

        do {
            f = (int) (Math.floor(Math.random() * 9));
            c = (int) (Math.floor(Math.random() * 9));
        } while (this.getTablero()[f][c] != null);

        posicion[0] = f;
        posicion[1] = c;

        return posicion;
    }

    public static void main(String[] args) {
        MotorSudoku motor = new MotorSudoku();
        motor.mostrarTablero();
        motor.identificarCuadrante("1", 6,6);
        /*

        
        for (int f = 0; f < 9; f++) {
            for (int c = 0; c < 9; c++) {
                if (sudoku.isNumInCol("1", f)) {
                    System.out.println("Ya existe el numero 1 en col: "+f);
                 

                } else {
                    System.out.println("No existe el numero 1 en col: "+f);
                }
            }
            System.out.println("");
        }

        
        
        VERIFICAR CANTIDAD DE ESPACIOS LLENOS AL INICIAR EL TABLERO EN DIFICULTAD FÁCIL
        
        int cont = 0;
        for (int f = 0; f<sudoku.getTablero().length;f++){
            for (int c = 0; c<sudoku.getTablero().length;c++){
                if(sudoku.getTablero()[f][c] != null){
                    cont++;
                }
            }
        }
        
        System.out.println(cont);
         */
    }
}
