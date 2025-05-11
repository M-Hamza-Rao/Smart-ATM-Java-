import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


class CsvFunctions{
    public static String readCsv(String acc_num, String pass) {
        String isMatch = "false";
        int i=0;

        try {
            Scanner sc = new Scanner(new File("src/Data.csv"));
            sc.useDelimiter(",|\\n"); // sets the delimiter pattern to comma or newline

            while (sc.hasNextLine()) {
                String accountNumber = sc.next();
                String password = sc.next();
                sc.nextLine(); // consume the rest of the line

                if (accountNumber.equals(acc_num) && password.equals(pass)) {
                    //System.out.println(i);
                    isMatch = String.valueOf(i);
                    break;
                }
                i++;
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return isMatch;
    }

    public static String readCsvRow(int rowNumber){
        String csvFile = "src/Data.csv"; // Index of the row to read (zero-based)
        String[] rowData = null;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                if (lineNumber == rowNumber) {
                    rowData = line.split(",");
                    break;
                }
                lineNumber++;
            }
        } catch (Exception e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

        // Output the data from the row
        int i=0;
        String str="";
        if (rowData != null) {
            for (String value : rowData) {
                //System.out.print(value + "+");
                if(i!=5){
                    str= str + value+"+";
                }
                else{
                    str=str+ value;
                }
                i++;
            }
        } else {
            System.out.println("Row " + rowNumber + " not found.");
        }
        return str;
    }

    public static void overWriteCell(int row, int column, String value) throws IOException {
        String filePath = "src/Data.csv";
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        String[] cells = lines.get(row).split(",");
        cells[column] = value;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            sb.append(cells[i]);
            if (i < cells.length - 1) {
                sb.append(",");
            }
        }

        lines.set(row, sb.toString());

        Files.write(Paths.get(filePath), lines);
    }


    public static void deleteRow(int rowNum) throws IOException {
        // Read all lines from the CSV file into a list
        String filePath = "src/Data.csv";
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Delete the row at the given index
        lines.remove(rowNum);

        // Write the updated list of lines back to the CSV file
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (String line : lines) {
            writer.write(line + "\n");
        }
        writer.close();
    }


    public static String readCell(int row, int col) throws IOException {
        String fileName = "src/Data.csv";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        int currentRow = 0;
        while ((line = br.readLine()) != null) {
            if (currentRow == row) {
                StringTokenizer st = new StringTokenizer(line, ",");
                int currentCol = 0;
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    if (currentCol == col) {
                        br.close();
                        return token;
                    }
                    currentCol++;
                }
            }
            currentRow++;
        }
        br.close();
        return null;
    }


    public static void addNewAccount(String name, String email, String id) throws IOException {

        // Generate account number
        String acc_num = "AI-k22-" + id;

        // Set default values
        String pass = "0000";
        double balance = 0.0;
        boolean locked = false;

        // Create new row string
        String newRow = String.format("%s,%s,%s,%.2f,%s,%s", acc_num, pass, name, balance, email, locked);

        // Write new row to CSV file
        FileWriter csvWriter = new FileWriter("src/Data.csv", true); // 'true' parameter appends to file instead of overwriting it
        csvWriter.append("\n"); // add new line
        csvWriter.append(newRow);
        csvWriter.flush();
        csvWriter.close();
    }





    public static boolean searchCsv(String id, int column) {
        String csvFilePath = "src/Data.csv";
        String delimiter = ",";
        BufferedReader br = null;
        String line = "";
        boolean found = false;
        try {
            br = new BufferedReader(new FileReader(csvFilePath));
            while ((line = br.readLine()) != null) {
                String[] row = line.split(delimiter);
                if (row[column].equals(id)) {
                    found = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return found;
    }


    public static String getRowNum(String acc_num) {
        String isMatch = "false";
        int i=0;

        try {
            Scanner sc = new Scanner(new File("src/Data.csv"));
            sc.useDelimiter(",|\\n"); // sets the delimiter pattern to comma or newline

            while (sc.hasNextLine()) {
                String accountNumber = sc.next();
                sc.nextLine(); // consume the rest of the line

                if (accountNumber.equals(acc_num)) {
                    //System.out.println(i);
                    isMatch = String.valueOf(i);
                    break;
                }
                i++;
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return isMatch;
    }


}














