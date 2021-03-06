    public int calculate(int val[], int wt[], int W){
        int K[][] = new int[val.length+1][W+1];
        
        for(int j=0; j <= W; j++){
            for(int i=0; i <= val.length; i++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j > wt[i-1]){ // weight cannot exceed
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                } else{
                    K[i][j] = K[i-1][j];
                }
            }
        }
        return K[val.length][W];
    }
