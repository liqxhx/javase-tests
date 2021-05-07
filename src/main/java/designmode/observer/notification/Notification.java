package designmode.observer.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> 类描述: 通知
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/07/02 22:48
 * @since 2020/07/02 22:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    // 系统
    public static final int NOTI_BOOTUP = 1;
    public static final int NOTI_REFRESH = 2;

    // 应用

    private int type;
    private Object data;
}
