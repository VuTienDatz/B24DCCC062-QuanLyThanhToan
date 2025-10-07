package QuanLyThanhToan;

import java.text.NumberFormat;
import java.util.Locale;

public class Money {
    private static final Locale VI = new Locale("vi", "VN");
    private static final NumberFormat CURRENCY = NumberFormat.getCurrencyInstance(VI);

    public static String format(double amount) {
        return CURRENCY.format(amount);
    }
}
