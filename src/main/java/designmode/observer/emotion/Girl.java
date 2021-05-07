package designmode.observer.emotion;

import designmode.observer.emotion.listener.EmotionEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * 事件源
 * 属性：监听器（单个对象或者是集合），以及其它属性
 * 方法：
 *		注册监听：提供相应的get或set方法，或用addXXX(EventListener listener )
 *		取消监听 : removeXXX(EventListener listener )
 *		发生事件：即以事件源（this)为参数，调用事件监听器相应的方法
 * @author qhlee
 */
public class Girl {
	private String name;
	private List<EventListener> boyFirends = new ArrayList<EventListener>();

	public Girl(){ super(); }
	public Girl(String name){
		this.name = name ;
	}
	public Girl(String name , List<EventListener> boyFirends){
		this.name = name ; 
		this.boyFirends = boyFirends ;
	}

	//注册监听器的方法
	public void addBoyFirend(EventListener boyFirend){		
		this.boyFirends.add(boyFirend);
	}
	//取消监听器的方法
	public void removeBoyFirend(EventListener boyFirend){	
		if(!this.boyFirends.isEmpty() && this.boyFirends.contains(boyFirend)){
			this.boyFirends.remove(boyFirend);
		}
	}

	//发生事件
	public void fire(){																
		//实例化事件对象（要以事件源为构造参数）
		EmotionEvent e = new EmotionEvent(this);
		
		//发生事件就是以事件对象为参数调用监听接口中的方法		
		for(int day = 1 ; day <= 10 ; day++){						//发生事件
			System.out.println("Day:"+day);
			for(int i = 0 ; i< this.boyFirends.size() ; i++){	//事件发生后通知每一个监听器来处理
				EmotionEventListener boyFirend = (EmotionEventListener)this.boyFirends.get(i);
				
				if(day%2 == 0){
					boyFirend.whatCanIdoWhenGirlHappy(e);			
				}else{
					boyFirend.whatCanIdoWhenGirlSad(e);
				}
			}
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<EventListener> getBoyFirends() {
		return boyFirends;
	}
	public void setBoyFirends(List<EventListener> boyFirends) {
		this.boyFirends = boyFirends;
	}

}
