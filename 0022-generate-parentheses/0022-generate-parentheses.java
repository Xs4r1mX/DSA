class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("",0,0,n,ans);
        return ans;
    }

    private void generate(String current, int open, int close, int limit, List<String> result){
        if(current.length()==2*limit){
            result.add(current);
            return;
        }

        if(open<limit){
            generate(current+"(",open+1,close,limit,result);
        }

        if(close<open){
            generate(current+")",open,close+1,limit,result);
        }
    }
}