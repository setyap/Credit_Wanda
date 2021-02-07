package com.example.creditwahana;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.creditwahana.Model.Login.LoginData;

import java.util.HashMap;

public class SessionManager {

    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String IS_LOGGED_IN = "isLoggedIn";
    private static final String ID_USER = "id_user";
    private static final String USERNAME = "username";
    private static final String NAME = "name";
    private static final String JABATAN = "jabatan";

    public SessionManager(Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID_USER, user.getIdUser());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(NAME, user.getName());
        editor.putString(JABATAN, user.getJabatan());
        editor.commit();
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(ID_USER, sharedPreferences.getString(ID_USER, null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));
        user.put(NAME, sharedPreferences.getString(NAME, null));
        user.put(JABATAN, sharedPreferences.getString(JABATAN, null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);

    }
    public String getJabatan(){
        HashMap<String, String> user = getUserDetail();
        Log.d("XXXTAG", "getJABATAN : " +user.get(SessionManager.JABATAN));
        return user.get(SessionManager.JABATAN);
    }

}
