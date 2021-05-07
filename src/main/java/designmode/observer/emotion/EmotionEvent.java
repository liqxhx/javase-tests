package designmode.observer.emotion;

import java.util.EventObject;

/**
 * <p> 类描述: 男女感情事件
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/07/02 22:59
 * @since 2020/07/02 22:59
 */
public class EmotionEvent extends EventObject{

	public EmotionEvent(Object source) {//以事件源为构造参
		super(source);
	}

}
