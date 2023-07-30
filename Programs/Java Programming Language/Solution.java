import java.util.Arrays;

class Solution
{
    public int TotalPairs(int[] nums, int x, int y)
    {
        // int mem[][] = new int[nums.length][nums.length];
        // for(int i=0;i<mem.length;i++){
        //     for(int j=0;j<mem.length;j++){
        //         mem[i][j] = -1;
        //     }
        // }
        Arrays.sort(nums);
        return help(nums,0,nums.length-1,x,y);
    }
    public int help(int nums[],int i,int j,int x,int y){
        if(i>=j){
            return 0;
        }
        // if(mem[i][j]!=-1) return mem[i][j];
        int ans = 0;
        if(nums[i]*nums[j]<x){
            ans += help(nums,i+1,j,x,y);
        }
        else if(nums[i]*nums[j]>y){
            ans += help(nums,i,j-1,x,y);
        }
        else{
            int ans1 = help(nums,i+1,j,x,y);
            int ans2 = help(nums,i,j-1,x,y);
            ans = 1 + ans1 + ans2;
        }
        return ans;
    }
}