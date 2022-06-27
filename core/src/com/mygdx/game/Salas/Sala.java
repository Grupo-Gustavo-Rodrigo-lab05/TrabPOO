package com.mygdx.game.Salas;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Efeito.EfeitoBasico;
import com.mygdx.game.Inimigos.InimigoBasico;
import com.mygdx.game.Torre.TorreBasica;

//Interface contendo todos os métodos de uma Sala que são 'public' (podem ser acessados de fora)
public interface Sala {
    //Métodos gerais
    int getX();
    int getY();
    char getTipo();
    Rectangle getRec();
    void setRec(Rectangle rec);

    //Métodos SalaCaminho
    void adicionaEfeito(EfeitoBasico efeito);
    void removeEfeito(EfeitoBasico efeito);
    void adicionaInimigo(InimigoBasico inimigo);
    void removeInimigo(InimigoBasico enemy);
    void darDano();

    //Métodos SalaTorre
    TorreBasica getTorre();
    void setTorre(TorreBasica torre);
}