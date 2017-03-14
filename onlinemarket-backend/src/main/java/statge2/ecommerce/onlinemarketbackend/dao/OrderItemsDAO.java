package statge2.ecommerce.onlinemarketbackend.dao;

import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dto.OrderItems;
@Component
public interface OrderItemsDAO {
	public boolean addOrderedItem(OrderItems orderItems);

}
