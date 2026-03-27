package modelo;

import java.util.Date;

public class ResponsavelBuscaAluno {

    private Integer idResponsavel;
    private String nomeResponsavel;
    private String sobrenomeResponsavel;
    private Date dataNascimentoResponsavel;
    private String casaResponsavel;
    private String ruaResponsavel;
    private String bairroResponsavel;
    private String telefoneResponsavel;
    private Date dataRegistoResponsavel;

    public ResponsavelBuscaAluno() {
    }

    public ResponsavelBuscaAluno(Integer idResponsavel, String nomeResponsavel, String sobrenomeResponsavel, Date dataNascimentoResponsavel, String casaResponsavel, String ruaResponsavel, String bairroResponsavel, String telefoneResponsavel, Date dataRegistoResponsavel) {
        this.idResponsavel = idResponsavel;
        this.nomeResponsavel = nomeResponsavel;
        this.sobrenomeResponsavel = sobrenomeResponsavel;
        this.dataNascimentoResponsavel = dataNascimentoResponsavel;
        this.casaResponsavel = casaResponsavel;
        this.ruaResponsavel = ruaResponsavel;
        this.bairroResponsavel = bairroResponsavel;
        this.telefoneResponsavel = telefoneResponsavel;
        this.dataRegistoResponsavel = dataRegistoResponsavel;
    }

    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getSobrenomeResponsavel() {
        return sobrenomeResponsavel;
    }

    public void setSobrenomeResponsavel(String sobrenomeResponsavel) {
        this.sobrenomeResponsavel = sobrenomeResponsavel;
    }

    public Date getDataNascimentoResponsavel() {
        return dataNascimentoResponsavel;
    }

    public void setDataNascimentoResponsavel(Date dataNascimentoResponsavel) {
        this.dataNascimentoResponsavel = dataNascimentoResponsavel;
    }

    public String getCasaResponsavel() {
        return casaResponsavel;
    }

    public void setCasaResponsavel(String casaResponsavel) {
        this.casaResponsavel = casaResponsavel;
    }

    public String getRuaResponsavel() {
        return ruaResponsavel;
    }

    public void setRuaResponsavel(String ruaResponsavel) {
        this.ruaResponsavel = ruaResponsavel;
    }

    public String getBairroResponsavel() {
        return bairroResponsavel;
    }

    public void setBairroResponsavel(String bairroResponsavel) {
        this.bairroResponsavel = bairroResponsavel;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(String telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public Date getDataRegistoResponsavel() {
        return dataRegistoResponsavel;
    }

    public void setDataRegistoResponsavel(Date dataRegistoResponsavel) {
        this.dataRegistoResponsavel = dataRegistoResponsavel;
    }
}
