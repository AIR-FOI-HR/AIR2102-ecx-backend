package com.ecxfoi.wbl.wienerbergerbackend.mapper;

import com.ecxfoi.wbl.wienerbergerbackend.dto.OrderStatusDto;
import com.ecxfoi.wbl.wienerbergerbackend.exceptions.InvalidMappingException;
import com.ecxfoi.wbl.wienerbergerbackend.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusMapper implements GenericMapper<OrderStatusDto, Order>
{
    @Override
    public OrderStatusDto mapDto(final Order entity)
    {
        if (entity == null)
        {
            return null;
        }

        OrderStatusDto orderStatusDto = new OrderStatusDto();

        orderStatusDto.setId(entity.getIdOrder());
        orderStatusDto.setStatus(entity.getStatus());

        return orderStatusDto;
    }

    @Override
    public Order map(final OrderStatusDto dto) throws InvalidMappingException
    {
        if (dto == null)
        {
            return null;
        }

        Order order = new Order();

        order.setIdOrder(dto.getId());
        order.setStatus(dto.getStatus());

        return order;
    }
}