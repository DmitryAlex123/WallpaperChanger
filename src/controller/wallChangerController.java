package controller;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import com.sun.javafx.collections.ElementObservableListDecorator;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.NumPath;
import model.timing;
import pogorelov.ChagneImage;
import pogorelov.Main;

import java.io.File;
import java.net.URL;
import java.util.*;

public class wallChangerController implements Initializable {

    @FXML
    ComboBox combobox;

    @FXML
    Button out;

    @FXML
    Button in;

    private static ArrayList<File> folderItemsList = new ArrayList<>();
    public static ArrayList<File> getList(){
        return folderItemsList;
    }

    public void initialize(URL location, ResourceBundle resources) {
        out.setVisible(false);

        for (File file : (new File(Main.userPath + "/Pictures/WallChanger").listFiles())){
            folderItemsList.add(file);
        };

        ObservableList<timing> list =  FXCollections.observableArrayList();
        list.add(new timing("15 секунд", 15000));
        list.add(new timing("30 секунд", 30000));
        list.add(new timing("1 минута", 60000));
        list.add(new timing("3 минуты", 180000));
        combobox.setItems(list);
        combobox.getSelectionModel().selectFirst();

    }

    static Timer timer = new Timer();

    public static Timer getTimer(){
        return timer;
    }

    public void start(){
        timing t = (timing) combobox.getSelectionModel().getSelectedItem();
        long second = t.getMicrosecond();
        timer.schedule(new ChagneImage(), 0, second);
        in.setVisible(false);
        out.setVisible(true);
        Main.getStage().setIconified(true);
    }

    public void exit(){
        timer.cancel();
        Platform.exit();
    }

}
