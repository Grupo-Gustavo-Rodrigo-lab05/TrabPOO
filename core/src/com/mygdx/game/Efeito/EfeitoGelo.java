package com.mygdx.game.Efeito;

import com.badlogic.gdx.graphics.Texture;

import static com.badlogic.gdx.math.MathUtils.random;

public class EfeitoGelo extends Efeito{

    public EfeitoGelo() {
        dano = 50;
        id =  random.nextInt(100);;
        create();
    }

    public void create(){
        imagemEfeito = new Texture("EfeitoGelo.png");
    }
}
