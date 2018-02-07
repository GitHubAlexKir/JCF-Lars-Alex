package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {
    
   private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Heb je dan geen hoedje meer\n" +
                                                "Maak er een van bordpapier\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "En als het hoedje dan niet past\n" +
                                                "Zetten we het in de glazenkas\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";

   @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
    }

    /*
        Goal:

        Show amount of words, and amount of different words.
     */
    @FXML
    private void aantalAction(ActionEvent event)
    {
    /*
        Split words.
     */

     List<String> words = splitWords(taInput.getText());

     /*
        Remove duplicates.
      */

     HashSet<String> noDups = new HashSet<String>(words);

     /*
        Show amount of words, and different words.
      */

     taOutput.setText(taOutput.getText() + "Totaal aantal woorden: " + words.size() + "\n" + "Aantal verschillende woorden: : " + noDups.size());
    }

    /*
        Goal:

        Show all different words desc.
     */

    @FXML
    private void sorteerAction(ActionEvent event)
    {
    /*
        Split words.
     */

     List<String> words = splitWords(taInput.getText());

     /*
        Remove duplicates.
      */

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

     taOutput.setText(taOutput.getText() + stringBuilder.toString());
    }

    /*
        Goal:

        Count how many times every word is presented in the entire text.
     */

    @FXML
    private void frequentieAction(ActionEvent event)
    {
     /*
        Split words.
      */

     List<String> words = splitWords(taInput.getText());

     /*
        Create HashMap (with string and integer).
      */

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
     taOutput.setText(taOutput.getText() + stringBuilder.toString());
    }


    /*
        Goal:

        Count for every word how many times it's presented in every line.
     */

    @FXML
    private void concordatieAction(ActionEvent event)
    {
     /*
       Split words.
      */

     List<String> words = splitWords(taInput.getText());

     /*
       Remove the duplicates with hashset.
      */

     HashSet<String> noDups = new HashSet<>(words);

     /*
      Create spring builder.
      */
     StringBuilder stringBuilder = new StringBuilder();

     /*
      Split lines.
      */

     String[] lines = taInput.getText().toLowerCase().split("\\r?\\n");

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

     taOutput.setText(taOutput.getText() + stringBuilder.toString());
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
     taOutput.setText("Tijd splitsing woorden: " + tijd + "ms\n");
     return words;
    }
}
