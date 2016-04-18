package threesumclosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	
	/**
	 * Time: O(n^2). This is the good one. 
	 * Do not need to use extra spaces. Also faster than the previous one.
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int get3SumClosest(int[] nums, int target){
		if(nums==null || nums.length<3)	return 0;
				
		Arrays.sort(nums);
		
		int closestDiff = 0;//Integer.MAX_VALUE;
		int a=0, b=0, c=0;		
		
		for(int i=0; i<nums.length-2; i++){
			
			if(i>0 && nums[i] == nums[i-1])	continue;
			
			int start = i+1;
			int end = nums.length-1;
			
			/*if(i==0){
				closestDiff = Math.abs(target-(nums[i] + nums[start] + nums[end]));
				a = nums[i];
				b = nums[start];
				c = nums[end];
			}*/
			
			while(start < end){								
				if((start-1)!=i && (nums[start] == nums[start-1])){
					start++;
					continue;
				}
				else if((end+1)<nums.length && (nums[end] == nums[end+1])){
					end--;
					continue;
				}
				
				int sum = nums[i] + nums[start] + nums[end];
				
				if(sum == target){
					System.out.println(nums[i]+", " + nums[start]+", " +nums[end]);	
					return nums[i] + nums[start] + nums[end];
				}
				//else if(Math.abs(target-sum) < closestDiff){
				/*else if((sum-target) < closestDiff){
					a = nums[i];
					b = nums[start];
					c = nums[end];
					closestDiff = Math.abs(target-sum);
					start++;
					//end--;					
				}
				else	end--;*/
				
				if(sum < target){
					if(closestDiff == 0 || (target-sum)<closestDiff){
						a = nums[i];
						b = nums[start];
						c = nums[end];
						closestDiff = (target-sum);
					}
					start++;
				}
				else{
					if(closestDiff == 0 || (sum-target)<closestDiff){
						a = nums[i];
						b = nums[start];
						c = nums[end];
						closestDiff = Math.abs(target-sum);
					}
					end--;
				}
				
			}
		}
		System.out.println(a+", " + b+", " +c);		
		return a+b+c;
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*int[] a = {-1, 2, 1, -4};
		int target = 1;*/
		int[] a = {1, 1, -1, -1, 3}; // -1,-1,1,1,3
		int target = -1;
			
		int out = get3SumClosest(a, target);
		System.out.println(out);	
	}

}
