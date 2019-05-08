package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.dizionariograph.db.WordDAO;

public class Model {
	
	private SimpleGraph<String,DefaultEdge> grafo;
	
	public void createGraph(int numeroLettere) {

		grafo = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
		WordDAO dao = new WordDAO();

		List<String> parole = dao.getAllWordsFixedLength(numeroLettere);
		Graphs.addAllVertices(grafo, parole);

		for (String p1 : grafo.vertexSet()) {
			for (String p2 : grafo.vertexSet()) {
				if (!p1.equals(p2)) {
					if (isSimilar(p1, p2)) {
						grafo.addEdge(p1, p2);
					}
				}
			}
		}

	}

	private boolean isSimilar(String p1, String p2) {

		if (p1.length() != p2.length())
			return false;

		int difference = 0;
		for (int i = 0; i < p1.length(); i++) {
			if (p1.charAt(i) != p2.charAt(i))
				difference++;

			if (difference > 1)
				return false;
		}

		if (difference == 1)
			return true;

		return false;
	}

	public List<String> displayNeighbours(String parolaInserita) {
		
		
		List<String> parole = new ArrayList<String>();
		parole.addAll(Graphs.neighborListOf(grafo, parolaInserita));
		
		return parole;
	}

	public int findMaxDegree() {
		System.err.println("findMaxDegree -- TODO");
		return -1;
	}

	public boolean isDigit(String numeroInserito) {
		
		return numeroInserito.matches("\\d+");
	}
}
