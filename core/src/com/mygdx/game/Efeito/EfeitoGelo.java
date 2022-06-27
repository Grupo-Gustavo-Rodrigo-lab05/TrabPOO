package com.mygdx.game.Efeito;

import com.badlogic.gdx.graphics.Texture;
import static com.badlogic.gdx.math.MathUtils.random;

public class EfeitoGelo extends EfeitoBasico {
    public EfeitoGelo() {
        id =  random.nextInt(100);
        dano = 10;
        create();
    }

    @Override
    public void create() {
        imagemEfeito = new Texture("EfeitoGelo.png");
    }
}
