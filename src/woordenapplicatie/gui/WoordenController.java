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
    
    @FXML
    private void aantalAction(ActionEvent event) {
     List<String> words = splitWords(taInput.getText()); //arraylist
     HashSet<String> noDups = new HashSet<String>(words);
     taOutput.setText(taOutput.getText() + "Totaal aantal woorden: " + words.size() + "\n" + "Aantal verschillende woorden: : " + noDups.size());
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
     List<String> words = splitWords(taInput.getText()); //arraylist
     HashSet<String> noDups = new HashSet<String>(words);
     TreeSet<String> myTreeSet = new TreeSet(Collections.reverseOrder());
     myTreeSet.addAll(noDups);
     StringBuilder stringBuilder = new StringBuilder();
     for (String test:myTreeSet
          ) {
      stringBuilder.append(test + "\n");
     }
     taOutput.setText(taOutput.getText() + stringBuilder.toString());
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
     List<String> words = splitWords(taInput.getText()); //arraylist
     Map<String, Integer> wordCount = new HashMap<String, Integer>();

     for(String word: words) {
      Integer count = wordCount.get(word);
      wordCount.put(word, (count==null) ? 1 : count+1);
     }
     StringBuilder stringBuilder = new StringBuilder();
     wordCount.entrySet().stream()
             .sorted(Map.Entry.comparingByValue())
             .forEach(x -> stringBuilder.append(x + "\n"));
     taOutput.setText(taOutput.getText() + stringBuilder.toString());
    }


    @FXML
    private void concordatieAction(ActionEvent event) {
         throw new UnsupportedOperationException("Not supported yet."); 
    }

    private List<String> splitWords(String text)
    {
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
