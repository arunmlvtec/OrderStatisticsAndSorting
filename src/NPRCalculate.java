
public class NPRCalculate {
	public static void main(String[] args) {
		int ctr = 0;
		int[] arr = {1,3,5,7,9,11,13,15};
		for (int i=0;i<arr.length;i++){
			for (int j=0;j<arr.length;j++){
				for (int k=0;k<arr.length;k++){
					for (int l=0;l<arr.length;l++){
						for (int m=0;m<arr.length;m++){
							ctr++;
							if(arr[i]+arr[j]+arr[k]+arr[l]+arr[m]==30){
								System.out.println(arr[i]+"\t"+arr[j]+"\t"+arr[k]+"\t"+arr[l]+"\t"+arr[m]);
								System.exit(0);
							}
						}
					}
				}
			}
		}
		System.out.println("Final counter is: "+ctr);
		System.out.println("No combination found!!");
	}
}
