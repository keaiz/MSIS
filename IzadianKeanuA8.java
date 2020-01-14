package sample;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.shape.Rectangle;
import javafx.beans.value.*;

import javax.swing.*;
//import all the necessary javafx packages


public class IzadianKeanuA8 extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    //entry point of our application program
    public void start(Stage myStage){


        myStage.setTitle("New Grad Application");

        //Over here, we initialze three rootnodes and scenes. Each scene for each of the three states/windows
        //this program will be in...
        FlowPane rootNode = new FlowPane(250,55);
        FlowPane rootNode1 = new FlowPane(250,55);
        FlowPane rootNode2 = new FlowPane(250,55);
        rootNode.setAlignment(Pos.TOP_CENTER);  //
        Scene myScene = new Scene(rootNode,400,900);//
        Scene myScene2 = new Scene(rootNode1,400,400);
        Scene myScene3 = new Scene(rootNode2, 400,200);


        myStage.setScene(myScene);


        //Create the list of titles
        ObservableList<String> titleTypes=
                FXCollections.observableArrayList("Mr.","Mrs.","Ms.","Dr.","Sir","Lord","Lady");

        //Create the list of skills
        ObservableList<String> skillTypes=
                FXCollections.observableArrayList("Java","C++","Python","Excel",
                        "R","SQL","Perl","Ruby","C","C#");


        Label f_name = new Label("First Name");
        TextField f_name1 = new TextField();
        //label and textfield for first name

        Label l_name = new Label("Last Name");
        TextField l_name1 = new TextField();
        //label and textfield for last name

        Label titles = new Label("Titles");
        ListView<String> lvTitles = new ListView<String>(titleTypes);
        lvTitles.setPrefHeight(100);
        //label for titles, and putting the list of titles into a scrollable listview

        Label genders = new Label("Gender");
        RadioButton rb1 = new RadioButton("Male");
        RadioButton rb2 = new RadioButton("Female");
        RadioButton rb3 = new RadioButton("Other");
        ToggleGroup group1= new ToggleGroup();
        rb1.setToggleGroup(group1);
        rb2.setToggleGroup(group1);
        rb3.setToggleGroup(group1);
        //creating gender label, and the radio button for each gender, and putting each button into one toggle group...

        Label uni = new Label("University");
        ComboBox<String> UniComboBox = new ComboBox<>();
        UniComboBox.getItems().addAll("Santa Clara University","UCLA","SJSU","UCSB");
        UniComboBox.setEditable(true);
        //creating label for university, and adding universities to the list to choose from.
        //also making it editable so that we can add a university if its not on the list

        Label skills = new Label("Skills");
        ListView<String> lvSkills = new ListView<String>(skillTypes);
        lvSkills.setPrefHeight(75);
        lvSkills.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //creating a list view and label for the skills, and scrollable
        //also making it so mulitple skills can be selected...

        Button review = new Button("Review");
        //and lastly, adding a review button

        Label exception_handle = new Label();
        //and finally, adding an exception handler label for the bottom, to tell the user what he/she did wrong



        f_name.setAlignment(Pos.CENTER_LEFT);


        VBox topper = new VBox(5);
        VBox topper2 = new VBox(5);
        VBox title_box = new VBox(5);
        VBox gender_box = new VBox(5);
        VBox uni_box = new VBox(5);
        VBox skill_box = new VBox(5);
        //created vertical boxes for a nice format, and to group labels and fields together accordingly



        topper.getChildren().addAll(f_name,f_name1);
        topper2. getChildren().addAll(l_name,l_name1);
        title_box.getChildren().add(titles);
        title_box.getChildren().add(lvTitles);
        //adding fields to each corresponding box


        gender_box.getChildren().add(genders);
        gender_box.getChildren().add(rb1);
        gender_box.getChildren().add(rb2);
        gender_box.getChildren().add(rb3);
        uni_box.getChildren().add(uni);
        uni_box.getChildren().add(UniComboBox);
        skill_box.getChildren().add(skills);
        skill_box.getChildren().add(lvSkills);
        skill_box.getChildren().add(review);
        skill_box.getChildren().add(exception_handle);
        //adding more fields to each corresponding box...



        //handling the event of when the review button is pushed.
        review.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if(f_name1.getText().equals("")|| l_name1.getText().equals("") ||UniComboBox.getSelectionModel().getSelectedItem()==null
                        ||lvTitles.getSelectionModel().getSelectedItem() == null|| (rb1.isSelected()==false
                && rb2.isSelected()==false&&rb3.isSelected()==false)|| UniComboBox.getSelectionModel().getSelectedItem().equals("")) {
                    //myStage.setScene(myScene);
                    exception_handle.setText("Please enter your title,full name, gender, and university.");}
                //exception handeling portion. if full name, gender, or university arent entered, it wont let you go to
                //the next stage of the application. skills dont need to be entered in our program...


                else
                {

                    //set new stage for reviewing information.
                    myStage.setScene(myScene2);
                    Button back = new Button("Back");
                    Label prompt1 = new Label("Thank you for your application, please review details below:");
                    rootNode1.setAlignment(Pos.TOP_CENTER);
                    rootNode1.getChildren().addAll(back,prompt1);
                    //add back button and review prompt first

                    VBox review_info = new VBox(2);

                    Label name_review = new Label(lvTitles.getSelectionModel().getSelectedItem() + " " + f_name1.getText() + " " +
                            l_name1.getText());
                    //adding entered name label



                    Label gender_review = new Label("Gender: " + rb1.getText());
                    if (rb1.isSelected()) {
                        gender_review = gender_review;
                    } else if (rb2.isSelected()) {
                        gender_review.setText("Gender: " + rb2.getText());
                    } else if (rb3.isSelected()) {
                        gender_review.setText("Gender: " + rb3.getText());
                    }//adding entered gender label


                    Label university_review = new Label("University: " + UniComboBox.getValue());
                    //adding entered university label


                    Label skills_review = new Label(
                            "Skills selected are: " +
                                    lvSkills.getSelectionModel().getSelectedItems().toString()
                                            .replace(",", "")
                                            .replace("[", "")
                                            .replace("]", "")
                                            .trim());
                    //adding entered sklls label

                    Button submit = new Button("Submit");
                    //and a submit button at the bottom.


                    review_info.getChildren().addAll(name_review, gender_review, university_review, skills_review, submit);
                    rootNode1.getChildren().addAll(review_info);
                    //adding to the vbox, then adding the vbox to the root node...


                    myStage.show();
                    //showing stage




                    //action handler for the back button. this is important
                    back.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            //we will clear the review scene, so that we can override it with new information from
                            //the initial application scene.
                            rootNode1.getChildren().clear();

                            //we go back to the original application scene if we press back. and we can update the info
                            myStage.setScene(myScene);


                        }
                    });

                    //action handler if we hit submit
                    //it simply gives us a label telling us we've submitted the  application...
                    submit.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            myStage.setScene(myScene3);
                            rootNode2.setAlignment(Pos.CENTER);
                            Label end_program = new Label("Congratulations! Application Sent.");
                            rootNode2.getChildren().add(end_program);
                            myStage.show();

                        }
                    });


                }
            }
        });


        //We're putting together all items, in this case our boxes, in the order we want them to appear, top down.....
        rootNode.getChildren().addAll(topper,topper2,title_box,gender_box,uni_box,skill_box);

        //Show our stage and reveal what we have created...... in our initial application scene.
        myStage.show();


    }





}