package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JPanel pnLabels, pnDatos;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel lbLibretaUniversitaria, lbApellido, lbNombre, lbEmail, lbRepositorio, lbIcono, lbGeneracionDeVentana;
	private JTextField tfLibretaUniversitaria, tfApellido, tfNombre, tfEmail, tfRepositorio;
	
	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentaci\u00f3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		Image icon = new ImageIcon("C:\\Users\\Abril\\Desktop\\ISI\\Tecnologia de la Programacion\\tdp-proyecto-1\\proyecto-1\\src\\images\\tdp.png").getImage();
		setIconImage(icon);
		init();
		
		armarPaneles();
		armarLabel();
		armarInput();
		this.cargarDatos();
		this.agregarIcono();
		this.datoDeGeneracion();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabInformation.setLayout(null);
		tabbedPane.addTab("Informaci\u00f3n del alumno", null, tabInformation, "Muestra la informaci\u00f3n declarada por el alumno");
		contentPane.add(tabbedPane, BorderLayout.WEST);
	}
	
	private void armarPaneles() {
		pnLabels = new JPanel();
		pnLabels.setBounds(0, 0, 92, 190);
		pnLabels.setLayout(null);
		tabInformation.add(pnLabels);
		
		pnDatos = new JPanel();
		pnDatos.setBounds( 100, 0, 400, 190);
		pnDatos.setLayout(null);
		tabInformation.add(pnDatos);
	}
	
	private void armarLabel() {
		lbLibretaUniversitaria = new JLabel("LU");
		lbLibretaUniversitaria.setBounds( 8, 10 , 180, 20);
		lbLibretaUniversitaria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lbApellido = new JLabel("Apellido");
		lbApellido.setBounds( 8, 40 ,180, 20);
		lbApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lbNombre = new JLabel("Nombre");
		lbNombre.setBounds( 8, 70 ,180, 20);
		lbNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lbEmail = new JLabel("E-mail");
		lbEmail.setBounds( 8, 100, 180, 20);
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lbRepositorio = new JLabel("GitHub URL");
		lbRepositorio.setBounds( 8, 130, 180, 20);
		lbRepositorio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		pnLabels.add(lbLibretaUniversitaria);
		pnLabels.add(lbApellido);
		pnLabels.add(lbNombre);
		pnLabels.add(lbEmail);
		pnLabels.add(lbRepositorio);
	}
	
	private void armarInput() {
		tfLibretaUniversitaria = new JTextField();
		tfLibretaUniversitaria.setBounds(0, 10, 318, 20);
		tfLibretaUniversitaria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfApellido = new JTextField();
		tfApellido.setBounds(0, 40, 318, 20);
		tfApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfNombre = new JTextField();
		tfNombre.setBounds(0, 70, 318, 20);
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfEmail = new JTextField();
		tfEmail.setBounds(0, 100, 318, 20);
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfRepositorio = new JTextField();
		tfRepositorio.setBounds(0, 130, 318, 20);
		tfRepositorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		pnDatos.add(tfLibretaUniversitaria);
		pnDatos.add(tfApellido);
		pnDatos.add(tfNombre);
		pnDatos.add(tfEmail);
		pnDatos.add(tfRepositorio);
	}
	
	private void cargarDatos() {
		tfLibretaUniversitaria.setText(studentData.getId()+"");
		tfApellido.setText(studentData.getLastName());
		tfNombre.setText(studentData.getFirstName());
		tfEmail.setText(studentData.getMail());
		tfRepositorio.setText(studentData.getGithubURL());
		this.bloquearTextFieldDeDatos();
	}

	private void bloquearTextFieldDeDatos() {
		tfLibretaUniversitaria.setEditable(false);
		tfApellido.setEditable(false);
		tfNombre.setEditable(false);
		tfEmail.setEditable(false);
		tfRepositorio.setEditable(false);
	}
	
	private void datoDeGeneracion() {
		LocalDateTime localTime = LocalDateTime.now();
		String texto = "Esta ventana fue generada el "+localTime.getDayOfMonth()+"/"+localTime.getMonthValue()+"/"+localTime.getYear()+" a las "+localTime.getHour()+":"+localTime.getMinute()+":"+localTime.getSecond();
		lbGeneracionDeVentana = new JLabel(texto);
		lbGeneracionDeVentana.setBounds(8, 270, 100, 20);
		lbGeneracionDeVentana.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().add(lbGeneracionDeVentana, BorderLayout.PAGE_END);
		
	}
	
	private void agregarIcono() {
		File directory = new File("C:\\Users\\Abril\\Desktop\\ISI\\Tecnologia de la Programacion\\tdp-proyecto-1\\proyecto-1\\Proyecto\\src\\images");
		
		try {
			BufferedImage bufferedImage = null;
			for(File file: directory.listFiles()) {
				bufferedImage = ImageIO.read(file);
			}
			ImageIcon imageIcon = new ImageIcon(bufferedImage.getScaledInstance(154, 154, Image.SCALE_DEFAULT));
			lbIcono = new JLabel();
			lbIcono.setIcon(imageIcon);
			contentPane.add(lbIcono, BorderLayout.EAST);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
