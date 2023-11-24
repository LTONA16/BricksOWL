package scenes;

import display.Display;
import input.Input;
import ui.Text;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Aguilera Luzania José Luis.
 */
public class MenuScene extends BaseScene {

    private Text sceneTitle;        // Texto que muestra el título de la escena.
    private Text sceneInstructions; // Texto que muestra las instrucciones.
    private Text sceneSubTitle; // Texto que muestra las instrucciones.

    /**
     * Maneja la inicialización de los objetos en la escena.
     */
    @Override
    public void load() {
        // Referencia a la pantalla.
        Display display = Display.getInstance();

        // Inicializamos el texto de la escena.
        sceneTitle = new Text(new Font("Kenney Blocks", Font.PLAIN, 120));
        sceneTitle.setText("OWLBREAKER");
        sceneTitle.setColor(Color.yellow);
        sceneTitle.setPosition(display.getWidth() / 2, display.getHeight() / 2);
        
        sceneSubTitle = new Text(new Font("Kenney Pixel", Font.PLAIN, 72));
        sceneSubTitle.setText("¡De los Buhos para los Buhos!");
        sceneSubTitle.setColor(Color.cyan);
        sceneSubTitle.setPosition(display.getWidth() / 2, display.getHeight() / 2 + 15);

        sceneInstructions = new Text(new Font("Kenney Pixel", Font.PLAIN, 72));
        sceneInstructions.setText("¡Presiona ENTER para Jugar!");
        sceneInstructions.setColor(Color.WHITE);
        sceneInstructions.setPosition(display.getWidth() / 2, display.getHeight() / 2 + 200);
    }

    /**
     * Maneja la des inicialización de los objetos en la escena.
     */
    @Override
    public void unload() {

    }

    /**
     * Maneja la lógica de los objetos en la escena.
     */
    @Override
    public void update() {
        if (Input.getInstance().isPressed(KeyEvent.VK_ENTER)) {
            SceneManager.getInstance().loadScene(new GameplayScene());
        }
    }

    /**
     * Maneja la lógica de renderizado de los objetos en la escena.
     *
     * @param g Contenido de la ventana.
     */
    @Override
    public void render(Graphics g) {
        // Referencia de la ventana.
        Display display = Display.getInstance();

        // Limpiamos el contenido de la ventana.
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, display.getWidth(), display.getHeight());

        // Mostramos el título de la escena.
        sceneTitle.render(g);
        sceneInstructions.render(g);
        sceneSubTitle.render(g);
        //sceneTitle.setColor(Color.yellow);
    }
}
