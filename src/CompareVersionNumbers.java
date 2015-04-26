/*Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37*/

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] segV1 = version1.split("\\.");
        String[] segV2 = version2.split("\\.");
        
        int i = 0, j = 0;
        while (i < segV1.length && j < segV2.length) {
            Integer v1 = Integer.parseInt(segV1[i]);
            Integer v2 = Integer.parseInt(segV2[j]);
            
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            
            i++;
            j++;
        }
        
        if (i < segV1.length) {
            if (Integer.parseInt(segV1[i]) == 0) {
                return 0;
            }
            return 1;
        } else if (j < segV2.length) {
            if (Integer.parseInt(segV2[j]) == 0) {
                return 0;
            }
            return -1;
        }
        return 0;
    }
}
