package com.mygdx.game.Efeito;

import com.badlogic.gdx.graphics.Texture;

public class EfeitoRaio extends Efeito{

    public EfeitoRaio() {
        dano = 150;
        id = 2;
        create();
    }

    public void create(){
        imagemEfeito = new Texture("EfeitoRaio.png");
    }
}
