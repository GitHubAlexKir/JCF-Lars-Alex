package woordenapplicatie.gui;

import javafx.fxml.FXML;

import java.util.*;

public class WordClass {

    private String time;

    public String aantalAction(String taInput)
    {

        /*
            Split words.
        */

        List<String> words = splitWords(taInput);

        /*
            Remove duplicates.
        */

        long start = System.currentTimeMillis();
        HashSet<String> noDups = new HashSet<String>(words);

        /*
            Show amount of words, and different words.
        */

        long stop = System.currentTimeMillis();
        long tijd = stop - start;

        return time + "tijd berekening: " + tijd + "ms\n" + "Totaal aantal woorden: " + words.size() + "\n" + "Aantal verschillende woorden: : " + noDups.size();
    }

    public String sortAction(String taInput)
    {
        /*
            Split words.
        */

        List<String> words = splitWords(taInput);

        /*
            Remove duplicates.
        */

        long start = System.currentTimeMillis();
        HashSet<String> noDups = new HashSet<String>(words);

        /*
            Reverse the order.
        */

        TreeSet<String> myTreeSet = new TreeSet(Collections.reverseOrder());
        myTreeSet.addAll(noDups);

        /*
            Create string builder.
        */

        StringBuilder stringBuilder = new StringBuilder();

        /*
            Loop over the treeset and append it to the stringbuilder.
        */

        for (String test:myTreeSet) {
            stringBuilder.append(test + "\n");
        }

        long stop = System.currentTimeMillis();
        long tijd = stop - start;

        return time + "tijd berekening: " + tijd + "ms\n" + stringBuilder.toString();

    }

    public String frequentieAction(String taInput)
    {
        /*
            Split words.
        */

        List<String> words = splitWords(taInput);

        /*
            Create HashMap (with string and integer).
        */

        long start = System.currentTimeMillis();
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

        /*
            Loop over all words.
        */

        for(String word: words) {

            /*
                Check if word already exists in wordCount.
            */

            Integer count = wordCount.get(word);

            /*
                Put the word in wordCount, with the amount of times it's presented.
            */

            wordCount.put(word, (count==null) ? 1 : count+1);
        }

        /*
            Create the string. And sort it.
        */

        StringBuilder stringBuilder = new StringBuilder();
        wordCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(x -> stringBuilder.append(x + "\n"));

        long stop = System.currentTimeMillis();
        long tijd = stop - start;

        return time +  "tijd berekening: " + tijd + "ms\n" + stringBuilder.toString();
    }


    /*
        Goal:

        Count for every word how many times it's presented in every line.
     */

    @FXML
    public String concordatieAction(String taInput)
    {
        /*
                Split words.
        */

        List<String> words = splitWords(taInput);

        /*
            Remove the duplicates with hashset.
        */

        long start = System.currentTimeMillis();
        HashSet<String> noDups = new HashSet<>(words);

        /*
            Create spring builder.
        */

        StringBuilder stringBuilder = new StringBuilder();

        /*
            Split lines.
        */

        String[] lines = taInput.toLowerCase().split("\\r?\\n");

        /*
            Make list for keeping track of the counts.
        */

        List<Integer> lineCount = new ArrayList<>();
        int count = 1;

        /*
            Loop over the no dups.
        */

        for (String word: noDups) {

            /*
                Loop over the lines
            */

            for (String l: lines) {

                /*
                    Check if line contains word.
                */

                if(l.contains(word)) {

                    /*
                        If line contains word add the count to the list.
                    */

                    lineCount.add(count);
                }

                count++;
            }

            /*
                Create the string and append the lineCount.
            */

            stringBuilder.append(word + " " + lineCount.toString() + "\n");
            count = 1;
            lineCount.clear();
        }

        /*
            Show the string on the screen.
        */

        long stop = System.currentTimeMillis();
        long tijd = stop - start;

        return time + "Tijd berekening: " + tijd + "ms\n" + stringBuilder.toString();
    }

    private List<String> splitWords(String text)
    {

        /*
            Split incoming text by words with a regex expression.
        */

        long start = System.currentTimeMillis();

        List<String> words = new ArrayList<>(
                Arrays.asList(
                        text.toLowerCase().split("[^a-zA-Z]+")
                ));

        long stop = System.currentTimeMillis();
        long tijd = stop - start;
        time = "Tijd splitsing woorden: " + tijd + "ms\n";

        return words;
    }
}
