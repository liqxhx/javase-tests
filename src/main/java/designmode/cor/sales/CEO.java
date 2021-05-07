package designmode.cor.sales;

/**
 * <p> 类描述: CEO
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/07/07 21:46
 * @since 2020/07/07 21:46
 */
public class CEO extends PriceHandler {

    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.5f) {
            System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(), discount);
        } else {
            System.out.format("%s拒绝了折扣:%.2f%n", this.getClass().getName(), discount);
        }
    }
}
