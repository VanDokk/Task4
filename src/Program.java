import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        ArrayList<Square> Squares = new ArrayList<Square>();
        ArrayList<SquarePrism> Prisms = new ArrayList<SquarePrism>();

        double maxDiagonal = 0;
        int maxSquare = 0;
        byte flagDiagonal = -1;
        byte flagSquare = -1;

        for (int i = 0; i <= 10; i++) {
            Squares.add(new Square((int)(Math.random() * 9 + 1)));
            Prisms.add(new SquarePrism((int)(Math.random() * 9 + 1), i));

            int currentSquare = Squares.get(i).calcSquare();
            if (currentSquare > maxSquare) {
                maxSquare = currentSquare;
                flagSquare = (byte)i;
            }

            double currentDiagonal = Prisms.get(i).calcDiagonal();
            if (currentDiagonal > maxDiagonal) {
                maxDiagonal = currentDiagonal;
                flagDiagonal = (byte)i;
            }
        }

        NativeSerialization.saveFile(Squares.get(flagSquare), Prisms.get(flagDiagonal));
        Figure[] loadData = NativeSerialization.loadFile("figure.txt");
        System.out.println("Square:\n" + loadData[0].toString() + "\n\n" + "Prism:\n" + loadData[1].toString());


        JSONSerialization.saveFile(Squares.get(flagSquare), Prisms.get(flagDiagonal));
        loadData = JSONSerialization.loadFile("figureJSON.txt");
        //System.out.println(loadData[0]);
        //System.out.println("Square:\n" + loadData[0].toString() + "\n\n" + "Prism:\n" + loadData[1].toString());
    }
}
