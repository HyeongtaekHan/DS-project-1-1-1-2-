import java.io.*;
import java.util.*;

public class Assignment11 {
	public static void main(String args[]){
		try{
			BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
			int lns = Integer.parseInt(bf.readLine());
			int priceInt=Integer.MAX_VALUE;//set priceInt as a max value, to make sure that second line of input.txt (first line of listed prices and souvenirs) do not be omitted
			String svn = null;
			for(int i=0;i<lns;i++){
				String lineN = bf.readLine();
				StringTokenizer tk = new StringTokenizer(lineN," ");
				String compString = tk.nextToken();
				int comp = Integer.parseInt(compString);
				if(comp<priceInt){
					priceInt = comp;//use int comp as a parameter for comparing prior price and upcoming line's price
					svn = lineN.substring(compString.length()+1,lineN.length());//trim price and blank from read line, and then put in in string svn
				}else if(comp==priceInt){
					svn += ", ";
					svn += lineN.substring(compString.length()+1,lineN.length());
				}//in case that there are more than 1 cheapest souvenir(ex. "2 Key holders /n 2 Phone cases"), print all of them in one line with ',' and blank as a devision(eg. "Key holders, Phone cases")
			}
			bf.close();
			BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
			bw.write(svn);
			bw.close();
		}catch(IOException e){
			System.err.println("cannot find \"input.txt\"");
			e.printStackTrace();
		}
	}
}