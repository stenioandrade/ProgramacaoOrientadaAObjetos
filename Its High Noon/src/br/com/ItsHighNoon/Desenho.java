/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ItsHighNoon;

import java.awt.Image;

/**
 *
 * @author Ian
 */
public class Desenho implements Comum {
    
    private Image imagens;
    
    private boolean visibilidade;
    private boolean destruicao;
    private int altura_desenho;
    private int largura_desenho;
    
    private int x;
    private int y;
    
    private int direcao;
    
    public Desenho(){
        this.visibilidade = true;
        this.destruicao = false;
    }

    public Image getImagens() {
        return imagens;
    }

    public boolean isVisivel() {
        return visibilidade;
    }

    public boolean isDestruido() {
        return destruicao;
    }

    public int getAltura_desenho() {
        return altura_desenho;
    }
    
    public int getLargura_desenho(){
        return largura_desenho;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirecao() {
        return direcao;
    }

    public void setImagens(Image imagens) {
        this.imagens = imagens;
    }

    public void setVisibilidade(boolean visibilidade) {
        this.visibilidade = visibilidade;
    }

    public void setDestruicao(boolean destruicao) {
        this.destruicao = destruicao;
    }

    public void setAltura_desenho(int altura_desenho) {
        this.altura_desenho = altura_desenho;
    }

    public void setLargura_desenho(int largura_desenho) {
        this.largura_desenho = largura_desenho;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }
    
    
    
    
}
