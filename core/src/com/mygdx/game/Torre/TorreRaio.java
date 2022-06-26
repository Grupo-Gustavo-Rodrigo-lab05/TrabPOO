package com.mygdx.game.Torre;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Efeito.EfeitoRaio;

public class TorreRaio extends Torre {

    public TorreRaio(int x, int y){
        super(x, y);
        tipo = 'R';
        efeito = new EfeitoRaio();
    }

    @Override
    public void create(){
        imagemTorre = new Texture("TorreRaio.png");
    }

}

