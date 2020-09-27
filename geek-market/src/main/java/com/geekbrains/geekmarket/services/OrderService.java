package com.geekbrains.geekmarket.services;

import com.geekbrains.geekmarket.entities.Order;
import com.geekbrains.geekmarket.entities.OrderItem;
import com.geekbrains.geekmarket.entities.User;
import com.geekbrains.geekmarket.repositories.OrderItemRepository;
import com.geekbrains.geekmarket.repositories.OrderRepository;
import com.geekbrains.geekmarket.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void createOrder(HttpSession httpSession) {
        ShoppingCart shoppingCart = shoppingCartService.getCurrentCart(httpSession);
        List<OrderItem> orderItems = shoppingCart.getItems();
        User user = (User)httpSession.getAttribute("user");
        long user_id = user.getId();
        Order order = new Order();
        order.setUser_id(user_id);
        orderRepository.save(order);
        Long order_id = order.getId();
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);
        }
        shoppingCart.setItems(new ArrayList<OrderItem>());
    }
}
