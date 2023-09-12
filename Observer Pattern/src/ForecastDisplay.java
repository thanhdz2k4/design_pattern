public class ForecastDisplay implements Observer, DisplayElement{

    private float currentPressure = 29.92f;
    private float lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        float Avg = (currentPressure + lastPressure) / 2; 
        if(currentPressure == lastPressure) {
            System.out.println("Avg/Max/Min temperature = " + Avg + '/' + lastPressure + '/' + currentPressure);
        } else if(currentPressure > lastPressure) {
            System.out.println("Avg/Max/Min temperature = " + Avg + '/' + currentPressure + '/' + lastPressure);
        } else {
            System.out.println("Avg/Max/Min temperature = " + Avg + '/' + lastPressure + '/' + currentPressure);
        }
        
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        this.lastPressure = currentPressure;
        currentPressure = weatherData.getTemperature();
        display();
    }
    
}
