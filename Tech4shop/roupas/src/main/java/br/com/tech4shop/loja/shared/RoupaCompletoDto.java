package br.com.tech4shop.loja.shared;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class RoupaCompletoDto {
  private String id;
  private String nome;

  @NotEmpty(message= "Preencha a cor da camisa")
  @NotBlank(message= "Tem que ser informado caracteres")
  private String cor;

  @Size(min=1, max=2, message="Informe o tamanho: P, M, G ou GG")
  private String tamanho;

  @NotEmpty(message= "Preencha qual o tecido da camisa")
  @NotBlank(message= "Tem que ser informado caracteres")
  private String tecido;

  @NotEmpty(message= "Preencha qual a marca da camisa")
  @NotBlank(message= "Tem que ser informado caracteres")
  private String marca;

  @NotNull
  @Positive(message= "Valor deve ser informado")
  private Double valor;
  
  
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }  
  public String getCor() {
    return cor;
  }
  public void setCor(String cor) {
    this.cor = cor;
  }
  public String getTamanho() {
    return tamanho;
  }
  public void setTamanho(String tamanho) {
    this.tamanho = tamanho;
  }
  public String getTecido() {
    return tecido;
  }
  public void setTecido(String tecido) {
    this.tecido = tecido;
  }
  public String getMarca() {
    return marca;
  }
  public void setMarca(String marca) {
    this.marca = marca;
  }
  public Double getValor() {
    return valor;
  }
  public void setValor(Double valor) {
    this.valor = valor;
  }
   
}
 

