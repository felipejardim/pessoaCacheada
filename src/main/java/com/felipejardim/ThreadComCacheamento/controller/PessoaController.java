package com.felipejardim.ThreadComCacheamento.controller;


import com.felipejardim.ThreadComCacheamento.entity.Pessoa;
import com.felipejardim.ThreadComCacheamento.service.pessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    pessoaService service;

    @GetMapping("")
    public List<Pessoa> retornarPessoas(){
        return service.getListaDePessoas();
    }

    @GetMapping("/att")
    public String AtualizarLista(){
        service.atualizaListaDePessoas();
        return "OK";
    }

    @PostMapping("")
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa ){
        return service.criarPessoa(pessoa);
    }

    @PostConstruct                                                      //Faz o método rodar após instância do spring
    public void runner(){
        usainBoltCarteiro runner = new usainBoltCarteiro(service);
        Thread t = new Thread(runner);
        t.start();
    }
}
