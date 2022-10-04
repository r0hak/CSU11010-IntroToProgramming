
public class MyAssets implements Portfolio {
	public String symbol;
	public double totalCost;
	public double curPrice;
	
	@Override
	public double profit() {
		return totalCost;
	}
	@Override 
	public double marketVal() {
		return 0;
	}
	
}
