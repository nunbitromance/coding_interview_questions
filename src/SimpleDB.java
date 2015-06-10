package simple_db;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


/* https://www.thumbtack.com/challenges/simple-database */
public class SimpleDb {

	// transactions with rollback commands for ROLLBACK
	private Stack<Transaction> transactions = new Stack<Transaction>();
	
	// variable and history of values for SET and UNSET
	private Map<String, Stack<String>> history = new HashMap<>();
	
	// values and their counts for NUMEQUALTO
	private Map<String, Integer> valueCountMap = new HashMap<>();
	
	static final String GET_STRING = "GET";
	static final String SET_STRING = "SET";
	static final String UNSET_STRING = "UNSET";
	static final String NUMEQUALTO_STRING = "NUMEQUALTO";
	static final String END_STRING = "END";
	static final String BEGIN_STRING = "BEGIN";
	static final String ROLLBACK_STRING = "ROLLBACK";
	static final String COMMIT_STRING = "COMMIT";
	static final String NULL_STRING = "NULL";
	static final String NO_TRANSACTION_STRING = "NO TRANSACTION";
	static final String ZERO_NUM_VALUE = "0";
	
	public String processCommand(String command) {
		//System.out.println("processing command: " + command);
		
		if (command == null || command.isEmpty()) {
			return "INVALID COMMAND: BLANK OR NULL";
		}
		String[] parsed = command.split(" ");
		String result = null;
		String operation = parsed[0];
		String variable = null;
		String value = null;
		switch (operation) {
		case GET_STRING:
			variable = parsed[1];
			result = processGet(variable);
			break;
		case SET_STRING:
			variable = parsed[1];
			value = parsed[2];
			processSet(variable, value);
			break;
		case UNSET_STRING:
			variable = parsed[1];
			processUnset(variable);
			break;
		case NUMEQUALTO_STRING:
			value = parsed[1];
			result = processNumEqualTo(value);
			break;
		case END_STRING:
			processEnd();
			break;
		case BEGIN_STRING:
			processBegin();
			break;
		case ROLLBACK_STRING:
			result = processRollback();
			break;
		case COMMIT_STRING:
			processCommit();
			break;
		default:
			result = "INVALID COMMAND";
			break;
		}
		
		/*System.out.println("transactions: " + transactions.toString());
		System.out.println("history: " + history.toString());
		System.out.println("valueCountMap: " + valueCountMap.toString());*/
		
		return result;
	}
	
	public void processBegin() {
		this.transactions.push(new Transaction());
	}
	
	public String processRollback() {
		String result = null;
		if (!this.transactions.isEmpty()) {
			Stack<String> rollbackCommands = transactions.pop().getCommands();
			while (!rollbackCommands.isEmpty()) {
				String command = rollbackCommands.pop();
				processCommand(command);
			}
		} else {
			result = NO_TRANSACTION_STRING;
		}
		return result;
	}
	
	public void processCommit() {
		this.transactions.clear();
	}
	
	public String processGet(String variable) {
		String result = null;
		if (this.history.containsKey(variable)) {
			result = this.history.get(variable).peek() != null ?
					this.history.get(variable).peek() : NULL_STRING;
		} else {
			result = NULL_STRING;
		}
		return result;
	}
	
	public void processSet(String variable, String value) {
		String prevValue = null;
		
		if (this.history.containsKey(variable)) {
			prevValue = this.history.get(variable).peek();
			this.history.get(variable).push(value);
		} else {
			Stack<String> stack = new Stack<String>();
			stack.push(value);
			this.history.put(variable, stack);
		}
		
		if (this.valueCountMap.containsKey(value)) {
			this.valueCountMap.put(value, this.valueCountMap.get(value) + 1);
		} else {
			this.valueCountMap.put(value, 1);
		}
		
		if (this.valueCountMap.containsKey(prevValue)) {
			this.valueCountMap.put(prevValue, this.valueCountMap.get(prevValue) - 1);
		}
		
		if (!transactions.isEmpty()) {
			// place reverse command onto the transaction log.
			transactions.peek().getCommands().add("SET" + " " + variable + " " + prevValue);
		}
	}
	
	public void processUnset(String variable) {
		processSet(variable, null);
	}
	
	public String processNumEqualTo(String value) {
		String result = null;
		if (this.valueCountMap.containsKey(value)) {
			result = valueCountMap.get(value).toString();
		} else {
			result = NULL_STRING;
		}
		return result;
	}
	
	public void processEnd() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDb db = new SimpleDb();
		// using auto-closeable in java 7
		try (Scanner scanner = new Scanner(System.in)) {
			String command = null;
			while (!(command = scanner.nextLine()).equals(END_STRING)) {
				String result = db.processCommand(command);
				if (result != null) {
					System.out.println(result);
				}
			}
		}
	}

}

package simple_db;

import java.util.Stack;

public class Transaction {

	private Stack<String> commands = new Stack<String>();

	public Stack<String> getCommands() {
		return commands;
	}

	@Override
	public String toString() {
		return "Transaction [commands=" + commands + "]";
	}
	
}
