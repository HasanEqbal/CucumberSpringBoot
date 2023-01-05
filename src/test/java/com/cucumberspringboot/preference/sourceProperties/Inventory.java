package com.cucumberspringboot.preference.sourceProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class Inventory {
    private String storeId;
    private String upcId;
    private String itemQty;
}
