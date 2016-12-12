package easy;

/**
 * Problem:
 * No: 204
 * Link: https://leetcode.com/problems/count-primes/
 * <p/>
 * Analysis:
 * Euler's Sieve
 * <p/>
 * Reference:
 * http://www.cnblogs.com/easonliu/p/4461701.html
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes?oldformat=true
 */
public class CountPrimes {
    public int countPrimes(int n) {
        int primeCount = 0;
        boolean[] flags = new boolean[n];//denote if a number, whose value is index, is already marked as a composite number
        int[] primes = new int[n];
        for (int i = 2; i < n; i++) {
            //record the first element which isn't marked as a prime
            if (!flags[i]) {
                primes[primeCount] = i;
                primeCount++;
            }
            //sieve
            for (int j = 0; j < primeCount && primes[j] * i < n; j++) {
                flags[primes[j] * i] = true;
                if ((i % primes[j]) == 0) {//guarantee every number will be sieved only once by its smallest prime factor.
                    break;
                }
            }
        }
        return primeCount;
    }
}
