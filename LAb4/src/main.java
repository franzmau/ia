import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class main {	
	/*public State initialState(){
		//InputReader in = new InputReader(System.in);
    	Scanner S= new  Scanner(System.in);
    	S.useDelimiter("");
    	int MAX_HEIGHT = S.nextInt();
		ArrayList <Stack<String>> initialStateMatrix = new ArrayList<Stack<String>>();
		Stack<String> newStack = new Stack<String>();
		initialStateMatrix.add(newStack);
    	int c = (int) S.next().charAt(0);
    	int prev = c;
    	int currentArray = 0;
		while(c!='\n'){
			c = S.findInLine(".").charAt(0);
			if(c == ',' || c == ')'){
				if(prev != 'X' && prev != 'x'){
					initialStateMatrix.get(currentArray).push(""+prev);
				}
			}
			if(c == ')'){
				newStack = new Stack<String>();
			}
			prev = c;
		}
		S.close();
		return new State(initialStateMatrix, MAX_HEIGHT);
	}
	
	public State finalState(){
		InputReader in = new InputReader(System.in);
    	int MAX_HEIGHT = in.readInt();
    	
		ArrayList <Stack<String>> initialStateMatrix = new ArrayList<Stack<String>>();
		Stack<String> newStack = new Stack<String>();
		initialStateMatrix.add(newStack);
    	int c = in.read(); 
    	int prev = c;
    	int currentArray = 0;
		while(c!='\n'){
			c = in.read();
			if(c == ',' || c == ')'){
				if(prev != 'X' && prev != 'x'){
					initialStateMatrix.get(currentArray).push(""+prev);
				}
			}
			if(c == ')'){
				newStack = new Stack<String>();
			}
			prev = c;
		}
		
		return new State(initialStateMatrix, MAX_HEIGHT);
	}*/
	
	public State initialState(){
		ArrayList <Stack<String>> stateMatrix = new ArrayList<Stack<String>>();
		for(int i = 0; i < 3; i++){
			Stack<String> newStack = new Stack<String>();
			if(i == 0){
				newStack.push("B");
				newStack.push("A");
				
			}
			
			if(i == 1){
				newStack.push("C");
				newStack.push("E");
			}
			
			if(i == 2){
				newStack.push("D");
			}
			stateMatrix.add(newStack);
		}
		return new State(stateMatrix, 3);
	}
	
	public State finalState(){
		ArrayList <Stack<String>> stateMatrix = new ArrayList<Stack<String>>();
		for(int i = 0; i < 3; i++){
			Stack<String> newStack = new Stack<String>();
			if(i == 0){
				newStack.push("D");
				newStack.push("E");
				
			}
			
			if(i == 1){
				newStack.push("A");			
			}
			
			if(i == 2){
				newStack.push("B");
				newStack.push("C");
				
			}
			stateMatrix.add(newStack);
		}
		return new State(stateMatrix, 3);
	}
	
	 public boolean isInvalidChar(int c){
     	if(c > 'a' && c <'z' ||
     		c > 'A' && c <'Z'){
     		return false;
     	}
     	return true;
     }
     


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main m = new main();
		State initialState = m.initialState();
		//initialState.prettyPrint();
		State finalState = m.finalState();
		//finalState.prettyPrint();
		Tree tree = new Tree(initialState);
		System.out.println("Uniform cost\n");
		boolean aux =tree.uniformCost(finalState, 5000);
		if(!aux){
			System.out.println("No solution found");
		}
		System.out.println("\n a* Inconsistent\n");
		tree=new Tree (initialState);
		boolean aux2=tree.aStarInConsistent(finalState, 5000);
		if(!aux2){
			System.out.println("No solution found");
		}
		tree=new Tree (initialState);
		System.out.println("\n a* Consistent\n");
		boolean aux3 =tree.aStarConsistent(finalState , 5000);
		if(!aux3){
			System.out.println("No solution found");
		}
		tree=new Tree (initialState);
		System.out.println("\n Breadth First\n");
		boolean aux4 =tree.breadthFirstSearch(finalState , 5000);
		if(!aux4){
			System.out.println("No solution found");
		}
		tree=new Tree (initialState);
		System.out.println("\n Depth First\n");
		boolean aux5 =tree.depthFirstSearch(finalState , 5000);
		if(!aux5){
			System.out.println("No solution found");
		}
		
	}

}