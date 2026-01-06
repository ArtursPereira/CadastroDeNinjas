package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository; // Create one object the NinjaRepository
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository ninjaRepository) {
        this.ninjaMapper = ninjaMapper;
        this.ninjaRepository = ninjaRepository;
    }

    //List for all the ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return  ninjas.stream()
                .map(ninja -> ninjaMapper.map(ninja))
                .collect(Collectors.toList());

    }
    //List ninja for id
    public NinjaDTO listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninja -> ninjaMapper.map(ninja)).orElse(null);

    }
    // Create Ninja
    public NinjaDTO CreateNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }
    //Delete Ninja for Id
    public void deleteNinjaForId(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO ninjaUpdate(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }


}
