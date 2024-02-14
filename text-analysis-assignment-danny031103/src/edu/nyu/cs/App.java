package edu.nyu.cs;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * A program to analyze the use of verbal tics in any transcribed text.
 * Complete the functions to perform the tasks indicated in the comments.
 * Refer to the README.md file for additional requirements and helpful hints.
 */
public class App {
 
  // use this "global"-ish Scanner variable when getting keyboard input from the user within any function; this avoids common problems using several different Scanners within different functions
  public static Scanner scn = new Scanner(System.in);

  /**
   * The main function is automatically called first in a Java program.
   * This function contains the main logic of the program that makes use of all the other functions to solve the problem.
   * This main function MUST make use of the other functions to perform the tasks those functions are designed for, i.e.:
   * - you must use the getFilepathFromUser() to get the file path to the text file that the user wants to analyze
   * - you must use the getContentsOfFile() function whenever you need to get the contents of the text file
   * - you must use the getTicsFromUser() function whenever you need to get the set of tics the user wants to analyze in the text
   * - you must use the countOccurrences() function whenever you want to count the number of occurrences of a given tic within the text
   * - you must use the calculatePercentage() function whenever you want to calculate the percentage of all tics in the text that a given tic consumes
   * - you must use the calculateTicDensity() function to calculate the proportion of all words in the text that are tic words
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {

    String filepathhh=getFilepathFromUser();
    String contents=getContentsOfFile(filepathhh);
    String[] searchtics=getTicsFromUser();
    int [] totalCount = new int[searchtics.length];
    int countt=0;
    for (int i = 0; i < searchtics.length; i++) {
        totalCount[i] = countOccurrences(searchtics[i], contents);
        countt += totalCount[i];
    }
    System.out.println("...............................Analyzing text.................................");
    System.out.println("Total number of tics: "+countt);
    System.out.println("Density of tics: "+calculateTicDensity(searchtics,contents));
    System.out.println("...............................Tic breakdown..................................");
    for (int i=0;i<searchtics.length; i++){
      String ticfordisplay=searchtics[i];
      int percentagetodisplay=calculatePercentage (totalCount[i], countt);
      String percenttt=percentagetodisplay+"% of all tics";
      int countfordisplay=totalCount[i];
      String displayoccurences=countfordisplay+" occurrences";
      String formatted = String.format("%-10s / %-20s       / %-30s", ticfordisplay, displayoccurences, percenttt);
      System.out.println(formatted);
    }
    scn.close();
  }

  /**
   * getFilepathFromUser method
   * Asks the user to enter the path to the text file they want to analyze.
   * Hint:
   *  - use the "global"-ish Scanner variable scn to get the response from the user, rather than creating a new Scanner variable within this function.
   *  - do not close the "global"-ish Scanner so that you can use it in other functions
   * @return The file path that the user enters, e.g. "data/trump_speech_010621.txt"
   */
  public static String getFilepathFromUser() {
    Scanner scn= new Scanner(System.in);
    System.out.println("What is the path to the text file they want to analyze?");
    String filepath = scn.nextLine();
    return filepath;
  }

  /**
   * getContentsOfFile method
   * Opens the specified file and returns the text therein.
   * If the file can't be opened, print out the message, "Oh no... can't find the file!"
   * @param filename The path to a text file containing a speech transcript with verbal tics in it.
   * @return The full text in the file as a String.
   */
  public static String getContentsOfFile(String filepath) {

    // the code in this function is given to you as a gift... don't change it.

    String fullText = "";
    // opening up a file may fail if the file is not there, so use try/catch to protect against such errors
    try {
      // try to open the file and extract its contents
      Scanner scn = new Scanner(new File(filepath));
      System.out.println(scn);
      while (scn.hasNextLine()) {
        String line = scn.nextLine();
        fullText += line + "\n"; // nextLine() removes line breaks, so add them back in
      }
      scn.close(); // be nice and close the Scanner
    }
    catch (FileNotFoundException e) {
      // in case we fail to open the file, output a friendly message.
      System.out.println("Oh no... can't find the file!");
    }
    return fullText; // return the full text
  }
  
