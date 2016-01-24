/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smok;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author lukasz
 */
public class GUI {

    private JFrame mainFrame;
    private JPanel myPanel;
//Genracja mapy
    private int size = 0;
    private JTextField mapSize;
    private JLabel mapSizeLabel;
    private JButton mapGenBt;
    private MapGenerator mGen;
    private JLabel[][] imageLabel;
  
    /**
     * @param args the command line arguments
     */
    GUI() {
        Gui();

    }

    private void Gui() {

        mainFrame = new JFrame("Wumpus");
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel = new JPanel();
        myPanel.setLayout(null);

        mapSizeLabel = new JLabel();
        mapSizeLabel.setText("Rozmiar mapy : ");
        mapSizeLabel.setBounds(600, 20, 130, 30);
        myPanel.add(mapSizeLabel);

        mapSize = new JTextField();
        mapSize.setText("");
        mapSize.setBounds(720, 20, 70, 30);
        myPanel.add(mapSize);

        mapGenBt = new JButton();
        mapGenBt.setText("Generuj");
        mapGenBt.setBounds(600, 90, 200, 50);
        myPanel.add(mapGenBt);

        mapGenBt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {

                    size = Integer.parseInt(mapSize.getText());
                    mGen = new MapGenerator(size);
                    Map myMap;
                    myMap = mGen.returnMap();
                    try {
                        System.out.println(imageLabel.length);
                        for (int i = 0; i < imageLabel.length; i++) {
                            for (int j = 0; j < imageLabel.length; j++) {
                                myPanel.remove(imageLabel[i][j]);
                            }
                        }
                    } catch (Exception e) {

                    }
                    imageLabel = new JLabel[size][size];
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            imageLabel[i][j] = new JLabel();
                        }
                    }

                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {

                            if (myMap.getStatAgent(i, j) == true && myMap.getStatSmell(i, j) == true && myMap.getStatWind(i, j) == true) {
                                ImageIcon icon = createImageIcon("images/agepowodr.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatAgent(i, j) == true && myMap.getStatSmell(i, j) == true && myMap.getStatWind(i, j) == false) {
                                ImageIcon icon = createImageIcon("images/ageodr.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatAgent(i, j) == true && myMap.getStatSmell(i, j) == false && myMap.getStatWind(i, j) == false) {
                                ImageIcon icon = createImageIcon("images/agent.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatAgent(i, j) == true && myMap.getStatSmell(i, j) == false && myMap.getStatWind(i, j) == true) {
                                ImageIcon icon = createImageIcon("images/agepow.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatSmok(i, j) == true) {
                                ImageIcon icon = createImageIcon("images/smok.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatHole(i, j) == true) {
                                ImageIcon icon = createImageIcon("images/dziura.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatAgent(i, j) == false && myMap.getStatSmell(i, j) == true && myMap.getStatWind(i, j) == true) {
                                ImageIcon icon = createImageIcon("images/zappow.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatAgent(i, j) == false && myMap.getStatGold(i, j) == false && myMap.getStatSmell(i, j) == false && myMap.getStatWind(i, j) == true) {
                                ImageIcon icon = createImageIcon("images/powiew.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatAgent(i, j) == false && myMap.getStatGold(i, j) == false && myMap.getStatSmell(i, j) == true && myMap.getStatWind(i, j) == false) {
                                ImageIcon icon = createImageIcon("images/zapach.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatHole(i, j) == false && myMap.getStatSmok(i, j) == false && myMap.getStatAgent(i, j) == false && myMap.getStatGold(i, j) == false && myMap.getStatSmell(i, j) == false && myMap.getStatWind(i, j) == false) {
                                ImageIcon icon = createImageIcon("images/puste.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatGold(i, j) == true && myMap.getStatSmell(i, j) == true && myMap.getStatWind(i, j) == true) {
                                ImageIcon icon = createImageIcon("images/zappowzlo.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatGold(i, j) == true && myMap.getStatSmell(i, j) == false && myMap.getStatWind(i, j) == true) {
                                ImageIcon icon = createImageIcon("images/powzlo.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatGold(i, j) == true && myMap.getStatSmell(i, j) == true && myMap.getStatWind(i, j) == false) {
                                ImageIcon icon = createImageIcon("images/zloodr.png");
                                imageLabel[i][j].setIcon(icon);
                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else if (myMap.getStatGold(i, j) == true && myMap.getStatSmell(i, j) == false && myMap.getStatWind(i, j) == false) {
                                ImageIcon icon = createImageIcon("images/zloto.png");
                                imageLabel[i][j].setIcon(icon);

                                imageLabel[i][j].setBounds(i * 600 / size, j * 600 / size, 600 / size, 600 / size);

                                // picture.setToolTipText("A drawing of a " + name.toLowerCase());
                                if (icon != null) {
                                    imageLabel[i][j].setText(null);
                                } else {
                                    imageLabel[i][j].setText("Image not found");
                                }
                            } else {

                            }
                            imageLabel[i][j].setVisible(true);
                            myPanel.add(imageLabel[i][j]);
                            myPanel.revalidate();
                            myPanel.repaint();
                        }
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainFrame, "Dane nie są wprowadzone lub wprowadzone błędnie.");
                }
            }
        }
        );

        mainFrame.add(myPanel);
        mainFrame.setVisible(true);
    }

    public int getSize() {
        return size;
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        GUI main = new GUI();
    }

}
