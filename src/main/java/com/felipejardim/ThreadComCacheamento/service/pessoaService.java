package com.felipejardim.ThreadComCacheamento.service;

import com.felipejardim.ThreadComCacheamento.entity.Pessoa;
import com.felipejardim.ThreadComCacheamento.repository.pessoaRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class pessoaService {

    @Autowired
    pessoaRepository repo;

    @Getter
    private List<Pessoa> listaDePessoas;

    private Map<Long, Pessoa> pessoas = new Hashtable<Long, Pessoa>();

    public void atualizaListaDePessoas(){
        this.pessoas.clear();
        this.listaDePessoas = repo.findAll();
        this.listaDePessoas.forEach(pessoa -> this.pessoas.put(pessoa.getId(), pessoa));
    }

    public Pessoa retornaUmaPessoa(Long id){
        return this.pessoas.get(id);
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
