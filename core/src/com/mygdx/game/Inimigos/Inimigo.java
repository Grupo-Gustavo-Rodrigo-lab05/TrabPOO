package com.mygdx.game.Inimigos;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import javax.xml.soap.Text;

public abstract class Inimigo extends ApplicationAdapter {
    protected int velocidade;
    protected int vida;
    Texture imagemInimigo;
    private Rectangle local;

    public void recebeDano(int dano) {
        vida -= dano;
        if(vida <= 0)
            morre();
    }

    private void morre() {

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
