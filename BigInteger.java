package bigint;

/**
 * BigInteger contains an Integer of arbitrarty length 
 * @author Anton
 *
 */
public final class BigInteger {

	private static BigInteger TEN = new BigInteger("9");

	static {
		TEN = TEN.add(new BigInteger("1"));
	}

	/** Linked list of bits starting from lower rank */
	private Bit bits;

	/** Class presenting single bit of BigInteger */
	private static class Bit {
		/** true if bit == 1, false if bit   */
		private boolean state;
		
		/** Next higher rank */
		private Bit next;

		/** Constructor */
		private Bit(boolean state) {
			this.state = state;
		}

		/** Multiply this by ten */
		private Bit multi10(int pow) {
			Bit b = this;
			for (int i = 0; i < pow; i++)
				b = shiftAndAdd(b, TEN.bits);
			return b;
		}
		
		/** Decomposed multiplication by shift and add */
		private Bit shiftAndAdd(Bit base, Bit factor) {
			if (factor == null || factor.next == null)
				return base;
			if (base.next == null && base.state)
				return factor;

			Bit product = shiftAndAdd(base, factor.next);

			Bit b = product.doubles();//this is shift

			if (factor.state)
				return add(b, base, false);

			return b;
		}
		
		/** to int helper, overflow risk, for test purpose */
		private int toInt() {
			return (state ? 1 :0) + toInt(1, next);
		}
		
		/** to int helper, overflow risk, for test purpose */
		private int toInt(int f, Bit b) {
			if (b == null) 
			{
				return 0;
			}
			int p = 0;
			if (b.state)
				p = f*2;
			return p + toInt(f*2, b.next);
		}
		
		/** Self explaining :) */
		public String toString() {return toInt()+"";};
		
		/** Multiply this by 2 */
		private Bit doubles() {
			Bit b = new Bit(false);
			b.next = this;
			return b;
		}

		
	}

	public BigInteger(String val) {		
		this.bits = splitAndCalc(val);
	}
	
	private BigInteger() {
		bits = new Bit(false);
	}

	/** Decimal to bitwise conversion */
	protected Bit forChar(char val) {
		Bit first = null;
		
		if (val >= '0' && val <= '9') {
			int N = val - '0';
			int n = (int) Math.floor(Math.log10(N) / Math.log10(2)) + 1;
			int bytes[] = new int[n];
			int i = n - 1;
			while (N != 0) {
				bytes[i] = N % 2;
				N = N / 2;
				i = i - 1;
			}
			for (int b : bytes) {
				Bit t = new Bit(b == 1);
				if (first == null) {
					first = t;
				} else {
					t.next = first;
					first = t;
				}
			}
		}
		return first;
	}

	public String toString() {
		return bits.toString();
	}

	/** API's add method */
	public BigInteger add(BigInteger add) {
		BigInteger summ = new BigInteger();
		summ.bits = add(this.bits, add.bits, false);
		return summ;
	}

	/** Recursively applies bitwise addition algorithm */
	static Bit add(Bit b1, Bit add, boolean rem) {
		Bit b = new Bit(false);
		if (b1 == null && add == null) {
			if (rem)
				return new Bit(true);
			else
				return null;
		}

		Bit next = null;

		if (b1 == null) {
			if (rem)
				b.state = add.state;
			else
				b.state = !add.state;
			next = add(null, add.next, add.state && rem);
		} else if (add == null) {
			if (rem)
				b.state = !b1.state;
			else
				b.state = b1.state;
			next = add(b1.next, null, b1.state && rem);
		} else {
			if (!rem)
				b.state = b1.state ^ add.state;
			else
				b.state = !(b1.state ^ add.state);
			next = add(b1.next, add.next, ((b1.state || add.state) && rem) || (b1.state && add.state));
		}
		if (next != null)
			b.next = next;
		return b;
	}

	/**
	 * 1) Recursively devides input string into 2 parts of equal length,
	 * 	  until input becomes 1 character length;
	 * 2) Calculates Bits for right and left parts separatelly
	 * 3) Multiply left part by 10, N times. N == count of decimal digits of right part
	 * 4) return sum of left and right parts
	 *  
	 * @param val
	 * @return
	 */
	private Bit splitAndCalc(String val) {
		int length = val.length();

		if (length == 1)
			return forChar(val.toCharArray()[0]);
		else {
			int pivot = length / 2;

			String left = val.substring(0, pivot);
			String right = val.substring(pivot, length);

			Bit b = splitAndCalc(left);
			b = b.multi10(length - pivot);
			return add(b, splitAndCalc(right), false);
		}
	}
	
	/** Simple test */
	public static void main(String[] args) {
		BigInteger _1 = new BigInteger("123456789");
		System.out.println(_1);
	}
}