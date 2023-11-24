package scenes;

import display.Display;
import input.Input;
import ui.Text;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Aguilera Luzania José Luis.
 */
public class EndScene extends BaseScene{

    private final Color SCENE_COLOR = Color.BLACK;

    private Text go;        // Texto que muestra el título de la escena.
    private Text intentaloDN; // Texto que muestra las instrucciones.
    private Text restart; // Texto que muestra las instrucciones.
    private Boolean ganador;
    
    public EndScene(Boolean ganador){
        this.ganador = ganador;
    }
    
    /**
     * Maneja la inicialización de los objetos en la escena.
     */
    @Override
    public void load() {
        // Referencia a la pantalla.
        Display display = Display.getInstance();

        // Inicializamos el texto de la escena.
        go = new Text(new Font("Kenney Blocks", Font.PLAIN, 120));
        go.setText("GAME OVER!");
        go.setColor(Color.RED);
        go.setPosition(display.getWidth() / 2, display.getHeight() / 2 + 15);
        
        intentaloDN = new Text(new Font("Kenney Pixel", Font.PLAIN, 72));
        intentaloDN.setText("¡GRACIAS POR JUGAR!");
        intentaloDN.setColor(Color.GREEN);
        intentaloDN.setPosition(display.getWidth() / 2, display.getHeight() / 2 + 35);
        
        
        restart = new Text(new Font("Kenney Pixel", Font.PLAIN, 72));
        restart.setText("Presiona ENTER para jugar de nuevo");
        restart.setColor(Color.cyan);
        restart.setPosition(display.getWidth() / 2, display.getHeight() / 2 + 250);
        
        if(!ganador){
            go.setText("GAME OVER!");
            go.setPosition(display.getWidth() / 2, display.getHeight() / 2 + 15);
        } else{
            go.setText("¡HAS GANADO!");
            go.setPosition(display.getWidth() / 2, display.getHeight() / 2 + 15);
        }
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
        
        if (Input.getInstance().isPressed(KeyEvent.VK_ESCAPE)) {
            SceneManager.getInstance().loadScene(new MenuScene());
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
        g.setColor(SCENE_COLOR);
        g.fillRect(0, 0, display.getWidth(), display.getHeight());

        // Mostramos el título de la escena.
        if(!ganador){
            //go.setText("GAME OVER!");
            go.setColor(Color.RED);
            go.render(g);
            intentaloDN.setColor(Color.white);
            intentaloDN.render(g);
            restart.setColor(Color.YELLOW);
            restart.render(g);
        } else{
            //go.setText("¡HAS GANADO!");
            go.setColor(Color.GREEN);
            go.render(g);
            intentaloDN.setColor(Color.white);
            intentaloDN.render(g);
            restart.setColor(Color.YELLOW);
            restart.render(g);
        }
    }
}
