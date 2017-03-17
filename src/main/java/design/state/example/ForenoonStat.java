package design.state.example;

public class ForenoonStat implements Stat{

	@Override
	public void writeProgram(WorkContext workContext) {
		if(workContext.getHour() < 12) {
			System.out.println("当前时间："+workContext.getHour()+"精神百倍");
		} else {
			workContext.setStat(new NoonStat());
		}
	}
	
}
