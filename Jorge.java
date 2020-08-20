package arrays;// Substitua pelo seu pacote

import javax.swing.JOptionPane;

// OBS.: Como isto é apenas para estudo, não estou validando, use corretamente.
public class Jorge {
	public static void main(String[] args) {
		// Obtendo as dimensões da planilha
		String numeroLinhas = JOptionPane.showInputDialog("Informe o número de LINHAS: ");
		String numeroColunas = JOptionPane.showInputDialog("Informe o número de COLUNAS: ");
		
		int[][] matriz = new int
				[Integer.parseInt(numeroLinhas)]
				[Integer.parseInt(numeroColunas)];// Definindo as dimensões na planilha
		
		String[] alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");// Para referenciar coluna
		
		String divisor = "_______";// Apenas para fins de estilização
		
		// FOR Para montar a planilha
		for (int linha = 0; linha < matriz.length; linha++) {
			for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
				// Obtendo valor
				String valor = JOptionPane.showInputDialog(
						"Qual valor deseja inserir na CÉLULA: " + (linha + 1) + alfabeto[coluna] + ": "
				);
				
				matriz[linha][coluna] = Integer.parseInt(valor);// Definindo célula com valor obtido
			}
		}
		
		// Renderizar no terminal a planilha
		renderizar(divisor, alfabeto, matriz);
		soma(divisor, alfabeto, matriz);// SIMILAR A FUNÇÃO SOMA DO EXCEL
	}
	
	public static void renderizar(String divisor, String[] alfabeto, int[][] matriz) {
		System.out.println();// Apenas para espaçar do topo
		
		// FOR para renderizar no geral planilha
		for (int linha = 0; linha < matriz.length; linha++) {
			int totalColunas = matriz[linha].length;// Utilizo para saber operações lógicas
			
			System.out.println(divisor.repeat((totalColunas * 2) + 2));// Apenas para estilizar
			
			// FOR para renderizar a célula com seus respectivos valores
			for (int coluna = 0; coluna < totalColunas; coluna++) {
				int valor = matriz[linha][coluna];// Valor da célula
			
				// IF para saber se cheguei ao fim da linha / ultima coluna, para gerar uma nova linha
				if (coluna + 1 == totalColunas) {
					System.out.println("| CÉLULA: " + (linha + 1) + alfabeto[coluna] + " = " + valor + " |");
				} else {
					System.out.print("| CÉLULA: " + (linha + 1) + alfabeto[coluna] + " = " + valor + " |");
				}
			}
			
			System.out.println(divisor.repeat((totalColunas * 2) + 2));// Apenas para estilizar		
		}
	}
	
	// SOMA as células da planilha
	public static void soma(String divisor, String[] alfabeto, int[][] matriz) {
		int soma = 0;// YES
		
		do {
			soma = JOptionPane.showConfirmDialog(null, "Deseja utilizar função SOMA para somar células?");
			
			if (soma == 0) {// YES
				String celula1 = JOptionPane.showInputDialog("Informe uma CÉLULA: ");
				String celula2 = JOptionPane.showInputDialog("Informe outra CÉLULA: ");
				String[] linhaColuna1 = celula1.split("");
				String[] linhaColuna2 = celula2.split("");
				
				int valor1 = matriz[Integer.parseInt(linhaColuna1[0]) - 1][Integer.valueOf(encontraColuna(alfabeto, linhaColuna1[1]))];
				int valor2 = matriz[Integer.parseInt(linhaColuna2[0]) - 1][Integer.valueOf(encontraColuna(alfabeto, linhaColuna2[1]))];
				
				JOptionPane.showMessageDialog(null, "SOMA " + celula1 + " + " + celula2 + " = " + (valor1 + valor2));
			}
		} while (soma == 0);// YES	
	}
	
	// Baseado na letra do alfabeto ele retorna a coluna correspondente.
	public static int encontraColuna(String[] alfabeto, String letra) 
    {
		for (int coluna = 0; coluna < alfabeto.length; coluna++) {
			if (alfabeto[coluna].equals(letra)) {
				return coluna;
			}
		}
		
		return -1;// Lança uma exceção de proposito
    }
}

