package escalonador;

public class Processo {

    private String nome;
    private int PID;
    private String cargaTrabalho;
    private Estado estado;

    public Processo(String nome, int PID, String cargaTrabalho) {
        this.nome = nome;
        this.PID = PID;
        this.cargaTrabalho = cargaTrabalho;
    }

    public String getNome() {
        return nome;
    }

    public int getPID() {
        return PID;
    }

    public String getCargaTrabalho() {
        return cargaTrabalho;
    }

    public Estado getEstado() {
        return estado;
    }
}