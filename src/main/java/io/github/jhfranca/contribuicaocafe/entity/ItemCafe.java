package io.github.jhfranca.contribuicaocafe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "tb_item_cafe")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ItemCafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;
}
