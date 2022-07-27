package com.felipejardim.ThreadComCacheamento.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idPeople;

    @Basic
    @Column(name = "nome")
    private String nome;

    @Basic
    @Column(name = "sobrenome")
    private String sobrenome;
}

