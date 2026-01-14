package dev.java10x.cadastrodeninjas.Missoes;


import dev.java10x.cadastrodeninjas.Ninjas.NinjaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MissoesMapper {

    MissoesDTO map(MissoesModel missoesModel);

    MissoesModel map(MissoesDTO missoesDTO);
}
