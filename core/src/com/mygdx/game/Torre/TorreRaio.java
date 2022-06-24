package com.mygdx.game.Torre;

import com.badlogic.gdx.graphics.Texture;

public class TorreRaio extends Torre {

    public TorreRaio(int x, int y){
        super(x, y);
    }

    @Override
    public void create(){
        imagemTorre = new Texture("TorreRaio.png");
    }

}

