package tech;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.common.primitives.Ints;

public class UltimateSolution {

	
public static void main(String[] args) throws FileNotFoundException, IOException {
	List<MealsSatisfaction> timeAndSatisfaction = new ArrayList<MealsSatisfaction>();
	List<Integer> times = new ArrayList<Integer>();
	try (BufferedReader br = new BufferedReader(new FileReader(new File("/home/sony/workspace_neon/Gorden/src/tech/data.txt")))) {
	    String line;
	    while ((line = br.readLine()) != null) {
	       // process the line.
	    	String[] val = line.split(" ");
	    	int staisfaction = Integer.parseInt(val[0]);
	    	int time = Integer.parseInt(val[1]);
	    	times.add(time);
	    	timeAndSatisfaction.add(new MealsSatisfaction(time,staisfaction));
	    }
	}
	
	SumSet sumSet = new SumSet();
//	int target = 100;
	Scanner reader = new Scanner(System.in);  // Reading from System.in
	System.out.println("Enter a time: ");
	int target = reader.nextInt();
	
	Integer[] numbers = Arrays.stream( Ints.toArray(times) ).boxed().toArray( Integer[]::new );
	List <TempDataForPartial> tempDataForPartial= sumSet.sum_up_recursive(new ArrayList<Integer>(Arrays.asList(numbers)),target,new ArrayList<Integer>());
	int count = -1;
	int satisfaction = 0;
	int[]sat = new int[tempDataForPartial.size()];
	for (TempDataForPartial tempDataForPartial2 : tempDataForPartial) {
		
		count++;
		satisfaction = 0;
		
		
		List<Integer> tempTimes  = tempDataForPartial2.getTemp();
		for(MealsSatisfaction mealsSatisfaction:timeAndSatisfaction){
			int val = matchFound(mealsSatisfaction,tempTimes);
			satisfaction = satisfaction+val;
			sat[count] = satisfaction;
		}
	}
	
	Arrays.sort(sat);
	
	
	if(sat.length>0){
	System.out.println("Maximum satisfaction:"+sat[sat.length-1]);
	}else{
		System.out.println("Sorry wrong input");
	}
	
		
	}
	


private static int matchFound(MealsSatisfaction mealsSatisfaction, List<Integer> tempTimes) {
	int satisfaction = 0;
	for (Integer integer : tempTimes) {
		if(integer.equals(mealsSatisfaction.getTime())){
			int mealSat = mealsSatisfaction.getStatisfaction();
			satisfaction = satisfaction+mealSat;			
		}
	}
	
	return satisfaction;
}
	
}
