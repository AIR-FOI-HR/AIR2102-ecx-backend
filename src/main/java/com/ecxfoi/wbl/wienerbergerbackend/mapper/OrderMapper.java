package com.ecxfoi.wbl.wienerbergerbackend.mapper;

import com.ecxfoi.wbl.wienerbergerbackend.dto.OrderDto;
import com.ecxfoi.wbl.wienerbergerbackend.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements GenericMapper<OrderDto, Order>
{
    @Override
    public OrderDto mapDto(final Order entity)
    {
        if (entity == null)
        {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId(entity.getIdOrder());
        //orderDto.setName(entity.getName()); //TODO: determine whether Name atribute is needed
        orderDto.setStatus(entity.getStatus());
        orderDto.setDate(entity.getDocumentDate());
        orderDto.setDeliveryDate(entity.getWishDeliveryDate());
        orderDto.setPaymentMethod(entity.getPaymentTerm());

        return orderDto;
    }

    @Override
    public Order map(final OrderDto dto) throws Exception
    {
        if (dto == null)
        {
            return null;
        }

        Order order = new Order();

        order.setIdOrder(dto.getId());
        //orderDto.setName(entity.getName());
        order.setStatus(dto.getStatus());
        order.setDocumentDate(dto.getDate());
        order.setWishDeliveryDate(dto.getDeliveryDate());
        order.setPaymentTerm(dto.getPaymentMethod());

        return order;
    }
}