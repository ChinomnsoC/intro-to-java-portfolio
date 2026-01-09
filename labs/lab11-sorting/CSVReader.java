/*
 * Copyright (c) 2020.
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/4.0/ or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 * This CSVReader class has been borrowed from the 163/164 Knight Fight lab
 * */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This reader was implemented in practical 4, feel free to use that  version.
 */
public class CSVReader {
    private static final char DELIMINATOR = ',';
    private Scanner fileScanner;

    /**
     * Basic overloaded constructor that assumes the first line should be skipped.
     * @param file name of file to read
     */
    public CSVReader(String file) {
        this(file, true);
    }

    /**
     * A constructor that requires the name of the file to open
     * @param file filename to read
     * @param skipHeader true to skip header, false if it is to be read
     */
    public CSVReader(String file, boolean skipHeader) {
        try {
            fileScanner = new Scanner(new File(file));
            if(skipHeader) this.getNext();
        }catch (IOException io) {
            System.err.printf("File %s not found%n", file);
            System.exit(1);

        }
    }

    /**
     * Reads a line (nextLine()) and splits it into a String array by the DELIMINATOR, if the line is
     * empty it will also return null.
     * @return a String List if a line exits or null if not
     */
    public List<String> getNext() {
        // TAs this is not the student solution (just the the "proper" implementation that deals with quoted strings) students
        // are allowed to just conver the String using .split(), we don't have to worry about quoted strings
        // in the files. using the typical student solution will be as follows:
        // als this is the one method a student could actually change to keep it String[] as the return,
        // and it won't affect our grading. This is left over between updates.
       /*
       if(hasNext()) {
         String toSplit= fileScanner.nextLine();
         return Arrays.asList(toSplit.split(DELIMINATOR));
       }// else
       return null;
       */

        if(hasNext()){
            String toSplit = fileScanner.nextLine();
            List<String> result = new ArrayList<>();
            int start = 0;
            boolean inQuotes = false;
            for (int current = 0; current < toSplit.length(); current++) {
                if (toSplit.charAt(current) == '\"') { // the char uses the '', but the \" is a simple "
                    inQuotes = !inQuotes; // toggle state
                }
                boolean atLastChar = (current == toSplit.length() - 1);
                if (atLastChar) {
                    result.add(toSplit.substring(start).replace("\"", "")); // remove the quotes from the quoted item
                } else {
                    if (toSplit.charAt(current) == DELIMINATOR && !inQuotes) {
                        result.add(toSplit.substring(start, current).replace("\"", ""));
                        start = current + 1;
                    }
                }
            }
            return result;
        }
        return null;
    }

    /**
     * Checks to see if the fileScanner has more lines and returns the answer.
     * @return true if the file scanner has more lines (hasNext())
     */
    public boolean hasNext() {
        return (fileScanner != null) && fileScanner.hasNext();
    }



}