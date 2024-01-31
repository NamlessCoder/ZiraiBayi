package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

import com.isteMYSQL.Veritabanı;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GirişController {
	
	public GirişController() {
		baglanti = Veritabanı.Baglan();
	}
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_YKayit;

    @FXML
    private Button btn_giris;

    @FXML
    private Label lbl_sonuc;

    @FXML
    private TextField txt_kulad;

    @FXML
    private TextField txt_sifre;
    
    Connection baglanti=null;
    PreparedStatement sorgu = null;
    ResultSet getirilen = null;
    String sql;
    public static int yetkisi;
    public static String kullanıcı;
    
    @FXML
    void btn_YKayit_Click(ActionEvent event) {
    	try {
			Stage stage2 = new Stage();
			AnchorPane pane2 = (AnchorPane)FXMLLoader.load(getClass().getResource("yenikayit.fxml"));
			Scene scene2 = new Scene(pane2);
			stage2.setScene(scene2);
			stage2.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btn_giris_Click(ActionEvent event) {
    	sql = "select*from gi̇ri̇ş where Kullanıcı_AD=? and Sıfre=?";
    	try {
			sorgu=baglanti.prepareStatement(sql);
			sorgu.setString(1, txt_kulad.getText().trim());
			sorgu.setString(2, txt_sifre.getText().trim());
			
			ResultSet getirilen = sorgu.executeQuery();
			
			if(!getirilen.next()) {
				lbl_sonuc.setText("Hatalısın");
			}
			else {
				yetkisi =getirilen.getInt("Yetki");
				kullanıcı = getirilen.getString("Kullanıcı_AD");
				try {
					Stage stage1 = new Stage();
					AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("AnaForm.fxml"));
					Scene scene1 = new Scene(pane1);
					stage1.setScene(scene1);
					//stage1.getIcons().add(new Image("file:logo.ico"));
					//stage1.getIcons().add(new Image(getClass().getResourceAsStream("logo.ico")));
					stage1.show();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		} catch (SQLException e) {
			lbl_sonuc.setText(e.getMessage());
		}

    }

    @FXML
    void initialize() {
       

    }

}
