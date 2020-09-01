import java.io.*;
import java.util.*;

public class Assignment12{
	public static void main(String args[]){
		Oracle or = new Oracle();

		int n = or.getN();
		int tofind = or.getWhatToFind();

		int left = 0;
		int right = n-1;
		int midIndex;
		boolean found = false;
		while(left<right){
			midIndex = (left+right)/2;

			if(or.getElementAt(midIndex)<tofind){
				left = midIndex+1;
			}else{
				right = midIndex;
			}
		}
		if((or.getElementAt(left)==tofind)&&(left==right)){
			found = true;
			or.reportAnswer(found,left);
		}else{
			or.reportAnswer(found,0);
		}
		
	}
}