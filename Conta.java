//Aluno: Martin Lange de Assis
//Curso: Ciência da Computação
//Universidade: FURB
package conta;

import java.time.LocalDate;

public class Conta {
	public String nome;
	public int numero;
	public String agencia;
	public double saldo;
	public LocalDate dataDeAbertura;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		} else {
			IllegalArgumentException exc = new IllegalArgumentException("Por favor, digite um nome.");
			throw exc;
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		if (agencia != null && !agencia.isBlank()) {
			this.agencia = agencia;
		}else {
			IllegalArgumentException exc = new IllegalArgumentException("Por favor, digite um nome de agência válido");
			throw exc;
		}
		
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		if (saldo >= 0) {
			this.saldo = saldo;
		}
	}

	public LocalDate getDataDeAbertura() {
		return dataDeAbertura;
	}

	public void setDataDeAbertura(LocalDate dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}

	public double sacar() {
		double valor = 0;
		if (this.getSaldo() >= valor) {
			this.setSaldo(this.getSaldo() - valor);
			return this.getSaldo();
		} else {
			return this.getSaldo();
		}

	}

	public void deposita(double valor) {
		this.setSaldo(this.getSaldo() + valor);
	}

	public double calculaRendimento() {
		return getSaldo() * 0.1;
	}

	public String recuperarDadosParaImpressao() {
		String dados = "\nNome: " + this.getNome();
		System.out.println("___CONTA___");
		System.out.println("Nome: " + this.getNome());
		System.out.println("Número: " + this.getNumero());
		System.out.println("Agência: " + this.getAgencia());
		System.out.println("Saldo: " + this.getSaldo());
		System.out.println("Rendimento: " + this.calculaRendimento());
		System.out.println("Data de Abertura: " + this.dataDeAbertura);
		return dados;
	}

}
