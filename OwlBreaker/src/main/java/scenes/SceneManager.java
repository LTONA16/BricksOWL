package scenes;

import java.awt.*;

/**
 * Maneja la lógica para separar los estados del juego (menu, gameplay, game over) en distintas 'escenas'.
 *
 * @author Aguilera Luzania José Luis.
 */
public class SceneManager {

    private static final SceneManager instance = new SceneManager(); // Instancia única de la clase.
    private BaseScene currentScene; // Escena actual.

    /**
     * Maneja la lógica para separar los estados del juego (menu, gameplay, game over) en distintas 'escenas'.
     */
    private SceneManager() {
    }

    /**
     * Obtiene una instancia única de la clase SceneManager para manejar el contenido actual que se muestra en la ventana.
     * Si no existe una instancia previamente, crea una nueva y la devuelve.
     *
     * @return Instancia única de Input.
     */
    public static SceneManager getInstance() {
        return instance;
    }

    /**
     * Carga una nueva escena.
     *
     * @param scene Nueva escena en ser mostrada.
     */
    public void loadScene(BaseScene scene) {
        // Liberamos los recursos de la escena actual.
        if (currentScene != null) {
            currentScene.unload();
        }

        // Guardamos la referencia de la nueva escena.
        currentScene = scene;

        // Cargamos los recursos de la nueva escena.
        currentScene.load();
    }
    
    public BaseScene getScene() {
        // devuelve escena actual.
        return currentScene;
    }

    /**
     * Maneja la lógica de los objetos en la escena.
     */
    public void update() {
        currentScene.update();
    }

    /**
     * Maneja la lógica de renderizado de los objetos en la escena.
     *
     * @param g Contenido de la ventana.
     */
    public void render(Graphics g) {
        currentScene.render(g);
    }

}
