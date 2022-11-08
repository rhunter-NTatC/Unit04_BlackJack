package tests_DO_NOT_EDIT;

import org.junit.jupiter.api.*;
import labs.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

class Test_Lab02 {

	public static InOutMimic inOut;
	
	@BeforeAll
	static void beforeAll() {
		inOut = new InOutMimic();
	}

	
	@Test
	@DisplayName("Test problem #1")
	void test1() {
		String problemNumber = "Problem #1";
		String expectedOutput = "3 6 9 12 15 18 21";
		
		String output = "";
		try {
			inOut.resetOutputStream();
			inOut.overridePrintStatements();
			Lab02.problem01();
			assertTrue(inOut.getOutputStream().contains(expectedOutput));
			
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all tests\n\n\n\n");
			
		}
		catch (AssertionError e){
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + 1 + " of  1"
					+ "\n   Input tested: "
					+ "\n   Expected output: " + expectedOutput 
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
		
	}
	
	
	@Test
	@DisplayName("Test problem #2")
	void test2() {
		String problemNumber = "Problem #2";
		
		int randInput = (int) (Math.random() * 500) + 200;
		int randInput1 = randInput % 2 == 0 ? randInput : randInput - 1; 
		String randOutput = "" + randInput1;
		for (int i = randInput1 - 2; i >= -randInput1; i -= 2) {
			randOutput += " " + i;
		}
		
		
		
		String[][] tests = {{"6", "6 4 2 0 -2 -4 -6"},
				{"21", "20 18 16 14 12 10 8 6 4 2 0 -2 -4 -6 -8 -10 -12 -14 -16 -18 -20"},
				{"3", "2 0 -2"},
				{String.valueOf(randInput1), randOutput}
				};
		int i = 0;
		
		
		try {
			for (; i < tests.length; i++) {
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab02.problem02();
				
				assertTrue(inOut.getOutputStream().contains(tests[i][1]));
						
			}
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all " + tests.length + " tests\n\n\n\n");
			
		}
		catch (AssertionError e) {
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   Input tested: " +  tests[i][0]
					+ "\n   Expected output: " + tests[i][1]
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
	}
	
	
	@Test
	@DisplayName("Test problem #3")
	void test3() {
		String problemNumber = "Problem #3";
		
		int randInput = (int) (Math.random() * 500) + 300;
		String randOutput = "1";
		for (int i = 2; i <= randInput; i++) {
			if (randInput % i == 0) {
				randOutput += " " + i;
			}
		}
		
		
		
		String[][] tests = {{"18", "1 2 3 6 9 18"},
				{"21", "1 3 7 21"},
				{"60", "1 2 3 4 5 6 10 12 15 20 30 60"},
				{String.valueOf(randInput), randOutput}
				};
		int i = 0;
		
		
		try {
			for (; i < tests.length; i++) {
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab02.problem03();
				
				assertTrue(inOut.getOutputStream().contains(tests[i][1]));
						
			}
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all " + tests.length + " tests\n\n\n\n");
//			System.out.println(randInput + "\n" + randOutput);
		}
		catch (AssertionError e) {
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   Input tested: " +  tests[i][0]
					+ "\n   Expected output: " + tests[i][1]
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
		
		
	}
	
	
	@Test
	@DisplayName("Test problem #4")
	void test4() {
		String problemNumber = "Problem #4";
		
		String[][] tests = {{"11", "That number is prime"},
				{"18", "That number is not prime"},
				{"31", "That number is prime"},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				{"", ""},
				};
		
		
		for (int i = 3; i < 13; i++) {
			int randNum = (int) (Math.random() * 23) + 7;
			tests[i][0] = String.valueOf(randNum);
			boolean isPrime = true;
			
			for (int j = 2; j < randNum / 2 + 1; j++) {
				if (randNum % j == 0) {
					isPrime = false;
				}
			}
			tests[i][1] = isPrime ? "That number is prime" : "That number is not prime";
		}
		
//		for (String[] test : tests) {
//			System.out.println(Arrays.toString(test));
//		}
		
		int i = 0;
		
		
		try {
			for (; i < tests.length; i++) {
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab02.problem04();
				
				assertTrue(inOut.getOutputStream().contains(tests[i][1]));
						
			}
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all " + tests.length + " tests\n\n\n\n");
			
		}
		catch (AssertionError e) {
			inOut.resetSystem();
			
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   Input tested: " +  tests[i][0]
					+ "\n   Expected output: " + tests[i][1]
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
		
	}
	
	@Test
	@DisplayName("Test problem #5")
	void test5() {
		String problemNumber = "Problem #5";
		
		String[][] tests = {{"25", "2 3 5 7 11 13 17 19 23"},
				{"18", "2 3 5 7 11 13 17"},
				{"47", "2 3 5 7 11 13 17 19 23 29 31 37 41"},
				};
		
		
		
		int i = 0;
		
		
		try {
			for (; i < tests.length; i++) {
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab02.problem05();
				
				assertTrue(inOut.getOutputStream().contains(tests[i][1]));
						
			}
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all " + tests.length + " tests\n\n\n\n");
			
		}
		catch (AssertionError e) {
			inOut.resetSystem();
			
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   Input tested: " +  tests[i][0]
					+ "\n   Expected output: " + tests[i][1]
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
		
	}
	
}
