package scenes;

import java.awt.*;

/**
 * Representa una escena del juego (Menu, Gameplay, etc.).
 *
 * @author Aguilera Luzania José Luis.
 */
public abstract class BaseScene {

    /**
     * Maneja la inicialización de los objetos en la escena.
     */
    public abstract void load();

    /**
     * Maneja la des inicialización de los objetos en la escena.
     */
    public abstract void unload();

    /**
     * Maneja la lógica de los objetos en la escena.
     */
    public abstract void update();

    /**
     * Maneja la lógica de renderizado de los objetos en la escena.
     *
     * @param graphics Contenido de la ventana.
     */
    public abstract void render(Graphics graphics);
}
