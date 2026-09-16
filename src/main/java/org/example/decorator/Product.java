

package org.example.decorator;

import java.time.LocalDate;
import org.example.builder.Category;

// =========================================================================
// TASK 3: Implement the Interface
// We make our core Product class implement the new Sellable interface.
// =========================================================================
public class Product implements Sellable {

    // =====================================================================
    // TASK 1: Add Price to Product
    // We added the private final 'price' field to the Product class here.
    // =====================================================================
    private final String id;
    private final String name;
    private final Category category;
    private final int rating;
    private final double price; // <-- TASK 1: Price attribute added
    private final LocalDate createdDate;
    private final LocalDate modifiedDate;

    // =====================================================================
    // TASK 1 (Continued): Update the Product Constructor
    // The private constructor is updated to copy the price from the builder.
    // =====================================================================
    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.rating = builder.rating;
        this.price = builder.price; // <-- TASK 1: Assigned here
        this.createdDate = builder.createdDate;
        this.modifiedDate = builder.modifiedDate;
    }

    // Implementing Sellable interface methods
    @Override public String getId() { return id; }
    @Override public String getName() { return name; }
    @Override public double getPrice() { return price; } // <-- TASK 1: Getter returns price

    public Category getCategory() { return category; }
    public int getRating() { return rating; }
    public LocalDate getCreatedDate() { return createdDate; }
    public LocalDate getModifiedDate() { return modifiedDate; }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

    // =====================================================================
    // TASK 1 (Continued): Update the Builder Class
    // The Builder static nested class is updated to support the price field.
    // =====================================================================
    public static class Builder {
        private String id;
        private String name;
        private Category category;
        private int rating;
        private double price = 0.0; // <-- TASK 1: Added field with default value
        private LocalDate createdDate = LocalDate.now();
        private LocalDate modifiedDate = LocalDate.now();

        public Builder id(String id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder category(Category category) { this.category = category; return this; }
        public Builder rating(int rating) { this.rating = rating; return this; }

        // <-- TASK 1: Added setter method for price supporting method chaining
        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Product build() {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalStateException("Product name cannot be null or empty");
            }
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalStateException("Product id cannot be null or empty");
            }
            if (price < 0) {
                throw new IllegalStateException("Price cannot be negative");
            }
            return new Product(this);
        }
    }
}
