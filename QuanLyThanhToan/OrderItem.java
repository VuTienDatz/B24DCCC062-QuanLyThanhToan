package QuanLyThanhToan;

public class OrderItem {
    private final Product product;
    private final int quantity;

    public OrderItem(Product p, int q) {
        if (q <= 0) throw new IllegalArgumentException("So luong phai > 0");
        this.product = p;
        this.quantity = q;
    }

    public double getLineTotal() {
        return product.unitPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s x%d = %s",
                product.name(), quantity, Money.format(getLineTotal()));
    }
}
