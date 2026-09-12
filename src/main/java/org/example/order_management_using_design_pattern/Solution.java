package org.example.order_management_using_design_pattern;


import java.util.*;


interface IOrder {

    public String getName();
    public int getPrice();
    public void setName(String name);
    public void setPrice(int price);

}

interface IOrderSystem {
    /**
     * Add an order to the cart
     */
    void addToCart(IOrder order);

    /**
     * Remove one occurrence of the order from the cart
     */
    void removeFromCart(IOrder order);

    /**
     * Returns total discounted amount
     */
    int calculateTotalAmount();

    /**
     * key = Category
     * value = Sum of discounted prices for that category
     */
    Map<String, Integer> categoryDiscounts();

    /**
     * key = Item Name
     * value = Quantity
     */
    Map<String, Integer> cartItems();
}

interface DiscountStrategy
{
    int discountPrice(IOrder order);
    CATEGORY getCategory();
}

class CheapDiscountStrategy implements DiscountStrategy
{

    @Override
    public int discountPrice(IOrder order) {
        return order.getPrice() - order.getPrice()*10/100;
    }

    @Override
    public CATEGORY getCategory() {
        return CATEGORY.CHEAP;
    }

}

class ModerateDiscountStrategy implements DiscountStrategy
{

    @Override
    public int discountPrice(IOrder order) {
        return order.getPrice() -  order.getPrice()*20/100;
    }

    @Override
    public CATEGORY getCategory() {
        return CATEGORY.MODERATE;
    }

}

class ExpensiveDiscountStrategy implements DiscountStrategy
{

    @Override
    public int discountPrice(IOrder order) {
        return  order.getPrice() - order.getPrice()*30/100;
    }

    @Override
    public CATEGORY getCategory() {
        return CATEGORY.EXPENSIVE;
    }

}

class StrategyFactory
{


        private static final DiscountStrategy CHEAP =
                new CheapDiscountStrategy();

        private static final DiscountStrategy MODERATE =
                new ModerateDiscountStrategy();

        private static final DiscountStrategy EXPENSIVE =
                new ExpensiveDiscountStrategy();


    public static DiscountStrategy getDiscountStrategy(IOrder order)
    {
        if(order.getPrice()<=10)
             return CHEAP;
        if(order.getPrice()<=20)
            return MODERATE;

          return EXPENSIVE;


    }
}



enum CATEGORY
{
    CHEAP, MODERATE, EXPENSIVE;
}

class Order implements IOrder
{

    private String name;
    private int price;

    public Order(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
}

class OrderSystem implements IOrderSystem
{
    Map<String, List<IOrder>> orderMap = new LinkedHashMap<>();
    Map<String, Integer> categoryDiscount = new HashMap<>();



    @Override
    public void addToCart(IOrder order) {

        if(order == null)
            return;

        orderMap.computeIfAbsent(order.getName(),k-> new ArrayList<IOrder>()).add(order);
    }

    @Override
    public void removeFromCart(IOrder order) {
        if(order == null)
            return;
        List<IOrder> orders = orderMap.get(order.getName());
        if(orders != null && !orders.isEmpty())
        {
            orders.remove(orders.size()-1);
            if(orders.isEmpty())
                orderMap.remove(order.getName());
        }

    }

    @Override
    public int calculateTotalAmount() {
        int total =0;
        categoryDiscount.clear();

        for(List<IOrder> orders: orderMap.values())
        {
            for(IOrder order: orders)
            {
                DiscountStrategy strategy = StrategyFactory.getDiscountStrategy(order);
                int discountedAmount= strategy.discountPrice(order);
                total += discountedAmount;
                String category = strategy.getCategory().name();
                categoryDiscount.put(category, categoryDiscount.getOrDefault(category,0)+discountedAmount);
            }
        }
        return total;
    }







    @Override
    public Map<String, Integer> categoryDiscounts() {

        return categoryDiscount;
    }

    @Override
    public Map<String, Integer> cartItems() {
        Map<String, Integer> cartItems = new HashMap<>();
       for(Map.Entry<String,List<IOrder>> entry: orderMap.entrySet())
       {
           cartItems.put(entry.getKey(), entry.getValue().size());
       }

        return cartItems;
    }
}



public class Solution {
    public static void main(String[] args) {
        IOrderSystem orderSystem = new OrderSystem();

        // Create Orders
        IOrder order1 = new Order("Television", 40);
        IOrder order2 = new Order("Computer", 30);
        IOrder order3 = new Order("Television", 40);
        IOrder order4 = new Order("Mouse", 8);
        IOrder order5 = new Order("Keyboard", 18);
        IOrder order6 = new Order("Laptop", 70);

        // =====================
        // Add Orders
        // =====================
        orderSystem.addToCart(order1);
        orderSystem.addToCart(order2);
        orderSystem.addToCart(order3);
        orderSystem.addToCart(order4);
        orderSystem.addToCart(order5);
        orderSystem.addToCart(order6);

        // =====================
        // Cart Items
        // =====================
        System.out.println("Cart Items");
        Map<String, Integer> cartItems = orderSystem.cartItems();

        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey() + " (" + entry.getValue() + " items)");
        }

        // =====================
        // Total Discounted Amount
        // =====================
        System.out.println();
        System.out.println("Total Amount : " + orderSystem.calculateTotalAmount());

        // =====================
        // Category Discounts
        // =====================
        System.out.println();
        System.out.println("Category Discounts");

        Map<String, Integer> categoryDiscounts = orderSystem.categoryDiscounts();

        for (Map.Entry<String, Integer> entry : categoryDiscounts.entrySet()) {
            System.out.println(entry.getKey() + " Category Discount : " + entry.getValue());
        }

        // =====================
        // Remove Item
        // =====================
        System.out.println();
        System.out.println("Removing Television");

        orderSystem.removeFromCart(order1);

        // =====================
        // Cart After Removal
        // =====================
        System.out.println();
        System.out.println("Cart After Removal");

        cartItems = orderSystem.cartItems();

        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey() + " (" + entry.getValue() + " items)");
        }

        // =====================
        // Recalculate
        // =====================
        System.out.println();
        System.out.println("Total Amount After Removal : "
                + orderSystem.calculateTotalAmount());

        System.out.println();

        categoryDiscounts = orderSystem.categoryDiscounts();

        for (Map.Entry<String, Integer> entry : categoryDiscounts.entrySet()) {
            System.out.println(entry.getKey() + " Category Discount : " + entry.getValue());
        }
    }
}
