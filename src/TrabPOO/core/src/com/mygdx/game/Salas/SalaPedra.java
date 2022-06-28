package com.mygdx.game.Salas;

//Sala pela qual os inimigos não podem andar
public class SalaPedra extends SalaBasica {
    public SalaPedra(int x, int y) {
        super(x, y);
        tipo = 'P';
    }
}