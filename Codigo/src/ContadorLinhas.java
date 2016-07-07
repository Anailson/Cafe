import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContadorLinhas {
	
	private int totalLinhas;
	
	public ContadorLinhas() {
		totalLinhas = 0;
	}
	
	private void listarPastas(File raiz) {
		
		String[] arquivos = raiz.list();
		
		for (int i = 0; i < arquivos.length; i++) {
			
			File filho = new File(raiz, arquivos[i]);
			
			if (filho.isDirectory()) {
				listarPastas(filho);
			} else {
				contarLinhas(filho);
			}
		}
	}
	
	private void contarLinhas(File arquivo){
		
		int linhasArquivo = 0;
		
		try {
			
			BufferedReader buffer = new BufferedReader(new FileReader(arquivo));
			while(buffer.readLine() != null){
				linhasArquivo++;
				totalLinhas++;
			}
			buffer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(arquivo.getName() + ": " + linhasArquivo);
	}
	
	public void contar(File raiz){
		listarPastas(raiz);
		System.out.println("Total de linhas: " + totalLinhas);
	}
	
	public static void main(String[] args) {
		new ContadorLinhas().contar(new File("src"));
	}
}
