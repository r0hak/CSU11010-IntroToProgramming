
public class Currency implements Portfolio{
	public double amount;
	
	public Currency(double amt) {
		this.amount = amt;
	}
	@Override
	public double marketVal() {
		return this.amount;
	}
	@Override
	public double profit() {
		return 0;
	}
	public String toString() {
		return String.format("Cash ( $ %.2f )", amount);
	}
}
