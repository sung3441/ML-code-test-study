import java.util.HashMap;

class Solution {
    
    HashMap<String, Player> playerStore = new HashMap<String, Player>();

    public String solution(String[] participants, String[] completion) {
        String result = "";

        for (String name : participants) participantPlayer(name);

        for (String name : completion) completionPlayer(name);
        
        for (String key : playerStore.keySet()) result = key;

        return result;
    }
    
    public void participantPlayer(String name) {
        Player player = playerStore.get(name);
        if (player != null) {
            player.cnt++;
        } else {
            Player play = new Player(name);
            playerStore.put(name, play);
        }
    }

    public void completionPlayer(String name) {
        Player player = playerStore.get(name);
        player.cnt--;
        if (player.cnt == 0) {
            playerStore.remove(name);
        }
    }
}

class Player {
    int cnt = 1;
    String name;

    public Player(String name) {
        this.name = name;
    }
}
