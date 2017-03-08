package design.strategy;

/**
 * 算法类
 * 		新客户大批量打9折
 * @ClassName: NewCustomerFewStrategy 
 * @Description:
 * @author renzy 
 * @date 2017年3月6日 上午10:27:58 
 *
 */
public class NewCustomerManyStrategy implements Strategy{

	@Override
	public Double getPrice(Double standardPrice) {
		System.out.println("新客户大批量打9折");
		return standardPrice*0.9;
	}

}
