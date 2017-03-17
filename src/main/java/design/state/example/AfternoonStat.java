package design.state.example;

public class AfternoonStat implements Stat {

	@Override
	public void writeProgram(WorkContext workContext) {
		if(workContext.getHour() < 18) {
			System.out.println("当前时间："+workContext.getHour()+"下午了，精神还可以");
		} else {
			workContext.setStat(new NightStat());
		}

	}

}
