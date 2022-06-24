package com.mygdx.game.Inimigos;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;

import javax.xml.soap.Text;

public abstract class Inimigo extends ApplicationAdapter {
    protected int velocidade;
    protected int vida;
    Texture imagemInimigo;
    public void recebeDano(int dano) {
        vida -= dano;
        if(vida <= 0)
            morre();
    }

    private void morre() {

    }

    public Texture imagemInimigo(){
        return imagemInimigo;
    }

}
