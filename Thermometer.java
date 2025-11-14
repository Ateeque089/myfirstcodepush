public class Thermometer {
    private double temperature; // Stores temperature in Celsius by default
    private String unit;        // "C" for Celsius, "F" for Fahrenheit

    // Constructor to initialize with a temperature in Celsius
    public Thermometer(double initialTempCelsius) {
        this.temperature = initialTempCelsius;
        this.unit = "C";
    }

    // Constructor to initialize with a temperature and unit
    public Thermometer(double initialTemp, String unit) {
        if (unit.equalsIgnoreCase("F")) {
            this.temperature = fahrenheitToCelsius(initialTemp); // Convert to Celsius for internal storage
            this.unit = "F";
        } else if (unit.equalsIgnoreCase("C")) {
            this.temperature = initialTemp;
            this.unit = "C";
        } else {
            System.out.println("Invalid unit. Defaulting to Celsius.");
            this.temperature = initialTemp;
            this.unit = "C";
        }
    }

    // Get temperature in Celsius
    public double getTemperatureCelsius() {
        return temperature;
    }

    // Get temperature in Fahrenheit
    public double getTemperatureFahrenheit() {
        return celsiusToFahrenheit(temperature);
    }

    // Set temperature in Celsius
    public void setTemperatureCelsius(double newTempCelsius) {
        this.temperature = newTempCelsius;
        this.unit = "C";
    }

    // Set temperature in Fahrenheit
    public void setTemperatureFahrenheit(double newTempFahrenheit) {
        this.temperature = fahrenheitToCelsius(newTempFahrenheit);
        this.unit = "F";
    }

    // Get current unit
    public String getUnit() {
        return unit;
    }

    // Convert Celsius to Fahrenheit
    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Convert Fahrenheit to Celsius
    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Display the temperature
    public String displayTemperature() {
        if (unit.equalsIgnoreCase("F")) {
            return String.format("%.1f°F", getTemperatureFahrenheit());
        } else {
            return String.format("%.1f°C", temperature);
        }
    }

    public static void main(String[] args) {
        Thermometer thermoC = new Thermometer(25.0); // 25 degrees Celsius
        System.out.println("Initial temperature: " + thermoC.displayTemperature());

        Thermometer thermoF = new Thermometer(77.0, "F"); // 77 degrees Fahrenheit
        System.out.println("Initial temperature: " + thermoF.displayTemperature());

        thermoC.setTemperatureFahrenheit(98.6); // Set a new temperature in Fahrenheit
        System.out.println("New temperature: " + thermoC.displayTemperature());
        System.out.println("In Celsius: " + thermoC.getTemperatureCelsius() + "°C");

        thermoF.setTemperatureCelsius(0.0); // Set a new temperature in Celsius
        System.out.println("New temperature: " + thermoF.displayTemperature());
        System.out.println("In Fahrenheit: " + thermoF.getTemperatureFahrenheit() + "°F");
    }
}