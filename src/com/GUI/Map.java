package GUI;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.stage.Screen;

public class Map extends Group {
    private Grid grid;

    private double width,height;
    private boolean canRight,canLeft,canUp,canDown;

    public Map() {
        grid=new Grid(18,18);
        addAllTileToMap();
        setOnActions();
        width=18*70;
        height=18*70;
    }

    public Map(int xSize,int ySize) {
        grid=new Grid(xSize,ySize);
        addAllTileToMap();
    }


    private void setOnActions(){
        double shiftVel=10;
        Rectangle2D root=Screen.getPrimary().getVisualBounds();

        setOnKeyPressed(event -> {
            if(event.getCode()== KeyCode.SPACE){
                setTranslateX(0);
                setTranslateY(0);
            }
        });

        setOnMouseMoved(event -> {
            canUp=event.getSceneY()<100;
            canDown=event.getSceneY()> root.getHeight()-200;
            canRight=event.getSceneX()<100;
            canLeft=event.getSceneX()> root.getWidth()-200;
        });

        new AnimationTimer(){
            @Override
            public void handle(long now) {
                if(canUp) setTranslateY(getTranslateY()+shiftVel);
                if(canDown&&getTranslateY()>-1*height-root.getHeight()/2) setTranslateY(getTranslateY()-shiftVel);
                if(canRight&&getTranslateY()<width/2) setTranslateX(getTranslateX()+shiftVel);
                if(canLeft&&getTranslateY()>-1*height-root.getWidth()/2) setTranslateX(getTranslateX()-shiftVel);

            }
        }.start();

    }

    private void addAllTileToMap(){
        for (int i=0;i<grid.getSizeX();i++) {
            for (int j=0; j < grid.getSizeX(); j++) {
                getChildren().add(grid.get(i,j));
            }
        }
    }



    public Tile getTile(int i,int j){
        return grid.get(i,j);
    }


}
