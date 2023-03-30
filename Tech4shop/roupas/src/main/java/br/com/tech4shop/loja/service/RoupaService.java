package br.com.tech4shop.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4shop.loja.shared.RoupaCompletoDto;
import br.com.tech4shop.loja.shared.RoupaDto;



public interface RoupaService {
  List<RoupaCompletoDto> verTodas();
  Optional<RoupaDto> visualizarPorId(String id);
  void excluirPorId(String id);
  RoupaCompletoDto cadastrar(RoupaCompletoDto dto);
  Optional<RoupaCompletoDto> atualizarPorId(String id, RoupaCompletoDto dto);
  
  



}
