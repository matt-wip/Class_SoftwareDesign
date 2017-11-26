import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Class to check and extract information from user's query
 * @author Matt Wipfler
 */
public class MessageChecker {

    private static Pattern kPattern = Pattern.compile("[0-9,\\.]+(.*?)[t][o][\\s+][a-z]+");
    /**
     * Class for checking sentence to a certain motiff
     * format: [number] [unit] to [other unit]
     * @param s Sentence to check
     * @return True if sentence matches structure, false otherwise
     */
    public static boolean checkSentence(String s){
        //https://stackoverflow.com/questions/273141/regex-for-numbers-only  // = new Regex(@"^-*[0-9,\.]+");
        if(!s.matches("(.*?)[0-9,\\.]+[\\s+][a-z]+[\\s]+[t][o][\\sa-z]+")) // note: does not use decimals
            return false;
        return true;
    }

    /**
     * Method to extract units and value from query
     * @param s sentence that is checked and contains valid parameters
     * @return Object containing extracted values
     */
    public static results extractInfo(String s){
        Matcher match = kPattern.matcher(s);
        results kResults = new results();
        if(match.find())
        {
            // Split into 4 words - [number, unit, to, unit]
            String[] sub = match.group().split("[\\s+]");//.replaceFirst("[?]","").
            if(sub.length != 4)
                return  kResults;// uuhhhh, should not happen

            // Remove 's' if plural is used
            if(sub[1].endsWith("s")) sub[1] = sub[1].replaceAll(".$","");
            if(sub[3].endsWith("s")) sub[3] = sub[3].replaceAll(".$","");

            // Convert to results (todo? have non-index conversion?)
            kResults.value = Double.parseDouble(sub[0]);
            kResults.from = UnitConverter.toUnitEnum(sub[1]);
            kResults.to = UnitConverter.toUnitEnum(sub[3]);
        }

        return kResults;
    }

    /**
     * Class for storing value and units
     */
    public static class results{
        public SupportedUnits from = SupportedUnits.VOID;
        public SupportedUnits to = SupportedUnits.VOID;
        public double value = 0;
    }
}
