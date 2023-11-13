/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

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
    
    public Pelota(int largo, int ancho, int X, int Y, int radio, int velX,int velY){
        this.largo = largo;
        this.ancho = ancho;
        this.X = X;
        this.Y = Y;
        this.radio = radio;
        this.velX = velX;
        this.velY = velY;
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
    
    public int getRadio(){
        return radio;
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
    
    
}
