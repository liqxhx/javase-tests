package designmode.observer.emotion.listener;

import designmode.observer.emotion.EmotionEvent;
import designmode.observer.emotion.Girl;

public class BadBoy extends AbstractBoyFirend {
	public BadBoy(){super();}
	public BadBoy(String name){
		super(name);
	}
	@Override
	public void whatCanIdoWhenGirlHappy(EmotionEvent e) {
		Girl girl = (Girl)e.getSource();
		System.out.println(this.getName()+" said:"+girl.getName()+" you happy,I can make you sad.");
	}
	
	@Override
	public void whatCanIdoWhenGirlSad(EmotionEvent e) {
		Girl girl = (Girl)e.getSource();
		System.out.println(this.getName()+" said:"+girl.getName()+" you sad,I'm very happy.");

	}

}
