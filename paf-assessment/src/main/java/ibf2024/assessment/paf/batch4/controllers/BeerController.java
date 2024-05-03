package ibf2024.assessment.paf.batch4.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Brewery;
import ibf2024.assessment.paf.batch4.models.Style;
import ibf2024.assessment.paf.batch4.services.BeerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/beer")
public class BeerController {

	@Autowired
	private BeerService beerService;

	// TODO Task 2 - view 0
	@GetMapping("/style")
	public ModelAndView getBeerStyleCount() {
		ModelAndView mav = new ModelAndView("view0");
		List<Style> beerStyles = beerService.getStyles();
		mav.addObject("styles", beerStyles);
		return mav;
	}

	// TODO Task 3 - view 1
	@GetMapping("/style/{id}")
	public ModelAndView getBeerBreweries(@PathVariable int id, @RequestParam("styleName") String name) {
		ModelAndView mav = new ModelAndView("view1");
		List<Beer> beerBreweries = beerService.getBreweriesByBeer(id);
		mav.addObject("name", name);
		mav.addObject("beerBreweries", beerBreweries);
		return mav;
	}

	// TODO Task 4 - view 2
	@GetMapping("/brewery/{id}")
	public ModelAndView getBreweriesBeer(@PathVariable int id, @RequestParam String breweryName) {

		Optional<Brewery> opt = beerService.getBeersFromBrewery(id);
		ModelAndView mav = new ModelAndView();

		if (opt.isEmpty()) {
			mav.setViewName("nobrewery");
		} else {
			mav.setViewName("view2");
			mav.addObject("breweryName", breweryName);
			mav.addObject("brewery", opt.get());
		}
		return mav;
	}

	// TODO Task 5 - view 2, place order

}
