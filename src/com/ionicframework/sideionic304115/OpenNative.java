package com.ionicframework.sideionic304115;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

import foxit.ui.FileBrowserActivity;

/**
 * Created by snyxius on 11/3/16.
 */
public class OpenNative extends CordovaPlugin {

    /**
     * Executes the request and returns a boolean.
     *
     * @param action
     *            The action to execute.
     * @param args
     *            JSONArry of arguments for the plugin.
     * @param callbackContext
     *            The callback context used when calling back into JavaScript.
     * @return boolean.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("open")) {
            try {
                openN();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else {
        }
        return true;
    }
    private void openN() throws IOException {

      Intent  intent = new Intent(this.cordova.getActivity().getApplicationContext(), FileBrowserActivity.class);

        this.cordova.getActivity().startActivityForResult(intent,0);
        this.cordova.getActivity().startActivity(intent);
        this.cordova.getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

}
