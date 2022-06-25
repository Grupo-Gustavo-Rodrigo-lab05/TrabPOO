package com.mygdx.game.Torre;

import com.badlogic.gdx.graphics.Texture;

public class TorreVazia extends Torre{

    public TorreVazia(int x, int y){
        super(x, y);
        tipo = 'V';
    }

    @Override
    public void create(){
        imagemTorre = new Texture("vazio.png");
    }

}

