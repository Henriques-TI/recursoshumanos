package controller;

import dao.DepartamentoDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import modelo.Departamento;

@Named(value = "departamentoBean")
@SessionScoped
public class DepartamentoBean implements Serializable {

    private DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    private List<Departamento> departamentos;
    private Departamento departamento = new Departamento();

    @PostConstruct
public void init() {
    departamentos = departamentoDAO.selectAllDepartamentos();
}

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public String guardarDados() {
        departamentoDAO.insertDepartamento(departamento);
        return "departamento?faces-redirect=true";
    }
    
}
