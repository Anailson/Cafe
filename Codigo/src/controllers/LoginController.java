package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import models.LoginModel;
import views.FramePrincipal;

public class LoginController implements ActionListener{
	
	private JFrame frame;
	private LoginModel model;
	private JTextField tfLogin; 
	private JPasswordField tfSenha;


	public LoginController(JFrame frame, JTextField tfLogin, JPasswordField tfSenha) {

		this.frame = frame;
		this.tfLogin = tfLogin;
		this.tfSenha = tfSenha;
		this.model = new LoginModel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String login = tfLogin.getText();
		String senha = new String(tfSenha.getPassword()); 
		frame.dispose();
		new FramePrincipal("Café Novo Horizonte").setVisible(true);
//		
//		if (login.equalsIgnoreCase("") || senha.equalsIgnoreCase("")){
//			
//			JOptionPane.showMessageDialog(null, "Informe os dois campos para concluir a autenticação!!!");
//			return;
//			
//		} else {
//
//			int resultado = model.buscarUsuario(login, senha);
//			
//			if (resultado == LoginModel.LOGIN_SUCESSO){
//				
//				frame.dispose();
//				new FramePrincipal("Café Novo Horizonte").setVisible(true);
//				
//			} else {
//				JOptionPane.showMessageDialog(null, "Erro na autenticação!!!");
//				return;
//			}
//		}
	}
}

