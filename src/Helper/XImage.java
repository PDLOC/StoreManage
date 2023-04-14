/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;


import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author ADMIN
 */
public class XImage {
//    public static final Image APP_ICON;
//    static{
//        String file = "/com/polypro/icon/fpt.png";
//        APP_ICON = new ImageIcon(XImage.class.getResource(file)).getImage();
//    }  
    public static boolean saveLogo(File file){
        File dir = new File("IMAGE");
        if(!dir.exists()){
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } 
        catch (Exception ex) {
            return false;
        }
    }
    public static ImageIcon readLogo(String fileName){
        File path = new File("IMAGE", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}