package io.github.jhfranca.contribuicaocafe.repository;

import io.github.jhfranca.contribuicaocafe.entity.ContribuicaoCafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContribuicaoCafeRepository extends JpaRepository<ContribuicaoCafe, Long> {
    boolean existsById(Long id);
}
