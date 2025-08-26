package com.mycompany.practica1cajeroo;

import javax.swing.JOptionPane;

public class metodosCajero {

    String[] usuarios = {"1234", "5678", "2412"};
    String[] nombres = {"Juan", "Maria", "Osvaldo"};
    double[] saldos = {1000.0, 2500.0, 2000.0};
    int intentos = 0;
    int usuarioActual = -1;
    byte opcion;

    public void ingresarUsuario(){
        
        while (intentos < 3 && usuarioActual == -1) {
            String pin = JOptionPane.showInputDialog("Ingrese su PIN");
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i].equals(pin)) {
                    usuarioActual = i;
                    break;
                }
            }
            if (usuarioActual == -1) {
                JOptionPane.showMessageDialog(null, "PIN incorrecto");
                intentos++;
            }
        }
    }
    public void leerMovimiento(){
        do{
        opcion = Byte.parseByte(JOptionPane.showInputDialog("-----------------Bienvenido al cajero-----------------\n¿Que movimiento deseas hacer? " + nombres[usuarioActual] + "\n" +
                                                                      "1.- Ver saldo\n" +
                                                                      "2.- Retirar dinero\n" +
                                                                      "3.- Depositar dinero\n" + 
                                                                      "4.- Salir"));
        manejarCajero();
        }while(opcion != 4);
    }
    public void manejarCajero() {
        switch(opcion){
            case 1:
                JOptionPane.showMessageDialog(null, "Este es tu saldo actual " + nombres[usuarioActual] + ": " + saldos[usuarioActual]);
                break;
            case 2:
                double retiro = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el monto a retirar"));
                if (retiro <= saldos[usuarioActual]){
                    saldos[usuarioActual] -= retiro;
                    JOptionPane.showMessageDialog(null, "Retiro realizado con exito, tu saldo actual es de: " + saldos[usuarioActual]);
                }else{
                    JOptionPane.showMessageDialog(null, "Fondos insuficientes");
                }
                break;
            case 3:
                double ingreso = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el monto a depositar"));
                saldos[usuarioActual] += ingreso;
                JOptionPane.showMessageDialog(null, "Deposito realizado con exito");
                break;
            case 4: 
                break;
                
        }

    }

}
