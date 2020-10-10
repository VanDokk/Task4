import org.codehaus.jackson.annotate.JsonAutoDetect;
import java.io.Serializable;

public class SquarePrism extends Square implements  Figure, Serializable {

    private int height;

    public int getHeight() {
        return height;
    }

    public SquarePrism(int side, int height) {
        super(side);
        this.height = height;
    }

    private double diagonalSidePlane() {
        //Вычисление диагонали боковой стороны
        return Math.sqrt(Math.pow(this.side, 2) + Math.pow(this.height, 2));
    }

    public double Volume() {
        return super.calcSquare() * height;
    }

    @Override
    public int calcSquare() {
        return (4 * side * height) + (2 * super.calcSquare());
    }

    @Override
    public double calcDiagonal() {
        return Math.sqrt(Math.pow(diagonalSidePlane(), 2) + Math.pow(side, 2));
    }

    @Override
    public int calcPerimeter() {
        return 2 * super.calcPerimeter() + 4 * height;
    }

    @Override
    public String toString() {
        return "Side: " + side +
                "\nHeight: " + height +
                "\nVolume: " + Volume() +
                "\nSquare: " + calcSquare() +
                "\nPerimeter: " + calcPerimeter() +
                "\nDiagonal: " + calcDiagonal();
    }
}
