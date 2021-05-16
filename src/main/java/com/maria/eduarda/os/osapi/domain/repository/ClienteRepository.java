package com.maria.eduarda.os.osapi.domain.repository;

import com.maria.eduarda.os.osapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
