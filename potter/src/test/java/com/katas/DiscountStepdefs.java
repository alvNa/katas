package com.katas;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DiscountStepdefs {

    private static final List<Book> series = Arrays.asList(
            new Book("Harry Potter I", 8D),
            new Book("Harry Potter II", 8D),
            new Book("Harry Potter III", 8D),
            new Book("Harry Potter IV", 8D),
            new Book("Harry Potter V", 8D)
    );

    private ShoppingCart cart = new ShoppingCart();

 /*   @Given("^I request the (\\w+) Most Watched Feed for (\\w+)$")
    public void I_request_the_type_Most_Watched_Feed_for_platform(String type, String platform) throws Throwable {

    }

    ;

    @Given("Alice has installed maven")
    public void alice_has_installed_maven() {
        // Write code here that turns the phrase above into concrete actions
    }*/

    @When("^I buy (\\d+) cop(?:y|ies) of \"([^\"]*)\"$")
    public void I_buy_copy_of(int numCopies, String title) throws Throwable {
        //cart.getClearBooks();
        Book book = bookByTitle(title).orElseThrow(() -> new UnknownTitle(title));
        //IntStream.range(0, numCopies).forEach(n-> cart.addBook(book));
        if (numCopies>0)
            cart.addBook(book,numCopies);
    }


    @Then("^I must pay \\$(\\d+.?\\d*)$")
    public void I_must_pay_$(Double amount) throws Throwable {
        Double expected = amount;
        Double total = cart.calculateTotalWithDiscounts();
        Assert.assertEquals(total, expected);
    }

    private Optional<Book> bookByTitle(String title) {
        return series.stream()
                .filter(book -> title.equals(book.getTitle()))
                .findFirst();
    }

    private static class UnknownTitle extends RuntimeException {
        public UnknownTitle(String title) {
            super(title);
        }
    }
}
