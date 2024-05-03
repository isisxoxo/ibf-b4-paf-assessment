package ibf2024.assessment.paf.batch4.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import ibf2024.assessment.paf.batch4.models.OrdersForm;

@Repository
public class OrderRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	// TODO: Task 5
	public String placeOrder(OrdersForm ordersForm) {
		OrdersForm savedOrder = mongoTemplate.save(ordersForm, "orders");
		return savedOrder.getOrderId();
	}
}
