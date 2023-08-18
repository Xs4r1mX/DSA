class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Set<String> set = new HashSet<>();
        int size=0;
        boolean flag=false;

        for(int i=0;i<n;i++)
        {
            int[] next = new int[8];
            for(int j=1;j<7;j++)
            {
                next[j]=(cells[j-1]==cells[j+1])? 1 : 0;
            }
            String s =Arrays.toString(next);
            if(!set.contains(s))
            {
                set.add(s);
                size++;
            }
            else
            {
                flag=true;
                break;
            }
            cells=next;
        }
        if(flag)
        {
            n=n%size;
            for(int i=0;i<n;i++)
            {
                int[] next = new int[8];
                for(int j=1;j<7;j++)
                    {
                        next[j]=(cells[j-1]==cells[j+1] ? 1 : 0);
                    }
                    cells=next;
            }
        }
        return cells;
        
    }
}