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

    public CrosswordGrid(List<String> input) {
        this.grid = new char[input.size()][input.getFirst().length()];
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
        Integer[] xMasCount = {0, 0};
        List<String> linesToCheck = new ArrayList<>();
        
        if (!isColumns) {
            for (int i = 0; i < grid[0].length; i++) {
                linesToCheck.add("");
                for (char[] row : grid) {
                    linesToCheck.set(i,linesToCheck.get(i)+row[i]);
                }
            }
        }
        else{
            for (char[] row : grid) {
                linesToCheck.add(String.valueOf(row));
            }
        }
        
        for (String string : linesToCheck) {
            Integer initialCount = string.length();
            Integer forwardsMissing = string.replaceAll(forwards, "").length();
            Integer backwardsMissing = string.replaceAll(backwards, "").length();
            
            xMasCount[0] += initialCount != forwardsMissing ? (initialCount-forwardsMissing)/forwards.length() : 0;
            xMasCount[1] += initialCount != backwardsMissing ? (initialCount-backwardsMissing)/backwards.length() : 0;
            
        }
        
        
       

        return xMasCount;
    }

    public Integer[] getInstancesInDiagonals() {
        Integer[] xMasCount = {0, 0};
        List<String> linesToCheck = new ArrayList<>();
        
        return xMasCount;
    }
}
