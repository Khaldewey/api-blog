package com.israelita.isblog.isblog.services;

import com.israelita.isblog.isblog.dto.PostagensDTO;
import com.israelita.isblog.isblog.entities.Postagens;
import com.israelita.isblog.isblog.repositories.PostagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 
import java.util.Optional;

import java.util.List;

@Service
public class PostagensService {

    @Autowired
    private PostagensRepository postagensRepository;

    @Transactional(readOnly = true)
   public List<PostagensDTO> findAll(){
      List<Postagens> result = postagensRepository.findAll();
      List<PostagensDTO> dto = result.stream().map(x -> new PostagensDTO(x)).toList();
      return dto;

   } 

   public Optional<Postagens> findById(Long id) {
        return postagensRepository.findById(id);
    }

    @Transactional
    public Postagens save(Postagens postagem) {
        return postagensRepository.save(postagem);
    } 

    @Transactional
    public void delete(Postagens postagem){ 
        postagensRepository.delete(postagem); 
    }
}
