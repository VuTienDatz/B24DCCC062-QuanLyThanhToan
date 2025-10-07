package QuanLyThanhToan;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product iphone = new ElectronicProduct("P001", "iPhone 15", 19990000, "356789012345678", 12);
        Product milk = new FoodProduct("F001", "Sua tuoi 1L", 35000, LocalDate.now().plusDays(7));
        Product snack = new FoodProduct("F002", "Banh Snack 100g", 18000, LocalDate.now().plusMonths(3));

        System.out.println("=== DANH MUC SAN PHAM ===");
        System.out.println(iphone);
        System.out.println(milk);
        System.out.println(snack);
        System.out.println();

        // Đơn hàng 1 - Thanh toán tiền mặt
        Order orderA = new Order("Nguyen Van A");
        orderA.addItem(milk, 2);
        orderA.addItem(snack, 3);
        orderA.setPaymentCash();
        orderA.printSummary();
        orderA.checkout();
        System.out.println();

        // Đơn hàng 2 - Thanh toán thẻ tín dụng
        Order orderB = new Order("Nguyen Van B");
        orderB.addItem(iphone, 1);
        orderB.addItem(snack, 5);
        orderB.setPaymentCard("4111111111111111", "NGUYEN VAN B");
        orderB.printSummary();
        orderB.checkout();
        System.out.println();

        // Đơn hàng 3 - Thanh toán bằng ví Momo
        Order orderC = new Order("Tran Thi C");
        orderC.addItem(iphone, 1);
        orderC.setPaymentMomo("0903-xxx-xxx");
        orderC.printSummary();
        orderC.checkout();
    }
}
