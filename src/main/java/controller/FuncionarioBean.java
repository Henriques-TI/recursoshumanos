package controller;

import dao.FuncionarioDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import modelo.Funcionario;

@Named(value = "funcionarioBean")
@SessionScoped

public class FuncionarioBean implements Serializable {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private List<Funcionario> funcionarios;
    private Funcionario funcionario = new Funcionario();

    @PostConstruct
    public void init() {
        funcionarios = funcionarioDAO.selectAllFuncionarios();
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String guardarDados() {
        funcionarioDAO.insertFuncionario(funcionario);
        return "funcionario?faces-redirect=true";
    }
}
