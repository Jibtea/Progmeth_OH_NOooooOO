package gui.selector;

import io.MapParser;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameSystem;
import logic.Map;

public class MapSelectorPane extends VBox {
    private static final String[] fileList = {"01.txt", "02.txt", "03.txt", "04.txt", "05.txt"};
    private static MapSelectorPane instance;

    private MapSelectorPane() {
        // TODO: Complete the remaining code of the constructor
    	super();
    	
    	this.setPrefSize(400, 600);
    	
    	this.setAlignment(Pos.TOP_CENTER);
    	this.setSpacing(10);
    	
    	this.setBackground(new Background(new BackgroundFill(Color.web("#EEF7FF"), null, null)));
    	// top bottom left right
    	this.setPadding(new Insets(10,0,10,0));

        for (String file: fileList) {
            Map map = MapParser.readFile("res/maps/" + file);
            if (map == null) {
                continue;
            }
            // TODO: Add new MapButtonPane for each map here
            this.getChildren().add(new MapButtonPane(map));
        }
    }

    public static MapSelectorPane getInstance() {
        if (instance == null) {
            instance = new MapSelectorPane();
        }
        return instance;
    }
}
