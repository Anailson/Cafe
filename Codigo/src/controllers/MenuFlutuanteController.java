package controllers;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entidades.MenuFlutuante;
import interfaces.MenuFlutuanteListener;
import views.FrameCadastroCliente;
import views.FrameCadastroFornecedor;
import views.FrameCadastroProduto;
import views.FrameCadastroTransportadora;
import views.FrameListarCliente;
import views.FrameListarFornecedor;
import views.FrameListarProduto;
import views.FrameListarTransportadora;
import views.FrameListarVenda;
import views.FramePrincipal;
import views.FrameRealizarVendaVista;
import views.FrameRelatorioPagamento;
import views.FrameRelatorioRecebimento;

public class MenuFlutuanteController implements MenuFlutuanteListener {

	private static final String CADASTRO_CLIENTE = "Cadastro de cliente";
	private static final String CADASTRO_TRANSPORTADORA = "Cadastro de transportadora";
	private static final String CADASTRO_FORNECEDOR = "Cadastro de fornecedor";
	private static final String CADASTRO_PRODUTO = "Cadastro de produto";
	private static final String LISTAR_CLIENTE = "Lista dos clientes cadastrados";
	private static final String LISTAR_TRANSPORTADORA = "Lista das transportadoras cadastradas";
	private static final String LISTAR_FORNECEDOR = "Lista dos fornecedores cadastrados";
	private static final String LISTAR_PRODUTO = "Lista dos produtos cadastrados";
	private static final String LISTAR_VENDA = "Lista das vendas realizadas";
	private static final String RELATORIO_PAGAMENTO = "Relatório de pagamentos";
	private static final String RELATORIO_RECBIMENTO = "Relatório de recebimentos";
	private static final String VENDAS_A_VISTA = "Realizar venda à vista";
	
	private JFrame frame;

