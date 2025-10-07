package QuanLyThanhToan;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Product {
    private final String id;
    private final String name;
    private final double unitPrice;
    private final String category;

    protected Product(String id, String name, double unitPrice, String category) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.category = category;
    }

    public String id() { return id; }
    public String name() { return name; }
    public double unitPrice() { return unitPrice; }
    public String category() { return category; }

    protected abstract String extraInfo();

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%s) %s",
                id, name, Money.format(unitPrice), category, extraInfo());
    }
}
