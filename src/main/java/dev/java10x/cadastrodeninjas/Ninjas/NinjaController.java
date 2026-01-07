package dev.java10x.cadastrodeninjas.Ninjas;

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
    public NinjaDTO CreateNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.CreateNinja(ninja);
    }

    @GetMapping("/listar/{id}")
    public  NinjaDTO listarNinjasPorId(@PathVariable Long id) { // @PathVariable [e um tipo de variavel que vai no patch naquele id por exemplo
        return ninjaService.listarNinjasPorId(id);
    }

    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Put [e a juncao de Post + Get
    @PutMapping("/update/{id}")
    public NinjaDTO ninjaUpdate(@PathVariable Long id, @RequestBody NinjaDTO ninjaModel) {
        return ninjaService.ninjaUpdate(id, ninjaModel);
    }


    @DeleteMapping("/delete/{id}")
    public  void deleteNinjaForId(@PathVariable Long id) {ninjaService.deleteNinjaForId(id);}

}
