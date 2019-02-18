import java.util.*;
import java.util.stream.*;

public class PSI{
	public static int solve(List<Integer> list){
		int count = 0;
		int sum = 0;
		int size = list.size();

		// start with first digit of subsequence
		for(int i=0; i<size; i++){
			// increment count if digit is positive
			if((sum+= list.get(i)) > 0){
				count++;
			}

			// increment count if consecutive element sum is positive
			for(int j=i+1; j<size; j++){
				if((sum += list.get(j)) > 0){
					count++;
				}
			}
			sum = 0;
		}

		return count;
	}

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		// String inputString = "1 -2 5 -7 4 3";

		List<Integer> list = Arrays.stream(inputString.split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        
		System.out.println("Count: " + solve(list));
	}
}