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
    private int vidaJugador = 3;
    private Pelota pelota= new Pelota(5,5,150,150,15,0,5,Color.WHITE);
    private Paleta paleta = new Paleta(25,150,0,0,0,Color.WHITE);
    private Ladrillo ladrillo;
    private int[][] ladrillos;
            
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
         // Obtenemos la referencia a la ventana.
        Display display = Display.getInstance();
        paleta.setX(display.getWidth()/2);
        paleta.setY(600);
        pelota.setX(615);
        pelota.setY(615);
        pelota.setVelY(-5);
       
        // Inicializa la matriz de ladrillos
        
    }
        

    // En el método update, donde manejas la lógica del juego
    @Override
    public void update() {
        // Comprobamos si se presiona la tecla escape.
        if (Input.getInstance().isPressed(KeyEvent.VK_ESCAPE)) {
            // Creamos un evento de "Cerrar ventana" para terminar con la aplicación.
            Display.getInstance().dispatchEvent(new WindowEvent(Display.getInstance(), WindowEvent.WINDOW_CLOSING));
        }

        // Mover la paleta a la izquierda si se presiona la tecla A
        if (Input.getInstance().isPressed(KeyEvent.VK_A)) {
            if(paleta.getX() < 4){
                paleta.setX(4);
            }else{
                movePaletaLeft();
            }
        }

        // Mover la paleta a la derecha si se presiona la tecla D
        if (Input.getInstance().isPressed(KeyEvent.VK_D)) {
            if(paleta.getX() >= 871){
                paleta.setX(871);
            }else{
                movePaletaRight();
            }
        }
        
        pelota.setX(pelota.getX()+pelota.getVelX());
        pelota.setY(pelota.getY()+pelota.getVelY());
        
            if ( pelota.getX() < 0) {
                pelota.setVelX(-pelota.getVelX());
            }
            
            if ( pelota.getY() < 0) {
                pelota.setVelY(-pelota.getVelY());
            }
            
            if ( pelota.getX() > 635) {
                pelota.setVelX(-pelota.getVelX());
            }
            
            
        render();
    }

    
    //Regresa las vidas actuales
    public int getVidaJugador(){
        return vidaJugador;
    }

    //Actualiza las vidas a el valor deseado
    public void setVidaJugador(int nVidas){
        vidaJugador = nVidas;
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
    public void generarLadrillos(int fila, int columna){
        int gap = 2;
        ladrillo.setLargo(20);
        ladrillo.setAncho(DISPLAY_WIDTH/(columna - gap));
        
        for(int i=0; i<ladrillos.length;i++){
            for(int j=0; i<ladrillos.length;j++){
                ladrillos[i][j] = 1;
            }
        }
    }
    
    // 
    public void pintarLadrillos(int fila, int columna){
        
    }
    
    // Comprueba si existen ladrillos restantes, si no hay ladrillos el jugador gana la partida
    public void ganaste(){
        
    }
    
    private void movePaletaLeft() {
        paleta.setX(paleta.getX() - 5); // Puedes ajustar la cantidad de movimiento según tus necesidades
    }
    
    private void movePaletaRight() {
        paleta.setX(paleta.getX() + 5); // Puedes ajustar la cantidad de movimiento según tus necesidades
    }

    public void keyTyped(KeyEvent e) {
        // No es necesario implementar este método, pero la interfaz lo exige
    }

    public void keyReleased(KeyEvent e) {
        // No es necesario implementar este método, pero la interfaz lo exige
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
        g.setColor(Color.WHITE);
        g.fillOval(pelota.getX() - pelota.getRadio(), pelota.getY() - pelota.getRadio(),pelota.getRadio()* 2, pelota.getRadio()* 2);

        
        // Actualizamos los gráficos y los mostramos en la ventana.
        display.renderGraphics();

    }
}
