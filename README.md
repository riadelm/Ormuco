# Ormuco
Technical Test for Ormuco summer 2020 internship position
Code written using JAVA:


Question A
Your goal for this question is to write a program that accepts two lines (x1,x2) and (x3,x4) on the x-axis and returns whether they overlap. As an example, (1,5) and (2,6) overlaps but not (1,5) and (6,8).
 
     - I was able to implement a program that only uses primitive data types to store two lines and return whether they overlap or not. 
     - The program separates the situation into two cases. First one is when the first line entered has the lowest starting point, or vice versa. Then we only have to compare the extremums of the lines to figure out whether they overlap.
     - The lines only exist on the positive part of the x axis.


-Question B: 
The goal of this question is to write a software library that accepts 2 version string as input and returns whether one is greater than, equal, or less than the other. As an example: “1.2” is greater than “1.1”. Please provide all test cases you could think of.

    - I was able to implement a version string comparison program: 
    - The program starts by prompting the user, then it splits the integer strings into elements of 2 arrays that store each       number of the version string separately x.y => {x,y}, then it makes these arrays equal in length, adding zeros to the shortest one to match the longest one. Then the program concatenates the array elements, turns them into integers and compares them. I found this method to be the most efficient
    - However the version strings cannot have a component higher than 9 (i.e: 3.11.2)
    

-Question C: At Ormuco, we want to optimize every bits of software we write. Your goal is to write a new library that can be integrated to the Ormuco stack. Dealing with network issues everyday, latency is our biggest problem. Thus, your challenge is to write a new Geo Distributed LRU (Least Recently Used) cache with time expiration.

    - I was able to successfully implement an LRU cache using linked list and hashmap data structures
    - Efficient because linked list helps with the fast removal process and Hashmap help with the fast lookup process
      which are the two important aspects of a LRU cache
    - Was not able to implement a time expiration and the geo distributed methods
