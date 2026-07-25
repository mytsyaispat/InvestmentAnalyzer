package org.example.model;

import java.time.LocalDate;

public class BondInfo {

    private String ticker;
    private String figi;
    private String isin;
    private String name;

    private String currency;

    private double nominal;
    private double cleanPrice;
    private double dirtyPrice;
    private double accruedCoupon;
    private double ytm;

    private int couponsPerYear;

    private LocalDate maturityDate;

    private String countryOfRisk;
    private String sector;
    private String riskLevel;


    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public double getCleanPrice() {
        return cleanPrice;
    }

    public void setCleanPrice(double cleanPrice) {
        this.cleanPrice = cleanPrice;
    }

    public double getDirtyPrice() {
        return dirtyPrice;
    }

    public void setDirtyPrice(double dirtyPrice) {
        this.dirtyPrice = dirtyPrice;
    }

    public double getAccruedCoupon() {
        return accruedCoupon;
    }

    public void setAccruedCoupon(double accruedCoupon) {
        this.accruedCoupon = accruedCoupon;
    }

    public int getCouponsPerYear() {
        return couponsPerYear;
    }

    public void setCouponsPerYear(int couponsPerYear) {
        this.couponsPerYear = couponsPerYear;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getCountryOfRisk() {
        return countryOfRisk;
    }

    public void setCountryOfRisk(String countryOfRisk) {
        this.countryOfRisk = countryOfRisk;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public double getYtm() {
        return ytm;
    }

    public void setYtm(double ytm) {
        this.ytm = ytm;
    }
}
