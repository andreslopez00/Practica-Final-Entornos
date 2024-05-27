package proyecto;

import java.util.Random;

public class Digimon {
	 String nombre;
	    int nivel;
	    int puntosDeAtaque;
	    int salud;
	    int dp;

	    public Digimon(String nombre) {
	        this.nombre = nombre;
	        this.nivel = new Random().nextInt(5) + 1;
	        this.puntosDeAtaque = 5 * nivel;
	        this.salud = 10 * nivel;
	        this.dp = 10;
	    }

	    public int ataque1() {
	        if (dp >= 1) {
	            dp -= 1;
	            return puntosDeAtaque;
	        }
	        return 0;
	    }

	    public int ataque2() {
	        if (dp >= 2) {
	            dp -= 2;
	            return puntosDeAtaque * 2;
	        }
	        return 0;
	    }

	    public void mostrarEstado() {
	        System.out.println(nombre + " (Nivel: " + nivel + ", Salud: " + salud + ", Ataque: " + puntosDeAtaque + ", DP: " + dp + ")");
	    }
	}