/**
 * Class to provide conversion equations
 * @author Matt Wipfler
 */
public class UnitConverter {

    /** Conversion factor from feet to meters*/
    private static final double feetToMeter = 0.3048; //5280 ft/mile
    /** Conversion factor from pounds to grams*/
    private static final double poundToGram = 453.59237; //16 oz/lb
    /** Conversion factor from quarts to liters*/
    private static final double quartToLiter = 0.946352946;// 4 qt/gal
    //F to C : (*F - 32) * 0.55555555
    //C to F : (C * 1.8) + 32
    /**
     * Converts string into set enum
     * @param s string to test/convert
     * @return Unit enum, void if does not work
     */
    public static SupportedUnits toUnitEnum(String s){

        if(s.matches("foot|feet|ft"))
            return SupportedUnits.FEET;
        else if(s.matches("meter|m"))
            return SupportedUnits.METER;
        else if(s.matches("mile|mi"))
            return SupportedUnits.MILE;
        else if(s.matches("km|kilometer"))
            return SupportedUnits.KILOMETER;
        else if(s.matches("lb|pound"))
            return SupportedUnits.POUND;
        else if(s.matches("ounce|oz"))
            return SupportedUnits.OUNCE;
        else if(s.matches("g|gram"))
            return SupportedUnits.GRAM;
        else if(s.matches("kg|kilogram"))
            return SupportedUnits.KILOGRAM;
        else if(s.matches("gallon|gal|ga"))
            return SupportedUnits.GALLON;
        else if(s.matches("qt|quart"))
            return SupportedUnits.QUART;
        else if(s.matches("l|liter"))
            return SupportedUnits.LITER;
        else if(s.matches("f|fahrenheit"))
            return SupportedUnits.FAHRENHEIT;
        else if(s.matches("c|celsius"))
            return SupportedUnits.CELSIUS;

        return SupportedUnits.VOID;
    }

    /**
     * Method to check if possible to convert the two units
     * @param kResults Object containing the units to check
     * @return True if possible, false otherwise
     */
    public static boolean checkUnits(MessageChecker.results kResults){
        SupportedUnits a = kResults.from;
        SupportedUnits b = kResults.to;

        if(a == SupportedUnits.VOID || b == SupportedUnits.VOID){
            System.out.println("Error in units. Please check if valid units or spelling");
            return false;
        }

        // distance: feet, meter, mile, kilometer
        if( (a==SupportedUnits.FEET || a==SupportedUnits.METER || a==SupportedUnits.MILE || a==SupportedUnits.KILOMETER) &&
             (b==SupportedUnits.FEET || b==SupportedUnits.METER || b==SupportedUnits.MILE || b==SupportedUnits.KILOMETER))
            return true;

        // weight: pound, ounce, gram, kilogram
        if( (a==SupportedUnits.POUND || a==SupportedUnits.OUNCE || a==SupportedUnits.GRAM || a==SupportedUnits.KILOGRAM) &&
            (b==SupportedUnits.POUND || b==SupportedUnits.OUNCE || b==SupportedUnits.GRAM || b==SupportedUnits.KILOGRAM))
            return  true;

        // volume: gallon, quart, liter
        if( (a==SupportedUnits.GALLON || a==SupportedUnits.QUART || a==SupportedUnits.LITER) &&
            (b==SupportedUnits.GALLON || b==SupportedUnits.QUART || b==SupportedUnits.LITER))
            return true;

        // temperature: fahrenheit, celsius
        if( (a==SupportedUnits.FAHRENHEIT || a==SupportedUnits.CELSIUS) &&
            (b==SupportedUnits.FAHRENHEIT || b==SupportedUnits.CELSIUS) )
            return true;

        System.out.println("Units can not be converted between one another. Try another conversion.");
        return false;
    }

