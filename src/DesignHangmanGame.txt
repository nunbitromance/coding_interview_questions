need to clarify one question first: what does the distributed hangman game mean or which part should be distributed?

there are 2 types: stateless || stateful server
stateless server might be the best way to solve the problem, since the game is very simple, nothing about security, and with a good 
encoding, client side can do all the caching of the game process with very cheap network communication. This makes the server very 
scalable.(in another sense, the server is just a skeleton to implement the logic. the game is just like running on users' machine and 
doing the calculation on server)

stateful: this one is a little bit tricky. The server side may need to record users session obtained by users' cookie or the user ID.
Considering millions of users playing at the same time, we can store the user session in a distributed database or file system like 
Chord File system or Google file system. using SHA-1 hash to distribute the user session, and do the calculation on that machine. 
To do the load balancing, we can use open source software like Haproxy as master node to dispatch the calculation.

To implement some features like leader border: we might need to use a master node to implement a B+ tree or other better data structure 
(fix sized priority queue, if only first K records are needed)

=====================================================

1) TCP based session establishment (process based system where each request is handled by a forking/preforking a new process instance.) 
2) Per user session created. Session class can look like:

class HMSession
            {
                 string userid;
                 string word;
                 int [] correct_guesses;  // positions guessed already
                 int chances_left;
                 bool isGuessCorrect(char c);
             public:
                 string getRandomWord();
                 bool guessChar(char c);
                 bool guessWord(string word);
         };
3) Basic operations expected will be searching for presence of given char in the string to be guessed and updating number of turns left. 
4) I think the request-responses can be synchronous. Operations to be done are pretty basic. Single server should be able to serve 
100s of users concurrently without any significant latency. 
5) Since the user data is confined in the process'es address space boundaries concurrency issues should not come in picture. 
6) Session info will be in-memory (if scores are to be kept, those can be written to disk). User info should also be saved as cookies, 
so if connection is lost the game can be resumed easily. 
7) These Hangman servers can be behind a load-balancer who can simply serve in requests in a round-robin manner or sophisticated 
monitoring system can be built for health checking and keeping track of current load on a system. 
8) New hosts can be added to the load balancer or inactive/dead hosts can be removed without the needing any special configuration. 


public class Hangman {
    private final int ALLOWED_TURNS = 7;
    private final String wordToGuess;
    private boolean[] currentState;
    private int turnsLeft;
     
    Hangman(String wordToGuess){
        this.wordToGuess = wordToGuess.toLowerCase();
        this.currentState = new boolean[wordToGuess.length()];
        this.turnsLeft = ALLOWED_TURNS;
        display();
    }
     
    public boolean match(char guess){
        boolean found = false;
        for(int i=0;i&amp;lt;wordToGuess.length();i++){
            if(guess == wordToGuess.charAt(i)){
                currentState[i] = true;
                found = true;
            }
        }
        if(!found)
            turnsLeft--;
         
        boolean isComplete = true;
         
        for(int i=0;i&amp;lt;currentState.length;i++){
            if(!currentState[i])
                isComplete = false;
        }
         
        if(isComplete){
            System.out.println(&amp;quot;Congratulations You Guessed It right &amp;quot; + wordToGuess);
            return true;
        }
         
        if(turnsLeft == 0){
            System.out.println(&amp;quot;Sorry you loose&amp;quot;);
            return true;
        }   
        display();
        return false;
    }
     
    public void display(){
        for(int i=0;i&amp;lt;currentState.length;i++){
            if(currentState[i]){
                System.out.print(&amp;quot; &amp;quot; + wordToGuess.charAt(i) + &amp;quot; &amp;quot;);
            }else{
                System.out.print(&amp;quot; _ &amp;quot;);
            }           
        }
        System.out.print(&amp;quot; Turn left &amp;quot; + turnsLeft);
    }
}
To create a game and play

public class HangmanDemo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Hangman g1 = new Hangman(&amp;quot;Microsoft&amp;quot;);
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            System.out.println();
            String in = s.next().toLowerCase();
            if(in.length() &amp;gt; 1)
                throw new IllegalArgumentException();
            char guess = in.charAt(0);
            boolean hasGameEnded = g1.match(guess);
            if(hasGameEnded)
                break;
        }
        s.close();
    }
}

