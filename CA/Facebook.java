import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.control.PasswordField;
import javafx.scene.text.*;

// Facebook Application
public class Facebook extends Application
{
   // Facebook has 2 Scenes that uses BorderPane as its Layout Pane
   private Scene scene1, scene2;
   //Scene1 variables
   //BorderPane layout
   private BorderPane sceneLayout;
   // and has a subPane (top) that uses GridPane, 
   private GridPane p1;
   // with 1 Labels, and 2 TextFields, and 2 buttons
   private TextField email1, password1;
   private Button logIn,signUp;
   private Label fb;
   // a subpane (bottom) that uses StackPane
   private StackPane p2;
   // Scene2 Variables
   //BorderPane layout
   private BorderPane sceneLayout2;
   // and has a subPane (right) that uses GVBox, 
   private VBox p3;
   // with 1 Labels, and 4 TextFields, and a Button
   private Button signUp2;
   private TextField fName,lName, email2, password2;
   private Label fb1;
   // a subpane (left) that uses StackPane
   private StackPane p4;


   @Override
   public void start(Stage primaryStage)
   {
      // Construct p1
      p1=new GridPane();
      //Constructs a border around the gridPnae
      p1.setBorder(new Border(new BorderStroke(Color.BLACK,
                                      BorderStrokeStyle.SOLID,
                                      new CornerRadii(0),
                                      new BorderWidths(1))));
      //Constructs the Labels,texfields and buttons
      p1.add(new Label("Email:"),0,0);
      p1.add(new Label("Password:"),0,1);  
      p1.add(email1=new TextField(),1,0);                    
      PasswordField passwordField = new PasswordField();
      p1.add(passwordField, 1, 1);           
      p1.add(logIn=new Button("Log In"),2,0); 
      //Sets the background of the button to Alice Blue
      logIn.setStyle("-fx-background-color: #f0f8ff; ");
      //Constructs the border around the button
      logIn.setBorder(new Border(new BorderStroke(Color.BLACK,
                                      BorderStrokeStyle.SOLID,
                                      new CornerRadii(0),
                                      new BorderWidths(1))));
      //Sets the button to the max width of the coloumn
      logIn.setMaxWidth(Double.MAX_VALUE);          
      p1.add(signUp=new Button("Sign Up"),2,1);
      signUp.setStyle("-fx-background-color: #f0f8ff; ");
      signUp.setBorder(new Border(new BorderStroke(Color.BLACK,
                                      BorderStrokeStyle.SOLID,
                                      new CornerRadii(0),
                                      new BorderWidths(1))));  
      signUp.setMaxWidth(Double.MAX_VALUE); 
      //Lamba expression event handler for the sign up button
      signUp.setOnAction(
         e -> {
         //Switches the scene from scene1 to scene2
            primaryStage.setScene(scene2);
         }); 
      //Creates a coloumn split of 25, 50, 25
      ColumnConstraints col1 = new ColumnConstraints();
      col1.setPercentWidth(25);
      ColumnConstraints col2 = new ColumnConstraints();
      col2.setPercentWidth(50);
      ColumnConstraints col3 = new ColumnConstraints();
      col3.setPercentWidth(25);
      p1.getColumnConstraints().addAll(col1,col2,col3);
      
      // Construct p2
      p2=new StackPane();
      //Constructs a border around p2
      p2.setBorder(new Border(new BorderStroke(Color.BLACK,
                                      BorderStrokeStyle.SOLID,
                                      new CornerRadii(0),
                                      new BorderWidths(1))));
      //Adds the label with the facebook png
      p2.getChildren().add(fb=new Label("", new ImageView("facebook.png"))); 
           
      // Construct sceneLayout
      sceneLayout=new BorderPane();
      // and setTop() of sceneLayout to p1                                
      sceneLayout.setTop(p1);
      // and setCenter() of sceneLayout to p2                                
      sceneLayout.setCenter(p2);
     
      // Construct scene1
      scene1=new Scene(sceneLayout);
      
      //Start of scene2
      VBox p3=new VBox();
      //Constructs a border around the VBox
      p3.setBorder(new Border(new BorderStroke(Color.BLACK,
                                      BorderStrokeStyle.SOLID,
                                      new CornerRadii(0),
                                      new BorderWidths(1))));
      //Adss a label, 4 textfields and a button 
      p3.getChildren().add(fb = new Label("Sign Up")); 
      fb.setMaxWidth(Double.MAX_VALUE); 
      //Sets the font to SanSerif and the style to bold
      fb.setFont(Font.font("SanSerif",FontWeight.BOLD,18));
      fb.setBorder(new Border(new BorderStroke(Color.BLACK,
                                      BorderStrokeStyle.SOLID,
                                      new CornerRadii(0),
                                      new BorderWidths(1))));
      p3.getChildren().add(fName=new TextField("Enter First Name"));  
      //Sets the colour of the text in the textfield to grey
      fName.setStyle("-fx-text-inner-color: grey;"); 
      p3.getChildren().add(lName=new TextField("Enter Last Name"));
      lName.setStyle("-fx-text-inner-color: grey;"); 
      p3.getChildren().add(email2=new TextField("Enter Email")); 
      email2.setStyle("-fx-text-inner-color: grey;"); 
      p3.getChildren().add(password2=new TextField("Enter Password")); 
      password2.setStyle("-fx-text-inner-color: grey;");                        
      p3.getChildren().add(signUp2=new Button("Sign Up"));
      signUp2.setBorder(new Border(new BorderStroke(Color.BLACK,
                                      BorderStrokeStyle.SOLID,
                                      new CornerRadii(0),
                                      new BorderWidths(1)))); 
      //Sets the font to SanSerif and the style to bold
      signUp2.setFont(Font.font("SanSerif",FontWeight.BOLD,18));
      //Sets button background colour to Alice Blue
      signUp2.setStyle("-fx-background-color: #f0f8ff; ");
      signUp2.setMaxWidth(Double.MAX_VALUE);    
      //Lamba expression event handler for the sign up button
      signUp2.setOnAction(
         e -> {
         //Switches the scene from scene1 to scene2
            primaryStage.setScene(scene1);
         });       
      
      // Construct p4
      p4=new StackPane();
      p4.setBorder(new Border(new BorderStroke(Color.BLACK,
                                      BorderStrokeStyle.SOLID,
                                      new CornerRadii(0),
                                      new BorderWidths(1))));
      // setAlignment() on p4 Pos.CENTER
      p4.setAlignment(Pos.CENTER);
      //Adds a label with the image of facebook
      p4.getChildren().add(fb=new Label("", new ImageView("facebook.png")));   
           
      // Construct sceneLayout
      sceneLayout2=new BorderPane();
      // and setRight() of sceneLayout to p3                              
      sceneLayout2.setRight(p3);
      // and setLeft() of sceneLayout to p4                            
      sceneLayout2.setLeft(p4);
     
      // Construct scene2
      scene2=new Scene(sceneLayout2);
      
      //The application begins with scene1 being displayed first
      primaryStage.setScene(scene1);
      primaryStage.setTitle("Facebook");
      primaryStage.show(); 
   
   }
   
}

