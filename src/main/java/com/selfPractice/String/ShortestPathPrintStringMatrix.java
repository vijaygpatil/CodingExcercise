package com.selfPractice.String;

class ShortestPathPrintStringMatrix {
	public static void main (String[] args) {
		String str = "COZY";
        printPath(str);
	}
	
	public static void printPath(String str) {
	    int n = str.length();
	    
	    int x = 0;
	    int y = 0;
	    
	    for(int i = 0; i < n; i++) {
	        int nextx = (str.charAt(i) - 'A') / 5;
	        int nexty = (str.charAt(i) - 'B' + 1) % 5;
	        
	        while(x > nextx) {
	            System.out.println("Move Up");
	            x--;
	        }
	        
	        while(x < nextx) {
	            System.out.println("Move Down");
	            x++;
	        }
	        
	        while(y > nexty) {
	            System.out.println("Move Left");
	            y--;
	        }
	        
	        while(y < nexty) {
	            System.out.println("Move Right");
	            y++;
	        }
	        
	        System.out.println("Press OK");
	    }
	}
}
