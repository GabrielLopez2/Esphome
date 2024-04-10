package org.utl.dsm.model;

public class Registro {

    private int idRegistro;
    private float temperature;
    private float humidity;
    private int brightness;
    private String door;
    private String garage;
    private boolean led0;
    private boolean led1;
    private boolean led2;
    private String timestamp;

    public Registro(int idRegistro, float temperature, float humidity, int brightness, String door, String garage, boolean led0, boolean led1, boolean led2, String timestamp) {
        this.idRegistro = idRegistro;
        this.temperature = temperature;
        this.humidity = humidity;
        this.brightness = brightness;
        this.door = door;
        this.garage = garage;
        this.led0 = led0;
        this.led1 = led1;
        this.led2 = led2;
        this.timestamp = timestamp;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public boolean isLed0() {
        return led0;
    }

    public void setLed0(boolean led0) {
        this.led0 = led0;
    }

    public boolean isLed1() {
        return led1;
    }

    public void setLed1(boolean led1) {
        this.led1 = led1;
    }

    public boolean isLed2() {
        return led2;
    }

    public void setLed2(boolean led2) {
        this.led2 = led2;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "idRegistro=" + idRegistro +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", brightness=" + brightness +
                ", door='" + door + '\'' +
                ", garage='" + garage + '\'' +
                ", led0=" + led0 +
                ", led1=" + led1 +
                ", led2=" + led2 +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
