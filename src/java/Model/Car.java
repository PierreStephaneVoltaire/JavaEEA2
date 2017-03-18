/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author steph
 */
public class Car {

    public Car(int id, String make, String model, int debut, String carEngine, double price, String color, String regiistration, String fuel) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.debut = debut;
        this.carEngine = carEngine;
        this.price = price;
        this.color = color;
        this.regiistration = regiistration;
        this.fuel = fuel;
    }
    private int id;
    private String make;
    private String model;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegiistration() {
        return regiistration;
    }

    public void setRegiistration(String regiistration) {
        this.regiistration = regiistration;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Car() {
    }
    private int debut;
    private String carEngine;
    private double price;
    private String color;
    private String regiistration;
    private String fuel;
}
