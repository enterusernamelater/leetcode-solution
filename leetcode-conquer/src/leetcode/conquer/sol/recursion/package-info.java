/*
 * This package contains all recursion solutions from leetcode I did
 * mainly three types of recursion questions:
 * 1. backtracking meaning you will need to store a state for each recursive call and restore the state back to normal
 * 2. DFS,
 * 3. BFS, sometime BFS can be achieved using QUEUE or SET
 * 
 * between combination and permutation questions, combination and permutation both dont allow identical combos. 
 * however combiation doesnt allow any duplicate combs eg. 123 213. however in permutation this is allowed as
 * in combiation order doesnt matter but in permutation order matters.
 * so the time complexity for combination in general is faster that permutation 
 * in combination the time complexity is rough to 2^n
 * while permuation has time complexity of rough to n!
 */
package leetcode.conquer.sol.recursion;
