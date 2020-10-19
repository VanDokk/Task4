import org.codehaus.jackson.map.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.Date;


public class JSONSerialization {

    private static String fileNameSquare = "Square" + new Date() + ".json";
    private static String fileNamePrism = "Prism" + new Date() + ".json";

    public static void saveFile(Square sq, SquarePrism sp)
    {
        try
        {
            FileWriter fw1 = new FileWriter(fileNameSquare, true);
            FileWriter fw2 = new FileWriter(fileNamePrism, true);

            ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(fw1, sq);
            mapper.writeValue(fw2, sp);
        }

        catch (Exception e)
        {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static Figure[] loadFile(String fileNameSquare, String fileNamePrism)
    {
        Figure[] figures = new Figure[2];

        try
        {
            FileReader fr1 = new FileReader(fileNameSquare);
            FileReader fr2 = new FileReader(fileNamePrism);

            ObjectMapper mapper = new ObjectMapper();

            figures[0] = mapper.readValue(fr1, Square.class);
            figures[1] = mapper.readValue(fr2, SquarePrism.class);

        }
        catch (Exception e)
        {
            System.out.println("Ошибка: " + e.getMessage());
        }

        return figures;
    }
}
