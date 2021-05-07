package designmode.observer.notification;

import java.util.List;

/**
 * <p> 类描述: Notification Listener Interface
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/07/02 22:59
 * @since 2020/07/02 22:59
 */
public interface INotificationListener {
    /**
     * 对哪些通知感兴趣
     * @return
     */
    List<Integer> listInterests();

    /**
     * 处理通知
     * @param notification
     */
    void handleNotification(Notification notification);
}
