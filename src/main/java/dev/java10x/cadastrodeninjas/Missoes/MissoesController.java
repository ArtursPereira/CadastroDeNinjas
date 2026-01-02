package dev.java10x.cadastrodeninjas.Missoes;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissoesController {

    @PostMapping("/missoes/criar")
    public String CreateMissoes() {
        return "Missoes criadas";
    }

    @GetMapping("/missoes/mostrarone")
    public String ProcuraPorId() {
        return "Missao retornada";
    }

    @GetMapping("/missoes/mostrarall")
    public  String MostrarTodasAsMissoes() {
        return "Mostrando todas as Missoes";
    }

    @DeleteMapping("/missoes/deletar")
    public String DeletaUmaMissao() {
        return "Missao deletada";
    }

    @PutMapping("/missoes/update")
    public  String UpdateMissao() {
        return "Missao atualizada";
    }
}
