package dev.java10x.cadastrodeninjas.Missoes;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @PostMapping("/criar")
    public String CreateMissoes() {
        return "Missoes criadas";
    }

    @GetMapping("/mostrarone")
    public String ProcuraPorId() {
        return "Missao retornada";
    }

    @GetMapping("/mostrarall")
    public  String MostrarTodasAsMissoes() {
        return "Mostrando todas as Missoes";
    }

    @DeleteMapping("/deletar")
    public String DeletaUmaMissao() {
        return "Missao deletada";
    }

    @PutMapping("/update")
    public  String UpdateMissao() {
        return "Missao atualizada";
    }
}
