package GUI;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Hexagon extends Polygon {


    public Hexagon(double x, double y, double radius) {
        relocate(x,y);
        setHexagonPoints(radius);
        setFill(Color.web("009900"));
        setStroke(Color.web("4d2600"));
    }



    private void setHexagonPoints(double radius) {
        for (int i = 0; i < 6; i++) {
            double xval = (int) (radius*Math.cos(i * 2 * Math.PI / 6D));
            double yval = (int) (radius*Math.sin(i * 2 * Math.PI / 6D));
            getPoints().addAll(xval,yval);
        }

    }


    public void relocate(double x,double y){
        setTranslateX(x);
        setTranslateY(y);
    }
}
