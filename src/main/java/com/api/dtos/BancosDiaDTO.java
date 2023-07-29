package com.api.dtos;

public class BancosDiaDTO {
    private String BancoCodigo;
    private String API;
    private Integer BancoAgencia;
    private Integer BancoAgenciaDig;
    private Integer BancoConta;
    private Integer BancoContaDig;
    private String BancoNome;
    private String BancoLiberado;

    private Integer EmpresaId;

    public BancosDiaDTO(String BancoCodigo, String API, Integer BancoAgencia, Integer BancoAgenciaDig, Integer BancoConta, Integer BancoContaDig, String BancoNome) {
        this.BancoCodigo = BancoCodigo;
        this.API = API;
        this.BancoAgencia = BancoAgencia;
        this.BancoAgenciaDig = BancoAgenciaDig;
        this.BancoConta = BancoConta;
        this.BancoContaDig = BancoContaDig;
        this.BancoNome = BancoNome;
    }

    public Integer getEmpresaId() {
        return EmpresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        EmpresaId = empresaId;
    }

    public String getBancoLiberado() {
        return BancoLiberado;
    }

    public void setBancoLiberado(String bancoLiberado) {
        BancoLiberado = bancoLiberado;
    }

    public String getBancoCodigo() {
        return BancoCodigo;
    }

    public void setBancoCodigo(String BancoCodigo) {
        this.BancoCodigo = BancoCodigo;
    }

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public Integer getBancoAgencia() {
        return BancoAgencia;
    }

    public void setBancoAgencia(Integer BancoAgencia) {
        this.BancoAgencia = BancoAgencia;
    }

    public Integer getBancoAgenciaDig() {
        return BancoAgenciaDig;
    }

    public void setBancoAgenciaDig(Integer BancoAgenciaDig) {
        this.BancoAgenciaDig = BancoAgenciaDig;
    }

    public Integer getBancoConta() {
        return BancoConta;
    }

    public void setBancoConta(Integer BancoConta) {
        this.BancoConta = BancoConta;
    }

    public Integer getBancoContaDig() {
        return BancoContaDig;
    }

    public void setBancoContaDig(Integer BancoContaDig) {
        this.BancoContaDig = BancoContaDig;
    }

    public String getBancoNome() {
        return BancoNome;
    }

    public void setBancoNome(String BancoNome) {
        this.BancoNome = BancoNome;
    }
}
