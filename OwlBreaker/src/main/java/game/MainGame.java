package game;

import display.Display;
import input.Input;
import scenes.GameplayScene;
import scenes.MenuScene;
import scenes.SceneManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 * Incluya una descripción de su juego.
 *
 * @author Aguilera Luzania José Luis.
 */
public class MainGame extends BaseGame {

    private final int DISPLAY_WIDTH = 1024; // Ancho de la ventana.
    private final int DISPLAY_HEIGHT = 640; // Alto de la ventana.

    // Referencia del SceneManager.
    private final SceneManager sceneManager = SceneManager.getInstance();

    // Referencia del Input.
    private final Input input = Input.getInstance();

    /**
     * Incluya una descripción de su juego.
     */
    public MainGame() {
        // Inicializamos la ventana.
        Display.initialize(DISPLAY_WIDTH, DISPLAY_HEIGHT, "OwlBreaker");

        // Inicializamos el estado del juego.
        isRunning = true;

        // Inicializamos el contenido.
        sceneManager.loadScene(new MenuScene());
    }

    /**
     * Maneja la lógica del juego y es invocado 60 veces por segundo.
     */
    @Override
    public void update() {

        // Comprobamos si se presiona la tecla escape.
        if (input.isPressed(KeyEvent.VK_ESCAPE)) {

            // Creamos un evento de "Cerrar ventana" para terminar con la aplicación.
            Display.getInstance().dispatchEvent(new WindowEvent(Display.getInstance(), WindowEvent.WINDOW_CLOSING));
        }

        // TODO: Incluya la lógica de su aplicación aquí.
        sceneManager.update();
    }

    /**
     * Maneja el renderizado del juego en la ventana, es invocado al menos una vez por segundo.
     */
    @Override
    public void render() {

        // Obtenemos la referencia a la ventana.
        Display display = Display.getInstance();

        // Obtenemos el objeto Graphics donde dibujaremos el contenido del juego.
        Graphics graphics = display.getGraphics();

        // TODO: Dibuje los elementos de su aplicación aquí.
        sceneManager.render(graphics);

        // Actualizamos los gráficos y los mostramos en la ventana.
        display.renderGraphics();

    }
}
