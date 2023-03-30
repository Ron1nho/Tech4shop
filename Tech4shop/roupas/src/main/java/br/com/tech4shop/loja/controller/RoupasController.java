package br.com.tech4shop.loja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4shop.loja.service.RoupaService;
import br.com.tech4shop.loja.shared.RoupaCompletoDto;
import br.com.tech4shop.loja.shared.RoupaDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/catalogo")
public class RoupasController {
  @Autowired
  private RoupaService servico;
  

  @PostMapping
  public ResponseEntity<RoupaCompletoDto> cadastrarRoupa(@RequestBody @Valid RoupaCompletoDto roupa){
    return new ResponseEntity<>(servico.cadastrar(roupa), HttpStatus.CREATED); 
  }

  @GetMapping
  public ResponseEntity<List<RoupaCompletoDto>> obterCatalogo() {
    return new ResponseEntity<>(servico.verTodas(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RoupaDto> vizualizarRoupa(@PathVariable String id) {
    Optional<RoupaDto> retorno = servico.visualizarPorId(id);

    if (retorno.isPresent()) {
      return new ResponseEntity<>(retorno.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removerRoupa(@PathVariable String id){
    servico.excluirPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  public ResponseEntity<RoupaCompletoDto> atualizarRoupa(@PathVariable String id, @RequestBody RoupaCompletoDto roupa){
    Optional<RoupaCompletoDto> retorno = servico.atualizarPorId(id, roupa); 

    if (retorno.isPresent()) {
      return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
   
  }

  @GetMapping("/porta")
  public String obterPorta(@Value("${local.server.port}") String porta){
    return "A instância que respondeu a requisição está rodando na porta" + porta;
  }
  
}
