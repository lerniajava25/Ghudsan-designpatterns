

package org.example.decorator;

import org.example.builder.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductDecoratorTest {

    private Product baseProduct;

    // Denna metod körs automatiskt före varje enskilt test för att ge oss ett rent testobjekt
    @BeforeEach
    public void setUp() {
        baseProduct = new Product.Builder()
                .id("test-id")
                .name("Test Laptop")
                .category(Category.ELECTRONICS)
                .price(1000.0)
                .build();
    }

    // =========================================================================
    // TEST 1: Verifiera att basprodukten har rätt värden från början
    // =========================================================================
    @Test
    public void testBaseProductCorrectness() {
        assertEquals("test-id", baseProduct.getId());
        assertEquals("Test Laptop", baseProduct.getName());
        assertEquals(1000.0, baseProduct.getPrice(), 0.001);
    }

    // =========================================================================
    // TEST 2: Verifiera att DiscountDecorator räknar ut rätt rabatterat pris
    // =========================================================================
    @Test
    public void testDiscountDecoratorCalculatesCorrectPrice() {
        // Skapar en dekoratör med 20% rabatt runt basprodukten
        Sellable discountedItem = new DiscountDecorator(baseProduct, 20.0);

        // Kontrollera att det rabatterade priset blir exakt 800.0
        assertEquals(800.0, discountedItem.getPrice(), 0.001);

        // Kontrollera att originalproduktens pris fortfarande är HELT ORÖRT (1000.0)
        assertEquals(1000.0, baseProduct.getPrice(), 0.001);
    }

    // =========================================================================
    // TEST 3: Verifiera att dekoratören skickar vidare (delegerar) namn och ID korrekt
    // =========================================================================
    @Test
    public void testDecoratorDelegatingMethods() {
        Sellable decoratedItem = new DiscountDecorator(baseProduct, 10.0);

        // Dekoratören ska returnera exakt samma ID och namn som originalet
        assertEquals("test-id", decoratedItem.getId());
        assertEquals("Test Laptop", decoratedItem.getName());
    }

    // =========================================================================
    // TEST 4: Verifiera valideringen av felaktiga rabattsatser (Felhantering)
    // =========================================================================
    @Test
    public void testInvalidDiscountThrowsException() {
        // En rabatt över 100% ska kasta ett IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new DiscountDecorator(baseProduct, 150.0);
        });

        // En negativ rabatt ska också kasta ett IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new DiscountDecorator(baseProduct, -5.0);
        });
    }
}

