class Solution {
    //Not Done By be I'll Do it letter , by myself , aur nischay bhai kaise ho?
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final String EMPTY_KEY_MASK = "      ";
    private static final String FULL_KEY_MASK = "abcdef";
    
    public int shortestPathAllKeys(String[] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length();
        
        int startRow = -1;
        int startCol = -1;
        int numKeys = 0;
        for(int r=0; r<numRows; r++) {
            for(int c=0; c<numCols; c++) {
                char ch = grid[r].charAt(c);
                
                if('@' == ch) {
                    startRow = r;
                    startCol = c;
                } else if(Character.isLowerCase(ch)) {
                    numKeys = Math.max(numKeys, ch - 'a' + 1);
                }
            }
        }
        
        String allKeys = FULL_KEY_MASK.substring(0, numKeys);
        int numSteps = 0;
        
        Set<String> visited = new HashSet<>();
        Deque<State> queue = new ArrayDeque<>();
        State startState = new State(new StringBuilder(EMPTY_KEY_MASK.substring(0, numKeys)), 
                                     startRow, startCol);
        queue.offer(startState);
        visited.add(startState.toString());
        
        while(!queue.isEmpty()) {
            int qs = queue.size();
            for(int i=0; i<qs; i++) {
                State s = queue.poll();
                if(allKeys.equals(s.keySb.toString())) {
                    return numSteps;
                }

                for(int[] d : DIRECTIONS) {
                    int newRow = s.row + d[0];
                    int newCol = s.col + d[1];

                    if(newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && 
                        grid[newRow].charAt(newCol) != '#') {
                        char c = grid[newRow].charAt(newCol);
                        if(Character.isUpperCase(c) && !s.canUnlock(c)) {
                            // Can't unlock this door
                            continue;
                        }
                        
                        StringBuilder stateKeys = new StringBuilder(s.keySb);
                        if(Character.isLowerCase(c)) {
                            // Pick up this key
                            stateKeys.setCharAt(c - 'a', c);
                        }
                        
                        State newState = new State(stateKeys, newRow, newCol);
                        if(!visited.contains(newState.toString())) {
                            visited.add(newState.toString());
                            queue.offer(newState);
                        }
                    }
                }
            }
            
            numSteps++;
        }
        
        return -1;
    }
    
    
    private class State {
        private StringBuilder keySb = null;
        private int row = -1;
        private int col = -1;
        
        private State(StringBuilder keySb, int aRow, int aCol) {
            this.keySb = keySb;
            this.row = aRow;
            this.col = aCol;
        }
        
        private boolean canUnlock(char c) {
            c = Character.toLowerCase(c);
            return keySb.charAt(c - 'a') == c;
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(keySb);
            sb.append(",");
            sb.append(row);
            sb.append(",");
            sb.append(col);
            
            return sb.toString();
        }
    }
}