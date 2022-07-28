package com.felipejardim.ThreadComCacheamento.controller;

import com.felipejardim.ThreadComCacheamento.service.pessoaService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
        cal.set(Calendar.HOUR_OF_DAY, 06);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 00);

        Date proxHorario = cal.getTime();

        long milisMorales = proxHorario.getTime() - hoje.getTime();                                 //retorna a diferença de tempo em milisegundo


        pool.schedule(new usainBoltCarteiro(service), milisMorales, TimeUnit.MILLISECONDS);         // configura o prox horário de execucao
    }
}
