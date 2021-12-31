package com.ecxfoi.wbl.wienerbergerbackend.mapper;

import com.ecxfoi.wbl.wienerbergerbackend.dto.OrderDetailsDto;
import com.ecxfoi.wbl.wienerbergerbackend.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsMapper implements GenericMapper<OrderDetailsDto, Order>
{
    @Override
    public OrderDetailsDto mapDto(final Order entity)
    {
        if (entity == null)
        {
            return null;
        }

        OrderDetailsDto orderDto = new OrderDetailsDto();

        orderDto.setId(entity.getIdOrder());
        orderDto.setStatus(entity.getStatus());
        orderDto.setDate(entity.getDocumentDate());
        orderDto.setDeliveryDate(entity.getWishDeliveryDate());
        orderDto.setCurrency(entity.getCurrency());
        orderDto.setPaymentMethod(entity.getPaymentTerm());
        orderDto.setAdditionalProjectInfo(entity.getAdditionalProjectInfo());

        return orderDto;
    }

    @Override
    public Order map(final OrderDetailsDto dto) throws Exception
    {
        if (dto == null)
        {
            return null;
        }

        Order order = new Order();

        order.setIdOrder(dto.getId());
        order.setStatus(dto.getStatus());
        order.setDocumentDate(dto.getDate());
        order.setWishDeliveryDate(dto.getDeliveryDate());
        order.setPaymentTerm(dto.getPaymentMethod());
        order.setCurrency(dto.getCurrency());
        order.setAdditionalProjectInfo(dto.getAdditionalProjectInfo());

        return order;
    }
}