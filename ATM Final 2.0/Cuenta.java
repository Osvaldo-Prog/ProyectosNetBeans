package com.mycompany.models;

public class Cuenta <ID, PIN> {

    private ID numeroCuenta;
    private PIN pin;
    private double saldo;
    private String titular;

    public Cuenta(ID numeroCuenta, PIN pin, double saldoInicial, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldoInicial;
        this.titular = titular;
    }

    public ID getNumeroCuenta() {
        return numeroCuenta;
    }

    public PIN getPin() {
        return pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public boolean validarPin(String pinIngresado) {
        return this.pin.equals(pinIngresado);
    }

    public void setPin(PIN nuevoPin) {
        this.pin = nuevoPin;
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= this.saldo) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        }
    }
    //Tarea, diseñar los comportamientos restantes, transferir, cambiar nip
    public void transferir(double cantidad) {
        saldo -= cantidad;
    }
}
