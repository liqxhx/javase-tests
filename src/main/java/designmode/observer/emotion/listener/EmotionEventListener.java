package designmode.observer.emotion.listener;

import designmode.observer.emotion.EmotionEvent;

import java.util.EventListener;

/**
 * 事件监听接口  
 * extends EventListener(标记接口)
 * 接口中每一个方法，都要以相应的事件对象为参数
 * @author
 *
 */
public interface EmotionEventListener extends EventListener {
	//接口的方法要以事件为参数
	void whatCanIdoWhenGirlHappy(EmotionEvent e);
	void whatCanIdoWhenGirlSad(EmotionEvent e);
}
