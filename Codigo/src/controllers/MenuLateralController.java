package controllers;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entidades.MenuLateral;
import interfaces.MenuLateralListener;
import views.FrameEstoque;
import views.FrameHome;
import views.FrameLogin;
import views.FramePrincipal;

public class MenuLateralController implements MenuLateralListener {

	private final String HOME = "Café Novo Horizonte";
	private final String ESTOQUE = "Verificar estoque";
	
	private JFrame frame;
	
	public MenuLateralController(JFrame frame) {

		this.frame = frame;
	}
	
	private void atualizarTela(JPanel panel, String titulo) {
		
		if(panel != null){
			FramePrincipal.setPanel(panel);	
		}
		frame.setTitle(titulo);
		frame.setMinimumSize(new Dimension(840, 510));
		frame.repaint();
	}
	
	private void home(String titulo){
		atualizarTela(new FrameHome(), titulo);
	}

	private void estoque(String titulo) {
		atualizarTela(new FrameEstoque(titulo), titulo);
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
	
	
	@Override
	public void menuSelecionado(MenuLateral menuLateral) {
		
		String nome = menuLateral.getNome();
		
		if(nome.equals(FramePrincipal.HOME)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/home_item.png");
			
		} else if(nome.equals(FramePrincipal.CADASTRAR)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/cadastrar_item.png");
			
		} else if(nome.equals(FramePrincipal.LISTAR)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/listar_item.png");
			
		} else if(nome.equals(FramePrincipal.RELATORIOS)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/relatorios_item.png");
			
		} else if(nome.equals(FramePrincipal.ESTOQUE)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/estoque_item.png");
			
		} else if(nome.equals(FramePrincipal.VENDAS)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/vendas_item.png");
			
		} else if(nome.equals(FramePrincipal.SAIR)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/sair_item.png");			
		}
	}

	@Override
	public void menuDescelecionado(MenuLateral menuLateral) {
		
		String nome = menuLateral.getNome();
		
		if(nome.equals(FramePrincipal.HOME)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/home.png");
			
		} else if(nome.equals(FramePrincipal.CADASTRAR)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/cadastrar.png");
			
		} else if(nome.equals(FramePrincipal.LISTAR)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/listar.png");
			
		} else if(nome.equals(FramePrincipal.RELATORIOS)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/relatorios.png");
			
		} else if(nome.equals(FramePrincipal.ESTOQUE)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/estoque.png");
			
		} else if(nome.equals(FramePrincipal.VENDAS)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/vendas.png");
			
		} else if(nome.equals(FramePrincipal.SAIR)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/sair.png");			
		}
	}

	@Override
	public void menuPressionado(MenuLateral menuLateral) {
		
		String nome = menuLateral.getNome();
		
		if(nome.equals(FramePrincipal.HOME)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/home_press.png");
			home(HOME);
			
		} else if(nome.equals(FramePrincipal.ESTOQUE)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/estoque_press.png");
			estoque(ESTOQUE);
			
		} else if(nome.equals(FramePrincipal.SAIR)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/sair_press.png");
			sair();
		}
	}

	@Override
	public void menuLiberado(MenuLateral menuLateral) {
		
		String nome = menuLateral.getNome();
		
		if(nome.equals(FramePrincipal.HOME)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/home_item.png");
			
		} else if(nome.equals(FramePrincipal.ESTOQUE)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/estoque_item.png");
			
		} else if(nome.equals(FramePrincipal.SAIR)){
			
			FramePrincipal.alterarIcone(menuLateral.getLabel(), "/sair_item.png");			
		}		
	}
}
