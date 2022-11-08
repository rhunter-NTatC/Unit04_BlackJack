package tests_DO_NOT_EDIT;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;

public class InOutMimic {

	private String outputStream = "";
	private final PrintStream systemOut;
	private final InputStream systemIn;
	private ByteArrayInputStream testIn;
	
	
	public InOutMimic() {
		String outputStream = "";
		systemOut = System.out;
		systemIn = System.in;
	}
	
	
	//HANDLING INPUT STREAM
	
	// this simulates the data as if it came from the system.in
	public void provideInput(String data) {
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}
	
	
	
	
	
	//HANDLING OUTPUT STREAM
	
	//returns output stream
	public String getOutputStream() {
		return outputStream;
	}
	
	//set's output stream to empty string
	public void resetOutputStream() {
		outputStream = "";
	}
	
	
	/*
	 * Diverts all calls to println(), print() or printf() to printCalled()
	 */
	public void overridePrintStatements() {
		System.setOut(new PrintStream(System.out) {
			
			//override all println()s
			public void println() {
				printCalled("\n");
			}
			public void println(boolean b) {
				printCalled(String.valueOf(b) + "\n");
			}
			public void println(char c) {
				printCalled(String.valueOf(c) + "\n");
			}
			public void println(char[] s) {
				printCalled(String.valueOf(s) + "\n");
			}
			public void println(double d) {
				printCalled(String.valueOf(d) + "\n");
			}
			public void println(float f) {
				printCalled(String.valueOf(f) + "\n");
			}
			public void println(int i) {
				printCalled(String.valueOf(i) + "\n");
			}
			public void println(long l) {
				printCalled(String.valueOf(l) + "\n");
			}
			public void println(Object obj) {
				printCalled(String.valueOf(obj) + "\n");
			}
			public void println(String str) {
				printCalled(str + "\n");
			}
			
			
			//override printf()
			public void printf(String str) {
				printCalled(str);
			}
			
			
			//override all print()s
			public void print(boolean b) {
				printCalled(String.valueOf(b));
			}
			public void print(char c) {
				printCalled(String.valueOf(c));
			}
			public void print(char[] s) {
				printCalled(String.valueOf(s));
			}
			public void print(double d) {
				printCalled(String.valueOf(d));
			}
			public void print(float f) {
				printCalled(String.valueOf(f));
			}
			public void print(int i) {
				printCalled(String.valueOf(i));
			}
			public void print(long l) {
				printCalled(String.valueOf(l));
			}
			public void print(Object obj) {
				printCalled(String.valueOf(obj));
			}
			public void print(String str) {
				printCalled(str);
			}
			
			
		});

	}
	
	
	/*
	 * Handles all print calls
	 */
	public void printCalled(String str) {
		outputStream += str;
	}
	
	
	public void resetSystem() {
		System.setOut(systemOut);
		System.setIn(systemIn);
	}
	
	
	
	
	
	
}
