package com.mygdx.game.Torre;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Efeito.EfeitoFogo;

//Torre do elemento Fogo
public class TorreFogo extends TorreBasica {
    public TorreFogo(int x, int y){
        super(x, y);
        tipo = 'F';
        efeito = new EfeitoFogo();
        create();
    }

    @Override
    public void create() {
        imagemTorre = new Texture("TorreFogo.png");
    }
}
