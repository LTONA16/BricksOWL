/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.Ladrillo;
import models.Paleta;
import models.Pelota;


/**
 *
 * @author luisi
 */
public class EnJuego {
    
    //Atributos para el funcionamiento de la logica del juego
    private int vidas;
    private Pelota pelota;
    private Paleta paleta;
    private Ladrillo[][] ladrillos;
    
    //Constructor
    public EnJuego(int vidas, Pelota pelota, Paleta paleta, Ladrillo[][] ladrillos){
        this.vidas = vidas;
        this.pelota = pelota;
        this.paleta = paleta;
        this.ladrillos = ladrillos;
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
    public void pintarComponent(){
        
    }
    
    // Comprueba si existen ladrillos restantes, si no hay ladrillos el jugador gana la partida
    public void ganaste(){
        
    }
    
}
