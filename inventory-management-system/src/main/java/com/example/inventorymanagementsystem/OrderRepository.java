package com.example.inventorymanagementsystem;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class OrderRepository {

    public static final RowMapper<Order> ORDER_ROW_MAPPER = (rs, rowNum) -> new Order(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getTimestamp("placed_time").toLocalDateTime(),
            rs.getInt("total_amount"),
            OrderStatus.valueOf(rs.getString("status"))
    );
    private final JdbcClient jdbcClient;

    public OrderRepository(JdbcTemplate template, JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    Iterable<Order> findAll() {
        return jdbcClient.sql("SELECT id,name,placed_time,total_amount,status FROM orders")
                .query(ORDER_ROW_MAPPER)
                .list();

    }
    Optional<Order> findById(Integer id){
        return jdbcClient.sql(("SELECT id,name,placed_time,total_amount,status FROM orders"))
                .param("id",id)
                .query(ORDER_ROW_MAPPER)
                .optional();
    }
    public void save(Order order){
        this.jdbcClient.sql("INSERT INTO orders(name, placed_time, total_amount, status) VALUES (:name, :placed_time, :total_amount, :status)")
                .param("name", order.getName())
                   .param("placed_time", order.getPlacedTime())
                .param( "total_amount", order.getTotalAmount())

                .param( "status", order.getStatus().toString()).update()
;    }
}
