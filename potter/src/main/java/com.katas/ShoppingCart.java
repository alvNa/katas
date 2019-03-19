package com.katas;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ShoppingCart {

    private Map<Book,Integer> orders = new HashMap<>();

    public ShoppingCart(){
    }

    public ShoppingCart(Map<Book,Integer> orders){
        this.orders = orders;
    }

    public void addBook(Book b){
        addBook(b, 1);
    }

    public void addBook(Book b, int numCopies){
        if (orders.containsKey(b))
            orders.put(b,orders.get(b)+numCopies);
        else
            orders.put(b,numCopies);
    }

    public void getClearBooks() {
        orders.clear();
    }

    public Double calculateTotal(){
        /*
        return orders.entrySet().stream()
                .map((entry)-> entry.getKey().getPrice()
                .multiply(new BigDecimal(entry.getValue()))).reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);*/

        return orders.entrySet().stream()
                .map((entry)-> entry.getKey().getPrice() * entry.getValue())
                .reduce(Double::sum)
                .orElse(0d);
    }

    public Double calculateTotalWithDiscounts(){
        var total = calculateTotal();

        if (orders.size()>1) {
            Map<Integer, Integer> disc = calculateDiscounts();

            var discPrice = disc.entrySet().stream()
                    .map(e -> discount(e.getKey()) * e.getValue())
                    .reduce((a, b) -> a + b);

            //var d = new BigDecimal(discPrice.orElse(0F));
            //System.out.println(total.subtract(total.multiply(d)).toString());
            total = total - total * discPrice.orElse(0d);
        }

        return total;
    }

    private Map<Integer,Integer> calculateDiscounts(){
        Map<Book,Integer> discounts = Map.copyOf(orders);
        Map<Integer,Integer> result = new HashMap<>();

        AtomicInteger discValue = new AtomicInteger(0);

        while (discounts.size()>1){
            discValue.set(0);

            //discounts.values().stream().map(v -> { discValue.incrementAndGet(); return v - 1;} );

            discValue.set(discounts.size());

            if (result.containsKey(discValue))
                result.put(discValue.intValue(),result.get(discValue)+1);
            else
                result.put(discValue.intValue(),1);

            /*for (Map.Entry<Book, Integer> e: discounts.entrySet()) {
                if (e.getValue() == 0){
                    discounts.remove(e.getKey());
                }
            }*/
            /*
            discounts = discounts.entrySet().stream()
                    .map( e -> new Map.Entry<Book,Integer>(e.getKey(),e.getValue()-1));
                    //.collect(Collectors.toMap(x -> x.getKey(), x-> x.getValue() -1));

            discounts = discounts.entrySet().stream()
                    .filter(k -> k.getValue()>0).collect(Collectors.toMap(x -> x.getKey(), x-> x.getValue());
*/
            discounts = discounts.entrySet().stream()
                            .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue()-1))
                            .filter(e -> e.getValue()>0)
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }

        return result;
    }

    /*private float discount(int distinctBooks) {
        switch (distinctBooks) {
            case 1: return 1f;
            case 2: return 0.95f;
            case 3: return 0.9f;
            case 4: return 0.8f;
            case 5: return 0.75f;
            default: return Float.NaN;
        }
    }*/

    private Double discount(int distinctBooks) {
        switch (distinctBooks) {
            case 1: return 0d;
            case 2: return 0.05d;
            case 3: return 0.1d;
            case 4: return 0.2d;
            case 5: return 0.25d;
            default: return Double.NaN;
        }
    }
}