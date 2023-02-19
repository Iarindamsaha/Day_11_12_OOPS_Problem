package StockAccountManagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StockServices {
    ArrayList<StockPortfolio> stockList = new ArrayList<>();

    StockPortfolio stocks;
    Scanner sc = new Scanner(System.in);

    public void addStock(){

        System.out.println("Enter Share Name");
        String shareName = sc.next();

        System.out.println("Enter Number Of Shares Bought");
        int numberOfShare = sc.nextInt();

        System.out.println("Enter The Stock Price");
        int sharePrice = sc.nextInt();

        stocks = new StockPortfolio(sharePrice,shareName,numberOfShare);
        stockList.add(stocks);

    }

    public void stockReport(){

        int sum = 0;
        for (StockPortfolio stock : stockList){
                sum += stock.getNumberOfShare()*stock.getSharePrice();
            }
        System.out.println(stockList);
        System.out.println("Total Stock Bought : " +sum);
    }

    public void eachStockValue(){

        for(StockPortfolio stock : stockList){

            int eachValue = stock.getNumberOfShare() * stock.getSharePrice();
            System.out.println("Stock Name : " + stock.getShareName() +" "+ "Total Value : "+eachValue);
        }
    }

    public boolean debit(int noOfShare,String nameOsStock){

        for (int i = 0 ; i < stockList.size(); i++){
            if(stockList.get(i) != null && stockList.get(i).getShareName().equalsIgnoreCase(nameOsStock) &&  noOfShare < stockList.get(i).getNumberOfShare()){
                int debited = noOfShare * stockList.get(i).getSharePrice();
                stockList.get(i).setNumberOfShare(stockList.get(i).getNumberOfShare() - noOfShare);
                System.out.println("Shares Sold : " + noOfShare +" "+"Date And Time : " + time());
                System.out.println("Debited Amount : " + debited);
                return true;
            }

        }
        return false;
    }

    public boolean credit(int noOfShare,String nameOsStock){

        for (int i = 0 ; i < stockList.size(); i++){
            if(stockList.get(i) != null && stockList.get(i).getShareName().equalsIgnoreCase(nameOsStock)){
                int credited = noOfShare * stockList.get(i).getSharePrice();
                stockList.get(i).setNumberOfShare(stockList.get(i).getNumberOfShare() + noOfShare);
                System.out.println("Shares Bought : " + noOfShare +" "+"Date And Time : " + time());
                System.out.println("Amount Credited : " + credited);
                return true;
            }

        }
        return false;
    }

    public String time()
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(date);
    }
        

}
