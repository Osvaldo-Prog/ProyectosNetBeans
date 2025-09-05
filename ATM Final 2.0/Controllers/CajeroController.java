package com.mycompany.models.Controllers;

import com.mycompany.models.CajeroModel;
import com.mycompany.models.Views.CajeroView;

public class CajeroController {

    private CajeroModel model;
    private CajeroView view;
    private boolean sistemaActivo;

    public CajeroController(CajeroModel model, CajeroView view) {
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
    }

    public void iniciarSistema() {
        view.mostrarBienvenida();
        while (sistemaActivo) {
            if (autenticarUsuario()) {
                ejecutarMenuPrincipal();
            } else {
                view.mostrarMensaje("Credenciales incorrectas");
            }
        }
        view.mostrarMensaje("Gracias por usar nuestro cajero, esperamos tu regreso");
    }

    private boolean autenticarUsuario() {
        String numeroCuenta = view.solicitarNumeroCuenta();
        String pin = view.solicitarPin();
        return model.autenticar(numeroCuenta, pin);
    }

    private void ejecutarMenuPrincipal() {
        boolean sesionActiva = true;
        while (sesionActiva) {
            view.mostrarMenuPrincipal(model.getCuentaActual().getTitular());
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    this.realizarRetiro();
                    break;
                case 3:
                    this.realizarDeposito();
                    break;
                case 4:
                    this.realizarTransferencia();
                    break;
                case 5:
                    this.cambiarPin();
                    break;
                case 6:
                    sesionActiva = false;
                    sistemaActivo = false;
                    break;
                default:
                    break;
            }
        }
    }

    public void consultarSaldo() {
        double saldo = model.consultarSaldo();
        view.mostrarSaldo(saldo);
    }
    public void realizarRetiro() {
        double cantidad = view.solicitarCantidad("Retirar");
        if (cantidad <= 0) {
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if (model.realizarRetiro(cantidad)) {
            view.mostrarMensaje("Retiro exitoso de: $" + cantidad);
        } else {
            view.mostrarMensaje("Fondos insuficientes");
        }
    }

    public void realizarDeposito() {
        double cantidad = view.solicitarCantidad("Deposito");
        if (cantidad <= 0) {
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if (model.realizarDeposito(cantidad)) {
            view.mostrarMensaje("Deposito de $" + cantidad + " realizado con exito");
        } else {
            view.mostrarMensaje("Error al proceder con el deposito");
        }
    }

    public void realizarTransferencia() {
        String cuentaDestino = view.solicitarCuentaDestino();
        double cantidad = view.solicitarCantidad("Transferencia");
        if (cantidad <= 0) {
            view.mostrarError("Error en la transferencia, debes ingresar una cantidad mayor a 0");
            return;
        }
        if (model.realizarTransaccion(cuentaDestino, cantidad)) {
            view.mostrarMensaje("Transferencia de $" + cantidad + " a la cuenta " + cuentaDestino + " realizada con éxito");
        } else {
            view.mostrarMensaje("No se pudo hacer la transferencia, favor de intentar mas tarde o verificar fondos o cuenta");
        }
    }

    public void cambiarPin() {
        String pinActual = view.solicitarPinActual();
        String nuevoPin = view.solicitarNuevoPin();

        if (model.cambiarNip(pinActual, nuevoPin)) {
            view.mostrarMensajeExito("El PIN se cambio con éxito");
        } else {
            view.mostrarError("El PIN actual es incorrecto, intenta de nuevo");
        }
    }
}
