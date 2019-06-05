/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ItsHighNoon;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Ian
 */
 
public class Maquina extends Personagem
{
    /* Implementando a IA, definida no caderno ( coisa pra caralho). quase morri. */
    
    public Maquina (String nome, String reino, ArrayList<Cartas> cartas)
    {
    
        this.name   = name;
        this.kingdom  = reino;
        this.cartas = cartas;
        
        this.cartas.get(0).setSelect(true);
        
       this.life = Max_life;
       this.power = Max_power;
       
       this.Max_level = CalcularLevel();
       this.Max_strength = CalcularStrength();
        
        
        this.setX(1068); // VERIFICA
        this.setY(45); // VERIFICA
        
    }
    
    public void primeiraJogada () // Se a maquina for a primeira do jogo a iniciar a partida.
    {
        
        for ( int i = 0 ; i < this.cartas.size(); i++ )
        {
            
            if ( this.cartas.get(i).getLevel() == this.Max_level 
                    && this.cartas.get(i).isReady()
                    && this.cartas.get(i).getTipoCarta() != TIPO_CARTAS.defesa)
            {
                usaCarta(i);                
                return;
            }
            
        }
        
        int nivel = Max_level;
        int selecionada = -1;
        
        for ( int i = 0 ; i < this.cartas.size(); i++ )
        {
            
            if ( this.cartas.get(i).getLevel() < nivel
                    && this.cartas.get(i).isReady()
                    && this.cartas.get(i).getTipoCarta() != TIPO_CARTAS.defesa)
            {
                nivel = this.cartas.get(i).getLevel();
                selecionada = i;
            }
            
        }
        
        if ( selecionada != -1)
        {
            usaCarta(selecionada);   
            return;
        }
        
        nivel = 0;
        selecionada = -1;
        
        for ( int i = 0 ; i < this.cartas.size(); i++ )
        {
            
            if ( this.cartas.get(i).getLevel() > nivel
                    && this.cartas.get(i).isReady()
                    && this.cartas.get(i).getTipoCarta() != TIPO_CARTAS.defesa)
            {
                nivel = this.cartas.get(i).getLevel();
                selecionada = i;
            }
            
        }
        
        if ( selecionada != -1)
        {
            usaCarta(selecionada);
            return;
        }
        
        for ( int i = 0 ; i < this.cartas.size(); i++ )
        {
            
            if ( this.cartas.get(i).isReady()&& this.cartas.get(i).getTipoCarta() != TIPO_CARTAS.defesa)
            {
                usaCarta(i);                
                return;
            }
            
        }
        
    }
    
    public void atuar (Cartas jogador) // Analisa a carta do jogador e age de acordo com ela ( se for atk ou def)
    {
        
        if (jogador.getTipoCarta() == TIPO_CARTAS.ataque)
        {
            for ( int i = 0 ; i < this.cartas.size(); i++ )
            {

                if ( this.cartas.get(i).getLevel() > jogador.getLevel() && this.cartas.get(i).isReady())
                {
                    usaCarta(i);
                    return;
                }

            }

            for ( int i = 0 ; i < this.cartas.size(); i++ )
            {

                if ( this.cartas.get(i).getLevel() == jogador.getLevel() && this.cartas.get(i).isReady())
                {
                    usaCarta(i);
                    return;
                }

            }

            int nivel    = -1;
            int escolher = -1;

            for ( int i = 0 ; i < this.cartas.size(); i++ )
            {

                if ( this.cartas.get(i).getTipoCarta() == TIPO_CARTAS.defesa && this.cartas.get(i).isReady())
                {
                    if ( this.cartas.get(i).getLevel() > nivel)
                    {
                        nivel = this.cartas.get(i).getLevel();
                        escolher = i;
                    }
                }

            }

            if ( nivel != -1 && escolher != -1 )
            {
                usaCarta(escolher);
                return;
            }

            nivel    = -1;
            escolher = -1;

            for ( int i = 0 ; i < this.cartas.size(); i++ )
            {

                if ( this.cartas.get(i).getTipoCarta() == TIPO_CARTAS.ataque && this.cartas.get(i).isReady())
                {
                    if ( this.cartas.get(i).getLevel() > nivel)
                    {
                        nivel = this.cartas.get(i).getLevel();
                        escolher = i;
                    }
                }

            }

            if ( nivel != -1 && escolher != -1 )
            {
                usaCarta(escolher);
                return;
            }

            nivel    = 6;
            escolher = 6;

            for ( int i = 0 ; i < this.cartas.size(); i++ )
            {

                if ( this.cartas.get(i).getTipoCarta() == TIPO_CARTAS.ataque && this.cartas.get(i).isReady())
                {
                    if ( this.cartas.get(i).getLevel()< nivel)
                    {
                        nivel = this.cartas.get(i).getLevel();
                        escolher = i;
                    }
                }

            }

            if ( nivel != 6 && escolher != 6 )
            {
                usaCarta(escolher);
            }
        }
        else
        {
            for ( int i = 0 ; i < this.cartas.size(); i++ )
            {

                if ( this.cartas.get(i).getTipoCarta() == TIPO_CARTAS.ataque 
                        && this.cartas.get(i).getLevel() > jogador.getLevel() 
                        && this.cartas.get(i).isReady())
                {
                    usaCarta(i);
                    return;
                }

            }
            
            int nivel    = 6;
            int escolher = 6;

            for ( int i = 0 ; i < this.cartas.size(); i++ )
            {

                if ( this.cartas.get(i).getTipoCarta() == TIPO_CARTAS.ataque && this.cartas.get(i).isReady())
                {
                    if ( this.cartas.get(i).getLevel() < nivel)
                    {
                        nivel = this.cartas.get(i).getLevel();
                        escolher = i;
                    }
                }

            }

            if ( nivel != 6 && escolher != 6 )
            {
                usaCarta(escolher);
            }
        }
    }
    
