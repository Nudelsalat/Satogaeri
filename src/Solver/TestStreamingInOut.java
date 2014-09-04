package Solver;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

import java.io.*;
import java.util.*;
/**
 * Created by Cloud on 28.05.2014.
 */
public class TestStreamingInOut {

        public static void main(String args[]) throws IOException {

/*
            try {
                // Execute command
                String command = "cmd /c start cmd.exe";
                Process child = Runtime.getRuntime().exec(command);

                // Get output stream to write from it
                OutputStream out = child.getOutputStream();

                out.write("cd C:/ /r/n".getBytes());
                out.flush();
                out.write("dir /r/n".getBytes());
                out.close();
            } catch (IOException e) {
            }
*/

            /*
            String command = "cmd /c cvc4-1.3-win32-opt.exe (exit)";
            // String command = "cmd /c cvc4.exe --lang smt -m";
            // String command = "cmd /c dir ..\\CVC4";
            Process process = Runtime.getRuntime().exec(command);
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;

            System.out.printf("Output of running %s is:",
                    command);

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }



            // http://mrbool.com/run-external-windows-program-with-java/24415
            Process process = Runtime.getRuntime().exec("cmd /c start \"C:\\Users\\Cloud\\Studium\\SS 2014\\Bachelor thesis\\CVC4\\cvc4-1.3-win32-opt.exe\"");
            // Process process = new ProcessBuilder("C:\\Users\\Cloud\\Studium\\SS 2014\\Bachelor thesis\\CVC4\\cvc4-1.3-win32-opt.exe").start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;

            System.out.printf("Output of running %s is:", Arrays.toString(args));

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            */

            Scanner scan = new Scanner(System.in);

            String[] command = {"CMD", "/C", "cvc4-1.3-win32-opt.exe --lang smt -m"};
            ProcessBuilder probuilder = new ProcessBuilder( command );
            //You can set up your work directory
            probuilder.directory(new File("C:\\Users\\Cloud\\Studium\\SS 2014\\Bachelor thesis\\CVC4"));
            probuilder.redirectErrorStream(true);


            Process process = probuilder.start();
            OutputStream outs = process.getOutputStream();



            //Read out dir output
            InputStream ins = process.getInputStream();
            String line;

            final BufferedReader reader = new BufferedReader (new InputStreamReader(ins));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outs));

            Thread one = new Thread() {
                public void run() {
                    try {
                        String line = reader.readLine();
                        while(line != null){
                        System.out.println("before line-output");
                        System.out.println ("THREAD: " + line);
                            if(!line.contentEquals("sat")) {
                                String[] ints = parseResult(line);
                                System.out.println("int1: " + ints[0] + "\nint2: " + ints[1] + "\nint3: " + ints[2]);
                                if(ints[2].contentEquals("- 1")){
                                    System.out.println("leider nein, sucker11");
                                }
                            }
                            line = reader.readLine();
                        }
                    } catch(IOException e) {
                        System.out.println(e);
                    }
                }
            };

            one.start();

            writer.write("(set-logic QF_LIA)"+"\n");
            writer.write("(declare-fun f0-0 () Int)"+"\n");
            writer.write("(declare-fun c0-0 () Int)"+"\n");
            writer.write("(declare-fun f1-0 () Int)"+"\n");
            writer.write("(declare-fun c1-0 () Int)"+"\n");
            writer.write("(declare-fun f2-0 () Int)"+"\n");
            writer.write("(declare-fun c2-0 () Int)"+"\n");
            writer.write("(declare-fun f0-1 () Int)"+"\n");
            writer.write("(declare-fun c0-1 () Int)"+"\n");
            writer.write("(declare-fun f1-1 () Int)"+"\n");
            writer.write("(declare-fun c1-1 () Int)"+"\n");
            writer.write("(declare-fun f2-1 () Int)"+"\n");
            writer.write("(declare-fun c2-1 () Int)"+"\n");
            writer.write("(assert (or (and (> f0-0 0) (< f0-1 0)) (and (< f0-0 0) (> f0-1 0))))"+"\n");
            writer.write("(assert (or (and (> f1-0 0) (< f1-1 0)) (and (< f1-0 0) (> f1-1 0))))"+"\n");
            writer.write("(assert (or (and (> f2-0 0) (< f2-1 0)) (and (< f2-0 0) (> f2-1 0))))"+"\n");
            writer.write("(assert (and (= c0-0 1) (= c2-0 3) (= c0-1 2)))"+"\n");
            writer.write("(assert (or (= f0-0 c0-0)))"+"\n");
            writer.write("(assert (or (and (= c1-0 c2-0) (= f1-0 c2-0)) (and (= c2-1 c2-0) (= f2-1 c2-0))))"+"\n");
            writer.write("(assert (or (and (= c1-1 c0-1) (= c2-1 c0-1) (= f2-1 c0-1))))"+"\n");
            writer.write("(check-sat)"+"\n");
            writer.write("(get-value (f0-0))"+"\n");
            writer.write("(get-value (f1-0))"+"\n");
            writer.write("(get-value (f2-0))"+"\n");
            writer.write("(get-value (f0-1))"+"\n");
            writer.write("(get-value (f1-1))"+"\n");
            writer.write("(get-value (f2-1))"+"\n");
            writer.flush();
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

    static public String[] parseResult(String string){
        String pattern = "(\\(\\(f)(\\d+)(-)(\\d+)( *\\(*)(-* *\\d)(\\)+)";
        String pattern2 = ";";
        string = string.replaceAll(pattern, "$2;$4;$6");

        return string.split(pattern2);
    }
}
