package tests_DO_NOT_EDIT;

import org.junit.jupiter.api.*;
import labs.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class Test_Lab01 {

	public static InOutMimic inOut;
	
	@BeforeAll
	static void beforeAll() {
		inOut = new InOutMimic();
	}
	
	
	@Test
	@DisplayName("Test Problem #1")
	void test1() {
		String problemNumber = "Problem #1";
		
		int i = 0;
		String expectedOutput = "";
		int input = 0;
		int numCount = 0;
		char[] output;
		int count = 0;
		
		try {
			
			
			for (; i < 50; i ++) {
				numCount = 0;
				input = (int) (Math.random() * 10);
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(String.valueOf(input));
				Lab01.problem1();
				
				output = inOut.getOutputStream().toCharArray();
				
				for (int j = 0; j < output.length; j++) {	
					if (output[j] >= 48 && output[j] <= 57) { numCount++; }
				}
				
				if (numCount >= 14) { numCount -= 4;}
				else {numCount -= 3;}
				
				if (numCount == 1) {
					expectedOutput = "It took 1 try to get your number.";
				}
				else {
					expectedOutput = "It took " + numCount + " tries to get your number.";
				}
				
				assertTrue(inOut.getOutputStream().contains(expectedOutput));
				
			}
			
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all tests\n\n\n\n");

		}
		catch (AssertionError e) {
			inOut.resetSystem();
			
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + 50
					+ "\n   Input tested: " +  input
					+ "\n   Expected output: " + expectedOutput 
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
	}

	
	@Test
	@DisplayName("Test Problem #2")
	void test2() {
		String problemNumber = "Problem #2";
		String[][] tests = {{"" + Lab01.pin + "\n-5555\n-6666", "Access Granted", "Account Locked", 
									"Should have gained access on first try."},
							{"-5555\n" + Lab01.pin + "\n-7777", "Access Granted", "Account Locked", 
									"Should have gained access on second try."},
							{"-5555\n-6666\n" + Lab01.pin, "Access Granted", "Account Locked", 
									"Should have gained access on thrid try."},
							{"-5555\n-6666\n-7777", "Account Locked", "Access Granted", 
									"All three tries wrong.  Account should be blocked."}
							};
		int i = 0;
		
		boolean hasCorrect = false;
		boolean doesNotHaveIncorrect = false;
		
		try {
			for (; i < tests.length; i++) {
				hasCorrect = false;
				doesNotHaveIncorrect = false;
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab01.problem2();
				hasCorrect = inOut.getOutputStream().contains(tests[i][1]);
				doesNotHaveIncorrect = !inOut.getOutputStream().contains(tests[i][2]);
				assertTrue(hasCorrect);
				assertTrue(doesNotHaveIncorrect);
			}
		
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all " + tests.length + " tests\n\n\n\n");
			
		}
		catch (AssertionError e){
			inOut.resetSystem();
			
			String hint = "";
			
			if (!hasCorrect) {
				hint += "\n      You didn't tell user: \"" + tests[i][1] + "\"";
			}
			if (!hasCorrect) {
				hint += "\n      You should not have told the user: \"" + tests[i][2] + "\"";
			}
			
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   Input(s) tested: " +  tests[i][0]
					+ "\n   Expected output: " + tests[i][1] 
					+ "\n   Hints:" + tests[i][3] + hint
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
		
	}
	
	@Test
	@DisplayName("Test problem #3")
	void test3() {
		
		String randInput = "";
		int randTotal = 0;
		int randNum = 0;
		int numInputs = (int) (Math.random() * 100) + 100;
		for (int i = 0; i < 18; i++) {
			randNum = (int) (Math.random() * 250) - 100;
			randInput += "" + randNum + "\n";
			randTotal += randNum;
		}
		randInput += "0\n"; 
		
		
		String problemNumber = "Problem #3";
		String[][] tests = {{"3\n12\n-2\n0", "13"},
							{"5\n16\n57\n24\n-14\n0", "88"},
							{"5\n-4\n95\n-15\n-18\n48\n654\n-125\n15\n3\n-4\n-8\n-159\n24\n16\n-4\n-8\n5\n0", "520"},
							{randInput, String.valueOf(randTotal)},
							};
		int i = 0;
		String expectedOutput = "";
		
		try {
			for (; i < tests.length; i++) {
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab01.problem3();
				expectedOutput = "The sum of your input is " + tests[i][1] + ".";
				assertTrue(inOut.getOutputStream().contains(expectedOutput));
						
			}
			
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all " + tests.length + " tests\n\n\n\n");
			
		}
		catch (AssertionError e){
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   Input tested: " +  tests[i][0]
					+ "\n   Expected output: " + expectedOutput
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
		
	}
	
	

	
}
