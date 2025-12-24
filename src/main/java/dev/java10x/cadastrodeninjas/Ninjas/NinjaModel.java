package dev.java10x.cadastrodeninjas.Ninjas;


import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

// O comando Entity transforma uma classe em uma entity no banco de dados
@Entity
@Table(name = "tb_cadastro_de_ninjas") // Declara que estamos criando uma tabela
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

    public NinjaModel() {
    }

    public NinjaModel(String email, String nome, int idade) {
        this.email = email;
        this.nome = nome;
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
