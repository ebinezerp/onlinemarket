package statge2.ecommerce.onlinemarketbackend.dao;

import javax.persistence.criteria.Order;

import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dto.Orders;
@Component
public interface OrdersDAO {
	public boolean addOrder(Orders order);
	public boolean deleteOrder(Orders order);
	public boolean updateOrder(Orders order);

}
