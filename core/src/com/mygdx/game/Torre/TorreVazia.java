package com.mygdx.game.Torre;

//Classe que representa o espaço de Torre Vazio
public class TorreVazia extends TorreBasica {
    public TorreVazia(int x, int y) {
        super(x, y);
        tipo = 'V';
    }

    @Override
    public void create() { }
}

