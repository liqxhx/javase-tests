package designmode.cor.sales;

/**
 * <p> 类描述: 一线销售人员，可以批准5%内的折扣
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/07/07 20:52
 * @since 2020/07/07 20:52
 */
public class Sales extends PriceHandler {

    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.05) {
            System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(), discount);
        } else {
            successor.processDiscount(discount);
        }
    }
}
