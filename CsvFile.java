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
  float sum = 0;

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
      sum = 0;
      BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
      String lastLine = null;
      String line = br.readLine();
      lastLine = line;
      line = br.readLine();
      System.out.println("\nIndex,Date,Category,Amount,Description");
      while (line != null) {
          lastLine = line;
          line = br.readLine();
          String[] values = lastLine.split(",");
          float f = Float.parseFloat(values[3]);
          sum = sum + f;
          System.out.println(lastLine);  
      }
      System.out.println("\nTotal amount spent = " + sum);
      if (lastLine == null) {
        throw new IOException("File is empty.");
      }
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  void displaySelect(String val, int in){
    try{
      sum = 0;
      BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
      String lastLine = null;
      String line = br.readLine();
      while (line != null) {
          lastLine = line;
          line = br.readLine();
          String[] values = lastLine.split(",");
          if (val.equals(values[in])){
            float f = Float.parseFloat(values[3]);
            sum = sum + f;
            System.out.println(lastLine);  
          }
      }
      if (lastLine == null) {
        throw new IOException("File is empty.");
      }
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  void displayCategory(String cat) {
    System.out.println("\nIndex,Date,Category,Amount,Description");
    displaySelect(cat, 2);
    System.out.println("\nTotal amount of money spent in this category = " + sum);
  }

  void displayIndex(String i) {
    System.out.println("\nIndex,Date,Category,Amount,Description");
    displaySelect(i, 0); 
  }

  void displayLesserAmount(float am){
    try{
      sum = 0;
      BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
      String lastLine = null;
      String line = br.readLine();
      lastLine = line;
      line = br.readLine();
      System.out.println("\nIndex,Date,Category,Amount,Description");
      while (line != null) {
          lastLine = line;
          line = br.readLine();
          String[] values = lastLine.split(",");
          float f = Float.parseFloat(values[3]);
          if (f<=am){
            sum = sum + f;
            System.out.println(lastLine);  
          }
      }
      System.out.println("\nTotal amount of money spent here = " + sum);
      if (lastLine == null) {
        throw new IOException("File is empty.");
      }
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  void displayGreaterAmount(float am){
    try{
      sum = 0;
      BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
      String lastLine = null;
      String line = br.readLine();
      lastLine = line;
      line = br.readLine();
      System.out.println("\nIndex,Date,Category,Amount,Description");
      while (line != null) {
          lastLine = line;
          line = br.readLine();
          String[] values = lastLine.split(",");
          float f = Float.parseFloat(values[3]);
          if (f>=am){
            sum = sum + f;
            System.out.println(lastLine);  
          }
      }
      System.out.println("\nTotal amount of money spent here = " + sum);
      if (lastLine == null) {
        throw new IOException("File is empty.");
      }
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  void displayInYear(int year){
    try{
      sum = 0;
      BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
      String lastLine = null;
      String line = br.readLine();
      lastLine = line;
      line = br.readLine();
      System.out.println("\nIndex,Date,Category,Amount,Description");
      while (line != null) {
          lastLine = line;
          line = br.readLine();
          String[] values = lastLine.split(",");
          String[] x = (values[1]).split("/");
          int y = Integer.parseInt(x[2]);
          if (year==y){
            float f = Float.parseFloat(values[3]);
            sum = sum + f;
            System.out.println(lastLine);  
          }
      }
      System.out.println("\nTotal amount of money spent in this year = " + sum);
      if (lastLine == null) {
        throw new IOException("File is empty.");
      }
    } catch (IOException e){
      e.printStackTrace();
    }
  }
  void displayInMonth(int year, int month){
    try{
      sum = 0;
      BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
      String lastLine = null;
      String line = br.readLine();
      lastLine = line;
      line = br.readLine();
      System.out.println("\nIndex,Date,Category,Amount,Description");
      while (line != null) {
          lastLine = line;
          line = br.readLine();
          String[] values = lastLine.split(",");
          String[] x = (values[1]).split("/");
          int y = Integer.parseInt(x[2]);
          int m = Integer.parseInt(x[1]);
          if (year==y && month ==m){
            float f = Float.parseFloat(values[3]);
            sum = sum + f;
            System.out.println(lastLine);  
          }
      }
      System.out.println("\nTotal amount of money spent in this year = " + sum);
      if (lastLine == null) {
        throw new IOException("File is empty.");
      }
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
              System.out.println("4) Display expenses based on index");
              System.out.println("5) Display expense with amount less than equal to");
              System.out.println("6) Display expense with amount greater than equal to");
              System.out.println("7) Display expenses in given year");
              System.out.println("8) Display expenses in given month of given year");
              System.out.println("9) Exit\n");
              System.out.print("Enter your choice : ");
              String x = breader.readLine();
              int choice = Integer.parseInt(x);
              if(choice==9) {
                break;
              }
              else if (choice == 1){
                bwriter.write(func.dataInput());
                break;
              } 
              switch (choice){
                
                case 2:
                  func.displayAll();
                  break;

                case 3:
                  System.out.print("Enter category name : ");
                  String cat = breader.readLine();
                  func.displayCategory(cat);
                  break;

                case 4:
                  System.out.print("Enter index number : ");
                  String i = breader.readLine();
                  func.displayIndex(i);
                  break;

                case 5:
                  System.out.print("Enter amount : ");
                  String a = breader.readLine();
                  float am = Float.parseFloat(a);
                  func.displayLesserAmount(am);  
                  break;

                case 6:
                  System.out.print("Enter amount : ");
                  a = breader.readLine();
                  am = Float.parseFloat(a);
                  func.displayGreaterAmount(am);  
                  break;

                case 7:
                  System.out.print("Enter year : ");
                  a = breader.readLine();
                  int year = Integer.parseInt(a);
                  func.displayInYear(year);

                case 8:
                  System.out.print("Enter year : ");
                  a = breader.readLine();
                  year = Integer.parseInt(a);
                  System.out.print("Enter month : ");
                  a = breader.readLine();
                  int month = Integer.parseInt(a);
                  func.displayInMonth(year, month);
              } 
            }
            bwriter.close();
            System.out.println("CSV file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
      }
    
}
