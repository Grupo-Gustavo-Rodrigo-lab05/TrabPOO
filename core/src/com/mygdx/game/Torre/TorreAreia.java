package com.mygdx.game.Torre;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Efeito.EfeitoAreia;
import com.mygdx.game.Efeito.EfeitoFogo;

public class TorreAreia extends Torre{
    public TorreAreia(int x, int y){
        super(x, y);
        tipo = 'A';
        efeito = new EfeitoAreia();
        create();
    }

    @Override
    public void create(){
        imagemTorre = new Texture("TorreAreia.png");
    }
}
