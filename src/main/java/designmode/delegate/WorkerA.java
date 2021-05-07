package designmode.delegate;

/**
 * <p> 类描述: TODO
 *
 * @author qhlee
 * @version TODO
 * @date 2020/06/29 22:29
 * @since 2020/06/29 22:29
 */
public class WorkerA implements Worker{
    @Override
    public void work(String command) {
        System.out.println("加密 ".concat(command));
    }
}
