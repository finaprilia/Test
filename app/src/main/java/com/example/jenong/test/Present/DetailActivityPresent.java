package com.example.jenong.test.Present;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jenong.test.API.AppController;
import com.example.jenong.test.API.Const;
import com.example.jenong.test.Interface.DetailActivityInput;
import com.example.jenong.test.Interface.DetailActivityOutput;
import com.example.jenong.test.Model.DATADETAIL;
import com.example.jenong.test.Model.DetailActivityModel;
import com.example.jenong.test.Model.RootObject;
import com.example.jenong.test.Model.RootObjectDetail;
import com.example.jenong.test.View.UtamaActivity;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by gits on VIP.
 * Present for process
 */
public class DetailActivityPresent implements DetailActivityInput {
    public DetailActivityOutput output;
    private String tag_json_array="jarray_req";
    private String TAG= DetailActivityPresent.class.getSimpleName();

    @Override
    public void doSomething(String strA, String strB) {
        DetailActivityModel response = new DetailActivityModel();
        response.setVarA(strA);
        response.setVarB(strB);
        output.displaySomething(response);
    }


    @Override
    public void makeJsonDetail(String nomer) {
        Log.e(TAG, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA: "+nomer );
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
                "http://dev.gits.co.id/apiecommerce/public/index.php/list/"+nomer , null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        RootObjectDetail dataDetail = new Gson().fromJson(response.toString(), RootObjectDetail.class);
                        output.displayDetail(dataDetail.getDATA());
//                        output.displaySizeSpek(dataDetail.getDATA().getUkuran().getAvailable());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error : " + error.getMessage());
                output.displayError("Maaf Error 2");
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_array);
    }


}