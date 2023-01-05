Feature: Comparing the inventory data in Source and Target

  @Inventory
  Scenario Outline: Verify that data produced in Kafka and Inventory are same or not.
    Given I have "<upcId>" upc with "<storeId>" and "<quantity>"
    When I send the message through kafka Producer
    Then I should receive in consumer
    And I should the see the data also added in Inventory collection
    Examples:
      |upcId      |storeId|quantity|
      |81829001150|243    |16       |