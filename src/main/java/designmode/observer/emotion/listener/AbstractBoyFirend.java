package designmode.observer.emotion.listener;

import java.util.ArrayList;
import java.util.List;



public abstract class AbstractBoyFirend  implements EmotionEventListener{	
	private String name;		
	private List sources = new ArrayList();	
	public AbstractBoyFirend(){super();}
	public AbstractBoyFirend(String name){
		this.name = name;
	}
	public void addEventSource(Object source){
		this.sources.add(source);
	}
	public void removeSource(Object source){
		if(!sources.isEmpty() && this.sources.contains(source)){
			this.sources.remove(source);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getSources() {
		return sources;
	}
	public void setSources(List sources) {
		this.sources = sources;
	}
	
}
