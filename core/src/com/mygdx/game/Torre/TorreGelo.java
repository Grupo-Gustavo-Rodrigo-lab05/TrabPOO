package com.mygdx.game.Torre;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Efeito.EfeitoGelo;

//Torre do elemento Fogo
public class TorreGelo extends TorreBasica {
    public TorreGelo(int x, int y){
        super(x, y);
        tipo = 'G';
        efeito = new EfeitoGelo();
        create();
    }

    @Override
    public void create() {
        imagemTorre = new Texture("TorreGelo.png");
    }
}
