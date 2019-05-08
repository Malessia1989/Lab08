package it.polito.tdp.dizionariograph;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.dizionariograph.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCreaGrafo;

    @FXML
    private Button btnVicini;

    @FXML
    private Button btnGradoMax;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

	private Model model;

    @FXML
    void doCercaGradoMax(ActionEvent event) {

    }

    @FXML
    void doCercaVicini(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	String parolaAggiunta= txtParola.getText();
    	
    	if (parolaAggiunta != null && !parolaAggiunta.isEmpty()) {
    		model.displayNeighbours(parolaAggiunta);
    		if (parolaAggiunta != null) {

				txtResult.setText(parolaAggiunta.toString());
    		}
    	
    	}
    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	
    	String numeroLettere= txtNumero.getText();
    	
    	if(!numeroLettere.isEmpty()) {
    		if(model.isDigit(numeroLettere)) {
    			model.createGraph(Integer.parseInt(numeroLettere));
    			txtResult.setText("Grafo creato!");
    		}
    		
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtNumero.clear();
    	txtParola.clear();
    	txtResult.clear();
    }

    @FXML
    void initialize() {
        assert txtNumero != null : "fx:id=\"txtNumero\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnVicini != null : "fx:id=\"btnVicini\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnGradoMax != null : "fx:id=\"btnGradoMax\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		
		
	}
}
