import java.util.Arrays;
public class ArrayStats {


	public static int range(int[] nums) {

		int difference = 999999;

		for (int i=0; i<nums.length;i++){
			for (int j=1; j<nums.length;j++){
				if (nums[i]-nums[j]<difference){
					difference = nums[i]-nums[j];
				}
			}
		}

		return Math.abs(difference);
	}

	public static int mode(int[] nums){

		int most = 0;
		int number= 0;
		for (int i=0; i < nums.length; i++){
			int first = nums[i];
			int count =1;
			for (int j = 1 ; j < nums.length; j++){
				if (first==nums[j]){
					count++;
				}
			}
			if (count > most){
				most = count;
				number = first;
			}

		}
		return number;


	}


	public static double mean(int[] nums){
		int sum =0;
		int count =0;
		for (int num: nums){
			sum = sum+num;
			count++;
		}
		return (double) (sum/count);

	}

	public static double median(int[] nums){

		Arrays.sort(nums);

		double mediannumber = 0.0;

		if (nums.length%2==0)
		{
			mediannumber = (double) (nums[(nums.length)/2-1]+ nums[((nums.length)/2)])/2;

		}
		else {

			mediannumber = nums[((nums.length)/2)];
		}

		return mediannumber;



	}




	public static void main (String[] args){
		int[] array = {1,2,5,5,5,6,7,8,8,10};

		System.out.println(mode(array));


	}
}