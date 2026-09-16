
package org.example.decorator;

// =========================================================================
// TASK 5: Create a Concrete DiscountDecorator
// This class extends ProductDecorator and modifies the price dynamically.
// =========================================================================
public class DiscountDecorator extends ProductDecorator {

    // Field for the discount percentage
    private final double discountPercentage;

    // Constructor accepts a Sellable product and the discount percentage
    public DiscountDecorator(Sellable decoratedProduct, double discountPercentage) {
        super(decoratedProduct); // Sends the product to the abstract parent constructor
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        this.discountPercentage = discountPercentage;
    }

    // Override the getPrice() method to inject the new functionality (The Discount)
    @Override
    public double getPrice() {
        // Gets the original price from the decorated product
        double originalPrice = decoratedProduct.getPrice();

        // Returns the new, discounted price
        return originalPrice * (1 - (discountPercentage / 100.0));
    }
}

