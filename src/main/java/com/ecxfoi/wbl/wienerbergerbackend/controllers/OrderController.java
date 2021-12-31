package com.ecxfoi.wbl.wienerbergerbackend.controllers;

import com.ecxfoi.wbl.wienerbergerbackend.dto.OrderDetailsDto;
import com.ecxfoi.wbl.wienerbergerbackend.dto.OrderDto;
import com.ecxfoi.wbl.wienerbergerbackend.dto.OrderStatusDto;
import com.ecxfoi.wbl.wienerbergerbackend.response.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController
{
    private final OrderService orderService;

    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/api/orders", method = RequestMethod.POST)
    public ResponseEntity<?> getOrdersForACustomer(@RequestBody Long customerId)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            List<OrderDto> customerOrders = orderService.getOrdersForACustomer(idJWT, customerId);
            return ResponseEntity.ok(new WienerbergerResponse<>(true, "Success!", customerOrders));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "Orders not found!", null));
        }
    }

    @RequestMapping(value = "/api/orders/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrderDetails(@PathVariable Long orderId)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            OrderDetailsDto orderDetails = orderService.getOrderDetails(idJWT, orderId);

            if(orderDetails == null)
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "You are not authorized to get details of this order!", null));
            }

            return ResponseEntity.ok(new WienerbergerResponse<>(true, "Success!", orderDetails));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "Order not found!", null));
        }
    }

    @RequestMapping(value = "/api/orders/{orderId}", method = RequestMethod.POST)
    public ResponseEntity<?> updateOrderStatus(@PathVariable Long orderId, @RequestBody OrderStatusDto orderStatusDto)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            if(!orderService.updateOrderStatus(idJWT, orderStatusDto))
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "You are not authorized to edit other user's orders!", null));
            }

            return ResponseEntity.ok(new WienerbergerResponse<>(true, "Order status updated!", orderStatusDto));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "Error while updating order!", ex.getMessage()));
        }
    }
}