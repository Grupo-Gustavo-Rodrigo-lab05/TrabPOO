package com.mygdx.game.Efeito;

import com.badlogic.gdx.graphics.Texture;

import static com.badlogic.gdx.math.MathUtils.random;

public class EfeitoAreia extends Efeito{
    public EfeitoAreia() {
        dano = 5;
        id =  random.nextInt(100);;
        create();
    }

    public void create(){
        imagemEfeito = new Texture("EfeitoAreia.png");
    }

}
