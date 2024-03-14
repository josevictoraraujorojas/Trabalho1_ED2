/*
Aluno: Jose Victor Araujo Rojas
Disciplina: Estrutura de Dados
Data de codificacao: 08/03/24
Objetivo da classe: Testar os metodos da classe Aluno e listaAluno
 */

import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws Exception {
        ListaAluno listaAluno = new ListaAluno();
        //insercoes
        listaAluno.insercao(new Aluno("12333",1));
        listaAluno.insercao(new Aluno("12334",1));
        listaAluno.insercao(new Aluno("12335",3));
        listaAluno.insercao(new Aluno("12336",2));
        listaAluno.insercao(new Aluno("12337",4));
        listaAluno.insercao(new Aluno("12338",5));
        //imprimi
        System.out.println(listaAluno);
        //remove
        System.out.println(listaAluno.remocao("12333"));
        System.out.println(listaAluno.remocao("12334"));
        System.out.println(listaAluno.remocao("12337"));
        System.out.println(listaAluno);
        //busaca Matricula
        System.out.println(listaAluno.buscaMatricula("12336"));
        int[] vetorNotas = new int[]{1,2,10};
        System.out.println(Arrays.toString(listaAluno.buscaNota(vetorNotas)));
    }
}