package designmode.stragegy.pay;

/**
 * <p> 类描述: 支付
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/06/29 21:59
 * @since 2020/06/29 21:59
 */
public interface PaymentStrategy {
    PayState pay(String uid, double amount);
}
