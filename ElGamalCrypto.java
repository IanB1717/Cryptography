import java.util.Scanner;
public class ElGamalCrypto
{
	public static long modMult(long first, long second, long modulus){
	//multiplies the first number by the second number with the given modulus

		if(second==0)return 0;
		else if (second%2==0) {
			long half=modMult(first, second/2, modulus);
			return (half+half)%modulus;
		}else{
			long half=modMult(first, second/2, modulus);
			return (half+half+first)%modulus;
		}
	}

	public static long modPow(long number, long power, long modulus){
	//raises a number to a power with the given modulus

		if(power==0)return 1;
		else if (power%2==0) {
			long halfpower=modPow(number, power/2, modulus);
			return modMult(halfpower,halfpower,modulus);
		}
		else{
			long halfpower=modPow(number, power/2, modulus);
			long firstbit = modMult(halfpower,halfpower,modulus);
			return modMult(firstbit,number,modulus);
		}
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		long p = sc.nextLong(), g = sc.nextLong(), gxmodp = sc.nextLong(), x = 0, ans = 0, c1 = sc.nextLong(), c2 = sc.nextLong(), msg = 0;
		while(ans != gxmodp)
		{
			ans = modPow(g,x,p);
			if(ans != gxmodp) x++;
		}
		msg = ((modPow(c1,p-1-x,p))*c2)%p;
		System.out.println(msg);
	}
}