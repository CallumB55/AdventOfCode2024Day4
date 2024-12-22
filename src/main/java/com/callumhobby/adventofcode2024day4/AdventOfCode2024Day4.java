/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.callumhobby.adventofcode2024day4;

/**
 *
 * @author CallumBinns
 */
public class AdventOfCode2024Day4 {
    
    public static void main(String[] args) {
        InputReader in = new InputReader("src\\main\\java\\com\\callumhobby\\adventofcode2024day4\\Input.txt");
        CrosswordGrid grid = new CrosswordGrid(in.getLines());
        Integer[] xMasCount = grid.getInstancesInDiagonals();
        Integer[] rowsCount = grid.getInstancesInRowsOrColumns(false);
        xMasCount[0] += rowsCount[0];
        xMasCount[1] += rowsCount[1];
        Integer[] columnsCount = grid.getInstancesInRowsOrColumns(true);
        xMasCount[0] += columnsCount[0];
        xMasCount[1] += columnsCount[1];


        System.out.println("Total count: "+String.valueOf(xMasCount[0]+xMasCount[1]));
        String[] newPair = {"MAS","SAM"};
        grid.switchSearchStrings(newPair);
        System.out.println("Total count of mas in x shape: "+String.valueOf(grid.masInXShapeCount()));
    }
}
