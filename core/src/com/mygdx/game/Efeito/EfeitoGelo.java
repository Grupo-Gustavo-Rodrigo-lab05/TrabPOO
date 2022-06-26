package com.mygdx.game.Efeito;

import com.badlogic.gdx.graphics.Texture;

public class EfeitoGelo extends Efeito{

    public EfeitoGelo() {
        dano = 50;
        id = 3;
        create();
    }

    public void create(){
        imagemEfeito = new Texture("EfeitoGelo.png");
    }
}
