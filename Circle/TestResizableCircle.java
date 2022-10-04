
public class TestResizableCircle {

	public static void main(String[] args) {
        Resizable geomObj2 = new ResizableCircle(100.0);
        geomObj2.resize(10);
        GeometricObject geomObj3 = (GeometricObject) geomObj2;
        System.out.println("Perimeter = "+geomObj3.getPerimeter());
        System.out.println("Area = "+geomObj3.getArea());
	}

}
