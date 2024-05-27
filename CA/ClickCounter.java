import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import java.text.DecimalFormat;

// STEP 1 - Create a Stage 
// STEP 2 - Decide on Layout of Scene & add it to Stage
// STEP 3 - Declare controls of GUI as Instance Variables
// STEP 4 - Build sizePane and add to Scene
// STEP 5 - Build extrasPane and add to Scene
// STEP 6 - Build button and add to Scene
// STEP 7 - Build pricePane and add to Scene
// STEP 8 - Create and Register a basic Listener with button
// STEP 9 - Get Listener working fully

// PizzaMenu IS-A Application ==> Inheritance
public class PizzaOrder extends Application{
   // PizzaOrder HAS-A Scene that uses BorderPane as its Layout Pane
   private Scene scene;
   private BorderPane sceneLayout;
   
   // It has a VBox with a Label and 3 RadioButtons...
   private VBox leftPane;
   private Label lblSize;
   private RadioButton rbSmall, rbMedium, rbLarge;
   private ToggleGroup tgSize;
   
   // ... a VBox with a Label and 3 CheckBoxes...
   private VBox middlePane;
   private Label lblToppings;
   private CheckBox cbHam, cbMushrooms, cbCheese, cbOnions;
      
   // ... a Button, and...
   private Button btTotal;
   
   // ... a HBox with a Label
   private HBox bottomPane;
   private Label lblPrice;
      
   @Override
   public void start(Stage primaryStage){
		/////////
      // Build btTotal
      /////////
	 	// Construct btTotal with text and a graphic
		btTotal = new Button("_TOTAL", new ImageView("image/euro.jpg"));   
      // Set the properties of btTotal-Font,MaxHeight,ContentDisplay,Border
		btTotal.setFont(Font.font("Helvetica",FontWeight.BOLD,22));
      btTotal.setMaxHeight(Double.MAX_VALUE);
      btTotal.setContentDisplay(ContentDisplay.TOP);
      btTotal.setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(0),
                        new BorderWidths(1))));

   	////////
      // Build scene
      ////////     
      // Construct the BorderPane node called sceneLayout...
      sceneLayout = new BorderPane();
      sceneLayout.setLeft(getLeftPane());      // sizePane to left
      sceneLayout.setCenter(getMiddlePane());  // extrasPane to center
      sceneLayout.setRight(btTotal);      // btTotal to right
      sceneLayout.setBottom(getBottomPane());
      
      // Construct scene to contain sceneLayout
      scene=new Scene(sceneLayout);
      
      // ...setScene() of primaryStage to scene created
      primaryStage.setScene(scene);      
      primaryStage.setTitle("PIZZA ORDER");
      primaryStage.show();            
   }
   
   ////////
   // Build and return leftPane
   ////////
   private VBox getLeftPane()
   {
      leftPane=new VBox(5);
      leftPane.setPadding(new Insets(5));
      leftPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                                        BorderStrokeStyle.SOLID,
                                        new CornerRadii(0),
                                        new BorderWidths(1))));
      
      leftPane.getChildren().add(lblSize=new Label("SIZE"));
      lblSize.setFont(Font.font("Helvatica",FontWeight.BOLD,12));
      leftPane.getChildren().add(rbSmall=new RadioButton("Small"));
      leftPane.getChildren().add(rbMedium=new RadioButton("Medium"));
      leftPane.getChildren().add(rbLarge=new RadioButton("Large"));
      rbSmall.setSelected(true);
      tgSize=new ToggleGroup();
      rbSmall.setToggleGroup(tgSize);
      rbMedium.setToggleGroup(tgSize);
      rbLarge.setToggleGroup(tgSize);
      
      return leftPane;
   }

   ////////
   // Build and return middlePane
   ////////
   private VBox getMiddlePane()
   {
      middlePane = new VBox(5);
      middlePane.setPadding(new Insets(5));  
      middlePane.setBorder(new Border(new BorderStroke(Color.BLACK,
                                      BorderStrokeStyle.SOLID,
                                      new CornerRadii(0),
                                      new BorderWidths(1))));
      // Add controls to rightPane
      middlePane.getChildren().add(lblToppings=new Label("TOPPINGS"));
      lblToppings.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
      middlePane.getChildren().add(cbHam=new CheckBox("Ham"));
      middlePane.getChildren().add(cbMushrooms=new CheckBox("Mushrooms"));
      middlePane.getChildren().add(cbCheese=new CheckBox("Cheese"));
      middlePane.getChildren().add(cbOnions=new CheckBox("Onions"));      

      return middlePane;
   }
   
   ////////
   // Build and return bottomPane
   ////////
   private HBox getBottomPane()
   {
      bottomPane=new HBox();
      bottomPane.setAlignment(Pos.CENTER);
      bottomPane.setPadding(new Insets(5));
      bottomPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                                        BorderStrokeStyle.SOLID,
                                        new CornerRadii(0),
                                        new BorderWidths(1))));

      bottomPane.getChildren().add(lblPrice=new Label("PIZZA PRICE 0.00"));
      lblPrice.setFont(Font.font("Helvatica",FontWeight.BOLD,16));
      
      return bottomPane;
   }
}