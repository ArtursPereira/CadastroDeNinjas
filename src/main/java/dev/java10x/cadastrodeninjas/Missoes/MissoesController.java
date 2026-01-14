package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/create")
    public ResponseEntity<MissoesDTO> CreateMissao(@RequestBody MissoesDTO missoesDTO) {
       MissoesDTO missoesDTO1 =  missoesService.createMissao(missoesDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(missoesDTO1);

    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?>    ProcuraPorId(@PathVariable Long id) {
        MissoesDTO missoesDTO = missoesService.listarMissaoPorId(id);
        if(missoesDTO != null) {
            return ResponseEntity.ok(missoesDTO);
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não tem nenhum ninja com o id:  + id +  informado");

    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
         return ResponseEntity.ok(missoesService.listarMissoes());
    }

    @DeleteMapping("/deletar")
    public void DeletaUmaMissao(Long id) {
        missoesService.deleteMissao(id);
    }
}
