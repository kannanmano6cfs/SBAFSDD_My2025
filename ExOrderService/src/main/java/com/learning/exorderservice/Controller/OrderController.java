package com.learning.exorderservice.Controller;

import com.learning.exorderservice.Model.Order;
import com.learning.exorderservice.Model.Product;
import com.learning.exorderservice.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/placeorder")
    public ResponseEntity<String> placeorder(@RequestBody Product product) {
        Order order = new Order();
        order.setPrdid(product.getPrdid());
        order.setPrdname(product.getPrdname());
        order.setOrderqty(1);
        orderRepository.save(order);
        return new ResponseEntity<>("Order place successfully for the product "+product.getPrdname(), HttpStatus.OK);
    }

}
