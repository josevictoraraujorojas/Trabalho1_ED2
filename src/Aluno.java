/*
Aluno: Jose Victor Araujo Rojas
Disciplina: Estrutura de Dados
Data de codificacao: 08/03/24
Objetivo da classe: Pretende armazenar os dados do aluno
 */

public class Aluno {
    private String matricula;
    private int nota;

    public Aluno(String matricula, int nota) throws Exception {
        setMatricula(matricula);
        setNota(nota);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) throws Exception {
        if (nota>=0&&nota<=10){
            this.nota = nota;
        }else {
            throw new Exception("nota invalida");
        }
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + getMatricula() + '\'' +
                ", nota=" + getNota() +
                '}';
    }
}
