/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentthree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Aashin
 */
public class windowClass extends JFrame implements ActionListener {

    HashMap<String, ArrayList<Integer>> hmap = new HashMap<>(); //creates hashmap
    ArrayList<Integer> e = new ArrayList<>(); //creates integer arrayList
    ArrayList<productClass> productList = new ArrayList<>(); //creates product arrayList
    electronicsClass ecClass = new electronicsClass(); //creates respective ecClass 
    bookClass bkClass = new bookClass(); //creates respective bkClass 

    //establishes private values to be used within this class
    private JLabel menuLabel;
    private JLabel menuLabel2;
    private JLabel menuLabel3;
    private JLabel addLabel;
    private JLabel typeLabel;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel yearLabel;
    private JLabel makerLabel;
    private JLabel authorLabel;
    private JLabel publisherLabel;
    private JLabel searchLabel;
    private JTextField productID;
    private JTextField productPrice;
    private JTextField productName;
    private JTextField productYear;
    private JTextField productMaker;
    private JTextField productAuthor;
    private JTextField productPublisher;
    private JLabel messageLabel;
    private JTextArea messageDisplay;
    private JScrollPane scrolledText;
    private JButton addOption;
    private JButton resetOption;
    private JTextField searchYearStart;
    private JTextField searchName;
    private JTextField searchID;
    private JLabel yearLabel2;
    private JTextField searchYearEnd;
    private JLabel nameLabel2;
    private JButton searchOption;
    private static JTextArea searchDisplay;
    private JScrollPane searchText;
    private JLabel resultsLabel;
    private JComboBox<String> typeList;
    private String fileNameAccess;

    /**
     *
     * @param fileName the string value passed from the main class to be used
     * for file IO here
     *
     */
    public windowClass(String fileName) {
        super();

        //grabs the filename from command line arguments
        fileNameAccess = fileName;
        productClass.fileInput(fileNameAccess, productList); //reads in input file
        productClass.hashmapAdd(productList, hmap); //sorts and adds file values to hashmap

        setSize(500, 250); //sets size of window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("eStore"); //sets title of window
        this.setLayout(null);

        //creation of all menu items below
        JMenu commandMenu = new JMenu("Command");

        JMenuItem addChoice = new JMenuItem("add");
        addChoice.addActionListener(this);
        commandMenu.add(addChoice);

        JMenuItem searchChoice = new JMenuItem("search");
        searchChoice.addActionListener(this);
        commandMenu.add(searchChoice);

        JMenuItem quitChoice = new JMenuItem("quit");
        quitChoice.addActionListener(this);
        commandMenu.add(quitChoice);

        JMenuBar bar = new JMenuBar();
        bar.add(commandMenu);
        setJMenuBar(bar);

        menuLabel = new JLabel("Welcome to eStore");
        menuLabel.setBounds(30, 30, 200, 100);
        add(menuLabel);

        menuLabel2 = new JLabel("Choose a command from the 'Commands' menu above for");
        menuLabel2.setBounds(30, 60, 400, 100);
        add(menuLabel2);

        menuLabel3 = new JLabel("adding a product, searching products, or quitting the program");
        menuLabel3.setBounds(30, 80, 400, 100);
        add(menuLabel3);

    }

