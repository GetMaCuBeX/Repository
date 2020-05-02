package com.mgrecol.jasper.window.displayreport;

import database.Database;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;

public class LayoutController implements Initializable {

    @FXML
    public BorderPane borderPane;
    @FXML
    public Button btnShowReport;
    @FXML
    public ImageView reportHolder;
    private JasperPrint jasperPrint;
    private List<Integer> pages;
    private Double zoomFactor;
    private double imageHeight;
    private double imageWidth;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // THREAD
        new Thread() {
            @Override
            public void run() {
                try {
                    // I USE THIS TO CACHE THE PROCESS TO MINIMIZE THE NEXT COMPILATION - UP TO YOU
                    // COMPILE OTHER REPORT
                    long COMPILE_OTHER_REPORT = System.currentTimeMillis();
                    JasperCompileManager.compileReport(System.getProperty("user.dir") + "/reports/membersInformation.jrxml");
                    System.out.println("Compiling Other Report: " + (System.currentTimeMillis() - COMPILE_OTHER_REPORT) + "ms");
                } catch (JRException ex) {
                    System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
                    System.err.println(ex.fillInStackTrace());
                }
            }
        }.start();
    }

    Stage stageWindow;
    double x, y;

// ============================================================================= TITLE BAR DRAGGING
    @FXML
    public void dragged(MouseEvent event) {
        stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageWindow.setX(event.getScreenX() - x);
        stageWindow.setY(event.getScreenY() - y);
    }

    @FXML
    public void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void reportShow1(ActionEvent event) {
        try {

            fillJasperPrint(1);
            long SETIMAGE = System.currentTimeMillis();
            reportHolder.setImage(getImage(0));
            System.out.println("Changing Image: " + (System.currentTimeMillis() - SETIMAGE) + "ms");

//            if (jasperPrint.getPages().size() > 0) {
//
//                pages = new ArrayList<Integer>();
//                for (int i = 0; i < jasperPrint.getPages().size(); i++) {
//                    pages.add(i + 1);
//                }
//            }
//            reportHolder.setFitHeight(imageHeight * zoomFactor);
//            reportHolder.setFitWidth(imageWidth * zoomFactor);
        } catch (Exception ex) {
            System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
            System.err.println(ex.fillInStackTrace());
        }
    }

    @FXML
    void reportShow2(ActionEvent event) {
        try {
            fillJasperPrint(2);
            long SETIMAGE = System.currentTimeMillis();
            reportHolder.setImage(getImage(0));
            System.out.println("Changing Image: " + (System.currentTimeMillis() - SETIMAGE) + "ms");
        } catch (Exception ex) {
            System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
            System.err.println(ex.fillInStackTrace());
        }
    }

    @FXML
    void reportShow3(ActionEvent event) {
        try {
            fillJasperPrint(3);
            long SETIMAGE = System.currentTimeMillis();
            reportHolder.setImage(getImage(0));
            System.out.println("Changing Image: " + (System.currentTimeMillis() - SETIMAGE) + "ms");
        } catch (Exception ex) {
            System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
            System.err.println(ex.fillInStackTrace());
        }
    }

// ============================================================================= TITLE BAR 
    @FXML
    public void draggedDoubleClick(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        if (event.getClickCount() == 2) {
            if (stage.isFullScreen()) {
                stage.setFullScreen(false);
            } else {
                stage.setFullScreen(true);
            }
        }
    }

    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void maximize(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreenExitHint("");
//        Stage.setFullScreenExitKeyCombination(KeyCombination);
        if (stage.isFullScreen()) {
            stage.setFullScreen(false);
        } else {
            stage.setFullScreen(true);
        }

    }

    @FXML
    public void minimize(MouseEvent event) {
        Stage stage = null;
        if (event.getClickCount() == 1) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            if (stage.isIconified()) {
                stage.setIconified(false);
            } else {
                stage.setIconified(true);
            }
        }
    }

//============================================================================== RETURN REPORTS
    private WritableImage getImage(int pageNumber) {
        BufferedImage image = null;
        try {
            image = (BufferedImage) JasperPrintManager.printPageToImage(jasperPrint, pageNumber, 2);
        } catch (JRException ex) {
            System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
            System.err.println(ex.fillInStackTrace());
        }
        WritableImage fxImage = new WritableImage(jasperPrint.getPageWidth(), jasperPrint.getPageHeight());
        return SwingFXUtils.toFXImage(image, fxImage);
    }

    private void fillJasperPrint(int id) {
        try {
            String location = System.getProperty("user.dir") + "/reports/reportthis.jrxml";
            // DATABASE
            long DATABASE = System.currentTimeMillis();
            Connection conn = Database.getConnectionMySQL(Database.BOOKS_RESERVATION);
            System.out.println("Connecting Server: " + (System.currentTimeMillis() - DATABASE) + "ms");
            // PARAMETERS 
            HashMap parameters = new HashMap();
            parameters.put("idmembers", id);
            // COMPILE 
            long COMPILE = System.currentTimeMillis();
            JasperReport report = JasperCompileManager.compileReport(location);
            System.out.println("Compiling: " + (System.currentTimeMillis() - COMPILE) + "ms");
            //PRINT 
            long PRINT = System.currentTimeMillis();
            jasperPrint = JasperFillManager.fillReport(report, parameters, conn);
            System.out.println("Printing: " + (System.currentTimeMillis() - PRINT) + "ms");
        } catch (Exception ex) {
            System.err.println(String.format("[EXCEPTION ERROR][LINE#:%s] @ [%s.%s.class]", Thread.currentThread().getStackTrace()[1].getLineNumber(), getClass().getPackage(), getClass().getSimpleName()));
            System.err.println(ex.fillInStackTrace());

        }
    }

}
