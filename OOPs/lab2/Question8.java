// 8. Write a class TemperatureConverter with static methods to convert temperatures between Celsius and Fahrenheit.

class TemperatureConverter {
    static float Celsius, Fahrenheit;

    static void CelToFarh(float Celsius) {
        float Fahrenheit = (Celsius * (9f/5)) + 32;
        System.out.println(Celsius + "C in farhenheit is " + Fahrenheit + "F");
    }
    static void FarhToCel(float Fahrenheit) {
        Celsius = (Fahrenheit - 32) * (5f/9);
        System.out.println(Fahrenheit + "F in celcius is " + Celsius + "C");
    }
}


public class Question8 {
    public static void main(String[] args) {
        TemperatureConverter t = new TemperatureConverter();
        TemperatureConverter.CelToFarh(100f);
        TemperatureConverter.FarhToCel(212f);
    }
}
