package com.mygdx.game.Torre;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Efeito.EfeitoFogo;
import com.mygdx.game.Efeito.EfeitoGelo;

public class TorreGelo extends Torre{

    public TorreGelo(int x, int y){
        super(x, y);
        tipo = 'G';
        efeito = new EfeitoGelo();
    }

    @Override
    public void create(){
        imagemTorre = new Texture("TorreGelo.png");
    }
}
