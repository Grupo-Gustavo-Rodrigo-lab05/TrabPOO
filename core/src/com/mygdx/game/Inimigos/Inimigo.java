package com.mygdx.game.Inimigos;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import javax.xml.soap.Text;

public abstract class Inimigo extends ApplicationAdapter {
    protected int velocidade;
    protected float vida;
    Texture imagemInimigo;
    private Rectangle local;

    public int getVel(){
        return velocidade;
    }
    public void recebeDano(float dano) {
        vida -= dano;
        if(vida <= 0)
            morre();
    }

    public boolean morre() {
        if(vida <= 0){
            return true;
        }
        return false;
    }

    public void setRec(float x, float y) {
        local = new Rectangle();
        local.x = x;
        local.y = y;
        local.width = 64;
        local.height = 64;
    }
    public Rectangle getRec() {
        return local;
    }

    public Texture imagemInimigo() {
        return imagemInimigo;
    }

}
