package design.state.example;

/**
 * 工作类
 * @ClassName: WorkContext 
 * @author renzy 
 * @date 2017年3月17日 下午5:32:36 
 *
 */
public class WorkContext {
	private Stat stat;
	private Integer hour = 0;
	private Boolean finashed = false;
	
	public WorkContext() {
		this.stat = new ForenoonStat();
	}

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
		stat.writeProgram(this);
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Boolean getFinashed() {
		return finashed;
	}

	public void setFinashed(Boolean finashed) {
		this.finashed = finashed;
	}
	
	public void handle() {
		stat.writeProgram(this);
	}
	
}
