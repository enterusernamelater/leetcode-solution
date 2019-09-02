package leetcode.conquer.sol.design;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * I use the queue to track the last pos of snake if snake's size has passed the score + 1 then i remove the q.poll from set
 * for every new move I first check boundary and then I check if besides the last of snake, any other positions in the snake is
 * the same as current move if so then snake fucked himself up. otherwise, if the head meets tail, the size of the snake is the same,
 * all I do is pop tail from the q and re-add the tail back to the q, so the tail is now the new head.
 * there is a size param to keep track the size of the sneak so I don't call .size() because thats O(n);
 * snake's size should always be score +1 if bigger we need to remove.
 * if the current move pos is valid and is a food position then we increase the score and don't remove the last from the snake.
 * Time O(1) Space O(n)
 */
public class DesignSnakeGame {


	/** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	private int width;
	private int height;
	private int[][] food;
	private Set<Position> snake;
	private Queue<Position> q;
	private Position head;
	private int score;
	private int size;

	public DesignSnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
		this.food = food;
		this.snake = new HashSet<>();
		this.head = new Position(0,0);
		this.snake.add(head);
		this.q = new LinkedList<>();
		this.q.offer(head);
		this.score = 0;
		this.size = 1;
	}

	/** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
	public int move(String direction) {
		Position cur = new Position(head.x,head.y);
		switch (direction){
		case "U":
			cur.x-=1;
			break;
		case "D":
			cur.x+=1;
			break;
		case "L":
			cur.y-=1;
			break;
		case "R":
			cur.y+=1;
			break; 
		}

		if(cur.x < 0 || cur.x >= height || cur.y < 0 || cur.y >= width){
			return -1;
		}
		//if snake contains the cur pos but is the tail then we know we will remove the tail dont return -1;
		if(snake.contains(cur) && !q.peek().equals(cur)) {
			return -1;
		}else if(snake.contains(cur)) {
			//if the cur pos is the snake's tail we pop the tail out of the q and later re added back to the q. 
			//so the tail is now the head.
			q.poll();
			size--;
		}
		
		//if cur is the same as tail the snake don't change
		snake.add(cur);
		size++;
		//if the cur is the same as tail, the tail is polled from previous if statement, and here the tail is added to the q as the head.
		q.offer(cur);
		head = cur;

		//check if sneak is fat again
		if(score < food.length){
			Position fpos = new Position(food[score][0],food[score][1]);
			if(fpos.equals(head)){
				score++;
			}
		}

		if(size>score+1){
			snake.remove(q.poll());
			size--;
		}
		return score;
	}
}


class Position{
	public int x;
	public int y;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o){
		Position p = (Position)o;
		return this.x==p.x && this.y==p.y;
	}

	@Override
	public int hashCode() {
		return x*y+x;
	}
}

