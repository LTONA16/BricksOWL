/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.awt.Color;
/**
 *
 * @author luisi
 */
public class Ladrillo {
    private int largo;
    private int ancho;
    private int vida;
    private int ladrillos;
    private int vidaMax = 3;
    private Color colorLadrillo;
    private int x;
    private int y;


    
     public Ladrillo(int largo, int ancho, int vida, int vidaMax, Color colorLadrillo){
        this.largo = largo;
        this.ancho = ancho;
        this.vida = vida;
        this.vidaMax = vidaMax;
        this.colorLadrillo = colorLadrillo;
        
    }
    
    public int getLargo(){
        return largo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getAncho(){
        return ancho;
    }
    
    public int getVida(){
        return vida;
    }
    
    public Color getColor(){
        return colorLadrillo;
    }
    
    public int getVidaMax(){
        return vidaMax;
    }
    
    public void setLargo(int nLargo){
        this.largo = nLargo;
    }
    
    public void setAncho(int nAncho){
        this.ancho = nAncho;
    }
    
    public void setVida(int nVida){
        this.vida = nVida;
    }
    
    public void setColor(Color nColor){
        this.colorLadrillo = nColor;
    }
    
    public void setVidaMax(int nVidaMax){
        this.vidaMax = nVidaMax;
    }
    
        public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}
