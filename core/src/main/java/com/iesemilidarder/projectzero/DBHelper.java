package com.iesemilidarder.projectzero;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// Classe per connectar a una base de dades i List dels restaturants
public class DBHelper {
    public List<Restaurants> getRestaurants(String cerca) {
        List<Restaurants> arrayRestaurants = new ArrayList();
        try {
            // Per fer la connexió a la base de dades
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");


            Statement stmt = con.createStatement();

            // Sentència SQL per treure la informació guardada a la base de dades
            ResultSet rs;
            if (cerca == null) {
                rs = stmt.executeQuery("SELECT RES_NOM, RES_ADRECA, RES_WEB, RES_TELEFON, TRS_DESCRIPCIO, RES_URL_IMG, RES_MITJANA, RES_CODI  FROM  RESTAURANTS , TRESTAURANTS WHERE ROWNUM <=5 AND TRS_CODI = RES_TRS_CODI ORDER BY RES_MITJANA DESC");
            } else {
                rs = stmt.executeQuery("SELECT RES_NOM, RES_ADRECA, RES_WEB, RES_TELEFON, TRS_DESCRIPCIO, RES_URL_IMG, RES_MITJANA, RES_CODI FROM  RESTAURANTS , TRESTAURANTS WHERE TRS_CODI = RES_TRS_CODI AND LOWER (RES_NOM) LIKE '%" + cerca.toLowerCase() + "%'");
            }
            while (rs.next()) {
                String name = rs.getString("RES_NOM");
                String address = rs.getString("RES_ADRECA");
                String website = rs.getString("RES_WEB");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");
                String images = rs.getString("RES_URL_IMG");
                String mitjana = rs.getString("RES_MITJANA");
                String code = rs.getString("RES_CODI");


                Restaurants std = new Restaurants();
                std.setName(name);
                std.setAddress(address);
                std.setWebsite(website);
                std.setTelephone(telephone);
                std.setType(type);
                std.setImages(images);
                std.setMitjana(mitjana);
                std.setCode(code);


                arrayRestaurants.add(std);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arrayRestaurants;
    }


    public static Restaurants loadRestaurant(String id) {
        Restaurants res = null;
        try {
            // Per fer la connexió a la base de dades
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");


            Statement stmt = con.createStatement();
            ResultSet rs;
            // Sentència SQL per treure la informació guardada a la base de dades

            rs = stmt.executeQuery("SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, T.TRS_DESCRIPCIO, R.RES_URL_IMG, R.RES_MITJANA, R.RES_CODI  FROM  RESTAURANTS R , TRESTAURANTS T WHERE TRS_CODI = RES_TRS_CODI AND RES_CODI ='" + id + "'");

            if (rs.next()) {
                String name = rs.getString("RES_NOM");
                String address = rs.getString("RES_ADRECA");
                String website = rs.getString("RES_WEB");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");
                String images = rs.getString("RES_URL_IMG");
                String mitjana = rs.getString("RES_MITJANA");
                String code = rs.getString("RES_CODI");


                res = new Restaurants();
                res.setName(name);
                res.setAddress(address);
                res.setWebsite(website);
                res.setTelephone(telephone);
                res.setType(type);
                res.setImages(images);
                res.setMitjana(mitjana);
                res.setCode(code);


            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return res;
    }

 public List<Comments> getComments(String comments) {
 List<Comments> arrayComments = new ArrayList();
 try {
 // Per fer la connexió a la base de dades
 Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

 Statement stmnt = con.createStatement();

 // Sentència SQL per treure la informació guardada a la base de dades
 ResultSet rs;
 rs = stmnt.executeQuery("select O.OPI_USU_CODI, O.OPI_CODI, O.OPI_PUNTUACIO, O.OPI_OBSERVACIO FROM OPINIONS O, RESTAURANTS R WHERE OPI_RES_CODI  = R.RES_CODI AND R.RES_CODI ='" + comments + "'");

 while (rs.next()) {
 String user = rs.getString("OPI_USU_CODI");
 String id = rs.getString("OPI_CODI");
 String puntu = rs.getString("OPI_PUNTUACIO");
 String comment = rs.getString("OPI_OBSERVACIO");

 Comments com = new Comments();
 com.setUser(user);
 com.setId(id);
 com.setPuntu(puntu);
 com.setComment(comment);


 arrayComments.add(com);
 }
 stmnt.close();
 con.close();

 } catch (Exception e) {
 System.out.println(e.toString());
 }
 return arrayComments;
 }

    public static List<Restaurants> getRestaurantsApi() {
        List<Restaurants> arrayRestaurants = new ArrayList();
        try {
            // Per fer la connexió a la base de dades
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");


            Statement stmt = con.createStatement();

            // Sentència SQL per treure la informació guardada a la base de dades
            ResultSet rs;

                rs = stmt.executeQuery("SELECT RES_NOM, RES_ADRECA, RES_WEB, RES_TELEFON, TRS_DESCRIPCIO, RES_URL_IMG, RES_MITJANA, RES_CODI  FROM  RESTAURANTS , TRESTAURANTS WHERE TRS_CODI = RES_TRS_CODI");

            while (rs.next()) {
                String name = rs.getString("RES_NOM");
                String address = rs.getString("RES_ADRECA");
                String website = rs.getString("RES_WEB");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");
                String images = rs.getString("RES_URL_IMG");
                String mitjana = rs.getString("RES_MITJANA");
                String code = rs.getString("RES_CODI");


                Restaurants std = new Restaurants();
                std.setName(name);
                std.setAddress(address);
                std.setWebsite(website);
                std.setTelephone(telephone);
                std.setType(type);
                std.setImages(images);
                std.setMitjana(mitjana);
                std.setCode(code);


                arrayRestaurants.add(std);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arrayRestaurants;
    }

}

