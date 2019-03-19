package com.katas;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCart {

    private Map<Book, Integer> orders = new HashMap<>();

    public ShoppingCart() {
    }

    public ShoppingCart(Map<Book, Integer> orders) {
        this.orders = orders;
    }

    public void addBook(Book b) {
        addBook(b, 1);
    }

    public void addBook(Book b, int numCopies) {
        if (orders.containsKey(b))
            orders.put(b, orders.get(b) + numCopies);
        else
            orders.put(b, numCopies);
    }

    public Double calculateTotal() {
        return orders.entrySet().stream()
                .map((entry) -> entry.getKey().getPrice() * entry.getValue())
                .reduce(Double::sum)
                .orElse(0d);
    }

    public Double calculateTotalWithDiscounts() {
        var total = calculateTotal();

        if (orders.size() > 1) {
            Map<Integer, Integer> disc = calculateDiscounts();

            var discPrice = disc.entrySet().stream()
                    .map(e -> discount(e.getKey()) * e.getValue())
                    .reduce((a, b) -> a + b);

            total = total - total * discPrice.orElse(0d);
        }

        return total;
    }

    private Map<Integer, Integer> calculateDiscounts() {
        Map<Book, Integer> discounts = Map.copyOf(orders);
        Map<Integer, Integer> result = new HashMap<>();

        int discValue;

        while (discounts.size() > 1) {

            discValue = discounts.size();

            if (result.containsKey(discValue))
                result.put(discValue, result.get(discValue) + 1);
            else
                result.put(discValue, 1);

            discounts = discounts.entrySet().stream()
                    .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue() - 1))
                    .filter(e -> e.getValue() > 0)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }

        return result;
    }

    private Double discount(int distinctBooks) {
        switch (distinctBooks) {
            case 1:
                return 0d;
            case 2:
                return 0.05d;
            case 3:
                return 0.1d;
            case 4:
                return 0.2d;
            case 5:
                return 0.25d;
            default:
                return Double.NaN;
        }
    }
}