package com.mygdx.game.Torre;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.Efeito.EfeitoFogo;

public class TorreFogo extends Torre {
    public TorreFogo(int x, int y){
        super(x, y);
        tipo = 'F';
        efeito = new EfeitoFogo();
    }

    @Override
    public void create(){
        imagemTorre = new Texture("TorreFogo.png");
    }


}
