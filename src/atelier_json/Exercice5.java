/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package atelier_json;

import java.io.IOException;
import java.text.DecimalFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Generate JSON Build a full order from catalog
 */


public class Exercice5 {


    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws Exception {
        String json = FileReader.loadFileIntoString("catalogue.json","UTF-8");
        JSONArray lvrs = JSONArray.fromObject(json);

        // Build the livre list to add in the order
        JSONArray livres = new JSONArray();
        double total = 0.0;
        for (int i = 0; i < lvrs.size(); i++) {
            JSONObject livre = lvrs.getJSONObject(i);
            if (livre.getDouble("prix") < 100.0) {
                total += livre.getDouble("prix");
                livres.add(livre);
            }
        }

        // Format the price
        DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(2);
        String totalStr = format.format(total);

        //get current date time with Date()
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateOrder = dateFormat.format(date);;
         
        // Build the order
        JSONObject order = new JSONObject();
        order.accumulate("id", "1321033823");
        order.accumulate("total", totalStr);
        order.accumulate("date", dateOrder);
        order.accumulate("validation", true);
        order.accumulate("livres", livres);
             
        
        
        try{
        FileWriter.saveStringIntoFile("order.json", order.toString());
        }catch (IOException e){
            System.out.println("Erreur lors de la conversion," + "operation annuler");
        }
        
           
 
        
        
    }}
