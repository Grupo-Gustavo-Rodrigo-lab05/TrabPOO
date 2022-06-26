package com.mygdx.game.Efeito;

import com.badlogic.gdx.graphics.Texture;

public class EfeitoFogo extends Efeito{

    public EfeitoFogo() {
        dano = 200;
        id = 1;
        create();
    }

    public void create(){
        imagemEfeito = new Texture("EfeitoFogo.png");
    }

}
