package proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La clase Domador representa a un domador de Digimons que puede capturar y manejar un equipo de Digimons.
 * Proporciona métodos para capturar Digimons y gestionar el equipo.
 * 
 * @autor [Andrés López Barrera]
 */
public class Domador {
    String nombre;
    ArrayList<Digimon> equipo;

    /**
     * Constructor que inicializa un nuevo domador con el nombre proporcionado.
     * Al crear un domador, se le asigna un Digimon inicial aleatorio.
     *
     * @param nombre el nombre del domador
     */
    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        String[] digimonsIniciales = {"Agumon", "Gabumon", "Patamon"};
        String digimonInicial = digimonsIniciales[new Random().nextInt(digimonsIniciales.length)];
        Digimon inicial = new Digimon(digimonInicial);
        this.equipo.add(inicial); // Digimon inicial aleatorio
        System.out.println("Tu digimon inicial es:");
        inicial.mostrarEstado();
    }

    /**
     * Captura un digimon y lo añade al equipo del domador si su salud es menor a 20.
     * Si la salud del digimon es mayor o igual a 20, la captura no es exitosa.
     *
     * @param digimon el digimon que se desea capturar
     */
    public void captura(Digimon digimon) {
        if (digimon.salud < 20) {
            equipo.add(digimon);
            System.out.println(digimon.nombre + " se ha unido a su equipo");
        } else {
            System.out.println("¡Aún no puedes capturar a " + digimon.nombre + "!");
        }
    }
}
