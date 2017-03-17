package design.state.example;

public class NightStat implements Stat {

	@Override
	public void writeProgram(WorkContext workContext) {
		if(workContext.getHour() < 22) {
			if(workContext.getFinashed()) {
				workContext.setStat(new RestStat());
				return;
			}
			System.out.println("当前时间："+workContext.getHour()+"困死了要");
		} else {
			workContext.setStat(new SleepStat());
		}
	}

}
