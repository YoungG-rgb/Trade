package kg.tech.order.controllers;

import kg.tech.commons.exceptions.OrderException;
import kg.tech.commons.models.ResponseModel;
import kg.tech.commons.rest.BaseController;
import kg.tech.order.domain.models.CouponModel;
import kg.tech.order.services.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupons")
public class CouponRestController extends BaseController {
    private final CouponService couponService;

    @GetMapping
    public ResponseModel<List<CouponModel>> getAll(){
        return successResponse(couponService.getAll());
    }

    @PostMapping
    public ResponseModel<CouponModel> save(@RequestBody CouponModel couponModel) {
        return successResponse(couponService.save(couponModel));
    }

    @GetMapping("/{userId}")
    public ResponseModel<List<CouponModel>> getAllByUserId(@PathVariable Long userId) {
        return successResponse(couponService.findByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseModel<String> delete(@PathVariable Long id) throws OrderException {
        couponService.delete(id);
        return successResponse("Удалено");
    }
}
