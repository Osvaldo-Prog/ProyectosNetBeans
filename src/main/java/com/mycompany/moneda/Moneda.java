
package com.mycompany.moneda;
import java.util.Scanner;

public class Moneda {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Cajero cajero = new Cajero();

        System.out.println("Ingresa cantidades en euros (enteros positivos). Ingresa 0 para terminar.");

        while (true) {
            System.out.print("Cantidad en euros: ");
            int cantidad = leer.nextInt();
            leer.nextLine(); // limpiar buffer

            if (cantidad == 0) {
                System.out.println("Programa finalizado.");
                break;
            }

            cajero.setCantidad(cantidad);
            System.out.println("DESGLOSE EN EUROS");
            cajero.mostrarCambioEuros();
            System.out.print("Deseas convertir a pesos mexicanos? (s/n): ");
            String respuesta = leer.nextLine().trim().toLowerCase();

            if (respuesta.equals("s") || respuesta.equals("sí")) {
                System.out.println("Desgloce en pesos mexicanos:");
                cajero.mostrarCambioPesos();
            } else {
                System.out.println("Conversion omitida.");
            }

            System.out.println("-----------------------------");
        }

        leer.close();
    }
}