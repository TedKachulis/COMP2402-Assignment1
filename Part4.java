package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class Part4 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		//Declare new stack for the Stack of s
		Stack<String> s = new Stack<String>();
		
		//Start line number count at 0
		int lineNum = 0;
		
		//For each line that is not null..
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			
			s.push(line);
			
			for (int i = (49*lineNum); i < 49*(lineNum+1); i++){
				s.push(r.readLine());
			}
			//Print nothing for a blank line..
			while(!s.empty()){
				if (s.peek() == null){
					w.println("");
					s.pop();
				}
				else{
					w.println(s.pop());
				}
			}
		}
	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);				
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}