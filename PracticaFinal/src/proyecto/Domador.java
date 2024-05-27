package proyecto;

import java.util.ArrayList;
import java.util.Random;

public class Domador {
    private String nombre;
    private ArrayList<Digimon> equipo;

    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        // Asignar un Digimon aleatorio al inicio
        String[] digimonIniciales = {"Agumon", "Gabumon", "Patamon"};
        int indiceAleatorio = new Random().nextInt(digimonIniciales.length);
        this.equipo.add(new Digimon(digimonIniciales[indiceAleatorio]));
    }

    public ArrayList<Digimon> getEquipo() {
        return equipo;
    }

    public void capturar(Digimon enemigo) {
        if (enemigo.getSalud() < 20 &&!equipo.contains(enemigo)) {
            System.out.println(enemigo.getNombre() + " se ha unido a su equipo");
            equipo.add(enemigo);
        } else {
            System.out.println("No se puede unir");
        }
    }
}
