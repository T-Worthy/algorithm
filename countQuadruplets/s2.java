package countQuadruplets;




import java.util.HashMap;
import java.util.Map;

class s2 {


    public int countQuadruplets(int[] nums) {
        int n=nums.length;


        //int [] count =new int[101];
        Map<Integer,Integer> map =new HashMap<>();
        Integer aa;
        for(int i =0;i<nums.length;i++) {
            aa=map.get(nums[i]);
            if(aa==null)    {
              map.put(nums[i],i*1000+1);
            }
            else map.put(nums[i],aa+1);
        }

//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
//        }

        //count[num]++;
        int ans=0;


        int ai=0,bi,ci,d,ccc;
        for ( ;ai<n-3;ai++){
            for(bi=ai+1 ;bi<n-2;bi++){
                for ( ci =bi+1 ; ci <n-1;ci++){
                    d= nums[ai]+nums[bi]+nums[ci];

                    if((aa=map.get(d))==null || (ccc= aa%1000)==0) continue;
                    if((aa/1000)>ci) {
                        ans += (ccc);

                    }
                    else if((ccc)>1) {
                        for(int di=ci+1;di<n ;di++) {
                            if (nums[di] == d) {
                                ans += 1;
                              //   System.out.println("D:"+d+"= "+nums[ai]+" "+nums[bi]+" "+nums[ci]);

                            }
                        }
                    }
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        s2 s = new s2();
        int []a ={1,2,3,6}; //{99,11,77,33,74,89,53,14,73,79,88,97,74,100,95,21,82,92,21,29,49,99,32};
        System.out.println(s.countQuadruplets(a));
    }
}