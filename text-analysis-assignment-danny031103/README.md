# Text Analysis Exercise

A little exercise to parse text from a text file in Java.

## Background

You work evenings as an unpaid intern in a historical semantics research institute. Your boss, an absent-minded computer-illiterate professor of linguistics (a vestige from a bygone era), would like you to build a program to analyze the frequency of [verbal tics](http://www.newser.com/story/131668/speech-habits-of-psychopaths-analyzed-in-study.html) in historical recorded speech.

The institute has hired a [Hyderabad, India](https://en.wikipedia.org/wiki/Hyderabad,_India)-based firm to convert the recorded [speech into text](https://en.wikipedia.org/wiki/Speech_recognition). Now you need to be able to take these text transcripts and analyze them for verbal tics.

## The program

The program must be able to open any text file specified by the user, and analyze the frequency of verbal tics in the text. Since there are many different kinds of verbal tics (such as "`like`", "`uh`", "`um`", etc) the program must ask the user what tics to look for. A user can enter multiple tics, separated by commas - any spaces entered by the user before or after each tic must be ignored. You can assume all tics are single words.

The program should output:

- the total number of tics found in the text
- the density of tics (proportion of all words in the text that are tics)
- the frequency of each of the verbal tics
- the percentage that each tic represents out of all the total number of tics

## Example input and output

This example shows suggested input/output of such a program. User responses are shown with "`>`" in front of them for your convenience, although this character should not be output by the program or entered by the user. Data analysis numbers are placeholder only and are not meant to be '_real_'.

```
What file would you like to open?
> data/trump_speech_010621.txt
What words would you like to search for?
> uh,like, um,so

...............................Analyzing text.................................

Total number of tics: 66
Density of tics: 0.2

...............................Tic breakdown..................................

uh        / 0 occurrences      / 0% of all tics
like      / 33 occurrences     / 12% of all tics
um        / 63 occurrences     / 23% of all tics
so        / 138 occurrences    / 50% of all tics
```

## Requirements

- The program must be able to analyze any text file, but an example file must be included in the submission.
- The user must be able to enter as many tics as they would like, separated by commas, with or without spaces.
- Those tics can be assumed to be single words, such as "uh" and "like", and not multi-word tics such as "uh huh" and "you know".
- The list of tics entered by the user must be stored in an array, not an ArrayList or any other array-like data structure.
- You must use separate methods for each component of the analysis. At the least, this includes:
  1. asking the user which text file to open.
  1. opening the file and importing its contents.
  1. soliciting tic words or phrases from the user and separating them into an array.
  1. counting the occurrences of each tic.
  1. calculating the percent of all tics that each tic consumes.
  1. calculating tic density.
- The output must be formatted so that all output lines up nicely as in the example
  - the tic word column consumes 10 spaces
  - the number of occurrences column consumes 20 spaces
  - the percentage column consumes as much space as necessary
  - columns are separated by the `/` characters - note that the text within any column should always be separated one space away from this separator - see example output
- The search for tics must be case insensitive.
- round all occurrences and percentages to the nearest integer.
- limit the density to two decimal places.

## Helpful hints

You _may_ find it useful to split strings by more than one separator.

```java
String someText = "this;text,has-various?separators+in!it";
String[] values = someText.split("[.,?!-]+"); // an array of the parts of the String separated by any of the indicated separators
```

To make a string consume a fixed amount of space, use the `String.format()` function, e.g.:

```java
// format a string
String old = "hello";
String new = String.format("%10s", old); // returns "hello     "
```

```java
// format an integer
int old = 6;
String new = String.format("%10d", old); // returns "6         "
```

```java
// format a floating point number
double old = 6.0;
String new = String.format("%10f", old); // returns "6.0       "
```

```java
// limit the number of decimal places in a floating point number
double old = 3.14159265; // pi!
String new = String.format("%.2f", old); // returns "3.14";
```

## Folder structure

This project has several important directories:

- `data` - contains any text files analyzed by this program.
- `src` - contains the Java source code for the project (i.e. `.java` files)
- `test` - contains code that will help us determine whether the code you have written works correctly. Do not touch this directory!
- `bin` - contains the compiled code (i.e. `.class` files)
- `lib` - contains any dependencies (other libraries of code that the project depends upon to work)

If your project has no dependencies and has not been compiled, you may not see the `lib` or `bin` directories.

## How to test your work

Automated tests that can help determine whether you have done the work correctly have been included within the `test` directory. Use them as follows. A [video tutorial](https://www.youtube.com/watch?v=Af6Ka0Bmflo) shows how to do this and overcome any problems:

- Click the Run and Debug icon in the Visual Studio Code activity bar, then click the play button to run your code without using the automated tests. Do this prior to running the tests to make sure your program seems to behave correctly yourself.
- Open the relevant test file, located within the `test` directory.
- Click the Test icon (a beaker) in the Visual Studio Code activity bar and click the play button to run those tests. Tests that pass will be marked with a green checkmark, while those that fail will be marked with a red "X".
- Each test that fails will show a message with some indication of what went wrong - these messages may help you pinpoint the source of the error.

If you have trouble running the tests from within Visual Studio Code, you can do them from within a Terminal window, assuming the project directory is the current working directory (change `TestClassName` to the relevant name fo the test class.)

```bash
java -cp "bin:lib/*" org.junit.runner.JUnitCore edu.nyu.cs.TestClassName
```

Windows users should replace the `:` in `"bin:lib/*"` with a semi-colon, `;`, i.e. `"bin;lib/*"`

## How to submit this assignment

Once you have completed the changes to th assignment, you are ready to submit it. Do this from within Visual Studio Code.

1. Click on the `Source Control` icon in the left activity bar in Visual Studio Code.
1. In the Source Control side bar, you will see a field named `Message` - type in a unique message about what you have done, e.g. "_Finished assignment!_" or whatever you want to write as a short note to yourself.
1. Hover over the words `Source Control`. You will see a `...` icon appear - click it to see a menu. In that menu, click `Commit`->`Commit`. This logs the changes you've made to the Git project - remember Git is used to keep track of changes.
1. Go to the same menu and click `Push` to submit your assignment - this uploads your updated files to the copy of your respository on GitHub.

![Push changes to GitHub](./images/how_to_push_changes_to_github_from_vscode.png)

That's it... you're done.

## Double-check your submission

Prove to yourself that you have correctly submitted by viewing your repository on the GitHub website - you should see your completed README.md file there.

## Resubmit as many times as you want

You can re-submit as many times as you want before the deadline. Just make changes to the files on your own computer and repeat the process outlined above to upload them to GitHub.
