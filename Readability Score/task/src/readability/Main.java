package readability;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    static double sum = 0.0;

    public static void main(String[] args) throws IOException {
        String pathToFile = args[0];

        String str = new String(Files.readAllBytes(Paths.get(pathToFile)));
        Scanner scan = new Scanner(str);

        String[] sentArr = str.split("[\\.!?]{1,3}");
        String[] wordsArr = str.split(" ");
        String[] charArr= str.replace(" ", "").split("");

        int sentences = sentArr.length;
        int words = wordsArr.length;
        int characters = charArr.length;
        int syllables = 0;
        int polysyllables = 0;

        for (int i = 0; i < wordsArr.length; i++) {
            String[] syl = wordsArr[i].split("[aeiouAEIOU]{1,3}");
            int newSyll = syl.length - 1;
            if (syl.length == 1 || syl.length == 0) {
                newSyll = 1;
            }
            syllables += newSyll;
            if (newSyll > 2) {
                polysyllables++;
            }
        }

        System.out.println("The text is:");
        System.out.println(str);
        System.out.println();
        System.out.printf("Words: %d\n", words);
        System.out.printf("Sentences: %d\n", sentences);
        System.out.printf("Characters: %d\n", characters);
        System.out.printf("Syllables: %d\n", syllables);
        System.out.printf("Polysyllables: %d\n", polysyllables);
        System.out.printf("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

        Main m = new Main();
        Scanner scan2 = new Scanner(System.in);
        String answer = scan2.next();
        System.out.println();

        switch (answer) {
            case "ARI":
                m.testARI(characters, words, sentences);
                break;
            case "FK":
                m.testFK(words, sentences, syllables);
                break;
            case "SMOG":
                m.testSMOG(polysyllables, sentences);
                break;
            case "CL":
                m.testCLI(characters, words, sentences);
                break;
            case "all":
                m.testARI(characters, words, sentences);
                m.testFK(words, sentences, syllables);
                m.testSMOG(polysyllables, sentences);
                m.testCLI(characters, words, sentences);
                System.out.println();
                double average = sum / 4.0;
                System.out.printf("This text should be understood in average by %.2f year olds.", average);
                break;
        }
    }

    public void testARI(int characters, int words, int sentences) {
        double scoreARI = 4.71 * ((double) characters / (double) words) +
                0.5 * ((double) words / (double) sentences) - 21.43;

        String levelARI = new String();

        int scoreARI2 = (int) scoreARI + 1;

        if (scoreARI2 < 2) {
            levelARI = "6";
        } else if (scoreARI2 == 2) {
            levelARI = "7";
        } else if (scoreARI2 == 3) {
            levelARI = "9";
        } else if (scoreARI2 == 4) {
            levelARI = "10";
        } else if (scoreARI2 == 5) {
            levelARI = "11";
        } else if (scoreARI2 == 6) {
            levelARI = "12";
        } else if (scoreARI2 == 7) {
            levelARI = "13";
        } else if (scoreARI2 == 8) {
            levelARI = "14";
        } else if (scoreARI2 == 9) {
            levelARI = "15";
        } else if (scoreARI2 == 10) {
            levelARI = "16";
        } else if (scoreARI2 == 11) {
            levelARI = "17";
        } else if (scoreARI2 == 12) {
            levelARI = "18";
        } else if (scoreARI2 == 13) {
            levelARI = "24";
        } else if (scoreARI2 >= 14) {
            levelARI = "24+";
        }

        System.out.printf("Automated Readability Index: %.2f (about %s year olds).\n", scoreARI, levelARI);
        sum += Double.parseDouble(levelARI);
    }

    public void testFK(int words, int sentences, int syllables) {
        double scoreFK = 0.39 * ((double) words / (double) sentences) +
                11.8 * ((double) syllables / (double) words) - 15.59;

        String levelFK = new String();

        if (scoreFK < 100.0 && scoreFK >= 90.0) {
            levelFK = "11";
        } else if (scoreFK < 90.0 && scoreFK >= 80.0) {
            levelFK = "12";
        } else if (scoreFK < 80.0 && scoreFK >= 70.0) {
            levelFK = "13";
        } else if (scoreFK < 70.0 && scoreFK >= 60.0) {
            levelFK = "14";
        } else if (scoreFK < 60.0 && scoreFK >= 50.0) {
            levelFK = "17";
        } else if (scoreFK < 50.0 && scoreFK >= 30.0) {
            levelFK = "17";
        } else if (scoreFK < 30.0 && scoreFK >= 10.0) {
            levelFK = "18";
        } else if (scoreFK < 10.0 && scoreFK >= 0.0) {
            levelFK = "19";
        }

        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s year olds).\n", scoreFK, levelFK);
        sum += Double.parseDouble(levelFK);
    }

    public void testSMOG(int polysyllables, int sentences) {
        double scoreSMOG = 1.043 * Math.sqrt((double) polysyllables * 30.0 / sentences) + 3.1291;
        int levelSMOG = (int) scoreSMOG + 6;

        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).\n", scoreSMOG, levelSMOG);
        sum += (double) levelSMOG;
    }

    public void testCLI(int characters, int words, int sentences) {
        double scoreCLI = (0.0588 * (double) characters / ((double) words / 100.0 )) -
                (0.296 * (double) sentences / ((double) words / 100.0)) -
                15.8;

        int levelCLI = (int) scoreCLI + 7;

        System.out.printf("Coleman–Liau index: %.2f (about %d year olds).\n", scoreCLI, levelCLI);
        sum += (double) levelCLI;
    }


}
