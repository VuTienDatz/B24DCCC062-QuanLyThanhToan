package QuanLyThanhToan;

import java.time.LocalDate;

public class FoodProduct extends Product {
    private final LocalDate expiryDate;

    public FoodProduct(String id, String name, double price, LocalDate expiry) {
        super(id, name, price, "Thuc pham");
        this.expiryDate = expiry;
    }

    public boolean isExpired(LocalDate onDate) {
        return expiryDate.isBefore(onDate);
    }

    @Override
    protected String extraInfo() {
        return String.format("- HSD: %s", expiryDate);
    }
}
