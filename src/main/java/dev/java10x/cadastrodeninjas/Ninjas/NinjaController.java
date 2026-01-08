package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    @PostMapping("/create")
    public ResponseEntity<String> CreateNinja(@RequestBody NinjaDTO ninja) {

        NinjaDTO ninjanovo  = ninjaService.CreateNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com sucesso: " + ninjanovo.getNome() + " Id: " + ninjanovo.getId());
    }

    @GetMapping("/listar/{id}")
    public  ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {// @PathVariable [e um tipo de variavel que vai no patch naquele id por exemplo
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
          if (ninja != null){
              return ResponseEntity.ok(ninja);

          }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Não tem nenhum ninja com o id: " + id + " informado");
    }

    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Put [e a juncao de Post + Get
    @PutMapping("/update/{id}")
    public ResponseEntity<?> ninjaUpdate(@PathVariable Long id, @RequestBody NinjaDTO ninjaModel) {
        NinjaDTO ninja = ninjaService.ninjaUpdate(id, ninjaModel);
        if(ninjaService.listarNinjasPorId(id) != null) {
            ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não tem nenhum ninja com o id: " + id + " informado");

    }


    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> deleteNinjaForId(@PathVariable Long id) {
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deleteNinjaForId(id);
            return  ResponseEntity.ok("Ninja com id: " + id + " deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com o id " + id+" Nao foi encontrado");
        }
    }

}
