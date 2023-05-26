package com.israelita.isblog.isblog.controllers;

import com.israelita.isblog.isblog.dto.PostagensDTO;
import com.israelita.isblog.isblog.entities.Postagens;
import com.israelita.isblog.isblog.services.PostagensService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="postagens")
public class PostagensController {

    @Autowired
    private PostagensService postagensService;

    @GetMapping
    public List<PostagensDTO> findAll(){
        List<PostagensDTO> result = postagensService.findAll();
        return result;
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPostagem(@PathVariable(value = "id") Long id){
        Optional<Postagens> postagensOptional = postagensService.findById(id);
        if (!postagensOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Postagem não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(postagensOptional.get());
    }

    @PostMapping
    @RequestMapping(value="/post")
    public ResponseEntity<Object> salvarPostagem(@RequestBody PostagensDTO postagemDTO){

        var postagem = new Postagens();
        BeanUtils.copyProperties(postagemDTO, postagem);

        return ResponseEntity.status(HttpStatus.CREATED).body(postagensService.save(postagem));
    }

}
