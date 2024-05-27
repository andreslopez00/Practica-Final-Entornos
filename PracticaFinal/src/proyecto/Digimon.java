package proyecto;

import java.util.Random;

public class Digimon {
    private String nombre;
    private int nivel;
    private int puntosAtaque;
    private int salud;
    private int intentosAtaque;

    public Digimon(String nombre) {
        this.nombre = nombre;
        Random random = new Random();
        this.nivel = random.nextInt(5) + 1; // Nivel aleatorio entre 1 y 5
        this.puntosAtaque = this.nivel * 5;
        this.salud = this.nivel * 10;
        this.intentosAtaque = 10;
    }

    public void ataque1(Digimon enemigo) {
        if (this.intentosAtaque > 0) {
            enemigo.recibirDanio(this.puntosAtaque);
            this.intentosAtaque--;
        }
    }

    public void ataque2(Digimon enemigo) {
        if (this.intentosAtaque > 1) { // Resta 2 intentos
            enemigo.recibirDanio(this.puntosAtaque * 2);
            this.intentosAtaque -= 2;
        }
    }

    private void recibirDanio(int danio) {
        this.salud -= danio;
        if (this.salud < 0) {
            this.salud = 0;
        }
    }

    public boolean estaDerrotado() {
        return this.salud <= 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }
}
