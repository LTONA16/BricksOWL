package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Se encarga de manejar el estado de las teclas del teclado. Solo existe una única instancia de la clase que
 * puede ser accedida desde cualquier parte de la aplicación.
 *
 * @author Aguilera Luzania José Luis.
 */
public final class Input implements KeyListener {

    /**
     * Instancia única de la clase.
     */
    private static Input instance = null;

    /**
     * Arreglo que contiene el estado de las teclas del teclado.
     */
    private final boolean[] pressed;

    /**
     * Constructor privado para evitar la creación de instancias por clases externas.
     */
    private Input() {
        // Inicializamos el arreglo de las teclas.
        pressed = new boolean[255];
    }

    /**
     * Obtiene una instancia única de la clase Input para manejar el estado de las teclas del teclado. Si no existe una
     * instancia previamente, crea una nueva y la devuelve.
     *
     * @return Instancia única de Input.
     */
    public static synchronized Input getInstance() {

        // Comprobamos si existe una instancia.
        if (instance == null) {
            instance = new Input();
        }

        // Regresamos la instancia.
        return instance;
    }

    /**
     * ¿Está la tecla 'keyCode' siendo presionada en este momento?
     *
     * @param keyCode Código que representa la tecla.
     * @return Estado de la tecla.
     */
    public boolean isPressed(int keyCode) {
        return pressed[keyCode];
    }

    /**
     * @param e El evento a ser procesado.
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Cambia el estado de la tecla especificada en el evento 'e' a verdadero (presionada).
     *
     * @param e El evento a ser procesado.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;
    }

    /**
     * Cambia el estado de la tecla especificada en el evento 'e' a falso (no presionada).
     *
     * @param e El evento a ser procesado.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        pressed[e.getKeyCode()] = false;
    }
}
