/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ItsHighNoon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Ian
 */
public class Simulaçao extends JPanel implements Runnable, Comum {
 
    
    private Dimension dimensao;

    private boolean esta_jogando = true;
    private boolean fimdejogo    = false;

    private final String background_imagem = "bg.png";
    private ImageIcon background;
    
    private Jogador jogador;
    private Maquina maquina;
    
    private Thread animador;
    
    private boolean resultado = false;
    private String resultado_etapa = "";
    
    private int ultimo = 0;

    public Simulaçao ()
    {
        addKeyListener(new TAdapter());
        
        setFocusable(true);
        
        this.dimensao = new Dimension(LARGURA, ALTURA);
        
        background = new ImageIcon(getClass().getResource(background_imagem));
        
        initJogo();
    }
    
    public void initJogo () // INICIANDO AS CARTAS DO JOGADOR E DO PC
    {
        Random gerar = new Random(); // USEI UM RAMDOM PRA GERAR O NIVEL E O PODER DAS CARTAS.
        ArrayList<Cartas> cartas = new ArrayList<Cartas>();
        
        cartas.add(new Cartas("carta 1 ", gerar.nextInt(99)+1, gerar.nextInt(4)+1, TIPO_CARTAS.defesa));
        cartas.add(new Cartas("carta 2", gerar.nextInt(99)+1, gerar.nextInt(4)+1, TIPO_CARTAS.defesa));
        cartas.add(new Cartas("carta 3 ", gerar.nextInt(99)+1, gerar.nextInt(4)+1, TIPO_CARTAS.ataque));
        cartas.add(new Cartas("carta 4", gerar.nextInt(99)+1, gerar.nextInt(4)+1, TIPO_CARTAS.ataque));
        cartas.add(new Cartas("carta 5", gerar.nextInt(99)+1, gerar.nextInt(4)+1, TIPO_CARTAS.ataque));
        cartas.add(new Cartas("carta 6", gerar.nextInt(99)+1, gerar.nextInt(4)+1, TIPO_CARTAS.ataque));
        
        jogador = new Jogador("Ian", "UFS", cartas);
        jogador.setWaiting(false);
        
        ArrayList<Cartas> cartas_maquina = new ArrayList<Cartas>();
        
        cartas_maquina.add(new Cartas(" carta 7", gerar.nextInt(99)+1, gerar.nextInt(4)+1, TIPO_CARTAS.defesa));
        cartas_maquina.add(new Cartas("carta 8", gerar.nextInt(99)+1, gerar.nextInt(4)+1, TIPO_CARTAS.defesa));
        cartas_maquina.add(new Cartas("carta 9", gerar.nextInt(99)+1, gerar.nextInt(4)+1, TIPO_CARTAS.ataque));
        cartas_maquina.add(new Cartas("carta 10", gerar.nextInt(99)+1, gerar.nextInt(4)+1, TIPO_CARTAS.ataque));
        cartas_maquina.add(new Cartas("carta 11", gerar.nextInt(99)+1, gerar.nextInt(4)+1, TIPO_CARTAS.ataque));
        cartas_maquina.add(new Cartas("carta 12", gerar.nextInt(99)+1, gerar.nextInt(4)+1, TIPO_CARTAS.ataque));
        
        maquina = new Maquina("maquina", "computador", cartas_maquina);
        maquina.setWaiting(true);
                
        if (animador == null || !esta_jogando)
        {
            animador = new Thread(this);
            animador.start();
        }
    }
    
    @Override
    public void addNotify()
    {
        super.addNotify();
        initJogo();
    }
    
    public void desenharStatus (Graphics2D g)
    {
        Font estilo  = new Font("Microsoft Sans Serif", Font.CENTER_BASELINE, 58);

        g.setColor(Color.white);
        
        g.setFont(estilo);
        
        FontMetrics metrica = this.getFontMetrics(estilo);
        
        if (resultado)
        {
            g.drawString(resultado_etapa, (LARGURA - metrica.stringWidth(resultado_etapa))/2, ALTURA / 2);
            return;
        }
        
        if (jogador.isWaiting())
        {
            resultado_etapa = "Aguarde a sua vez!";
            g.drawString("Aguarde a sua vez!", (LARGURA - metrica.stringWidth(resultado_etapa))/2, ALTURA / 2);
        }
        else
        {
            resultado_etapa = "Aguarde a sua vez!";
            g.drawString("Sua vez de jogar!", (LARGURA - metrica.stringWidth(resultado_etapa))/2, ALTURA / 2);
        }
        
    }
    
