package dev.java10x.cadastrodeninjas.Ninjas;


import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NinjaMapper {

    NinjaDTO map(NinjaModel ninjaModel);
    NinjaModel map(NinjaDTO ninjaDTO);


}
