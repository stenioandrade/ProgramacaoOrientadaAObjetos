/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ItsHighNoon;

/**
 *
 * @author Ian
 */
public interface Comum {
    
  public enum TIPO_CARTAS { ataque , defesa };
    
    public static final int Max_level = 5;
    public static final int Max_strength = 100;
    public static final int Max_life = 1000;
    public static final int Max_power = 500;
    
    public static boolean End_game = false;
    public static boolean Power_charge = false;
    
    
    public static final int ALTURA = 480;
    public static final int LARGURA = 640;
    
    public static final String CAMINHO_graficos = "/graficos/";
    
    public static final int DELAY = 17;
    
    
    
}
