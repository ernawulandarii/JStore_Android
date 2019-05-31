package com.example.jstore_android_ernawulandari;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class InvoiceFetchRequest extends StringRequest {
    public InvoiceFetchRequest(int id, Response.Listener<String> listener){
        super(Method.GET, API.Invoice_URL+"/"+id, listener, null);
    }
}
