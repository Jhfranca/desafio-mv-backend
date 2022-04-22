package io.github.jhfranca.contribuicaocafe.repository;

import io.github.jhfranca.contribuicaocafe.entity.ItemCafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCafeRepository extends JpaRepository<ItemCafe, Long> {
    boolean existsItemCafeByItemEquals(String item);
}
