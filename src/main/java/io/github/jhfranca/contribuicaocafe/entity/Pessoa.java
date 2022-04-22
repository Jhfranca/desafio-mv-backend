package io.github.jhfranca.contribuicaocafe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_pessoa")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    @Id
    @Column(unique = true)
    private String cpf;
    private String nome;
}
