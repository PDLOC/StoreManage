/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

/**
 *
 * @author daung
 */
public class ResetPassword {
    public static String userName = null;
    
    public static String createCode(){
        int code = (int) ((Math.random() * (9999-1000)) + 1000);
        return code + "";
    }
}
