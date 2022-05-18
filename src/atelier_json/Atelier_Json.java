/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atelier_json;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;
//
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import org.apache.commons.io.IOUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Nezzar
 */
public class Atelier_Json {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        String jsonString = FileReader.loadFileIntoString
        ("catalogue.json","UTF-8");
        JSONArray livres = JSONArray.fromObject(jsonString);
        

//    Exercice 01:
        System.out.println("Il y a " + livres.size() + " livre(s) dans le catalogue.");
//    Exercice 02:
        System.out.println("livres parus depuis 2010:");
        int cpt = 0;
        for(int i = 0; i < livres.size(); i++) {
            JSONObject livre = livres.getJSONObject(i);
            if(livre.getInt("annee") >= 2010) {
                   cpt += 1;
                   System.out.println(" * " + livre.getString("titre"));
            }
        }
        System.out.println("Il y a " + livres.size() + " livre(s) dans le catalogue dont " + cpt + " paru(s) depuis 2010.");
   
 
//    Exercice 03:
        System.out.println("Prix des livres disponibles:");
        int cpt_ = 0;
        for(int i = 0; i < livres.size(); i++) {
            JSONObject livre = livres.getJSONObject(i);
            if(livre.getBoolean("disponible")) {
                   cpt_ += 1;
                   System.out.println(" * " + livre.getString("titre") + ": " + livre.getDouble("prix") + "$");
            }
        }
        System.out.println("Il y a " + cpt + " livre(s) disponible(s).");
   
   
//    Exercice 04:
//      premier niveau commande
        JSONObject commande = new JSONObject();
        
        commande.accumulate("id", "1321033823");
        commande.accumulate("total", 49.9);
        commande.accumulate("date", "11/11/2011");
        commande.accumulate("validation", true);

        // Build another object for representing the book
        JSONObject livre = new JSONObject();
        livre.accumulate("id", "1");
        livre.accumulate("titre", "Database System Concepts");

        // Build a JSON array of books
        JSONArray albums = new JSONArray();
        albums.add(livre);

        // Add the array to the order
        commande.accumulate("livres", albums);

        System.out.println(commande);
 
        

 }
}