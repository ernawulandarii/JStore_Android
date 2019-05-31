package com.example.jstore_android_ernawulandari;


import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PesananFetchRequest extends StringRequest {

    public PesananFetchRequest(int id, Response.Listener<String> listener) {
        super(Method.GET, API.Fetch_URL, listener, null);
        Log.d("url", "PesananFetchRequest: "+ API.Fetch_URL);
    }
}

class PesananBatalRequest extends StringRequest {
    private Map<String, String> params;

    public PesananBatalRequest(String id, Response.Listener<String> listener) {
        super(Method.POST, API.cancel_URL, listener, null);
        params = new HashMap<>();
        params.put("idinvoice",id);
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}

class PesananSelesaiRequest extends StringRequest {
    private Map<String, String> params;

    public PesananSelesaiRequest(String id, Response.Listener<String> listener) {
        super(Method.POST, API.finish_URL, listener, null);
        params = new HashMap<>();
        params.put("idinvoice",id);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
