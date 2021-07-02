package com.imaster.utp.angelg;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class EjerciciosPropuestos {

    public static void operaciones(double num1, double num2) {

        char[] operaciones = { '+', '-', '*', '/' };
        var operacion = "";
        var resultado = 0.0d;

        for (int i = 0; i < operaciones.length; i++) {

            switch (i) {
                case 0:
                    operacion = "suma";
                    resultado = num1 + num2;
                    break;

                case 1:
                    operacion = "resta";
                    resultado = num1 - num2;
                    break;
                case 2:
                    operacion = "multiplicación";
                    resultado = num1 * num2;
                    break;
                case 3:
                    operacion = "división";
                    resultado = num2 > 0 ? num1 / num2 : -1;
                    break;
            }

            System.out.println("La " + operacion + " entre " + num1 + " y " + num2 + " es "
                    + (i == 3 && resultado == -1 ? "No puede se puede dividir entre 0" : resultado));

        } // fin del ciclo principal

    }

    public static String promedio(String nombre, double[] notas) {

        var promedio = 0.0d;

        for (int i = 0; i < notas.length; i++) {

            if (notas[i] > 0.0 && notas[i] <= 5.0) {
                promedio += notas[i];
            }

        }

        promedio /= notas.length;

        return promedio > 2.9 ? "El alumno " + nombre + " ¡Aprobo!" : "El alumno " + nombre + " NO aprobo";
    }

    public static int sueldo(int horasTrabajadas) {
        return horasTrabajadas * 30000;
    }

    public static void tablaMultiplicar(int numero) {
        for (int i = 0; i < 11; i++) {
            System.out.println(numero + " * " + i + " = " + (numero * i));
        }
    }

    public static void juegoAdivinar(Scanner sc) {

        var numeroUsuario = 0;
        var numeroAleatorio = (int) (Math.abs(Math.random() * 10 + 1));

        while (numeroUsuario != numeroAleatorio) {

            try {

                System.out.print("Ingrese un número entre 0 y 10: ");
                numeroUsuario = sc.nextInt();

                if (numeroUsuario > numeroUsuario) {
                    System.out.println("El número que busca es mayor");
                } else if (numeroUsuario < numeroAleatorio) {
                    System.out.println("El número que busca es menor");
                } else {
                    System.out.println("¡Ha ganado!");
                    break;
                }

            } catch (Exception e) {
                System.out.println("Ingrese un valor correcto. Intente de nuevo.");
                numeroUsuario = -1;
            }

        }

    }

    public static int pesoIdeal(char genero, int altura) {
        var pesoIdeal = 0;

        if (genero == 'm' || genero == 'M') {
            pesoIdeal = altura - 110;
        } else if (genero == 'f' || genero == 'F') {
            pesoIdeal = altura - 120;
        } else {
            return -1;
        }

        return pesoIdeal;

    }

    public static void esPrimo(int numero, Scanner sc) {
        var contador = 0;
        var desicion = ' ';
        do {

            for (int i = 2; i < numero; i++) {
                if (numero % i == 0) {
                    contador++;
                    break;
                }
            }

            if (contador == 0) {
                System.out.println("El numero " + numero + " es primo");
            } else {
                System.out.println("El número no es primo");
            }

            System.out.print("Desea continuar (S/N)");
            desicion = sc.next().charAt(0);

            if (desicion == 'S' || desicion == 's') {
                System.out.print("Ingrese un numero: ");
                numero = sc.nextInt();
                contador = 0;
            } else {
                break;
            }

        } while (desicion != 'N' || desicion != 'n');

    }

    public static String algoritmo_PPT(char jugador1, char jugador2, int opcion) {

        var ganador = "";

        switch (jugador1) {

            case 'P':
                if (jugador2 == 80 || jugador2 == 112) {
                    ganador = "!Empate¡";
                } else if (jugador2 == 76 || jugador2 == 108) {
                    ganador = (opcion == 2 ? "¡Gana la maquina!" : "¡Gana el jugador 2!");
                } else {
                    ganador = "¡Haz ganado!";
                }
                break;

            case 'L':
                if (jugador2 == 80 || jugador2 == 112) {
                    ganador = "¡Haz ganado!";
                } else if (jugador2 == 76 || jugador2 == 108) {
                    ganador = "!Empate¡";
                } else {
                    ganador = (opcion == 2 ? "¡Gana la maquina!" : "¡Gana el jugador 2!");
                }
                break;

            case 'T':
                if (jugador2 == 80 || jugador2 == 112) {
                    ganador = (opcion == 2 ? "¡Gana la maquina!" : "¡Gana el jugador 2!");
                } else if (jugador2 == 76 || jugador2 == 108) {
                    ganador = "¡Haz ganado!";

                } else {
                    ganador = "!Empate¡";
                }
                break;

            default:
                ganador = "Opción invalida.";
                break;
        }
        return ganador;
    }

    public static char jugadaValida(Scanner sc, char jugador) {
        do {

            System.err.print("¿ P, L, T ? : ");
            jugador = sc.next().charAt(0);
            jugador = (jugador == 'p' || jugador == 'l' || jugador == 't') ? jugador -= 32 : jugador;

        } while ((jugador != 'P') && (jugador != 'L') && (jugador != 'T'));

        return jugador;
    }

    public static void piedra_Papel_Tijeras(Scanner sc) {

        // controlamos si quiere jugar con otra persona o con la maquina: 1.Otro
        // 2.Maquina. 3.Salir
        var opcion = 0;

        // opcion del usuario o jugador 1.
        var usuario1 = ' ';

        // en caso de que se decida jugar con la maquina, para no usar 2 variables
        // diferentes.
        var usuario2_maquina = ' ';

        // En caso de que se juege con la máquina.
        char[] opciones = { 'P', 'L', 'T' };

        /**
         * Opciones de elección. P piedra, L papel, T tijeras.
         */

        while (opcion != 3) {

            do {
                System.out.println(
                        "Selccione una opción de juego: \n" + "1. Dos jugadores." + "\n2.Un jugador." + "\n3.Salir.");
                opcion = sc.nextInt();
            } while (opcion < 1 || opcion > 3);

            if (opcion == 3)
                break;

            usuario1 = jugadaValida(sc, usuario1);

            if (opcion == 2) {
                usuario2_maquina = opciones[(int) (Math.random() * 3)];
            } else {
                usuario2_maquina = jugadaValida(sc, usuario2_maquina);
            }

            System.out.println(algoritmo_PPT(usuario1, usuario2_maquina, opcion));

        }
    }

    public static void fibonachi(int limite) {
        
        var num1 = 0;
        var num2 = 1;
        var fibonachi = 0;

        System.out.print(num1+" "+num2+" ");
        for (int i = 0; i < limite; i++) {
            fibonachi = num1 + num2;
            num1 = num2;
            num2 = fibonachi;
            System.out.print(fibonachi+" ");
        }

    }

    public static void main(String[] args) {

        var sc = new Scanner(System.in);
        /*
         * operaciones(5651, 3544); double [] notas = {.5, 4.5, .0};
         * System.out.println(promedio("Angel Garcia", notas)); tablaMultiplicar(5);
         */

        // juegoAdivinar(sc);

        // esPrimo(3, sc);
        //piedra_Papel_Tijeras(sc);
        fibonachi(10);

    }
}
