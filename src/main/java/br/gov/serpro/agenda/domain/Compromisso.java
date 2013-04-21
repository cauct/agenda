package br.gov.serpro.agenda.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Compromisso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long id;

	@Column
	private String nomeCompromisso;

//	@Column
//	private Date dataVencimento;
//
//	@Column
//	private Date dataPagamento;
//
//	@Column
//	private BigDecimal valorCompromisso;
//
//	@Column
//	private BigDecimal valorPago;

	public Compromisso() {
		super();
	}

//	public Compromisso(String nomeCompromisso, Date dataVencimento, Date dataPagamento, BigDecimal valorCompromisso,
//			BigDecimal valorPago) {
//		this.setNomeCompromisso(nomeCompromisso);
//		this.setdataVencimento(dataVencimento);
//		this.setDataPagamento(dataPagamento);
//		this.setValorCompromisso(valorCompromisso);
//		this.setValorPago(valorPago);
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompromisso() {
		return nomeCompromisso;
	}

	public void setNomeCompromisso(String nomeCompromisso) {
		this.nomeCompromisso = nomeCompromisso;
	}

//	public Date getdataVencimento() {
//		return dataVencimento;
//	}
//
//	public void setdataVencimento(Date dataVencimento) {
//		this.dataVencimento = dataVencimento;
//	}
//
//	public Date getDataPagamento() {
//		return dataPagamento;
//	}
//
//	public void setDataPagamento(Date dataPagamento) {
//		this.dataPagamento = dataPagamento;
//	}
//
//	public BigDecimal getValorCompromisso() {
//		return valorCompromisso;
//	}
//
//	public void setValorCompromisso(BigDecimal valorCompromisso) {
//		this.valorCompromisso = valorCompromisso;
//	}
//
//	public BigDecimal getValorPago() {
//		return valorPago;
//	}
//
//	public void setValorPago(BigDecimal valorPago) {
//		this.valorPago = valorPago;
//	}
//
//	public boolean isAtrasado() {
//		return false;
//		// fazer logica se o compromisso está ou foi pago em atraso
//
//	}

}
