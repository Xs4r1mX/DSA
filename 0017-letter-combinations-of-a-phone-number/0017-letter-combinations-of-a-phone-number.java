class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        generate(digits,0,ans,"");
        return ans;
    }

    private void generate(String digits, int index, List<String> ans, String current){
        if(index==digits.length()){
            ans.add(current);
            return;
        }
        char currentDigit = digits.charAt(index);
        String letters = getLetters(currentDigit);
        for(int i=0;i<letters.length();i++){
            generate(digits,index+1,ans,current+letters.charAt(i));
        }
    } 

    private String getLetters(char number) {
        switch (number) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}