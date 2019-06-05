/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ItsHighNoon;

import java.util.ArrayList;
/**
 *
 * @author Ian
 */
public class Personagem extends Desenho {
    
   protected String name;
   protected String kingdom;
    
   protected int Max_strength;
   protected int Max_level;
   
   protected int life;
   protected int power;
   
   protected ArrayList<Cartas> cartas;
   
   private boolean waiting;
   

  
   
    public int CalcularLevel(){
       int level = 0;
       for (int i=0; i< this.cartas.size(); i++){
           level += this.cartas.get(i).getLevel();
       }
       return level = level/this.cartas.size();
    }
   
    
    
    public int CalcularStrength(){
       int forca = 0;
       for (int i=0; i< this.cartas.size(); i++){
           forca += this.cartas.get(i).getStrength();
       }
       return forca = forca/this.cartas.size();
       
    }
    
    
    
    public void liberarCarta(){ // Quando suas cartas acabarem este método fará com que a carta de menor nivel seja liberada.
         boolean ready = false;
         int menor_nivel = Max_level;
         
         int index = 0;
         
         for(int i=0; i < this.cartas.size(); i++){
             
             if(this.cartas.get(i).getLevel() < menor_nivel){ //busca a carta com o menor nivel.
                 menor_nivel = this.cartas.get(i).getLevel();
                 index = i;
             }
             
             if(this.cartas.get(i).isReady()){ // verifica se está disponivel.
                 ready = true;
                 break;
             }
             
         }
         
         if(!ready){
             this.cartas.get(index).setReady(true);
         }
    }
    
     public void liberarTodasCarta () // Quando o poder se esgota e irá recarregar, ele libera todas as cartas para serem jogadas novamente.
    {
        for ( int i = 0 ; i < this.cartas.size(); i++)
        {
            this.cartas.get(i).setWait(0);
            this.cartas.get(i).setReady(true);            
        }
        
    }
     
     
     public void diminuirEspera() // Verifica quantas turnos ainda faltam para a carta poder ser usada novamente.
    {
        for ( int i = 0 ; i < this.cartas.size(); i++)
        {
            
            if ( this.cartas.get(i).getWait() > 0 && this.cartas.get(i).getWait() != 7)
            {
                this.cartas.get(i).setWait(this.cartas.get(i).getWait() - 1 );
            }
            
            if ( this.cartas.get(i).getWait()== 0 )
            {
                this.cartas.get(i).setReady(true);
            }
            
        }
    }
    
    
    
    
    
    public boolean emJogo () // verifica se a carta está em jogo.
    {
        for ( int i = 0 ; i < this.cartas.size(); i++)
        {
            
            if ( this.cartas.get(i).isInGame())
            {
                return true;
            }
            
        }
        
        return false;
    }
    
    
    
    
    public boolean resetar () // verifica as cartas que estão em jogo. Se estiver em jogo, seta a carta como false e retorna false.
    {
        for ( int i = 0 ; i < this.cartas.size(); i++)
        {
            
            if ( this.cartas.get(i).isInGame())
            {
                this.cartas.get(i).setInGame(false);
            }
            
        }
        
        return false;
    }
    
    
    
    
     public Cartas cartaEmJogo ()// verifica qual carta está em jogo e retona ela, caso n haja nenhuma carta em jogo ele retona null.
    {
        for ( int i = 0 ; i < this.cartas.size(); i++)
        {
            
            if ( this.cartas.get(i).isInGame())
            {
                return this.cartas.get(i);
            }
            
        }
        
        return null;
    }

     
     
     

    public String getName() {
        return name;
    }

    public String getKingdom() {
        return kingdom;
    }

    public int getMax_strength() {
        return Max_strength;
    }

    public int getMax_level() {
        return Max_level;
    }

    public int getLife() {
        return life;
    }

    public int getPower() {
        return power;
    }

    public ArrayList<Cartas> getCartas() {
        return cartas;
    }

    public void setLife(int forca) {
        this.life -= forca;
    }
    
    public void zeraVida() 
    {
        this.life = 0;
    }

    public void setPower(int forca) {
        this.power -= forca;
    }
    
    public void setAumentoDePoder(int power) // Para quando o poder acabar, recarrega-lo.
    {
        this.power = power;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }
   
    
}
