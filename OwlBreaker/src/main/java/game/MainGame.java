package game;

import display.Display;
import input.Input;
import models.Ladrillo;
import models.Paleta;
import models.Pelota;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 * Incluya una descripción de su juego.
 *
 * @author 
 */
public class MainGame extends BaseGame {

    private final int DISPLAY_WIDTH = 1024;
    private final int DISPLAY_HEIGHT = 640;
    private int vidas;
    private Pelota pelota;
    private Paleta paleta = new Paleta(25,150,0,0,0,Color.WHITE);
    private Ladrillo[][] ladrillos;

    /**
     * Incluya una descripción de su juego.
     */
    public MainGame() {
        // Inicializamos la ventana.
        Display.initialize(DISPLAY_WIDTH, DISPLAY_HEIGHT, "OwlBreaker");

        // Inicializamos el estado del juego.
        isRunning = true;

        // Inicializamos el contenido.
        initialize();
    }

    /**
     * Se inicializan los componentes necesarios para el funcionamiento del juego.
     */
    private void initialize() {
        
    }
        

    /**
     * Maneja la lógica del juego y es invocado 60 veces por segundo.
     */
    @Override
    public void update() {

        // Comprobamos si se presiona la tecla escape.
        if (Input.getInstance().isPressed(KeyEvent.VK_ESCAPE)) {

            // Creamos un evento de "Cerrar ventana" para terminar con la aplicación.
            Display.getInstance().dispatchEvent(new WindowEvent(Display.getInstance(), WindowEvent.WINDOW_CLOSING));
        }

        // TODO: Incluya la lógica de su aplicación aquí.
        
        if (Input.getInstance().isPressed(KeyEvent.VK_A)) {
            moveLeft();
        }
        // Mover el rectángulo a la derecha
        if (Input.getInstance().isPressed(KeyEvent.VK_D)) {
            moveRight();
        }
         render();
    }
    
    //Regresa las vidas actuales
    public int getVidas(){
        return vidas;
    }

    //Actualiza las vidas a el valor deseado
    public void setVidas(int nVidas){
        vidas = nVidas;
    }
    
    
    //Metodos
    
    //Colisión con el bloque
    public void colBloque(){
        
    }
    
    //Colisión de la pelota
    public void colPelota(){
        
    }
    
    //Colisión con de la pelota con el Bloque, resta vidas al bloque
    public void colPelotaBloque(){
        
    }
    //Genera ladrillos
    public void generarLadrillos(){
        
    }
    
    // Cambia el color de los componentes
    public void paint(Graphics g){
    }
    
    // Comprueba si existen ladrillos restantes, si no hay ladrillos el jugador gana la partida
    public void ganaste(){
        
    }
    
    public void moveRight (){
        paleta.setX(paleta.getX() + 20); 
    }
    public void moveLeft (){
        paleta.setX(paleta.getX() - 20); 
    }

    /**
     * Maneja el renderizado del juego en la ventana, es invocado al menos una vez por segundo.
     */
    @Override
    public void render() {
        // Obtenemos la referencia a la ventana.
        Display display = Display.getInstance();

        // Obtenemos el objeto Graphics donde dibujaremos el contenido del juego.
        Graphics g = display.getGraphics();
        
        paleta.setX(display.getWidth()/2);
        paleta.setY(600);
        

        // Limpiamos la pantalla.
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, display.getWidth(), display.getHeight());

        // TODO: Dibuje los elementos de su aplicación aquí.
        g.setColor(Color.black);
        g.fillRect(1, 1, display.getWidth(), display.getHeight());
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 3, (display.getHeight() ));
        g.fillRect(0, 0, (display.getWidth() ), 3);
        g.fillRect(1021, 0, 3, display.getHeight());
        //g.fillRect(0, 637, display.getWidth(),3 );
       
        g.setColor(Color.WHITE);
        g.fillRect(paleta.getX(), paleta.getY(), paleta.getAncho(), paleta.getLargo());
        //g.fillRect(500, 500, 100, 50);
        
        
        
        // Actualizamos los gráficos y los mostramos en la ventana.
        display.renderGraphics();

    }
}
