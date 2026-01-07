package dev.java10x.cadastrodeninjas.Ninjas;


import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public static NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();

        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());

        return ninjaModel;
    }

    public static NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();

        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());

        return ninjaDTO;
    }
}
