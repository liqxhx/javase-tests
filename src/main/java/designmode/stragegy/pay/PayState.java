package designmode.stragegy.pay;

/**
 * <p> 类描述: 支付状态
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/06/29 22:01
 * @since 2020/06/29 22:01
 */
public class PayState {
    private int code;
    private Object data;
    private String msg;

    public PayState(int code, String msg,Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString(){
        return ("支付状态：[" + code + "]," + msg + ",交易详情：" + data);
    }
}
