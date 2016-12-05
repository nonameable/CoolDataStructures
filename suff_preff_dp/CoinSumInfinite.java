/*
 * Made by nonameable
 * Solution to the Coin Sum Infinite at https://www.interviewbit.com/problems/coin-sum-infinite/ (Microsoft)
 * Estimated time of solution: 45 minutes
 */

package suff_preff_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinSumInfinite {

	public static void main(String[] args) throws IOException {
		
		int[] coins = {1,3,5,6,7}; // These must be in order; if not, sort them first
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String line = br.readLine();
		int N = Integer.parseInt(line); // N is the value we want to reach using the coins
		
		int[][] m = new int[coins.length + 1][N + 1];
		
		//initial values to start the dp solution
		for(int i = 0; i < N + 1; i++){
			m[0][i] = 0;
		}
		
		for(int i  = 0; i < coins.length + 1; i++){
			m[i][0] = 1;
		}
		
		// fill the dp matrix. I think we could optimize this.
		for(int i = 1; i < coins.length + 1 ; i++){
			for (int j = 1; j < N + 1; j++) {
				int a = m[i-1][j];
				int b;
				int currentCoin = coins[i -1];
				if(j - currentCoin < 0){
					b = 0;
				} else{
					b = m[i][j - currentCoin];
				}
				m[i][j] = a + b;
			}
		}
		
		System.out.println("Answer: " + m[coins.length][N]);
		
			
	}

}
