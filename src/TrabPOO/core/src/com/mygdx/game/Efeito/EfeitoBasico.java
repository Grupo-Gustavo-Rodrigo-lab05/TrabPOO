package com.mygdx.game.Efeito;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;

public abstract class EfeitoBasico extends ApplicationAdapter implements Efeito {
    protected int id;
    protected float dano;
    protected Texture imagemEfeito;

    public int getId() {
        return id;
    }

    public float getDano() {
        return dano;
    }

    public Texture getImagemEfeito() {
        return imagemEfeito;
    }

    public abstract void create();
}
