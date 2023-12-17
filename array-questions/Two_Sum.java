import java.util.Map;
import java.util.HashMap;

public class Two_Sum{


	//Method 1: Brute Force
	public int [] twoSum(int [] A, int target){
		for(int i = 0; i < A.length -1; i++){
			for(int j = i +1; j < A.length; j++){
				if(A[i] + A[j] == target){
					System.out.println(i + " "+j);
					return new int [] {i, j};
				}
			}
		}
		return new int [] {};
	}
	//Method 2: Two Pass HashMap
	public int [] twoSumHT(int []A, int target){
		Map <Integer, Integer> map = new HashMap <>();

		for(int i = 0; i < A.length; i++){
			map.put(A[i], i);
		}
		for(int i = 0; i <  A.length; i++){
		// x + y = target; let A[i] = x; A[i] + y = target; y = target - A[i];
			int comp = target - A[i];
			if(map.containsKey(comp) && map.get(comp) != i){
				System.out.println(map.get(comp) + " "+ i);
				return new int []{map.get(comp), i};
			}
		}
		return new int []{};
	}
	//Method 3: One Pass HashMap
	public int [] twoSumHT1(int [] A, int target){
		Map <Integer, Integer> map = new HashMap <>();
		for(int i = 0; i < A.length; i++){
			int comp = target - A[i];
			if(map.containsKey(comp)){
				System.out.println(i +" "+map.get(comp));
				return new int [] {i, map.get(comp)};
			}
			map.put(A[i], i);
		}
		return new int [] {};
	}
	public static void main(String[]args){
		int [] A = {2, 3, 55, 7};
		int target = 9;
		
		Two_Sum sum = new Two_Sum();
		sum.twoSum(A, target);
		//
		sum.twoSumHT(A, target);
		//One Pass
		sum.twoSumHT1(A, target);
	}
}
