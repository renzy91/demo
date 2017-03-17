package design.state.example;

public class RestStat implements Stat {

	@Override
	public void writeProgram(WorkContext workContext) {
		System.out.println("下班了.............");
	}

}
