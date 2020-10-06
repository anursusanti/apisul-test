package entities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class Report implements IElevadorService {

	private List<Elevator> list = new ArrayList<>();

	public void carregarJson() {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader("input.json"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Elevator[] elevadores;

		String json = "";
		while (sc.hasNext()) {
			json += sc.next();
		}

		Gson gson = new Gson();

		elevadores = gson.fromJson(json, Elevator[].class);
		
		for (Elevator e : elevadores) {
			list.add(e);
		}
	}


	@Override
	public List<Integer> andarMenosUtilizado() {
		List<Integer> andaresMenosUtilizado = new ArrayList<>();

		int menosUsado = 0;
		int[] andarMenosUsado = new int[16];
		for (Elevator e : list) {
			for (int i = 0; i < andarMenosUsado.length; i++) {
				if (e.andar == i) {
					andarMenosUsado[i] += 1;
				}
			}
		}

		for (int i = 0; i < andarMenosUsado.length; i++) {
			for(int j = i + 1; j < andarMenosUsado.length; j++) {
				if (andarMenosUsado[i] <= andarMenosUsado[j] && andarMenosUsado[i] <= andarMenosUsado[menosUsado]) {
					menosUsado = i;		
				} else if (andarMenosUsado[i] >= andarMenosUsado[j] && andarMenosUsado[j] <= andarMenosUsado[menosUsado]) {
                    menosUsado = j;  
                }   
			}
			andaresMenosUtilizado.add(menosUsado);  
		}
		
		List<Integer> andarMenosUtilizado = new ArrayList<>();

		for (Integer i : andaresMenosUtilizado) {
			if (!andarMenosUtilizado.contains(i)) {
				andarMenosUtilizado.add(i);
			}
		}
		
		Collections.sort(andarMenosUtilizado);
		
		return andarMenosUtilizado;
		
	}

	@Override
	public List<Character> elevadorMaisFrequentado() {
		List<Character> elevadorMaisFrequentado = new ArrayList<>();
		int somaA = 0, somaB = 0, somaC = 0, somaD = 0, somaE = 0;

		for (Elevator e : list) {
			if (e.elevador == 'A') {
				somaA += 1;
			}
			if (e.elevador == 'B') {
				somaB += 1;
			}
			if (e.elevador == 'C') {
				somaC += 1;
			}
			if (e.elevador == 'D') {
				somaD += 1;
			}
			if (e.elevador == 'E') {
				somaE += 1;
			}
		}

		
		if (somaA >= somaB && somaA >= somaC && somaA >= somaD && somaA >= somaE ) {
			elevadorMaisFrequentado.add('A');
		}
		if (somaB >= somaA && somaB >= somaC && somaB >= somaD && somaB >= somaE ) {
			elevadorMaisFrequentado.add('B');
		}
		if (somaC >= somaA && somaC >= somaB && somaC >= somaD && somaC >= somaE ) {
			elevadorMaisFrequentado.add('C');
		}
		if (somaD >= somaA && somaD >= somaB && somaD >= somaC && somaD >= somaE ) {
			elevadorMaisFrequentado.add('D');
		}
		if (somaE >= somaA && somaE >= somaB && somaE >= somaC && somaE >= somaD ) {
			elevadorMaisFrequentado.add('E');
		}
		
		return elevadorMaisFrequentado;
	}

	@Override
	public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
		List<Character> periodoMaiorFluxo = new ArrayList<>();
		List<Character> elevadorMaiorFluxo = new ArrayList<>();
		int somaM = 0, somaV = 0, somaN = 0;
		int somaA = 0, somaB = 0, somaC = 0, somaD = 0, somaE = 0;

		for (Elevator e : list) {
			if (e.turno == 'M') {
				somaM += 1;
			}
			if (e.turno == 'V') {
				somaV += 1;
			}
			if (e.turno == 'N') {
				somaN += 1;
			}
		}

		
		if (somaM >= somaV && somaM >= somaN) {
			periodoMaiorFluxo.add('M');
			for (Elevator e : list) {
				if (e.turno == 'M') {
					elevadorMaiorFluxo.add(e.elevador);
				}
			}
		}
		if (somaV >= somaM && somaV >= somaN) {
			periodoMaiorFluxo.add('V');
			for (Elevator e : list) {
				if (e.turno == 'M') {
					elevadorMaiorFluxo.add(e.elevador);
				}
			}
		}
		if (somaN >= somaM && somaN >= somaV) {
			periodoMaiorFluxo.add('N');
			for (Elevator e : list) {
				if (e.turno == 'M') {
					elevadorMaiorFluxo.add(e.elevador);
				}
			}
		}

		
		for (Character e : elevadorMaiorFluxo) {
			if (e == 'A') {
				somaA += 1;
			}
			if (e == 'B') {
				somaB += 1;
			}
			if (e == 'C') {
				somaC += 1;
			}
			if (e == 'D') {
				somaD += 1;
			}
			if (e == 'E') {
				somaE += 1;
			}
		}

		
		if (somaA >= somaB && somaA >= somaC && somaA >= somaD && somaA >= somaE ) {
			periodoMaiorFluxo.add('A');
		}
		if (somaB >= somaA && somaB >= somaC && somaB >= somaD && somaB >= somaE ) {
			periodoMaiorFluxo.add('B');
		}
		if (somaC >= somaA && somaC >= somaB && somaC >= somaD && somaC >= somaE ) {
			periodoMaiorFluxo.add('C');
		}
		if (somaD >= somaA && somaD >= somaB && somaD >= somaC && somaD >= somaE ) {
			periodoMaiorFluxo.add('D');
		}
		if (somaE >= somaA && somaE >= somaB && somaE >= somaC && somaE >= somaD ) {
			periodoMaiorFluxo.add('E');
		}
		return periodoMaiorFluxo;
	}
	

	@Override
	public List<Character> elevadorMenosFrequentado() {
		List<Character> elevadorMenosFrequentado = new ArrayList<>();
		int somaA = 0, somaB = 0, somaC = 0, somaD = 0, somaE = 0;

		
		for (Elevator e : list) {
			if (e.elevador == 'A') {
				somaA += 1;
			}
			if (e.elevador == 'B') {
				somaB += 1;
			}
			if (e.elevador == 'C') {
				somaC += 1;
			}
			if (e.elevador == 'D') {
				somaD += 1;
			}
			if (e.elevador == 'E') {
				somaE += 1;
			}
		}

		
		if (somaA <= somaB && somaA <= somaC && somaA <= somaD && somaA <= somaE ) {
			elevadorMenosFrequentado.add('A');
		}
		if (somaB <= somaA && somaB <= somaC && somaB <= somaD && somaB <= somaE ) {
			elevadorMenosFrequentado.add('B');
		}
		if (somaC <= somaA && somaC <= somaB && somaC <= somaD && somaC <= somaE ) {
			elevadorMenosFrequentado.add('C');
		}
		if (somaD <= somaA && somaD <= somaB && somaD <= somaC && somaD <= somaE ) {
			elevadorMenosFrequentado.add('D');
		}
		if (somaE <= somaA && somaE <= somaB && somaE <= somaC && somaE <= somaD ) {
			elevadorMenosFrequentado.add('E');
		}
		return elevadorMenosFrequentado;
	}

	@Override
	public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
		List<Character> periodoMenorFluxo = new ArrayList<>();
		List<Character> elevadorMenorFluxo = new ArrayList<>();
		int somaM = 0, somaV = 0, somaN = 0;
		int somaA = 0, somaB = 0, somaC = 0, somaD = 0, somaE = 0;

		
		for (Elevator e : list) {
			if (e.turno == 'M') {
				somaM += 1;
			}
			if (e.turno == 'V') {
				somaV += 1;
			}
			if (e.turno == 'N') {
				somaN += 1;
			}
		}

		
		if (somaM <= somaV && somaM <= somaN) {
			periodoMenorFluxo.add('M');
			for (Elevator e : list) {
				if (e.turno == 'M') {
					elevadorMenorFluxo.add(e.elevador);
				}
			}
		}
		if (somaV <= somaM && somaV <= somaN) {
			periodoMenorFluxo.add('V');
			for (Elevator e : list) {
				if (e.turno == 'M') {
					elevadorMenorFluxo.add(e.elevador);
				}
			}
		}
		if (somaN <= somaM && somaN <= somaV) {
			periodoMenorFluxo.add('N');
			for (Elevator e : list) {
				if (e.turno == 'M') {
					elevadorMenorFluxo.add(e.elevador);
				}
			}
		}

		
		for (Character e : elevadorMenorFluxo) {
			if (e == 'A') {
				somaA += 1;
			}
			if (e == 'B') {
				somaB += 1;
			}
			if (e == 'C') {
				somaC += 1;
			}
			if (e == 'D') {
				somaD += 1;
			}
			if (e == 'E') {
				somaE += 1;
			}
		}

		
		if (somaA <= somaB && somaA <= somaC && somaA <= somaD && somaA <= somaE ) {
			periodoMenorFluxo.add('A');
		}
		if (somaB <= somaA && somaB <= somaC && somaB <= somaD && somaB <= somaE ) {
			periodoMenorFluxo.add('B');
		}
		if (somaC <= somaA && somaC <= somaB && somaC <= somaD && somaC <= somaE ) {
			periodoMenorFluxo.add('C');
		}
		if (somaD <= somaA && somaD <= somaB && somaD <= somaC && somaD <= somaE ) {
			periodoMenorFluxo.add('D');
		}
		if (somaE <= somaA && somaE <= somaB && somaE <= somaC && somaE <= somaD ) {
			periodoMenorFluxo.add('E');
		}
		return periodoMenorFluxo;
	}

	@Override
	public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
		List<Character> periodoMaiorUtilizacaoConjuntoElevadores = new ArrayList<>();
		int somaM = 0, somaV = 0, somaN = 0;

		
		for (Elevator e : list) {
			if (e.turno == 'M') {
				somaM += 1;
			}
			if (e.turno == 'V') {
				somaV += 1;
			}
			if (e.turno == 'N') {
				somaN += 1;
			}
		}

		
		if (somaM >= somaV && somaM >= somaN) {
			periodoMaiorUtilizacaoConjuntoElevadores.add('M');
			for (Elevator e : list) {
				if (e.turno == 'M') {
					periodoMaiorUtilizacaoConjuntoElevadores.add(e.elevador);
				}
			}
		}
		if (somaV >= somaM && somaV >= somaN) {
			periodoMaiorUtilizacaoConjuntoElevadores.add('V');
			for (Elevator e : list) {
				if (e.turno == 'M') {
					periodoMaiorUtilizacaoConjuntoElevadores.add(e.elevador);
				}
			}
		}
		if (somaN >= somaM && somaN >= somaV) {
			periodoMaiorUtilizacaoConjuntoElevadores.add('N');
			for (Elevator e : list) {
				if (e.turno == 'M') {
					periodoMaiorUtilizacaoConjuntoElevadores.add(e.elevador);
				}
			}
		}
		
		return periodoMaiorUtilizacaoConjuntoElevadores;
	}

	
	public float usoTotalElevadores() {
		float total = 0;
		for (Elevator e : list) {
			if (e.elevador == 'A') {
				total += 1;
			}
			if (e.elevador == 'B') {
				total += 1;
			}
			if (e.elevador == 'C') {
				total += 1;
			}
			if (e.elevador == 'D') {
				total += 1;
			}
			if (e.elevador == 'E') {
				total += 1;
			}
		}
		return total;
	}
	
	public float percentualDeUsoElevadorA() {
		int somaA = 0;
		float percentualElevadorA;
		for (Elevator e : list) {
			if (e.elevador == 'A') {
				somaA += 1;
			}
		}
		
		percentualElevadorA = 100 * somaA / usoTotalElevadores();
						
		return percentualElevadorA;
	}

	@Override
	public float percentualDeUsoElevadorB() {
		int somaB = 0;
		float percentualElevadorB;
		for (Elevator e : list) {
			if (e.elevador == 'B') {
				somaB += 1;
			}
		}
		
		percentualElevadorB = 100 * somaB / usoTotalElevadores();
						
		return percentualElevadorB;
	}

	@Override
	public float percentualDeUsoElevadorC() {
		int somaC = 0;
		float percentualElevadorC;
		for (Elevator e : list) {
			if (e.elevador == 'C') {
				somaC += 1;
			}
		}
		
		percentualElevadorC = 100 * somaC / usoTotalElevadores();
					
		return percentualElevadorC;
	}

	@Override
	public float percentualDeUsoElevadorD() {
		int somaD = 0;
		float percentualElevadorD;
		for (Elevator e : list) {
			if (e.elevador == 'D') {
				somaD += 1;
			}
		}
		
		percentualElevadorD = 100 * somaD / usoTotalElevadores();
						
		return percentualElevadorD;
	}

	@Override
	public float percentualDeUsoElevadorE() {
		int somaE = 0;
		float percentualElevadorE;
		for (Elevator e : list) {
			if (e.elevador == 'E') {
				somaE += 1;
			}
		}
		
		percentualElevadorE = 100 * somaE / usoTotalElevadores();
						
		return percentualElevadorE;
	}
	
}