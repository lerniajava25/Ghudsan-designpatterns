

package org.example.decorator;

// =========================================================================
// TASK 4: Create an Abstract ProductDecorator
// This abstract class implements Sellable and acts as the base for all decorators.
// =========================================================================
public abstract class ProductDecorator implements Sellable {

    // Holds a reference to a Sellable object to wrap
    protected final Sellable decoratedProduct;

    // The constructor accepts a Sellable object to wrap
    public ProductDecorator(Sellable decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    // Implement interface methods by delegating calls to the decoratedProduct
    @Override
    public String getId() {
        return decoratedProduct.getId(); // Delegating call
    }

    @Override
    public String getName() {
        return decoratedProduct.getName(); // Delegating call
    }

    @Override
    public double getPrice() {
        return decoratedProduct.getPrice(); // Delegating call
    }
}

