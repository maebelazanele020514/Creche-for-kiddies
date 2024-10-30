/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import za.tut.kiddies.Kiddies;


/**
 *
 * @author hifi
 */
public class Creche4KiddiesFrame extends JFrame{
    //panels
    private JPanel kidsPnl;
    private JPanel namePnl;
    private JPanel genderPnl;
    private JPanel btnPnl;
    private JPanel commentsPnl;
    private JPanel kidsPnlandCommentsPnl;
    private JPanel mainPnl;
    
    //Labels
    private JLabel nameLbl;
    private JLabel genderLbl;
    
    //Text Fields
    private JTextField nameTxtField;
    
    //radio buttons
    
    private JRadioButton maleRadBtn;
    private JRadioButton femaleRadBtn;
    
    //button group
    private ButtonGroup btnGroup;
    
    //textArea
    private JTextArea commentsTxtArea;
    
    //buttons
    private JButton registerBtn;
    private JButton displayBtn;
    
    //scrollpane
    private JScrollPane scrollPane;
    
    //list of kids
    private ArrayList<Kiddies> kiddies;
    
    //construct the GUI
    
    public Creche4KiddiesFrame(){
        //set the frame
        
        setTitle("CRECHE 4 YOUR KIDDIE");
        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        //create a list for members
        kiddies=new ArrayList<>();
        
        //create panels
        kidsPnl=new JPanel (new GridLayout(3,1,1,1));
        
        namePnl=new JPanel (new FlowLayout(FlowLayout.LEFT));
        genderPnl=new JPanel (new FlowLayout(FlowLayout.LEFT));
        btnPnl=new JPanel (new FlowLayout(FlowLayout.LEFT));
        commentsPnl=new JPanel (new FlowLayout(FlowLayout.LEFT));
        kidsPnlandCommentsPnl=new JPanel (new BorderLayout());
        mainPnl=new JPanel (new BorderLayout());
        
        //create labels
        nameLbl=new JLabel ("Name: ");
        genderLbl=new JLabel ("Gender: ");
        
        //create TextFields
        nameTxtField= new JTextField(10);
        
        //create radio buttons
        maleRadBtn=new JRadioButton ("Male");
        femaleRadBtn=new JRadioButton ("Female");
        
        //create buttonGroup
        btnGroup=new ButtonGroup();
        btnGroup.add(maleRadBtn);
        btnGroup.add(femaleRadBtn);
        
        //create text Area
        commentsTxtArea=new JTextArea (15,50);
        commentsTxtArea.setEditable(false);
        commentsTxtArea.setBorder(new LineBorder(Color.blue,0));
        
        //create scrollpane
        scrollPane=new JScrollPane(commentsTxtArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //create buttons
        registerBtn=new JButton ("Register Kiddie");
        registerBtn.addActionListener(new RegisterBtnListener());
        
        displayBtn=new JButton ("Display Kiddies");
        displayBtn.addActionListener(new DisplayBtnListener());
        
        //add components to panels
        namePnl.add(nameLbl);
        namePnl.add(nameTxtField);
        
        genderPnl.add(genderLbl);
        genderPnl.add(maleRadBtn);
        genderPnl.add(femaleRadBtn);
        
        kidsPnl.add(namePnl);
        kidsPnl.add(genderPnl);
        
        
        
        btnPnl.add(registerBtn);
        btnPnl.add(displayBtn);
        
        commentsPnl.add(scrollPane);
        
        mainPnl.add(btnPnl,BorderLayout.SOUTH);
        kidsPnlandCommentsPnl.add(kidsPnl,BorderLayout.NORTH);
        kidsPnlandCommentsPnl.add(btnPnl,BorderLayout.CENTER);
        kidsPnlandCommentsPnl.add(commentsPnl,BorderLayout.SOUTH);
        
        mainPnl.add(kidsPnlandCommentsPnl,BorderLayout.CENTER);
        
        
        
        add(mainPnl);
        pack();
        
        setResizable(false);
        setVisible(true);
    }
        
    
    private class DisplayBtnListener implements ActionListener {

        public DisplayBtnListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String regKiddos="";
                
            for(int i=0;i<kiddies.size();i++){
                
                Kiddies kid=kiddies.get(i);
                
                regKiddos+=kid.getName()+" "+kid.getGender()+"\n";
            }
            commentsTxtArea.setText("REGISTERED KIDDIES: \n"+regKiddos);
        }
    }

    private class RegisterBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           //read data
           
           String name=nameTxtField.getText();
           String gender = null;
           
           if(maleRadBtn.isSelected()){
               gender="Male";
           }
           else
               if(femaleRadBtn.isSelected()){
                   gender="Female";
               }
           
           //create a member
           
           Kiddies kids=new Kiddies(name,gender);
           
           //add the kiddies to the list
           kiddies.add(kids);
           
           //clear details
           nameTxtField.setText("");
           btnGroup.clearSelection();
           
           //display a success message
           commentsTxtArea.setText( name +" "+"has been succesfuly registered!");
        }
   
    }
}

