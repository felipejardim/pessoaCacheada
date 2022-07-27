package com.felipejardim.ThreadComCacheamento.controller;

import com.felipejardim.ThreadComCacheamento.entity.Pessoa;
import com.felipejardim.ThreadComCacheamento.repository.pessoaRepository;
import com.felipejardim.ThreadComCacheamento.service.pessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
public class usainBoltCarteiro implements Runnable{
    private final pessoaService service;
    usainBoltCarteiro(pessoaService service){
        this.service = service;
    }

    @Override
    public void run(){
        while(true){
            try{
                service.atualizaListaDePessoas();
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
