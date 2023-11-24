package scenes;

import display.Display;
import input.Input;
import ui.Text;
import models.Ladrillo;
import models.Paleta;
import models.Pelota;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * @author Aguilera Luzania José Luis.
 */
public class GameplayScene extends BaseScene {

    private final Color SCENE_COLOR = Color.BLACK;

    private Text sceneTitle;        // Texto que muestra el título de la escena.
    private final int DISPLAY_WIDTH = 1024;
    private final int DISPLAY_HEIGHT = 640;
    private Pelota pelota = new Pelota(5,5,150,150,15,0,0,Color.WHITE);
    private Paleta paleta = new Paleta(25,150,0,0,0,Color.WHITE);
    private Ladrillo[][] ladrillos;
    private int columna, fila=0;
    private boolean play = false;
    Random random = new Random();
    int min = -1;
    int max = 1;

    /**
     * Maneja la inicialización de los objetos en la escena.
     */
    @Override
    public void load() {
        // Referencia a la pantalla.
        Display display = Display.getInstance();

        // Inicializamos el texto de la escena.
        sceneTitle = new Text(new Font("Kenney Pixel Square", Font.PLAIN, 36));
        sceneTitle.setText("¡PRESIONA SPACE PARA EMPEZAR LA PARTIDA!");
        sceneTitle.setColor(Color.WHITE);
        sceneTitle.setPosition(display.getWidth() / 2, display.getHeight() / 2);
        
        paleta.setX(display.getWidth()/2);
        paleta.setY(600);
        pelota.setX(450);
        pelota.setY(550);
       
        // Inicializa la matriz de ladrillos
        inicializarLadrillos(6,6);
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
        if (Input.getInstance().isPressed(KeyEvent.VK_LEFT)) {
            SceneManager.getInstance().loadScene(new MenuScene());
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
        
        if(!play){
            if (Input.getInstance().isPressed(KeyEvent.VK_SPACE)) {
                sceneTitle.setText("");
                play = true;
                iniciarPelota();
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
        
    }
    
    private int numAzar(){
        int rango = max - min + 1;
        int randomNumber = random.nextInt(rango) + min;
        return randomNumber;
    }
    
    private void verificarColisionLadrillos() {
        // Verificar colisiones con los ladrillos
        for (int i = 0; i < ladrillos.length; i++) {
            for (int j = 0; j < ladrillos[i].length; j++) {
                if (intersecta(ladrillos[i][j])) {
                    // Colisión con un ladrillo
                    ladrillos[i][j] = null;  // Eliminar el ladrillo
                    pelota.setVelY(pelota.getVelY() + numAzar());
                    pelota.setVelX(pelota.getVelX() + numAzar());
                    if(pelota.getVelX() == 0){
                        pelota.setVelX(1);
                    }
                    if(pelota.getVelX() > 2){
                    pelota.setVelX(2);
                    }
                    if(pelota.getVelY() == 0){
                        pelota.setVelY(1);
                    }
                    if(pelota.getVelY() > 2){
                    pelota.setVelY(2);
                    }
                    
                    // Aquí puedes realizar más acciones si es necesario
                    invertirDireccion(); // Invierte la dirección de la pelota
                }
            }
        }
    }
    
    //Metodos
   
    //Colisión de la pelota
    public void colPelota(){
        if (pelota.getX() - pelota.getRadio() <= 0 || pelota.getX() + pelota.getRadio() >= DISPLAY_WIDTH) {
            pelota.setVelX(-pelota.getVelX()); // Invertir la dirección en el eje X
        }

        if (pelota.getY() - pelota.getRadio() <= 0) {
            pelota.setVelY(-pelota.getVelY()); // Invertir la dirección en el eje Y
        }
        //pelota.getY() + pelota.getRadio() >= DISPLAY_HEIGHT
    }
    
    public void iniciarPelota(){
        pelota.setVelY(-1);
        pelota.setVelX(1);
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
                //System.out.println(ladrillos[i][j].getX());
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
        }

        // Si todos los ladrillos han sido destruidos, muestra el mensaje de ganador
        if (todosLadrillosDestruidos) {
            //JOptionPane.showMessageDialog(null, "¡Ganaste!");
            SceneManager.getInstance().loadScene(new EndScene(true));
        }

        if(pelota.getY() - pelota.getRadio() >= DISPLAY_HEIGHT){
            //JOptionPane.showMessageDialog(null, "¡Has perdido!, intentalo de nuevo.");
            SceneManager.getInstance().loadScene(new EndScene(false));
        }
        
    }

    private void movePaletaLeft() {
        if(play){
            paleta.setX(paleta.getX() - 9); // Puedes ajustar la cantidad de movimiento según tus necesidades
        }
    }
    
    private void movePaletaRight() {
        if(play){
            paleta.setX(paleta.getX() + 9); // Puedes ajustar la cantidad de movimiento según tus necesidades
        }
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
        
        g.setColor(Color.CYAN);
        g.fillRect(paleta.getX(), paleta.getY(), paleta.getAncho(), paleta.getLargo());
        g.setColor(Color.WHITE);
        g.drawRect(paleta.getX(), paleta.getY(), paleta.getAncho(), paleta.getLargo());
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
        
        // Mostramos el título de la escena.
        if(!play){
            g.setColor(new Color(0,0,0,85));
            g.fillRect(0, 0, display.getWidth(), display.getHeight());
            sceneTitle.render(g);
        }else{
            g.setColor(new Color(255,255,255,85));
        }
        
    }
}
