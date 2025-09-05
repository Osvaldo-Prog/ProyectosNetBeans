package com.mycompany.models;

import java.util.HashMap;
import java.util.Map;
public class CajeroModel {

    private Map<String, Cuenta> cuentas;
    private Cuenta cuentaActual;

    public CajeroModel() {
        cuentas = new HashMap<>();
        inicializarCuentas();
    }

    private void inicializarCuentas() {
        Cuenta<String, String> cuentaGenerica1 = new Cuenta<>("08120", "08120", 9000, "Ambar2");
        cuentas.put("12345", new Cuenta("12345", "1111", 5000, "Osvaldo"));
        cuentas.put("56789", new Cuenta("56789", "6789", 7000, "Adrian"));
        cuentas.put("54321", new Cuenta("54321", "2412", 8600, "Ambar"));
    }

    public boolean autenticar(String numeroCuenta, String pin) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && cuenta.validarPin(pin)) {
            this.cuentaActual = cuenta;
            return true;
        }
        return false;
    }

    public Cuenta getCuentaActual() {
        return this.cuentaActual;
    }

    public double consultarSaldo() {
        return this.cuentaActual != null ? cuentaActual.getSaldo() : 0;
    }

    public boolean realizarRetiro(double cantidad) {
        return this.cuentaActual != null && cuentaActual.retirar(cantidad);
    }
    public boolean realizarDeposito(double cantidad) {
        if (cuentaActual != null && cantidad > 0) {
            cuentaActual.depositar(cantidad);
            return true;
        }
        return false;
    }

    public boolean cuentaExistente(String numeroCuenta) {
        return cuentas.containsKey(numeroCuenta);
    }
    //definir metodo para transferir
    public boolean realizarTransaccion(String cuentaDestino, double cantidad) {
        if (cuentaActual != null && cantidad > 0 && cuentaExistente(cuentaDestino)) {
            Cuenta destino = cuentas.get(cuentaDestino);
            if (cuentaActual.retirar(cantidad)) {
                destino.depositar(cantidad);
                return true;
            }
        }
        return false;
    }
    public boolean cambiarNip(String pinActual, String nuevoPin) {
        if (cuentaActual != null && cuentaActual.validarPin(pinActual)) {
            cuentaActual.setPin(nuevoPin);
            return true;
        }
        return false;
    }

}


//Tarea investigar que es javadoc, como utilizarlo e implementarlo a este codigo
