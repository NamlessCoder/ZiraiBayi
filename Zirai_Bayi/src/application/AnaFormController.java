package application;

import java.io.IOException;
import java.net.URL;
import java.rmi.server.LoaderHandler;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AnaFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_sagalt;

    @FXML
    private AnchorPane anchor_sagust;

    @FXML
    private AnchorPane anchor_sol;

    @FXML
    private Button btn_ara;

    @FXML
    private Button btn_calisan;

    @FXML
    private Button btn_exit;

    @FXML
    private Button btn_geçmis;

    @FXML
    private Button btn_gubre;

    @FXML
    private Button btn_hormon;

    @FXML
    private Button btn_ilaç;

    @FXML
    private Button btn_stok;
    
    @FXML
    private TextField txt_ara;

    
    @FXML
    void btn_ara_Click(ActionEvent event) {
    	 try {
     		
     		FXMLLoader loader = new FXMLLoader(getClass().getResource("TabloUrun.fxml"));
 			AnchorPane panel1=(AnchorPane)loader.load();
 			
 			urunlerController nesne = loader.getController();
 			nesne.SqlDoldur( "select * from urunler where Urun_ad like '%"+txt_ara.getText()+"%'");
 			nesne.Anchordoldur(1);
 			
 			anchor_sagalt.getChildren().setAll(panel1);
 		   } catch (IOException e) {
 			   e.printStackTrace();
 		   }

    }

    @FXML
    void btn_calisan_Click(ActionEvent event) {
    	try {
			AnchorPane panel1=(AnchorPane)FXMLLoader.load(getClass().getResource("TabloGiris.fxml"));
			anchor_sagalt.getChildren().setAll(panel1);
		} catch (IOException e) {
			e.printStackTrace();
		}
   

    }

    @FXML
    void btn_exit_click(ActionEvent event) {
    	Runtime.getRuntime().exit(0);

    }

    @FXML
    void btn_geçmis_Click(ActionEvent event) {
         try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Geçmis.fxml"));
			AnchorPane panel1=(AnchorPane)loader.load();
			
			TabloGeçmisController nesne = loader.getController();
			nesne.SqlDoldur( "select * from gecmis");

			anchor_sagalt.getChildren().setAll(panel1);
		   } catch (IOException e) {
			   e.printStackTrace();
		   }

    }

    @FXML
    void btn_gubre_Click(ActionEvent event) {
         try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("TabloUrun.fxml"));
			AnchorPane panel1=(AnchorPane)loader.load();
			
			urunlerController nesne = loader.getController();
			nesne.SqlDoldur( "select * from urunler where Urun_Tur='"+"g"+"'");
			nesne.Anchordoldur(1);

			anchor_sagalt.getChildren().setAll(panel1);
		   } catch (IOException e) {
			   e.printStackTrace();
		   }
    }

    @FXML
    void btn_hormon_Click(ActionEvent event) {
    	try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("TabloUrun.fxml"));
			AnchorPane panel1=(AnchorPane)loader.load();
			
			urunlerController nesne = loader.getController();
			nesne.SqlDoldur( "select * from urunler where Urun_Tur='"+"h"+"'");
			nesne.Anchordoldur(1);

			anchor_sagalt.getChildren().setAll(panel1);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void btn_ilaç_Click(ActionEvent event) {
         try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("TabloUrun.fxml"));
			AnchorPane panel1=(AnchorPane)loader.load();
			
			urunlerController nesne = loader.getController();
			nesne.SqlDoldur( "select * from urunler where Urun_Tur='"+"i"+"'");
			nesne.Anchordoldur(1);

			anchor_sagalt.getChildren().setAll(panel1);
		   } catch (IOException e) {
			   e.printStackTrace();
		   }

    }

    @FXML
    void btn_stok_Click(ActionEvent event) {
    	  try {
      		
      		FXMLLoader loader = new FXMLLoader(getClass().getResource("TabloUrun.fxml"));
  			AnchorPane panel1=(AnchorPane)loader.load();
  			
  			urunlerController nesne = loader.getController();
  			nesne.SqlDoldur( "select * from urunler");
  			nesne.Anchordoldur(2);

  			anchor_sagalt.getChildren().setAll(panel1);
  		   } catch (IOException e) {
  			   e.printStackTrace();
  		   }

    }

   

    @FXML
    void initialize() {
        
    }

}
