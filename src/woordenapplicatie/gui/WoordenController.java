package woordenapplicatie.gui;

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
    private WordClass wordClass = new WordClass();

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
        taOutput.setText(
            wordClass.aantalAction(taInput.getText())
        );
    }

    /*
        Goal:

        Show all different words desc.
     */

    @FXML
    private void sorteerAction(ActionEvent event)
    {
        taOutput.setText(
            wordClass.sortAction(taInput.getText())
        );
    }

    /*
        Goal:

        Count how many times every word is presented in the entire text.
     */

    @FXML
    private void frequentieAction(ActionEvent event)
    {
        taOutput.setText(
            wordClass.frequentieAction(taInput.getText())
        );
    }


    /*
        Goal:

        Count for every word how many times it's presented in every line.
     */

    @FXML
    private void concordatieAction(ActionEvent event)
    {
        taOutput.setText(
            wordClass.concordatieAction(taInput.getText())
        );
    }
}
