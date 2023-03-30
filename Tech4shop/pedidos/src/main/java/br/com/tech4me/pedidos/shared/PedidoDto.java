package br.com.tech4me.pedidos.shared;

import br.com.tech4me.pedidos.model.Roupa;

public class PedidoDto {
    private String nomeCliente;
    private String idRoupa;
    private Double valor;
    private Roupa dadosRoupa;

    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getIdRoupa() {
    return idRoupa;
    }
    public void setIdRoupa(String idRoupa) {
    this.idRoupa = idRoupa;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Roupa getDadosRoupa() {
    return dadosRoupa;
    }
    public void setDadosRoupa(Roupa dadosRoupa) {
    this.dadosRoupa = dadosRoupa;
    }
    
    public void setDadosRoupa(String idRoupa2) {
    }
}
