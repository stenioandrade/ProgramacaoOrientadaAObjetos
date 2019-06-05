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
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Ian
 */
public class Jogador extends Personagem {
    
    
    public Jogador (String nome, String reino, ArrayList<Cartas> cartas){
    
        this.name   = name;
        this.kingdom  = reino;
        this.cartas = cartas;
        
        this.cartas.get(0).setSelect(true);
        
       this.life = Max_life;
       this.power = Max_power;
       
       this.Max_level = CalcularLevel();
       this.Max_strength = CalcularStrength();
        
        this.setX(995); // verificar
        this.setY(720); // verificar.
                
        posicionarCartas();
    }
    
    public void cartaEsquerda () // metodo que verifica quando a carta foi selecionada, e se foi selecionado ela entra em espera até poder ser selecionada novamente. 
    {
        int selecionada = -1;
        
        for ( int i = 0 ; i < this.cartas.size(); i++)
        {
            
            if ( this.cartas.get(i).isSelect())
            {
                selecionada = i;
                break;
            }
            
        }
        
        if ( selecionada != -1 )
        {
            this.cartas.get(selecionada).setSelect(false);
            
            selecionada -= 1;
            
            if ( selecionada < 0 )
            {
                selecionada = 5;
            }
            
            this.cartas.get(selecionada).setSelect(true);
        }
    }
    
    public void cartaDireita ()
    {
        
        int selecionada = -1;
        
        for ( int i = 0 ; i < this.cartas.size(); i++)
        {
            
            if ( this.cartas.get(i).isSelect() )
            {
                selecionada = i;
                break;
            }
            
        }
        
        if ( selecionada != -1 )
        {
            this.cartas.get(selecionada).setSelect(false);
            
            selecionada += 1;
            
            if ( selecionada > 5 )
            {
                selecionada = 0;
            }
            
            this.cartas.get(selecionada).setSelect(true);
        }
    }
    
    public void usaCarta ()
    {
        int selecionada = -1;
        
        for ( int i = 0 ; i < this.cartas.size(); i++) // percorre todas as cartas.
        {
            
            if ( this.cartas.get(i).isSelect() ) // verifica qual carta está seleconada.
            {
                selecionada = i;// obtem-se a posição dela.
                break;
            }
            
        }
        
        if ( this.cartas.get(selecionada).isReady()&& selecionada != -1 ) // Verifica se a carta estiver selecionada e disponivel.
        {
            this.cartas.get(selecionada).setInGame(true);
            this.setWaiting(true);
            this.cartas.get(selecionada).setReady(false);

            if ( this.cartas.get(selecionada).getTipoCarta() == TIPO_CARTAS.ataque ) // isso aqui utiliza daquele metodo de como verificar se a carta é de atack ou def.
            {
                this.cartas.get(selecionada).waiting();
            }
            else
            {
                this.cartas.get(selecionada).setWait(7);
            }
        }
    }
        
    private void posicionarCartas () // posiciona as cartas na interface. VERIFICAR
    {
        int y = 545; // verifica
        int x = 13; // verifica
        
        int fator = 0;
        
        for ( int i = 0; i < this.cartas.size(); i++ )
        {
            fator = i + 1;
            
            this.cartas.get(i).setX(x);
            this.cartas.get(i).setY(y);
            
            x += 156;
        }
    }
    
    public void desenharJogador (Graphics2D g) // VERIFICAR 
    {
        Font estilo     = new Font("Microsoft Sans Serif", Font.CENTER_BASELINE, 38);
        Font estilo_med = new Font("Microsoft Sans Serif", Font.CENTER_BASELINE, 22);
        Font estilo_min = new Font("Microsoft Sans Serif", Font.CENTER_BASELINE, 14);

        g.setColor(Color.white);
        
        g.setFont(estilo);
        g.drawString(this.name, this.getX(), this.getY()); 
        
        g.setFont(estilo_med);
        g.drawString(this.kingdom, 50, 220);
        g.drawString(this.Max_strength + "/" + this.Max_level, 1130, 720);
        
        g.setFont(estilo_min);
        g.drawString(this.life+"", 1085, 575);
        g.drawString(this.power+"", 1050, 630);
        
    }
    
