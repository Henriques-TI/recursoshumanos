package modelo;

public class Departamento {

    private int id_departamento;
    private String nome;
    private String descricao;

    public Departamento() {

    }

    public Departamento(int id_departamento, String nome, String descricao) {
        this.id_departamento = id_departamento;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Departamento(String nome, String descricao) {
        super();
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id_departamento;
    }

    public void setId(int id) {
        this.id_departamento = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
