package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository; // Create one object the NinjaRepository

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //List for all the ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }



}
