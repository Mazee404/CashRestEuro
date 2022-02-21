import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class Calculation {

	NumberFormat n = NumberFormat.getCurrencyInstance(Locale.ITALY);
	BigDecimal change1;
	
	public String return1(BigDecimal bills, BigDecimal clients) {
		
		String x = "";
		BigDecimal bill =  bills;		
		BigDecimal client =  clients;	
		BigDecimal HUNDRED = new BigDecimal(100);	
		change1 = bill.subtract(client);
		BigDecimal change2 = change1.multiply(HUNDRED);	    
		
		BigDecimal[] money = {new BigDecimal(1), new BigDecimal(2), new BigDecimal(5), 
				    			  new BigDecimal(10), new BigDecimal(20), new BigDecimal(50),
					  			  new BigDecimal(100), new BigDecimal(200), new BigDecimal(500), 
								  new BigDecimal(1000), new BigDecimal(2000), new BigDecimal(5000), 
								  new BigDecimal(10000), new BigDecimal(20000), new BigDecimal(50000)};
		
		int i = money.length-1; 
		BigDecimal num;
				
		while (change2.compareTo(BigDecimal.ZERO) > 0 && i >= 0) {				
			num = change2.divide(money[i],0,RoundingMode.DOWN);
			if (num.compareTo(BigDecimal.ZERO) != 0) { 						
				if (change2.compareTo(BigDecimal.valueOf(100)) >= 0) {
					x += ("\t"+(money[i].divide(HUNDRED))+" E  =  "+num+"\n"); 
				} else if (change2.compareTo(BigDecimal.valueOf(10)) >= 0){
					x += ("\t"+(money[i].divide(HUNDRED))+"0 c  =  "+num+"\n");
				} else  if (change2.compareTo(BigDecimal.valueOf(1)) >= 0){
					x += ("\t"+(money[i].divide(HUNDRED))+" c  =  "+num+"\n");
				}				
				change2 = change2.subtract(num.multiply(money[i]));
			}
			i--;
		}		
		return x;
	}
			
	public String return2() {		 
	    String s = n.format(this.change1);	    
		return s;
	}
}
