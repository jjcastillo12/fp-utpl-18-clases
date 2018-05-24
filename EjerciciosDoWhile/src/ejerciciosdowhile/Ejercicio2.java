/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosdowhile;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String nombre;
        String reporte = "";
        String reporte1 = "";
        String reporte2 = "";
        String contador_pases = "";
        String contador_goles = "";
        int goles;
        int pases;
        int suma1 = 0;
        int suma2 = 0;
        int numero_partidos = 0;
        int salir1 = 0;
        int numero_jugador = 0;
        double promedio_pases = 0;
        double promedio_goles = 0;
        boolean salir = true;

        reporte = String.format("Reporte de Jugadores del Equipo\"UTPL\"\n\n%-22s%-16s%-16s%-17s\n\n", "Nombre del Jugador", "Total de Pases", "Total de Goles", "Nivel de Jugador");

        do {
            numero_jugador = numero_jugador + 1;
            System.out.printf("Nombre del Jugador:\n ");
            nombre = entrada.nextLine();
            System.out.printf("Ingrese el número de  partidos que a Jugado:\n ");
            numero_partidos = entrada.nextInt();

            reporte1 = String.format("%-22s", nombre);

            for (int contador = 1; contador <= numero_partidos; contador++) {

                System.out.printf("Total de Pases Partido %d: ", contador);
                pases = entrada.nextInt();
                System.out.printf("Total Goles Partido %d: ", contador);
                goles = entrada.nextInt();

                contador_pases = String.format("P%d:%-16d", contador, pases);
                contador_goles = String.format("G%d:%-16d", contador, goles);

                if (contador == 1) {
                    reporte1 = String.format("%s%-18s%-18s\n", reporte1, contador_pases, contador_goles);
                } else {
                    reporte1 = String.format("%s%-22s%-18s%-18s\n", reporte1, "", contador_pases, contador_goles);
                }
                suma1 = suma1 + pases;
                suma2 = suma2 + goles;

            }
            if (suma1 >= 100) {
                reporte2 = "Excelente";

            } else if (suma1 < 100 && suma1 >= 80) {
                reporte2 = "Muy bueno";
            } else if (suma1 < 80 && suma1 >= 60) {
                reporte2 = "Bueno";
            } else {
                reporte2 = "Regular";
            }

            contador_pases = String.format("Total:%d", suma1);
            contador_goles = String.format("Total:%d", suma2);
            reporte1 = String.format("%s\n%-22s%-18s%-18s%-17s", reporte1, "", contador_pases, contador_goles, reporte2);
            reporte = String.format("%s%s\n\n", reporte, reporte1);

            promedio_pases = promedio_pases + suma1;
            promedio_goles = promedio_goles + suma2;

            System.out.printf("¿Desea salir? Pulse 1-Si --- 2-No:");
            salir1 = entrada.nextInt();
            entrada.nextLine();

            if (salir1 == 1) {
                salir = false;
            }

            suma1 = 0;
            suma2 = 0;

        } while (salir);

        promedio_pases = promedio_pases / numero_jugador;
        promedio_goles = promedio_goles / numero_jugador;

        reporte = String.format("%sDatos Finales:\n%d Jugadores Analizados.\nPromedio de Pases del equipo es %.2f\nPromedio de Goles del equipo %.2f \n\nDepartamento Estadistico ", reporte, numero_jugador, promedio_pases, promedio_goles);
        System.out.printf(reporte);
    }

}
