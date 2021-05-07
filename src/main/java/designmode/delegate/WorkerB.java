package designmode.delegate;

/**
 * <p> 类描述: TODO
 *
 * @author qhlee
 * @version TODO
 * @date 2020/06/29 22:29
 * @since 2020/06/29 22:29
 */
public class WorkerB implements Worker{
    @Override
    public void work(String command) {
        System.out.println("业务 ".concat(command));
    }
}
