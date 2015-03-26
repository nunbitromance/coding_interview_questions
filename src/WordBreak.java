public class Solution{
	public int ladderLength(String start,String end, HashSet<String> dict){
		if(dict.size()==0)
			return0;
		int result=0;
		LinkedList<String>wordQueue=newLinkedList<String>();
		LinkedList<Integer>distanceQueue=newLinkedList<Integer>();
		wordQueue.add(start);
		distanceQueue.add(1);
		while(!wordQueue.isEmpty()) {
			String currWord = wordQueue.pop();
			Integer	currDistance = distanceQueue.pop();
			if (currWord.equals(end)) {
				return currDistance;
			}
			for(inti=0;i<currWord.length();i++){
			char[]currCharArr=currWord.toCharArray();
			for(charc=’a’;c<=’z’;c++){
				currCharArr[i]=c;
				StringnewWord=newString(currCharArr);
				if(dict.contains(newWord)){
				wordQueue.add(newWord);
				distanceQueue.add(currDistance+1);
				dict.remove(newWord);
			}	
			}
		}
	}
	return0;
	}
	
	String SegmentString(String input, Set<String> dict) {
	  if (dict.contains(input)) return input;
	  int len = input.length();
	  for (int i = 1; i < len; i++) {
	    String prefix = input.substring(0, i);
	    if (dict.contains(prefix)) {
	      String suffix = input.substring(i, len);
	      String segSuffix = SegmentString(suffix, dict);
	      if (segSuffix != null) {
	        return prefix + " " + segSuffix;
	      }
	    }
	  }
	  return null;
	}
	
	Map<String, String> memoized;

	String SegmentString(String input, Set<String> dict) {
	  if (dict.contains(input)) return input;
	  if (memoized.containsKey(input) {
	    return memoized.get(input);
	  }
	  int len = input.length();
	  for (int i = 1; i < len; i++) {
	    String prefix = input.substring(0, i);
	    if (dict.contains(prefix)) {
	      String suffix = input.substring(i, len);
	      String segSuffix = SegmentString(suffix, dict);
	      if (segSuffix != null) {
	        memoized.put(input, prefix + " " + segSuffix);
	        return prefix + " " + segSuffix;
	}
	}
	memoized.put(input, null);
	return null;
	}
}
