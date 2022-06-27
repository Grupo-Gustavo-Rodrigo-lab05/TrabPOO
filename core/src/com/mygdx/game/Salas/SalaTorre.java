package com.mygdx.game.Salas;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Efeito.Efeito;
import com.mygdx.game.Inimigos.Inimigo;
import com.mygdx.game.Torre.Torre;
import com.mygdx.game.Torre.TorreFogo;

public class SalaTorre extends SalaBasica{
    private Torre torre;
    Rectangle salaFront;
    public SalaTorre(int x, int y, Torre torre) {
        super(x, y);
        setTorre(torre);
        tipo = 'T';;
    }

    public Torre getTorre(){
        return torre;
    }

    public Rectangle getRec() {
        return salaFront;
    }

    @Override
    public void retiraEfeito(Efeito efeito) {

    }

    @Override
    public void darDano() {

    }

    public void setRec(Rectangle rec){
        this.salaFront = rec;
    }


    @Override
    public void setTorre(Torre torre) {
        this.torre = torre;
    }

    @Override
    public void addInimigo(Inimigo inimigo) {

    }

    @Override
    public Inimigo[] getInimigo() {
        return null;
    }


    @Override
    public void remove() {
    }

}
