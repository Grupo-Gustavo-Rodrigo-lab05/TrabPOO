package com.mygdx.game.Torre;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Efeito.EfeitoPedra;

public class TorrePedra extends Torre {

    public TorrePedra(int x, int y){
        super(x, y);
        tipo = 'R';
        efeito = new EfeitoPedra();
        create();
    }

    @Override
    public void create(){
        imagemTorre = new Texture("TorrePedra.png");
    }

}

