/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ItsHighNoon;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Ian
 */
public class Cartas extends Desenho {
    
    private String name;
    private int strength;
    private int level;
    //private String tipo; // ATK ou DEF
    private TIPO_CARTAS tipo_carta;// ATK ou DEF
    private Image imagens;
    
    private boolean ready;
    private boolean select;
    private boolean inGame;
    
    private int wait;
    
    private final String imagem_normal = "carta.png";
    //private TIPO_cartas tipo_cartas;// // esse tipo cartas é outro meio que tava vendo de como fazer pra identifica quando ela vai ser de atack ou def. VC olha depois qual que fica do melhor jeito, tem outras classes que utlizam esses metodo, ai vc altera se necessario.
    
    public Cartas(String name, int strength, int level,/* String tipo,*/TIPO_CARTAS tipo_carta){
        this.name = name;
        this.level = level;
        this.strength = strength;
        this.ready = true;
        //this.tipo = tipo;
        this.tipo_carta = tipo_carta;//
        
        this.inGame = false;
        this.select = false;
        this.wait = 0;
        
        //ImageIcon carta = new ImageIcon(imagem_normal);
      //  setImagem(carta.getImage());
        
    }
    
    public void setImage(String tipo){
        if (tipo == "ATK"){
            //imagem = new Image(this.getClass().getResource("imagem//logo.jpg"));
        }
        else {
             //imagem = new Image(this.getClass().getResource("imagem//logo.jpg"));
            
        }
    }

    public String getName() {
        return name;
    }

    /*public String getTipo() {
        return tipo;
    }*/

    /*public void setTipo(String tipo) {
        this.tipo = tipo;
    }*/
    
    public TIPO_CARTAS getTipoCarta()
    {
        return tipo_carta;
    }

    public int getStrength() {
        return strength;
    }

    public int getLevel() {
        return level;
    }

    public boolean isReady() {
        return ready;
    }
    
    public void setReady(boolean ready){
        this.ready = ready;
        
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
    
    public void waiting(){ //chamo quando a carta fica em espera. Pois atraves desse metodo eu saberei o nivel da carta que é igual a quantidade de vezes que terei que esperar para jogar a carta novamente.
        this.wait = this.level + 1;
        
    }

    public int getWait() {
        return wait;
    }

    public void setWait(int wait) {
        this.wait = wait;
    }

   public TIPO_CARTAS getTipo_cartas() {
        return tipo_carta;
    }
}
