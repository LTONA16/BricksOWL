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
public class Pelota {
    private int largo;
    private int ancho;
    private int X;
    private int Y;
    private int radio;
    private int velX;
    private int velY;
    private int vel = 5;
    private Color colorPelota;
    
     public Pelota(int largo, int ancho, int X, int Y, int radio, int velX,int velY, Color colorPelota){
        this.largo = largo;
        this.ancho = ancho;
        this.X = X;
        this.Y = Y;
        this.radio = radio;
        this.velX = velX;
        this.velY = velY;
        this.colorPelota = colorPelota;
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
    
    public int getVelX(){
        return velX;
    }
    
    public int getVelY(){
        return velY;
    }
    
    public int getVel(){
        return vel;
    }
    
    public int getRadio(){
        return radio;
    }
    
    public Color getColor(){
        return colorPelota;
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
    
    public void setRadio(int nRadio){
        this.radio = nRadio;
    }
    
    public void setVelX(int nVelX){
        this.velX = nVelX;
    }
    
    public void setVelY(int nVelY){
        this.velY = nVelY;
    }
    
    public void setVel(int nVel){
        this.vel = nVel;
    }
    
    public void setColor(Color nColor){
        this.colorPelota = nColor;
    }
    
     public void mover() {
        setX(getX() + getVelX());
        setY(getY() + getVelY());
    }
    
    
}
