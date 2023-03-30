package br.com.tech4shop.loja.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.tech4shop.loja.model.Roupa;
import br.com.tech4shop.loja.repository.RoupaRepository;
import br.com.tech4shop.loja.shared.RoupaCompletoDto;
import br.com.tech4shop.loja.shared.RoupaDto;

@Service
public class RoupaServiceImpl implements RoupaService {
  @Autowired
  private RoupaRepository repositorio;

  @Override
  public List<RoupaCompletoDto> verTodas() {
    List<Roupa> roupas = repositorio.findAll();
    
    return roupas.stream()
                .map(r -> new ModelMapper().map(r, RoupaCompletoDto.class))
                .collect(Collectors.toList());
  }

  @Override
  public Optional<RoupaDto> visualizarPorId(String id) {
    Optional<Roupa> roupa  = repositorio.findById(id);

    if (roupa.isPresent()) {
      return Optional.of(new ModelMapper().map(roupa.get(), RoupaDto.class));
    }
    return Optional.empty();
  }

  @Override
  public void excluirPorId(String id) {
    repositorio.deleteById(id);
  }

  @Override
  public RoupaCompletoDto cadastrar(RoupaCompletoDto dto) {
    Roupa roupa = new ModelMapper().map(dto, Roupa.class);
    repositorio.save(roupa);
    return new ModelMapper().map(roupa, RoupaCompletoDto.class);  
  }

  @Override
  public Optional<RoupaCompletoDto> atualizarPorId(String id, RoupaCompletoDto dto) { 
    Optional<Roupa> retorno = repositorio.findById(id);

    if (retorno.isPresent()) {
      Roupa roupa = new ModelMapper().map(dto, Roupa.class);
      roupa.setId(id);
      repositorio.save(roupa);
      return Optional.of(new ModelMapper().map(roupa, RoupaCompletoDto.class));
    } else {
      return Optional.empty();
    }
    
   
  }

}
