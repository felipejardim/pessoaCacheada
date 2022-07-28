package com.felipejardim.ThreadComCacheamento.service;

import com.felipejardim.ThreadComCacheamento.entity.Pessoa;
import com.felipejardim.ThreadComCacheamento.repository.pessoaRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pessoaService {

    @Autowired
    pessoaRepository repo;

    @Getter
    private List<Pessoa> listaDePessoas;

    public void atualizaListaDePessoas(){
        this.listaDePessoas = repo.findAll();
    }

    public Pessoa criarPessoa(Pessoa p){
        return repo.save(p);
    }

    public Pessoa alterarPessoa(Pessoa p){
        return repo.save(p);
    }

    public void excluirPessoa(Long id){
        repo.deleteById(id);
    }
}
