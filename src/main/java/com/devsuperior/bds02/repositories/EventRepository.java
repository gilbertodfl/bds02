package com.devsuperior.bds02.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.bds02.entities.Event;

//repare que aqui é uma INTERFACE 
// e quem precisa importar o import org.springframework.data.jpa.repository.JpaRepository;
public interface EventRepository extends JpaRepository <Event, Long>{


}
