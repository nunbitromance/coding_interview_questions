Find Missing Integer (<Cracking Coding Interview> 10.3)

Given a file with 4 billion distinct integers, find out an integer that is not contained in the file.
Assume you have 1 GB of memory.
Assume you have 10 MB of memory.
Solution

There are 2^32 distinct integers and the file contains 4 billion ~= 2^32 integers.

Given 1 GB memory, i.e. 2^30 bytes = 2^33 bits.
We can map all integers to a Bitmap so that all integers can be loaded into memory. So, we can solve the problem in one-pass.
 public int findMissingNumber(int[] data) {  
   long n = (long)Integer.MAX_VALUE >> 1;  
   byte[] bitmap = new byte[(int)(n >> 3)];  
   
   // scan all data  
   for (int i=0; i<data.length; ++i) {  
     bitmap[data[i]>>3] |= (1 << (data[i] & 7));  
   }  
   
   // find missing one  
   for (int i=0; i<bitmap.length; ++i) {  
     for (int j=0; j<8; ++j) {  
       if ((bitmap[i] & (1 << j)) == 0) return (i*8 + j);  
     }  
   }  
   
   // not found  
   return -1;  
 }  

Given 10 MB memory, to find a missing integer requires two pass of data.
Divide the data into N blocks and count the number of integers in each block. If the block contains the missing integer, the count will be smaller than the size of the block.
Minimum memory usage is
N * 4 < 10 * 2^20 (in bytes)
where N is the number of blocks.
For the block that contains the missing integer, apply bitmap over integers in the block to find the missing one.
Minimum memory usage is
2^32 / N = B < 10 * 2^20 * 8 (in bits)
where B is the size of a block.
So, the block size can be in range [2^11, 2^26]. Selecting a middle value such that both passes require less memory, i.e. N*4*8 ~= B, B = 2^18.
 public int findMissingNumber(int[] data) {  
   int blockSize = 1 << 18; // block size 2^18  
   int blockNum = 1 << 14; // N = 2^32 / 2^18  
   
   int start = countNumInBlock(data, new int[blockNum], blockSize);  
   return findMissingNumInBlock(data, start);  
 }  
   
 /* Count the number of integers in each block and return the one with missing integer. */  
 private int countNumInBlock(int[] data, int[] counts, int blockSize) {  
   for (int i=0; i<data.length; ++i) {  
     ++counts[data[i] >> 18];  
   }  
   
   for (int i=0; i<counts.length; ++i) {  
     if (counts[i] < blockSize) return blockSize * i;  
   }  
   
   return -1;  
 }  
   
 /* Find a missing integer from given block [start, start+blockSize). */  
 private int findMissingNumInBlock(int[] data, int start, int blockSize) {  
   byte[] bitmap = new byte[(int)(blockSize >> 3)];  
   
   // scan all data  
   int end = start + blockSize;
   for (int i=0; i<data.length; ++i) {  
     if (data[i] >= start && data[i] < end)
       bitmap[data[i]>>3] |= (1 << (data[i] & 7));  
   }  
   
   // find missing one  
   for (int i=0; i<bitmap.length; ++i) {  
     for (int j=0; j<8; ++j) {  
       if ((bitmap[i] & (1 << j)) == 0) return (i*8 + j);  
     }  
   }  
   
   // not found  
   return -1;  
 }  
