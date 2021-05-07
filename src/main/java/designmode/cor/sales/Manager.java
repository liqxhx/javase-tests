package designmode.cor.sales;

/**
 * <p> 类描述:
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/07/07 20:56
 * @since 2020/07/07 20:56
 */
public class Manager extends PriceHandler {

    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.3f) {
            System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(), discount);
        } else {
            successor.processDiscount(discount);
        }
    }
}
