# Projeto `Tower Defense`

# Descrição Resumida do Projeto/Jogo
O jogo consiste em um arcade do tipo TowerDefense, em que o jogador deve enfrentar hordas de inimigos e impedir que cheguem em seu tesouro. Para fazer isso, ele pode
comprar torres de defesa, que nesse jogo são representados como Golems, e elas irão atacar os inimigos. Ouro é ganho a cada inimigo morto e é usado para comprar mais
torres. Assim, o jogador  deve  sobreviver 10 ondas e derrotar 2 inimigos do tipo Boss para vencer.

# Equipe
* `Gustavo Molino Teixeira Alves` - `247144`
* `Rodrigo Botelho Zuiani` - `245244`

# Arquivo Executável do Jogo

[Executável](https://github.com/Grupo-Gustavo-Rodrigo-lab05/TrabPOO/blob/main/src/TrabPOO/desktop/build/libs/desktop-1.0.jar)

# Slides do Projeto

## Slides da Prévia
[Slides Prévia](https://github.com/Grupo-Gustavo-Rodrigo-lab05/TrabPOO/blob/main/assets/ApresentaçãoPrévia.pptx)

## Slides da Apresentação Final
[Slides Final](https://github.com/Grupo-Gustavo-Rodrigo-lab05/TrabPOO/blob/main/assets/ApresentaçãoFinal.pptx)

## Relatório de Evolução

> Relatório de evolução, descrevendo as evoluções do design do projeto, dificuldades enfrentadas, mudanças de rumo, melhorias e lições aprendidas. Referências aos diagramas e recortes de mudanças são bem-vindos.

# Destaques de Código

> Escolha trechos relevantes e/ou de destaque do seu código. Apresente um recorte (você pode usar reticências para remover partes menos importantes). Veja como foi usado o highlight de Java para o código.

~~~java
// Recorte do seu código
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~

# Destaques de Orientação a Objetos
>Buscamos durante todo o código usar polimorfismo de modo que, Salas, inimigos e efeitos possuem todos um interface e uma classe abstrata, desse modo, declaramos sempre apenas a classe abstrata e instanciamos o objeto em um dos filhos de modo espeficico.
Exemplo de declaração abstrata das salas:
Imagem que mostra organização das classes com Interface-Classe abstrata(Implementa Interface)-Classes filhas( Extendem a abstrata)

![classe](assets/image.png)
## Diagrama de Classes usada no destaque OO:
![classe2](assets/DiagramaClasses.png)
## Código do Destaque OO
~~~java
public Mapa() {
        this.salas = new SalaBasica[9][5];

        //Gera uma matriz de salas que será o mapa no BackEnd
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 5; j++)
                if (i == 1 || i == 3|| i == 5) {
                    if (j == 1 || j == 3)
                        salas[i][j] = new SalaTorre(i, j, new TorreVazia(i, j));
                    else if ((j == 2 || j == 4) && (i == 1 || i == 5))
                        salas[i][j] = new SalaPedra(i, j);
                    else if ((j == 0 || j == 2) && i == 3)
                        salas[i][j] = new SalaPedra(i, j);
                    else
                        salas[i][j] = new SalaCaminho(i, j);
                }
                else
                    salas[i][j] = new SalaCaminho(i, j);
    }
~~~
Sala declarando seus efeitos e inimigos
~~~java
public class SalaCaminho extends SalaBasica {
    private Array<InimigoBasico> enemies;
    protected EfeitoBasico[] efeitos;
    public SalaCaminho(int x, int y) {
        super(x, y);
        enemies = new Array<InimigoBasico>();
        tipo = 'C';
        this.efeitos = new EfeitoBasico[2];
        for(int j = 0; j < 2; j++)
            efeitos[j] = null;
    }
~~~~

# Destaques de Pattern
> Os principais Patterns adotados pela equipe foram o Observer Pattern e o Adpater Pattern

## Diagrama do Pattern
Observer Pattern para salas e inimigos
![Observer1](assets/PatternObserverSalas.png)

Observer Pattern para torres
![Observer2](assets/PatternObserverTorres.png)

Adapter Pattern Inimigos
![Adapter1](assets/PatternAdapterInimigos.png)

Adapter Pattern torres
![Adapter1](assets/PatternAdapterTorres.png)
## Código do Pattern
> Código do Observer Pattern para dar dano nos inimigos - A gameScreen fica o tempo todo verificando a posição dos inimigos vs a posição das salas. Caso ocorra sobreposição ela chama o método darDano da sala e dá dano nos inimigos.
~~~java
for (int linha = 0; linha < 7; linha ++) {
            for (int coluna = 0; coluna < 5; coluna++) {
                if(mapa.getSalas(linha, coluna).getTipo() == 'C') {
                    for (Iterator<InimigoBasico> it = enemies.iterator(); it.hasNext();) {
                        InimigoBasico enemy = it.next();
                        if (mapa.getSalas(linha, coluna).getRec().contains(enemy.getRec().x, enemy.getRec().y)) {
                            mapa.getSalas(linha, coluna).adicionaInimigo(enemy);
                            mapa.getSalas(linha, coluna).darDano();
                            if(enemy.morre()) {
                                it.remove();
                                enemy.getImagemInimigo().dispose();
                                ouro += enemy.getGoldDrop();
                            }
                        }
                        else {
                            mapa.getSalas(linha, coluna).removeInimigo(enemy);
                        }
                    }
                }
            }
        }
~~~
> Codigo do Observer Pattern para torres - A GameScreen Verifica o tempo todo a torre que está contida naquela sala e aplica os efeitos decorrentes dessa torre.
~~~java
for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if(mapa.getSalas(i, j).getTipo() == 'T') {
                    if (mapa.getSalas(i, j).getTorre().getTorreTipo() != 'V') {
                        for (int m = -1; m <= 1; m++) {
                            for (int z = -1; z <= 1; z++) {
                                if (mapa.getSalas(i + m, j + z).getTipo() == 'C' && Math.abs(m) != Math.abs(z)) {
                                    mapa.getSalas(i + m, j + z).adicionaEfeito(mapa.getSalas(i, j).getTorre().getEfeitoTorre());
                                    batch.draw(mapa.getSalas(i, j).getTorre().getEfeitoTorre().getImagemEfeito(), mapa.getSalas(i + m, j + z).getRec().x, mapa.getSalas(i + m, j + z).getRec().y);
                                }
                            }
                        }
                        ...
~~~
> Código do Adapter Inimigos - Note que primeiro declaramos o Rectangle, e depois aplicamos a ele determinado inimigo especifico, sendo que qualquer inimigo pode se adaptar a ele.
~~~java
for (MapObject object : tiledMap.getLayers().get("Spawn").getObjects()) {
                Rectangle Spawn = ((RectangleMapObject) object).getRectangle();
                InimigoBasico enemy;
                if (ondas[ondasI][ondasJ] == 'F')
                    enemy = new InimigoFaca();
                else if (ondas[ondasI][ondasJ] == 'M')
                    enemy = new InimigoMorcego();
                else if (ondas[ondasI][ondasJ] == 'A')
                    enemy = new InimigoArmadura();
                else if (ondas[ondasI][ondasJ] == 'O')
                    enemy = new InimigoOgro();
                else if (ondas[ondasI][ondasJ] == 'G')
                    enemy = new InimigoGolem();
                else
                    enemy = new InimigoEsqueleto();
~~~

>Código do Adapter Torres - Note que cada sala se associa a um Rectangle, e qualquer torre pode se adaptar nesse Rectangle, dependendo apenas da torre que está contidade dentro da sala
~~~java
for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 5; j++) {
                    if (mapa.getSalas(i, j).getTipo() == 'T' && mapa.getSalas(i, j).getTorre().getTorreTipo() != 'V') {
                        batch.draw(mapa.getSalas(i, j).getTorre().getImagemTorre(), mapa.getSalas(i, j).getRec().x, mapa.getSalas(i, j).getRec().y);
                    }
                }
            }
~~~

# Conclusões e Trabalhos Futuros

Por fim, o grupo concluiu que conseguimos entregar um jogo satisfatório, atendendo quase completamente nossa proposta inicial. Reconhecemos que, dado mais tempo, poderíamos ter dedicado mais à aparência do jogo, deixando certas partes mais bonitas e implementando telas adaptáveis à opção de tela cheia, que é algo que nós aprendemos a fazer mas não tivemos tempo suficiente para implementar..
Além disso, conforme trabalhávamos com a framework libgdx, adquirimos certos entendimentos e conhecimentos que, caso tivéssemos antes, poderíamos ter deixado nossa arquitetura mais elegante. O principal exemplo disso é o caso da separação entre as partes View e Controller do nosso projeto. Primeiramente, implementamos nossas Screens de modo que elas mesmas são responsáveis por monitorar e controlar as ações do jogador na tela, além do funcionamento geral do jogo, já que essa é a maneira mais simples de implementar uma tela pelo libgdx. Porém, aprendemos posteriormente que é possível criar classes que vão agir como controladores das Screens, e elas é que ficam responsáveis por administrar as ações do usuário e o decorrer do jogo. Desse modo, podemos definir mais claramente e separar melhor a View e o Controller em nossa arquitetura. Porém, ao termos feito essa descoberta, não tínhamos tempo de implementar a mudança, mas esse seria o principal ponto a melhorar para um futuro projeto.
Por fim, gostaríamos também de termos elaborado melhor a parte de tratamento de exceções em nosso projeto. Como essa foi uma das últimas matérias aprendidas em sala, reconhecemos sua importância mas não conseguimos trabalhá-la conforme desejado. Assim, esse seria um ponto crucial de aprimoração em futuros projetos.


# Documentação dos Componentes

O vídeo a seguir apresenta um detalhamento de um projeto baseado em componentes:

[![Projeto baseado em Componentes](http://img.youtube.com/vi/1LcSghlin6o/0.jpg)](https://youtu.be/1LcSghlin6o)

# Diagramas

## Diagrama Geral da Arquitetura do Jogo

![Arquitetura](https://user-images.githubusercontent.com/101989884/176222653-ccb56d40-f078-4be6-8d60-1c398627fe47.png)

> Faça uma breve descrição do diagrama.

## Diagrama Geral de Componentes

> Se você adotou componentes de software, apresente a documentação de componentes conforme o modelo.

### Exemplo 1

Este é o diagrama compondo componentes para análise:

![Diagrama Analise](diagrama-componentes-analise.png)

### Exemplo 2

Este é um diagrama inicial do projeto de jogos:

![Diagrama Jogos](diagrama-componentes-jogos.png)

### Exemplo 3

Este é outro diagrama de um projeto de vendas:

![Diagrama Vendas](diagrama-componentes-vendas.png)

Para cada componente será apresentado um documento conforme o modelo a seguir:

## Componente `<Nome do Componente>`

> Resumo do papel do componente e serviços que ele oferece.

![Componente](diagrama-componente.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `<nome dos membros que criaram o componente>`
Interfaces | `<listagem das interfaces do componente>`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

## Detalhamento das Interfaces

### Interface `<nome da interface>`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

## Exemplo:

### Interface `ITableProducer`

Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

~~~java
public interface ITableProducer {
  String[] requestAttributes();
  String[][] requestInstances();
}
~~~

Método | Objetivo
-------| --------
`requestAttributes` | Retorna um vetor com o nome de todos os atributos (colunas) da tabela.
`requestInstances` | Retorna uma matriz em que cada linha representa uma instância e cada coluna o valor do respectivo atributo (a ordem dos atributos é a mesma daquela fornecida por `requestAttributes`.

### Interface `IDataSetProperties`

Define o recurso (usualmente o caminho para um arquivo em disco) que é a fonte de dados.

~~~java
public interface IDataSetProperties {
  public String getDataSource();
  public void setDataSource(String dataSource);
}
~~~

Método | Objetivo
-------| --------
`getDataSource` | Retorna o caminho da fonte de dados.
`setDataSource` | Define o caminho da fonte de dados, informado através do parâmetro `dataSource`.

# Plano de Exceções

## Diagrama da hierarquia de exceções
> Elabore um diagrama com a hierarquia de exceções como detalhado a seguir.

![Hierarquia Exceções](exception-hierarchy.png)

## Descrição das classes de exceção

> Monte uma tabela descritiva seguindo o exemplo:

Classe | Descrição
----- | -----
DivisaoInvalida | Engloba todas as exceções de divisões não aceitas.
DivisaoInutil | Indica que a divisão por 1 é inútil.
DivisaoNaoInteira | Indica uma divisão não inteira.
