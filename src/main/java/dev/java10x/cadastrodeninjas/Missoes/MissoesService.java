package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    public MissoesModel listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoporId = missoesRepository.findById(id);
        return  missaoporId.orElse(null);
    }

    public MissoesModel createMissao(MissoesModel missoesModel) {
        return missoesRepository.save(missoesModel);
    }
}
