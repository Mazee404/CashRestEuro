import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class Calculation {
	
	public String drobiz(BigDecimal bills, BigDecimal clients) {
		
		String x = "";
		BigDecimal bill =  bills;		
		BigDecimal client =  clients;	
		BigDecimal HUNDRED = new BigDecimal(100);	
		BigDecimal change1 = bill.subtract(client);
		BigDecimal change2 = change1.multiply(HUNDRED);	    

		BigDecimal[] vrednosti = {new BigDecimal(1), new BigDecimal(2), new BigDecimal(5), 
								  new BigDecimal(10), new BigDecimal(20), new BigDecimal(50),
								  new BigDecimal(100), new BigDecimal(200), new BigDecimal(500), 
								  new BigDecimal(1000), new BigDecimal(2000), new BigDecimal(5000), 
								  new BigDecimal(10000), new BigDecimal(20000), new BigDecimal(50000)};
		
		int i = vrednosti.length-1; 
		BigDecimal st;
				
		while (change2.compareTo(BigDecimal.ZERO) > 0 && i >= 0) {				
			st = change2.divide(vrednosti[i],0,RoundingMode.DOWN);
			if (st.compareTo(BigDecimal.ZERO) != 0) { 						
				if (change2.compareTo(BigDecimal.valueOf(100)) >= 0) {
					x += ("\t"+(vrednosti[i].divide(HUNDRED))+"€ = "+st+"\n"); 
				} else if (change2.compareTo(BigDecimal.valueOf(10)) >= 0){
					x += ("\t"+(vrednosti[i].divide(HUNDRED))+"0c = "+st+"\n");
				} else  if (change2.compareTo(BigDecimal.valueOf(1)) >= 0){
					x += ("\t"+(vrednosti[i].divide(HUNDRED))+"c = "+st+"\n");
				}				
				change2 = change2.subtract(st.multiply(vrednosti[i]));
			}
			i--;
		}		
		return x;
	}
			
	public String VraDenarja(BigDecimal bills, BigDecimal clients) {
		BigDecimal bill = bills;	
		BigDecimal client = clients;	
		BigDecimal vra = bill.subtract(client);		
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.ITALY); 
	    String s = n.format(vra);	    
		return s;
	}
}
