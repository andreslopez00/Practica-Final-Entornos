package proyecto;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * La clase BatallaDigital representa una batalla entre el equipo de Digimons de un domador y un digimon enemigo.
 * Proporciona métodos para elegir el digimon del equipo que luchará y para gestionar la pelea.
 * 
 * @autor [Andrés López Barrera]
 */
public class BatallaDigital {
    Digimon enemigo;
    Domador domador;

    /**
     * Constructor que inicializa una nueva batalla con el domador proporcionado y una lista de nombres de digimons restantes.
     * Elige un digimon enemigo aleatorio que no esté en el equipo del domador.
     *
     * @param domador el domador que participará en la batalla
     * @param digimonsRestantes la lista de nombres de digimons que pueden aparecer como enemigos
     */
    public BatallaDigital(Domador domador, ArrayList<String> digimonsRestantes) {
        this.domador = domador;
        for (String digimon : digimonsRestantes) {
            if (!domador.equipo.stream().anyMatch(d -> d.nombre.equals(digimon))) {
                enemigo = new Digimon(digimon);
                break;
            }
        }
        System.out.println("¡Un digimon enemigo salvaje apareció!");
        enemigo.mostrarEstado();
    }

    /**
     * Permite al domador elegir un digimon de su equipo para luchar contra el enemigo.
     */
    public void elige() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige el Digimon de tu equipo para luchar:");
        for (int i = 0; i < domador.equipo.size(); i++) {
            System.out.println((i + 1) + ". " + domador.equipo.get(i).nombre);
        }
        int eleccion = scanner.nextInt();
        Digimon elegido = domador.equipo.get(eleccion - 1);
        elegido.mostrarEstado();
        pelea(elegido);
    }

    /**
     * Gestiona la pelea entre el digimon elegido por el domador y el digimon enemigo.
     * 
     * @param elegido el digimon del domador que luchará contra el enemigo
     */
    public void pelea(Digimon elegido) {
        Scanner scanner = new Scanner(System.in);
        while (enemigo.salud > 0 && elegido.salud > 0) {
            System.out.println("1. Ataque1\n2. Ataque2\n3. Capturar");
            int opcion = scanner.nextInt();
            int dano = 0;
            switch (opcion) {
                case 1:
                    dano = elegido.ataque1();
                    break;
                case 2:
                    dano = elegido.ataque2();
                    break;
                case 3:
                    domador.captura(enemigo);
                    if (enemigo.salud < 20) return;
                    continue;
                default:
                    System.out.println("Opción no válida");
                    continue;
            }
            enemigo.salud -= dano;
            System.out.println("El enemigo " + enemigo.nombre + " recibió daño y tiene " + enemigo.salud + " puntos de salud restantes.");
            enemigo.mostrarEstado();

            // Ataque del enemigo al Digimon del domador
            elegido.salud -= enemigo.ataque1();
            if (elegido.salud <= 0) {
                System.out.println("Tu " + elegido.nombre + " recibió daño y ha sido derrotado.");
                System.out.println("Gracias por jugar.");
                System.exit(0); // Termina el programa
            }
            System.out.println("Tu " + elegido.nombre + " recibió daño y tiene " + elegido.salud + " puntos de salud restantes.");
            elegido.mostrarEstado();
        }

        if (enemigo.salud <= 0) {
            System.out.println("¡Has derrotado a " + enemigo.nombre + "!");
            domador.captura(enemigo);
        }
    }
}
