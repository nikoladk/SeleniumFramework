Feature:
Scenario Outline: Customer place an order by purchasing an item from search
Given user is on Home Page
When he search for "dress"
And choose to buy the first item
And select color and size
And moves to checkout from mini cart
And enter <customer> details on checkout page
And select same delivery address
And select payment method as "check" payment
And place the order

Examples:
    |customer   |
    |  Sadio     |