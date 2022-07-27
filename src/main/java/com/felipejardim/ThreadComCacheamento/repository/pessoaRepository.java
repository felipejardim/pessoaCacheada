package com.felipejardim.ThreadComCacheamento.repository;

import com.felipejardim.ThreadComCacheamento.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface pessoaRepository extends JpaRepository<Pessoa, Long> {

}
