public class Rectangle{
    double a;
    double b;

    public Rectangle(double a, double b) throws RectangleException{
        if(a <= 0){
            throw new RectangleException("a parameter has to be positive, got: "+Double.toString(a));
        }
        if(b <= 0){
            throw new RectangleException("b parameter has to be positive, got: "+Double.toString(b));
        }
        this.a = a;
        this.b = b;
    }

    public double getArea(){
        return this.a * this.b;
    }

    public double getPerimeter(){
        return 2 * this.a + 2 * this.b;
    }

    public void setA(double a){
        this.a = a;
    }

    public void setB(double b){
        this.b = b;
    }

    public double getA(){
        return this.a;
    }

    public double getB(){
        return this.b;
    }

    public boolean isSquare(){
        return this.a == this.b;
    }
}
