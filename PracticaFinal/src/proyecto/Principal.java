package proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase Principal contiene el método main que inicia la ejecución del programa.
 * Permite al usuario crear un domador, iniciar batallas y capturar Digimons.
 * 
 * @autor [Andrés López Barrera]
 */
public class Principal {

    /**
     * El método main es el punto de entrada del programa. Permite al usuario crear un domador,
     * iniciar batallas y capturar Digimons hasta que el equipo del domador tenga tres Digimons.
     *
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del domador:");
        String nombreDomador = scanner.nextLine();
        Domador domador = new Domador(nombreDomador);       
        ArrayList<String> digimonsRestantes = new ArrayList<>();
        digimonsRestantes.add("Agumon");
        digimonsRestantes.add("Gabumon");
        digimonsRestantes.add("Patamon");
        digimonsRestantes.removeIf(d -> domador.equipo.stream().anyMatch(e -> e.nombre.equals(d)));

        while (domador.equipo.size() < 3) {
            System.out.println("1. Iniciar batalla\n2. Salir");
            int opcion = scanner.nextInt();
            if (opcion == 2) {
                break;
            }
            BatallaDigital batalla = new BatallaDigital(domador, digimonsRestantes);
            batalla.elige();
            digimonsRestantes.removeIf(d -> domador.equipo.stream().anyMatch(e -> e.nombre.equals(d)));
        }
        System.out.println("¡Felicidades " + nombreDomador + "! Has capturado a todos los Digimon icónicos.");
    }
}
