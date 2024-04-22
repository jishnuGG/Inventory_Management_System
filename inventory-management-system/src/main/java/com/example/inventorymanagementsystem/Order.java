package com.example.inventorymanagementsystem;



import java.time.LocalDateTime;
public class Order {
        private Integer id;


        private String name;
        private LocalDateTime placedTime;
        private Integer totalAmount;
        private OrderStatus status;

        public Order() {}

        public Order(Integer id, String name, LocalDateTime placedTime, Integer totalAmount, OrderStatus status) {
            this.id = id;
            this.name = name;
            this.placedTime = placedTime;
            this.totalAmount = totalAmount;
            this.status = status;
        }

        public Order(String name, LocalDateTime placedTime, Integer totalAmount, OrderStatus status) {
            this.name = name;
            this.placedTime = placedTime;
            this.totalAmount = totalAmount;
            this.status = status;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDateTime getPlacedTime() {
            return placedTime;
        }

        public void setPlacedTime(LocalDateTime placedTime) {
            this.placedTime = placedTime;
        }

        public Integer getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Integer totalAmount) {
            this.totalAmount = totalAmount;
        }
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

        @Override
        public String toString() {
            return "Order{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", placedTime=" + placedTime +
                    ", totalAmount=" + totalAmount +
                    ", status=" + status +
                    '}';
        }


    }

