package Practice;

public class LongestPrefixOfString {
	
	public static void main(String[] args) {
		String str[]= {"techno","techique","technology","technical"};
		String ans="";
		boolean f=true;
		int i=-1;
		while(f) {
			ans+=str[0].charAt(++i);
			for(String s:str) {
				if(!s.startsWith(ans)) {
					ans=ans.replace(ans.charAt(i), ' ');
					f=false;
					break;
				}
			}
		}
		System.out.println(ans.trim());
		
	}

}
