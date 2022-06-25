package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;

public class Efeito extends ApplicationAdapter {
    private int id;
    private float dano;
    private Texture imagemEfeito;

    public Efeito(){
        dano = 200;
        create();
        id = 1;
    }

    public int getId() {
        return this.id;
    }

    public float getDano(){
        return dano;
    }

    public Texture getImagemEfeito(){
        return imagemEfeito;
    }
    public void create(){
        imagemEfeito = new Texture("EfeitoFogo.png");
    }
}
