package com.mygdx.game.Efeito;

import com.badlogic.gdx.graphics.Texture;
import static com.badlogic.gdx.math.MathUtils.random;

public class EfeitoPedra extends EfeitoBasico {
    public EfeitoPedra() {
        id =  random.nextInt(100);
        dano = 15;
        create();
    }

    @Override
    public void create() {
        imagemEfeito = new Texture("EfeitoPedra.png");
    }
}
