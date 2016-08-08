package com.example.jenong.test.Present;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jenong.test.API.AppController;
import com.example.jenong.test.API.Const;
import com.example.jenong.test.Interface.UtamaActivityInput;
import com.example.jenong.test.Interface.UtamaActivityOutput;
import com.example.jenong.test.Model.DATA;
import com.example.jenong.test.Model.RootObject;
import com.example.jenong.test.Model.UtamaActivityModel;
import com.example.jenong.test.View.UtamaActivity;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by gits on VIP.
 * Present for process
 */
public class UtamaActivityPresent implements UtamaActivityInput {
    public UtamaActivityOutput output;
    private String tag_json_array="jarray_req";
    private String TAG= UtamaActivity.class.getSimpleName();

    @Override
    public void doSomething(String strA, String strB) {
        UtamaActivityModel response = new UtamaActivityModel();
        response.setVarA(strA);
        response.setVarB(strB);
        output.displaySomething(response);
    }

    @Override
    public void makeJsonSatu() {
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
                Const.URL_API_UTAMA, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        RootObject rootObject = new Gson().fromJson(response.toString(), RootObject.class);
                        output.displayUtama(rootObject.getDATA());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error : " + error.getMessage());
                output.displayError("Tidak ada koneksi");
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_array);
    }

//    @Override
//    public void makeJsonFilter() {
//        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
//                Const.URL_API_UTAMA, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        RootObject rootObject = new Gson().fromJson(response.toString(), RootObject.class);
//                        output.displayFilter(rootObject.getDATA());
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error : " + error.getMessage());
//                output.displayError("Tidak ada koneksi");
//            }
//        });
//
//        AppController.getInstance().addToRequestQueue(req, tag_json_array);
//    }

}

