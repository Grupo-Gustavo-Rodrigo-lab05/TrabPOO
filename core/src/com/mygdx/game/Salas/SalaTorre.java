package com.mygdx.game.Salas;

import com.mygdx.game.Torre.TorreBasica;

//Sala que pode conter uma Torre
public class SalaTorre extends SalaBasica {
    private TorreBasica torre;

    public SalaTorre(int x, int y, TorreBasica torre) {
        super(x, y);
        setTorre(torre);
        tipo = 'T';;
    }

    @Override
    public TorreBasica getTorre() {
        return torre;
    }

    @Override
    public void setTorre(TorreBasica torre) {
        this.torre = torre;
    }
}
