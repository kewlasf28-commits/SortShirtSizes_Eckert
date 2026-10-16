/*
 * Name: Allison Eckert
 * Course: CIS 171 - Java Programming
 * Instructor: Karen Lentz-O'Loughlin
 * Assignment: Sort Shirt Sizes
 * Date: October 16, 2026
 *
 * Description:
 * This program reads shirt orders from an online text file
 * and separates customers into four files based on size.
 *
 * Extra Credit:
 * 1. Remove shirt sizes from customer names.
 * 2. Remove commas from customer names.
 *
 * Sources:
 * - DMACC CIS 171 assignment instructions.
 * - OpenAI ChatGPT assisted with code placement.
 */

import java.io.*;
import java.net.URL;

public class SortShirtSizesEckert{
    public static void main(String[] args) {

        String fileURL =
                "https://bbmedia.dmacc.edu/CIS/CIS171/shirtsizes.txt";

        int small = 0;
        int medium = 0;
        int large = 0;
        int extraLarge = 0;

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new URL(fileURL).openStream()));

                PrintWriter smallFile =
                        new PrintWriter("smallshirts.txt");

                PrintWriter mediumFile =
                        new PrintWriter("mediumshirts.txt");

                PrintWriter largeFile =
                        new PrintWriter("largeshirts.txt");

                PrintWriter extraLargeFile =
                        new PrintWriter("extralargeshirts.txt")
        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length == 3) {

                    String size = parts[0].trim();

                    // Extra credit: remove size and commas
                    String name = parts[1].trim() + " "
                            + parts[2].trim();

                    switch (size) {

                        case "S":
                            smallFile.println(name);
                            small++;
                            break;

                        case "M":
                            mediumFile.println(name);
                            medium++;
                            break;

                        case "L":
                            largeFile.println(name);
                            large++;
                            break;

                        case "XL":
                            extraLargeFile.println(name);
                            extraLarge++;
                            break;

                        default:
                            System.out.println(
                                    "Unknown size: " + size);
                    }
                }
            }

            System.out.println("Shirt orders sorted successfully!");
            System.out.println();

            System.out.println("Small shirts: " + small);
            System.out.println("Medium shirts: " + medium);
            System.out.println("Large shirts: " + large);
            System.out.println("Extra large shirts: " + extraLarge);

            System.out.println();
            System.out.println("All four text files were created.");

        } catch (IOException e) {

            System.out.println(
                    fileURL + " is not available.");
        }
    }
}