    /**
     * Method to change from one unit to another. Note: assumes units are valid
     * @param kResults Information about the two units and value
     * @return converted value
     */
    public static double convert(MessageChecker.results kResults){
        // If units the same, return number
        if(kResults.to == kResults.from) return kResults.value;

        // distance: feet, meter, mile, kilometer
        if(kResults.from == SupportedUnits.MILE){
            kResults.value *= 5280.0;// in feet
            if(kResults.to == SupportedUnits.FEET)
                return kResults.value;
        }
        if(kResults.from == SupportedUnits.MILE || kResults.from == SupportedUnits.FEET){
            if(kResults.to == SupportedUnits.MILE)
                return kResults.value / 5280.0;

            kResults.value *= feetToMeter; // in meters
            if(kResults.to == SupportedUnits.METER)
                return kResults.value;
            else if(kResults.to == SupportedUnits.KILOMETER)
                return kResults.value*0.001;
        }

        if(kResults.from == SupportedUnits.KILOMETER) {
            kResults.value *= 1000.0; // in meters
            if(kResults.to == SupportedUnits.METER)
                return kResults.value;
        }
        if(kResults.from == SupportedUnits.KILOMETER || kResults.from == SupportedUnits.METER){
            if(kResults.to == SupportedUnits.KILOMETER)
                return kResults.value / 1000.0;

            kResults.value /= feetToMeter; //to feet
            if(kResults.to == SupportedUnits.FEET)
                return kResults.value;
            else if(kResults.to == SupportedUnits.MILE)
                return kResults.value / 5280.0;
        }

        // weight: pound, ounce, gram, kilogram
        if(kResults.from == SupportedUnits.OUNCE){
            kResults.value /= 16.0; //to pound
            if(kResults.to == SupportedUnits.POUND)
                return kResults.value;
        }
        if(kResults.from == SupportedUnits.OUNCE || kResults.from == SupportedUnits.POUND){
            if(kResults.to == SupportedUnits.OUNCE)
                return kResults.value * 16.0;

            kResults.value *= poundToGram; // in grams
            if(kResults.to == SupportedUnits.GRAM)
                return kResults.value;
            else if(kResults.to == SupportedUnits.KILOGRAM)
                return kResults.value * 0.001;
        }

        if(kResults.from == SupportedUnits.KILOGRAM) {
            kResults.value *= 1000; //to grams
            if(kResults.to == SupportedUnits.GRAM)
                return kResults.value;
        }
        if(kResults.from == SupportedUnits.KILOGRAM || kResults.from == SupportedUnits.GRAM){
            if(kResults.to == SupportedUnits.KILOGRAM)
                return kResults.value * 0.001;

            kResults.value /= poundToGram; // in pounds
            if(kResults.to == SupportedUnits.POUND)
                return kResults.value;
            else if(kResults.to == SupportedUnits.OUNCE)
                return kResults.value * 16.0;
        }

        // volume: gallon, quart, liter
        if(kResults.from == SupportedUnits.GALLON){
            kResults.value *= 4.0; //to quarts
            if(kResults.to == SupportedUnits.QUART)
                return kResults.value;
        }
        if(kResults.from == SupportedUnits.GALLON || kResults.from == SupportedUnits.QUART ){
            if(kResults.to == SupportedUnits.LITER)
                return kResults.value * quartToLiter;
            else if(kResults.to == SupportedUnits.GALLON)
                return kResults.value / 4.0;
        }

        if(kResults.from == SupportedUnits.LITER){
            kResults.value /= quartToLiter; //to quart
            if(kResults.to == SupportedUnits.QUART)
                return kResults.value;
            else if(kResults.to == SupportedUnits.GALLON)
                return  kResults.value / 4.0;
        }

        // temperature: fahrenheit, celsius
        if( kResults.from == SupportedUnits.FAHRENHEIT)
            return (kResults.value - 32.0) * 0.555555555;
        else if(kResults.from == SupportedUnits.CELSIUS)
            return kResults.value * 1.8 + 32.0;

        return  0;
    }
}