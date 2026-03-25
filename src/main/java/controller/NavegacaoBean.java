


package controller; 

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class NavegacaoBean implements Serializable {

    public String irDepartamentos() {
        return "departamentos?faces-redirect=true";
    }

    public String irFuncionarios() {
        return "funcionarios?faces-redirect=true";
    }
}

