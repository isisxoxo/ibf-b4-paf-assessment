package ibf2024.assessment.paf.batch4.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2024.assessment.paf.batch4.exception.NoBreweryFoundException;
import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Brewery;
import ibf2024.assessment.paf.batch4.models.Order;
import ibf2024.assessment.paf.batch4.models.Style;
import ibf2024.assessment.paf.batch4.services.BeerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	public ModelAndView getBreweriesBeer(@PathVariable int id) throws NoBreweryFoundException {

		Optional<Brewery> opt = beerService.getBeersFromBrewery(id);
		ModelAndView mav = new ModelAndView();

		if (opt.isEmpty()) {
			throw new NoBreweryFoundException("Brewery not found");
		} else {
			mav.setViewName("view2");
			mav.addObject("brewery", opt.get());
		}
		return mav;
	}

	// TODO Task 5 - view 2, place order
	@PostMapping("/brewery/{id}/order")
	public ModelAndView postOrder(@PathVariable int id, @RequestBody MultiValueMap<String, String> orders) {

		ModelAndView mav = new ModelAndView();

		List<String> beerIds = orders.get("beerId");
		List<String> quantities = orders.get("quantity");
		List<Order> orderList = new LinkedList<>();

		for (int i = 0; i < beerIds.size(); i++) {
			if ((quantities.get(i).isEmpty()) || (Integer.parseInt(quantities.get(i)) < 1)) {
				continue;
			}
			Order order = new Order();
			order.setQuantity(Integer.parseInt(quantities.get(i)));
			order.setBeerId(Integer.parseInt(beerIds.get(i)));
			orderList.add(order);
		}

		// If no valid quantity was entered
		if (orderList.size() == 0) {
			mav.setViewName("noorder");
			mav.addObject("id", id);
			return mav;
		}

		// If valid quantity was entered
		String orderId = beerService.placeOrder(id, orderList);
		mav.setViewName("view3");
		mav.addObject("orderId", orderId);
		return mav;
	}

}
