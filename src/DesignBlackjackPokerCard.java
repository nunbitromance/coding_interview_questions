. Design the data structures for a generic deck of cards. Explain how you would
subclass the data structures to implement blackjack.
pgWS
SOLUTION
First, we need to recognize that a "generic" deck of cards can mean many things. Generic
could mean a standard deck of cards that can play a poker-like game, or it could even
stretch to Uno or Baseball cards. It is important to ask your interviewer what she means
by generic.
Let's assume that your interviewer clarifies that the deck is a standard -card set, like
you might see used in a blackjack or poker game. If so, the design might look like this:
 public enum Suit {
 Club (), Diamond (), Heart (), Spade ();
 private int value;
 private Suit(int v) { value = v; }
 public int getValue() { return value; }
 public static Suit getSuitFromValue(int value) { ... }
 }

 public class Deck <T extends Card> {
 private ArrayList<T> cards; // all cards, dealt or not
 private int dealtlndex = ; // marks first undealt card

 public void setDeckOfCards(ArrayList<T> deckOfCards) { ... }

 public void snuffle() { ... }
 public int remainingCardsQ {
 return cards.sizeQ - dealtlndex;
 }
 public T[] dealHand(int number) { ... }
 public T dealCardQ { ••• }
 }

 public abstract class Card {
 private boolean available = true;

 /* number or face that's on card - a number  through , or 
 * for Jack,  for Queen,  for King, or  for Ace */
 protected int faceValue;
 protected Suit suit;

 public Card(int c, Suit s) {
 faceValue = c;
 suit = s;
 }

 Cracking the Coding Interview | Solutions to Object-Oriented Design
Solutions to Chapter  | Object-Oriented Design
 public abstract int value();

 public Suit suit() { return suit; }

 /* Checks if the card is available to be given out to someone */
 public boolean isAvailableQ { return available; }
 public void markUnavailableQ { available = false; }

 public void markAvailableQ { available = true; }
 }

 public class Hand <T extends Card> {
 protected ArrayList<T> cards = new ArrayList<T>();

 public int score() {
 int score = ;
 for (T card : cards) {
score += card.value();
 }
return score;
 }

 public void addCard(T card) {
 cards.add(card);
 }
 }
In the above code, we have implemented Deck with generics but restricted the type
of T to Card. We have also implemented Card as an abstract class, since methods like
value() don't make much sense without a specific game attached to them. (You could
make a compelling argument that they should be implemented anyway, by defaulting
to standard poker rules.)
Now, let's say we're building a blackjack game, so we need to know the value of the
cards. Face cards are  and an ace is  (most of the time, but that's the job of the Hand
class, not the following class).
 public class BlackDackHand extends Hand<BlackJackCard> {
 /* There are multiple possible scores for a blackjack hand,
 * since aces have multiple values. Return the highest possible
 * score that's under , or the lowest score that's over. */
public int scoreQ {
 ArrayList<Integer> scores = possibleScoresQ;
int maxUnder = Integer.MIN_VALUE;
 int minOver = Integer.MAX_VALUE;
 for (int score : scores) {
 if (score >  && score < minOver) {
 minOver = score;
 } else if (score <=  && score > maxUnder) {
 maxUnder = score;
CrackingTheCodinglnterview.com 
Solutions to Chapter  | Object-Oriented Design
 }
 }
 return maxUnder == Integer.MIN_VALUE ? tninOver : maxUnder;
 }

 /* return a list of all possible scores this hand could have
 * (evaluating each ace as both  and  */
 private ArrayList<Integer> possibleScoresQ { ... }

 public boolean bustedQ { return scoreQ > ; }
 public boolean is() { return scoreQ == ; }
 public boolean IsBlackJackQ { ... }
 }

 public class BlackJackCard extends Card {
 public BlackJackCard(int c, Suit s) { super(c, s); }
 public int value() {
 if (isAce()) return ;
 else if (faceValue >=  && faceValue <= ) return ;
 else return faceValue;
 }

 public int minValueQ {
 if (isAceQ) return ;
 else return valueQ;
 }

 public int maxValueQ {
 if (isAceQ) return ;
 else return value();
 }

 public boolean IsAceQ {
 return faceValue == ;
 }

 public boolean isFaceCardQ {
 return faceValue >=  && faceValue <= ;
 }
