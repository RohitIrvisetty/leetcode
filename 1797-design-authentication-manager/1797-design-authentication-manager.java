class AuthenticationManager {

    private class Token {
        String tokenId;
        int expTime;

        public Token(String id, int time) {
            this.tokenId = id;
            this.expTime = time;
        }
    }

    private int TTL;
    private Map<String, Integer> tokenMap;
    private LinkedList<Token> list;

    public AuthenticationManager(int timeToLive) {
        TTL = timeToLive;
        tokenMap = new HashMap<>();
        list = new LinkedList<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        tokenMap.put(tokenId, currentTime + TTL);
        list.addLast(new Token(tokenId, currentTime + TTL));
        return;
    }
    
    public void renew(String tokenId, int currentTime) {
        removeExpired(currentTime);

        if (!tokenMap.containsKey(tokenId)) {
            return;
        }

        tokenMap.put(tokenId, currentTime + TTL);
        list.addLast(new Token(tokenId, currentTime + TTL));
        return;
    }
    
    public int countUnexpiredTokens(int currentTime) {
        removeExpired(currentTime);
        
        int count = 0;

        for (int expirationTime: tokenMap.values()) {
            if (expirationTime > currentTime) {
                count++;
            }
        }

        return count;
    }

    private void removeExpired(int currentTime) {
        while (!list.isEmpty() && list.getFirst().expTime <= currentTime) {
            Token token = list.removeFirst();

            if (tokenMap.containsKey(token.tokenId) && tokenMap.get(token.tokenId) == token.expTime) {
                tokenMap.remove(token.tokenId);
            }
        }
        return;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */