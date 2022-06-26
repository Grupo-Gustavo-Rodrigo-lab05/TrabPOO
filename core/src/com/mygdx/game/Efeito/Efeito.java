package com.mygdx.game.Efeito;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;

public class Efeito extends ApplicationAdapter {
    protected float dano;
    protected Texture imagemEfeito;
    protected int id;

    public int getId() {
        return this.id;
    }

    public float getDano(){
        return dano;
    }

    public Texture getImagemEfeito(){
        return imagemEfeito;
    }

}
