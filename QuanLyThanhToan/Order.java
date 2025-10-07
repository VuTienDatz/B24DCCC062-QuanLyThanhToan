package QuanLyThanhToan;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String customerName;
    private final List<OrderItem> items = new ArrayList<>();

    private PaymentType paymentType = null;
    private String cardMasked = null;
    private String cardHolder = null;
    private String momoPhone = null;

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public void addItem(Product p, int qty) {
        items.add(new OrderItem(p, qty));
    }

    // --- Chọn phương thức thanh toán ---
    public void setPaymentCash() {
        this.paymentType = PaymentType.CASH;
        this.cardMasked = this.cardHolder = this.momoPhone = null;
    }

    public void setPaymentCard(String fullCardNumber, String holderName) {
        this.paymentType = PaymentType.CREDIT_CARD;
        String last4 = fullCardNumber.substring(Math.max(0, fullCardNumber.length() - 4));
        this.cardMasked = "**** **** **** " + last4;
        this.cardHolder = holderName;
        this.momoPhone = null;
    }

    public void setPaymentMomo(String phone) {
        this.paymentType = PaymentType.MOMO;
        this.momoPhone = phone;
        this.cardMasked = this.cardHolder = null;
    }

    // --- Tính tổng tiền ---
    public double getSubtotal() {
        return items.stream().mapToDouble(OrderItem::getLineTotal).sum();
    }

    // --- In thông tin đơn hàng ---
    public void printSummary() {
        System.out.println("==== DON HANG ====");
        System.out.println("Khach hang: " + customerName);
        for (OrderItem it : items) System.out.println(" - " + it);
        System.out.println("Tong tien: " + Money.format(getSubtotal()));
        System.out.println("Phuong thuc: " + (paymentType == null ? "(chua chon)" : paymentType));
    }

    // --- Thanh toán ---
    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Don hang trong. Khong the thanh toan");
            return;
        }
        if (paymentType == null) {
            System.out.println("Chua chon phuong thuc thanh toan.");
            return;
        }
        double amount = getSubtotal();

        switch (paymentType) {
            case CASH:
                System.out.printf("Khach hang: %s. Tong tien: %s. Thanh toan tien mat thanh cong.%n",
                        customerName, Money.format(amount));
                break;
            case CREDIT_CARD:
                System.out.printf("Khach hang: %s. Tong tien: %s. Thanh toan bang the tin dung thanh cong (the %s - chu the %s).%n",
                        customerName, Money.format(amount), cardMasked, cardHolder);
                break;
            case MOMO:
                System.out.printf("Khach hang: %s. Tong tien: %s. Thanh toan qua vi Momo (%s) thanh cong.%n",
                        customerName, Money.format(amount), momoPhone);
                break;
        }
    }
}
