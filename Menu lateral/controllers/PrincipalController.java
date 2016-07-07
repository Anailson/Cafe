package controllers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import views.FrameCadastroCliente;
import views.FrameCadastroProduto;
import views.FrameHome;
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
	
	public MouseListener getMouseListener(String id){
		return new AddMouseListener(id);
	}
	
	@SuppressWarnings("rawtypes")
	private Component getComponent(JFrame frame, Class cls){
		
		Component components[] = frame.getContentPane().getComponents();
		
		for(int i = 0; i < components.length; i++){
			if (components[i].getClass().equals(cls)){
				return components[i];
			}
		}
		return null;
	}
	
	private void atualizarTela(String titulo){
		frame.setTitle(titulo);
	}
	
	private void atualizarTela(String titulo, JPanel panel){

		atualizarTela(titulo);
		
		JScrollPane scrPane = (JScrollPane) getComponent(frame, JScrollPane.class);
		scrPane.setViewportView(panel);
		frame.setMinimumSize(new Dimension(840, 510));
		frame.repaint();
	}
	
	private void salvar(String titulo) {
		atualizarTela(titulo);
	}
	
	private void abrir(String titulo) {
		atualizarTela(titulo);
	}
	
	private void home(String titulo){
		JPanel panel = new FrameHome(Color.WHITE).getPanel();
		atualizarTela(titulo, panel);
	}
	
	private void cliente(String titulo){
		JPanel panel = new FrameCadastroCliente(Color.WHITE).getPanel();
		atualizarTela(titulo, panel);
	}
	
	private void fornecedor(String titulo){
		atualizarTela(titulo);
	}
	
	private void transportadora(String titulo){
		atualizarTela(titulo);
	}
	
	private void produto(String titulo){

		JPanel panel = new FrameCadastroProduto().getPanel();
		atualizarTela(titulo, panel);
	}
	
	private void cadastrar(String titulo) {
		atualizarTela(titulo);
	}

	private void listar(String titulo) {
		atualizarTela(titulo);
	}

	private void relatorios(String titulo) {
		atualizarTela(titulo);
	}

	private void estoque(String titulo) {
		atualizarTela(titulo);
	}
	
	private void vendas(String titulo) {
		atualizarTela(titulo);
	}
	
	private void sair() {
		
		JPanel panel = new FrameHome(Color.CYAN).getPanel();
		atualizarTela("Café Novo Horizonte", panel);
		
		int result = JOptionPane.showConfirmDialog(frame, "Você realmente deseja sair do aplicativo?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (result == JOptionPane.YES_OPTION){
			System.exit(0);
		} else {
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		}
	}
	
	public class AddWindowListener extends WindowAdapter{

		public void windowClosing(WindowEvent e){
			sair();
		}
	}
	
	public class AddActionListner implements ActionListener{

		private String id;
		
		public AddActionListner(String id) {
			this.id = id;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			if (id.equals(FramePrincipal.ABRIR)){
				
				abrir("Abrir novo documento");
				
			} else if (id.equals(FramePrincipal.SALVAR)){
				
				salvar("Salvando documento");
				
			} else if (id.equals(FramePrincipal.CLIENTE)){
				
				cliente("Cadastrar cliente");
				
			} else if (id.equals(FramePrincipal.FORNECEDOR)){
				
				fornecedor("Cadastrar fornecedor");
				
			} else if (id.equals(FramePrincipal.TRANSPORTADORA)){
				
				transportadora("Cadastrar transportadora");
				
			} else if (id.equals(FramePrincipal.PRODUTO)){
				
				produto("Cadastrar produto");
				
			} else if (id.equals(FramePrincipal.SALVAR)){
				
				salvar("Salvando documento");
				
			} else if (event.getActionCommand().equals(FramePrincipal.SAIR)){

				sair();
			}
		}
	}

	public class AddMouseListener implements MouseListener{

		private String id;
		
		public AddMouseListener(String id) {
			this.id = id;
		}
				
		@Override
		public void mouseClicked(MouseEvent event) { }

		@Override
		public void mouseEntered(MouseEvent event) { }

		@Override
		public void mouseExited(MouseEvent event) { }

		@Override
		public void mousePressed(MouseEvent event) { }

		@Override
		public void mouseReleased(MouseEvent event) {

			
			if (FramePrincipal.HOME.equals(id)){
				
				home("Café Novo Horizonte");
				
			} else if (FramePrincipal.CADASTRAR.equals(id)){
				
				cadastrar("[mouseReleased] " + id);

			} else if (id.equals(FramePrincipal.LISTAR)){
				
				listar("[mouseReleased] " + id);

			} else if (id.equals(FramePrincipal.RELATORIOS)){

				relatorios("[mouseReleased] " + id);
				
			}  else if (id.equals(FramePrincipal.ESTOQUE)){

				estoque("[mouseReleased] " + id);
				
			}  else if (id.equals(FramePrincipal.VENDAS)){

				vendas("[mouseReleased] " + id);
				
			}  else if (id.equals(FramePrincipal.SAIR)){

				sair();
			} 
		}
	}
}
