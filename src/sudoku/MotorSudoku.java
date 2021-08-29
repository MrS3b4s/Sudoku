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
    private int[] listaNumeros = new int[9];

    public int[] getListaNumeros() {
        return listaNumeros;
    }

    public void setListaNumeros(int[] listaNumeros) {
        this.listaNumeros = listaNumeros;
    }

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
 
    }
    
    public MotorSudoku(String[][] tablero) {
        this.setTablero(tablero);
 
    }

    public void mostrarTablero() {
        
        System.out.println("");
        System.out.println("Tablero: ");
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
        int facil = 38;
        int media = 32;
        int dificil = 25;
        int experto = 23;
        

        while (this.getCasillasLlenas() < 23) {
            num = (int) (Math.floor(Math.random() * 9 + 1));
            int[] posicion = this.generarPosicion();

            if (!this.isNumInRow(String.valueOf(num), posicion[0])
                    && !this.isNumInCol(String.valueOf(num), posicion[1])
                    && !this.identificarCuadrante(String.valueOf(num), posicion[0], posicion[1])) {
                if (this.indentificarNum(num) < 9){
                    this.getTablero()[posicion[0]][posicion[1]] = String.valueOf(num);
                    this.setCasillasLlenas(this.getCasillasLlenas() + 1);
                    this.contador(num);
                }
               
            }
        }
        
       
        if(this.solucionarSudoku()){
            System.out.println("Tablero listo: ");
        } else {
            this.setTablero(new String[9][9]);
            this.llenarTablero();
        }

    }
    
    public void contador(int num){
        int[] lista = this.getListaNumeros();

        switch (num) {
            
            case 1:
                num--;
                lista[num]++;
                break;
            case 2:
                num--;
                lista[num]++;
                break;
            case 3:
                num--;
                lista[num]++;
                break;
            case 4:
                num--;
                lista[num]++;
                break;
            case 5:
                num--;
                lista[num]++;
                break;
            case 6:
                num--;
                lista[num]++;
                break;
            case 7:
                num--;
                lista[num]++;
                break;
            case 8:
                num--;
                lista[num]++;
                break;
            case 9:
                num--;
                lista[num]++;
                break;
            
        }
        
        this.setListaNumeros(lista);
    }
    
    public int indentificarNum(int num){
        int[] lista = this.getListaNumeros();

        switch (num) {
            
            case 1:
                num--;
                return lista[num];
            case 2:
                num--;
                return lista[num];
            case 3:
                num--;
                return lista[num];
            case 4:
                num--;
                return lista[num];
            case 5:
                num--;
                return lista[num];
            case 6:
                num--;
                return lista[num];
            case 7:
                num--;
                return lista[num];
            case 8:
                num--;
                return lista[num];
            case 9:
                num--;
                return lista[num];
            default:
                return 0;
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
    
    private boolean solucionarSudoku(){
       
        for (int f = 0; f < 9; f++) {
            for (int c = 0; c < 9; c++) {
                if(this.getTablero()[f][c] == null){
                    
                    for (int i = 1; i <= 9; i++) {
                        if(this.validarNumero(String.valueOf(i), f, c)){
                            System.out.println("El numero: "+i+" es valido en la posición ["+f+""+c+"");
                            this.tablero[f][c] = String.valueOf(i);
                            if(this.solucionarSudoku()){
                                return true;
                            } else {
                                this.getTablero()[f][c] = null;
                            }
                        }
                    }
                    return false;
                   
                }
            }
        }
        
        return true;
    }
//Validaciones: Filas, Columnas y Cuadrantes -----------------------------------
    private boolean validarNumero(String num, int f, int c){
        return !this.isNumInRow(num, f) && !this.isNumInCol(num, c) && !this.identificarCuadrante(num, f, c);
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
            return this.isNumInCuadrante(num, 0, 0);
        } else if ((f >= 0 && f <= 2) && (c >= 3 && c <= 5)) {
            return this.isNumInCuadrante(num, 0, 3);
        } else if ((f >= 0 && f <= 2) && (c >= 6 && c <= 8)) {
            return this.isNumInCuadrante(num, 0, 6);
        } else if ((f >= 3 && f <= 5) && (c >= 0 && c <= 2)) {
            return this.isNumInCuadrante(num, 3, 0);
        } else if ((f >= 3 && f <= 5) && (c >= 3 && c <= 5)) {
            return this.isNumInCuadrante(num, 3, 3);
        } else if ((f >= 3 && f <= 5) && (c >= 6 && c <= 8)) {
            return this.isNumInCuadrante(num, 3, 6);
        } else if ((f >= 6 && f <= 8) && (c >= 0 && c <= 2)) {
            return this.isNumInCuadrante(num, 6, 0);
        } else if ((f >= 6 && f <= 8) && (c >= 3 && c <= 5)) {
            return this.isNumInCuadrante(num, 6, 3);
        } else if ((f >= 6 && f <= 8) && (c >= 6 && c <= 8)) {
            return this.isNumInCuadrante(num, 6, 6);
        }

        return false;
    }

    private boolean isNumInCuadrante(String num, int f, int c) {
        String[][] t = this.getTablero();
        int i = f;
        int j = c;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (t[i][j] == null ? (num) == null : t[i][j].equals(num)) {
                    return true;
                }
                j++;
            }
            j = c;
            i++;
        }
        return false;
    }
//------------------------------------------------------------------------------

    private boolean mostrarCuadrante(String num, int f, int c) {
        String[][] t = this.getTablero();
        int i = f;
        int j = c;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print("[" + String.valueOf(i) + String.valueOf(j) + "]");
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
        String[][] t = {
            {"4","6","9",null,null,null,null,null,"2"},  
            {"7",null,null,"2","8",null,null,"9","6"},  
            {"2","8","1","3","9","6",null,"4",null},  
            {"8","7",null,"5",null,"9","6",null,null},  
            {"6",null,null,"8",null,null,null,null,null},  
            {"5","1",null,null,"7",null,"9","8","4"},  
            {null,"2","6",null,null,null,null,"7","8"},  
            {null,null,null,null,"2",null,"5",null,null},  
            {"1",null,null,null,null,null,"4","2",null},  
        };
        
        MotorSudoku motor = new MotorSudoku();
        motor.mostrarTablero();

        
        
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
