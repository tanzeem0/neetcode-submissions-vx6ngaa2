class Twitter {
    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> followers;
    private Map<Integer, Post> userTweets; // Maps userId to their LATEST Post (Head of LL)

    public Twitter() {
        followers = new HashMap<>();
        userTweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Post oldHead = userTweets.get(userId);
        // Create new post and link it to the previous one
        Post newHead = new Post(tweetId, ++timestamp);
        newHead.next = oldHead; 
        userTweets.put(userId, newHead);
    }

    public List<Integer> getNewsFeed(int userId) {
        // Heap compares based on the timestamp of the Post objects
        PriorityQueue<Post> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        // 1. Add user's latest post
        if (userTweets.containsKey(userId)) {
            pq.offer(userTweets.get(userId));
        }

        // 2. Add latest posts of all followees
        if (followers.containsKey(userId)) {
            for (int followeeId : followers.get(userId)) {
                Post followeeLatest = userTweets.get(followeeId);
                if (followeeLatest != null) {
                    pq.offer(followeeLatest);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty() && result.size() < 10) {
            Post current = pq.poll();
            result.add(current.tweetId);

            // If there is an older post by this same user, add it to the heap
            if (current.next != null) {
                pq.offer(current.next);
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followers.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }

    // The Post class now acts as a Linked List Node
    private class Post {
        int tweetId;
        int time;
        Post next; // Pointer to the next older post

        Post(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
            this.next = null;
        }
    }
}