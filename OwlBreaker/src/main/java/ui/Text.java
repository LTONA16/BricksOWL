package ui;

import display.Display;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Representa un texto en la pantalla.
 *
 * @author Aguilera Luzania José Luis.
 */
public class Text {

    private String text;         // Contenido del texto.
    private Font font;           // Fuente del texto.
    private Color color;         // Color del texto.
    private int x;               // Posición en el eje x.
    private int y;               // Posición en el eje y.

    /**
     * Representa un texto en la pantalla.
     *
     * @param font Fuente del texto.
     */
    public Text(Font font) {
        // Inicializamos el contenido.
        this.text = "";
        this.color = Color.white;

        // Guardamos la referencia de la fuente.
        this.font = font;

        // Inicializamos la posición del texto en (0,0).
        x = y = 0;
    }

    /**
     * @param text Contenido del texto.
     */
    public void setText(String text) {
        this.text = text;

        // Actualizamos la posición del pivote.
        updatePivotPosition();
    }

    /**
     * @param color Color del texto.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @param x Coordenadas en el eje x.
     * @param y Coordenadas en el eje y.
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;

        // Actualizamos la posición del pivote.
        updatePivotPosition();
    }


    /**
     * Dibuja el texto en la ventana con la fuente y color específicados.
     *
     * @param graphics Contenido de la ventana.
     */
    public void render(Graphics graphics) {
        Color original = graphics.getColor(); // Guardamos el color original.
        graphics.setColor(color);        // Establecemos el color.
        graphics.setFont(font);          // Establecemos la fuente del texto.
        graphics.drawString(text, x, y); // Dibujamos el texto.
        graphics.setColor(original);     // Reiniciamos el color.
    }

    /**
     * Actualiza la posición del pivote (punto que sirve como referencia de la posición del texto). El pivote queda
     * centrado en el rectángulo del texto.
     */
    public void updatePivotPosition() {
        // Obtenemos los gráficos de la pantalla.
        Graphics graphics = Display.getInstance().getGraphics();

        // Calculamos el rectángulo del texto.
        Rectangle2D rect = graphics.getFontMetrics(font).getStringBounds(text, graphics);

        // Recalculamos la posición del texto.
        x -= (int) rect.getWidth() / 2;
        y -= (int) rect.getHeight() / 2;
    }
}