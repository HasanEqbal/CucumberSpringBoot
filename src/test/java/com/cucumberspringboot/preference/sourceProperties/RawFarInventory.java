package com.cucumberspringboot.preference.sourceProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection="RawFarInventory")
public class RawFarInventory {
       private String  storeId;
       private String upcId;
       private String itemQty;
}
