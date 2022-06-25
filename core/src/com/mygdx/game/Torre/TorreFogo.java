package com.mygdx.game.Torre;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Efeito;
import com.mygdx.game.Torre.Torre;

public class TorreFogo extends Torre {
    public TorreFogo(int x, int y){
        super(x, y);
        efeito = new Efeito();
    }

    @Override
    public void create(){
        imagemTorre = new Texture("TorreFogo.png");
    }


}
