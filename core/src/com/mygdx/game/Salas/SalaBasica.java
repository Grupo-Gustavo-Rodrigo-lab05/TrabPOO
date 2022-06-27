package com.mygdx.game.Salas;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Efeito.EfeitoBasico;
import com.mygdx.game.Inimigos.InimigoBasico;
import com.mygdx.game.Torre.TorreBasica;

//Classe anstrata contendo os métodos básicos das Salas
public abstract class SalaBasica implements Sala {
    protected int x, y;
    protected char tipo;
    private Rectangle salaFront;

    public SalaBasica(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getTipo() {
        return tipo;
    }

    public Rectangle getRec() {
        return salaFront;
    }

    public void setRec(Rectangle rec) {
        this.salaFront = rec;
    }

    //Métodos SalaCaminho
    public void adicionaEfeito(EfeitoBasico efeito) { }
    public void removeEfeito(EfeitoBasico efeito) { }
    public void adicionaInimigo(InimigoBasico inimigo) { }
    public void removeInimigo(InimigoBasico enemy) { }
    public void darDano() { }

    //Métodos SalaTorre
    public TorreBasica getTorre() { return null; }
    public void setTorre(TorreBasica torre) { }
}
