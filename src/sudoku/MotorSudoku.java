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
    

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public MotorSudoku() {
        this.llenarTablero();
    }
    
    
       
    public void mostrarTablero() {
        for (int f = 0; f < 9; f++){
            for (int c = 0; c < 9; c++){
                System.out.print("["+tablero[f][c]+"]");
            }
            System.out.println();
        }
    }
    
    public void llenarTablero() {
        int num;
        int facil = 42;
        
        for (int i = 0; i<42; i++) {
            num = (int)(Math.floor(Math.random()*9+1));
          
            
            int[] posicion = this.generarPosicion();
            this.getTablero()[posicion[0]][posicion[1]] = String.valueOf(num);
        }
        
        
    }
    
    public int[] generarPosicion(){
        int[] posicion = new int[2];
        
        int f;
        int c;
        
        do{
            f = (int)(Math.floor(Math.random()*9));
            c = (int)(Math.floor(Math.random()*9));
        }
        while(this.getTablero()[f][c] != null);
        
        
        posicion[0] = f;
        posicion[1] = c;
        
        return posicion;
    }
            
    public static void main(String[] args){
        MotorSudoku sudoku;
        sudoku = new MotorSudoku();
        sudoku.mostrarTablero();
        sudoku.llenarTablero();
        sudoku.mostrarTablero();
        
        
        
        
        
        
        
        
        
        /*
        
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
