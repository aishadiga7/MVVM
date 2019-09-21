package com.example.myapplication.data;

import android.os.AsyncTask;

import com.example.myapplication.model.User;

import java.util.HashMap;

/*
This class will iomplement the repository interface and doers the actual logic of it
 */
public class MainRepositoryImpl implements Repository {

    // this hashmap mocks the shared preference
    private static HashMap<String,Object> preference = new HashMap<>();
    private static boolean mockError = false; // just a flag to mock error



    /*
    This method intercats with the backend server and gets the login result
     */

    @Override
    public void login(String usename, String password, final Callback<User> callback) {
        // mocking api call

       // do it inside an asynktask so that we wont block mainthread

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if(mockError && callback!=null)
                    callback.onError(new Throwable("Login failed"));


                if (callback != null && !mockError) {
                    User user = new User();
                    user.firstName = "Aishwarya";
                    user.lastName = "Adiga";
                    callback.onSuccess(user);
                }
            }
        }.execute();

    }

    @Override
    public void saveUser(User user) {
       preference.put(PreferenceKeys.USER,user);
    }

    @Override
    public void getUser() {
        preference.get(PreferenceKeys.USER);
    }


    public static class PreferenceKeys{
        public static final String USER= "user";
    }
}
