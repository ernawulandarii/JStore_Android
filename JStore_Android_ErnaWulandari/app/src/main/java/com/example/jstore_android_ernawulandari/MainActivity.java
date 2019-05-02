package com.example.jstore_android_ernawulandari;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Supplier> listSupplier = new ArrayList<>();
    private ArrayList<Item> listItem = new ArrayList<>();
    private HashMap<Supplier, ArrayList<Item>> childMapping = new HashMap<>();

    ExpandableListView exListView;

    MenuListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    protected void refreshList(){
        Response.Listener<String> responseListener = new Response.Listener<String>(){
            @Override
            public void onResponse(String response){
                try{
                    JSONArray jsonResponse = new JSONArray(response);
                    for(int i = 0; i< jsonResponse.length(); i++){
                        JSONObject supplier = jsonResponse.getJSONObject(i).getJSONObject("supplier");
                        JSONObject location = supplier.getJSONObject("location");
                        Location newLocation = new Location(
                                location.getString("province"),
                                location.getString("city"),
                                location.getString("description")
                        );
                        Supplier newSupplier = new Supplier(
                                supplier.getInt("id"),
                                supplier.getString("name"),
                                supplier.getString("email"),
                                supplier.getString("phoneNumber"),
                                newLocation
                        );
                        listSupplier.add(newSupplier);

                        JSONObject item = jsonResponse.getJSONObject(i);
                        Item newItem = new Item(
                                item.getInt("id"),
                                    item.getString("name"),
                                    item.getInt("price"),
                                    item.getString("category"),
                                    item.getString("status"),
                                    newSupplier

                            );
                            listItem.add(newItem);
                        childMapping.put(listSupplier.get(i), listItem);
                        listAdapter = new MenuListAdapter(MainActivity.this, listSupplier, childMapping);
                        exListView.setAdapter(listAdapter);

                    }


                } catch (JSONException e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Failed") .create() .show();
                }
            }
        };

    }
}

class MenuRequest extends StringRequest
{
    private static final String ItemsURL = "insert your New Customer API URL";

    public MenuRequest(Response.Listener<String> listener) {
        super(Request.Method.GET, ItemsURL, listener, null);
    }
}

class MenuListAdapter extends BaseExpandableListAdapter{
    private Context context;
    private ArrayList<Supplier> listDataHeader;
    private HashMap<Supplier, ArrayList<Item>> listDataChild;

    public MenuListAdapter(Context context, ArrayList<Supplier> listDataHeader,
                           HashMap<Supplier, ArrayList<Item>> listChildData) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}



