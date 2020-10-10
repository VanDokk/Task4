import org.codehaus.jackson.map.*;
import org.codehaus.jackson.type.TypeReference;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;


public class JSONSerialization {
    public static void saveFile(Square sq, SquarePrism sp)
    {
        try(FileWriter fw = new FileWriter("figureJSON.json"))
        {
            Figure[] figures = {sq, sp};
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(fw, figures);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static Figure[] loadFile(String fileName)
    {
        try(FileReader fr = new FileReader("figureJSON.json"))
        {
            ObjectMapper mapper = new ObjectMapper();
            Figure[] figures = mapper.readValue(fr, Figure[].class);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return new Figure[1];
    }
}
