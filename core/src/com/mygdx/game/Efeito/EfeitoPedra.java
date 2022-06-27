package com.mygdx.game.Efeito;

import com.badlogic.gdx.graphics.Texture;

import static com.badlogic.gdx.math.MathUtils.random;

public class EfeitoPedra extends Efeito{

    public EfeitoPedra() {
        dano = 15;
        id =  random.nextInt(100);;
        create();
    }

    public void create(){
        imagemEfeito = new Texture("EfeitoPedra.png");
    }
}
