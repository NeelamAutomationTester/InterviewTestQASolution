import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class JsonTest{

    JsonReader jsonReader = new JsonReader();
    CostAnalysis costAnalysis = new CostAnalysis();
    List<CostAnalysis> ca;
    


@Test
public void verifyCountOfRecords() throws IOException {
     ca = jsonReader.readRecords();
    System.out.printf("Loaded %,d records%n", ca.size());
    assertEquals(53,ca.size());
    ca.forEach(System.out::println);   
      
}

@Test
    public void descendingCostTest() throws IOException{
        ca = jsonReader.readRecords();
        ca.sort(Comparator.comparing(CostAnalysis::getCost).reversed());
        System.out.println("Arranged list in descending Order..");
        assertEquals(0,ca.get(0).getCountryId());
         System.out.println("Country id for top element in the list is: "+ca.get(0).getCountryId());
        ca.forEach(System.out::println);
        
    }

    @Test
    public void sumOfCost() throws IOException{

        ca = jsonReader.readRecords();

        BigDecimal expectedSum = BigDecimal.valueOf(77911.3744561);
        BigDecimal sum  = BigDecimal.ZERO;
        for(int i=0; i<ca.size(); i++){
          

            if(ca.get(i).getYearId().equals("2016")){
               sum = sum.add(ca.get(i).getCost());                
            }           
        } 
        System.out.println("Sum of cost for the year 2016 is: "+sum);
        assertEquals(expectedSum,sum);     
    }    
   
}
