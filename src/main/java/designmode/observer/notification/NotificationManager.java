package designmode.observer.notification;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * <p> 类描述: Notification Manager Implementation
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/07/02 22:56
 * @since 2020/07/02 22:56
 */
public class NotificationManager implements INotificationManager {

    private Map<Integer, List<INotificationListener>> listenerMap;
    private INotificationPublisher notificationPublisher;
    private boolean async;
    private ThreadPoolExecutor threadPoolExecutor;

    public NotificationManager(List<INotificationListener> listenerList, boolean asyncMode) {
        listenerMap = new ConcurrentHashMap<>();


        this.async = asyncMode;
        if(this.async) {
            threadPoolExecutor = new ThreadPoolExecutor(
                    4,
                    8,
                    1000L,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(100),
                    runnable -> {
                        Thread thread = new Thread(runnable);
                        thread.setDaemon(false);
                        thread.setPriority(Thread.NORM_PRIORITY);
                        thread.setName("notimgr-" + thread.getName().toLowerCase());
                        return thread;
                    },
                    (r, executor) -> System.out.println(String.format("#notimgr#pool#rejected Task:%s rejected from %", r.toString(), executor.toString()))
            );
        }
    }

    @Override
    public void onNotification(Notification notification) {
        List<INotificationListener> listeners = listenerMap.get(notification.getType());
        if(listeners != null) {
            if(async) {
                for (INotificationListener listener : listeners) {
                   threadPoolExecutor.execute(() -> listener.handleNotification(notification));
                }
            } else {
                for (INotificationListener listener : listeners) {
                    listener.handleNotification(notification);
                }
            }
        }

    }

    @Override
    public void publishNotifcation(Notification notification) {
        this.notificationPublisher.publishNotification(notification);
    }

    public void destory() {
        if(async) {
            threadPoolExecutor.shutdown();
        }
    }
}
