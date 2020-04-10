/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.main;

import java.io.IOException;
import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

 
class ScreensController extends StackPane {

    // holds the screen to be displayed
    // String = ID
    // Node = to group of the scene graph for the particular screen
    // bunch of tree structure
    private HashMap<String, Node> screens = new HashMap<>();

    public ScreensController() {
        super();
    }

    // add the screen to the controller
    public void addScreen(String nameID, Node parentRoot) {
        // add screen to the HashMap
        screens.put(nameID, parentRoot);
    }

    // return the node with the apporpreate name
    public Node getScreen(String nameID) {
        return screens.get(nameID);
    }

    // load the FXML file to the screen to the screen collection and
    // finnaly injects the screenPane to the Controller
    public boolean loadScreen(String hashID, String resource) {
        try {
            // CREATE fxmlloaderObj WITH FXML RESOUCE FILENAME
            FXMLLoader fxmlloaderObj = new FXMLLoader(getClass().getResource(resource));
            
            // LOAD the fxmlloaderObj TO THE Parent          
            Parent parentRoot = (Parent) fxmlloaderObj.load(); 
            
            // GET THE CONTROLLER OF THE fxmlloaderObj TO THE interfaceClass
            ControlledScreen interfaceClass = ((ControlledScreen) fxmlloaderObj.getController());
            
            // INJECT ScreensController TO THE interfaceClass
            interfaceClass.setScreenParent(this);
            
            // ADD TO THE HASHMAP
            addScreen(hashID, parentRoot);
            
            return true;
        } catch (IOException e) {
            System.err.println("-------------------------------- " + e.getMessage());
            return false;
        }
    }

    // This method tries to display the screen with a predefine name.
    // First it makes sure the screen has to be already loaded. Then if there is more than
    // one screen the new screen is been added second, and then the current screen is removed.
    // If there isn't any screen being displayed, the menu screen is just added to the root.
    public boolean setScreen(final String name) {
        if (screens.get(name) != null) { // screen loaded
            final DoubleProperty opacity = opacityProperty();
            int timeDuration = 500;

            if (!getChildren().isEmpty()) { // there is more than 1 screen
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(timeDuration), (ActionEvent t) -> {
                            getChildren().remove(0);
                            getChildren().add(0, screens.get(name));
                            Timeline fadeIn = new Timeline(
                                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                    new KeyFrame(new Duration(timeDuration), new KeyValue(opacity, 1.0)));
                            fadeIn.play();
                        } // end handle(ActionEvent t)
                                ,
                                 new KeyValue(opacity, 0.0))); // Timeline fade
                fade.play();
            } // end second if   
            else {
                setOpacity(0.0);
                getChildren().add(screens.get(name)); // no one else been display, then just show
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(timeDuration), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } // end first if 
        else {
            System.err.println("Screen hasn't been loaded!!! \n");
            return false;
        }
    }

    // this method will remove the screen with the given name from the collections of screen
    public boolean unloadScreen(String name) {
        // remove the screen from the hashmap
        if (screens.remove(name) == null) {
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }

}
