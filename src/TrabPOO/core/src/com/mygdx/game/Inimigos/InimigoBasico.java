package com.mygdx.game.Inimigos;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

//Classe anstrata contendo os métodos básicos dos Inimigos
public abstract class InimigoBasico extends ApplicationAdapter implements Inimigo {
    protected int velocidade;
    protected int goldDrop;
    protected float vida;
    private Rectangle local;
    protected Texture imagemInimigo;

    public int getVelocidade() {
        return velocidade;
    }

    public int getGoldDrop() {
        return goldDrop;
    }

    public void recebeDano(float dano) {
        vida -= dano;
    }

    public boolean morre() {
        if(vida <= 0){
            return true;
        }
        return false;
    }

    public Rectangle getRec() {
        return local;
    }

    public void setRec(float x, float y) {
        local = new Rectangle();
        local.x = x;
        local.y = y;
        local.width = 64;
        local.height = 64;
    }

    public Texture getImagemInimigo() {
        return imagemInimigo;
    }

    public abstract void create();
}
