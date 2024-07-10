class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        for (String command: logs){
            if (command.startsWith(".")){
                if (command.startsWith("./")){
                    continue;
                }
                level-=1;
                if (level<0) level=0;
            }
            else {
                level+=1;
            }
        }
        return level;
    }
}