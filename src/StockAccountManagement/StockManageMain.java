package StockAccountManagement;

import java.util.Scanner;

public class StockManageMain {
    public static void main(String[] args) {
        System.out.println("------Welcome To Stock Management System-------");
        Scanner sc = new Scanner(System.in);
        StockServices stocks = new StockServices();
        int input;

        do{
            System.out.println("Press 1 to Add Stocks\n" +
                    "Press 2 To Display Stocks\n" +
                    "Press 3 To Debit Amount\n" +
                    "Press 4 To Buy Stocks" +
                    "\nPress 5 For Purchase History" +
                    "\nPress 6 To Exit");

            input = sc.nextInt();

            switch(input){

                case 1:{

                    stocks.addStock();
                    break;

                }

                case 2:{

                    stocks.stockReport();
                    stocks.eachStockValue();
                    break;
                }

                case 3:{
                    System.out.println("Enter How Many Stock You Want To Sell: ");
                    int noOfShare = sc.nextInt();
                    System.out.println("Enter The Stock Name: ");
                    String nameOfShare = sc.next();
                    boolean update = stocks.debit(noOfShare,nameOfShare);
                    if(update){
                        System.out.println("Amount Debited Successfully");
                    }
                    else {
                        System.out.println("Stocks Are Not Present in Your Portfolio");
                    }

                    break;
                }
                case 4: {
                    System.out.println("Enter How Many Stock You Want To Buy: ");
                    int noOfShare = sc.nextInt();
                    System.out.println("Enter The Stock Name: ");
                    String nameOfShare = sc.next();
                    boolean update = stocks.credit(noOfShare,nameOfShare);
                    if(update){
                        System.out.println("Amount Credited Successfully");
                    }
                    else {
                        System.out.println("Stock Not Present in Your Portfolio || Check Stock Name");
                    }

                    break;
                }

                case 5:{
                    stocks.purchaseHistory();
                    break;
                }

                case 6:{

                    System.out.println(" || Application Closed || ");
                }

                default:{
                    System.out.println("Enter Correct Input Choice");
                }
            }
        }while (input != 6);
    }
}
