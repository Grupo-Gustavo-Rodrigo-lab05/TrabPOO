package com.mygdx.game.Torre;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Efeito;

public abstract class Torre extends ApplicationAdapter implements TorreInterface {
    int x;
    int y;
    Texture imagemTorre;
    float dano;
    Efeito efeito;
    char tipo;

    public Torre(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Efeito getEfeitoTorre(){
        return efeito;
    }

    public char TorreTipo(){
        return tipo;
    }

    public Texture imagemTorre(){
        return imagemTorre;
    }
}
