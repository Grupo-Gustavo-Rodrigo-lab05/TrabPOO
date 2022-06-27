package com.mygdx.game.Inimigos;

import com.badlogic.gdx.graphics.Texture;

public class InimigoZumbi extends Inimigo{

    public InimigoZumbi(){
        vida = 100000;
        velocidade = 100;
        create();
    }
    public void create() {
        imagemInimigo = new Texture("inimigo1.png");
    }
}
