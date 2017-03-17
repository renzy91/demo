package design.state.example;

public class NoonStat implements Stat {

	@Override
	public void writeProgram(WorkContext workContext) {
		if(workContext.getHour() < 14) {
			System.out.println("当前时间："+workContext.getHour()+"中午了，又困又饿");
		} else {
			workContext.setStat(new AfternoonStat());
		}

	}

}
