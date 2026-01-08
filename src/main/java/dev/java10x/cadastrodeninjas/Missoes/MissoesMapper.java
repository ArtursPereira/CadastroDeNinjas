package dev.java10x.cadastrodeninjas.Missoes;


import dev.java10x.cadastrodeninjas.Ninjas.NinjaDTO;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public static MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setNinjas(missoesDTO.getNinjas());
        return missoesModel;
    }

    public static MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setNinjas(missoesModel.getNinjas());
        return  missoesDTO;
    }
}
