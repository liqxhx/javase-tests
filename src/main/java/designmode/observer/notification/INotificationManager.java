package designmode.observer.notification;

/**
 * <p> 类描述: Notification Manager Interface
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/07/02 22:53
 * @since 2020/07/02 22:53
 */
public interface INotificationManager {
    /**
     * 收到通知
     * @param notification
     */
    void onNotification(Notification notification);

    /**
     * 发布通知，让其它模块的INotificationManager来处理
     * @param notification
     */
    void publishNotifcation(Notification notification);

}
