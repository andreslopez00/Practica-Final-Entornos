package proyecto;

import java.util.Random;

/**
 * La clase Digimon representa a un digimon con nombre, nivel, puntos de ataque, salud y DP.
 * Proporciona métodos para realizar ataques y mostrar el estado del digimon.
 * 
 * @author [Andrés López Barrera]
 */
public class Digimon {
    String nombre;
    int nivel;
    int puntosDeAtaque;
    int salud;
    int dp;

    /**
     * Constructor que inicializa un nuevo digimon con el nombre proporcionado.
     * El nivel se genera aleatoriamente entre 1 y 5, y los puntos de ataque y salud
     * se establecen en función del nivel.
     *
     * @param nombre el nombre del digimon
     */
    public Digimon(String nombre) {
        this.nombre = nombre;
        this.nivel = new Random().nextInt(5) + 1;
        this.puntosDeAtaque = 5 * nivel;
        this.salud = 10 * nivel;
        this.dp = 10;
    }

    /**
     * Realiza el primer ataque del digimon, que consume 1 DP y devuelve los puntos de ataque.
     * Si no hay suficiente DP, el ataque no tiene efecto y se devuelve 0.
     *
     * @return los puntos de ataque del digimon si tiene suficiente DP, de lo contrario 0
     */
    public int ataque1() {
        if (dp >= 1) {
            dp -= 1;
            return puntosDeAtaque;
        }
        return 0;
    }

    /**
     * Realiza el segundo ataque del digimon, que consume 2 DP y devuelve el doble de los puntos de ataque.
     * Si no hay suficiente DP, el ataque no tiene efecto y se devuelve 0.
     *
     * @return el doble de los puntos de ataque del digimon si tiene suficiente DP, de lo contrario 0
     */
    public int ataque2() {
        if (dp >= 2) {
            dp -= 2;
            return puntosDeAtaque * 2;
        }
        return 0;
    }

    /**
     * Muestra el estado actual del digimon, incluyendo su nombre, nivel, salud, puntos de ataque y DP.
     */
    public void mostrarEstado() {
        System.out.println(nombre + " (Nivel: " + nivel + ", Salud: " + salud + ", Ataque: " + puntosDeAtaque + ", DP: " + dp + ")");
    }
}
