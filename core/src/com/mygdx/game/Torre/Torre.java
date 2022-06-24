package com.mygdx.game.Torre;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;

public abstract class Torre extends ApplicationAdapter implements TorreInterface {
    int x;
    int y;
    Texture imagemTorre;
    float dano;

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

    public float efeitoTorre(){
        return dano;
    }

    public Texture imagemTorre(){
        return imagemTorre;
    }
}
