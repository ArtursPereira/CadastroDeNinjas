package dev.java10x.cadastrodeninjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/create")
   @Operation(summary = "Register of Ninjas", description = "This route create ninjas and insert in the data base")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created ninja with sucess"),
            @ApiResponse(responseCode = "404", description = "Error in the creating ninja")
    })
    public ResponseEntity<String> CreateNinja(@RequestBody NinjaDTO ninja) {

        NinjaDTO ninjanovo  = ninjaService.CreateNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com sucesso: " + ninjanovo.getNome() + " Id: " + ninjanovo.getId());
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "list of ninja by ID", description = "This route list ninja by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listed ninja with sucess"),
            @ApiResponse(responseCode = "404", description = "Error in ninja listing")
    })
    public  ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {// @PathVariable [e um tipo de variavel que vai no patch naquele id por exemplo
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
          if (ninja != null){
              return ResponseEntity.ok(ninja);

          }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Não tem nenhum ninja com o id: " + id + " informado");
    }

    @Operation(summary = "list of ninjas", description = "This route list ninjas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listed ninjas with sucess"),
            @ApiResponse(responseCode = "404", description = "Error in ninjas listing")
    })
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>>  listarNinjas() {
        List<NinjaDTO> ninjaDTOS = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjaDTOS);
    }

    @Operation(summary = "update of ninja by ID", description = "This route update ninja by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "updated ninja with sucess"),
            @ApiResponse(responseCode = "404", description = "Error in ninja updating")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<?> ninjaUpdate(@PathVariable Long id, @RequestBody NinjaDTO ninjaModel) {
        NinjaDTO ninja = ninjaService.ninjaUpdate(id, ninjaModel);
        if(ninjaService.listarNinjasPorId(id) != null) {
            ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não tem nenhum ninja com o id: " + id + " informado");

    }

    @Operation(summary = "Delete ninjaf by id", description = "This route excludes ninjas by ID in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted ninja with sucess"),
            @ApiResponse(responseCode = "404", description = "Error in ninja delete")
    })
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
