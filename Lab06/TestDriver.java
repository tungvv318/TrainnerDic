import java.util.ArrayList;

public class TestDriver {
    public static void main(String[] args) {
        Shape circle = new Circle(new Point(10,10), 1);
        Shape rectangle = new Rectangle(new Point(20, 20), new Point(50,55));
        Shape square = new Square(new Point(60,60), new Point(70,70));
        Shape triangle = new Triangle(new Point(100,100), new Point(100,200), new Point(200,250));
        Diagram diagram = new Diagram();
        ArrayList<Layer> listLayer = new ArrayList<>();
        diagram.setListLayer(listLayer);
        Layer layer = new Layer();
        ArrayList<Shape> listShape = new ArrayList<>();
        listShape.add(circle);
        listShape.add(rectangle);
        listShape.add(square);
        listShape.add(triangle);
        layer.setListShape(listShape);
        listLayer.add(layer);
        diagram.removeAllCircle();
        diagram.getListLayer().get(0).removeAllTriangle();
        System.out.println(listShape.size());
    }
}
