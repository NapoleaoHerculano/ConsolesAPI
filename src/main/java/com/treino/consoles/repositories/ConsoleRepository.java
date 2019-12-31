package com.treino.consoles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treino.consoles.domain.Console;

public interface ConsoleRepository extends JpaRepository<Console, Integer> {

}
