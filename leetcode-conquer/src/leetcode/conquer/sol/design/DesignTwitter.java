package leetcode.conquer.sol.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * use two map for mapping following for each user and each users Tweets
 * the unfollow and follow is pretty much remove or add on set
 * when post a tweet we adding the tweet to the users tweet list also
 * if the user is not followed himself yet we will follow himself.
 * 
 * finally the juicy part, getNewsFeed
 * this is pretty much a similar solution to any priority queue solution. 
 * first set priority queue sort property a-b (tweet.time), then we grab the given users following list
 * , loop through each following users tweet list and adding them to the priority queue before the queue size is 10
 * When priority queue size hits 10
 * we poll the top which is the oldest and add a new one in.
 * also for each tweet list of a user, the tweet is sorted from the latest to the oldest
 * so when the priority queue hit 10 size and realizing that the current user's current tweet is older than
 * the queue's oldest(the top of the queue) we can break the loop and move on the the next user because the current user's left over 
 * tweets will not be added to the queue.
 * finally we do a stream and convert the queue's vals into a list and return.
 * Time O(nlogn) Space O(n)
 */
public class DesignTwitter {
    private Map<Integer,LinkedList<Tweet>> news;
    private Map<Integer,Set<Integer>> users;
    private static int time;
    /** Initialize your data structure here. */
    public DesignTwitter() {
        this.news = new HashMap<>();
        this.users = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        LinkedList<Tweet> list = news.getOrDefault(userId, new LinkedList<>());
        list.addFirst(new Tweet(tweetId, time++));
        news.putIfAbsent(userId,list);
        //follow myself
        Set<Integer> set = users.getOrDefault(userId, new HashSet<>());
        set.add(userId);
        users.putIfAbsent(userId,set);
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
       Set<Integer> set = users.getOrDefault(userId,new HashSet<>());
       PriorityQueue<Tweet> queue = new PriorityQueue<>((a,b) -> (a.time - b.time));
       
       for(int user : set){
           LinkedList<Tweet> tweets = news.getOrDefault(user, new LinkedList<>());
           for(Tweet tweet : tweets){
               if(queue.size() == 10){
                   if(!queue.isEmpty() && queue.peek().time > tweet.time) break;
                   queue.poll();
                   queue.offer(tweet);
               }else{
                   queue.offer(tweet);
               }
           }
       }
        
       LinkedList<Integer> res = new LinkedList<>();
       while(!queue.isEmpty()) res.addFirst(queue.poll().id);
       return res; 
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = users.getOrDefault(followerId,new HashSet<>());
        set.add(followeeId);
        users.putIfAbsent(followerId,set);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        Set<Integer> set = users.getOrDefault(followerId,new HashSet<>());
        if(set.contains(followeeId)) set.remove(followeeId);
        users.putIfAbsent(followerId,set);
    }
}

class Tweet{
    public int id;
    public int time;
    
    public Tweet(int id, int time){
        this.id = id;
        this.time = time;
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */