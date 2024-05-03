package ibf2024.assessment.paf.batch4.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Brewery;
import ibf2024.assessment.paf.batch4.models.Order;
import ibf2024.assessment.paf.batch4.models.OrdersForm;
import ibf2024.assessment.paf.batch4.models.Style;
import ibf2024.assessment.paf.batch4.repositories.BeerRepository;
import ibf2024.assessment.paf.batch4.repositories.OrderRepository;

@Service
public class BeerService {

	@Autowired
	private BeerRepository beerRepository;

	@Autowired
	private OrderRepository orderRepository;

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
	public String placeOrder(int breweryId, List<Order> orderList) {
		// TODO: Task 5
		String orderId = UUID.randomUUID().toString().substring(0, 8);
		Date date = new Date();

		OrdersForm ordersForm = new OrdersForm();
		ordersForm.setOrderId(orderId);
		ordersForm.setDate(date);
		ordersForm.setBreweryId(breweryId);
		ordersForm.setOrders(orderList);

		String result = orderRepository.placeOrder(ordersForm);
		return result;
	}

}
