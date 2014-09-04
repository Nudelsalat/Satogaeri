package Solver;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Cloud on 28.05.2014.
 */
public class CVC4Streaming {

        public static void main(String args[]) throws IOException {
            Scanner scan = new Scanner(System.in);

            String[] command = {"CMD", "/C", "cvc4-1.3-win32-opt.exe --lang smt -m"};
            ProcessBuilder probuilder = new ProcessBuilder( command );
            //You can set up your work directory
            probuilder.directory(new File("C:\\Users\\Cloud\\Studium\\SS 2014\\Bachelor thesis\\CVC4"));
            probuilder.redirectErrorStream(true);


            Process process = probuilder.start();
            OutputStream outs = process.getOutputStream();

            InputStream ins = process.getInputStream();
            String line;

            BufferedReader reader = new BufferedReader (new InputStreamReader(ins));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outs));

            while (scan.hasNext()) {
                System.out.println("before writer");
                String input = scan.nextLine();
                if (input.trim().equals("(exit)")) {
                    // Putting 'exit' amongst the echo --EOF--s below doesn't work.
                    writer.write("(exit)\n");
                    writer.close();
                    reader.close();
                    scan.close();
                    break;
                } else {
                    writer.write(input +"\n");
                    System.out.println("<input> " + input);
                }
                writer.flush();
                System.out.println("after flush-writer");

                if (input.trim().equals("(check-sat)") || input.trim().equals("(get-value (f0-0))")){
                    line = reader.readLine();
                    System.out.println("before line-output");
                    System.out.println ("Stdout: " + line);
                }
            }



            //Wait to get exit value
            try {
                int exitValue = process.waitFor();
                System.out.println("\n\nExit Value is " + exitValue);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }
}
