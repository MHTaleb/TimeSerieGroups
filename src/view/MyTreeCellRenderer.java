/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Taleb
 */
public class MyTreeCellRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean sel, boolean exp, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, exp, leaf, row, hasFocus);

        // Assuming you have a tree of Strings
        String node = (String) ((DefaultMutableTreeNode) value).getUserObject();

        // If the node is a leaf and ends with "xxx"
        if (leaf && node.endsWith("xxx")) {
            // Paint the node in blue
            setForeground(Color.white);
        }

        return this;
    }
}