package designmode.stragegy.pay;

/**
 * <p> 类描述: we chat pay
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/06/29 22:03
 * @since 2020/06/29 22:03
 */
public class WeChatPay implements PaymentStrategy{
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用微信支付");
        return new PayState(200,"支付成功",amount);
    }
}
