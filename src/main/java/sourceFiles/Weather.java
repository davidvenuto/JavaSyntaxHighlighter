package sourceFiles;

public class Weather {
    private String city;
    private double temperature;

    public Weather(String city, double temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    public String getWeatherReport() {
        return "The current temperature in " + city + " is " + temperature + " degrees Celsius.";
    }

    public void updateTemperature(double newTemp) {
        this.temperature = newTemp;
    }
}
