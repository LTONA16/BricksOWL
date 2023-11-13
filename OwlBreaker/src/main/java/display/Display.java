package display;

import input.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Ventana principal de la aplicación, esta ventana es responsable de mostrar el contenido del juego y manejar los
 * eventos relacionados con la entrada y salida.
 *
 * @author Aguilera Luzania José Luis.
 */
public class Display extends JFrame {

    /**
     * Instancia única de la ventana.
     */
    private static Display instance;

    /**
     * Área rectangular en blanco que representa el contenido que será representado
     */
    private static Canvas canvas;

    /**
     * Ventana principal de la aplicación, esta ventana es responsable de mostrar el contenido del juego y manejar los
     * eventos relacionados con la entrada y salida.
     *
     * @param width  Ancho de la ventana.
     * @param height Alto de la ventana.
     * @param title  Título que se mostrará en la barra de titulo.
     */
    private Display(int width, int height, String title) {
        // Configuración de la ventana.
        //
        // 1. Establecemos el título de la ventana.
        // 2. Establecemos el críterio para detener la aplicación al cerrar la ventana.
        // 3. Evitamos que se pueda cambiar el tamaño de la ventana.
        //
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Creamos y configuramos el canvas.
        //
        // 1. Creamos el canvas (área de dibujo).
        // 2. Establecemos el tamaño del canvas (Igual al de la ventana).
        // 3. Evitamos que el canvas pueda tener el foco.
        // 4. Añadimos el canvas a la ventana.
        //
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);

        // Establecemos el tamaño de la ventana usando a sus componentes como medida.
        this.pack();

        // Evita el parpadeo al momento de dibujar los gráficos.
        canvas.createBufferStrategy(3);

        // Centramos la ventana al iniciar.
        setLocationRelativeTo(null);

        // Mostramos la ventana.
        setVisible(true);

        // Inicializamos la entrada.
        addKeyListener(Input.getInstance());
    }

    /**
     * Obtiene una instancia única de la clase Display, responsable de mostrar el contenido del juego y manejar los
     * eventos relacionados con la entrada dle teclado. Si no existe una instancia previamente, crea una nueva y
     * la devuelve.
     *
     * @return Instancia única de la ventana.
     */
    public static synchronized Display getInstance() {
        return instance;
    }

    /**
     * Inicializa la ventana principal de la aplicación, esta ventana es responsable de mostrar el contenido del juego y
     * manejar los eventos relacionados con la entrada y salida.
     *
     * @param width  Ancho de la ventana.
     * @param height Alto de la ventana.
     * @param title  Título que se mostrará en la barra de titulo.
     */
    public static void initialize(int width, int height, String title) {
        instance = new Display(width, height, title);
    }

    /**
     * @return Área rectangular que representa el contenido que se muestra en la ventana principal.
     */
    public synchronized Graphics getGraphics() {
        return canvas.getBufferStrategy().getDrawGraphics();
    }

    /**
     * Renderiza el contenido del canvas en la ventana principal.
     */
    public synchronized void renderGraphics() {
        BufferStrategy buffer = canvas.getBufferStrategy();
        buffer.getDrawGraphics().dispose();
        buffer.show();
    }
}
