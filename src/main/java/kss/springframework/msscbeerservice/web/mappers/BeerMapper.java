package kss.springframework.msscbeerservice.web.mappers;


import kss.springframework.msscbeerservice.domain.Beer;
import kss.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    Beer BeerDtoToBeer(BeerDto dto);
    BeerDto beerToBeerDto(Beer beer);
}
