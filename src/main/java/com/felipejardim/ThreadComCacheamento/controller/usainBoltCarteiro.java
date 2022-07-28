package com.felipejardim.ThreadComCacheamento.controller;

import com.felipejardim.ThreadComCacheamento.entity.Pessoa;
import com.felipejardim.ThreadComCacheamento.repository.pessoaRepository;
import com.felipejardim.ThreadComCacheamento.service.pessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Transactional
public class usainBoltCarteiro implements Runnable{
    private final pessoaService service;
    usainBoltCarteiro(pessoaService service){
        this.service = service;
    }

    private ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

    @Override
    public void run(){
        service.atualizaListaDePessoas();

        //Calcular tempo em milisegundos para 6AM do dia seguinte
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);      //num tem Locale.Brazil :(
        Calendar cal = Calendar.getInstance();

        Date hoje = cal.getTime();

        cal.set(Calendar.DATE, cal.get(Calendar.DATE)+1);                                           // add 1 dia e coloca o horário para 6AM
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 01);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 00);

        Date proxHorario = cal.getTime();

        long milisMorales = proxHorario.getTime() - hoje.getTime();                                 //retorna a diferença de tempo em milisegundo


        pool.schedule(new usainBoltCarteiro(service), milisMorales, TimeUnit.MILLISECONDS);         // configura o prox horário de execucao


        /*while(true){                              //implementação de teste, att o cache a cada segundo
            try{
                service.atualizaListaDePessoas();
                Thread.sleep(1000);

            }
            catch (Exception e){
                System.out.println(e);


            }
        }*/
    }
}
