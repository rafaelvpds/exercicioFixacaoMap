package apllication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter file full path: ");

		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			Map<String, Integer> lista = new HashMap<>();

			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");

				String name = fields[0];
				int numberVotes = Integer.parseInt(fields[1]);

				if (lista.containsKey(name)) {
					int sumVotes = lista.get(name);
					// estou pegando os valores de cada chave
					// System.out.println(sumVotes);
					lista.put(name, numberVotes + sumVotes);
				} else {
					lista.put(name, numberVotes);
				}

				line = br.readLine();

			}

			System.out.println("Lista");

			for (String key : lista.keySet()) {
				System.out.println(key + ": " + lista.get(key));
			}

			// D:\Curso\Curso Java\cap16GenericSetMap\Arquivos\listaCandidatos.txt

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
