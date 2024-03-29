package com.stackroute.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharityStatus {
    private String username;
    private String foodAvailable;
    private String deliveryBoyName;
    private Long deliveryBoyMobile;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFoodAvailable() {
        return foodAvailable;
    }

    public void setFoodAvailable(String foodAvailable) {
        this.foodAvailable = foodAvailable;
    }

    public String getDeliveryBoyName() {
        return deliveryBoyName;
    }

    public void setDeliveryBoyName(String deliveryBoyName) {
        this.deliveryBoyName = deliveryBoyName;
    }

    public Long getDeliveryBoyMobile() {
        return deliveryBoyMobile;
    }

    public void setDeliveryBoyMobile(Long deliveryBoyMobile) {
        this.deliveryBoyMobile = deliveryBoyMobile;
    }
}