    public void desenharStatus (Graphics2D g) // VERIFICAR
    {
        int vida  = (this.life  * 175) / Max_life;
        int poder = (this.power * 175) / Max_power;
        
        g.setColor(Color.YELLOW);
        
        g.fillRect(992, 582, vida, 26);
        
        g.setColor(Color.RED);
        
        g.fillRect(992, 638, poder, 26);
        
    }
    
    public void desenharValoresCartas (Graphics2D g, JPanel tela) // VERIFICAR. 
    {
        String forca = "F";
        String nivel = "N";
        
        Font estilo_mini = new Font("Microsoft Sans Serif", Font.BOLD, 14);
        Font estilo_medi = new Font("Tahoma", Font.BOLD, 22);
        Font estilo_full = new Font("Microsoft Sans Serif", Font.CENTER_BASELINE, 38);
        
        FontMetrics metrica_mini = tela.getFontMetrics(estilo_mini);
        FontMetrics metrica_medi = tela.getFontMetrics(estilo_medi);
        FontMetrics metrica_full = tela.getFontMetrics(estilo_full);

        g.setColor(Color.white);
        
        int x_medi = 35;
        int x_full = 58;
        
        int disponivel   = 42;
        int indisponivel = 36;
        
        int fator = 0;        
        
        for ( int i = 0; i < this.cartas.size(); i++ )
        { 
            fator = i + 1;
            
            if ( this.cartas.get(i).isReady())
            {
                g.setColor(Color.white);
            }
            else
            {
                g.setColor(Color.yellow);
            }
            
            if ( this.cartas.get(i).isSelect()&& this.cartas.get(i).isInGame())
            {                
                g.setFont(estilo_medi);

                g.drawString(forca, 73, 319); 
                g.drawString(nivel, 73, 409); 
                
                g.drawString(this.cartas.get(i).getTipoCarta().toString().toUpperCase(), 73, 350);

                g.setFont(estilo_full);

                g.drawString(this.cartas.get(i).getStrength()+"", 96, 321); 
                g.drawString(this.cartas.get(i).getLevel()+"", 96, 411); 
            }
            else
            {
                g.setFont(estilo_medi);

                g.drawString(forca, x_medi, 602); 
                g.drawString(nivel, x_medi, 692); 
                
                g.drawString(this.cartas.get(i).getTipoCarta().toString().toUpperCase(), x_medi, 660);

                g.setFont(estilo_full);

                g.drawString(this.cartas.get(i).getStrength()+"", x_full, 604); 
                g.drawString(this.cartas.get(i).getLevel()+"", x_full, 694); 

            }
            
            g.setFont(estilo_mini);
            
            if ( this.cartas.get(i).isReady())
            {
                g.drawString("DISPONÍVEL", disponivel, 750); 
            }
            else
            {
                g.drawString("INDISPONÍVEL", indisponivel, 750); 
            }
            
            x_medi       += 156;
            x_full       += 156;
            disponivel   += 156;
            indisponivel += 156;
        }
    }
    
    public void desenharCartas (Graphics2D g, JPanel tela) // VERIFICAR
    {
        
        for ( int i = 0; i < this.cartas.size(); i++ )
        {            
            if ( this.cartas.get(i).isSelect())
            { 
                if ( this.cartas.get(i).isInGame())
                {
                    g.drawImage(this.cartas.get(i).getImagens(), 
                                51, 
                                262, 
                                tela); 
                }
                else
                {
                    g.drawImage(this.cartas.get(i).getImagens(), 
                                this.cartas.get(i).getX(), 
                                this.cartas.get(i).getY(), 
                                tela); 
                }
            }
        }
        
    }
    
    public void keyPressed (KeyEvent e) // Teclas das quais o jogador utilizará para jogar .
    {
       if ( !emJogo() && !isWaiting())
       {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT)
            { cartaEsquerda(); }

            if (key == KeyEvent.VK_RIGHT)
            { cartaDireita(); }

            if (key == KeyEvent.VK_ENTER)
            { usaCarta(); }
       }
    }

    public void keyReleased (KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT)
        { }

        if (key == KeyEvent.VK_RIGHT)
        { }
       
        if (key == KeyEvent.VK_ENTER)
        { }
    }
    }

