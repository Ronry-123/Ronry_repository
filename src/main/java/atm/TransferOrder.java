package atm;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Random;

public final class TransferOrder extends Order {
    private String orderId;
    private String fromAccountId;
    private String toAccountId;
    private double amount;
    private boolean isSuccess;
    private Date time = new Date();

    public TransferOrder(String fromAccountId, String toAccountId, double amount) {
        this.orderId = getRandomOrderId(fromAccountId+toAccountId);
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    @Override
    public String getOrderId() {

        return orderId;
    }

    private String getRandomOrderId(String prefix) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(prefix);
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(10);
            sb.append(num);
        }
        return sb.toString();
    }

    @Contract(pure = true)
    public @NotNull String toString() {
        return "CashOrder [orderId:" + orderId + ", fromId:" + fromAccountId + ", toId:" + toAccountId + ", time=" + time
                +  ", amount=" + amount + ", isSuccess=" + isSuccess +"]";
    }
    @Override
    public boolean getIsSuccess() {
        return isSuccess;
    }
}