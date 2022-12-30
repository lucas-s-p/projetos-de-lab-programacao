package documin;

import java.text.Collator;
import java.util.Arrays;

/**
 * cria um termo. 
 * 
 * @author lucas
 */
public class Termo implements Elementavel {
	/**
	 * Conteúdo a ser abordado no termo.
	 */
	private String valor;
	/**
	 * Nivel de prioridade do elemento.
	 */
	private int prioridade;
	/**
	 * Indica em que ponto é separado cada termo.
	 */
	private String separador;
	/**
	 * Forma de ordenação do valor.
	 */
	private String ordem;
	
	/**
	 * Constrói um termo que fez contrato com a interface Elementavel.
	 * 
	 * @param valor Nivel de prioridade do elemento.
	 * @param prioridade Indica em que ponto é separado cada termo.
	 * @param separador Forma de ordenação do valor.
	 * @param ordem Forma de ordenação do valor.
	 */
	public Termo(String valor, int prioridade, String separador, String ordem) {
		this.valor = valor;
		this.prioridade = prioridade;
		this.separador = separador;
		this.ordem = ordem;
	}

	/**
	 *  Representação detalhada do termo. 
	 * 
	 * @return String com a representação visual.
	 */
	@Override
	public String getRepresentacaoCompleta() {
		String[] nomes = separador();
		if (this.ordem.equals("ALFABÉTICA")) {
			return ordemAlfabeticaCompleta(nomes);
		} else if(this.ordem.equals("TAMANHO")) {
			return ordemTamanhoCompleta(nomes);
		}
		return ordemNenhumaCompleta(nomes);
	}

	/**
	 * Representação resumida do termo. 
	 * 
	 * @return String com a representação visual.
	 */
	@Override
	public String getRepresentacaoResumida() {
		String[] nomes = separador();
		if (this.ordem.equals("ALFABÉTICA")) {
			return ordemAlfabeticaResumida(nomes);
		} else if(this.ordem.equals("TAMANHO")) {
			return ordemTamanhoResumida(nomes);
		}
		return ordemNenhumaResumida(nomes);
	}
	
	/**
	 * separa os termos. 
	 * 
	 * @return Array com os termos separados.
	 */
	private String[] separador() {
		return this.valor.split(separador);
	}
	
	/**
	 * Comparador que ordena os termos. 
	 * 
	 * @param a String de um termo.
	 * @param b String de um termo.
	 * @return Comparação entre as duas string e se é maior, menor ou igual.
	 */
	private int compare(String a, String b) {
		if (a.length() > b.length()) {
			return 1;
		} 
		if (a.length() < b.length()) {
			return -1;
		}
		return 0;
	}
	
	/**
	 * Termos sem ordenação. 
	 * 
	 * @param nomes Nomes dos termos.
	 * @return Representação detalhada e sem ordem dos termos.
	 */
	private String ordemNenhumaResumida(String[] nomes) {
		String ordenado = "";
		for (int i = 0; i < nomes.length; i++) {
			if (i == nomes.length - 1) {
					ordenado += nomes[i].trim();
				} else {
					ordenado += nomes[i].trim() + " " + this.separador + " ";
				}
		}
		return ordenado;
	}
	
	/**
	 * Termos sem ordenação. 
	 * 
	 * @param nomes Nomes dos termos.
	 * @return Representação resumida e sem ordem dos termos.
	 */
	private String ordemNenhumaCompleta(String[] nomes) {
		String ordenado = "";
		ordenado += "Total termos: " + nomes.length + "\n- ";
		for (int i = 0; i < nomes.length; i++) {
			if (i == nomes.length - 1) {
					ordenado += nomes[i].trim();
				} else {
					ordenado += nomes[i].trim() + ", ";
				}
		}
		return ordenado;
	}
	
	/**
	 * Termos ordenados por tamanho. 
	 * 
	 * @param nomes Nomes dos termos.
	 * @return Representação resumida e ordenado por tamanho.
	 */
	private String ordemTamanhoResumida(String[] nomes) {
		String ordenado = "";
		for (int i = 0; i < nomes.length; i++) {
		for (int j = 0; j < nomes.length; j++) {
			if(compare(nomes[i], nomes[j]) == 1) {
				String aux = nomes[i];
				nomes[i] = nomes[j];
				nomes[j] = aux;
			}
		}
	}
		for(int i = 0; i < nomes.length; i++) {
			if (i == nomes.length -1) {
				ordenado += nomes[i].trim();
			} else {
				ordenado += nomes[i].trim() + " " + this.separador + " ";
			}
		}
		return ordenado;
	}
	
	/**
	 * Termos ordenados por tamanho. 
	 * 
	 * @param nomes Nomes dos termos.
	 * @return Representação detalhada e ordenado por tamanho.
	 */
	private String ordemTamanhoCompleta(String[] nomes) {
		String ordenado = "";
		ordenado += "Total termos: " + nomes.length + "\n- ";
		for (int i = 0; i < nomes.length; i++) {
		for (int j = 0; j < nomes.length; j++) {
			if(compare(nomes[i], nomes[j]) == 1) {
				String aux = nomes[i];
				nomes[i] = nomes[j];
				nomes[j] = aux;
			}
		}
	}
		for(int i = 0; i < nomes.length; i++) {
			if (i == nomes.length - 1) {
				ordenado += nomes[i].trim();
			} else {
				ordenado += nomes[i].trim() + ", ";
			}
		}
		return ordenado;
	}
	
	/**
	 * Termos ordenados por ordem alfabética. 
	 * 
	 * @param nomes Nomes dos termos.
	 * @return Representação resumida e ordenado por ordem alfabética.
	 */
	private String ordemAlfabeticaResumida(String[] nomes) {
		String ordenado = "";
		Arrays.sort(nomes, Collator.getInstance());
		for (int i = 0; i < nomes.length; i++) {
			if (i != nomes.length - 1) {
				ordenado += nomes[i].trim() + " " + this.separador + " ";
			} else {
				ordenado += nomes[i].trim();
			}
		}
		return ordenado;
	}
	
	/**
	 * Termos ordenados por ordem alfabética. 
	 * 
	 * @param nomes Nomes dos termos.
	 * @return Representação detalhada e ordenado por ordem alfabética.
	 */
	private String ordemAlfabeticaCompleta(String[] nomes) {
		String ordenado = "";
		ordenado += "Total termos: " + nomes.length + "\n- ";
		Arrays.sort(nomes, Collator.getInstance());
		for (int i = 0; i < nomes.length; i++) {
			if (i != nomes.length - 1) {
				ordenado += nomes[i].trim() + ", ";
			} else {
				ordenado += nomes[i].trim();
			}
		}
		return ordenado;
	}
	
	/**
	 * Pega a prioridade. 
	 * 
	 * @return Inteiro com a prioridade.
	 */
	@Override
	public int getPrioridade() {
		return this.prioridade;
	}
}
