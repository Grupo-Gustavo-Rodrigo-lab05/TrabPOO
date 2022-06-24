package com.mygdx.game.Salas;

import com.mygdx.game.Inimigos.Inimigo;
import com.mygdx.game.Torre.Torre;
import com.mygdx.game.Torre.TorreFogo;

public class SalaTorre extends SalaBasica{
    private Torre torre;

    public SalaTorre(int x, int y, Torre torre) {
        super(x, y);
        setTorre(torre);
        tipo = 'T';;
    }

    public Torre getTorre(){
        return torre;
    }

    @Override
    public void setTorre(Torre torre) {
        this.torre = torre;
    }

    @Override
    public Inimigo[] getInimigo() {
        return null;
    }
}