	public MenuFlutuanteController(JFrame frame) {

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
	
	private void cadastrarCliente(String titulo){
		JPanel panel = new FrameCadastroCliente(titulo);
		atualizarTela(panel, titulo);
	}
	
	private void cadastrarTransportadora(String titulo){
		JPanel panel = new FrameCadastroTransportadora(titulo);
		atualizarTela(panel, titulo);
	}
	
	private void cadastrarFornecedor(String titulo){
		JPanel panel = new FrameCadastroFornecedor(titulo);
		atualizarTela(panel, titulo);
	}
	
	private void cadastrarProduto(String titulo){
		JPanel panel = new FrameCadastroProduto(titulo);
		atualizarTela(panel, titulo);
	}
	
	private void listarCliente(String titulo){
		JPanel panel = new FrameListarCliente(titulo);
		atualizarTela(panel, titulo);
	}
	
	private void listarTransportadora(String titulo){
		JPanel panel = new FrameListarTransportadora(titulo);
		atualizarTela(panel, titulo);
	}
	
	private void listarFornecedor(String titulo){
		JPanel panel = new FrameListarFornecedor(titulo);
		atualizarTela(panel, titulo);
	}
	
	private void listarProduto(String titulo){

		JPanel panel = new FrameListarProduto(titulo);
		atualizarTela(panel, titulo);
	}
	
	private void listarVenda(String titulo){

		JPanel panel = new FrameListarVenda(titulo);
		atualizarTela(panel, titulo);
	}
	
	private void relatorioPagamento(String titulo){
		
		JPanel panel = new FrameRelatorioPagamento(titulo);
		atualizarTela(panel, titulo);
	}
	
	private void relatorioRecebimento(String titulo){
		
		JPanel panel = new FrameRelatorioRecebimento(titulo);
		atualizarTela(panel, titulo);
	}
	
	private void vendaAVista(String titulo){
		
		JPanel panel = new FrameRealizarVendaVista(titulo);
		atualizarTela(panel, titulo);
	}

	@Override
	public void menuSelecionado(MenuFlutuante menuFlutuante) {
		
		String nome = menuFlutuante.getNome();
		
		if(nome.equals(FramePrincipal.CAD_CLIENTE)
				|| nome.equals(FramePrincipal.LIS_CLIENTE)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/cliente_item.png");
			
		} else if(nome.equals(FramePrincipal.CAD_FORNECEDOR)
				|| nome.equals(FramePrincipal.LIS_FORNECEDOR)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/fornecedor_item.png");
			
		} else if(nome.equals(FramePrincipal.CAD_TRANSPORTADORA)
				|| nome.equals(FramePrincipal.LIS_TRANSPORTADORA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/transportadora_item.png");
			
		} else if(nome.equals(FramePrincipal.CAD_PRODUTO)
				|| nome.equals(FramePrincipal.LIS_PRODUTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/produto_item.png");			
			
		} else if(nome.equals(FramePrincipal.LIS_VENDAS)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/lis_vendas_item.png");
			
		} else if(nome.equals(FramePrincipal.PAGAMENTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/pagamento_item.png");
			
		} else if(nome.equals(FramePrincipal.RECEBIMENTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/recebimento_item.png");
			
		} else if(nome.equals(FramePrincipal.BALANCO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/balanco_item.png");
			
		} else if(nome.equals(FramePrincipal.REALIZAR_VENDA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/realizar_venda_item.png");			
			
		} else if(nome.equals(FramePrincipal.LISTAR_VENDAS_A_VISTA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/listar_a_vista_item.png");
			
		} else if(nome.equals(FramePrincipal.LISTAR_VENDAS_DUPLICATA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/listar_duplicata_item.png");	
		}
	}

	@Override
	public void menuDescelecionado(MenuFlutuante menuFlutuante) {
		
		String nome = menuFlutuante.getNome();
		
		if(nome.equals(FramePrincipal.CAD_CLIENTE)
				|| nome.equals(FramePrincipal.LIS_CLIENTE)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/cliente.png");
			
		} else if(nome.equals(FramePrincipal.CAD_FORNECEDOR)
				|| nome.equals(FramePrincipal.LIS_FORNECEDOR)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/fornecedor.png");
			
		} else if(nome.equals(FramePrincipal.CAD_TRANSPORTADORA)
				|| nome.equals(FramePrincipal.LIS_TRANSPORTADORA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/transportadora.png");
			
		} else if(nome.equals(FramePrincipal.CAD_PRODUTO)
				|| nome.equals(FramePrincipal.LIS_PRODUTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/produto.png");			
			
		} else if(nome.equals(FramePrincipal.LIS_VENDAS)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/lis_vendas.png");
			
		} else if(nome.equals(FramePrincipal.PAGAMENTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/pagamento.png");
			
		} else if(nome.equals(FramePrincipal.RECEBIMENTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/recebimento.png");
			
		} else if(nome.equals(FramePrincipal.BALANCO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/balanco.png");
			
		} else if(nome.equals(FramePrincipal.REALIZAR_VENDA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/realizar_venda.png");			
			
		} else if(nome.equals(FramePrincipal.LISTAR_VENDAS_A_VISTA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/listar_a_vista.png");
			
		} else if(nome.equals(FramePrincipal.LISTAR_VENDAS_DUPLICATA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/listar_duplicata.png");	
		}
	}

	@Override
	public void menuPressionado(MenuFlutuante menuFlutuante) {
		
		String nome = menuFlutuante.getNome();
		
		if(nome.equals(FramePrincipal.CAD_CLIENTE)
				|| nome.equals(FramePrincipal.LIS_CLIENTE)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/cliente_press.png");
			
		} else if(nome.equals(FramePrincipal.CAD_FORNECEDOR)
				|| nome.equals(FramePrincipal.LIS_FORNECEDOR)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/fornecedor_press.png");
			
		} else if(nome.equals(FramePrincipal.CAD_TRANSPORTADORA)
				|| nome.equals(FramePrincipal.LIS_TRANSPORTADORA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/transportadora_press.png");
			
		} else if(nome.equals(FramePrincipal.CAD_PRODUTO) 
				|| nome.equals(FramePrincipal.LIS_PRODUTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/produto_press.png");
			
		} else if(nome.equals(FramePrincipal.LIS_VENDAS)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/lis_vendas_press.png");	
			
		} else if(nome.equals(FramePrincipal.PAGAMENTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/pagamento_press.png");
			
		} else if(nome.equals(FramePrincipal.RECEBIMENTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/recebimento_press.png");
			
		} else if(nome.equals(FramePrincipal.BALANCO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/balanco_press.png");
			
		} else if(nome.equals(FramePrincipal.REALIZAR_VENDA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/realizar_venda_press.png");			
			
		} else if(nome.equals(FramePrincipal.LISTAR_VENDAS_A_VISTA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/listar_a_vista_press.png");
			
		} else if(nome.equals(FramePrincipal.LISTAR_VENDAS_DUPLICATA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/listar_duplicata_press.png");
		}
	}

	@Override
	public void menuLiberado(MenuFlutuante menuFlutuante) {

		String nome = menuFlutuante.getNome();
		
		if(nome.equals(FramePrincipal.CAD_CLIENTE)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/cliente.png");
			cadastrarCliente(CADASTRO_CLIENTE);
			
		} else if(nome.equals(FramePrincipal.CAD_FORNECEDOR)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/fornecedor.png");
			cadastrarFornecedor(CADASTRO_FORNECEDOR);
			
		} else if(nome.equals(FramePrincipal.CAD_TRANSPORTADORA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/transportadora.png");
			cadastrarTransportadora(CADASTRO_TRANSPORTADORA);
			
		} else if(nome.equals(FramePrincipal.CAD_PRODUTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/produto.png");			
			cadastrarProduto(CADASTRO_PRODUTO);			
			
		} else if(nome.equals(FramePrincipal.LIS_CLIENTE)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/cliente.png");
			listarCliente(LISTAR_CLIENTE);
			
		} else if(nome.equals(FramePrincipal.LIS_FORNECEDOR)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/fornecedor.png");
			listarFornecedor(LISTAR_FORNECEDOR);
			
		} else if(nome.equals(FramePrincipal.LIS_TRANSPORTADORA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/transportadora.png");
			listarTransportadora(LISTAR_TRANSPORTADORA);
			
		} else if(nome.equals(FramePrincipal.LIS_PRODUTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/produto.png");
			listarProduto(LISTAR_PRODUTO);			
			
		} else if(nome.equals(FramePrincipal.LIS_VENDAS)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/lis_vendas.png");
			listarVenda(LISTAR_VENDA);		
			
		} else if(nome.equals(FramePrincipal.PAGAMENTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/pagamento.png");
			relatorioPagamento(RELATORIO_PAGAMENTO);
			
		} else if(nome.equals(FramePrincipal.RECEBIMENTO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/recebimento.png");
			relatorioRecebimento(RELATORIO_RECBIMENTO);
			
		} else if(nome.equals(FramePrincipal.BALANCO)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/balanco.png");
			
		} else if(nome.equals(FramePrincipal.REALIZAR_VENDA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/realizar_venda.png");			
			
		} else if(nome.equals(FramePrincipal.LISTAR_VENDAS_A_VISTA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/listar_a_vista.png");
			vendaAVista(VENDAS_A_VISTA);
			
		} else if(nome.equals(FramePrincipal.LISTAR_VENDAS_DUPLICATA)){
			
			FramePrincipal.alterarIcone(menuFlutuante.getLabel(), "/listar_duplicata.png");
			
		}
	}	
}
