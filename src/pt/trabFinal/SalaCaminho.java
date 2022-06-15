package pt.trabFinal;

public class SalaCaminho extends SalaBasica{
    protected Inimigo[] inimigos;
    protected Efeito[] efeitos;

    SalaCaminho(int x, int y) {
        super(x, y);

        tipo = 'C';
        this.inimigos = new Inimigo[20]; //TROCAR PELO MAX DE INIMIGOS EM UMA SALA
        for(int i = 0; i < 20; i++)
            inimigos[i] = null;
        this.efeitos = new Efeito[10]; //TROCAR PELO NUMERO DE EFEITOS QUE COLOCARMOS NO JOGO
        for(int j = 0; j < 10; j++)
            efeitos[j] = null;
    }

    public boolean possuiEfeito(Efeito efeito) {
        //Verifica se a sala possui o efeito em questão
        for (int i = 0; i < 10; i++) {
            if(efeitos[i].getId() == efeito.getId())
                return true;
        }
        return false;
    }

    public void adicionaEfeito(Efeito efeito) {
        if(!possuiEfeito(efeito)) {
            int i = 0;
            while (efeitos[i] != null) { //Encontra o primeiro índice vazio no vetor
                i++;
            }
            efeitos[i] = efeito;
        }
    }
}
