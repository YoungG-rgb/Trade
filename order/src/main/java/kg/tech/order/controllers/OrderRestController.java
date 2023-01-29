package kg.tech.order.controllers;

import kg.tech.commons.models.ResponseModel;
import kg.tech.commons.rest.BaseController;
import kg.tech.order.models.OrderModel;
import kg.tech.order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseModel<OrderModel> create(@RequestBody OrderModel orderModel,
                                            @RequestParam(value = "applyCoupons", required = false) List<Long> applyCoupons) {
        return successResponse(orderService.save(orderModel, applyCoupons));
    }
}
