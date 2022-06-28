package maximumRequests1601 ;

class Solution {
    public int maximumRequests(int n, int[][] requests) {
                    int [] in =new int [n];
                    int [] out =new int[n];
                    boolean[] Isnotneed=new boolean [requests.length];
                     int ans=0;
                    for (int i = 0 ; i< requests.length ;i++){
                        if (requests[i][0]==requests[i][1]){
                            ans++;
                           Isnotneed[i]=true;
                           continue;
                        }
                        out[requests[i][0]]+=1;
                        in [requests[i][1]]+=1;
                    }

               boolean changeFlag=true;
           boolean isNEED[] =new boolean [n];
                    while ( changeFlag){
                         changeFlag=false;
                        for (int  i = 0 ;i<n;i++){
                            if(isNEED[i]==false && out[i]==0) {
                                changeFlag=true;
                                for (int j = 0 ; j< requests.length ;j++){
                                    if(!Isnotneed[j] ){
                                        if(requests[j][1]==i)  out[requests[i][0]]--;
                                        Isnotneed[j]=true;
                                    }
                                }             //---------------------

                                 isNEED[i]=true;
                            }
                        }


                    }

                    for (int  i = 0 ;i<n;i++){
                        ans+= Math.min(in[i],out[i]);
                    }
                    return ans;
    }
}