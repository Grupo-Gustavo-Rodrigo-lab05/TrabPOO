package com.mygdx.game.Torre;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Efeito;

public interface TorreInterface  {

    public Efeito getEfeitoTorre();
    int getX();
    int getY();
    Texture imagemTorre();
    char TorreTipo();
}
