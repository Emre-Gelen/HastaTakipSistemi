/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastatakipsistemi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author E-G
 */

public class Metotlar {
    
    static File dosya=new File("Name.txt");
    static BufferedReader okuyucu=null;
    static BufferedWriter yazici=null;
  
    
    public static boolean GirisKontrol(String ad,String Soyad,String Sifre) throws FileNotFoundException, IOException{
        okuyucu=new BufferedReader(new FileReader(dosya));
        String Satir=okuyucu.readLine();
       
        boolean giriskontrol=true;
        
        if(Satir==null)
            giriskontrol=false;
        while(Satir!=null){
            String[] Satirparcasi=Satir.split("\\-");
            if(Satirparcasi[0].equals(ad+"*"+Soyad+"*"+Sifre))
                return true;
            else
                giriskontrol=false;
            
           Satir=okuyucu.readLine();
           
        }
        okuyucu.close();
        return giriskontrol;
    }
    /*public static boolean KayitKontrol(String ad,String Soyad,String Sifre) throws FileNotFoundException, IOException{
        okuyucu=new BufferedReader(new FileReader(dosya));
        String Satir=okuyucu.readLine();
        boolean giriskontrol=false;
        if(Satir==null)
            giriskontrol= true;
        while(Satir!=null){
            if(Satir.equals(ad+"*"+Soyad+"*"+Sifre))
                return false;
            else
                giriskontrol=true;
            
           Satir=okuyucu.readLine();
        }
        okuyucu.close();
        return giriskontrol;
    }*/
    public static String Ilac(String ad,String Soyad,String Sifre) throws IOException{
        okuyucu=new BufferedReader(new FileReader(dosya));
        String Satir=okuyucu.readLine();
        
        String ilaclar="";
        while(Satir!=null){
            String[] Satirparcasi=Satir.split("\\-");
            if(Satirparcasi[0].equals(ad+"*"+Soyad+"*"+Sifre))
            {
            return Satirparcasi[1];
            }
           Satir=okuyucu.readLine();
        }
        return ilaclar;
    }
    
    public static void Kayit(String ad,String Soyad,String Sifre) throws IOException{
      
        if(!GirisKontrol(ad,Soyad,Sifre)){
        String eskimetin = "";
        try
        {
            okuyucu=new BufferedReader(new FileReader(dosya));
            String line = okuyucu.readLine();
            while (line != null) 
            {
                eskimetin = eskimetin + line + System.lineSeparator();
                 
                line = okuyucu.readLine();
            }
            String yenimetin = eskimetin+ad+"*"+Soyad+"*"+Sifre+"-";
            yazici=new BufferedWriter(new FileWriter(dosya));
            yazici.write(yenimetin);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                JOptionPane.showMessageDialog(null,"Kayit Basarili");
                okuyucu.close();
                yazici.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
       }
        else{
            JOptionPane.showMessageDialog(null,"Kullanici Mevcut");
        }
    }
}
