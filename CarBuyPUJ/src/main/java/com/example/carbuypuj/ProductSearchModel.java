package com.example.carbuypuj;

public class ProductSearchModel {

    Integer idCars;
    String Marka;
    String Model;
    String Godina;
    String VIN;
    String Cijena;

    public ProductSearchModel(Integer idCars,String Marka,String Model,String Godina,String VIN,String Cijena) {
        this.idCars = idCars;
        this.Marka = Marka;
        this.Model = Model;
        this.Godina = Godina;
        this.VIN = VIN;
        this.Cijena = Cijena;
    }
    public Integer getIdCars() {
        return idCars;
    }
    public String getMarka() {
        return Marka;
    }
    public String getModel() {
        return Model;
    }
    public String getGodina() {
        return Godina;
    }
    public String getVIN() {
        return VIN;
    }
    public String getCijena() {
        return Cijena;
    }
    public void setIdCars(Integer idCars) {
        this.idCars = idCars;
    }
    public void setMarka(String marka) {
        Marka = marka;
    }
    public void setModel(String model) {
        Model = model;
    }
    public void setGodina(String godina) {
        Godina = godina;
    }
    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
    public void setCijena(String cijena) {
        Cijena = cijena;
    }
}
