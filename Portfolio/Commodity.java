
public class Commodity extends MyAssets{
	public double totalShares;
	
	public Commodity(String shareName, double sharePrice) {
		symbol = shareName;
		curPrice= sharePrice;
	}
	@Override
	public double marketVal() {
		return (totalShares * curPrice);
	}
	public void purchase(double shares, double sharePrice) {
		totalShares += shares;
		totalCost = totalCost + (shares * sharePrice);
	}
	public void setCurrentPrice(double marketVal) {
		curPrice = marketVal;
	}
	public double profit() {
		return ( (totalShares * curPrice) - totalCost);
	} 
	public String toString() {
		return String.format("%s ( %.0f shares, $ %.2f total cost )", symbol, totalShares, totalCost);
	}
}
