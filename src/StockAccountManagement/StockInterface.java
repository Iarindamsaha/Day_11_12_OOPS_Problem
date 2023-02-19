package StockAccountManagement;

interface StockInterface {
    public void addStock();
    public void stockReport();
    public void eachStockValue();
    public boolean debit(int noOfShare,String nameOsStock);
    public boolean credit(int noOfShare,String nameOsStock);
    public void purchaseHistory();
    public String time();
}
