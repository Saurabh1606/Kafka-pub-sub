package com.nt.saurabh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="stock_quote_tab")
@Data
public class StockQuote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="stk_code_col")
	private String stockCode; 

	@Column(name="stk_cost_col")
	private Double shareValue;
	
	@Column(name="stk_dte_col")
	@Temporal(TemporalType.TIMESTAMP)
	private Date  serviceDate;
	
}
