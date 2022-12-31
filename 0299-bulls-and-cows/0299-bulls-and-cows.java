class Solution {

    public String getHint(String secret, String guess) {
        int map[] = new int[10];

        for (char ch : secret.toCharArray()) {
            map[ch - '0']++;
        }
        int cows = 0, bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                cows++;
                map[secret.charAt(i) - '0']--;
            } 
            // else {
            //     if (map[guess.charAt(i) - '0'] > 0) bulls++;
            //     map[guess.charAt(i) - '0']--;
            // }
        }

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                // cows++;
                // map[secret.charAt(i) - '0']--;
            } 
            else {
                if (map[guess.charAt(i) - '0'] > 0) bulls++;
                map[guess.charAt(i) - '0']--;
            }
        }

        return cows + "A" + bulls + "B";
    }
}
