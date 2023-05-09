# [ADSP]
Algorithms + Data Structure = Programs

# [LeetCode 2506] 
It somehow happened in this life that only now I started visiting interview in software development industry.
Looks like interviewers like to ask algorithmic question/live coding. Honestly I played with this kind of tasks 
last time only during schooldays on Olimpiads in informatics. 

In my subjective opinion in mainstream and appliance programming you will almost never
meet with this kind of tasks in 95%+, even "bubble-sort like" algorithms will be outside of
horizon for most programmers nowadays. But it's definitely necessary and used in real systems
in narrow range of tasks.

To keep my 30+ years old experience in this area up to date in context of interview, I've decided to 
get only one easy task from LC, resolve it and share with you my experience.

Also in addition to pure algorithmic solution, it's converted to recent Java based implementations with
functional programming, lambdas, fork/join, virtual threads, tuples(record), concurrent and parallel
processing approach.

So let's start:

# [2506 readme]
Count Pairs Of Similar Strings

Easy

You are given a **0-indexed** string array `words`.

Two strings are **similar** if they consist of the same characters.

*   For example, `"abca"` and `"cba"` are similar since both consist of characters `'a'`, `'b'`, and `'c'`.
*   However, `"abacba"` and `"bcfd"` are not similar since they do not consist of the same characters.

Return _the number of pairs_ `(i, j)` _such that_ `0 <= i < j <= word.length - 1` _and the two strings_ `words[i]` _and_ `words[j]` _are similar_.

**Example 1:**

**Input:** words = ["aba","aabb","abcd","bac","aabc"]

**Output:** 2

**Explanation:** There are 2 pairs that satisfy the conditions:

- i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'.

- i = 3 and j = 4 : both words[3] and words[4] only consist of characters 'a', 'b', and 'c'.

**Example 2:**

**Input:** words = ["aabb","ab","ba"]

**Output:** 3

**Explanation:** There are 3 pairs that satisfy the conditions:

- i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'.

- i = 0 and j = 2 : both words[0] and words[2] only consist of characters 'a' and 'b'.

- i = 1 and j = 2 : both words[1] and words[2] only consist of characters 'a' and 'b'.

**Example 3:**

**Input:** words = ["nba","cba","dba"]

**Output:** 0

**Explanation:** Since there does not exist any pair that satisfies the conditions, we return 0.

**Constraints:**

*   `1 <= words.length <= 100`
*   `1 <= words[i].length <= 100`
*   `words[i]` consist of only lowercase English letters.



