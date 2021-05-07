package designmode.cor.sales;

/**
 * <p> 类描述: 价格处理人
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/07/07 20:49
 * @since 2020/07/07 20:49
 */
public abstract class PriceHandler {
    /**
     * 后继 PriceHandler
     */
    protected PriceHandler successor;

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

    /**
     * 处理折扣申请
     * @param discount
     */
    public abstract void processDiscount(float discount);
}
