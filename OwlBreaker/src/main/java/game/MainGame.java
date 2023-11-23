package game;

import display.Display;
import input.Input;
import models.Ladrillo;
import models.Paleta;
import models.Pelota;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 * Incluya una descripción de su juego.
 *
 * @author 
 */
public class MainGame extends BaseGame {

    private final int DISPLAY_WIDTH = 1024;
    private final int DISPLAY_HEIGHT = 640;
    private int vidaJugador = 3;
    private Pelota pelota= new Pelota(5,5,150,150,15,2,5,Color.WHITE);
    private Paleta paleta = new Paleta(25,150,0,0,0,Color.WHITE);
    private Ladrillo[][] ladrillos;
    private int columna, fila=0;
            
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
        pelota.setVelY(2);
       
        // Inicializa la matriz de ladrillos
        inicializarLadrillos(6,6);
        
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


         pelota.mover();
         
        verificarColision(1024, 640, paleta);
        
        pelota.setX(pelota.getX()+pelota.getVelX());
        pelota.setY(pelota.getY()+pelota.getVelY());
        colPelota();
//        colPelotaBloque();
        verificarColisionLadrillos();
    
        // Verificar si el jugador ha ganado
        ganaste();


        render();
    }
    
private void verificarColisionLadrillos() {
        // Verificar colisiones con los ladrillos
        for (int i = 0; i < ladrillos.length; i++) {
            for (int j = 0; j < ladrillos[i].length; j++) {
                if (intersecta(ladrillos[i][j])) {
                    // Colisión con un ladrillo
                    ladrillos[i][j] = null;  // Eliminar el ladrillo

                    // Aquí puedes realizar más acciones si es necesario
                    invertirDireccion(); // Invierte la dirección de la pelota
                }
            }
        }
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
    
  
    
    //Colisión de la pelota
    public void colPelota(){
        if (pelota.getX() - pelota.getRadio() <= 0 || pelota.getX() + pelota.getRadio() >= DISPLAY_WIDTH) {
            pelota.setVelX(-pelota.getVelX()); // Invertir la dirección en el eje X
        }

        if (pelota.getY() - pelota.getRadio() <= 0 || pelota.getY() + pelota.getRadio() >= DISPLAY_HEIGHT) {
            pelota.setVelY(-pelota.getVelY()); // Invertir la dirección en el eje Y
        }
        
    }
 

    
    public void pintarLadrillos(int fila, int columna){
        
    }
    
    private void inicializarLadrillos(int columna, int fila) {
        // Inicializa el arreglo de ladrillos
        this.columna = columna;
        this.fila = fila;
        int gap = 2;
        ladrillos = new Ladrillo[columna][fila];
        for (int i = 0; i < ladrillos.length; i++) {
            for (int j = 0; j < ladrillos[i].length; j++) {
                ladrillos[i][j] = new Ladrillo(0, 0, 3, 3, Color.GREEN); // Puedes ajustar las dimensiones y color
                ladrillos[i][j].setLargo(40);
                ladrillos[i][j].setAncho(1020/columna - gap);
                ladrillos[i][j].setX(3 + j * ladrillos[i][j].getAncho() + gap);
                ladrillos[i][j].setY(i * ladrillos[i][j].getLargo() + gap);
                System.out.println(ladrillos[i][j].getX());
                   //ladrillos[i][j].getLargo(), ladrillos[i][j].getAncho()
            }
        }
    }
    
    private void invertirDireccion() {
        pelota.setVelX(-pelota.getVelX());
        pelota.setVelY(-pelota.getVelY());
    }
 
    private boolean intersecta(Ladrillo ladrillo) {
        if (ladrillo == null) {
            return false;
        }

        int distanciaX = Math.abs(pelota.getX() - ladrillo.getX() - ladrillo.getAncho() / 2);
        int distanciaY = Math.abs(pelota.getY() - ladrillo.getY() - ladrillo.getLargo() / 2);
        if (distanciaX > (ladrillo.getAncho() / 2 + pelota.getRadio())) {
            return false;
        }
        if (distanciaY > (ladrillo.getLargo() / 2 + pelota.getRadio())) {
            return false;
        }

        if (distanciaX <= (ladrillo.getAncho() / 2)) {
            return true;
        }
        if (distanciaY <= (ladrillo.getLargo() / 2)) {
            return true;
        }

        double distanciaEsquina = Math.pow((distanciaX - ladrillo.getAncho() / 2), 2)
                + Math.pow((distanciaY - ladrillo.getLargo() / 2), 2);

        return (distanciaEsquina <= Math.pow(pelota.getRadio(), 2));
    }

    // Comprueba si existen ladrillos restantes, si no hay ladrillos el jugador gana la partida
    public void ganaste() {
        boolean todosLadrillosDestruidos = true;

        // Verifica si todos los ladrillos han sido destruidos
        for (int i = 0; i < ladrillos.length; i++) {
            for (int j = 0; j < ladrillos[i].length; j++) {
                if (ladrillos[i][j] != null) {
                    todosLadrillosDestruidos = false;
                    break;

                  
            }
        }
            
            // Si todos los ladrillos han sido destruidos, muestra el mensaje de ganador y cierra el juego
            if (todosLadrillosDestruidos) {
                JOptionPane.showMessageDialog(null, "¡Ganaste!");
                System.exit(0); // Cierra la aplicación
            }
    
        
    }

    // Si todos los ladrillos han sido destruidos, muestra el mensaje de ganador
    if (todosLadrillosDestruidos) {
        JOptionPane.showMessageDialog(null, "¡Ganaste!");
        // Aquí puedes realizar otras acciones o reiniciar el juego si lo deseas
    }
        
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
    
   public void verificarColision(int anchoPantalla, int altoPantalla, Paleta paleta) {
    // Colision con las paredes
    if (pelota.getX() - pelota.getRadio() <= 0 || pelota.getX() + pelota.getRadio() >= anchoPantalla) {
        pelota.setVelX(-pelota.getVelX()); // Invertir la dirección en el eje X
    }

    // Colision con la paleta
    if (pelota.getY() + pelota.getRadio() >= paleta.getY() &&
        pelota.getY() + pelota.getRadio() <= paleta.getY() + paleta.getLargo() &&
        pelota.getX() >= paleta.getX() && pelota.getX() <= paleta.getX() + paleta.getAncho()) {
        pelota.setVelY(-pelota.getVelY()); // Invertir la dirección en el eje Y
    }

    
    
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
       
        g.setColor(Color.WHITE);
        g.fillRect(paleta.getX(), paleta.getY(), paleta.getAncho(), paleta.getLargo());
        g.setColor(Color.WHITE);
        g.fillOval(pelota.getX() - pelota.getRadio(), pelota.getY() - pelota.getRadio(),pelota.getRadio()* 2, pelota.getRadio()* 2);

        // Dibuja los ladrillos
        for (int i = 0; i < ladrillos.length; i++) {
            for (int j = 0; j < ladrillos[i].length; j++) {
                int gap = 2;
                if (ladrillos[i][j] != null) {
                    g.setColor(ladrillos[i][j].getColor()); // Establece el color del ladrillo
                    g.fillRect(3 + j * ladrillos[i][j].getAncho() + gap * j, i * ladrillos[i][j].getLargo() + gap * i, ladrillos[i][j].getAncho(), ladrillos[i][j].getLargo());
                }
    }
        }
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 3, (display.getHeight() ));
        g.fillRect(0, 0, (display.getWidth() ), 3);
        g.fillRect(1021, 0, 3, display.getHeight());
        //g.fillRect(0, 637, display.getWidth(),3 );
        
        // Actualizamos los gráficos y los mostramos en la ventana.
        display.renderGraphics();

    }
}
