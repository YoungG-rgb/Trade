package kg.tech.order.controllers;

import kg.tech.commons.models.ResponseModel;
import kg.tech.commons.rest.BaseController;
import kg.tech.order.models.OrderModel;
import kg.tech.order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderRestController extends BaseController {
    private final OrderService orderService;
    @GetMapping("/{userId}")
    public ResponseModel<List<OrderModel>> getUserOrders(@PathVariable("userId") Long userId){
        return successResponse(orderService.findAllByUserId(userId));
    }
}
