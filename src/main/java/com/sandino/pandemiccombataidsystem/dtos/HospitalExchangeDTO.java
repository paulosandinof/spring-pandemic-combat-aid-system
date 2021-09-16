package com.sandino.pandemiccombataidsystem.dtos;

public class HospitalExchangeDTO {

    private ExchangeDTO firstHospital;
    private ExchangeDTO secondHospital;

    public HospitalExchangeDTO() {
    }

    public HospitalExchangeDTO(ExchangeDTO firstHospital, ExchangeDTO secondHospital) {
        this.firstHospital = firstHospital;
        this.secondHospital = secondHospital;
    }

    public ExchangeDTO getFirstHospital() {
        return firstHospital;
    }

    public void setFirstHospital(ExchangeDTO firstHospital) {
        this.firstHospital = firstHospital;
    }

    public ExchangeDTO getSecondHospital() {
        return secondHospital;
    }

    public void setSecondHospital(ExchangeDTO secondHospital) {
        this.secondHospital = secondHospital;
    }

    @Override
    public String toString() {
        return "HospitalExchangeDTO [firstHospital=" + firstHospital + ", secondHospital=" + secondHospital + "]";
    }
}
