package java_puzzlers;

import java.math.BigDecimal;

public class expressive {
 
	public static void test_1_isOdd() {
		System.out.println("\n\ntest_1_isOdd(int i)");
		System.out.println("\t  i  i%2==1  i%2!=0  (i&1)==1");
		for (int i = -10; i <= 10; i++)
			System.out.println("\t" + String.format("%3d", i)
					+ String.format("%8s", (i%2==1))
					+ String.format("%8s", (i%2!=0))
					+ String.format("%8s", ((i&1)==1)));
	}
 /*test_1_isOdd(int i)
	  i  i%2==1  i%2!=0  (i&1)==1
	-10   false   false   false
	 -9   false    true    true
	 -8   false   false   false
	 -7   false    true    true
	 -6   false   false   false
	 -5   false    true    true
	 -4   false   false   false
	 -3   false    true    true
	 -2   false   false   false
	 -1   false    true    true
	  0   false   false   false
	  1    true    true    true
	  2   false   false   false
	  3    true    true    true
	  4   false   false   false
	  5    true    true    true
	  6   false   false   false
	  7    true    true    true
	  8   false   false   false
	  9    true    true    true
	 10   false   false   false
*/

	
	
	public static void test_2_Change_the_currency() {
		System.out.println("\n\ntest_2_Change_the_currency(2美元花掉1.1美元)");
//		System.out.println("\t" + 2.00 - 1.10);//The operator - is undefined for the argument type(s) String, double
		System.out.println("\t" + (2.00 - 1.10));
		System.out.println('\t' + 2.00 - 1.10);
		System.out.println("\t" + String.format("%.2f", 2.00 - 1.10));		
		System.out.println("\t" + 1.10);
		
		System.out.println("\t" + new BigDecimal(1.10));
		System.out.println("\t" + new BigDecimal("1.10"));		
		System.out.println("\t" + new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
		
		System.out.println("\t" + (200-110)+" cents");
	}
/*test_2_Change_the_currency(2美元花掉1.1美元)
	0.8999999999999999
9.9
	0.90
	1.1
	1.100000000000000088817841970012523233890533447265625
	1.10
	0.90
	90 cents
*/

	
	
	public static void test_3_LongDivision(){
		System.out.println("\n\ntest_3_LongDivision");
		long MICROS_PER_DAY=24*60*60*1000*1000;
		long MILLIS_PER_DAY=24*60*60*1000;
		System.out.println("\t" + MICROS_PER_DAY/MILLIS_PER_DAY);

		System.out.println("\t" + MILLIS_PER_DAY);
		
		System.out.println("\t" + MICROS_PER_DAY);
		System.out.println("\t" + 24*60*60*1000*1000);
		
		MICROS_PER_DAY=24L*60*60*1000*1000;
		System.out.println("\t" + MICROS_PER_DAY);
		System.out.println("\t" + 24L*60*60*1000*1000);		
	}
/*test_3_LongDivision
	5
	86400000
	500654080
	500654080
	86400000000
	86400000000
*/
	
	

	public static void test_4_Elementary(){
		System.out.println("\n\ntest_4_Elementary");
		System.out.println(12345+5432l);
		System.out.println(12345+54321);
		System.out.println(12345+5432L);
	}
/*test_4_Elementary
17777
66666
17777
*/
	
	
	
	public static void test_5_Hex(){
		System.out.println("\n\ntest_5_Hex");
		System.out.println(0x100000000L+0xcafebabe);
		System.out.println(0x100000000L+0xcafebabeL);
		
		System.out.println(0xcafebabe);
		System.out.println(0xcafebabeL);
	}
/*
test_5_Hex
3405691582
7700658878
-889275714
3405691582
*/
	
	
	
	public static void test_6_Multicast(){
		System.out.println("\n\ntest_6_Multicast");
		System.out.println((int)(char)(byte)-1);
		System.out.println((char)(byte)-1);
		System.out.println(String.format("%d",((char)(byte)-1)&0xFFFFFF));
	}
/*
test_6_Multicast
65535
?
65535
 */
	
	
	public static void test_7_Swap(){
		System.out.println("\n\ntest_7_Swap");
		int x=1984,y=2001;
		x^=y^=x^=y;
		System.out.println("\tx="+x+"; y="+y);
		
		x=1984;y=2001; 
		x^=(y^=(x^=y));
		System.out.println("\tx="+x+"; y="+y);

		x=1984;y=2001;
		x=x^(y^=(x^=y));
		System.out.println("\tx="+x+"; y="+y);
		
		x=1984;y=2001;
		x=(y^=(x^=y))^x;
		System.out.println("\tx="+x+"; y="+y);
		
		x=1984;y=2001;
		x^=y;	y^=x;	x^=y;
		System.out.println("\tx="+x+"; y="+y);
	}
/*test_7_Swap
	x=0; y=1984
	x=0; y=1984
	x=0; y=1984
	x=2001; y=1984
	x=2001; y=1984
*/
	
	
	public static void test_8_DosEquis(){
		System.out.println("\n\ntest_8_DosEquis");
		char x='0';
		int i=0;
		System.out.println(true?x:0);
		System.out.println(true?x:i);
		System.out.println(false?i:x);
		
		x='X';
		System.out.println(true?x:0);
		System.out.println(true?x:i);
		System.out.println(false?i:x);
	}
/*test_8_DosEquis
0
48
48
X
88
88
*/
	

	public static void test_9(){
		System.out.println("\n\ntest_9");		
		short x1; int i1;

		x1=0; i1=123456; x1+=i1;
		System.out.println(x1);
		
//		x1=0; i1=123456; x1=x1+i1;//Type mismatch: cannot convert from int to short
		x1=0; i1=123456; x1=(short) (x1+i1);
		System.out.println(x1);
		
		x1=0; i1=123456; i1+=x1;
		System.out.println(i1);
	}
/*
 test_9
-7616
-7616
123456
*/

	public static void test_10(){
		System.out.println("\n\ntest_10");
		Object x2;String i2;

		x2=" Buy "; i2=" a apple ";	x2+=i2;
		System.out.println(x2);
		
		x2=" Buy "; i2=" a apple ";	x2=x2+i2;
		System.out.println(x2);		

		x2=" Buy "; i2=" a apple ";	i2+=x2;
		System.out.println(i2);
		
		x2=" Buy "; i2=" a apple ";	i2=i2+x2;
		System.out.println(i2);
		
	}

/*
test_10
 Buy  a apple 
 Buy  a apple 
 a apple  Buy 
 a apple  Buy 
*/
	
	
	public static void main(String[] args) {
		test_1_isOdd();
		test_2_Change_the_currency();
		test_3_LongDivision();
		test_4_Elementary();
		test_5_Hex();
		test_6_Multicast();
		test_7_Swap();
		test_8_DosEquis();
		test_9();
		test_10();
	}

}
