import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NativeSerialization {
    public static void saveFile(Square sq, SquarePrism sp)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("figure.txt")))
        {
            oos.writeObject(sq);
            oos.writeObject(sp);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static Figure[] loadFile(String fileName)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
        {
            Figure[] figure = new Figure[2];
            figure[0] = (Square)ois.readObject();
            figure[1] = (SquarePrism)ois.readObject();
            return figure;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return new Figure[1];
    }
}
