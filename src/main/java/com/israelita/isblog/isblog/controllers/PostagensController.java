package com.israelita.isblog.isblog.controllers;

import com.israelita.isblog.isblog.dto.PostagensDTO;
import com.israelita.isblog.isblog.services.PostagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
