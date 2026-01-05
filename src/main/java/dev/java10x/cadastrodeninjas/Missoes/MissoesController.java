package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public String CreateMissoes() {
        return "Missoes criadas";
    }

    @GetMapping("/listar/{id}")
    public MissoesModel ProcuraPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);
    }

    @GetMapping("/listar")
    public List<MissoesModel> MostrarTodasAsMissoes() {
        return missoesService.listarMissoes();
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
