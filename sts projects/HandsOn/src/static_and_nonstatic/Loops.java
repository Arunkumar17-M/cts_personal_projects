package static_and_nonstatic;
public class Loops {

	public static void main(String[] args) {
	    
	    int n=150;
	    int i=1;
	    for(; i<=150; i++){
	        if(i == 100)
	            break;
	       else if(i%10 == 0)
	            continue;
	       System.out.println(i);
	    }
	    i=1;
	    while(i<=150){
	        if(i == 100)
	            break;
	       else if(i%10 == 0) {
	    	   i++;
	    	   continue;
	       }
	       System.out.println(i);
	       i++;
	    }
	    i=1;
	    do{
	        if(i == 100)
	            break;
	       else if(i%10 == 0) {
	    	   i++;
	    	   continue;
	       }
	       System.out.println(i);
	       i++;
	    }while(i<=150);
	}

}