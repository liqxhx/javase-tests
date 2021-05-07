package designmode.cor.sales;

/**
 * <p> 类描述: PriceHandler Factory
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/07/07 21:50
 * @since 2020/07/07 21:50
 */
public class PriceHandlerFactory {
    public static Sales getPriceHandler() {
        Sales sales = new Sales();
        Manager manager = new Manager();
        CEO ceo = new CEO();
        sales.setSuccessor(manager);
        manager.setSuccessor(ceo);

        return sales;
    }
}
