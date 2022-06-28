package com.mygdx.game.Efeito;

import com.badlogic.gdx.graphics.Texture;
import static com.badlogic.gdx.math.MathUtils.random;

public class EfeitoFogo extends EfeitoBasico {
    public EfeitoFogo() {
        id =  random.nextInt(100);
        dano = 20;
        create();
    }

    @Override
    public void create() {
        imagemEfeito = new Texture("EfeitoFogo.png");
    }
}
