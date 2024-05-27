package proyecto;

import java.util.Random;
import java.util.Scanner;

public class BatallaDigital {
    private Domador domador;
    private Digimon enemigo;

    public BatallaDigital(Domador domador) {
        this.domador = domador;
        // Generar un Digimon enemigo aleatorio
        String[] digimonEnemigos = {"Agumon", "Gabumon", "Patamon"};
        int indiceAleatorio = new Random().nextInt(digimonEnemigos.length);
        this.enemigo = new Digimon(digimonEnemigos[indiceAleatorio]);
    }

    public void eligeDigimon() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un Digimon de tu equipo:");
        for (int i = 0; i < domador.getEquipo().size(); i++) {
            System.out.println((i + 1) + ". " + domador.getEquipo().get(i).getNombre());
        }
        int eleccion = scanner.nextInt();
        Digimon digimonElegido = domador.getEquipo().get(eleccion - 1);
        pelea(digimonElegido);
    }

    private void pelea(Digimon digimonElegido) {
        Scanner scanner = new Scanner(System.in);
        while (!digimonElegido.estaDerrotado() &&!enemigo.estaDerrotado()) {
            System.out.println("1. Atacar\n2. Intentar Capturar\n3. Salir");
            int accion = scanner.nextInt();
            switch (accion) {
                case 1:
                    System.out.println("Elige tipo de ataque:\n1. Ataque1\n2. Ataque2");
                    int ataque = scanner.nextInt();
                    if (ataque == 1) {
                        digimonElegido.ataque1(enemigo);
                    } else if (ataque == 2) {
                        digimonElegido.ataque2(enemigo);
                    }
                    System.out.println("Has realizado un ataque!");
                    break;
                case 2:
                    if (enemigo.getSalud() < 20) {
                        domador.capturar(enemigo);
                        return; // Termina la batalla después de capturar
                    } else {
                        System.out.println("No se puede unir");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo de la batalla...");
                    return;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            // Turno del enemigo
            if (!enemigo.estaDerrotado()) {
                int ataqueEnemigo = new Random().nextInt(2); // El enemigo elige un ataque al azar
                if (ataqueEnemigo == 0) {
                    enemigo.ataque1(digimonElegido);
                } else {
                    enemigo.ataque2(digimonElegido);
                }
                System.out.println("El Digimon enemigo ha realizado un ataque!");
            }
        }
        if (digimonElegido.estaDerrotado()) {
            System.out.println("Tu Digimon ha sido derrotado.");
        } else {
            System.out.println("Has derrotado al Digimon enemigo!");
        }
    }
}
