package LevelEditor;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PVZLevelEditor extends  JFrame {


    private JPanel body;
    private JCheckBox cbPeashooter;
    private JButton saveChangesButton;
    private JTabbedPane tabbedPane1;
    private JCheckBox cbZombie;
    private JPanel cbPlants;
    private JComboBox comboMusic;
    private JSlider slSunFallRate;
    private JButton resetToDefaultButton;
    private JRadioButton fullscreenRadioButton;
    private JRadioButton windowedRadioButton;
    private JCheckBox cbPlantInvulnerability;
    private JCheckBox cbNoLawnmower;
    private JCheckBox cbPlantDoubleSpeed;
    private JCheckBox cbPlantNoCooldown;
    private JSlider slSunValue;
    private JPanel StartingSun;
    private JCheckBox cbConeheadZombie;
    private JCheckBox cbBungeeZombie;
    private JCheckBox cbPoleVaultingZombie;
    private JCheckBox cbFootballZombie;
    private JCheckBox cbBucketheadZombie;
    private JSlider slZombieMovementSpeed;
    private JCheckBox cbSunflower;
    private JCheckBox cbSnowpea;
    private JCheckBox cbChomper;
    private JCheckBox cbGatlingPea;
    private JCheckBox cbRepeater;
    private JCheckBox cbWallNut;
    private JCheckBox cbCherrybomb;
    private JSlider slZombieSpawnRate;
    private JSlider slZombieDamage;
    private JSlider slZombieHealth;
    private JSlider slStartingSun;
    private JButton startButton;
    private JButton stopButton;
    private JProgressBar progressBar1;
    private JRadioButton lawnSummerRadioButton;
    private JRadioButton lawnFallRadioButton;
    private JRadioButton lawnNightRadioButton;
    private JRadioButton lawnWinterRadioButton;
    private JCheckBox cbInvisighoul;
    private JTabbedPane tabbedPane2;
    private JCheckBox cbFumeShroom;
    private JCheckBox cbDoomShroom;
    private JCheckBox cbIceShroom;
    private JCheckBox cbGloomShroom;
    private JCheckBox cbThreepeater;
    private JCheckBox cbTorchwoord;
    private JCheckBox cbJalapeno;
    private JCheckBox cbPumpkin;
    private JCheckBox cbCoffeeBean;
    private JCheckBox cbTallNut;
    private JCheckBox cbSpikeWeed;
    private JCheckBox cbSquash;
    private JCheckBox cbSpikeRock;
    private JCheckBox cbPotatoMine;
    private JCheckBox cbNewspaperZombie;
    private JCheckBox cbPogoZombie;
    private JCheckBox cbScreendoorZombie;
    private JCheckBox cbGargantuar;
    private JCheckBox cbZomboni;
    private JCheckBox cbDrSerato;
    private JTextPane tpZombies;
    private JTextPane tpPlants;
    private JCheckBox cbTwinSunflower;
    private JTextArea taPlants;
    private JTextArea taZombies;


    public static final int MAX_PLANT_COUNT = 8;

    GameSettings gameSettings;
    protected static final String filePath = "./data/settings.ser";


    protected Map<String, JCheckBox> zombiesMap = null;
    protected Map<String, JCheckBox> plantsMap = null;


    public void loadFromFile(String file) {
        try (
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream(file)
                )
        ) {
            gameSettings = (GameSettings) ois.readObject();

            cbPlantInvulnerability.setSelected(gameSettings.plantInvulnerable);
            cbPlantNoCooldown.setSelected(gameSettings.plantNoCooldown);
            cbPlantDoubleSpeed.setSelected(gameSettings.plantDoubleSpeed);
            cbNoLawnmower.setSelected(gameSettings.noLawnmower);

            slSunFallRate.setValue(gameSettings.sunFallRate);
            slSunValue.setValue(gameSettings.sunSunValue);
            slStartingSun.setValue(gameSettings.startingSun);

            cbInvisighoul.setSelected(gameSettings.zombieInvisighoul);
            slZombieHealth.setValue(gameSettings.zombieHealthMultiplier);
            slZombieDamage.setValue(gameSettings.zombieDamageMultiplier);
            slZombieMovementSpeed.setValue(gameSettings.zombieMovementSpeedMultiplier);
            slZombieSpawnRate.setValue(gameSettings.zombieSpawnRateMultiplier);

            for (Map.Entry<String, JCheckBox> entry : plantsMap.entrySet()) {
                entry.getValue().setSelected(false);
            }

            for (Map.Entry<String, JCheckBox> entry : zombiesMap.entrySet()) {
                entry.getValue().setSelected(false);
            }

            for (String s : gameSettings.selectedPlants) {
                (plantsMap.get(s)).setSelected(true);
            }

            for (String s : gameSettings.selectedZombies) {
                (zombiesMap.get(s)).setSelected(true);
            }

            tpPlants.setText("");
            for (String p : gameSettings.selectedPlants) {
                tpPlants.setText(tpPlants.getText() + p + "\n");
            }

            tpZombies.setText("");
            for (String z : gameSettings.selectedZombies) {
                tpZombies.setText(tpZombies.getText() + z + "\n");
            }

            System.out.println("Game settings loaded from file successfully.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Game settings could not be loaded! Initializing default settings!");
            gameSettings = new GameSettings();
        }
    }

    public static String cleanString(String s) {
        return s.replaceAll("\\s", "");
    }

    public PVZLevelEditor() {

        zombiesMap = new HashMap<>();
        plantsMap = new HashMap<>();

        zombiesMap.put("Zombie", cbZombie);
        zombiesMap.put("ConeheadZombie", cbConeheadZombie);
        zombiesMap.put("BucketheadZombie", cbBucketheadZombie);
        zombiesMap.put("FootballZombie", cbFootballZombie);
        zombiesMap.put("PoleVaultingZombie", cbPoleVaultingZombie);
        zombiesMap.put("NewspaperZombie", cbNewspaperZombie);
        zombiesMap.put("PogoZombie", cbPogoZombie);
        zombiesMap.put("ScreendoorZombie", cbScreendoorZombie);
        zombiesMap.put("GargantuarZombie", cbGargantuar);
        zombiesMap.put("BungeeZombie", cbBungeeZombie);

        plantsMap.put("Sunflower", cbSunflower);
        plantsMap.put("TwinSunflower", cbTwinSunflower);
        plantsMap.put("Peashooter", cbPeashooter);
        plantsMap.put("Repeater", cbRepeater);
        plantsMap.put("GatlingPea", cbGatlingPea);
        plantsMap.put("PotatoMine", cbPotatoMine);
        plantsMap.put("Cherrybomb", cbCherrybomb);
        plantsMap.put("WallNut", cbWallNut);
        plantsMap.put("Chomper", cbChomper);
        plantsMap.put("Snowpea", cbSnowpea);

        plantsMap.put("FumeShroom", cbFumeShroom);
        plantsMap.put("GloomShroom", cbGloomShroom);
        plantsMap.put("IceShroom", cbIceShroom);
        plantsMap.put("DoomShroom", cbDoomShroom);

        plantsMap.put("Threepeater", cbThreepeater);
        plantsMap.put("Squash", cbSquash);
        plantsMap.put("SpikeWeed", cbSpikeWeed);
        plantsMap.put("SpikeRock", cbSpikeRock);
        plantsMap.put("TallNut", cbTallNut);
        plantsMap.put("Jalapeno", cbJalapeno);
        plantsMap.put("Torchwood", cbTorchwoord);

        plantsMap.put("Pumpkin", cbPumpkin);
        plantsMap.put("CoffeeBean", cbCoffeeBean);

        loadFromFile(filePath);

        ActionListener cbPlantsActionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox cbPlant = ((JCheckBox)e.getSource());
                String pName = cbPlant.getText();
                boolean isSelected = cbPlant.isSelected();

                if (isSelected) {
                    if (gameSettings.selectedPlants.size() == MAX_PLANT_COUNT) {
                        JOptionPane.showMessageDialog(null, "Maximum plant count! Remove one to add " + pName + " to the list", "Max Plant Count", JOptionPane.WARNING_MESSAGE);
                        cbPlant.setSelected(false);
                    } else {
                        gameSettings.selectedPlants.add(cleanString(pName));
                    }
                } else {
                    gameSettings.selectedPlants.remove(cleanString(pName));
                }

                tpPlants.setText("");
                for (String p : gameSettings.selectedPlants) {
                    tpPlants.setText(tpPlants.getText() + p + "\n");
                }

            }
        };

        for (Map.Entry<String, JCheckBox> entry : plantsMap.entrySet()) {
            entry.getValue().addActionListener(cbPlantsActionListener);
        }

        ActionListener cbZombiesActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JCheckBox cbZombie = ((JCheckBox)e.getSource());
                String zName = cbZombie.getText();
                boolean isSelected = cbZombie.isSelected();


                if (isSelected) {
                    gameSettings.selectedZombies.add(cleanString(zName));
                } else {
                    gameSettings.selectedZombies.remove(cleanString(zName));
                }

                tpZombies.setText("");
                for (String z : gameSettings.selectedZombies) {
                    tpZombies.setText(tpZombies.getText() + z + "\n");
                }
            }
        };

        for (Map.Entry<String, JCheckBox> entry : zombiesMap.entrySet()) {
            entry.getValue().addActionListener(cbZombiesActionListener);
        }


        saveChangesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (
                        ObjectOutputStream oos = new ObjectOutputStream(
                                new FileOutputStream(filePath)
                        )
                ) {
                    oos.writeObject(gameSettings);
                    System.out.println("Game state saved to file successfully.");
                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
        });


        resetToDefaultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFromFile("./data/default.ser");
            }
        });

        cbPlantInvulnerability.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.plantInvulnerable = ((JCheckBox)(e.getSource())).isSelected();
            }
        });

        cbPlantNoCooldown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.plantNoCooldown = ((JCheckBox)(e.getSource())).isSelected();
            }
        });

        cbPlantDoubleSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.plantDoubleSpeed = ((JCheckBox)(e.getSource())).isSelected();
            }
        });

        cbNoLawnmower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.noLawnmower = ((JCheckBox)(e.getSource())).isSelected();
            }
        });

        slSunFallRate.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.sunFallRate = ((JSlider)(e.getSource())).getValue();
            }
        });
        slSunValue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.sunSunValue = ((JSlider)(e.getSource())).getValue();
            }
        });
        slStartingSun.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.startingSun = ((JSlider)(e.getSource())).getValue();
            }
        });
        slZombieHealth.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.zombieHealthMultiplier = ((JSlider)(e.getSource())).getValue();
            }
        });
        slZombieDamage.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.zombieDamageMultiplier = ((JSlider)(e.getSource())).getValue();
            }
        });
        slZombieMovementSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.zombieMovementSpeedMultiplier = ((JSlider)(e.getSource())).getValue();
            }
        });
        slZombieSpawnRate.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.zombieSpawnRateMultiplier = ((JSlider)(e.getSource())).getValue();
            }
        });
        comboMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m = (String)((JComboBox<?>)e.getSource()).getSelectedItem();
                gameSettings.music = "bg" + m.charAt(3);
            }
        });

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.window = ((JRadioButton)e.getSource()).getText();
            }
        };

        fullscreenRadioButton.addActionListener(listener);
        windowedRadioButton.addActionListener(listener);

        cbInvisighoul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.zombieInvisighoul = ((JCheckBox)e.getSource()).isSelected();
            }
        });

        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.background = ((JRadioButton)e.getSource()).getText();
            }
        };

        lawnSummerRadioButton.addActionListener(listener1);
        lawnFallRadioButton.addActionListener(listener1);
        lawnNightRadioButton.addActionListener(listener1);
        lawnWinterRadioButton.addActionListener(listener1);

        cbDrSerato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.isBossFight = ((JCheckBox)e.getSource()).isSelected();
            }
        });
    }

    public static void main(String[] args) {
        PVZLevelEditor app = new PVZLevelEditor ();
        app.setContentPane(app.body);
        app.setSize(1200, 800);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("PvZ Level Editor");
        app.setVisible(true);
        app.setLocationRelativeTo(null);
    }

}
