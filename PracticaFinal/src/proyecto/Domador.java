package proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Domador {
	String nombre;
    ArrayList<Digimon> equipo;

    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        String[] digimonsIniciales = {"Agumon", "Gabumon", "Patamon"};
        String digimonInicial = digimonsIniciales[new Random().nextInt(digimonsIniciales.length)];
        Digimon inicial = new Digimon(digimonInicial);
        this.equipo.add(inicial); // Digimon inicial aleatorio
        inicial.mostrarEstado();
    }

    public void captura(Digimon digimon) {
        if (digimon.salud < 20) {
            equipo.add(digimon);
            System.out.println(digimon.nombre + " se ha unido a su equipo");
        } else {
            System.out.println("¡Aún no puedes capturar a " + digimon.nombre + "!");
        }
    }
}