    public void desenharFimDeJogo (Graphics2D g) // FAZ COM QUE APARECÇA MENSAGENS NA TELA
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, LARGURA, ALTURA);
        
        Font estilo = new Font("Microsoft Sans Serif", Font.CENTER_BASELINE, 38);
        
        FontMetrics metrica = this.getFontMetrics(estilo);
        
        g.setColor(Color.BLACK);
        
        g.setFont(estilo);
        
        
        
        if (fimdejogo)
        {
            g.drawString("Você perdeu :(", (LARGURA - metrica.stringWidth("Você perdeu :("))/2, ALTURA / 2); 
        }
        else
        {
            g.drawString("Você ganhou :D", (LARGURA - metrica.stringWidth("Você ganhou :D"))/2, ALTURA / 2);
        }
    }
    
    @Override
    public void paint (Graphics g)
    {
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (esta_jogando)
        {
            g2.drawImage(background.getImage(), 0, 0, this);
            
            maquina.desenharCarta(g2, this);
            jogador.desenharCartas(g2, this);
            jogador.desenharJogador(g2);
            jogador.desenharValoresCartas(g2, this);
            jogador.desenharStatus(g2);
            
            maquina.desenharJogador(g2);
            maquina.desenharStatus(g2);
            maquina.desenharValoresCarta(g2, this);
            
            desenharStatus(g2);
        }
        else
        {
            desenharFimDeJogo(g2);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    @Override
    public void run ()
    {
        long antesTempo, tempoDiferente, sleep;
        antesTempo = System.currentTimeMillis();
        
        while (esta_jogando)
        {
            repaint();
            
            ciclo();
            
            if ( resultado )
            {
                try
                {
                    Thread.sleep(2500);
                }
                catch (InterruptedException e)
                {
                    System.out.println("Erro de interrupção!");
                }
                
                resultado = false;
            }
                        
            tempoDiferente = System.currentTimeMillis() - antesTempo;
            sleep = DELAY - tempoDiferente;

            if (sleep < 0)
            { sleep = 2; }

            try
            {
                Thread.sleep(sleep);
            }
            catch (InterruptedException e)
            {
                System.out.println("Erro de interrupção!");
            }

            antesTempo = System.currentTimeMillis();
            
        }
        
        repaint();
    }
    
    public void ciclo () // IMPLEMENTAÇÃO DE COMO O PROGAMA VAI ANALISAR QUEM GANHA CADA RODADA
    {
        jogador.liberarCarta(); // FAZ COM QUE AS CARTAS SEJAM LIBERADAS PRA JOGAR
        maquina.liberarCarta();
                
        if ( jogador.emJogo() && jogador.isWaiting()&& !maquina.emJogo()) // VEZ DA MAQUINA JOGAR. O JOGADOR JA JOGOU
        {
            try
            {
                Thread.sleep(2500);
            }
            catch (InterruptedException e)
            {
                System.out.println("Erro de interrupção!");
            }
            
            maquina.atuar(jogador.cartaEmJogo());
            
            jogador.setWaiting(false);
            
        }
        else if ( !jogador.emJogo() && jogador.isWaiting()&& !maquina.isWaiting() && !maquina.emJogo()) // VEZ DO JOGADOR JOGAR.
        {
            try
            {
                Thread.sleep(2500);
            }
            catch (InterruptedException e)
            {
                System.out.println("Erro de interrupção!");
            }
            
            maquina.primeiraJogada(); // PRIMEIRA JOGADA DA MAQUINA 
            
            jogador.setWaiting(false);// DEPOIS QUE A MAQUINA JOGA O JOGADOR N VAI MAIS ESTAR AGUARDANDO
            
        }
        
        if ( jogador.emJogo() && maquina.emJogo() ) // QUANDO AMBOS FIZERAM A SUA JOGADA E AS CARTAS ESTÃO NA MESA
        {
            repaint(); // verificar
            
            resultado       = true;
            resultado_etapa = jogador.cartaEmJogo().getName(); // MOSTRA O NOME DA CARTA QUE ESTÁ EM JOGO
            
            try
            {
                Thread.sleep(2500);
            }
            catch (InterruptedException e)
            {
                System.out.println("Erro de interrupção!");
            }
            
            Cartas carta_jogador = jogador.cartaEmJogo(); // CAPTURA A CARTA PARA ANALISAR
            Cartas carta_maquina = maquina.cartaEmJogo();
            
            int forca;
            
            jogador.setPower(carta_jogador.getStrength()); // SUBTRAI O PODER DA CARTA AO PODER DO JOGADOR 
            maquina.setPower(carta_maquina.getStrength());
            
            if ( carta_jogador.getTipoCarta() == TIPO_CARTAS.ataque  // COMEÇA A ANALISE DE DANO 
                    && carta_maquina.getTipoCarta() == TIPO_CARTAS.ataque)
            {
                
                if ( carta_jogador.getLevel() > carta_maquina.getLevel() )
                {
                    forca = ((carta_jogador.getLevel() - 1) * 100) + carta_jogador.getStrength();
                    
                    maquina.setLife(forca);
                    
                    forca = ((carta_maquina.getLevel() - 1) * 100) + 
                            ( ( carta_maquina.getStrength() / Max_level ) * carta_maquina.getLevel() );
                    
                    jogador.setLife(forca);
                    
                    resultado_etapa = "Você se saiu melhor!"; // QUANDO TERMINA A ANALISE, E O JOGADOR GANHOU, MOSTRA QUE ELE GANHOU A RODADA
                }
                else if ( carta_jogador.getLevel() < carta_maquina.getLevel() )
                {
                    forca = ((carta_maquina.getLevel() - 1) * 100) + carta_maquina.getStrength();
                    
                    jogador.setLife(forca);
                    
                    forca = ((carta_jogador.getLevel() - 1) * 100) + 
                            ( ( carta_jogador.getStrength() / Max_level ) * carta_jogador.getLevel() );
                    
                    maquina.setLife(forca);
                    
                    resultado_etapa = maquina.getName() + " se saiu melhor!";
                }
                else if ( carta_jogador.getLevel() == carta_maquina.getLevel() )
                {
                    forca = ((carta_jogador.getLevel() - 1) * 100) + carta_jogador.getStrength();
                    
                    maquina.setLife(forca);
                    
                    forca = ((carta_maquina.getLevel() - 1) * 100) + carta_maquina.getStrength();
                                        
                    jogador.setLife(forca);
                    
                    resultado_etapa = "Ambos foram bem!"; 
                }
                
            }
            else if ( carta_jogador.getTipoCarta() == TIPO_CARTAS.defesa 
                    && carta_maquina.getTipoCarta() == TIPO_CARTAS.ataque )
            {
                if ( carta_jogador.getLevel() >= carta_maquina.getLevel())
                {
                    if (carta_jogador.getStrength() > carta_maquina.getStrength())
                    {
                        forca = carta_jogador.getStrength() - carta_maquina.getStrength();
                        
                        maquina.setLife(forca);
                    }
                    
                    resultado_etapa = "Você se saiu melhor!";
                }
                else
                {
                    int forca_defesa = ((carta_jogador.getLevel() - 1) * 100) + carta_jogador.getStrength();
                    int forca_ataque = ((carta_maquina.getLevel() - 1) * 100) + carta_maquina.getStrength();
                    
                    jogador.setLife(forca_ataque - forca_defesa);
                    
                    resultado_etapa = maquina.getName() + " se saiu melhor!";
                }
            }
            else if ( carta_jogador.getTipoCarta() == TIPO_CARTAS.ataque 
                    && carta_maquina.getTipoCarta() == TIPO_CARTAS.defesa )
            {
                if ( carta_maquina.getLevel() >= carta_jogador.getLevel())
                {
                    if (carta_maquina.getStrength() > carta_jogador.getStrength())
                    {
                        forca = carta_maquina.getStrength() - carta_jogador.getStrength();
                        
                        jogador.setLife(forca);
                    }
                    
                    resultado_etapa = maquina.getName() + " se saiu melhor!";
                }
                else
                {
                    int forca_defesa = ((carta_maquina.getLevel() - 1) * 100) + carta_maquina.getStrength();
                    int forca_ataque = ((carta_jogador.getLevel() - 1) * 100) + carta_jogador.getStrength();
                    
                    maquina.setLife(forca_ataque - forca_defesa);
                    
                    resultado_etapa = "Você se saiu melhor!";
                }
            }
            
            maquina.resetar(); // COMEÇA UMA NOVA RODADA.
            jogador.resetar();
            
            if ( jogador.isWaiting()&& maquina.isWaiting() )
            {
                jogador.setWaiting(false);
                maquina.setWaiting(true);
            }
            else
            {
                jogador.setWaiting(!jogador.isWaiting());
                maquina.setWaiting(!maquina.isWaiting());
            }
            
            jogador.diminuirEspera(); // DIMINUI A ESPERA DE CADA CARTA. POIS SE PASSOU UM RODADA
            maquina.diminuirEspera();
            
            if (jogador.getLife() <= 0) // VERIFICA SE A VIDA ZEROU.
            {
                jogador.zeraVida();
            }
            
            if (maquina.getLife() <= 0)
            {
                maquina.zeraVida();
            }
            
            if (jogador.getPower() <= 0) // VERIFICA SE O PODER ZEROU.
            {
                jogador.setAumentoDePoder(0);
            }
            
            if (maquina.getPower() <= 0)
            {
                maquina.setAumentoDePoder(0);
            }
                        
            repaint();// verificar
            
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println("Erro de interrupção!");
            }
            
        }
        
        if (jogador.getLife() <= 0) // CASO A VIDA SEJA 0 GAME OVER.
        {
            esta_jogando = false;
            fimdejogo    = true;
        }
        else if (maquina.getLife() <= 0)
        {
            esta_jogando = false;
        }
        
        if (jogador.getPower() <= 0) // QUANDO O PODER É 0 DIMINUI A VIDA EM 50 PONTOS, LIBERA AS CARTAS, E RECARREGA O PODER.
        {
            jogador.setLife(50);
            jogador.setAumentoDePoder(0);
            jogador.liberarTodasCarta();
            
            if (jogador.getLife() <= 0)
            {
                jogador.zeraVida();
            }
                        
            resultado_etapa = "Carregando seu poder!";
            
            int poder = 0;
            
            while ( jogador.getPower() != 500 )
            {
                poder++;
                
                jogador.setAumentoDePoder(poder);
                
                repaint(); // VERIFICAR
            
                try
                {
                    Thread.sleep(5);
                }
                catch (InterruptedException e)
                {
                    System.out.println("Erro de interrupção!");
                }
            }
        }
        else if (maquina.getPower() <= 0)
        {
            maquina.setLife(50);
            maquina.setAumentoDePoder(0);
            maquina.liberarTodasCarta();
            
            resultado_etapa = "Carregando o poder de " + maquina.getName() + "!";

            int poder = 0;
            
            while ( maquina.getPower() != 500 )
            {
                poder++;
                
                maquina.setAumentoDePoder(poder);
                
                repaint();
            
                try
                {
                    Thread.sleep(5);
                }
                catch (InterruptedException e)
                {
                    System.out.println("Erro de interrupção!");
                }
                
            }
        }
    }
    
    private class TAdapter extends KeyAdapter { // VERIFICAR

        @Override
        public void keyReleased(KeyEvent e)
        {
            jogador.keyReleased(e);
        }

        // DEFINE O MÉTODO DE TECLA PRESSIONADA DO JOGADOR
        @Override
        public void keyPressed(KeyEvent e)
        {
            // O JOGADOR SE MOVIMENTA
            jogador.keyPressed(e);
        }
    }
        

}


