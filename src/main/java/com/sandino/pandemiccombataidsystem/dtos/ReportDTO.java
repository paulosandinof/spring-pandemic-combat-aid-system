package com.sandino.pandemiccombataidsystem.dtos;

import java.util.List;

import com.sandino.pandemiccombataidsystem.entities.Exchange;
import com.sandino.pandemiccombataidsystem.entities.Hospital;

public class ReportDTO {

    private double hospitalsOvercrowdedPercentage;
    private double hospitalsUndercrowdedPercentage;
    private Hospital longerOvercrowdedHospital;
    private Hospital longerUndercrowdedHospital;
    private List<AverageResourceTypeDTO> averageResourceTypes;
    private List<Exchange> exchangeHistory;

    public ReportDTO() {
    }

    public ReportDTO(double hospitalsOvercrowdedPercentage, double hospitalsUndercrowdedPercentage,
            Hospital longerOvercrowdedHospital, Hospital longerUndercrowdedHospital,
            List<AverageResourceTypeDTO> averageResourceTypes, List<Exchange> exchangeHistory) {
        this.hospitalsOvercrowdedPercentage = hospitalsOvercrowdedPercentage;
        this.hospitalsUndercrowdedPercentage = hospitalsUndercrowdedPercentage;
        this.longerOvercrowdedHospital = longerOvercrowdedHospital;
        this.longerUndercrowdedHospital = longerUndercrowdedHospital;
        this.averageResourceTypes = averageResourceTypes;
        this.exchangeHistory = exchangeHistory;
    }

    public double getHospitalsOvercrowdedPercentage() {
        return hospitalsOvercrowdedPercentage;
    }

    public void setHospitalsOvercrowdedPercentage(double hospitalsOvercrowdedPercentage) {
        this.hospitalsOvercrowdedPercentage = hospitalsOvercrowdedPercentage;
    }

    public double getHospitalsUndercrowdedPercentage() {
        return hospitalsUndercrowdedPercentage;
    }

    public void setHospitalsUndercrowdedPercentage(double hospitalsUndercrowdedPercentage) {
        this.hospitalsUndercrowdedPercentage = hospitalsUndercrowdedPercentage;
    }

    public Hospital getLongerOvercrowdedHospital() {
        return longerOvercrowdedHospital;
    }

    public void setLongerOvercrowdedHospital(Hospital longerOvercrowdedHospital) {
        this.longerOvercrowdedHospital = longerOvercrowdedHospital;
    }

    public Hospital getLongerUndercrowdedHospital() {
        return longerUndercrowdedHospital;
    }

    public void setLongerUndercrowdedHospital(Hospital longerUndercrowdedHospital) {
        this.longerUndercrowdedHospital = longerUndercrowdedHospital;
    }

    public List<AverageResourceTypeDTO> getAverageResourceTypes() {
        return averageResourceTypes;
    }

    public void setAverageResourceTypes(List<AverageResourceTypeDTO> averageResourceTypes) {
        this.averageResourceTypes = averageResourceTypes;
    }

    public List<Exchange> getExchangeHistory() {
        return exchangeHistory;
    }

    public void setExchangeHistory(List<Exchange> exchangeHistory) {
        this.exchangeHistory = exchangeHistory;
    }

    @Override
    public String toString() {
        return "ReportDTO [averageResourceTypes=" + averageResourceTypes + ", exchangeHistory=" + exchangeHistory
                + ", hospitalsOvercrowdedPercentage=" + hospitalsOvercrowdedPercentage
                + ", hospitalsUndercrowdedPercentage=" + hospitalsUndercrowdedPercentage
                + ", longerOvercrowdedHospital=" + longerOvercrowdedHospital + ", longerUndercrowdedHospital="
                + longerUndercrowdedHospital + "]";
    }
}
