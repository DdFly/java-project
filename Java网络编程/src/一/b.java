//package 一;
//
//import java.util.concurrent.Callable;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class b implements Callable<Point>{
//	
//	private int[] array;
//	private final int start;
//	private final int end;
//	private int middle;
//	Lock lock = new ReentrantLock();
//	public b(int start,int end,int[] array){
//		this.start = start;
//		this.end = end;
//		this.array = array;
//	}
//
//	@Override
//	public Point call() {
//
//		/*进行排序*/
//		quickSort();
//		return new Point(start,end,middle);
//	}
//	public void quickSort(){
//
//		int head,tail;
//		head = start;
//		tail = end + 1;
//		while(true){
//		/*找到一个比head大的*/
//			do{
//				head++;
//			}while(!(array[head] >= array[start] || head == end));
//		
//			/*找到一个比head小的*/
//			do{
//				tail--;
//			}while(!(array[start] >= array[tail] || tail == start));
//			if(head < tail)
//				swap(head,tail);
//			else
//				break;
//		}
//		swap(start,tail);
//		middle = tail;
//	}
//
//	public void swap(int a,int b){
//		int temp = 0;
//		temp = array[a];
//		array[a] = array[b];
//		array[b] = temp;
//　　}
//
//	class Point{
//		private int start;
//		private int end;
//		private int middle;
//		public Point(int start,int end,int middle){
//		this.start = start;
//		this.end = end;
//		this.middle = middle;
//	}
//
//	public int getStart(){	
//		return start;
//	}
//	
//	public int getEnd(){
//		return end;
//	}
//	
//	public int getMiddle(){
//		return middle;
//	}
//	
//	public boolean compareStartMiddle(){
//		return start < middle - 1;
//	}
//	
//	public boolean compareMiddleEnd(){
//		return middle + 1 < end;	
//	}
//}