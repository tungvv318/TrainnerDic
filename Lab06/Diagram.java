gitimport java.util.ArrayList;
public class Diagram {
    private int width = 300;
    private int height = 300;

    public Diagram() {}

    public Diagram(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private ArrayList<Layer> listLayer = new ArrayList<>();

    public ArrayList<Layer> getListLayer() {
        return listLayer;
    }

    public void setListLayer(ArrayList<Layer> listLayer) {
        this.listLayer = listLayer;
    }

    public void removeAllCircle() {
        int sizeListLayer = listLayer.size();
        for (int i = 0; i < sizeListLayer; i++) {
            for (int j = 0; j < listLayer.get(i).getListShape().size(); j++) {
                if (listLayer.get(i).getListShape().get(j) instanceof Circle)
                    listLayer.get(i).getListShape().remove(j);
            }
        }
        System.out.println("Xóa thành công");
    }
}
