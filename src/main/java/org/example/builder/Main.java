
package org.example.builder;

public class Main {
    public static void main(String[] args) {
        Product product = new Product.Builder()
                .id("id1")
                .name("SuperWidget")
                .category(Category.TOOLS)
                .rating(8)
                .build();

        System.out.println("--- Product Created Successfully ---");
        System.out.println(product);
    }
}

