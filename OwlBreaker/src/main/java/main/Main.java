package main;

import game.BaseGame;
import game.MainGame;

/**
 * Incluya una descripción de su juego.
 *
 * @author 
 */
public class Main {

    /**
     * Método principal de la aplicación, la ejecución de la aplicación inicia y termina aquí.
     *
     * @param args Argumentos de la consola.
     */
    public static void main(String[] args) {

        // Creamos un objeto de tipo `MainGame`.
        BaseGame OwlBreaker = new MainGame();

        // Ejecutamos el juego.
        OwlBreaker.run();
    }

}
