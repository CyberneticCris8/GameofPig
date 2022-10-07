package application;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController implements Initializable {
	
	
	@FXML
	private TextField playerScoreUI, computerScoreUI;
	@FXML
	private Button rollBTN, holdBTN, playBTN;
	@FXML
	private Label rollLabel;
	@FXML
	private TableView<Report> table;
	private int player = 0, computer = 0;
	private Random random;

	private final int SCORE_LIMIT = 100;

	
	@Override
	public void initialize(URL url, ResourceBundle resource) {

		random = new Random();

		TableColumn<Report, String> nameCol = new TableColumn<Report, String>("Name");
		TableColumn<Report, String> dateCol = new TableColumn<Report, String>("Date");
		TableColumn<Report, String> winCol = new TableColumn<Report, String>("Result");
		TableColumn<Report, Integer> scoreCol = new TableColumn<Report, Integer>("Score");

		nameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.25));
		dateCol.prefWidthProperty().bind(table.widthProperty().multiply(0.25));
		winCol.prefWidthProperty().bind(table.widthProperty().multiply(0.25));
		scoreCol.prefWidthProperty().bind(table.widthProperty().multiply(0.25));

		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		dateCol.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
		winCol.setCellValueFactory(new PropertyValueFactory<>("win"));
		scoreCol.setCellValueFactory(new PropertyValueFactory<>("scores"));

		table.getColumns().add(nameCol);
		table.getColumns().add(dateCol);
		table.getColumns().add(scoreCol);
		table.getColumns().add(winCol);

	}
	
	@FXML
	public void roll() {
		
		int value = random.nextInt(6) + 1;
		rollLabel.setText("Value: " + value);
		if (value == 1) {
			player = 0;
		} else {
			player += value;
		}
		if (value == 1) {
			hold();
		}

	}

	@FXML
	public void hold() {
		playerScoreUI.setText(String.valueOf(player));
		if (!checkWin()) {
			boolean stop = false;
			do {
				int value = random.nextInt(6) + 1;
				if (value == 1) {
					computer = 0;
					break;
				} else {
					computer += value;
				}
				stop = random.nextBoolean();
			} while (!stop);
			computerScoreUI.setText(String.valueOf(computer));
			checkWin();
		}
	}

	@FXML
	public void playAgain() {

		rollBTN.setDisable(false);
		holdBTN.setDisable(false);
		playBTN.setDisable(true);
		playerScoreUI.setText("0");
		computerScoreUI.setText("0");
		player = 0;
		computer = 0;

	}

	private boolean checkWin() {

		if (player >= SCORE_LIMIT || computer >= SCORE_LIMIT) {
			// someone won..
			table.getItems().add(new Report("Player", player, player >= SCORE_LIMIT));
			table.getItems().add(new Report("Computer", computer, computer >= SCORE_LIMIT));
			rollBTN.setDisable(true);
			holdBTN.setDisable(true);
			playBTN.setDisable(false);
			return true;
		}
		return false;

	}

}

