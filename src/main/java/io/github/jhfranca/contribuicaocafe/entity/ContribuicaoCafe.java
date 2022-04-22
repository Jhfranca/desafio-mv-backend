package io.github.jhfranca.contribuicaocafe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "tb_contribuicao_cafe")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ContribuicaoCafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpf_pessoa", referencedColumnName = "cpf")
    private Pessoa pessoa;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_cafe_id", referencedColumnName = "id")
    private List<ItemCafe> itens;
}
