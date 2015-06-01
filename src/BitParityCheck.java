Given an integer of a certain bit length, does it have an even or odd number of parity bits?

/* Function to get parity of number n. It returns 1
   if n has odd parity, and returns 0 if n has even
   parity */
bool getParity(int n)
{
    bool parity = 0;
    while (n)
    {
        parity = !parity;
        n      = n & (n - 1);
    }        
    return parity;
}

bool getParity(int n)
{
	if (n == 0) {
		return false;
	}

	return !getParity(n & (n - 1));
}
 
/* Driver program to test getParity() */
int main()
{
    unsigned int n = 7;
    printf("Parity of no %d = %s",  n, 
             (getParity(n)? "odd": "even"));
     
    getchar();
    return 0;
}
