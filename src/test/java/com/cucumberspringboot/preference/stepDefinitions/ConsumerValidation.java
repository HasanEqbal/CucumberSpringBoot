package com.cucumberspringboot.preference.stepDefinitions;


import com.cucumberspringboot.preference.sourceProperties.RawFarInventory;
import com.cucumberspringboot.preference.utils.EventListener;
import com.cucumberspringboot.preference.sourceProperties.Inventory;
import com.cucumberspringboot.preference.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.core.KafkaTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Log4j2
public class ConsumerValidation {

    @Autowired
    @Qualifier("LocalTemplate")
    protected MongoTemplate mongoTemplateSource;

    @Autowired
    Utils utils;

    @Autowired
    Inventory inventory;

    @Autowired
    KafkaTemplate<String, Inventory> kafkaTemplate;

    @Autowired
    EventListener eventListener;

    public static final String TOPIC = "Item_Inventory";
    public static List<RawFarInventory> rawFarInventory = new ArrayList<>();

    @Given("I have {string} upc with {string} and {string}")
    public void iHaveUpcWithAnd(String upcId, String storeId, String quantity) {
        inventory.setStoreId(storeId);
        inventory.setUpcId(upcId);
        inventory.setItemQty(quantity);
        log.info("Sending UPC to kafka producer" + inventory);
    }

    @When("I send the message through kafka Producer")
    public void iSendTheMessageThroughKafkaProducer() {
        kafkaTemplate.send(TOPIC, inventory);
        log.info("successfully produced the inventory message for upc " + inventory.getUpcId());
    }

    @Then("I should receive in consumer")
    public void iShouldReceiveInConsumer() throws InterruptedException {
        Thread.sleep(20000);
        AtomicBoolean dataMatchedInConsumer = new AtomicBoolean(false);
        if (eventListener.eventData.size() > 0) {
            eventListener.eventData.forEach(consumerInventory -> {
                if (consumerInventory.getUpcId().equals(inventory.getUpcId())
                        && consumerInventory.getStoreId().equals(inventory.getStoreId())
                        && consumerInventory.getItemQty().equals(inventory.getItemQty())) {
                    dataMatchedInConsumer.set(true);
                    log.info("Data is matched in consumer for " + consumerInventory.getUpcId());
                }
            });
        } else {
            Assert.fail("There is no data in Consumer, Please check consumer as we got the zero events from consumer");
        }

        Assert.assertEquals("Data is not found in consumer for Upc" + inventory.getUpcId(), true, dataMatchedInConsumer.get());
    }

    @And("I should the see the data also added in Inventory collection")
    public void iShouldTheSeeTheDataAlsoAddedInRawFarInventoryCollection() {
        rawFarInventory = mongoTemplateSource.find(utils.withMultipleKeys("storeId", inventory.getStoreId(),
                "upcId", inventory.getUpcId()), RawFarInventory.class);
        AtomicBoolean dataMatchedInDB = new AtomicBoolean(false);
        if (rawFarInventory.size() > 0) {
            rawFarInventory.forEach(inventoryData -> {
                if (inventoryData.getUpcId().equals(inventory.getUpcId())
                        && inventoryData.getStoreId().equals(inventory.getStoreId())
                        && inventoryData.getItemQty().equals(inventory.getItemQty())) {
                    dataMatchedInDB.set(true);
                    log.info("Data is available in Database for upc" + inventory.getUpcId());
                }
            });
        } else {
            Assert.fail("Data not found in RawFarInventory, please verify consumer and database for more details");
        }
        Assert.assertEquals("Data not found in RawFarInventory for upc" + inventory.getUpcId(), true, dataMatchedInDB.get());
    }

}
