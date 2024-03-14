/*
Aluno: Jose Victor Araujo Rojas
Disciplina: Estrutura de Dados
Data de codificacao: 08/03/24
Objetivo da classe: Criar a lista encadeada de alunos e fazer as operacoes de insercao, remocao e busca

 */

public class ListaAluno {
    public static class Nodo{
        Aluno item;
        Nodo proximo;

        @Override
        public String toString() {
            return "Nodo{" +
                    "item=" + item +
                    ", proximo=" + proximo +
                    '}';
        }
    }

    Nodo inicio;
    Nodo ultimo;
    int tamanho;

    public ListaAluno() {
        this.inicio= new Nodo();
        this.ultimo=inicio;
        this.tamanho=0;
    }

    public void insercao(Aluno aluno) {
        Nodo novo = new Nodo();
        novo.item = aluno;
        if (vazia()) {
            primeiraInsercao(novo);
        }else if (verificaInsercaoNoInicio(novo.item.getNota())){
            insereNoInicio(novo);
        }
        else if (verificainsercaoNoFinal(novo.item.getNota())) {
            insereNofinal(novo);
        } else {
           insereNoMeio(novo);
        }
    }

    private void insereNofinal(Nodo novo){
        this.ultimo.proximo=novo;
        this.ultimo=novo;
        this.tamanho++;
    }

    private void insereNoMeio(Nodo novo){
        Nodo anterior = this.inicio;
        Nodo atual = this.inicio.proximo;

        for (int i = 0; i < this.tamanho; i++) {
            if (novo.item.getNota() >= atual.item.getNota()) {
                tamanho++;
                anterior.proximo=novo;
                novo.proximo=atual;
                return;
            }
            anterior=atual;
            atual=atual.proximo;
        }
    }

    private void insereNoInicio(Nodo novo){
        Nodo auxiliar = this.inicio.proximo;
        this.inicio.proximo=novo;
        novo.proximo=auxiliar;
        this.tamanho++;
    }
    private void primeiraInsercao(Nodo novo){
        this.inicio.proximo=novo;
        this.ultimo=novo;
        this.tamanho++;
    }

    public boolean verificainsercaoNoFinal(int nota){
        return nota<=this.ultimo.item.getNota();
    }
    public boolean verificaInsercaoNoInicio(int nota){
        return nota>=this.inicio.proximo.item.getNota();
    }

    public String remocao(String matricula) throws Exception {
        if (vazia()){
            throw new Exception("erro lista vazia");
        }else if (verificaRemocoInicio(matricula)){
            return removeInicio();
        }else {
           return removeMeioEFim(matricula);
        }
    }

    private String removeInicio(){
        Nodo auxiliar = this.inicio.proximo;
        this.inicio.proximo=auxiliar.proximo;
        if (vazia()){
            this.ultimo=this.inicio.proximo;
        }
        this.tamanho--;
        return auxiliar.item.getMatricula();
    }

    private String removeMeioEFim(String matricula){
        Nodo atual = this.inicio.proximo;
        Nodo anterior = this.inicio;

        for (int i = 0; i < this.tamanho; i++) {
            if (matricula==atual.item.getMatricula()){
                anterior.proximo=atual.proximo;
                this.tamanho--;
                if (this.ultimo==atual){
                    this.ultimo=anterior;
                }
                return atual.item.getMatricula();
            }
            anterior =atual;
            atual=atual.proximo;
        }
        return null;
    }

    public boolean verificaRemocoInicio(String matricula){
        return matricula.equals(this.inicio.proximo.item.getMatricula());
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public boolean vazia(){
        return this.inicio.proximo==null;
    }

    public String  buscaMatricula(String matricula) throws Exception {
        if (vazia()){
            throw  new Exception("errro lista vazia");
        }
        Nodo atual = this.inicio.proximo;
        for (int i = 0; i < this.tamanho ; i++) {
            if (matricula==atual.item.getMatricula()){
                return "Matricula:"+ atual.item.getMatricula()+", Nota:"+atual.item.getNota();
            }
            atual=atual.proximo;
        }
        return null;
    }
    public int[]  buscaNota(int[] vetor) throws Exception {
        if (vazia()){
            throw  new Exception("errro lista vazia");
        }

        Nodo atual = new Nodo();
        int[] vetorQuantidadeNotas = new int[vetor.length];

        for (int i = 0; i < vetor.length; i++) {
            atual=inicio.proximo;
            for (int j = 0; j < this.tamanho ; j++) {
                if (vetor[i]==atual.item.getNota()){
                    vetorQuantidadeNotas[i]++;
                }
                atual = atual.proximo;
            }
        }
        return vetorQuantidadeNotas;
    }

    @Override
    public String toString() {
        return "ListaAluno{" +
                "inicio=" + inicio +
                ", ultimo=" + ultimo +
                ", tamanho=" + tamanho +
                '}';
    }
}
