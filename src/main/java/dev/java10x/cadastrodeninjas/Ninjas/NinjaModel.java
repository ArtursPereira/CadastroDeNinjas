package dev.java10x.cadastrodeninjas.Ninjas;


import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// O comando Entity transforma uma classe em uma entity no banco de dados
@Entity
@Table(name = "tb_cadastro_de_ninjas") // Declara que estamos criando uma tabela
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nome;

    private int idade;

    //@ManyToOne um ninja tem apenas uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key ou Chave Estrangeira
    private MissoesModel missoes;


}
