/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplicationfabrica;

import java.util.ArrayList;

public class Fabrica {
    private int[] metales;
    private ArrayList<String> estados;
    private static final int METAL_NECESARIO = 10; // Cantidad de metal necesaria para fabricar un producto

    public Fabrica() {
        metales = new int[5];
        estados = new ArrayList<>();
    }

    // Método para agregar material a un contenedor
    public String agregarMaterial(int cantidad, int contenedor) {
        if (cantidad <= 0) {
            return "Error: La cantidad de material debe ser mayor a 0.";
        }
        if (contenedor < 0 || contenedor >= metales.length) {
            return "Error: El número de contenedor no es válido.";
        }

        metales[contenedor] += cantidad;
        return "Material agregado correctamente al contenedor " + contenedor + ". Cantidad actual: " + metales[contenedor];
    }

    // Método para fabricar un producto en un contenedor específico
    public String fabricar(int contenedor) {
        if (contenedor < 0 || contenedor >= metales.length) {
            return "Error: El número de contenedor no es válido.";
        }

        StringBuilder salida = new StringBuilder();
        salida.append("Reporte de fabricación en contenedor ").append(contenedor).append(": ");

        if (metales[contenedor] >= METAL_NECESARIO) {
            metales[contenedor] -= METAL_NECESARIO;
            salida.append("Éxito. Producto fabricado. Metal restante en el contenedor: ").append(metales[contenedor]);
            estados.add("OK");
        } else {
            salida.append("Fallo. No hay suficiente metal. Metal disponible: ").append(metales[contenedor]);
            estados.add("FALLIDO");
        }

        return salida.toString();
    }

    // Método para obtener la cantidad de productos fabricados exitosamente
    public int getOKs() {
        if (estados.isEmpty()) {
            return -1;
        }
        int count = 0;
        for (String estado : estados) {
            if ("OK".equals(estado)) {
                count++;
            }
        }
        return count;
    }

    // Método para obtener la cantidad de productos que fallaron en fabricarse
    public int getFallidos() {
        if (estados.isEmpty()) {
            return -1;
        }
        int count = 0;
        for (String estado : estados) {
            if ("FALLIDO".equals(estado)) {
                count++;
            }
        }
        return count;
    }
}
