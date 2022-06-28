package pathSum;

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;
    Node() {
    }
    Node(int val) {
        this.val = val;
    }
}

class Solution {
    Map<Integer,Node> map;
    public Node treeToDoublyList(Node root) {
        map= new HashMap<>();
        Set<Integer> keySet = new TreeSet<>(map.keySet());
       Node last=null,now=null,ans;
        Iterator<Integer> it = keySet.iterator();
        last=map.get(it.next()); ans=last;
        while (it.hasNext()) {
             now=map.get(it.next());
             last.right=now;
             now.left=last;
             last=now;
        }
        System.out.println();
        now.right=ans;
        ans.left= now;
        return  ans;
    }
    void dfs(Node root){
            if(root==null) return;;
            map.put(root.val,root);
            dfs(root.left);
            dfs(root.right);
        }

    public String minNumber(int[] nums) {
        int n = nums.length;
        String [] st= new String[n];
        for (int i = 0; i < n; i++) {
            st[i]=""+nums[i];
        }
        Arrays.sort(st, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.equals(o2))
                return 0;
                int index=0;
                while(index<o1.length() && index< o2.length()){
                    if(o1.charAt(index)==o2.charAt(index))
                    index++;
                    else return o1.charAt(index)-o2.charAt(index);
                }
                if(index== o1.length()){
                    if( o2.charAt(0)==o2.charAt(index))   return o1.charAt(index-1)-o2.charAt(index);
                    return o2.charAt(0)-o2.charAt(index);
                }
                if(o1.charAt(index)==o1.charAt(0)) return o1.charAt(index)-o2.charAt(index-1);
                return o1.charAt(index)-o1.charAt(0);
            }
        });

         printArray(st);

        StringBuilder sb = new StringBuilder();
        for(String s : st){
            sb.append(s);
        }
        return sb.toString();
    }



    public static void printArray(String [] a){
        System.out.print("[");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int [] ass= {4704,6306,9385,7536,3462,4798,5422,5529,8070,6241,9094,7846,663,6221,216,6758,8353,3650,3836,8183,3516,5909,6744,1548,5712,2281,3664,7100,6698,7321,4980,8937,3163,5784,3298,9890,1090,7605,1380,1147,1495,3699,9448,5208,9456,3846,3567,6856,2000,3575,7205,2697,5972,7471,1763,1143,1417,6038,2313,6554,9026,8107,9827,7982,9685,3905,8939,1048,282,7423,6327,2970,4453,5460,3399,9533,914,3932,192,3084,6806,273,4283,2060,5682,2,2362,4812,7032,810,2465,6511,213,2362,3021,2745,3636,6265,1518,8398};
        s.minNumber(ass);
    }


    }






