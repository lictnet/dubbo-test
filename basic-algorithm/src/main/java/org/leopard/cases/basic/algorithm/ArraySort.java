package org.leopard.cases.basic.algorithm;

public class ArraySort {
	
	/**
	 * 简单排序
	 */
	private static void Simple(){
		int a[] = {5,8,7,10,3,6,9,2,0,19,14};
		int tmp;
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]>a[j]){
					tmp = a[j];
					a[j]=a[i];
					a[i] = tmp;
				}
			}
		}
	}
	
	/**
	 * 冒泡排序
	 */
	private static void Bubble(){
		int a[] = {5,8,7,10,3,6,9,2,0,19,14};
		int tmp;
		boolean flag = true;
		printSort(a);
		for(int i=0;i<a.length&&flag;i++){
			flag = false;
			for(int j=a.length-1;j>i;j--){
				if(a[j]<a[j-1]){
					tmp = a[j];
					a[j]=a[j-1];
					a[j-1] = tmp;
					flag = true;
				}
				printSort(a);
			}
		}
	}
	
	/**
	 * 选择排序
	 */
	private static void Select(){
		int a[] = {5,8,7,10,3,6,9,2,0,19,14};
		int tmp;
		int min = 0;
		for(int i=0;i<a.length;i++){
			for(int j=i;j<a.length;j++){
				if(a[j]<a[j+1]){
					min = j;
				}
				if(min!=i){
					tmp = a[i];
					a[i] = a[min];
					a[min] = a[i];
				}
				printSort(a);
			}
		}
	}
	
	/**
	 * 插入排序
	 */
	private static void Insert(){
		//int a[] = {0,8,5,7,10,3,6,9,2,0,19,14};
		int a[] = {8,5,7};
		int tmp;
		int j =0;
		for(int i=1;i<a.length;i++){
			if(a[i]<a[i-1]){
				tmp = a[i];
				for(j=i-1;j>=0&&a[j]>tmp;j--){
					a[j+1]=a[j];	
				}
				a[j+1] = tmp;
			}
			printSort(a);
		}
	}
	
	/**
	 * 希尔排序
	 */
	private static void Shell(){
		int a[] = {0,8,5,7,10,3,6,9,2,0,19,14};
		//int a[] = {8,5,7,9};
		for(int k=a.length/2;k>0;k=k/2){
				int tmp;
				int j =0;
				for(int i=k;i<a.length;i++){
					if(a[i]<a[i-1]){
						tmp = a[i];
						for(j=i-1;j>=0&&a[j]>tmp;j--){
							a[j+1]=a[j];	
						}
						a[j+1] = tmp;
					}
					printSort(a);
				}
		}
	}
    
	/**
	 * 堆排序
	 */
	private static void HeapAdjust(int a[],int aLen,int i){
		int left = i*2 + 1;
		int right = i*2 + 2;
		int largest = i;
		int tmp;
		while(left < aLen || right < aLen){
			if(left < aLen && a[left]>a[largest])
				largest = left;
			if(right < aLen && a[right]>a[largest])
				largest = right;
			if(i!=largest){
				tmp = a[largest];
				a[largest] = a[i];
				a[i]= tmp;
				
				i = largest;
				left = i*2+1;
				right = i*2 +2;
			}else{
				break;
			}
			printSort(a);
		}
	}
	
	private static void Heap(){
		int a[] = {0,8,5,7,10,3,6,9,2,0,19,14};
		//int a[] = {2,5,7};
		int hLen = a.length;
		int tmp;
		//建堆，整理成大顶堆
		int begin = a.length/2 -1;
		for(int i = begin;i>=0;i--){
			HeapAdjust(a,a.length,i);
		}
		while(hLen>1){
			tmp = a[hLen-1];
			a[hLen-1]= a[0];
			a[0]= tmp;
			hLen--;
			HeapAdjust(a,hLen,0);
		}
		printSort(a);
	}
	
	/**
	 * 归并排序
	 */
	private static void MergeAdjust(int a[],int low,int mid,int high){
		int[] temp = new int[high-low+1]; 
		int i = low;   //左指针
		int j = mid + 1;  //右指针
		int k = 0;
		//把较小的数先移到新数组中
		while(i<=mid && j<=high){
			if(a[i]<a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		//把左边剩余的数移入数组
		while(i<=mid)
			temp[k++] = a[i++];
		//把右边剩余的数移入数组
		while(j<=high)
			temp[k++] = a[j++];
		//用新数组的值覆盖
		for(int w=0;w<temp.length;w++)
			a[w+low]= temp[w];
		printSort(a);
	}
	
	private static void Merge(int a[],int low,int high)
	{
		//int a[] = {0,8,5,7,10,3,6,9,2,0,19,14};
		//int a[] = {8,5,7};
		//递归方式排序
		int mid = (low+high)/2;
		if(low < high){
			//左边
			Merge(a,low,mid);
			//右边
			Merge(a,mid+1,high);
			//左右归并排序
			MergeAdjust(a,low,mid,high);
		}
		
			
		printSort(a);
		
	}

	/**
	 * 快速排序
	 * @param s
	 * @param l
	 * @param r
	 */
	private static void quick_sort(int s[], int l, int r)  
	{  
		if (l < r)  
	   {  
	        int i = l, j = r, x = s[l];  
	        while (i < j)  
	        {  
	            while(i < j && s[j] >= x) // 从右向左找第一个小于x的数  
	                j--;    
	            if(i < j)   
	                s[i++] = s[j];  
	              
	            while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数  
	                i++;    
	            if(i < j)   
	                s[j--] = s[i];  
	        }  
	        s[i] = x;  
	        quick_sort(s, l, i - 1); // 递归调用   
	        quick_sort(s, i + 1, r);  
	        printSort(s);
	    }  
	}
	
	private static void printSort(int[] a){
		for(int i = 0 ;i < a.length; i++){
			System.out.print(a[i]+"\t");
		}
		System.out.println("\n");
	}
	
	private static void Swap1(int a, int b)  
	{  
	    if (a != b)  
	    {  
	        a = b-a;  
	        b = b-a;  
	        a = b+a;  
	    }  
	}
	


	public static void main(String[] args) {
		//Shell();
		int a[] = {4,8,5,7,10,3,6,9,0,2,19,12};
		//int a[] = {8,5,7,9};
		//Merge(a,0,a.length-1);
		quick_sort(a,0,a.length-1);
		//System.out.println(7/4);

	}

}
