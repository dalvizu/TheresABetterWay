import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.ArrayList;

public class Examples
{
    public static void main(String [] args)
        throws Exception
    {
        // Try-with-resources
        try(BufferedReader br = new BufferedReader(new FileReader("resources/file.txt")))
        {
            System.out.println("This will work with any object implementing java.lang.AutoCloseable!");
            System.out.println("Read line: " + br.readLine());
        }

        // Switch string
        String foo = "foo";
        switch (foo)
        {
            case "bar": System.out.println("er.."); break;
            case "foo": System.out.println("Awesome!");break;
        }

        // Binary litereals
        int thisIsReallyAnInteger = 0b00111;
        long thisIsReallyALong = 0b1010000101000101101000010100010110100001010001011010000101000101L;
        System.out.println("Integer value: " + thisIsReallyAnInteger);
        System.out.println("Long value: " + thisIsReallyALong);

        // Numerical literal
        int one_million = 1_000_000;
        System.out.println("Dr. Evil demands " + one_million + " dollars!");

        // Multi-catch
        try
        {
            someMethod();
            // should throw exception before we hit here
        }
        catch(FirstException|SecondException exception)
        {
            System.out.println("I caught a : " + exception.getClass());
        }

        // Diamond operator
        List<String> list = new ArrayList<>();
        list.add("A");
        System.out.println("List: " + list);
    }

    public static class FirstException extends Exception {};
    public static class SecondException extends Exception {};

    public static void someMethod()
            throws FirstException, SecondException
    {
        SecureRandom random = new SecureRandom();
        random.setSeed(System.currentTimeMillis());
        if (random.nextBoolean())
        {
            throw new FirstException();
        }
        else
        {
            throw new SecondException();
        }
    }
}
