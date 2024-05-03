package ibf2024.assessment.paf.batch4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Brewery;
import ibf2024.assessment.paf.batch4.models.Style;
import ibf2024.assessment.paf.batch4.repositories.BeerRepository;

@Service
public class BeerService {

	@Autowired
	private BeerRepository beerRepository;

	public List<Style> getStyles() {
		return beerRepository.getStyles();
	}

	public List<Beer> getBreweriesByBeer(int id) {
		return beerRepository.getBreweriesByBeer(id);
	}

	public Optional<Brewery> getBeersFromBrewery(int id) {
		return beerRepository.getBeersFromBrewery(id);
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public String placeOrder(/* You can add any number parameters here */) {
		// TODO: Task 5

		return "";
	}

}
