public class UrlShortener {

  private static const char[] map = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWYXZ".toCharArray();

  public long shortUrlToId(String shortUrl) {
    long id = 0;
    for (int i = 0; i < shortUrl.length(); i++) {
      char c = shortUrl.charAt(i);
      if (c >= '0' && c <= '9') {
        id = id * 62 + c - '0';
      } else if (c >= 'a' && c <= 'z') {
        id = id * 62 + c - 'a' + 10;
      } else if (c >= 'A' && c <= 'Z') {
        id = id * 62 + c - 'A' + 36;
      }
    }
    return id;
  }
  
  public String idToShortUrl(long id) {
    StringBuilder sb = new StringBuilder();
    while (id > 0) {
      char c = map[id % 62];
      id = id / 62;
      sb.append(c);
    }
    return sb.reverse().toString();
  }
  
  public String urlToShortUrl(String url) {
    List<Record> records = db.search(url);
    String shortUrl = null;
    if (records.isEmpty()) {
      long id = db.insert(url);
      shortUrl = idToShortUrl(id);
      db.update(id, shortUrl);
    } else {
      shortUrl = records.get(0).shortUrl;
    }
    return shortUrl;
  }
}


package test;

import java.util.HashMap;
import java.util.Map;

public class Test {
    
    private static final char[] letters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWYXZ".toCharArray();

    private Map<Integer, String> map = null;
    
    private static final int startingIndex = 10;

    public Test() {
        map = new HashMap<>();
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int id = startingIndex + map.size() + 1;
        map.put(id, longUrl);
        String result = convertToString(id);
        return result;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        long id = urlToBased62(shortUrl);
        String longUrl = map.get((int)id);
        return longUrl;
    }
    
    public long urlToBased62(String url) {
        long id = 0;
        for (int i = 0; i < url.length(); i++) {
        	char c = url.charAt(i);
	        if (c >= '0' && c <= '9') {
	          id = id * 62;
	        } else if (c >= 'a' && c <= 'z') {
	          id = id * 62 + c - 'a' + 10;
	        } else if (c >= 'A' && c <= 'Z') {
	          id = id * 62 + c - 'A' + 36;
	        } 
        }
        return id;
      }
    
    private String convertToString(long id) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            long d = id % 62;
            sb.append(letters[(int)d]);
            id = id / 62;
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Test t = new Test();
		String shortUrl = t.encode("oiwehfoijweoijfoiwejfijeroijer");
		String longUrl = t.decode(shortUrl);
		System.out.println(shortUrl);
		System.out.println(longUrl);
		System.out.println("oiwehfoijweoijfoiwejfijeroijer".equals(longUrl));
	}
}
