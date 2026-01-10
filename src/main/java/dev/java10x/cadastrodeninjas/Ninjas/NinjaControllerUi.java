package dev.java10x.cadastrodeninjas.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjaDTOS = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjaDTOS);
        return "listarNinjas";
    }

    @GetMapping("/delete/{id}")
    public String deleteNinjaForId(@PathVariable Long id) {
        ninjaService.deleteNinjaForId(id);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public  String listarNinjasPorId(@PathVariable Long id, Model model) {// @PathVariable [e um tipo de variavel que vai no patch naquele id por exemplo
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        model.addAttribute("ninjas", ninja);
        return "detalhesNinja";
    }

    @GetMapping("/adicionar")
    public  String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @PostMapping("/create")
    public String CreateNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes attributes) {
        NinjaDTO ninjanovo  = ninjaService.CreateNinja(ninja);
        attributes.addFlashAttribute("mensagem", "ninja cadastrado com sucesso");
        attributes.addFlashAttribute("ninja", ninjanovo);
         return "redirect:/ninjas/ui/listar";
    }


}