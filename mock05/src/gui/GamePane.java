package gui;

import javafx.scene.layout.GridPane;
import logic.GameSystem;
import logic.Map;

import java.util.ArrayList;
import java.util.List;

public class GamePane extends GridPane {
    private static final int GAME_SIZE = 620;
    private static GamePane instance;
    private List<List<CellPane>> gridCellPane;
    private double tileSize;

    private GamePane() {
        super();
        this.setPrefWidth(GAME_SIZE);
        this.setPrefHeight(GAME_SIZE);
    }

    public static GamePane getInstance() {
        if (instance == null) {
            instance = new GamePane();
        }
        return instance;
    }

    public void initTiles() {
        this.getChildren().clear();
        Map map = GameSystem.getInstance().getCurrentMap();
        this.tileSize = GAME_SIZE / (Math.max(map.getWidth(), map.getHeight()) * 1.0);
        this.gridCellPane = new ArrayList<List<CellPane>>();

        // TODO: Complete the remaining code for this method
        int mapW = map.getWidth();
        int mapH = map.getHeight();
        
        
        for (int row = 0; row < mapH; row++) {
            List<CellPane> rowList = new ArrayList<>(); // ✅ สร้าง ArrayList สำหรับแถว
            for (int col = 0; col < mapW; col++) {
                CellPane cell = new CellPane(this.tileSize, this.tileSize,row,col); // ✅ สร้าง CellPane ตาม tileSize
                this.add(cell, col, row); // ✅ เพิ่ม CellPane ลงใน GridPane
                rowList.add(cell); // ✅ เพิ่ม CellPane ลงในแถว
            }
            this.gridCellPane.add(rowList); // ✅ เพิ่มแถวลงใน 2D List
        }



    }

    public CellPane getCellPane(int row,int col){
        return this.gridCellPane.get(row).get(col);
    }


}
