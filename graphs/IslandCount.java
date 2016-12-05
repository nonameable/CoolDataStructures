package graphs;

import java.util.ArrayDeque;

public class IslandCount {
	
	ArrayDeque<Cell> queue = new ArrayDeque<Cell>();
	

	/*
	 * The conventions for the DFS are going to be the following.
	 * Natural state:
	 * 0 (Undiscovered) Nothing 
	 * 1 (Undiscovered) Island with possible connection with other islands
	 * 2 (Discovered) Nothing 0 -> 2
	 * 3 (Discovered) Island with possible connection with other islands 1 -> 3
	 * 4 (Finished) Nothing 2 -> 4
	 * 5 (Finished) Island with possible connection with other islands 3 -> 5
	 */
	
	public int numberOfIslands(int[][] M){
		int numberOfIslands = 0;
		for(int i = 0; i < M.length;i++){
			for(int j = 0; j < M.length; j++){
				if(M[i][j] == 1){ // this means it has not been discovered yet
					numberOfIslands = numberOfIslands + 1;
					DFSVisit(i, j, M);
				}
			}
		}
		return numberOfIslands;
	}
	
	public int numberOfIslandsNoStackOverFlow(int[][] M){
		int numberOfIslands = 0;
		for(int i = 0; i < M.length;i++){
			for(int j = 0; j < M.length; j++){
				if(M[i][j] == 1){ // this means it has not been discovered yet
					numberOfIslands = numberOfIslands + 1;
					DFSVisitQueue(i, j, M);
				}
			}
		}
		return numberOfIslands;
	}
	
	public void DFSVisitQueue (int pi, int pj, int[][] M){
		int i,j;
		queue.add(new Cell(pi, pj));
		while(!queue.isEmpty()){
			Cell current = queue.poll();
			i = current.i;
			j = current.j;
			changeState(i, j, M);
			// A
			if(j - 1 >= 0){
				if(M[i][j-1] == 1){
					queue.add(new Cell(i, j -1));
				}
			}
			// B
			if(i - 1 >= 0){
				if(M[i -1][j] == 1){
					queue.add(new Cell(i - 1, j));;
				}
			}
			// C
			if(j + 1 < M.length){
				if(M[i][j+1] == 1){
					queue.add(new Cell(i, j +1));
				}
			}
			// D
			if(i + 1 < M.length){
				if(M[i + 1][j] == 1){
					queue.add(new Cell(i + 1, j));
				}
			}
			changeState(i, j, M);
		}
		
	}
	
	
	public void DFSVisit (int i, int j, int[][] M){
		changeState(i, j, M);
		
		// here we do de the DFS in every possible connection we have from that node
		
		// A
		if(j - 1 >= 0){
			if(M[i][j-1] == 1){
				DFSVisit(i, j -1, M);
			}
		}
		// B
		if(i - 1 >= 0){
			if(M[i -1][j] == 1){
				DFSVisit(i - 1,j, M);
			}
		}
		// C
		if(j + 1 < M.length){
			if(M[i][j+1] == 1){
				DFSVisit(i, j +1, M);
			}
		}
		// D
		if(i + 1 < M.length){
			if(M[i + 1][j] == 1){
				DFSVisit(i + 1,j, M);
			}
		}
		changeState(i, j, M);
		
	}
	
	public void changeState(int i, int j , int[][] M){
		int currentValue = M[i][j];
		switch (currentValue) {
			case 0: M[i][j] = 2;
						break;
			case 1: M[i][j] = 3;
						break;
			case 2: M[i][j] = 4;
						break;
			case 3: M[i][j] = 5;
						break;
			default: M[i][j] = -1;
						break;
		}
	}
	
	
	public static void main(String[] args) {
		int[][] M = new int[5][5];
		int[] col0 = {0,0,1,0,1};
		int[] col1 = {1,0,0,1,0};
		int[] col2 = {0,1,0,1,1};
		int[] col3 = {1,1,1,0,0};
		int[] col4 = {0,1,0,0,1};
		
		M[0] = col0;
		M[1] = col1;
		M[2] = col2;
		M[3] = col3;
		M[4] = col4;
		
		IslandCount ic = new IslandCount();
		//System.out.println("Number if Islands is: " + ic.numberOfIslands(M));
		System.out.println("Number if Islands with queue is: " + ic.numberOfIslandsNoStackOverFlow(M));
		
	}

}
