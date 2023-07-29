package com.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bancos")
public class BancosDiaModel {
    private String BancoCodigo;

    private Integer BancoAgencia;

    private String BancoAgenciaDig;

    @Id
    private Integer BancoConta;

    private String BancoContaDig;

    private String BancoNome;
    private String API;
    private String BancoLiberado;
    private Integer EmpresaId;

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public String getBancoCodigo() {
        return BancoCodigo;
    }

    public void setBancoCodigo(String bancoCodigo) {
        BancoCodigo = bancoCodigo;
    }

    public Integer getBancoAgencia() {
        return BancoAgencia;
    }

    public void setBancoAgencia(Integer bancoAgencia) {
        BancoAgencia = bancoAgencia;
    }

    public String getBancoAgenciaDig() {
        return BancoAgenciaDig;
    }

    public void setBancoAgenciaDig(String bancoAgenciaDig) {
        BancoAgenciaDig = bancoAgenciaDig;
    }

    public Integer getBancoConta() {
        return BancoConta;
    }

    public void setBancoConta(Integer bancoConta) {
        BancoConta = bancoConta;
    }

    public String getBancoContaDig() {
        return BancoContaDig;
    }

    public void setBancoContaDig(String bancoContaDig) {
        BancoContaDig = bancoContaDig;
    }

    public String getBancoNome() {
        return BancoNome;
    }

    public void setBancoNome(String bancoNome) {
        BancoNome = bancoNome;
    }

    public String getBancoLiberado() {
        return BancoLiberado;
    }

    public void setBancoLiberado(String bancoLiberado) {
        BancoLiberado = bancoLiberado;
    }

    public Integer getEmpresaId() {
        return EmpresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        EmpresaId = empresaId;
    }


}