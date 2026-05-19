
public class Main{
    public static void main(String[] args)  throws RectangleException
    {
        Rectangle rect = new Rectangle(2,3);
        System.out.println("A: " + Double.toString(rect.getA()));
        System.out.println("B: " + Double.toString(rect.getB()));
        System.out.println("Area: " + Double.toString(rect.getArea()));
        System.out.println("Perimeter: " + Double.toString(rect.getPerimeter()));
    }
}
