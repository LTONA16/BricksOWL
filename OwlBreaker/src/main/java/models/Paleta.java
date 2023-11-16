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
public class Paleta {
    private int largo;
    private int ancho;
    private int X;
    private int Y;
    private int vel;
    private Color colorPaleta;
    
     public Paleta(int largo, int ancho, int X, int Y, int vel, Color colorPaleta){
        this.largo = largo;
        this.ancho = ancho;
        this.X = X;
        this.Y = Y;
        this.vel = vel;
        this.colorPaleta = colorPaleta;
    }
    
    public int getLargo(){
        return largo;
    }
    
    public int getAncho(){
        return ancho;
    }
    
    public int getX(){
        return X;
    }
    
    public int getY(){
        return Y;
    }
    
    public int getVel(){
        return vel;
    }
    
    public Color getColor(){
        return colorPaleta;
    }
    
    public void setLargo(int nLargo){
        this.largo = nLargo;
    }
    
    public void setAncho(int nAncho){
        this.ancho = nAncho;
    }
    
    public void setX(int nX){
        this.X = nX;
    }
    
    public void setY(int nY){
        this.Y = nY;
    }
    
    public void setVel(int nVel){
        this.vel = nVel;
    }
    
    public void setColor(Color nColor){
        this.colorPaleta = nColor;
    }
    
}
