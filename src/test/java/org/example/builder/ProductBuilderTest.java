
package org.example.builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductBuilderTest {

    // =========================================================================
    // TEST 1: Verifiera att Buildern kastar fel om namnet saknas (Validering)
    // =========================================================================
    @Test
    public void testBuilderThrowsExceptionWhenNameIsEmpty() {
        assertThrows(IllegalStateException.class, () -> {
            new Product.Builder()
                    .id("id-123")
                    .name("") // Tomt namn ska stoppa skapandet!
                    .category(Category.TOOLS)
                    .build();
        });
    }

    // =========================================================================
    // TEST 2: Verifiera att Buildern kastar fel om ID saknas (Validering)
    // =========================================================================
    @Test
    public void testBuilderThrowsExceptionWhenIdIsNull() {
        assertThrows(IllegalStateException.class, () -> {
            new Product.Builder()
                    .id(null) // Null ID ska stoppa skapandet!
                    .name("Valid Name")
                    .category(Category.TOOLS)
                    .build();
        });
    }

    // =========================================================================
    // TEST 3: Verifiera att automatiska datum (Defaults) sätts korrekt
    // =========================================================================
    @Test
    public void testBuilderSetsDefaultDatesAutomatically() {
        Product product = new Product.Builder()
                .id("id-1")
                .name("Test Product")
                .category(Category.BOOKS)
                .build();

        // Kontrollera att skapat-datum och modifierat-datum sätts till IDAG automatiskt
        assertNotNull(product.getCreatedDate());
        assertNotNull(product.getModifiedDate());
    }
}
