package pogorelov;

import controller.wallChangerController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main extends Application {

    public static Stage primaryStage;
    public static Stage getStage() {
        return Main.primaryStage;
    }

    public void start(final Stage primaryStage) throws Exception {
        createFolder();
        this.primaryStage = primaryStage;
        primaryStage.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("/pogorelov/resourses/icons/icon32.png")));
        primaryStage.setTitle("WallChanger");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/wallChangerWindow.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

        primaryStage.iconifiedProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue){
                Platform.runLater(() -> {
                    primaryStage.setIconified(false);
                    primaryStage.hide();
                });
            }
        }));
        //чтоб не закрылось после сокрытия окна
        Platform.setImplicitExit(false);
        //что то там синхранизирует
        javax.swing.SwingUtilities.invokeLater(this::addAppToTray);

    }


    public static void main(String[] args) throws IOException {
        launch(args);

    }



    private void addAppToTray() {
        try {
            java.awt.Toolkit.getDefaultToolkit();

            java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();
            java.awt.Image image = ImageIO.read(Main.class.getResource("/pogorelov/resourses/icons/Wallpaper-Roll-icon.png"));
            java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(image);



            java.awt.MenuItem exitItem = new java.awt.MenuItem("Выход");
            exitItem.addActionListener(event -> {
                wallChangerController.getTimer().cancel();
                Platform.exit();
                tray.remove(trayIcon);
            });

            final java.awt.PopupMenu popup = new java.awt.PopupMenu();
            popup.add(exitItem);
            trayIcon.setPopupMenu(popup);

            //добавляет значок приложения в трей.
            tray.add(trayIcon);

        } catch (java.awt.AWTException | IOException e) {
            System.out.println("Не удается добавить в системный трей");
            e.printStackTrace();
        }
    }

     public static String userPath = System.getProperty("user.home");
     File directory = new File(userPath + "/Pictures/WallChanger");


    public void createFolder() throws Exception {
        if(!directory.exists()) {
            directory.mkdir();

            InputStream inpStream;
            Path target;

            try {

                inpStream = Main.class.getClassLoader().getResourceAsStream("pogorelov/resourses/walls/2.jpg");
                target = Paths.get(userPath + "/Pictures/WallChanger/2.jpg");
                Files.copy(inpStream, target, REPLACE_EXISTING);

                inpStream = Main.class.getClassLoader().getResourceAsStream("pogorelov/resourses/walls/3.jpg");
                target = Paths.get(userPath + "/Pictures/WallChanger/3.jpg");
                Files.copy(inpStream, target, REPLACE_EXISTING);

                inpStream = Main.class.getClassLoader().getResourceAsStream("pogorelov/resourses/walls/4.jpg");
                target = Paths.get(userPath + "/Pictures/WallChanger/4.jpg");
                Files.copy(inpStream, target, REPLACE_EXISTING);

                inpStream = Main.class.getClassLoader().getResourceAsStream("pogorelov/resourses/walls/5.jpg");
                target = Paths.get(userPath + "/Pictures/WallChanger/5.jpg");
                Files.copy(inpStream, target, REPLACE_EXISTING);

                inpStream = Main.class.getClassLoader().getResourceAsStream("pogorelov/resourses/walls/6.jpg");
                target = Paths.get(userPath + "/Pictures/WallChanger/6.jpg");
                Files.copy(inpStream, target, REPLACE_EXISTING);

                inpStream = Main.class.getClassLoader().getResourceAsStream("pogorelov/resourses/walls/7.jpg");
                target = Paths.get(userPath + "/Pictures/WallChanger/7.jpg");
                Files.copy(inpStream, target, REPLACE_EXISTING);

                inpStream.close();

            } catch (IOException e) {
                e.printStackTrace(System.out);
            }

        }
    }








}
