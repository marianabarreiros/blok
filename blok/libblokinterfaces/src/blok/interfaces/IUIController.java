/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blok.interfaces;

import javax.swing.JMenuItem;

/**
 *
 * @author aluno
 */
public interface IUIController {
    public abstract boolean initialize();
    public abstract JMenuItem createMenuItem(String menu, String item);
}
