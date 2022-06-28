package com.mygdx.game.Efeito;

import com.badlogic.gdx.graphics.Texture;
import static com.badlogic.gdx.math.MathUtils.random;

public class EfeitoAreia extends EfeitoBasico {
    public EfeitoAreia() {
        id =  random.nextInt(100);
        dano = 5;
        create();
    }

    @Override
    public void create() {
        imagemEfeito = new Texture("EfeitoAreia.png");
    }
}
