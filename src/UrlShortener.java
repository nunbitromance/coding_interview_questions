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
