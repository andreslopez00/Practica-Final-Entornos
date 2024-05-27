package proyecto;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BatallaDigital {
	Digimon enemigo;
    Domador domador;

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
            System.out.println("El enemigo " + enemigo.nombre + " tiene " + enemigo.salud + " puntos de salud restantes.");
            enemigo.mostrarEstado();

            // Ataque del enemigo al Digimon del domador
            elegido.salud -= enemigo.ataque1();
            if (elegido.salud <= 0) {
                System.out.println("Tu " + elegido.nombre + " recibió daño y ha sido derrotado.");
                System.out.println("Gracias por jugar.");
                System.exit(0); // Termina el programa
            }
            System.out.println("Tu " + elegido.nombre + " tiene " + elegido.salud + " puntos de salud restantes.");
            elegido.mostrarEstado();
        }

        if (enemigo.salud <= 0) {
            System.out.println("¡Has derrotado a " + enemigo.nombre + "!");
            domador.captura(enemigo);
        }
    }
}