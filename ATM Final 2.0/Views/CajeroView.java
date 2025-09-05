package com.mycompany.models.Views;

import java.util.Scanner;

public class CajeroView{ 

    private Scanner scanner;

//Construtor para inicializar un scanner
    public CajeroView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarBienvenida() {
        System.out.println("-------------------------------------------");
        System.out.println("Bienvenido al cajero automático del banco");
        System.out.println("-------------------------------------------");
    }

    public String solicitarNumeroCuenta() {
        System.out.println("Ingresa tu número de cuenta: ");
        return scanner.nextLine();
    }

    public String solicitarPin() {
        System.out.println("Ingresa tu PIN: ");
        return scanner.nextLine();
    }

    public void mostrarMenuPrincipal(String titular) {
        System.out.println("-------------------------------------------");
        System.out.println("         Bienvenid@" + titular);
        System.out.println("-------------------------------------------");
        System.out.println("1.- Consultar saldo");
        System.out.println("2.- Retirar");
        System.out.println("3.- Depositar");
        System.out.println("4.- Transferir");
        System.out.println("5.- Cambiar NIP");
        System.out.println("6.- Salir");
    }

    public int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarSaldo(double saldo) {
        System.out.println("-------------------------------------------");
        System.out.println("     Tu saldo actual es de: $" + saldo);
        System.out.println("-------------------------------------------");
    }

    public double solicitarCantidad(String operacion) {
        System.out.println("Ingresa la cantidad a " + operacion + ": ");
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("-------" + mensaje + "-------");
    }

    //tarea personalizar mensajes de error y de exito
    public void mostrarError(String mensaje) {
        System.out.println("--------" + mensaje + "--------");
    }

    public void mostrarMensajeExito(String mensaje) {
        System.out.println("--------" + mensaje + "--------");
    }

    public String solicitarPinActual() {
        System.out.println("Ingresa tu PIN actual: ");
        return scanner.nextLine();
    }

    public String solicitarNuevoPin() {
        System.out.println("Ingresa el nuevo PIN: ");
        return scanner.nextLine();
    }

    //metodo para solicitar cuenta destinataria
    public String solicitarCuentaDestino() {
        System.out.println("Ingresa el numero de cuenta de destino: ");
        return scanner.nextLine();
    }

}
