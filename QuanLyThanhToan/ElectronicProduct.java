package QuanLyThanhToan;

public class ElectronicProduct extends Product {
    private final String imei;
    private final int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, String imei, int warrantyMonths) {
        super(id, name, price, "Dien tu");
        this.imei = imei;
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    protected String extraInfo() {
        return String.format("- IMEI: %s, Bao hanh: %d thang", imei, warrantyMonths);
    }
}
