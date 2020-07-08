package leetcode.conquer.main;
import java.util.*;
public class InterviewRobot{
	
	public static void main(String[] args) throws InterruptedException {
		InterviewRobot robot = new InterviewRobot();
		
		while(robot.hasQuestion()) {
			System.out.println(robot.robotAsks());
			Thread.sleep(5*60*1000);
		}
	}
	
	public static final String[] Q = {
			"Why amazon",
			"What is your greatest weakness",
			"What is your greatest strength",
			"Tell me about your proudest professional achievement.",
			"Tell me when you have had to handle a variety of assignments. Describe the results.",
			"Tell me about a time when you went way beyond the scope of the project and delivered.",
			"Tell me about a time when you solved a problem through just superior knowledge or observation. ",
			"Tell me about a time when you influenced a change by only asking questions. ",
			"Give me two examples of when you did more than what was required in any job experience.",
			"Tell me about a time you use data to develop a strategy.",
			"Tell me about a time you had to deal with ambiguity.",
			"Tell me about a time when you had to work with limited time or resources.",
			"Tell me about a time when you had to work on a project with unclear responsibilities.",
			"Tell me about a time when you have been faced with a challenge where the best way forward or strategy to adopt was not “clear cut” (i.e. there were a number of possible solutions). How did you decide the best way forward?",
			"Tell me about a time when you had to work with incomplete data or information.",
			"Tell me about a time when you took important decision without any data",
			"Tell me about a time when you faced a problem that had multiple possible solutions",
			"Tell me about a time when you have to choose between technologies between projects",
			"How did you decide between the two technologies?",
			"Tell me about a time you step up to a leadership role.",
			"Describe a time when you saw some problem and took the initiative to correct it rather than waiting for someone else to do it.",
			"Tell me about a time when you took a calculated risk.",
			"Have you ever had to make a tough decision without consulting anybody",
			"Time when you came up with a novel solution.",
			"Describe a situation in which you found a creative way to overcome an obstacle",
			"Tell me about a time when you gave a simple solution to a complex problem.",
			"Tell me about a recent innovation",
			"Tell me something interesting you’ve learned recently.",
			"Tell me about something that you learnt recently in your role.",
			"When you realized the project review meeting wasn’t useful, how did you fix it?",
			"Tell me about a time when a team member didn’t meet your expectations on a project.",
			"Tell me about a time you needed to get information from someone who wasn’t very responsive. What did you do?",
			"Tell me about a time when you were wrong.",
			"Tell the story of the last time you had to apologize to someone.",
			"Tell me about a time when you missed an obvious solution to a problem.",
			"Tell me about a time when you couldn’t meet your own expectations on a project.",
			"We all make mistakes we wish we could take back. Tell me about a time you wish you’d handled a situation differently with a colleague. ",
			"Tell me how that project you were leading failed.",
			"Give me an example of a time when something you tried to accomplish and failed.",
			"Tell me about a time you made a serious mistake at work.",
			"Tell me about a time when you received negative feedback from your manager and how do you respond to it.",
			"Have you ever failed at something? What did you learn from it?",
			"Time when you helped someone grow but did not benefit them.",
			"Do you collaborate well",
			"Provide an example of a time you faced a conflict while working on a team how did you handle that",
			"We’ve all had to work with people that don’t like us. How do you deal with someone that doesn’t like you?",
			"Time when your team members were not supporting something but you pushed and went for a more optimal solution.",
			"Tell me about a time when you had to step up and disagree with a team members approach.",
			"If your direct manager was instructing you to do something you disagreed with, how would you handle it?",
			"Have you ever gone out of your way to help a peer",
			"Tell me about a time when you had to leave a task unfinished.",
			"Tell me about a time when you mentored someone.",
			"Tell me about a time you motivated a group of individuals.",
			"Describe a long-term project that you managed. How did you keep everything moving along in a timely manner",
			"Tell me about the time when you have to pivot a project strategy. ",
			"Tell me about the time you sacrificed a short term goal for a long term success.",
			"Tell me about a time when you faced a difficult challenge.",
			"Give me an example of a time when you set a difficult goal and were able to meet or achieve it",
			"Provide an example that you have demonstrated the ownership",
			"Tell me how to show customer obsession?",
			"Tell me about a time when you were not able to meet a time commitment. What prevented you from meeting it? What was the outcome and what did you learn from it",
			"When you’re working with a large number of customers, it’s tricky to deliver excellent service to them all. How do you go about prioritizing your customers’ needs?",
			"Give me an example of a time when you were 75% of the way through a project, and you had to pivot strategy–how were you able to make that into a success story?",
			"a time when you had to cut corners to meet a deadline",
			"What’d you do after you realized you couldn’t hit the date?",
			"Who was your most difficult customer?"
	};
	
	private List<String> questions = new ArrayList<>();
	private Map<String,Integer> q_map = new HashMap<>();
	private Random rand = new Random();
	
	public InterviewRobot() {
		for(String q : Q) {
			q_map.put(q,questions.size());
			questions.add(q);
		}
	}
	
	public boolean hasQuestion() {
		return !q_map.isEmpty();
	}
	
	public String robotAsks() {
		int index = rand.nextInt(questions.size());
		String qstr = questions.get(index);
		
		//remove question from list
		String lastQuestion = questions.get(questions.size()-1);
		questions.set(index, lastQuestion);
		q_map.put(lastQuestion, index);
		
		questions.remove(questions.size()-1);
		q_map.remove(qstr);
		return qstr;
	}
}
