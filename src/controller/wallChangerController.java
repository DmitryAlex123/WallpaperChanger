package controller;

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
import java.net.URL;
import java.util.*;

public class wallChangerController implements Initializable {

    @FXML
    ComboBox combobox;

    @FXML
    Button out;

    @FXML
    Button in;

    private static ArrayList<NumPath> pathList;

    public static ArrayList<NumPath> getPathList(){
        return pathList;
    }

    public void initialize(URL location, ResourceBundle resources) {
        out.setVisible(false);
        pathList = new ArrayList<NumPath>();
        pathList.add(new NumPath(0, "C:\\Users\\pdai\\Pictures\\Мои обои\\1.jpg"));
        pathList.add(new NumPath(1, "C:\\Users\\pdai\\Pictures\\Мои обои\\2.jpg"));
        pathList.add(new NumPath(2, "C:\\Users\\pdai\\Pictures\\Мои обои\\3.jpg"));
        pathList.add(new NumPath(3, "C:\\Users\\pdai\\Pictures\\Мои обои\\4.jpg"));
        pathList.add(new NumPath(4, "C:\\Users\\pdai\\Pictures\\Мои обои\\5.jpg"));
        pathList.add(new NumPath(5, "C:\\Users\\pdai\\Pictures\\Мои обои\\6.jpg"));
        pathList.add(new NumPath(6, "C:\\Users\\pdai\\Pictures\\Мои обои\\7.jpg"));
        pathList.add(new NumPath(7, "C:\\Users\\pdai\\Pictures\\Мои обои\\8.jpg"));
        pathList.add(new NumPath(8, "C:\\Users\\pdai\\Pictures\\Мои обои\\9.jpg"));
        pathList.add(new NumPath(9, "C:\\Users\\pdai\\Pictures\\Мои обои\\10.jpg"));
        pathList.add(new NumPath(10, "C:\\Users\\pdai\\Pictures\\Мои обои\\11.jpg"));
        pathList.add(new NumPath(11, "C:\\Users\\pdai\\Pictures\\Мои обои\\12.jpg"));
        pathList.add(new NumPath(12, "C:\\Users\\pdai\\Pictures\\Мои обои\\13.jpg"));
        pathList.add(new NumPath(13, "C:\\Users\\pdai\\Pictures\\Мои обои\\14.jpg"));
        pathList.add(new NumPath(14, "C:\\Users\\pdai\\Pictures\\Мои обои\\15.jpg"));
        pathList.add(new NumPath(15, "C:\\Users\\pdai\\Pictures\\Мои обои\\16.jpg"));
        pathList.add(new NumPath(16, "C:\\Users\\pdai\\Pictures\\Мои обои\\17.jpg"));


        ObservableList<timing> list =  FXCollections.observableArrayList();
        list.add(new timing("10 секунд", 10000));
        list.add(new timing("30 секунд", 30000));
        list.add(new timing("1 минута", 60000));
        list.add(new timing("3 минуты", 180000));
        combobox.setItems(list);
        combobox.getSelectionModel().selectFirst();

    }

    Timer timer = new Timer();

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