 /**
   * getTicsFromUser method
   * Asks the user to enter a comma-separated list of tics, e.g. "uh,like, um, you know,so", and returns an array containing those tics, e.g. { "uh", "like", "um", "you know", "so" }.
   * Hint:
   *  - use the "global"-ish Scanner variable scn to get the response from the user, rather than creating a new Scanner variable within this function.
   *  - do not close the "global"-ish Scanner so that you can use it in other functions
   * @return A String array containing each of the tics to analyze, with any leading or trailing whitespace removed from each tic.
   */

public static String[] getTicsFromUser() {
   Scanner scn = new Scanner(System.in);
   System.out.println("What words would you like to search for?");
   String ticstoanalyze = scn.nextLine();
   String[] tics = ticstoanalyze.split(",");
   for (int s=0;s<tics.length;s++){
    tics[s]=tics[s].trim();
   }
   return tics;
}

 /**
   * countOccurrences method
   * Counts how many times a given string (the needle) occurs within another string (the haystack), ignoring case.
   * @param needle The String to search for.
   * @param haystack The String within which to search.
   * @return THe number of occurrences of the "needle" String within the "haystack" String, ignoring case.
   */

    // write the countOccurrences function according to the instructions
    public static int countOccurrences (String needle, String haystack) {
      int finalcount=0;
      String []content = haystack.split("[\\s\\t\\n.;,:?!-+]");
      for (int o=0;o<content.length;o++){
        content[o]=content[o].trim();
       }
      int count=0;
      for (int i=0; i<content.length; i++){
        if (needle.equalsIgnoreCase(content[i])) {
          count+=1;
        }
      }
      int counttttt=0;
      for (int t=0;t<content.length-1;t++){
        String testword="";
        testword+=content[t];
        testword+=" ";
        testword+=content[t+1];
        if (testword.equalsIgnoreCase(needle)) {
          counttttt+=1;
        }
      }
      finalcount=(count+counttttt);
      return finalcount;
    }

  /**
   * calculatePercentage method
   * Calculates the equivalent percentage from the proportion of one number to another number.
   * @param num1 The number to be converted to a percentage.  i.e. the numerator in the ratio of num1 to num2.
   * @param num2 The overall number out of which the num1 number is taken.  i.e. the denominator in the ratio of num1 to num2.
   * @return The percentage that rum1 represents out of the total of num2, rounded to the nearest integer.
   */
  public static int calculatePercentage (int num1, int num2) {
    double num1d= num1;
    double num2d= num2;
    double percentage= (num1d/num2d);
    double percentage2=percentage*100;
    int displaypercent= (int) Math.round(percentage2);
    return displaypercent;
  }

  /**
   * calculateTicDensity method
   * Calculates the "density" of tics in the text.  In other words, the proportion of tic words to the total number of words in a text.
   * Hint:
   *  - assume that words in the text are separated from one another by any of the following characters: space ( ), line break (\n), tab (\t), period (.), comma (,), question mark (?), or exclamation mark (!)
   *  - all Strings have a .split() method which can split by any of a collection of characters given as an argument;  This function returns an array of the remaining text that was separated by any of those characters
   *  - e.g. "foo-bar;baz.bum".split("[-;.]+") will result in an array with { "foo", "bar", "baz", and "bum" } as the values.
   * @param tics An array of tic words to analyze.
   * @param fullText The full text.
   * @return The proportion of the number of tic words present in the text to the total number of words in the text, as a double.
   */

  public static double calculateTicDensity(String[] tics, String fullText) {
      String [] splitcontent=fullText.split(" ");
      int count=0;
      int contentlength=splitcontent.length;
      for (String tic:tics) {
          count+=countOccurrences(tic, fullText);
      }
      double TicDensity=(double) count/contentlength;
      DecimalFormat df=new DecimalFormat("#.#");
      double roundedTicDensity=Double.parseDouble(df.format(TicDensity));
      return roundedTicDensity;
  }

} // end of class