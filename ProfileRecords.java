import java.util.*;
public class ProfileRecords {
	dailyRecord e;
	LinkedList list;
	
	ProfileRecords(){
		e = new dailyRecord();
		list = new LinkedList();
		list.add(e);
	}
	//getRecords(String start, String end){
		//
	//}
	dailyRecord getDaily(){
		return e;
	}
	/*dailyRecord[] lastWeekRecords(){
		dailyRecord[] lastWeek = new dailyRecord[7];
		int i = 0;
		while(i != 7){
			list.get
		}
		return lastWeek;
	}*/
}
