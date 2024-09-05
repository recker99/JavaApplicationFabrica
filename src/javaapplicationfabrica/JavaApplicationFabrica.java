/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplicationfabrica;

import java.util.Scanner;

/**
 *
 * @author ivanb
 */
public class JavaApplicationFabrica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de la Fábrica ---");
            System.out.println("1. Agregar Material");
            System.out.println("2. Fabricar Producto");
            System.out.println("3. Mostrar Productos Fabricados con Éxito");
            System.out.println("4. Mostrar Productos Fallidos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de material: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Ingrese el número del contenedor (0-4): ");
                    int contenedor = scanner.nextInt();
                    System.out.println(fabrica.agregarMaterial(cantidad, contenedor));
                    break;

                case 2:
                    System.out.print("Ingrese el número del contenedor (0-4): ");
                    contenedor = scanner.nextInt();
                    System.out.println(fabrica.fabricar(contenedor));
                    break;

                case 3:
                    int exitos = fabrica.getOKs();
                    if (exitos == -1) {
                        System.out.println("No se encontraron estados registrados.");
                    } else {
                        System.out.println("Productos fabricados con éxito: " + exitos);
                    }
                    break;

                case 4:
                    int fallidos = fabrica.getFallidos();
                    if (fallidos == -1) {
                        System.out.println("No se encontraron estados registrados.");
                    } else {
                        System.out.println("Productos fallidos: " + fallidos);
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
    
}
