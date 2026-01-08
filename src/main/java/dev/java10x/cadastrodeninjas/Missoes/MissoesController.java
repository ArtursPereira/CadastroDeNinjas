package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/create")
    public MissoesDTO CreateMissao(@RequestBody MissoesDTO missoesDTO) {
        return missoesService.createMissao(missoesDTO);
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO    ProcuraPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
         return ResponseEntity.ok(missoesService.listarMissoes());
    }

    @DeleteMapping("/deletar")
    public void DeletaUmaMissao(Long id) {
        missoesService.deleteMissao(id);
    }

    @PutMapping("/update")
    public  String UpdateMissao() {
        return "Missao atualizada";
    }
}
