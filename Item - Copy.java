import java.text.NumberFormat;
import java.util.*;
//gui
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class Item implements interfaceItem
{

    protected String name;
    protected double shelfprice;
    protected double purchasedfor;
    protected int quantity;
    protected int ID;
    protected String itemtype;
    Scanner scan = new Scanner(System.in);

    static boolean gui_done;
    
    protected double itemPrice_tmp;
    protected String itemName_tmp;
    protected double purchfor_tmp;
    protected int numItem_tmp;
    protected int IDnum_tmp;
    protected String type_tmp;
    protected int expire_tmp;

    static protected int WIDTH=200;
    static protected int HEIGHT = 400;
    static protected JFrame frame;
    static protected JPanel panel;
    static protected JLabel inputNameLabel,inputPriceLabel,inputOrigPriceLabel,inputQuantLabel,inputIDLabel,inputExpireLabel,inputTypeLabel,inputEmptyLabel;
    static protected JButton okButton;
    static protected JTextField inputNameField,inputPriceField,inputOrigPriceField,inputQuantField,inputIDField,inputExpireField,inputTypeField;

    // parameters to be an Item (name, shelf price, purchased for, quantity, ID number, item type)
    public Item (String itemName, double itemPrice,double purchfor, int numItem, int IDnum, String type )
    {
        this.name = itemName;
        this.shelfprice = itemPrice;
        this.purchasedfor = purchfor;
        this.quantity = numItem;
        this.ID=IDnum;
        this.itemtype = type;
    }

    protected void setGuiPanel()
    {            //gui
        //GUI
        frame = new JFrame ("Item Entry");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        inputNameLabel = new JLabel("Enter Name:                 ");
        //inputNameLabel.setBounds(10,20,190,35);
        inputNameField = new JTextField(5);
        //inputNameField.setBounds(76,412,90,35);
        inputPriceLabel = new JLabel("Enter Price:                   ");
        inputPriceField = new JTextField(5);
        //inputPriceField.setBounds(76,412,90,35);
        inputOrigPriceLabel = new JLabel("Enter Original Price:   ");
        inputOrigPriceField = new JTextField(5);
        inputQuantLabel = new JLabel("Enter Quantity:             ");
        inputQuantField = new JTextField(5);
        inputIDLabel = new JLabel("Enter ID num:                ");
        inputIDField = new JTextField(5);
        //inputTypeLabel = new JLabel("Enter Item Type:           ");
        //inputTypeField = new JTextField(5);
        inputExpireLabel = new JLabel("Enter Expiration Date:");
        inputExpireField = new JTextField(5);
        //inputEmptyLabel = new JLabel("                                                 ");
        okButton = new JButton ("OK");
        //okButton.addActionListener(new ButtonListener());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setBackground(Color.lightGray);
        panel.add(inputNameLabel);
        panel.add(inputNameField);
        panel.add(inputPriceLabel);
        panel.add(inputPriceField);
        panel.add(inputOrigPriceLabel);
        panel.add(inputOrigPriceField);
        panel.add(inputQuantLabel);
        panel.add(inputQuantField);
        panel.add(inputIDLabel);
        panel.add(inputIDField);
        //panel.add(inputTypeLabel);
        //panel.add(inputTypeField);
        okButton.addActionListener(new ButtonListener());
    }
    public Item()
    {            //gui
    /*    //GUI
        frame = new JFrame ("Perishable Item Entry");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        inputNameLabel = new JLabel("Enter Name:                 ");
        //inputNameLabel.setBounds(10,20,190,35);
        inputNameField = new JTextField(5);
        //inputNameField.setBounds(76,412,90,35);
        inputPriceLabel = new JLabel("Enter Price:                   ");
        inputPriceField = new JTextField(5);
        //inputPriceField.setBounds(76,412,90,35);
        inputOrigPriceLabel = new JLabel("Enter Original Price:   ");
        inputOrigPriceField = new JTextField(5);
        inputQuantLabel = new JLabel("Enter Quantity:             ");
        inputQuantField = new JTextField(5);
        inputIDLabel = new JLabel("Enter ID num:                ");
        inputIDField = new JTextField(5);
        //inputTypeLabel = new JLabel("Enter Item Type:           ");
        //inputTypeField = new JTextField(5);
        inputExpireLabel = new JLabel("Enter Expiration Date:");
        inputExpireField = new JTextField(5);
        //inputEmptyLabel = new JLabel("                                                 ");
        okButton = new JButton ("OK");
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setBackground(Color.lightGray);
        panel.add(inputNameLabel);
        panel.add(inputNameField);
        panel.add(inputPriceLabel);
        panel.add(inputPriceField);
        panel.add(inputOrigPriceLabel);
        panel.add(inputOrigPriceField);
        panel.add(inputQuantLabel);
        panel.add(inputQuantField);
        panel.add(inputIDLabel);
        panel.add(inputIDField);
        */
        //panel.add(inputTypeLabel);
        //panel.add(inputTypeField);
        setGuiPanel();
        //okButton.addActionListener(new ButtonListener());


    }
    
    public void modify()
    {            //gui
        setGuiPanel();
        
    }    
    
    protected class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            System.out.println("Button pushed! Name="+inputNameField.getText());
            itemPrice_tmp = Double.parseDouble(inputPriceField.getText());
            itemName_tmp =  inputNameField.getText();
            purchfor_tmp= Double.parseDouble(inputOrigPriceField.getText());
            numItem_tmp= Integer.parseInt(inputQuantField.getText());
            IDnum_tmp = Integer.parseInt(inputIDField.getText());
            //type_tmp = inputTypeField.getText();
            expire_tmp = Integer.parseInt(inputExpireField.getText());
            //new Perishable ("peach",0.99,0.25,45,450000,1,"Perishable");
            //number2 = Integer.parseInt(secondNumberText.getText())
            Item.gui_done = true;
        }
    }

    public String toString ()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        return (name + "\t" + "\t"+ fmt.format(shelfprice) + "\t" +"\t"+ quantity + "\t"+"\t"
            + fmt.format(shelfprice*quantity));
    }

    public String getType()
    {
        return  itemtype;
    }

    public double getshelfPrice()
    {
        return shelfprice;
    }

    public double getPurchfor()
    {
        return purchasedfor;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int IDnum()
    {
        return ID;
    }

    public abstract int getexpire();

    public abstract String getLocation();

}