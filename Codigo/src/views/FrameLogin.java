package views;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controllers.LoginController;

public class FrameLogin {
	
	private JFrame frame;	//Objeto da classe JFrame para utilizar ele em outras classes
	private ImageIcon imgFundo; //Imagem de fundo
	private JLabel lbLogin, lbSenha, lbFundo, lbDesenvolvimento, lbSharkTech, lbSharkIcone; //Labels de login, senha, desenvolvimento e as imagens de fundo
	private JTextField tfLogin; //Campo de texto de login
	private JPasswordField tfSenha; //Campo de senha
	private JButton btLogin; //Botão para efetuar o login
	
	public FrameLogin(){ //Construtor da classe
		
		inicializaFrame(); //Chamada do método para instanciar o frame
		inicializaComponentes(); //Chamada do método para instanciar os componentes do frame
	}
			
	private void inicializaFrame(){ //Método para criar o frame
		try { //Exceção para utilizar ou não o tema Ninbus do java  
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		frame = new JFrame();
		frame.setTitle("Café Novo Horizonte"); //Título do frame
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FramePrincipal.URL_IMAGENS + "/CafeIcone.png")); //Icone do frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Operação ao fechar o frame
		frame.setResizable(false); //Não deixa modificar o tamanho da tela
		frame.setLayout(null); //Seta o layout como null
		frame.setSize(628,419); //Tamanho do frame
		frame.setLocationRelativeTo(null); //Posição da tela onde o frame vai aparecer, quando o valor é nulo, aparece no meio da tela
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {  //Verifica se o usuário deseja mesmo sair do sistema
			public void windowClosing(WindowEvent e){
				int i = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?");
				if (i == JOptionPane.YES_NO_OPTION){
					System.exit(0);
				} else{
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
				}
			}
		});
	}
	
	private void inicializaComponentes(){
		//Método para instanciar os objetos do frame
		lbLogin = new JLabel("Login");
		frame.add(lbLogin); 
		lbLogin.setBounds(299, 140, 50, 20);

		lbSenha = new JLabel("Senha");
		frame.add(lbSenha);
		lbSenha.setBounds(296, 200, 50, 20);

		tfLogin = new JTextField("Admin");
		frame.add(tfLogin);
		tfLogin.setBounds(215, 160, 200, 25);

		tfSenha = new JPasswordField("12345");
		frame.add(tfSenha);
		tfSenha.setBounds(215, 220, 200, 25);

		btLogin = new JButton(new ImageIcon("Imagens/LoginButtonIcone.png"));
		frame.add(btLogin);
		btLogin.setContentAreaFilled(false);
		btLogin.setBounds(264, 260, 100, 30);
		
		
		lbDesenvolvimento = new JLabel("Desenvolvido pela:");
		frame.add(lbDesenvolvimento);
		lbDesenvolvimento.setBounds(263, 310, 130, 20);
		
		lbSharkTech = new JLabel("Shark Tech®");
		frame.add(lbSharkTech);
		lbSharkTech.setBounds(280, 345, 140, 20);
		lbSharkTech.setFont(new Font("Arial", Font.BOLD, 20));
		
		lbSharkIcone = new JLabel(new ImageIcon("Imagens/Shark.png"));
		frame.add(lbSharkIcone);
		lbSharkIcone.setBounds(220, 325, 64, 64);
		
		imgFundo = new ImageIcon("Imagens/CafeFundoLogin.png");
		lbFundo = new JLabel(imgFundo);
		frame.add(lbFundo);
		lbFundo.setBounds(0, 0, 626, 417);
		
		btLogin.addActionListener(new LoginController(frame, tfLogin, tfSenha));
	}
	
	public static void main(String[] args) {
		new FrameLogin();
	}	
}