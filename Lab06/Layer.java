import java.util.ArrayList;

public class Layer {
    private ArrayList<Shape> listShape = new  ArrayList<>();

    public ArrayList<Shape> getListShape() {
        return listShape;
    }

    public void setListShape(ArrayList<Shape> listShape) {
        this.listShape = listShape;
    }

    public void removeAllTriangle() {
        int sizeListShape = listShape.size();
        for (int i = 0; i < sizeListShape; i++) {
            if (listShape.get(i) instanceof Triangle) {
                listShape.remove(i);
            }
        }
        System.out.println("Xóa thành công");
    }
}
