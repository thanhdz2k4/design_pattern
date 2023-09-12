public class CurrentConditionsDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + " % humidity");
        
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();

    }
    
}
