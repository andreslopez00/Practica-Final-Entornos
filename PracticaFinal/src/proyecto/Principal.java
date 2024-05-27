package proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del domador:");
        String nombreDomador = scanner.nextLine();

        Domador domador = new Domador(nombreDomador);
        BatallaDigital batalla = new BatallaDigital(domador);

        System.out.println("1. Iniciar batalla\n2. Salir");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                batalla.eligeDigimon();
                // Aquí continuaría la lógica de la batalla
                break;
            case 2:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }

        scanner.close();
    }
}