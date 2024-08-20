package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Entrevista {

    public static void main(String[] args) {

        System.out.println("Mi nombre es : ");
        pruebasProblema1();
        pruebasProblema2();
        pruebasProblema3();
        pruebasProblema4();
        pruebasProblema5();
        pruebasProblema6();
    }

    /**
     * Parametro: Listado de string que representa un tablero de ajedrez, donde
     * exista una letra '.' quiere decir que la celda esta vacia, cuando hay un
     * 'F' la celda esta llena.
     * <p>
     * Definiciones: Un tablero de ajedrez esta conformado por celdas(8x8)
     * blancas y negras que se intercambian, la celda (0,0) es una celda blanca.
     * <p>
     * Resultado: Numero de celdas blancas que estan llenas
     * <p>
     * Logica: Iteramos sobre cada celda del tablero. Dado que las celdas blancas
     * y negras se alternan, una celda (i, j) es blanca si la suma de sus
     * índices es par. Si la celda blanca contiene 'F', incrementamos el contador.
     */
    public static int problema1(String[] tablero) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) // Verifica si la celda es blanca
                    if (tablero[i].charAt(j) == 'F') // Verifica si la celda blanca está llena
                        count++;
            }
        }
        return count;
    }

    public static void pruebasProblema1() {
        System.out.println();
        System.out.println("==================================");

        System.out.println("PRUEBAS PROBLEMA 1 : BLANCAS OCUPADAS");
        System.out.println("0=" + problema1(new String[] { "........", "........", "........", "........", "........",
                "........", "........", "........" }));

        System.out.println("32=" + problema1(new String[] { "FFFFFFFF", "FFFFFFFF", "FFFFFFFF", "FFFFFFFF", "FFFFFFFF",
                "FFFFFFFF", "FFFFFFFF", "FFFFFFFF" }));
        System.out.println("1=" + problema1(new String[] { ".F.F...F", "F...F.F.", "...F.F.F", "F.F...F.", ".F...F..",
                "F...F.F.", ".F.F.F.F", "..FF..F." }));
        System.out.println("2=" + problema1(new String[] { "........", "..F.....", ".....F..", ".....F..", "........",
                "........", ".......F", ".F......" }));

    }

    /**
     * Parametro: Numero entero
     * <p>
     * Resultado: Numero binario que representa al entero recibido
     * <p>
     * Logica: Utilizamos el método `Integer.toBinaryString` que convierte el
     * número entero a su representación binaria en forma de cadena de texto.
     */
    public static String problema2(int numero) {
        return Integer.toBinaryString(numero);
    }

    public static void pruebasProblema2() {
        System.out.println();
        System.out.println("==================================");
        System.out.println("PRUEBAS PROBLEMA 2 : BINARIO");

        System.out.println("Decimal (0) Binario (0) > " + problema2(0));
        System.out.println("Decimal (3) Binario (11) > " + problema2(3));
        System.out.println("Decimal (6) Binario (110) > " + problema2(6));
        System.out.println("Decimal (20) Binario (10100) > " + problema2(20));
        System.out.println("Decimal (34) Binario (100010) > " + problema2(34));
        System.out.println("Decimal (63) Binario (111111) > " + problema2(63));
        System.out.println("Decimal (64) Binario (1000000) > " + problema2(64));
        System.out.println("Decimal (301) Binario (100101101) > " + problema2(301));

    }

    /**
     * Parametro: Numero entero
     * <p>
     * Resultado: Verdadero si el numero recibido es primo, falso si no lo es.
     * <p>
     * Logica: Un número primo es aquel que es mayor que 1 y no es divisible por
     * ningún número excepto por 1 y por sí mismo. Iteramos desde 2 hasta la raíz
     * cuadrada del número para verificar si tiene divisores.
     */
    public static boolean problema3(int numero) {
        if(numero <= 1) // Los números menores o iguales a 1 no son primos
            return false;
        for(int i = 2; i <= Math.sqrt(numero); i++) { // Itera desde 2 hasta la raíz cuadrada del número
            if(numero % i == 0) // Si el número es divisible por i, no es primo
                return false;
        }
        return true; // Si no se encontró ningún divisor, el número es primo
    }

    public static void pruebasProblema3() {
        System.out.println();
        System.out.println("==================================");

        System.out.println("PRUEBAS PROBLEMA 3 : PRIMOS");
        System.out.println("1 es primo , respuesta : " + problema3(1));
        System.out.println("3 es primo , respuesta : " + problema3(3));
        System.out.println("6 NO es primo , respuesta : " + problema3(6));
        System.out.println("17 es primo , respuesta : " + problema3(17));
        System.out.println("39 NO es primo , respuesta : " + problema3(39));
        System.out.println("137 es primo , respuesta : " + problema3(137));
        System.out.println("497 NO es primo , respuesta : " + problema3(497));
    }

    /**
     * Parametro: Numero entero
     * <p>
     * Resultado: Numero de digitos que conforman el numero y la suma de sus
     * digitos
     * <p>
     * Logica: Contamos el número de dígitos y sumamos sus valores dividiendo
     * repetidamente el número por 10 y tomando el residuo.
     */
    public static String problema4(int numero) {
        int suma = 0;
        int numDigitos = 0;
        int tempNumero = numero;

        if (numero == 0)
            numDigitos = 1; // El número 0 tiene un dígito
        else
            while (tempNumero != 0) {
                suma += tempNumero % 10; // Suma el último dígito del número
                tempNumero /= 10; // Elimina el último dígito
                numDigitos++; // Incrementa el contador de dígitos
            }
        return numDigitos + " digitos y suma " + suma;
    }

    public static void pruebasProblema4() {
        System.out.println();
        System.out.println("==================================");

        System.out.println("PRUEBAS PROBLEMA 4 : NUMERO Y SUMA DE DIGITOS");
        System.out.println("123 > 3 digitos y suman 6, resultado : " + problema4(123));
        System.out.println("0 > 1 digitos y suman 0, resultado : " + problema4(0));
        System.out.println("100000 > 6 digitos y suman 1, resultado : " + problema4(100000));
        System.out.println("4500 > 4 digitos y suman 9, resultado : " + problema4(4500));
    }

    /**
     * Parametro: Palabra
     * <p>
     * Definicion: Palabra palindrome es aquella que es igual si se lee de
     * izquierda a derecha que de derecha a izquierda
     * <p>
     * Resultado: Verdadero si la palabra es palindrome
     * <p>
     * Logica: Comparamos los caracteres desde el inicio y el final hacia el centro.
     * Si todos los pares de caracteres coinciden, la palabra es un palíndromo.
     */
    public static boolean problema5(String palabra) {
        int izquierda = 0;
        int derecha = palabra.length() - 1;
        while (izquierda < derecha) { // Compara caracteres desde los extremos hacia el centro
            if (palabra.charAt(izquierda) != palabra.charAt(derecha)) // Si no coinciden, no es un palíndromo
                return false;
            izquierda++;
            derecha--;
        }
        return true; // Si todos los pares de caracteres coinciden, es un palíndromo
    }

    public static void pruebasProblema5() {
        System.out.println();
        System.out.println("==================================");

        System.out.println("PRUEBAS PROBLEMA 5 : PALINDROME");
        System.out.println("carro NO es , resultado : " + problema5("carro"));
        System.out.println("radar SI es , resultado : " + problema5("radar"));
        System.out.println("amar NO es , resultado : " + problema5("amar"));
        System.out.println("reconocer SI es , resultado : " + problema5("reconocer"));
        System.out.println("sometemos SI es , resultado : " + problema5("sometemos"));
        System.out.println("cantar NO es , resultado : " + problema5("cantar"));
        System.out.println("acurruca SI es , resultado : " + problema5("acurruca"));

    }

    /**
     * Parametro: Tablero
     * <p>
     * Definicion: Se recibe un tablero con piedras que caen (#), los . representan
     * espacios vacios. Si se dejara pasar unos segundos todas las piedras caerian
     * hasta el piso apilandose unas encima de otras, las piedras son cuadradas por
     * lo que permanecen en la misma columna por donde estan cayendo.
     * <p>
     * Resultado: Tablero con el estado final de las piedras luego de caer.
     * <p>
     * Logica: Contamos las piedras en cada columna y las posicionamos en la parte
     * inferior de cada columna, rellenando los espacios restantes con '.'.
     */
    public static String[] problema6(String[] tablero) {
        int filas = tablero.length;
        int columnas = tablero[0].length();
        char[][] resultado = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            Arrays.fill(resultado[i], '.'); // Rellena inicialmente con puntos
        }

        for (int col = 0; col < columnas; col++) {
            int contadorPiedras = 0;
            for (String s : tablero) {
                if (s.charAt(col) == '#')
                    contadorPiedras++; // Cuenta las piedras en la columna
            }
            for (int fila = filas - 1; fila >= filas - contadorPiedras; fila--) {
                resultado[fila][col] = '#'; // Coloca las piedras desde el fondo
            }
        }

        String[] resultadoFinal = new String[filas];
        for (int i = 0; i < filas; i++) {
            resultadoFinal[i] = new String(resultado[i]);
        }
        return resultadoFinal;
    }

    public static void pruebasProblema6() {
        System.out.println();
        System.out.println("==================================");

        System.out.println("PRUEBAS PROBLEMA 6 : GRAVEDAD");
        List<String[]> pruebas = new ArrayList<>();
        pruebas.add(new String[] {
                "#",
                ".",
                "." });
        pruebas.add(new String[] {
                "##",
                ".#",
                "#." });
        pruebas.add(new String[] {
                "..#.#",
                "#.#..",
                "...##" });
        pruebas.add(new String[] {
                "#####",
                "#####",
                "#####",
                "#####" });
        pruebas.add(new String[] {
                "." });

        List<String[]> resultados = new ArrayList<>();
        resultados.add(new String[] {
                ".",
                ".",
                "#" });
        resultados.add(new String[] {
                "..",
                "##",
                "##" });
        resultados.add(new String[] {
                ".....",
                "..#.#",
                "#.###" });
        resultados.add(new String[] {
                "#####",
                "#####",
                "#####",
                "#####" });
        resultados.add(new String[] {
                "." });

        for (int i = 0; i < pruebas.size(); i++) {
            String prueba = Arrays.toString(pruebas.get(i));
            String resultado = Arrays.toString(resultados.get(i));
            String res = Arrays.toString(problema6(pruebas.get(i)));
            System.out.println(prueba + " > " + resultado + " > " + resultado.equals(res) + " > " + res);
        }
    }
}