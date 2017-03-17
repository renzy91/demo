package design.state.example;

public class SleepStat implements Stat {

	@Override
	public void writeProgram(WorkContext workContext) {
		System.out.println("已困死");
	}

}
