package br.gov.serpro.agenda.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Compromisso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long id;

	@Column(unique = true)
	@NotNull
	private String nomeCompromisso;

	@Column
	@NotNull
	@Temporal(value = TemporalType.DATE)
	private Date dataVencimento;

	@Column
	@Temporal(value = TemporalType.DATE)
	private Date dataPagamento;

	@Column
	@NotNull
	private BigDecimal valorCompromisso;

	@Column
	private BigDecimal valorPago;

	public Compromisso() {
		super();
	}

 /*   public Compromisso(String nomeCompromisso, Date dataVencimento, Date dataPagamento, BigDecimal valorCompromisso,
	 BigDecimal valorPago) 
    {
	 this.setNomeCompromisso(nomeCompromisso);
	 this.setDataVencimento(dataVencimento);
	 this.setDataPagamento(dataPagamento);
	 this.setValorCompromisso(valorCompromisso);
	 this.setValorPago(valorPago);
	 }*/

	public boolean isAtrasado() {
		if (isPago()) {
			return this.dataPagamento.compareTo(this.dataVencimento) > 0;
		} else {
			return new Date().compareTo(this.dataVencimento) > 0;
		}
	}

	public boolean isPago() {
		return this.dataPagamento != null;
	}

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

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValorCompromisso() {
		return valorCompromisso;
	}

	public void setValorCompromisso(BigDecimal valorCompromisso) {
		this.valorCompromisso = valorCompromisso;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
}
