package com.mygdx.game.Salas;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Efeito.Efeito;

//Interface contendo todas as funções basicas de uma sala//
public abstract class SalaBasica implements Sala {
    protected int x, y;
    protected char tipo;
    private Rectangle salaFront;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getTipo() {
        return tipo;
    }

    public void adicionaEfeito(Efeito efeito){

    }

    public SalaBasica(int x, int y) {
        this.x = x;
        this.y = y;
    }


}
