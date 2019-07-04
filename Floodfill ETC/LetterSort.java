import java.util.Arrays;

public class LetterSort
{
    public static void main(String[] args) {
        String alphabet = "ALPHABET";
        
        // Split string into each character
        String[] tokens = alphabet.split("");
        
        // Sort the array
        Arrays.sort(tokens);
        
        // Join sorted tokens back into single string
        String output = String.join("", tokens);
        
        // Print the array
        System.out.println(output);
    }
}
