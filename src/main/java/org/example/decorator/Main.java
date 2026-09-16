package org.example.decorator;

import org.example.builder.Category;

// =========================================================================
// TASK 6: Show it in Action
// Demonstrating how we wrap a regular Product with the DiscountDecorator.
// =========================================================================
public class Main {
    public static void main(String[] args) {

        // Create a regular Product using the updated Builder pattern (Original price = 1000.0)
        Product laptop = new Product.Builder()
                .id("id-laptop")
                .name("MacBook Pro")
                .category(Category.ELECTRONICS)
                .price(1000.0)
                .build();

        // Wrap the regular product inside the DiscountDecorator with a 20% discount
        Sellable discountedLaptop = new DiscountDecorator(laptop, 20);

        // Printing results to demonstrate the dynamic changes
        System.out.println("--- Decorator Pattern Test ---");
        System.out.println("Product Name: " + discountedLaptop.getName());

        // This should print the untouched original price: 1000.0
        System.out.println("Original laptop.getPrice(): " + laptop.getPrice());

        // This should print the new calculated discounted price: 800.0
        System.out.println("Decorated discountedLaptop.getPrice(): " + discountedLaptop.getPrice());
    }
}
