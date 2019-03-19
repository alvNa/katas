package com.katas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * def testBasics
 *     assert_equal(0, price([]))
 *     assert_equal(8, price([0]))
 *     assert_equal(8, price([1]))
 *     assert_equal(8, price([2]))
 *     assert_equal(8, price([3]))
 *     assert_equal(8, price([4]))
 *     assert_equal(8 * 2, price([0, 0]))
 *     assert_equal(8 * 3, price([1, 1, 1]))
 *     end
 */
@DisplayName("Dictionary replacer tests")
public class BookPriceTest {
    private Book hp1 = new Book("Harry Potter",BookVolume.I, 8D);
    private Book hp2 = new Book("Harry Potter",BookVolume.I, 8D);
    private Book hp3 = new Book("Harry Potter",BookVolume.I, 8D);
    private Book hp4 = new Book("Harry Potter",BookVolume.I, 8D);
    private Book hp5 = new Book("Harry Potter",BookVolume.I, 8D);


    @Test
    public void shouldCalculateTotalWhenEmptyCart() throws Exception {
        ShoppingCart cart = new ShoppingCart(Map.of());
        assertEquals(cart.calculateTotal(), BigDecimal.ZERO);
    }

    @Test
    public void shouldCalculatePriceVolI() throws Exception {
        Map<Book,Integer> orders = Map.of(hp1,1);

        ShoppingCart cart = new ShoppingCart(orders);
        assertEquals(cart.calculateTotal(), 8D);
    }

    @Test
    public void shouldCalculatePriceVolII() throws Exception {
        ShoppingCart cart = new ShoppingCart(Map.of(hp2,1));
        assertEquals(cart.calculateTotal(), 8D);
    }

    @Test
    public void shouldCalculatePriceVolIII() throws Exception {
        ShoppingCart cart = new ShoppingCart(Map.of(hp3,1));
        assertEquals(cart.calculateTotal(), 8D);
    }

    @Test
    public void shouldCalculatePriceVolIV() throws Exception {
        ShoppingCart cart = new ShoppingCart(Map.of(hp4,1));
        assertEquals(cart.calculateTotal(), 8D);
    }

    @Test
    public void shouldCalculatePriceVolV() throws Exception {
        ShoppingCart cart = new ShoppingCart(Map.of(hp5,1));
        assertEquals(cart.calculateTotal(), 8D);
    }

    @Test
    public void shouldCalculatePriceSeveralVolI() throws Exception {
        Map<Book,Integer> orders = Map.of(hp1,1*2);

        ShoppingCart cart = new ShoppingCart(orders);
        assertEquals(cart.calculateTotal(), new BigDecimal(8*2));
    }

    @Test
    public void shouldCalculatePriceSeveralVolII() throws Exception {
        Map<Book,Integer> orders = Map.of(hp2,1*3);

        ShoppingCart cart = new ShoppingCart(orders);
        assertEquals(cart.calculateTotal(), new BigDecimal(8*3));
    }

    /**
     * def testSimpleDiscounts
     *   assert_equal(8 * 2 * 0.95, price([0, 1]))
     *   assert_equal(8 * 3 * 0.9, price([0, 2, 4]))
     *   assert_equal(8 * 4 * 0.8, price([0, 1, 2, 4]))
     *   assert_equal(8 * 5 * 0.75, price([0, 1, 2, 3, 4]))
     * end
     * */

    @Test
    public void shouldCalculateWithDiscount() throws Exception {
        Map<Book,Integer> orders = Map.of(hp1,1,hp2,1);

        ShoppingCart cart = new ShoppingCart(orders);
        assertEquals(cart.calculateTotal(), new BigDecimal(8*2));
    }
}
