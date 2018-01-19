
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Library extends Application
{
	int i = 0;

	public static void main(String[] s) throws Exception
	{
		Application.launch(s);
	}
	
	@Override
	public void start(Stage prim) throws Exception
	{
		BorderPane pane = new BorderPane();
		Image image = new Image("file:vr2.png", 300, 150, true, true);
		ImageView x = new ImageView(image);

		Label l1 = new Label("Movie info :");
		pane.setPadding(new Insets(10));
		pane.setAlignment(x, Pos.CENTER);
		pane.setTop(x);
		pane.setAlignment(l1, Pos.CENTER);
		Button next = new Button("next");
		next.setPrefSize(60, 20);
		Button previous = new Button("previous");
		previous.setDisable(true);
		next.setDisable(true);
		pane.setRight(next);
		pane.setLeft(previous);
		pane.setAlignment(next, Pos.CENTER);
		pane.setAlignment(previous, Pos.CENTER);
		TextField tx1 = new TextField("fd");
		TextField tx2 = new TextField();
		TextField tx3 = new TextField();
		HBox hb1 = new HBox(20);
		Button sort = new Button("Sort");
		RadioButton r1 = new RadioButton("Sort by time");
		RadioButton r2 = new RadioButton("Sort by type");
		r1.setDisable(true);
		r2.setDisable(true);
		ToggleGroup group = new ToggleGroup();
		r1.setToggleGroup(group);
		r2.setToggleGroup(group);
		sort.setDisable(true);
		hb1.getChildren().addAll(r1, r2, sort);
		VBox vb1 = new VBox(10);
		vb1.setAlignment(Pos.CENTER);
		hb1.setAlignment(Pos.CENTER);
		Button load = new Button("load");
		load.setPrefSize(60, 40);
		vb1.setPadding(new Insets(30, 0, 0, 0));
		vb1.getChildren().addAll(load, hb1);
		pane.setBottom(vb1);
		GridPane gpane = new GridPane();
		Label l2 = new Label("Title: ");
		Label l3 = new Label("Type: ");
		Label l4 = new Label("Running time:     ");
		Label l5 = new Label("Details: ");
		TextField tx4 = new TextField();
		TextField tx5 = new TextField();
		TextField tx6 = new TextField();
		TextField tx7 = new TextField();
		TextField tx8 = new TextField();
		tx4.setEditable(false);
		tx5.setEditable(false);
		tx6.setEditable(false);
		tx7.setEditable(false);
		tx8.setEditable(false);
		tx7.setPrefColumnCount(27);
		gpane.addColumn(0, l2, l3, l4, l5);
		gpane.addColumn(1, tx4, tx5, tx6, tx7, tx8);
		pane.setCenter(gpane);
		gpane.setPadding(new Insets(30, 30, 0, 30));

		ArrayList<Movie> movies = new ArrayList<>();

		load.setOnAction(e ->
		{

			File input = new File("movies.txt");
			Scanner in = null;

			try
			{
				in = new Scanner(input);
			}
			catch (FileNotFoundException e1)
			{
				System.out.println("--> ERROR: File not found!");
				System.exit(1);
			}

			in.nextLine(); // To ignore the first line

			while(in.hasNext())
			{
				String str = in.nextLine().trim();
				switch (getType(str))
				{
				case "Action":
					movies.add(new Action(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
							getCountry(str), getLanguage(str)));
					break;
				case "Comedy":
					movies.add(new Comedy(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
							getCountry(str), getLanguage(str)));
					break;
				case "Mystery":
					movies.add(new Mystery(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
							getCountry(str), getLanguage(str)));
					break;
				case "Rescue":
					movies.add(new Rescue(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
							getCountry(str), getLanguage(str)));
					break;
				case "Romance":
					movies.add(new Romance(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
							getCountry(str), getLanguage(str)));
					break;
				case "Romantic Comedy":
					movies.add(new RomanticComedy(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
							getCountry(str), getLanguage(str)));
					break;
				case "Hollywood Blockbuster":
					movies.add(new HollywoodBlockbuster(getType(str), getTitle(str), getStarring(str),
							getRunningTime(str), getCountry(str), getLanguage(str)));
					break;
				}
			}

			in.close();
			tx4.setText(movies.get(0).getTitle());
			tx5.setText(movies.get(0).getType());
			tx6.setText(movies.get(0).getRunningTime() + "");
			tx7.setText("Starring: " + Arrays.toString(movies.get(0).getStarring()));
			tx8.setText("Country: " + movies.get(0).getCountry() + ", Language: " + movies.get(0).getLanguage());
			if(movies.size() > 1)
				next.setDisable(false);
			r1.setDisable(false);
			r2.setDisable(false);
			load.setDisable(true);
		});


		next.setOnAction(e ->
		{
			previous.setDisable(false);

			if(i + 2 == movies.size())
				next.setDisable(true);

			if(i < movies.size() - 1)
				i++;

			tx4.setText(movies.get(i).getTitle());
			tx5.setText(movies.get(i).getType());
			tx6.setText(movies.get(i).getRunningTime() + "");
			tx7.setText("Starring: " + Arrays.toString(movies.get(i).getStarring()));
			tx8.setText("Country: " + movies.get(i).getCountry() + ", Language: " + movies.get(i).getLanguage());
		});

		previous.setOnAction(e ->
		{
			next.setDisable(false);

			if(i == 1)
				previous.setDisable(true);
			
			if(i > 0)
				i--;

			tx4.setText(movies.get(i).getTitle());
			tx5.setText(movies.get(i).getType());
			tx6.setText(movies.get(i).getRunningTime() + "");
			tx7.setText("Starring: " + Arrays.toString(movies.get(i).getStarring()));
			tx8.setText("Country: " + movies.get(i).getCountry() + ", Language: " + movies.get(i).getLanguage());
		});

		r1.setOnAction(e -> sort.setDisable(false));
		r2.setOnAction(e -> sort.setDisable(false));
		
		sort.setOnAction(e ->
		{
			PrintWriter outFile = null;
			if(group.getSelectedToggle() == r1)
			{
				ArrayList<Movie> temp = new ArrayList<>(movies);
				bubbleSort(temp);
				
				try
				{
					outFile = new PrintWriter("sorted_list.txt");
				}
				catch (FileNotFoundException e1)
				{
					System.out.println("--> ERROR: File not found!");
					System.exit(1);
				}
				outFile.println("Type: Title, [Starring], Running time, Country, Language.");
				for (int j = 0; j < temp.size(); j++)
				{
					Movie movie = temp.get(j);
					outFile.println(movie.getType() + ": " + movie.getTitle() + ','
							+ Arrays.toString(movie.getStarring()) + ", " + movie.getRunningTime() + ", "
							+ movie.getCountry() + ", " + movie.getLanguage() + ".");
				}
				outFile.close();
			}
			else if(group.getSelectedToggle() == r2)
			{
				ArrayList<Movie> temp = new ArrayList<>(movies);
				Collections.sort(temp);

				try
				{
					outFile = new PrintWriter("sorted_list.txt");
				}
				catch (FileNotFoundException e1)
				{
					System.out.println("--> ERROR: File not found!");
					System.exit(1);
				}

				outFile.println("Type: Title, [Starring], Running time, Country, Language.");

				for (int j = 0; j < temp.size(); j++)
				{
					Movie movie = temp.get(j);
					outFile.println(movie.getType() + ": " + movie.getTitle() + ','
							+ Arrays.toString(movie.getStarring()) + ", " + movie.getRunningTime() + ", "
							+ movie.getCountry() + ", " + movie.getLanguage() + ".");
				}
				outFile.close();
			}
		});

		prim.setScene(new Scene(pane, 600, 450));
		prim.setTitle("Cinema System");
		prim.getIcons().add(new Image("file:icon.png"));
		prim.setResizable(false);
		prim.show();
	}


	public static String getType(String l)
	{
		return l.split(":")[0].trim();
	}

	public static String getTitle(String l)
	{
		return l.split("[:,]")[1].trim();
	}

	public static String[] getStarring(String l)
	{
		return l.substring(l.indexOf('[') + 1, l.indexOf(']')).trim().split(",");
	}

	public static int getRunningTime(String l)
	{
		return Integer.parseInt(l.substring(l.indexOf(']') + 2).trim().split(",")[0]);
	}

	public static String getCountry(String l)
	{
		return l.substring(l.indexOf(']') + 2).trim().split(",")[1].trim();
	}

	public static String getLanguage(String l)
	{
		return l.substring(l.indexOf(']') + 2).trim().split("[,.]")[2].trim();
	}

	public static void bubbleSort(ArrayList<Movie> movies)
	{
		Movie temp = null;
		for (int x = 0; x < movies.size() - 1; x++)
			for (int y = x + 1; y < movies.size(); y++)
				if(movies.get(x).getRunningTime() > movies.get(y).getRunningTime())
				{
					temp = movies.get(x);
					movies.set(x, movies.get(y));
					movies.set(y, temp);
				}
	}

}