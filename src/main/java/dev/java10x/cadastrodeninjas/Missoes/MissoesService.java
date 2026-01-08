package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missao -> missoesMapper.map(missao))
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoporId = missoesRepository.findById(id);
        return  missaoporId.map(missao -> missoesMapper.map(missao)).orElse(null);
    }

    public MissoesDTO createMissao(MissoesDTO missoesDTO) {
        MissoesModel missaoSalvar = missoesMapper.map(missoesDTO);
        missaoSalvar =  missoesRepository.save(missaoSalvar);
        return missoesMapper.map(missaoSalvar);

    }

    public void deleteMissao(Long id){
        missoesRepository.deleteById(id);
    }
}
