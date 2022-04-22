package io.github.jhfranca.contribuicaocafe.dto;

import io.github.jhfranca.contribuicaocafe.entity.ItemCafe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalvarContribuicaoResponse {
    private List<ItemCafe> itensAdicionados;
    private List<ItemCafe> itensJaExistentes;
}
