package org.example.builder;


import java.time.LocalDate;

public class Product {
    private final String id;
    private final String name;
    private final Category category;
    private final int rating;
    private final LocalDate createdDate;
    private final LocalDate modifiedDate;

    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.rating = builder.rating;
        this.createdDate = builder.createdDate;
        this.modifiedDate = builder.modifiedDate;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Category getCategory() { return category; }
    public int getRating() { return rating; }
    public LocalDate getCreatedDate() { return createdDate; }
    public LocalDate getModifiedDate() { return modifiedDate; }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", category=" + category
                + ", rating=" + rating + ", createdDate=" + createdDate
                + ", modifiedDate=" + modifiedDate + "]";
    }

    public static class Builder {
        private String id;
        private String name;
        private Category category;
        private int rating;
        private LocalDate createdDate = LocalDate.now();
        private LocalDate modifiedDate = LocalDate.now();

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder createdDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder modifiedDate(LocalDate modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public Product build() {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalStateException("Product name cannot be null or empty");
            }
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalStateException("Product id cannot be null or empty");
            }
            return new Product(this);
        }
    }
}

