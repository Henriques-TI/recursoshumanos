package skylink.mglcreche.mb;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import skylink.mglcreche.dao.ResponsavelBuscaAlunoDAO;
import skylink.mglcreche.modelo.ResponsavelBuscaAluno;

@Named(value = "responsavelBean")
@SessionScoped
public class ResponsavelBuscaAlunoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ResponsavelBuscaAluno responsavel;
    private ResponsavelBuscaAlunoDAO responsavelDAO;
    private List<ResponsavelBuscaAluno> listaResponsaveis;

    public ResponsavelBuscaAlunoBean() {
    }

    @PostConstruct
    public void init() {
        responsavel = new ResponsavelBuscaAluno();
        responsavelDAO = new ResponsavelBuscaAlunoDAO();
        listaResponsaveis = new ArrayList<>();
        this.listaResponsaveis = responsavelDAO.findAll(); // Carrega a lista ao iniciar
    }

    public String salvar() {
        if (responsavelDAO.save(responsavel)) {
            this.listaResponsaveis = responsavelDAO.findAll(); // Atualiza a lista após salvar
            responsavel = new ResponsavelBuscaAluno();
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxSucesso");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso ao Guarda", "Sucesso ao guardar os dados"));
            return "/responsavelbusca/index_responsavel_busca_aluno.faces?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Guardar", "Erro ao guardar os dados"));
            System.err.println("errrrrrrrrrrrrrrrrrrrrrrrrrro");
            return null;
        }
    }

    public void atualizar() {
        if (responsavelDAO.update(responsavel)) {
            this.listaResponsaveis = responsavelDAO.findAll(); // Atualiza a lista após atualizar
            novo();
        }
    }

    public void eliminar() {
        if (responsavelDAO.delete(responsavel)) {
            this.listaResponsaveis = responsavelDAO.findAll(); // Atualiza a lista após eliminar
            novo();
        }
    }

    public String novo() {
        responsavel = new ResponsavelBuscaAluno();
        return "cadastroResponsavel?faces-redirect=true";
    }

    public String listar() {
        this.listaResponsaveis = responsavelDAO.findAll(); // Garante a atualização da lista ao navegar para ela
        return "listaResponsavel?faces-redirect=true";
    }

    public ResponsavelBuscaAluno getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(ResponsavelBuscaAluno responsavel) {
        this.responsavel = responsavel;
    }

    public List<ResponsavelBuscaAluno> getListaResponsaveis() {
        return listaResponsaveis;
    }

    public void setListaResponsaveis(List<ResponsavelBuscaAluno> listaResponsaveis) {
        this.listaResponsaveis = listaResponsaveis;
    }
}
