import java.io.Serializable;


public class Square implements Figure, Serializable {

    protected int side;

    public Square(int side) {this.side = side;}

    public void setSide(int side) {
        try {
            this.side = side;
        }
        catch (Exception e) {
            System.out.println("Input a correct length of side, please");
        }
    }
    public int getSide() {return this.side;}

    public int calcSquare() {
        return this.side * this.side;
    }

    public double calcDiagonal() {
        return this.side * Math.sqrt(2);
    }

    public int calcPerimeter() {
        return this.side * 4;
    }

    public String toString() {
        return "Side: " + this.side +
                "\nSquare: " + calcSquare() +
                "\nDiagonal: " + calcDiagonal() +
                "\nPerimeter: " + calcPerimeter();
    }
}
