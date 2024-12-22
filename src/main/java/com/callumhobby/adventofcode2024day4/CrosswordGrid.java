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
public class CrosswordGrid {

    public char[][] grid;
    private String forwards;
    private String backwards;
    private Integer gridMaxX;
    private Integer gridMaxY;

    public CrosswordGrid(List<String> input) {
        this.gridMaxX = input.getFirst().length();
        this.gridMaxY = input.size();
        this.grid = new char[gridMaxY][gridMaxX];
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                grid[i][j] = input.get(i).charAt(j);
            }
        }
        this.forwards = "XMAS";
        this.backwards = "SAMX";
    }

    /**
     *
     * @param isColumns
     * @return integer array where 0 is forwards count and 1 is backwards count
     */
    public Integer[] getInstancesInRowsOrColumns(boolean isColumns) {
        List<String> linesToCheck = new ArrayList<>();

        if (!isColumns) {
            for (int i = 0; i < grid[0].length; i++) {
                linesToCheck.add("");
                for (char[] row : grid) {
                    linesToCheck.set(i, linesToCheck.get(i) + row[i]);
                }
            }
        } else {
            for (char[] row : grid) {
                linesToCheck.add(String.valueOf(row));
            }
        }

        return xMasCountLogic(linesToCheck);
    }

    public Integer[] getInstancesInDiagonals() {
        List<String> linesToCheck = new ArrayList<>();
        //Doing this graphically with y=mx+c but bound by the length and width of the grid
        //positive gradient diagonals loops:
        for (int c = -gridMaxX; c < gridMaxY; c++) {//loop to iterate through each line (aka every possible y intercept)
            String line = "";
            for (int x = 0; x < gridMaxX; x++) {//iterate through each possible x value
                Integer y = x+c;
                if (y>=0 && x>=0 && y < gridMaxY) {
                    line += grid[y][x];
                } 
            }
            linesToCheck.add(line);
        }
        //negative gradient diagonals loops:
        for (int c = 0; c < gridMaxY+gridMaxX; c++) {
            String line = "";
            for (int x = 0; x < gridMaxX; x++) {//iterate through each possible x value
                Integer y = -x+c;
                if (y>=0 && x>=0 && y < gridMaxY) {
                   line += grid[y][x]; 
                }
                
            }
            linesToCheck.add(line);
        }
        

        return xMasCountLogic(linesToCheck);
    }

    private Integer[] xMasCountLogic(List<String> linesToCheck) {
        Integer[] xMasCount = {0, 0};
        for (String string : linesToCheck) {
            Integer initialCount = string.length();
            Integer forwardsMissing = string.replaceAll(forwards, "").length();
            Integer backwardsMissing = string.replaceAll(backwards, "").length();

            xMasCount[0] += initialCount != forwardsMissing ? (initialCount - forwardsMissing) / forwards.length() : 0;
            xMasCount[1] += initialCount != backwardsMissing ? (initialCount - backwardsMissing) / backwards.length() : 0;

        }
        return xMasCount;
    }
}
