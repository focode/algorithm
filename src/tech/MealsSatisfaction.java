package tech;

public class MealsSatisfaction {
	
	
	public MealsSatisfaction(Integer time,Integer statisfaction) {
		this.time =  time;
		this.statisfaction = statisfaction;
	}
	
	private Integer time;
	private Integer statisfaction;
	
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getStatisfaction() {
		return statisfaction;
	}
	public void setStatisfaction(Integer statisfaction) {
		this.statisfaction = statisfaction;
	}
	
	

}
