package br.com.lukearch.stoom.restapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lukearch.stoom.restapi.controller.dto.EnderecoDto;
import br.com.lukearch.stoom.restapi.controller.form.EnderecoForm;
import br.com.lukearch.stoom.restapi.model.Endereco;
import br.com.lukearch.stoom.restapi.repository.EnderecoRepository;
import br.com.lukearch.stoom.restapi.service.GeocodeService;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {
  @Autowired
  private EnderecoRepository eRepository;
  
  @Autowired
  private GeocodeService gService;

  /** 
   * @return List<EnderecoDto>
   */
  @GetMapping
  public List<EnderecoDto> getAll() {
    List<Endereco> lEnderecos = eRepository.findAll();
    return EnderecoDto.convert(lEnderecos);
  }
  
  /** 
   * @param id
   * @return ResponseEntity<EnderecoDto>
   */
  @GetMapping("/{id}")
  public ResponseEntity<EnderecoDto> getOne(@PathVariable Long id) {
    Optional<Endereco> endereco = eRepository.findById(id);
    if(endereco.isPresent()) {
      return ResponseEntity.ok(new EnderecoDto(endereco.get()));
    }
    return ResponseEntity.notFound().build();
  }

  /** 
   * @param eForm
   */
  @PostMapping
  @Transactional
  public ResponseEntity<EnderecoDto> save(@RequestBody @Valid EnderecoForm eForm, UriComponentsBuilder builder, BindingResult result) {
    if(result.hasErrors()) {
    }
    Endereco endereco = eForm.convert(gService);
    eRepository.save(endereco);
    URI uri = builder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
    return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
  }
  
  /** 
   * @param id
   * @param eForm
   * @return ResponseEntity<EnderecoDto>
   */
  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<EnderecoDto> update(@PathVariable Long id, @RequestBody @Valid EnderecoForm eForm) {
    Optional<Endereco> endereco = eRepository.findById(id);
    if(endereco.isPresent()) {
      eForm.update(endereco.get(), gService);
      return ResponseEntity.ok(new EnderecoDto(endereco.get()));
    }
    return ResponseEntity.notFound().build();
  }
  
  /** 
   * @param id
   * @return ResponseEntity<?>
   */
  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<?> delete(@PathVariable Long id) {
    Optional<Endereco> endereco = eRepository.findById(id);
    if(endereco.isPresent()) {
      eRepository.delete(endereco.get());
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }
}