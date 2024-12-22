/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callumhobby.adventofcode2024day4;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author CallumBinns
 */
public class XWindow {
    private Integer[][] windowPosition;//{topLeft,topRight,middle,bottomLeft,bottomRight}

    
    /**
     * assumes start position of top left of x to be top left of grid. Coordinate order and x travel pattern are the way you read.
     * @param topLeft 
     */
    public XWindow(Integer[] topLeft){
      setupWindowAtNewPosition(topLeft);
    }
    /**
     * 
     * @return list contains two 2D integer arrays, the first for all coordinates in the descending x diagonal and the second for all coordinates in the ascending x diagonal
     */
    public List<Integer[][]> shiftRightOne(){
        
        for (int i = 0; i < windowPosition.length; i++) {
            windowPosition[i][1] += 1;
        }

        
        return getCoordsOfStringsToCheck();
    }
    
    public List<Integer[][]> shiftDownOneAndReturnToLeft(){
        Integer[] newCoordinates = {windowPosition[0][0]+1,0};
        setupWindowAtNewPosition(newCoordinates);        
        return getCoordsOfStringsToCheck();
    }
    
    public boolean hasSpaceToShiftDown(Integer gridMaxY){
        return windowPosition[3][0] < gridMaxY;
    }
    public boolean hasSpaceToShiftRight(Integer gridMaxX){
        return windowPosition[1][1] < gridMaxX;
    }
    
    public List<Integer[][]> getCoordsOfStringsToCheck(){
        List<Integer[][]> coordsOfStringsToCheck = new ArrayList<>();
        Integer[][] descDiagonal = {windowPosition[0],windowPosition[2],windowPosition[4]};
        coordsOfStringsToCheck.add(descDiagonal);
        Integer[][] ascDiagonal = {windowPosition[1],windowPosition[2],windowPosition[3]};
        coordsOfStringsToCheck.add(ascDiagonal);
        
        return coordsOfStringsToCheck;
    }
    
    private void setupWindowAtNewPosition(Integer[] topLeft){
        Integer[] topRight ={topLeft[0],(topLeft[1]+2)};
        Integer[] middle ={topLeft[0]+1,(topLeft[1]+1)};
        Integer[] bottomLeft ={topLeft[0]+2,(topLeft[1])};
        Integer[] bottomRight ={topLeft[0]+2,(topLeft[1]+2)};
        Integer[][] startPosition ={topLeft,topRight,middle,bottomLeft,bottomRight};
        this.windowPosition = startPosition;
        
    }
}
