/* Problem: given function of rand3() which return uniformly random int number of [1,2,3], 
write a random function rand4(), which return uniformly random integer of [1,2,3,4]

This is called rejection sampling. The idea is to call rand3 until it hits the range between 1 ~ 4
3 * 3 = 9
http://articles.leetcode.com/rejection-sampling
*/

public int rand4() {
    int idx = -1;
    while (idx == -1 || idx > 8) {
        int row = rand3();
        int col = rand3();
        int idx = (row - 1) * 3 + col;
    }
    return idx % 5;
}
