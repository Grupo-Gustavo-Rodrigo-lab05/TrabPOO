package com.mygdx.game.Torre;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Efeito.EfeitoBasico;

//Classe anstrata contendo os métodos básicos das Torres
public abstract class TorreBasica extends ApplicationAdapter implements Torre {
    protected int x;
    protected int y;
    protected char tipo;
    protected Texture imagemTorre;
    protected EfeitoBasico efeito;

    public TorreBasica(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getTorreTipo() {
        return tipo;
    }

    public EfeitoBasico getEfeitoTorre() {
        return efeito;
    }

    public Texture getImagemTorre(){
        return imagemTorre;
    }

    public abstract void create();
}
