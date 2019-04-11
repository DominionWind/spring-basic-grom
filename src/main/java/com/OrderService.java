package com;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
    @Autowired
    private OrderDAO orderDAO;
    private int[] orderIds = new int[5];

    public Order save (Order order){
        return null;
    }

    public void test(int index, int id){
        orderIds[index] = id;
    }
}
