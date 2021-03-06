/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exchange;

/**
 *
 * @author lotos
 */


public class Exchange {

    public static void main(String[] args) {

        // Inital prices array
        int priceArray[] = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94};
        for (Integer iPrice = 0; iPrice < priceArray.length; iPrice++) {
            String s = Integer.toString(priceArray[iPrice]);
            System.out.print(s + "," + " ");
        }
        
        // Create delta price array
        Integer priceDelta[] = new Integer[priceArray.length - 1];
        for (int i = 0; i < priceDelta.length; i++) {
            priceDelta[i] = priceArray[i + 1] - priceArray[i];
            String s = Integer.toString(priceDelta[i]);
        }

        int firstDayNumbers = 0, lastDayNumbers = 0, earningNumbers = 0,
                firstDay = 0, lastDay = 0, earnings = 0;
        
        // 
        for (int i = 0; i < priceDelta.length; ++i) {
            int newDelta = priceDelta[i];
            if (firstDayNumbers == 0) {
                firstDayNumbers = i; lastDayNumbers = i + 1;
                earningNumbers = newDelta;
            } else {
                earningNumbers = earningNumbers + newDelta;
                ++lastDayNumbers;
            }
            if (earningNumbers <= 0) {
                firstDayNumbers = 0; lastDayNumbers = 0;
                earningNumbers = 0;
            } else if (earningNumbers > earnings) {
                firstDay = firstDayNumbers;
                lastDay = lastDayNumbers;
                earnings = earningNumbers;
            }
        }
        System.out.print("\nPurchase: day " + Integer.toString(firstDay + 1) + 
                " for " + Integer.toString(priceArray[firstDay]) +
                ";\nSale: day " + Integer.toString(lastDay + 1)  +
                " for " + Integer.toString(priceArray[lastDay]) + ";\n");
        System.out.print("Earnings: " + Integer.toString(earnings));
    }
}
