package ua.opnu.list;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SortingList extends Application {

    private ObservableList<Student> students;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Список студентів");

        students = populateList();

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(5));
        vbox.setAlignment(Pos.CENTER);

        ListView<Student> listView = new ListView<>(students);
        listView.setPrefSize(400, 240);

        HBox hbox = setButtons();

        vbox.getChildren().addAll(listView, hbox);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private ObservableList<Student> populateList() {
        Student s1 = new Student("Борис", "Іванов", 75);
        Student s2 = new Student("Петро", "Петренко", 92);
        Student s3 = new Student("Сергій", "Сергієнко", 61);
        Student s4 = new Student("Григорій", "Сковорода", 88);

        return FXCollections.observableArrayList(s1, s2, s3, s4);
    }

    private HBox setButtons() {
        Button sortByNameButton = new Button("Сортувати за ім'ям");
        Button sortByLastNameButton = new Button("Сортувати за прізвищем");
        Button sortByMarkButton = new Button("Сортувати за оцінкою");

        HBox.setHgrow(sortByNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByLastNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByMarkButton, Priority.ALWAYS);

        sortByNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByLastNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByMarkButton.setMaxWidth(Double.MAX_VALUE);

        final boolean[] orderName = {true};
        final boolean[] orderSurname = {true};
        final boolean[] orderMark = {true};

        sortByNameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                students.sort(new NameSorter(orderName[0]));
                orderName[0] = !orderName[0];
            }
        });

        sortByLastNameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                students.sort(new SurnameSorter(orderSurname[0]));
                orderSurname[0] = !orderSurname[0];
            }
        });

        sortByMarkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                students.sort(new MarkSorter(orderMark[0]));
                orderMark[0] = !orderMark[0];
            }
        });

        HBox hb = new HBox(5);
        hb.getChildren().addAll(sortByNameButton, sortByLastNameButton, sortByMarkButton);
        hb.setAlignment(Pos.CENTER);
        return hb;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
