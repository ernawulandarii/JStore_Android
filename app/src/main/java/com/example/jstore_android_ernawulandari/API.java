package com.example.jstore_android_ernawulandari;

public interface API {
    final String IP = "192.168.43.10";
    final String PORT = ":8080";

    // String base = "http://192.168.43.10:8080/";
    final String loginURL = "http://" +IP + PORT +"/logincust/";
    final String Regis_URL = "http://" +IP + PORT +"/newcustomer/";
    final String itemsURL = "http://" +IP + PORT +"/items/";
    final String createPaidURL = "http://" +IP + PORT +"/createpaid/";
    final String createUnpaidURL = "http://" +IP + PORT +"/createunpaid/";
    final String createInstallmentURL = "http://" +IP + PORT +"createinstallment";
    final String Invoice_URL = "http://" +IP + PORT +"/invoice/";
    final String finish_URL = "http://" +IP + PORT +"/finishtransaction/";
    final String cancel_URL = "http://" +IP + PORT +"/canceltransaction/";
    final String Fetch_URL = "http://" +IP + PORT +"/invoicecustomer/";

}
