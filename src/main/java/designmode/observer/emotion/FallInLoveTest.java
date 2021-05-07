package designmode.observer.emotion;

import designmode.observer.emotion.listener.AbstractBoyFirend;
import designmode.observer.emotion.listener.BadBoy;
import designmode.observer.emotion.listener.GoodBoy;

public class FallInLoveTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Girl girl = new Girl("mm");
		
		AbstractBoyFirend goodBoy = new GoodBoy("goodboy");
		AbstractBoyFirend badBoy = new BadBoy("badboy");
		
		girl.addBoyFirend(goodBoy) ;
		girl.addBoyFirend(badBoy) ;
		
		goodBoy.addEventSource(girl) ;
		badBoy.addEventSource(girl) ;
		
		girl.fire() ;

	}

}
