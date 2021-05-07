package designmode.stragegy.pay;

/**
 * 姑且把这个枚举当做一个常量去维护
 * Created by Tom on 2018/3/11.
 */
public enum PayType {
    ALI_PAY(new AliPay()),
    WECHAT_PAY(new WeChatPay());

    private PaymentStrategy paymentStrategy;
    PayType(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentStrategy get(){ return  this.paymentStrategy;}
}
