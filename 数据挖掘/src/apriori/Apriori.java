package apriori;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class Apriori {
	static int count= 5;
	static int minSupport = 2;
	static boolean Tag = false;
	static int cnt = 2;
	static String[][] data = {{"苹果","牛奶","面包"},
			{"面包","火腿","牛奶","可乐"},
			{"面包","牛奶"},
			{"火腿","可乐","香蕉"},
			{"牛奶","苹果","香蕉"}}; 
	static List<List<String>> dataList = new ArrayList<>();
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("源数据输出：");
		for(int i=0;i<count;i++){
			List<String> list = new ArrayList<>();
			for(int j=0;j<data[i].length;j++){
				System.out.print(data[i][j]+"	");
				list.add(data[i][j]);
			}
			dataList.add(list);
			System.out.println();
		}
		List<List<String>> FirstCandidate = getFirstCandidate();
		System.out.println("候选一项集：");
		printItem(FirstCandidate);
		List<List<String>> FirstFrequent = getSupportItemset(FirstCandidate);
		System.out.println("频繁一项集：");
		printItem(FirstFrequent);
		while(Tag!=true){
			List<List<String>> nextCandidate = getNextCandidate(FirstFrequent);
			System.out.println("候选"+cnt+"项集:");
			printItem(nextCandidate);
			System.out.println("频繁"+cnt+++"项集：");
			List<List<String>> nextFrequent = getSupportItemset(nextCandidate);
			printItem(nextFrequent);
			if(Tag == true){  
                System.out.println("Apriori算法--->频繁集");  
                for(int i=0;i<FirstFrequent.size();i++){  
                    List<String> list = new ArrayList<String>(FirstFrequent.get(i));  
                    for(int j=0;j<list.size();j++){  
                        System.out.print(list.get(j)+" ");  
                    }  
                    System.out.println();  
                }  
            }  
            //****************下一次循环初值********************  
//            FirstCandidate = nextCandidate;  
            FirstFrequent = nextFrequent;
			
		}		
	}
	
	//获取候选一项集
	private static List<List<String>> getFirstCandidate(){
		List<List<String>> rList = new ArrayList<>();
		HashSet<String> hs = new HashSet<>();
		for(int i=0;i<dataList.size();i++){
			for(int j=0;j<dataList.get(i).size();j++){
				hs.add(dataList.get(i).get(j));
			}
		}
		for(String str:hs){
			List<String> list = new ArrayList<>();
			list.add(str);
			rList.add(list);
		}
		return rList;
	}
	
	//获取候选K项集
	private static List<List<String>> getNextCandidate(List<List<String>> frequent){
		List<List<String>> nextCandidateItemset = new ArrayList<List<String>>();  
        for (int i=0; i<frequent.size(); i++){  
              
            HashSet<String> hsSet = new HashSet<String>();  
            HashSet<String> hsSettemp = new HashSet<String>();  
            for (int k=0; k< frequent.get(i).size(); k++)//获得频繁集第i行  
                hsSet.add(frequent.get(i).get(k));  
            int hsLength_before = hsSet.size();//添加前长度  
            hsSettemp=(HashSet<String>) hsSet.clone();  
            for(int h=i+1; h<frequent.size(); h++){//频繁集第i行与第j行(j>i)连接   每次添加且添加一个元素组成    新的频繁项集的某一行，     
                hsSet=(HashSet<String>) hsSettemp.clone();//！！！做连接的hasSet保持不变  
                for(int j=0; j< frequent.get(h).size();j++)  
                    hsSet.add(frequent.get(h).get(j));  
                int hsLength_after = hsSet.size();            
                if(hsLength_before+1 == hsLength_after && isSubsetOf(hsSet,dataList)==1 && isnotHave(hsSet,nextCandidateItemset)){  
                    //如果不相等，表示添加了1个新的元素，再判断其是否为record某一行的子集     若是则其为  候选集中的一项  
                    Iterator<String> itr = hsSet.iterator();  
                    List<String>  tempList = new ArrayList<String>();  
                    while(itr.hasNext()){  
                        String Item = itr.next();  
                        tempList.add(Item);  
                    }  
                    nextCandidateItemset.add(tempList);  
                }  
                      
            }  
              
        }  
        return nextCandidateItemset;
	}
	 private static boolean isnotHave(HashSet<String> hsSet,  
	            List<List<String>> nextCandidateItemset) {  
	        // TODO Auto-generated method stub  
	        List<String>  tempList = new ArrayList<String>();  
	        Iterator<String> itr = hsSet.iterator();  
	        while(itr.hasNext()){  
	            String Item = itr.next();  
	            tempList.add(Item);  
	        }  
	        for(int i=0; i<nextCandidateItemset.size();i++)  
	            if(tempList.equals(nextCandidateItemset.get(i)))  
	                return false;  
	        return true;  
	    }  
	    
	    private static int isSubsetOf(HashSet<String> hsSet,  
	            List<List<String>> record2) {  
	        //hsSet转换成List  
	        List<String>  tempList = new ArrayList<String>();  
	        Iterator<String> itr = hsSet.iterator();  
	        while(itr.hasNext()){  
	            String Item = itr.next();  
	            tempList.add(Item);  
	        }         
	          
	        for(int i=1;i<dataList.size();i++){  
	            List<String>  tempListRecord = new ArrayList<String>();  
	            for(int j=1;j<dataList.get(i).size();j++)  
	                tempListRecord.add(dataList.get(i).get(j));  
	            if(tempListRecord.containsAll(tempList))  
	                return 1;  
	            }  
	        return 0;  
	    }  
	//获取频繁K项集
	private static List<List<String>> getSupportItemset(List<List<String>> dddd){
		List<List<String>> rList = new ArrayList<>();
		boolean end = true;
		for(int i=0;i<dddd.size();i++){
			int count = getFrequent(dddd.get(i));
			if(count>=minSupport){
				rList.add(dddd.get(i));
				end = false;
			}
		}
		Tag = end;//存在频繁项集则不会结束  
        if(Tag==true)  
            System.out.println("无满足支持度项集,结束连接");
		return rList;
	}
	
	private static int getFrequent(List<String> list) {
		// TODO 自动生成的方法存根
		int j;
		int k=0;
		for(int i=0;i<dataList.size();i++){
			for(j=0;j<list.size();j++){
				if(dataList.get(i).contains(list.get(j))){
					continue;
				}
				else
					break;
			}
			if(j==list.size()) {
				k++;
			}			
		}
		return k;
	}

	//打印项集
	private static void printItem(List<List<String>> dddd){
		for(int i=0;i<dddd.size();i++){
			for(int j=0;j<dddd.get(i).size();j++){
				System.out.print(dddd.get(i).get(j)+"	");
			}
			System.out.println();
		}
	}

}
