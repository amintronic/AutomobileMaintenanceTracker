package com.ameen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class userService {
    public static List<usersMaintenance> getAllUsers(){

        List<usersMaintenance> userList = null;
        try {
            File file = new File("/Users/ameen/Users.dat");
            if (!file.exists()) {
                userList = new ArrayList<usersMaintenance>();
                userList.add(new usersMaintenance(1, "Tesla", "G23","Electric",
                        "2014", "NE123", "21234123", 10,  ""));
                userList.add(new usersMaintenance(2, "BMW", "RT4","Gas",
                        "2013", "NE345", "23423424", 10, ""));
                userList.add(new usersMaintenance(3, "Peugeot", "207i","Diesel",
                        "2010", "NE567", "45645645", 10, ""));
                userList.add(new usersMaintenance(4, "Apple", "A4", "Electric",
                        "2018", "NE789", "30503450", 10, ""));
                saveUserList(userList);
            }
            else {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                userList = (List<usersMaintenance>) ois.readObject();
                ois.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }
    private static void saveUserList(List<usersMaintenance> userList){
        try {
            File file = new File("/Users/ameen/Users.dat");
            FileOutputStream fos;
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveNewUser(usersMaintenance new_user){
        List<usersMaintenance> userList = null;
        try {
            File file = new File("/Users/ameen/Users.dat");
            if (!file.exists()) {
//                userList = new ArrayList<usersMaintenance>();
//                userList.add(new usersMaintenance(1, "Tesla", "G23","Electric",
//                        "2014", "NE123", "21234123", 5000,  "Comment"));
//                userList.add(new usersMaintenance(2, "BMW", "RT4","Gas",
//                        "2013", "NE345", "23423424", 5800, "Comment"));
//                userList.add(new usersMaintenance(3, "Peugeot", "207i","Diesel",
//                        "2010", "NE567", "45645645", 3000, "Comment"));
//                userList.add(new usersMaintenance(4, "Apple", "A4", "Electric",
//                        "2018", "NE789", "30503450", 2600, "Comment"));
//                saveUserList(userList);
            }
            else {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                userList = (List<usersMaintenance>) ois.readObject();
                ois.close();

                new_user.set_id(userList.size()+1);
                userList.add(new_user);
                saveUserList(userList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void updateSingleUser(usersMaintenance new_user){
        List<usersMaintenance> userList = null;
        List<usersMaintenance> userList_new = new ArrayList<usersMaintenance>();
        try {
            File file = new File("/Users/ameen/Users.dat");
            if (!file.exists()) {
                //error : file not existed!
            }
            else {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                userList = (List<usersMaintenance>) ois.readObject();
                ois.close();

                for (int i = 0; i < userList.size(); i++) {
                    if(userList.get(i).get_make().equals(new_user.get_make())){
                        if(userList.get(i).get_model().equals(new_user.get_model())){
                            if(userList.get(i).get_type().equals(new_user.get_type())){
                                if(userList.get(i).get_year().equals(new_user.get_year())){
                                    if(userList.get(i).get_license_no().equals(new_user.get_license_no())){
                                        if(userList.get(i).get_vin().equals(new_user.get_vin())){
                                            new_user.set_id(i + 1);

                                            switch (new_user.get_type()) {
                                                case "Electric": {
                                                    String tmp = new car_electric(new_user.get_odometer()).get_maintenance();
                                                    check_maintenance(new_user, tmp);
                                                    break;
                                                }
                                                case "Gas": {
                                                    String tmp = new car_gas(new_user.get_odometer()).get_maintenance();
                                                    check_maintenance(new_user, tmp);
                                                }
                                                case "Diesel": {
                                                    String tmp = new car_diesel(new_user.get_odometer()).get_maintenance();
                                                    check_maintenance(new_user, tmp);
                                                }
                                            }

                                            userList_new.add(new_user);
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    userList_new.add(userList.get(i));
                }

                saveUserList(userList_new);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void check_maintenance(usersMaintenance new_user, String tmp) {
        if(!new_user.get_maintenance().equals("")){
            if(!tmp.equals(""))
                new_user.set_maintenance(new_user.get_maintenance() + "<br>\n" + tmp);}
        else
            new_user.set_maintenance(tmp);
        return;
    }

    public static void removeSingleUser(usersMaintenance new_user){
        List<usersMaintenance> userList = null;
        List<usersMaintenance> userList_new = new ArrayList<usersMaintenance>();
        try {
            File file = new File("/Users/ameen/Users.dat");
            if (!file.exists()) {
                //error : file not existed!
            }
            else {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                userList = (List<usersMaintenance>) ois.readObject();
                ois.close();

                for (int i = 0; i < userList.size(); i++) {
                    if(userList.get(i).get_make().equals(new_user.get_make())){
                        if(userList.get(i).get_model().equals(new_user.get_model())){
                            if(userList.get(i).get_type().equals(new_user.get_type())){
                                if(userList.get(i).get_year().equals(new_user.get_year())){
                                    if(userList.get(i).get_license_no().equals(new_user.get_license_no())){
                                        if(userList.get(i).get_vin().equals(new_user.get_vin())){

                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    userList_new.add(userList.get(i));
                }

                saveUserList(userList_new);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