    public void usaCarta(int i) // depois de analisar qual a melhor jogada a ser feita, a maquina a executa.
    {
        if ( this.cartas.get(i).isReady()&& i != -1 )
        {
            this.cartas.get(i).setInGame(true);
            this.setWaiting(true);
            this.cartas.get(i).setReady(false);

            if ( this.cartas.get(i).getTipoCarta() == TIPO_CARTAS.ataque )
            {
                this.cartas.get(i).waiting();
            }
            else
            {
                this.cartas.get(i).setWait(7);
            }
        }
    }
    
    public void desenharJogador (Graphics2D g) // VERIFICA
    {
        Font estilo     = new Font("Microsoft Sans Serif", Font.LAYOUT_RIGHT_TO_LEFT, 38);
        Font estilo_med = new Font("Microsoft Sans Serif", Font.CENTER_BASELINE, 22);
         Font estilo_min = new Font("Microsoft Sans Serif", Font.CENTER_BASELINE, 14);

        g.setColor(Color.white);
        
        g.setFont(estilo);
        g.drawString(this.name, this.getX(), this.getY()); 
        
        g.setFont(estilo_med);
        g.drawString(this.kingdom, 1018, 220);
        g.drawString(this.Max_strength + "/" + this.Max_level, 1018, 45);
        
        g.setFont(estilo_min);
        g.drawString(this.life+"", 570, 120);
    }
    
    public void desenharStatus (Graphics2D g) // VERIFICA
    {
        int vida  = (this.life  * 175) / Max_level;
        
        g.setColor(Color.YELLOW);
        
        g.fillRect(481, 129, vida, 26);
        
    }
    
    public void desenharCarta (Graphics2D g, JPanel tela) // VERIFICA
    {
        for ( int i = 0; i < this.cartas.size(); i++ )
        {
            if ( this.cartas.get(i).isInGame())
            { 
                g.drawImage(this.cartas.get(i).getImagens(), 
                                    1022, 
                                    262, 
                                    tela);  
            }
            
        }
    }
    
    public void desenharValoresCarta (Graphics2D g, JPanel tela) // VERIFICA
    {
        String forca = "F";
        String nivel = "N";
        
        Font estilo_medi = new Font("Tahoma", Font.BOLD, 22);
        Font estilo_full = new Font("Microsoft Sans Serif", Font.CENTER_BASELINE, 38);
        
        FontMetrics metrica_medi = tela.getFontMetrics(estilo_medi);
        FontMetrics metrica_full = tela.getFontMetrics(estilo_full);

        g.setColor(Color.white);
        
        int fator = 0;        
        
        for ( int i = 0; i < this.cartas.size(); i++ )
        { 
            fator = i + 1;
            
            if ( this.cartas.get(i).isInGame())
            {                
                g.setFont(estilo_medi);

                g.drawString(forca, 1047, 319); 
                g.drawString(nivel, 1047, 409); 
                g.drawString(this.cartas.get(i).getTipoCarta().toString().toUpperCase(), 1047, 350);

                g.setFont(estilo_full);

                g.drawString(this.cartas.get(i).getStrength()+"", 1067, 321); 
                g.drawString(this.cartas.get(i).getLevel()+"", 1067, 411);
                
            }
            
        }
    }
    
}

    

