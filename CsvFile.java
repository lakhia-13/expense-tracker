import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;

class Functions extends CsvFile{
  String Index;
  String Dates;
  String Category;
  String Amount;
  String Description;
  String Entry;
  String csvFilePath = "data.csv";
  String delimiter = ",";
  
  String dataInput() throws IOException {
    BufferedWriter bwriter = new BufferedWriter(new FileWriter(csvFilePath, true));
    InputStreamReader ireader = new InputStreamReader(System.in);
    BufferedReader breader = new BufferedReader(ireader);
    BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
    System.out.print("Please enter the Category of expense : ");
    Category = breader.readLine();
    System.out.print("Please enter the Amount of expense : ");
    Amount = breader.readLine();
    System.out.print("Please enter the Description of expense : ");
    Description = breader.readLine();
    
    Date date = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
    Dates = DateFor.format(date);

    String lastLine = null;
    String line = br.readLine();
    while (line != null) {
          lastLine = line;
          line = br.readLine();
      }
    if (lastLine == null) {
        throw new IOException("File is empty.");
      }
    String[] values = lastLine.split(",");
    if (values[0].equals("Index")){
        Index = "1";
    } else {
        int i = Integer.parseInt(values[0]);
        i++;
        Index = String.valueOf(i);
    }
    
    Entry = Index + "," + Dates + "," + Category + "," + Amount + "," + Description + "\n";
    return Entry;
  }
  
  void displayAll(){
    try{
      Scanner sc = new Scanner(new FileReader(csvFilePath));
      sc.useDelimiter(" , ");
      // BufferedReader breader = new BufferedReader(new FileReader(csvFilePath));
      while (sc.hasNext()) {
        System.out.print(sc.next());
      }
      sc.close();
    } catch (IOException e){
      e.printStackTrace();
    }
  }
}


public class CsvFile{
    public static void main(String[] args) {
      String csvFilePath = "data.csv";
      
        try {
            BufferedWriter bwriter = new BufferedWriter(new FileWriter(csvFilePath, true));
            InputStreamReader ireader = new InputStreamReader(System.in);
            BufferedReader breader=new BufferedReader(ireader);
            Functions func = new Functions();

            // bwriter.write("Index,Date,Category,Amount,Description\n");
            // bwriter.write("1,10/8/2023,Food&Drinks,20.0,Canteen Samosa\n");
            // bwriter.write("2,11/8/2023,Food&Drinks,12.0,Canteen Tea\n");
            // bwriter.write("3,21/8/2023,Clothes,899.0,Polo Tshirt from Amazon\n");
            // bwriter.write("4,5/8/2023,Clothes,1099.0,Kurta from Suman\n");
            while (true){
              System.out.println("========================================================= EXPENSE TRACKER==========================================================\n");
              System.out.println("Choose action : ");

              System.out.println("1) Enter expense"); 
              System.out.println("2) Display all expenses");
              System.out.println("3) Display expenses based on category");
              System.out.println("4) Display expenses based on year");
              System.out.println("5) Display all based on year and month");
              System.out.println(") Exit\n");
              System.out.print("Enter your choice : ");
              String x = breader.readLine();
              int choice = Integer.parseInt(x);
              if(choice==6) break;
              switch (choice){
                
                case 1:
                  bwriter.write(func.dataInput());
                  break;
              
                case 2:
                  func.displayAll();
                  break;
              } 
            }
            bwriter.close();
            System.out.println("CSV file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
      }
    
}
