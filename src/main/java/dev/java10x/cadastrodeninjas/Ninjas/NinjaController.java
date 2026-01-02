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

    @GetMapping("/boasvindas")// Pega as informações, nesse caso ele vai pegar o método boasVindas
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    //TODO: Adicionar ninja (Create)
    @PostMapping("/create")
    public String criarNinja() {
        return "Ninja Criado";
    }
    //TODO: Mostrar ninja por ID (Update)
    @GetMapping("/ninjaid")
    public  String MostrarNinjaPorId() {
        return "Mostra um ninja por ID";
    }

    //TODO Mostrar todos os ninjas (Update)
    @GetMapping("/all")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }
    //TODO: Alterar dados do Ninja (Update)
    @PutMapping("/update")
    public String AlterarONinjaPorID() {
        return "Ninja Alterado";
    }

    //TODO: Deletar Ninja (Delete)
    @DeleteMapping("/delete")
    public  String DeletarPorId() {
        return "Ninja deletado";
    }
}
