package controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import views.FrameLogin;
import views.FramePrincipal;

public class PrincipalController {
	
	private JFrame frame;
	
	public PrincipalController(JFrame frame) {
		this.frame = frame;
	}
	
	public WindowListener getWindowListener(){
		return new AddWindowListener();
	}
	
	public ActionListener getAcitonListener(String id){
		return new AddActionListner(id);
	}
	
	private void atualizarTela(JPanel panel, String titulo) {
		
		if(panel != null){
			FramePrincipal.setPanel(panel);	
		}
		frame.setTitle(titulo);
		frame.setMinimumSize(new Dimension(840, 510));
		frame.repaint();
	}
	
	private void abrir() {
		atualizarTela(null, "Abrir novo documento");
	}
	
	private void salvar() {
		atualizarTela(null, "Salvar documento");
	}
	
	private void imprimir(){
		atualizarTela(null, "Imprimir documento");
	}
	
	private void sobre(){

		atualizarTela(null, "Sobre o aplicativo");
	}
	
	private void sair() {
		
		int result = JOptionPane.showConfirmDialog(frame, "Você realmente deseja sair do aplicativo?", 
				"Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (result == JOptionPane.YES_OPTION){
			frame.dispose();
			new FrameLogin();
		} else {
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}
	
	private class AddWindowListener extends WindowAdapter{

		public void windowClosing(WindowEvent e){
			sair();
		}	
	}
	
	private class AddActionListner implements ActionListener{

		private String menu;
		
		public AddActionListner(String menu) {
			this.menu = menu;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(menu.equals(FramePrincipal.ABRIR)){
				
				abrir();
				
			} else if(menu.equals(FramePrincipal.SALVAR)){
				
				salvar();
				
			} else if(menu.equals(FramePrincipal.IMPRIMIR)){
				
				imprimir();
				
			} else if(menu.equals(FramePrincipal.SAIR)){

				sair();
				
			} else if(menu.equals(FramePrincipal.SOBRE)){
				
				sobre();
			}
		}
	}
	
//	private class LateralController extends MenuLateralController{
//
//		
//	}
}
