package kss.springframework.msscbeerservice.loader;

import kss.springframework.msscbeerservice.domain.Beer;
import kss.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       loadBeer();
    }

    private void loadBeer() {
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                    .beerName("New beer 1")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(678346578L)
                    .price(new BigDecimal("12.45"))
                    .build()
            );

            beerRepository.save(Beer.builder()
                    .beerName("New beer 2")
                    .beerStyle("ALE")
                    .quantityToBrew(130)
                    .minOnHand(5)
                    .upc(67862734578L)
                    .price(new BigDecimal("23.80"))
                    .build()
            );
        }

        System.out.println("Count of loaded beer: " + beerRepository.count());
    }
}
