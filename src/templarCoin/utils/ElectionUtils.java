/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templarCoin.utils;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author rafaelpimentel
 */
public class ElectionUtils {
   
    public static DefaultListModel getListModel(ArrayList lst){
	DefaultListModel model = new DefaultListModel();
	for (Object object : lst){
	    model.addElement(object);
	}
	return model;
    }
}
