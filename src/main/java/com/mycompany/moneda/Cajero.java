package com.mycompany.moneda;

public class Cajero {
    private int cantidad; // en euros
    private final double tipoCambio = 22; // 1 euro = 22 pesos mexicanos

    // Inventario del cajero (puedes cambiar estos valores iniciales)
    private int stock1000 = 20;
    private int stock500 = 25;
    private int stock200 = 35;
    private int stock100 = 45;
    private int stock50 = 50;
    private int stock20 = 60;
    private int stock10 = 100;
    private int stock5 = 120;
    private int stock2 = 150;
    private int stock1 = 200;

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void mostrarCambioEuros() {
        int cantidadR = cantidad;

        // Billetes de 1000
        int necesarios = cantidadR / 1000;
        int usar = Math.min(necesarios, stock1000);
        cantidadR -= usar * 1000;
        stock1000 -= usar;
        if (usar > 0) System.out.println("Billetes de 1000 entregados: " + usar + " | Quedan: " + stock1000);

        // Billetes de 500
        necesarios = cantidadR / 500;
        usar = Math.min(necesarios, stock500);
        cantidadR -= usar * 500;
        stock500 -= usar;
        if (usar > 0) System.out.println("Billetes de 500 entregados: " + usar + " | Quedan: " + stock500);

        // Billetes de 200
        necesarios = cantidadR / 200;
        usar = Math.min(necesarios, stock200);
        cantidadR -= usar * 200;
        stock200 -= usar;
        if (usar > 0) System.out.println("Billetes de 200 entregados: " + usar + " | Quedan: " + stock200);

        // Billetes de 100
        necesarios = cantidadR / 100;
        usar = Math.min(necesarios, stock100);
        cantidadR -= usar * 100;
        stock100 -= usar;
        if (usar > 0) System.out.println("Billetes de 100 entregados: " + usar + " | Quedan: " + stock100);

        // Billetes de 50
        necesarios = cantidadR / 50;
        usar = Math.min(necesarios, stock50);
        cantidadR -= usar * 50;
        stock50 -= usar;
        if (usar > 0) System.out.println("Billetes de 50 entregados: " + usar + " | Quedan: " + stock50);

        // Billetes de 20
        necesarios = cantidadR / 20;
        usar = Math.min(necesarios, stock20);
        cantidadR -= usar * 20;
        stock20 -= usar;
        if (usar > 0) System.out.println("Billetes de 20 entregados: " + usar + " | Quedan: " + stock20);

        // Monedas de 10
        necesarios = cantidadR / 10;
        usar = Math.min(necesarios, stock10);
        cantidadR -= usar * 10;
        stock10 -= usar;
        if (usar > 0) System.out.println("Monedas de 10 entregadas: " + usar + " | Quedan: " + stock10);

        // Monedas de 5
        necesarios = cantidadR / 5;
        usar = Math.min(necesarios, stock5);
        cantidadR -= usar * 5;
        stock5 -= usar;
        if (usar > 0) System.out.println("Monedas de 5 entregadas: " + usar + " | Quedan: " + stock5);

        // Monedas de 2
        necesarios = cantidadR / 2;
        usar = Math.min(necesarios, stock2);
        cantidadR -= usar * 2;
        stock2 -= usar;
        if (usar > 0) System.out.println("Monedas de 2 entregadas: " + usar + " | Quedan: " + stock2);

        // Monedas de 1
        necesarios = cantidadR / 1;
        usar = Math.min(necesarios, stock1);
        cantidadR -= usar * 1;
        stock1 -= usar;
        if (usar > 0) System.out.println("Monedas de 1 entregadas: " + usar + " | Quedan: " + stock1);

        // Si no se pudo completar el retiro
        if (cantidadR > 0) {
            System.out.println("⚠ No hay suficientes billetes/monedas para entregar todo el dinero.");
            System.out.println("Faltó entregar: " + cantidadR + " euros");
        }
    }

    public void mostrarCambioPesos() {
        int cantidadPesos = (int) Math.round(cantidad * tipoCambio);
        System.out.println(cantidad + " euros equivalen a " + cantidadPesos + " pesos mexicanos");
        // Aquí podrías repetir la misma lógica de arriba para usar inventario en pesos,
        // pero lo dejé igual que tu versión original
    }
}
