package com.mygdx.game.Efeito;

import com.badlogic.gdx.graphics.Texture;

import static com.badlogic.gdx.math.MathUtils.random;

public class EfeitoFogo extends Efeito{

    public EfeitoFogo() {
        dano = 20;
        id =  random.nextInt(100);;
        create();
    }

    public void create(){
        imagemEfeito = new Texture("EfeitoFogo.png");
    }

}
