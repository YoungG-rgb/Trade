package kg.tech.order.controllers;

import kg.tech.commons.exceptions.OrderException;
import kg.tech.commons.models.ResponseModel;
import kg.tech.commons.rest.BaseController;
import kg.tech.order.domain.models.OrderModel;
import kg.tech.order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderRestController extends BaseController {
    private final OrderService orderService;

    @GetMapping("/{userId}")
    public ResponseModel<List<OrderModel>> getUserOrders(@PathVariable("userId") Long userId){
        return successResponse(orderService.findAllByUserId(userId));
    }

    @PostMapping
    public ResponseModel<OrderModel> create(@RequestParam(value = "applyCoupons", required = false) List<Long> applyCoupons,
                                            @RequestBody OrderModel orderModel) throws Exception {
        return successResponse(orderService.save(orderModel, applyCoupons));
    }

    @PutMapping
    public ResponseModel<OrderModel> update(@RequestBody OrderModel orderModel) throws OrderException {
        return successResponse(orderService.update(orderModel));
    }

    @DeleteMapping("/{id}")
    public ResponseModel<String> delete(@PathVariable("id") Long id) throws OrderException {
        orderService.delete(id);
        return successResponse("Удалено");
    }
}
