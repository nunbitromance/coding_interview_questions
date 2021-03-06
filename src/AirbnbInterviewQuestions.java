1. min coin problem
2. circular buffer problem
3. maximum non-adjacent subsequence problem: Provide a set of positive integers (an array of integers). Each integer represent number of nights user request on Airbnb.com. If you are a host, you need to design and implement an algorithm to find out the maximum number a nights you can accommodate. The constrain is that you have to reserve at least one day between each request, so that you have time to clean the room. Example: 1) Input: [1, 2, 3] ===&gt; output: 4, because you will pick 1 and 3 2) input: [5, 1, 2, 6] ===&gt; output: 11, because you will pick 5 and 6 3) input: [5, 1, 2, 6, 20, 2] ===&gt; output: 27, because you will pick 5, 2, 20  
4. word boggle problem: Given a dictionary, and a matrix of letters, find all the words in the matrix that are in the dictionary. (Going across, down or diagonally)  
5. csv parser
6. lower/uppercase permutations, simple json parsing, implementing a simple socket based client (could lookup docs online). You need to produce *running code (this is true for both phone and onsite)
7. find all the combinations of a string in lowercase and uppercase. For example, string "ab" -&gt; "ab", "Ab", "aB", "AB". So, you will have 2^n (n = number of chars in the string) output strings. The goal is for you to test each of these string and see if it match a hidden string. 2. Implement a simple regex parser which, given a string and a pattern, returns a boolean indicating whether the input matches the pattern. By simple, we mean that the regex can only contain special character: * (star), . (dot), + (plus). The star means what you'd expect, that there will be zero or more of previous character in that place in the pattern. The dot means any character for that position. The plus means one or more of previous character in that place in the pattern.  
8. Find all words from a dictionary that are x edit distance away.  
9. Lots of tree questions (implement a BST, score sudden-death tournament results with a minimal binary tree data structure, encode an alien dictionary using a tree and then produce a dictionary using topological traversal), and a "rebuild Twitter from the ground up" scaling/architecture question. 
10. Store a set of sudden-death tournament results in a compact format (eg. a bit array) and a set of predicted match results (also in a bit array). Score the predictions, giving one point per correctly guessed match, without unpacking the bit array into a more convenient format (ie. you have to traverse the tree in-place). 
11. Sort a list of numbers in which each number is at a distance k from its actual position  
12. You have a plain with lots of rectangles on it, find out how many of them intersect  


/**
* returns a row of values as a list
* returns null if you are past the end of the input stream
*/
public static List<String> parseLine(Reader r) throws Exception {
    int ch = r.read();
    while (ch == '\r') {
        //ignore linefeed chars wherever, particularly just before end of file
        ch = r.read();
    }
    if (ch<0) {
        return null;
    }
    Vector<String> store = new Vector<String>();
    StringBuffer curVal = new StringBuffer();
    boolean inquotes = false;
    boolean started = false;
    while (ch>=0) {
        if (inquotes) {
            started=true;
            if (ch == '\"') {
                inquotes = false;
            }
            else {
                curVal.append((char)ch);
            }
        }
        else {
            if (ch == '\"') {
                inquotes = true;
                if (started) {
                    // if this is the second quote in a value, add a quote
                    // this is for the double quote in the middle of a value
                    curVal.append('\"');
                }
            }
            else if (ch == ',') {
                store.add(curVal.toString());
                curVal = new StringBuffer();
                started = false;
            }
            else if (ch == '\r') {
                //ignore LF characters
            }
            else if (ch == '\n') {
                //end of a line, break out
                break;
            }
            else {
                curVal.append((char)ch);
            }
        }
        ch = r.read();
    }
    store.add(curVal.toString());
    return store;
}
