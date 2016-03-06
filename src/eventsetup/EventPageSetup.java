package eventsetup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class EventPageSetup extends JFrame {

	private JPanel contentPane;
	private JPanel teamSetup;
	private JTextField FestName;
	private static String festName;
	private JTextField TBR;
	private static String tbr;
	private JTextField LaneInput;
	private static String lanes;
	private JTextField BreakTime;
	private JTextField AddCat;
	private JTextField BreakEndTime;
	private JTextField teamName;
	private JTextField BreakList;
	private ArrayList<String> breakList = new ArrayList<String>();
	private ArrayList<String> Category = new ArrayList<String>();
	private String tempCat;
	private String tempBreak;
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EventPageSetup frame = new EventPageSetup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EventPageSetup() {
		setTitle("Setup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		teamSetup = new JPanel();
		teamSetup.setVisible(false);
		teamSetup.setLayout(null);
		teamSetup.setBorder(new EmptyBorder(5, 5, 5, 5));
		teamSetup.setBackground(Color.LIGHT_GRAY);
		teamSetup.setBounds(0, 328, 540, 38);
		contentPane.add(teamSetup);
		
		JLabel label = new JLabel("Team Setup");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label.setBounds(211, 17, 121, 25);
		teamSetup.add(label);
		
		JLabel label_1 = new JLabel("Team Name");
		label_1.setBounds(6, 57, 74, 16);
		teamSetup.add(label_1);
		
		teamName = new JTextField();
		teamName.setColumns(10);
		teamName.setBounds(6, 73, 228, 26);
		teamSetup.add(teamName);
		
		JLabel label_2 = new JLabel("Category");
		label_2.setBounds(271, 57, 61, 16);
		teamSetup.add(label_2);
		
		JComboBox CatBox = new JComboBox();
		CatBox.setBounds(263, 74, 121, 27);
		teamSetup.add(CatBox);
		
		JButton addTeamCat = new JButton("+");
		addTeamCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{addTeam(teamName.getText(), CatBox.getSelectedItem());}catch (Exception e1) {
					e1.printStackTrace();}}
		});
		addTeamCat.setBounds(381, 73, 49, 29);
		teamSetup.add(addTeamCat);
		
		JFormattedTextField teamList = new JFormattedTextField();
		teamList.setBounds(6, 100, 528, 162);
		teamSetup.add(teamList);
		
		JButton teamDelete = new JButton("Delete");
		teamDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{deleteTeam(teamList.getSelectedText());}catch (Exception e2) {
					e2.printStackTrace();
			}}
		});
		teamDelete.setBounds(202, 260, 84, 29);
		teamSetup.add(teamDelete);
		
		JButton undoTeamDelete = new JButton("Undo");
		undoTeamDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{teamUndoDelete();}catch (Exception e3) {
					e3.printStackTrace();}
			}
		});
		undoTeamDelete.setBounds(287, 260, 74, 29);
		teamSetup.add(undoTeamDelete);
		
		JButton previous = new JButton("Previous");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevPage();
			}
		});
		previous.setBounds(6, 331, 117, 29);
		teamSetup.add(previous);
		
		JButton finish = new JButton("Finish");
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});
		finish.setBounds(417, 331, 117, 29);
		teamSetup.add(finish);
		
		JLabel lblEventSetup = new JLabel("Event Setup");
		lblEventSetup.setBounds(214, 6, 111, 25);
		lblEventSetup.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblEventSetup);
		
		JLabel lblFestivalName = new JLabel("Festival Name");
		lblFestivalName.setBounds(6, 41, 94, 16);
		contentPane.add(lblFestivalName);
		
		FestName = new JTextField();
		FestName.setBounds(99, 36, 130, 26);
		contentPane.add(FestName);
		FestName.setColumns(10);
		
		JLabel lblTimeBetweenRaces = new JLabel("Time Between Races");
		lblTimeBetweenRaces.setBounds(6, 83, 130, 16);
		contentPane.add(lblTimeBetweenRaces);
		
		TBR = new JTextField();
		TBR.setColumns(10);
		TBR.setBounds(136, 78, 51, 26);
		contentPane.add(TBR);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(193, 83, 51, 16);
		contentPane.add(lblMinutes);
		
		JLabel lblMaxNumberOf = new JLabel("Max Number of Lanes");
		lblMaxNumberOf.setBounds(6, 116, 142, 16);
		contentPane.add(lblMaxNumberOf);
		
		LaneInput = new JTextField();
		LaneInput.setColumns(10);
		LaneInput.setBounds(146, 111, 44, 26);
		contentPane.add(LaneInput);
		
		JLabel lblBreakTimes = new JLabel("Break Times");
		lblBreakTimes.setBounds(282, 48, 76, 16);
		contentPane.add(lblBreakTimes);
		
		BreakTime = new JTextField();
		BreakTime.setColumns(5);
		BreakTime.setBounds(359, 45, 51, 26);
		contentPane.add(BreakTime);
		
		JButton AddBreak = new JButton("+");
		AddBreak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToBreak(BreakTime.getText(), BreakEndTime.getText());
			}
		});
		AddBreak.setBounds(453, 45, 51, 29);
		contentPane.add(AddBreak);
		
		JTextField BreakList = new JTextField();
		BreakList.setBounds(282, 83, 214, 63);
		contentPane.add(BreakList);
		
		JButton DeleteBreak = new JButton("Delete");
		DeleteBreak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBreak(BreakList.getSelectedText().toString());
				}
		});
		DeleteBreak.setBounds(363, 152, 69, 29);
		contentPane.add(DeleteBreak);
		
		JButton UndoDelBreak = new JButton("Undo");
		UndoDelBreak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{deleteBreakUndo();}catch (Exception e6) {
					e6.printStackTrace();}
			}
		});
		UndoDelBreak.setBounds(427, 152, 69, 29);
		contentPane.add(UndoDelBreak);
		
		JLabel lblCategories = new JLabel("Categories");
		lblCategories.setBounds(6, 186, 76, 16);
		contentPane.add(lblCategories);
		
		AddCat = new JTextField();
		AddCat.setColumns(10);
		AddCat.setBounds(88, 181, 84, 26);
		contentPane.add(AddCat);
		
		JButton AddCatButton = new JButton("+");
		AddCatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCat(AddCat.getText());
			}
		});
		AddCatButton.setBounds(169, 181, 51, 29);
		contentPane.add(AddCatButton);
		
		JList CatList = new JList();
		CatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CatList.setBounds(6, 228, 214, 63);
		contentPane.add(CatList);
		
		JButton DelCat = new JButton("Delete");
		DelCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCat(CatList.getSelectedValue().toString());
				}
		});
		DelCat.setBounds(87, 297, 69, 29);
		contentPane.add(DelCat);
		
		JButton UndoDelCat = new JButton("Undo");
		UndoDelCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCatUndo();
				}
		});
		UndoDelCat.setBounds(151, 297, 69, 29);
		contentPane.add(UndoDelCat);
		
		JLabel lblUnused = new JLabel("Unused");
		lblUnused.setBounds(6, 210, 61, 16);
		contentPane.add(lblUnused);
		
		JList CatList2 = new JList();
		CatList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CatList2.setBounds(282, 228, 214, 63);
		contentPane.add(CatList2);
		
		JLabel lblUsed = new JLabel("Used");
		lblUsed.setBounds(282, 210, 61, 16);
		contentPane.add(lblUsed);
		
		JButton UseCat = new JButton(">");
		UseCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveCatUse(CatList.getSelectedValue().toString());
				}
		});
		UseCat.setBounds(226, 228, 44, 29);
		contentPane.add(UseCat);
		
		JButton UnuseCat = new JButton("<");
		UnuseCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveCatBack(CatList2.getSelectedValue().toString());
				}
		});
		UnuseCat.setBounds(226, 262, 44, 29);
		contentPane.add(UnuseCat);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextPage();
			}
		});
		btnNext.setBounds(417, 331, 117, 29);
		contentPane.add(btnNext);
		
		BreakEndTime = new JTextField();
		BreakEndTime.setBounds(407, 45, 51, 26);
		contentPane.add(BreakEndTime);
		BreakEndTime.setColumns(5);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(363, 29, 34, 16);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(407, 29, 34, 16);
		contentPane.add(lblEnd);
	}
	
	//breaks for event setup
	public void addToBreak(String start, String end){
		breakList.add(start + " " + end + "\n");
		BreakList.setText(breakList.toString());
	}
	public void deleteBreak(String selected){
		tempBreak = selected;
		breakList.remove(selected);
		BreakList.remove(BreakList.getSelectedText().indexOf(selected));
	}
	public void deleteBreakUndo(){
		breakList.add(tempBreak);
	}
	
	//actions for categories during event setup
	public void addCat(String cat){
		Category.add(cat);
	}
	public void deleteCat(String deadCat){
		tempCat = Category.get(Category.indexOf(deadCat));
		Category.remove(deadCat);
	}
	public void deleteCatUndo(){
		Category.add(tempCat);
	}
	public void moveCatUse(String useCat){
		
	}
	public void moveCatBack(String noUseCat){
		
	}
	
	//page buttons
	public void nextPage(){
		festName = FestName.getText();
		tbr = TBR.getText();
		lanes = LaneInput.getText();
		teamSetup.setVisible(true);
	}
	public void prevPage(){
		teamSetup.setVisible(false);
	}
	public void finish(){
		teamSetup.setVisible(false);
		contentPane.setVisible(false);
	}
	
	//actions dealing w/ teams
	public void addTeam(String name, Object Cat){
		
	}
	public void deleteTeam(String noTeam){
		
	}
	public void teamUndoDelete(){
		
	}
	
	

}