    /**
     *
     * @param ae the value used for getting the action command
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        String actionCommand = ae.getActionCommand();

        //actionPerformed for quit option
        if (actionCommand.equals("quit")) {
            productClass.fileOutput(fileNameAccess, productList);
            System.exit(0);
            //actionPerformed for add option
        } else if (actionCommand.equals("add")) {
            setSize(650, 650);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("eStore Search");
            this.setLayout(null);

            //removes certain labels when switched over to this window option
            this.remove(menuLabel);
            this.remove(menuLabel2);
            this.remove(menuLabel3);

            try {
                this.remove(searchLabel);
                this.remove(idLabel);
                this.remove(searchID);
                this.remove(nameLabel);
                this.remove(nameLabel2);
                this.remove(searchName);
                this.remove(yearLabel);
                this.remove(searchYearStart);
                this.remove(yearLabel2);
                this.remove(searchYearEnd);
                this.remove(resetOption);
                this.remove(searchOption);
                this.remove(resultsLabel);
                this.remove(searchDisplay);
                this.remove(searchText);
            } catch (Exception e) {
                // System.out.println(e);
            }

            //remakes the window
            this.revalidate();
            this.repaint();

            //creates the menu items for this option
            addLabel = new JLabel("Adding a product");
            addLabel.setBounds(10, -30, 400, 100);
            add(addLabel);

            typeLabel = new JLabel("Type:");
            typeLabel.setBounds(25, 0, 400, 100);
            add(typeLabel);

            String[] choiceType = {"book", "electronic"};
            typeList = new JComboBox<String>(choiceType);
            typeList.setSelectedIndex(0);
            typeList.setBounds(85, 40, 150, 25);
            add(typeList);

            //actionListener for the choice type within the combo box
            typeList.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //for electronic type
                    if (typeList.getSelectedIndex() == 1) {
                        setSize(650, 580);
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setLayout(null);

                        authorLabel.setVisible(false);
                        publisherLabel.setVisible(false);
                        productPublisher.setVisible(false);
                        makerLabel.setVisible(true);
                        productMaker.setVisible(true);

                        messageLabel.setBounds(10, 270, 400, 100);
                        scrolledText.setBounds(10, 340, 600, 170);
                        resetOption.setBounds(475, 50, 75, 50);
                        addOption.setBounds(475, 210, 75, 50);

                    } //for book type
                    else if (typeList.getSelectedIndex() == 0) {
                        setSize(650, 650);
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setLayout(null);

                        authorLabel.setVisible(true);
                        publisherLabel.setVisible(true);
                        productPublisher.setVisible(true);
                        makerLabel.setVisible(false);
                        productMaker.setVisible(false);

                        scrolledText.setBounds(10, 390, 600, 170);
                        messageLabel.setBounds(10, 330, 400, 100);
                        addOption.setBounds(475, 240, 75, 50);
                        resetOption.setBounds(475, 80, 75, 50);

                    }
                }
            });

            idLabel = new JLabel("ProductID:");
            idLabel.setBounds(20, 40, 400, 100);
            add(idLabel);

            productID = new JTextField();
            productID.setBounds(85, 80, 100, 25);
            add(productID);

            nameLabel = new JLabel("Name:");
            nameLabel.setBounds(25, 80, 400, 100);
            add(nameLabel);

            productName = new JTextField();
            productName.setBounds(85, 120, 250, 25);
            add(productName);

            priceLabel = new JLabel("Price:");
            priceLabel.setBounds(25, 120, 400, 100);
            add(priceLabel);

            productPrice = new JTextField();
            productPrice.setBounds(85, 160, 75, 25);
            add(productPrice);

            yearLabel = new JLabel("Year:");
            yearLabel.setBounds(25, 160, 400, 100);
            add(yearLabel);

            productYear = new JTextField();
            productYear.setBounds(85, 200, 75, 25);
            add(productYear);

            authorLabel = new JLabel("Author:");
            authorLabel.setBounds(25, 200, 400, 100);
            add(authorLabel);

            productAuthor = new JTextField();
            productAuthor.setBounds(85, 240, 250, 25);
            add(productAuthor);

            publisherLabel = new JLabel("Publisher:");
            publisherLabel.setBounds(25, 240, 400, 100);
            add(publisherLabel);

            productPublisher = new JTextField();
            productPublisher.setBounds(85, 280, 250, 25);
            add(productPublisher);

            makerLabel = new JLabel("Maker:");
            makerLabel.setBounds(25, 200, 400, 100);
            add(makerLabel);

            productMaker = new JTextField();
            productMaker.setBounds(85, 240, 250, 25);
            add(productMaker);

            makerLabel.setVisible(false);
            productMaker.setVisible(false);

            resetOption = new JButton("Reset");
            resetOption.setBounds(475, 80, 75, 50);
            add(resetOption);

            //actionListener for the reset option
            resetOption.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String aCommand = e.getActionCommand();

                    if (aCommand.equals("Reset")) {
                        productID.setText("");
                        productPrice.setText("");
                        productName.setText("");
                        productYear.setText("");

                        if (productMaker.isVisible() == true) {
                            productMaker.setText("");
                        }

                        productAuthor.setText("");
                        productPublisher.setText("");
                        messageDisplay.append("Fields reset!" + "\n");
                    }

                }
            });

            addOption = new JButton("Add");
            addOption.setBounds(475, 240, 75, 50);
            add(addOption);

            //actionListener for the add option
            addOption.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String bCommand = e.getActionCommand();

                    if (bCommand.equals("Add") && typeList.getSelectedIndex() == 0) {

                        String bookID = productID.getText();
                        String bookName = productName.getText();
                        String bookPrice = productPrice.getText();
                        String bookYear = productYear.getText();
                        String bookAuthor = productAuthor.getText();
                        String bookPublisher = productPublisher.getText();

                        try {
                            new bookClass(bookName, bookYear, bookID);
                            if (checkID(bookID, productList) == true) { //checks for duplicate productIDs
                                bkClass.setID(bookID);
                                bkClass.setName(bookName);
                                bkClass.setPrice(bookPrice);
                                bkClass.setYear(bookYear);
                                bkClass.setAuthor(bookAuthor);
                                bkClass.setPublisher(bookPublisher);
                                bkClass.setType("book");
                                productList.add(bkClass);
                                productClass.hashmapAdd(productList, hmap); //updates hashmap
                                messageDisplay.append("New book product was added!" + "\n");
                            }
                        } catch (Exception ex) {
                            messageDisplay.append(ex.toString());
                        }

                    } else if (bCommand.equals("Add") && typeList.getSelectedIndex() == 1) {

                        String electronicID = productID.getText();
                        String electronicName = productName.getText();
                        String electronicPrice = productPrice.getText();
                        String electronicYear = productYear.getText();
                        String electronicMaker = productMaker.getText();

                        try {
                            new electronicsClass(electronicName, electronicYear, electronicID);
                            if (checkID(electronicID, productList) == true) { //checks for duplicate IDs
                                ecClass.setID(electronicID);
                                ecClass.setMaker(electronicMaker);
                                ecClass.setPrice(electronicPrice);
                                ecClass.setName(electronicName);
                                ecClass.setYear(electronicYear);
                                ecClass.setType("electronic");
                                productList.add(ecClass);
                                productClass.hashmapAdd(productList, hmap); //updates hashmap
                                messageDisplay.append("New electronic product was added!" + "\n");
                            }
                        } catch (Exception ex) {
                            messageDisplay.append(ex.toString());
                        }

                    }

                }
            });

            messageLabel = new JLabel("Messages");
            messageLabel.setBounds(10, 330, 400, 100);
            add(messageLabel);

            messageDisplay = new JTextArea(10, 30);
            messageDisplay.setBackground(Color.WHITE);
            messageDisplay.setEditable(false);
            scrolledText = new JScrollPane(messageDisplay);
            scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrolledText.setBounds(10, 390, 600, 170);
            add(scrolledText);

            //actionPerformed for search option
        } else if (actionCommand.equals("search")) {

            setSize(650, 450);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);

            //removes certain menu elements when switched to search option
            this.remove(menuLabel);
            this.remove(menuLabel2);
            this.remove(menuLabel3);

            try {
                this.remove(addLabel);
                this.remove(typeLabel);
                this.remove(typeList);
                this.remove(yearLabel);
                this.remove(priceLabel);
                this.remove(productPrice);
                this.remove(productYear);
                this.remove(authorLabel);
                this.remove(productAuthor);
                this.remove(publisherLabel);
                this.remove(productPublisher);
                this.remove(makerLabel);
                this.remove(productMaker);
                this.remove(resetOption);
                this.remove(addOption);
                this.remove(messageLabel);
                this.remove(messageDisplay);
                this.remove(scrolledText);
                this.remove(idLabel);
                this.remove(nameLabel);
                this.remove(productID);
                this.remove(productName);
            } catch (Exception e) {
                //   System.out.println(e);
            }

            this.revalidate();
            this.repaint();

            searchLabel = new JLabel("Searching products");
            searchLabel.setBounds(10, -30, 400, 100);
            add(searchLabel);

            idLabel = new JLabel("ProductID:");
            idLabel.setBounds(20, 5, 400, 100);
            add(idLabel);

            searchID = new JTextField();
            searchID.setBounds(85, 42, 100, 25);
            add(searchID);

            nameLabel = new JLabel("Name");
            nameLabel.setBounds(20, 35, 400, 100);
            add(nameLabel);

            nameLabel2 = new JLabel("Keywords:");
            nameLabel2.setBounds(20, 50, 400, 100);
            add(nameLabel2);

            searchName = new JTextField();
            searchName.setBounds(85, 82, 250, 25);
            add(searchName);

            yearLabel = new JLabel("Start Year:");
            yearLabel.setBounds(20, 80, 400, 100);
            add(yearLabel);

            searchYearStart = new JTextField();
            searchYearStart.setBounds(85, 120, 75, 25);
            add(searchYearStart);

            yearLabel2 = new JLabel("End Year:");
            yearLabel2.setBounds(20, 110, 400, 100);
            add(yearLabel2);

            searchYearEnd = new JTextField();
            searchYearEnd.setBounds(85, 150, 75, 25);
            add(searchYearEnd);

            resetOption = new JButton("Reset");
            resetOption.setBounds(475, 30, 75, 50);
            add(resetOption);

            resetOption.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String aCommand = e.getActionCommand();

                    if (aCommand.equals("Reset")) {
                        searchID.setText("");
                        searchName.setText("");
                        searchYearStart.setText("");
                        searchYearEnd.setText("");
                        searchDisplay.append("Search fields reset!" + "\n");
                    }

                }
            });

            searchOption = new JButton("Search");
            searchOption.setBounds(475, 120, 75, 50);
            add(searchOption);

            //actionListener for the search method
            searchOption.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent aec) {
                    String aecCommand = aec.getActionCommand();

                    if (aecCommand.equals("Search")) {
                        String prodID = searchID.getText();
                        String prodName = searchName.getText();
                        String searchYear1 = searchYearStart.getText();
                        String searchYear2 = searchYearEnd.getText();
                        int firstYear = 0;
                        int secondYear = 0;

                        if (searchYear1.isEmpty() == false) {
                            firstYear = Integer.parseInt(searchYear1);
                        }

                        if (searchYear2.isEmpty() == false) {
                            secondYear = Integer.parseInt(searchYear2);
                        }

                        if (firstYear > secondYear && secondYear != 0) {
                            searchDisplay.append("Start year cannot be greater than End year!" + "\n");
                        } else if (prodName.isEmpty()) {
                            if (prodID.isEmpty() && searchYear1.isEmpty() && searchYear2.isEmpty()) {
                                searchDisplay.append("All fields empty, printing out all products!" + "\n");
                                for (int x = 0; x < productList.size(); x++) {

                                    searchDisplay.append(productList.get(x) + "\n");
                                }
                            } else //if the year input contains a dash, it then determines what type of year range its looking for
                            {
                                if (searchYear1.isEmpty() && searchYear2.isEmpty() == false) { //here it looks for years in this format: -XXXX
                                    productClass.previousYears(searchYear2, prodID, productList, null, 0);
                                } else if (searchYear1.isEmpty() == false && searchYear2.isEmpty() == false) { //here it looks for years in this format: XXXX-YYYY
                                    productClass.rangeYears(searchYear1, searchYear2, prodID, productList, null, 0);
                                } else if (searchYear1.isEmpty() == false && searchYear2.isEmpty()) { //here it looks for years in this format: XXXX-
                                    productClass.futureYears(searchYear1, prodID, productList, null, 0);
                                } else if (searchYear1.isEmpty() && searchYear2.isEmpty()) {
                                    productClass.commonSearch(searchYear1, prodID, productList, null, 0);
                                }
                            }
                        } else if (searchYear1.isEmpty() && searchYear2.isEmpty() && prodID.isEmpty() && !prodName.isEmpty()) //if searchName has keywords ONLY, limited to 3 words
                        {
                            productClass.searchNameOnly(prodName, hmap, e, productList);

                        } else if (!prodName.isEmpty()) //searches for multiple fields
                        {
                            if (!searchYear1.isEmpty() || !searchYear2.isEmpty() || !prodID.isEmpty()) {
                                if (searchYear1.isEmpty() && searchYear2.isEmpty() == false) { //here it looks for years in this format: -XXXX
                                    productClass.MultiplePreviousYears(searchYear2, prodID, productList, productClass.returnNameIndex(prodName, hmap, e, productList));
                                } else if (searchYear1.isEmpty() == false && searchYear2.isEmpty() == false) { //here it looks for years in this format: XXXX-YYYY
                                    productClass.MultipleRangeYears(searchYear1, searchYear2, prodID, productList, productClass.returnNameIndex(prodName, hmap, e, productList));
                                } else if (searchYear1.isEmpty() == false && searchYear2.isEmpty()) { //here it looks for years in this format: XXXX-
                                    productClass.MultipleFutureYears(searchYear1, prodID, productList, productClass.returnNameIndex(prodName, hmap, e, productList));
                                } else if (searchYear1.isEmpty() && searchYear2.isEmpty()) {
                                    productClass.MultipleCommonSearch(searchYear1, prodID, productList, productClass.returnNameIndex(prodName, hmap, e, productList)); //if no dash is detected, just uses specified year or no year 
                                }

                            }
                        } else if (searchYear1.isEmpty() && searchYear2.isEmpty() == false) { //here it looks for years in this format: -XXXX
                            productClass.previousYears(searchYear2, prodID, productList, e, 1);
                        } else if (searchYear1.isEmpty() == false && searchYear2.isEmpty() == false) { //here it looks for years in this format: XXXX-YYYY
                            productClass.rangeYears(searchYear1, searchYear2, prodID, productList, e, 1);
                        } else if (searchYear1.isEmpty() == false && searchYear2.isEmpty()) { //here it looks for years in this format: XXXX-
                            productClass.futureYears(searchYear1, prodID, productList, e, 1);
                        } else if (searchYear1.isEmpty() && searchYear2.isEmpty()) {
                            productClass.commonSearch(searchYear1, prodID, productList, e, 1); //if no dash is detected, just uses specified year or no year               
                        }
                    }
                }
            });

            resultsLabel = new JLabel("Search Results");
            resultsLabel.setBounds(10, 160, 400, 100);
            add(resultsLabel);

            searchDisplay = new JTextArea(8, 30);
            searchDisplay.setBackground(Color.WHITE);
            searchDisplay.setEditable(false);
            searchText = new JScrollPane(searchDisplay);
            searchText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            searchText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            searchText.setBounds(10, 230, 600, 150);
            add(searchText);

        }

    }

    /**
     *
     * @param productID user specified string of productID
     * @param sourceList user specified arrayList where IDs originate in
     * @return returns true if no duplicate productID exists in the book class
     * arrayList
     */
    public boolean checkID(String productID, ArrayList<productClass> sourceList) {
        if (sourceList.isEmpty()) {
            messageDisplay.append("First item added added to the arrayList!" + "\n");
            return true;
        } else if (!sourceList.isEmpty()) {

            for (int x = 0; x < sourceList.size(); x++) {

                if (sourceList.get(x).getID().equals(productID)) {
                    messageDisplay.append("ERROR: This product ID is already in use in the arrayList. Item not added!" + "\n");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param outputMessage takes a string value to output into a scrollable
     * textbox
     * @param outputMessage2 takes an object value to output into a scrollable
     * textbox
     */
    public static void outputToDisplay(String outputMessage, Object outputMessage2) {

        if (outputMessage.isEmpty()) {
            searchDisplay.append(outputMessage2.toString() + "\n");
        } else if (outputMessage2 == null) {
            searchDisplay.append(outputMessage + "\n");
        }

    }

}
