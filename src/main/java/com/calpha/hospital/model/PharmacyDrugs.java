package com.calpha.hospital.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import lombok.Builder;

import  java.util.Date;

/**
 *
 * @author CAlpha
 */
@Builder
@Entity
@Table(name="pharmacyDrugs")
public class PharmacyDrugs implements Serializable {
   private static final long serialVersionUID = 1L;
    
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="drugId")  
 private Long  drugId;
 
@Column(name="name")
private String drugName;
  
@Column(name="manufacturer")
private String manufacturer;
   
@Column(name="batchNo")
private String batchNo;
 
@Column(name="drugForm")
private String drugForm;

@Column(name="purchaseDate")
@Temporal(javax.persistence.TemporalType.DATE)
private Date purchasedDate;

@Column(name="mfd")
@Temporal(javax.persistence.TemporalType.DATE)
private Date manufacturedDate;

@Column(name="expiryDate") 
 @Temporal(javax.persistence.TemporalType.DATE)
private Date expiryDate;

@Column(name="saltBase")
private String saltBase;

@Column(name="price")
private double price; 

@Column(name="stockLevel")
private String stockLevel;
 
@Column(name="reorderLevel")
private String reOrderLevel;

/**
 * @return the drugID
 */
public Long getDrugId() {
	return drugId;
}

/**
 * @param drugID the drugID to set
 */
public void setDrugId(Long drugId) {
	this.drugId = drugId;
}

/**
 * @return the drugName
 */
public String getDrugName() {
	return drugName;
}

/**
 * @param drugName the drugName to set
 */
public void setDrugName(String drugName) {
	this.drugName = drugName;
}

/**
 * @return the manufacturer
 */
public String getManufacturer() {
	return manufacturer;
}

/**
 * @param manufacturer the manufacturer to set
 */
public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}

/**
 * @return the batchNo
 */
public String getBatchNo() {
	return batchNo;
}

/**
 * @param batchNo the batchNo to set
 */
public void setBatchNo(String batchNo) {
	this.batchNo = batchNo;
}

/**
 * @return the drugForm
 */
public String getDrugForm() {
	return drugForm;
}

/**
 * @param drugForm the drugForm to set
 */
public void setDrugForm(String drugForm) {
	this.drugForm = drugForm;
}

/**
 * @return the purchasedDate
 */
public Date getPurchasedDate() {
	return purchasedDate;
}

/**
 * @param purchasedDate the purchasedDate to set
 */
public void setPurchasedDate(Date purchasedDate) {
	this.purchasedDate = purchasedDate;
}

/**
 * @return the manufacturedDate
 */
public Date getManufacturedDate() {
	return manufacturedDate;
}

/**
 * @param manufacturedDate the manufacturedDate to set
 */
public void setManufacturedDate(Date manufacturedDate) {
	this.manufacturedDate = manufacturedDate;
}

/**
 * @return the expiredDate
 */
public Date getExpiryDate() {
	return expiryDate;
}

/**
 * @param expiredDate the expiredDate to set
 */
public void setExpiredDate(Date expiryDate) {
	this.expiryDate = expiryDate;
}

/**
 * @return the saltBase
 */
public String getSaltBase() {
	return saltBase;
}

/**
 * @param saltBase the saltBase to set
 */
public void setSaltBase(String saltBase) {
	this.saltBase = saltBase;
}

/**
 * @return the price
 */
public double getPrice() {
	return price;
}

/**
 * @param price the price to set
 */
public void setPrice(double price) {
	this.price = price;
}

/**
 * @return the stockLevel
 */
public String getStockLevel() {
	return stockLevel;
}

/**
 * @param stockLevel the stockLevel to set
 */
public void setStockLevel(String stockLevel) {
	this.stockLevel = stockLevel;
}

/**
 * @return the reOrderLevel
 */
public String getReOrderLevel() {
	return reOrderLevel;
}

/**
 * @param reOrderLevel the reOrderLevel to set
 */
public void setReOrderLevel(String reOrderLevel) {
	this.reOrderLevel = reOrderLevel;
}}
