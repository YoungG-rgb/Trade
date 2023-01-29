package kg.tech.order.mappers;

import kg.tech.order.entities.Coupon;
import kg.tech.order.models.CouponModel;
import kg.tech.order.repositories.UserRepository;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class CouponMapper {
    @Autowired UserRepository userRepository;

    @InheritInverseConfiguration
    public abstract CouponModel toModel(Coupon coupon);

    @Mapping(target = "user", expression = "java( userRepository.findById(id).get() )")
    public abstract Coupon toEntity(CouponModel couponModel);
}
