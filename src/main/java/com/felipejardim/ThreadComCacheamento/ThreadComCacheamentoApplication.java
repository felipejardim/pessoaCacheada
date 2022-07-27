package com.felipejardim.ThreadComCacheamento;

import com.felipejardim.ThreadComCacheamento.controller.PessoaController;
import com.felipejardim.ThreadComCacheamento.controller.usainBoltCarteiro;
import com.felipejardim.ThreadComCacheamento.service.pessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ThreadComCacheamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreadComCacheamentoApplication.class, args);
	}
}
